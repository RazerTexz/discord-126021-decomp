package com.discord.models.domain;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class ModelUrl {
    private final String url;

    public ModelUrl(String str) {
        this.url = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ModelUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ModelUrl)) {
            return false;
        }
        ModelUrl modelUrl = (ModelUrl) obj;
        if (!modelUrl.canEqual(this)) {
            return false;
        }
        String url = getUrl();
        String url2 = modelUrl.getUrl();
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
        StringBuilder sbU = a.U("ModelUrl(url=");
        sbU.append(getUrl());
        sbU.append(")");
        return sbU.toString();
    }
}
