package com.alfimenkov.task2;

import com.alfimenkov.task2.editor.TextEditor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextEditorTest {

    @Test
    void testReadAndParseTextFromFile() throws Exception {

        //GIVEN
        String expected = "\tThis text is for testing. Hello, Java! This was written in 2021. " + "\n";
        TextEditor editor = new TextEditor("test.txt");

        //WHEN
        System.out.println("Expecting text : \n" + expected);

        String result = editor.getText();
        System.out.println("Resulting text : \n" + result);

        //THEN
        Assertions.assertEquals(expected,result);


    }

    @Test
    void testDeleteWordsByLength() throws Exception {

        //GIVEN
        String textBeforeDelete = "\tThis text is for testing. Hello, Java! This was written in 2021. " + "\n";
        String textAfterDelete = "\tis for testing. Hello,! was written in 2021. " + "\n";
        TextEditor editor = new TextEditor("test.txt");

        //WHEN
        System.out.println("Text before deleting words: \n" + textBeforeDelete);
        System.out.println("Expected text after deleting words with length 4: \n" + textAfterDelete);
        editor.deleteWordsByLength(4);
        String result = editor.getText();
        System.out.println("Resulting text after deleting words with length 4: \n" + result);

        //THEN
        Assertions.assertEquals(textAfterDelete, result);

    }

}
