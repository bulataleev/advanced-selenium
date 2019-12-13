package com.herokuapp.theinternet;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test
    public void imageUploadTest() {
        log.info("Starting imageUploadTest");

        // open File Uploader Page
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();

        // Select file
        String fileName = "logo.png";
        fileUploaderPage.selectFile(fileName);

        // Push upload button
        fileUploaderPage.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPage.getUploadedFilesNames();

        // Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
