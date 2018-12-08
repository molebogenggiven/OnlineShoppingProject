package com.michaelcgood.JsonTest;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.util.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExtractTextFromPdf {

    public static void main(String[] args) {

    }

    void getTestMethod() throws IOException{

        File file = new File("");
        FileInputStream fileInputStream = new FileInputStream(file);

        //PDFParser pdfParser = new PDFParser(fileInputStream);

        //pdfParser.parse();

//        COSDocument cosDocument = pdfParser.getDocument();
//        PDDocument pdDocument = new PDDocument(cosDocument);
//        PDFTextStripper pdfTextStripper = new PDFTextStripper();
//        String data = pdfTextStripper.getText(pdDocument);
//        System.out.println(data);
//        Assert.assertTrue(data.contains("Hello"));


    }
}
