package alveDoorsDesigner.cuttingList;

import alveDoorsDesigner.model.Wardrobe;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;

public class DownloadButton extends Button {
    private final Wardrobe wardrobe;
    private FileDownloader fileDownloader;

    public DownloadButton(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
        setCaption(Constants.DOWNLOAD_PRODUCTION_LIST);
    }

    public void updatePDFToDownload() {
        if(fileDownloader != null)
            fileDownloader.remove();

        fileDownloader = new FileDownloader(
                new FileResource(new PDFFileWithCuttingListCreator().create(wardrobe)));
        fileDownloader.extend(this);
    }
}
