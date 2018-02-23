package com.jm.ui.componentsList.action;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;

public class DownloadPdfAction {

    FileDownloader fileDownloader = null;

    public void assignActionToButton(Button download, Wardrobe wardrobe) {

        StreamResource resource =
                new StreamResource(new PDFStream(wardrobe), createFileName(wardrobe.getReferenceName()));

        if (fileDownloader == null) {
            fileDownloader = new FileDownloader(resource);
        } else {
            fileDownloader.remove();
            fileDownloader = new FileDownloader(resource);
        }
        fileDownloader.extend(download);
    }

    private String createFileName(String referenceName) {
        return String.format("%s%s", referenceName, Constants.PDF_EXTENSION);
    }
}
