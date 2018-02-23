package com.jm.ui.componentsList.action;

import com.jm.model.Wardrobe;
import com.jm.ui.Constants;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Button;

public class OpenPdfAction {

    BrowserWindowOpener opener = null;

    public void assignActionToButton(Button print, Wardrobe wardrobe) {

        StreamResource resource =
                new StreamResource(new PDFStream(wardrobe), createFileName(wardrobe.getReferenceName()));

        if(opener == null){
            opener = new BrowserWindowOpener(resource);
        } else{
          opener.remove();
          opener = new BrowserWindowOpener(resource);
        }

        opener.extend(print);
    }

    private String createFileName(String referenceName) {
        return String.format("%s%s",referenceName, Constants.PDF_EXTENSION);
    }
}
