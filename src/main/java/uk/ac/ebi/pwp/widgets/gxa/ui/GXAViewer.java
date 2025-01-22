package uk.ac.ebi.pwp.widgets.gxa.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import java.util.Collections;
import java.util.List;

/**
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
@SuppressWarnings("UnusedDeclaration")
public class GXAViewer extends Composite {
    private ScrollPanel container;
    private AtlasHeatmapModule gxa;
    private String uniprotID;
    private String reactomeID;

    public GXAViewer() {
        this.container = new ScrollPanel();
        //noinspection GWTStyleCheck
        this.container.addStyleName("gxa-GXAViewer");
        this.container.getElement().setId(Document.get().createUniqueId());
        this.container.add(new HTMLPanel("Loading..."));
        initWidget(this.container);
    }

    private String getQueryString(List<String> ids) {
        StringBuilder sb = new StringBuilder("[");
        for (String uniProtID : ids) {
            sb.append("{value:\"");
            sb.append(uniProtID);
            sb.append("\"},");
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void load() {
        if (this.gxa == null && this.container.isAttached()) {
            this.container.clear();
            String placeHolder = this.container.getElement().getId();
            if (this.uniprotID != null) {
                this.gxa = AtlasHeatmapModule.build(placeHolder, uniprotID);
            } else if (this.reactomeID != null) {
                this.gxa = AtlasHeatmapModule.build(placeHolder, URL.encode(reactomeID));
            } else {
                this.setEmpty();
            }
        }
    }

    public void setEmpty() {
        this.container.clear();
        this.container.add(new HTMLPanel("No expression data available."));
    }

    public void setUniProtID(String uniProtID) {
        this.uniprotID = this.getQueryString(Collections.singletonList(uniProtID));
        this.load();
    }

    public void setUniProtIDs(List<String> uniProtIDs) {
        this.uniprotID = this.getQueryString(uniProtIDs);
        this.load();
    }

    public void setReactomeID(String reactomeID) {
        this.reactomeID = reactomeID;
        this.load();
    }

    @Override
    protected void onLoad() {
        this.load();
    }
}
