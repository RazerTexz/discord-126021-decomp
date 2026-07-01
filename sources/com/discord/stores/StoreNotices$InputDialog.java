package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StoreNotices.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreNotices$InputDialog {
    private final StoreNotices$InputDialog$Type type;

    public StoreNotices$InputDialog(StoreNotices$InputDialog$Type storeNotices$InputDialog$Type) {
        m.checkNotNullParameter(storeNotices$InputDialog$Type, "type");
        this.type = storeNotices$InputDialog$Type;
    }

    public static /* synthetic */ StoreNotices$InputDialog copy$default(StoreNotices$InputDialog storeNotices$InputDialog, StoreNotices$InputDialog$Type storeNotices$InputDialog$Type, int i, Object obj) {
        if ((i & 1) != 0) {
            storeNotices$InputDialog$Type = storeNotices$InputDialog.type;
        }
        return storeNotices$InputDialog.copy(storeNotices$InputDialog$Type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreNotices$InputDialog$Type getType() {
        return this.type;
    }

    public final StoreNotices$InputDialog copy(StoreNotices$InputDialog$Type type) {
        m.checkNotNullParameter(type, "type");
        return new StoreNotices$InputDialog(type);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StoreNotices$InputDialog) && m.areEqual(this.type, ((StoreNotices$InputDialog) other).type);
        }
        return true;
    }

    public final StoreNotices$InputDialog$Type getType() {
        return this.type;
    }

    public int hashCode() {
        StoreNotices$InputDialog$Type storeNotices$InputDialog$Type = this.type;
        if (storeNotices$InputDialog$Type != null) {
            return storeNotices$InputDialog$Type.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("InputDialog(type=");
        sbU.append(this.type);
        sbU.append(")");
        return sbU.toString();
    }
}
