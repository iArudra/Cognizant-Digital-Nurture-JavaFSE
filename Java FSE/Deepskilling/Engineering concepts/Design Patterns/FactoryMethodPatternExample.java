public interface Document {
    void open();
    void close();
}
public class wordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word document.");
    }
    @Override
    public void close() {
        System.out.println("Closing Word document.");
    }
}
public class pdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document.");
    }
    @Override
    public void close() {
        System.out.println("Closing PDF document.");
    }
}
public class excelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Excel document.");
    }
    @Override
    public void close() {
        System.out.println("Closing Excel document.");
    }
}
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new wordDocument();
    }
}
public class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new pdfDocument();
    }
}
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new excelDocument();
    }
}
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.close();
    }
}