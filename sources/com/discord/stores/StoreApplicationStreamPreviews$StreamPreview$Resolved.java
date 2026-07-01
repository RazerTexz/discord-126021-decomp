package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreApplicationStreamPreviews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreApplicationStreamPreviews$StreamPreview$Resolved extends StoreApplicationStreamPreviews$StreamPreview {
    private final String url;

    public StoreApplicationStreamPreviews$StreamPreview$Resolved(String str) {
        super(null);
        this.url = str;
    }

    public static /* synthetic */ StoreApplicationStreamPreviews$StreamPreview$Resolved copy$default(StoreApplicationStreamPreviews$StreamPreview$Resolved storeApplicationStreamPreviews$StreamPreview$Resolved, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = storeApplicationStreamPreviews$StreamPreview$Resolved.url;
        }
        return storeApplicationStreamPreviews$StreamPreview$Resolved.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final StoreApplicationStreamPreviews$StreamPreview$Resolved copy(String url) {
        return new StoreApplicationStreamPreviews$StreamPreview$Resolved(url);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreApplicationStreamPreviews$StreamPreview$Resolved) && m.areEqual(this.url, ((StoreApplicationStreamPreviews$StreamPreview$Resolved) other).url);
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
        return a.J(a.U("Resolved(url="), this.url, ")");
    }
}
