package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelApplicationStreamPreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStreamPreview {
    private final String url;

    public ModelApplicationStreamPreview(String str) {
        m.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public static /* synthetic */ ModelApplicationStreamPreview copy$default(ModelApplicationStreamPreview modelApplicationStreamPreview, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStreamPreview.url;
        }
        return modelApplicationStreamPreview.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ModelApplicationStreamPreview copy(String url) {
        m.checkNotNullParameter(url, "url");
        return new ModelApplicationStreamPreview(url);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelApplicationStreamPreview) && m.areEqual(this.url, ((ModelApplicationStreamPreview) other).url);
        }
        return true;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("ModelApplicationStreamPreview(url="), this.url, ")");
    }
}
