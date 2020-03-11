import org.testng.annotations.Test;

import java.io.IOException;

public class StartingDocker {

    @Test
    public void execFile() throws IOException {
        Runtime run = Runtime.getRuntime();
        run.exec("sh StartDockerCMD");
    }
}
