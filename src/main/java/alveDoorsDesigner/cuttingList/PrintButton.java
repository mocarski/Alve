package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.server.BrowserWindowOpener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;

public class PrintButton extends Button {
    private final Wardrobe wardrobe;
    private BrowserWindowOpener browserWindowOpener;

    public PrintButton(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
        setCaption(Constants.PRINT_PRODUCTION_LIST);
    }

    public void updatePDFToPrint() {
        if (browserWindowOpener != null)
            browserWindowOpener.remove();

        browserWindowOpener = new BrowserWindowOpener(
                new FileResource(new PDFFileWithCuttingListCreator().create(wardrobe)));
        browserWindowOpener.extend(this);
    }
}
