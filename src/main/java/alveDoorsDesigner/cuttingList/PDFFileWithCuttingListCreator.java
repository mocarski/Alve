package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.model.Wardrobe;
import alveDoorsDesigner.cuttingList.table.TableItemProvider;
import alveDoorsDesigner.cuttingList.table.model.TableItem;
import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Row;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFFileWithCuttingListCreator{

    public File create(Wardrobe wardrobe){
        try {
            PDPage page = new PDPage(PDRectangle.A4);
            PDDocument document = new PDDocument();

            BaseTable table = createTable(page, document);
            addTableTitle(table, wardrobe.getReferenceName());
            addRowWithColumnDescription(table);
            addRowsWithIntermediates(table, wardrobe);
            table.draw();

            File file = new File(createFileName(wardrobe.getReferenceName()));
            document.save(file);
            document.close();

            return file;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }

    private static String createFileName(String referenceName) {
        return String.format("%s%s", referenceName, alveDoorsDesigner.cuttingList.Constants.PDF_EXTENSION);
    }

    private void addTableTitle(BaseTable table, String referenceName) throws IOException {
        table.drawTitle(prepareTableTitle(referenceName),
                PDType1Font.HELVETICA_BOLD, 15, table.getWidth(), 30, "center", 0f, true);
    }

    private void addRowWithColumnDescription(BaseTable table) {
        addRow(table, alveDoorsDesigner.cuttingList.table.Constants.NAME, alveDoorsDesigner.cuttingList.table
                .Constants.DIMENTION, alveDoorsDesigner.cuttingList.table.Constants.QUANTITY);
    }

    private void addRowsWithIntermediates(BaseTable table, Wardrobe wardrobe) {
        List<TableItem> tableItems = new TableItemProvider(wardrobe).createWardrobeIntermediates();
        for (TableItem tableItem : tableItems) {
            addRow(table, tableItem.getName(), tableItem.getDimention(), String.valueOf(tableItem
                    .getQuantity()));
        }
    }

    private void addRow(BaseTable table, String name, String dimention, String quantity) {
        Row<PDPage> titleRow = table.createRow(12);
        titleRow.createCell(45f, name);
        titleRow.createCell(30f, dimention);
        titleRow.createCell(25f, quantity);
    }

    private static String prepareTableTitle(String referenceName) {
        return String.format("%s %s%s", "Cutting list (ref.", referenceName, ")");
    }

    private BaseTable createTable(PDPage myPage, PDDocument mainDocument) throws IOException {
        int tableMargin = 50;
        float startOfPageContentCountedFromTheBottom = myPage.getMediaBox().getHeight() - tableMargin;
        float widthOfTable = myPage.getMediaBox().getWidth() - (2 * tableMargin);

        return new BaseTable(0, startOfPageContentCountedFromTheBottom, 0,
                widthOfTable, tableMargin, mainDocument, myPage, true, true);
    }
}
