package com.discord.models.domain;

import b.d.b.a.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ModelGateway implements Model {
    private String url;

    @Override // com.discord.models.domain.Model
    public void assignField(Model$JsonReader model$JsonReader) throws IOException {
        String strNextName = model$JsonReader.nextName();
        strNextName.hashCode();
        if (strNextName.equals("url")) {
            this.url = model$JsonReader.nextString(this.url);
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelGateway;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelGateway)) {
            return false;
        }
        ModelGateway modelGateway = (ModelGateway) obj;
        if (!modelGateway.canEqual(this)) {
            return false;
        }
        String url = getUrl();
        String url2 = modelGateway.getUrl();
        return url != null ? url.equals(url2) : url2 == null;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String url = getUrl();
        return 59 + (url == null ? 43 : url.hashCode());
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGateway(url=");
        sbU.append(getUrl());
        sbU.append(")");
        return sbU.toString();
    }
}
