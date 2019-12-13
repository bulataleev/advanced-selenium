package com.herokuapp.theinternet;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DragAndDropTests extends TestUtilities {

    @Test
    public void dragAToBTest() {
        log.info("Starting dragAToBTest");

        // Open DragAndDropPage
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
        dragAndDropPage.openPage();

        // Drag box A and drop it on box B
        dragAndDropPage.dragAtoB();

        // Verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
    }
}
