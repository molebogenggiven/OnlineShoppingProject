package com.michaelcgood.JsonTest;

import com.itextpdf.kernel.utils.CompareTool;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import de.redsix.pdfcompare.PdfComparator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.util.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripper;
//import de.redsix.pdfcomapre.*;

import java.io.File;
import java.io.IOException;

//import static za.co.absa.automation.common.testbase.BaseClass.objectMap;

public class ReadPdf {

    public static void main(String[] args) {

        ReadPdf readPdf = new ReadPdf();
        //readPdf.readContent();
        readPdf.comparePdf();


    }

    void comparePDF(){

        ////CompareResult compareResult = new PdfComparator()


    }

    void comparePdf(){

        try {
            boolean isEquals = new PdfComparator("/home/given/Downloads/090226f1807a928c.pdf",
                    "/home/given/Downloads/FI_Welcome_Letter.pdf").
                    compare().writeTo("/home/given/Downloads/ShowDifferentLetters.pdf");

            if(!isEquals){
                System.out.println("Difference found");
            }else{
                System.out.println("Difference is not found");
            }
        }catch (Exception e){

            System.out.println("Something wrong occured while comparing");

        }
    }



     void readContent(){


         try {
             PDDocument document = PDDocument.load(new File("/home/given/Downloads/problem-gambling-strategic-plan.pdf"));
             if (!document.isEncrypted()) {

//                 PDFTextStripper stripper = new PDFTextStripper();
//                 System.out.println(document.getPage(5));
//                 int numberOfPages = document.getNumberOfPages();
//                 PDPage pdPage = document.getPage(4);
//                 //System.out.println(pdPage.hasContents());;
//                 //System.out.println(document.getPage(1));
//                 //System.out.println(numberOfPages);
//                 //String text = stripper.getText(document);
//                 //System.out.println("Text:" + text);

             }
             document.close();


         }catch (IOException e){
             System.out.println("Failed to load the file");
         }
            }


}