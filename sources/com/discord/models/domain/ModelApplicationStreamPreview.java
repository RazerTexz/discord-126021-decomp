package com.discord.models.domain;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelApplicationStreamPreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelApplicationStreamPreview {
    private final String url;

    public ModelApplicationStreamPreview(String str) {
        C12238m.checkNotNullParameter(str, "url");
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
        C12238m.checkNotNullParameter(url, "url");
        return new ModelApplicationStreamPreview(url);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelApplicationStreamPreview) && C12238m.areEqual(this.url, ((ModelApplicationStreamPreview) other).url);
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
        return C1643a.m822J(C1643a.m833U("ModelApplicationStreamPreview(url="), this.url, ")");
    }
}
