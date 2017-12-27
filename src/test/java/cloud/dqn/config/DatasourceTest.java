package cloud.dqn.config;

import cloud.dqn.models.DataResponse;
import cloud.dqn.models.ExceptionResponse;
import com.zaxxer.hikari.HikariConfig;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class DatasourceTest {
    /**
     * Requires db instance to be up and running at below configs
     */
    @Ignore("Enable if running db")
    @Test
    public void testConnectionTest() {
        DataResponse<HikariConfig> configResponse = Datasource.configFactory(
                "testPool",
                "org.postgresql.ds.PGSimpleDataSource",
                "127.0.0.1",
                "5432",
                "blogapp",
                "root",
                "password"
        );
        Assert.assertTrue(configResponse.success());
        Assert.assertNotNull(configResponse.data);
        Datasource ds = new Datasource(configResponse.data);
        ExceptionResponse resp = ds.testConnection();
        Assert.assertTrue(configResponse.success());
    }
}
