package com.jm.ui.componentsList.action;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Row;
import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.jm.ui.componentsList.ComponentsListProvider;
import com.jm.ui.componentsList.model.ListItem;
import com.vaadin.server.StreamResource;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PDFStream implements StreamResource.StreamSource {

    private final Wardrobe wardrobe;

    public PDFStream(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    @Override
    public InputStream getStream() {

        try {
            PDPage myPage = new PDPage(PDRectangle.A4);
            PDDocument mainDocument = new PDDocument();
            PDPageContentStream contentStream = new PDPageContentStream(mainDocument, myPage);

            BaseTable table = createTable(myPage, mainDocument);
            table.drawTitle(String.format("List of factory (ref. %s)", wardrobe.getReferenceName()),
                    PDType1Font.HELVETICA_BOLD, 15, table.getWidth(), 30, "center", 0f, true);

            addRowsWithComponents(table);

            table.draw();
            contentStream.close();

            return createInputStreamWithPDF(mainDocument);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void addRowsWithComponents(BaseTable table) {

        List<ListItem> listItems = new ComponentsListProvider().prepareListOfComponents( wardrobe );

        Row<PDPage> titleRow = table.createRow(12);
        titleRow.createCell(45f, Constants.NAME);
        titleRow.createCell(30f, Constants.DIMENTION);
        titleRow.createCell(25f, String.valueOf(Constants.QUANTITY));

        for(ListItem listItem : listItems){
            Row<PDPage> itemRow = table.createRow(12);
            itemRow.createCell(45f, listItem.getName());
            itemRow.createCell(30f, listItem.getDimention());
            itemRow.createCell(25f, String.valueOf(listItem.getQuantity()));
        }
    }

    private ByteArrayInputStream createInputStreamWithPDF(PDDocument mainDocument) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        mainDocument.save(out);
        mainDocument.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

    private BaseTable createTable(PDPage myPage, PDDocument mainDocument) throws IOException {

        int tableMargin = 50;
        int leftMargin = tableMargin;
        float startOfPageContentCountedFromTheBottom = myPage.getMediaBox().getHeight() - tableMargin;
        float widthOfTable = myPage.getMediaBox().getWidth() - (2 * tableMargin);

        return new BaseTable(0, startOfPageContentCountedFromTheBottom, 0,
                widthOfTable, leftMargin, mainDocument, myPage, true, true);
    }
}
