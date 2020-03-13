import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StartingDocker {

    @Test
    public void execFile() throws IOException, InterruptedException {
        boolean flag = false;
        Runtime.getRuntime().exec("chmod 777 /Users/home/IdeaProjects/tutorials/advanced-selenium/StartDockerCMD");
        Runtime.getRuntime().exec("sh StartDockerCMD");
        Thread.sleep(10000);

        BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
        while(reader.readLine()!=null){
            if(reader.readLine().contains("Registering the node to the hub")){
                flag=true;
                break;
            }
        }
        reader.close();
        Assert.assertTrue(flag);
    }
}
