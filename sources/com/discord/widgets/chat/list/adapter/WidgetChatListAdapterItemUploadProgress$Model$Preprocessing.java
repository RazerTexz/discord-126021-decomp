package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemUploadProgress$Model$Preprocessing extends WidgetChatListAdapterItemUploadProgress$Model {
    private final String displayName;
    private final String mimeType;
    private final int numFiles;

    public WidgetChatListAdapterItemUploadProgress$Model$Preprocessing(int i, String str, String str2) {
        super(null);
        this.numFiles = i;
        this.displayName = str;
        this.mimeType = str2;
    }

    public static /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Preprocessing copy$default(WidgetChatListAdapterItemUploadProgress$Model$Preprocessing widgetChatListAdapterItemUploadProgress$Model$Preprocessing, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetChatListAdapterItemUploadProgress$Model$Preprocessing.numFiles;
        }
        if ((i2 & 2) != 0) {
            str = widgetChatListAdapterItemUploadProgress$Model$Preprocessing.displayName;
        }
        if ((i2 & 4) != 0) {
            str2 = widgetChatListAdapterItemUploadProgress$Model$Preprocessing.mimeType;
        }
        return widgetChatListAdapterItemUploadProgress$Model$Preprocessing.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumFiles() {
        return this.numFiles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final WidgetChatListAdapterItemUploadProgress$Model$Preprocessing copy(int numFiles, String displayName, String mimeType) {
        return new WidgetChatListAdapterItemUploadProgress$Model$Preprocessing(numFiles, displayName, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemUploadProgress$Model$Preprocessing)) {
            return false;
        }
        WidgetChatListAdapterItemUploadProgress$Model$Preprocessing widgetChatListAdapterItemUploadProgress$Model$Preprocessing = (WidgetChatListAdapterItemUploadProgress$Model$Preprocessing) other;
        return this.numFiles == widgetChatListAdapterItemUploadProgress$Model$Preprocessing.numFiles && m.areEqual(this.displayName, widgetChatListAdapterItemUploadProgress$Model$Preprocessing.displayName) && m.areEqual(this.mimeType, widgetChatListAdapterItemUploadProgress$Model$Preprocessing.mimeType);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getNumFiles() {
        return this.numFiles;
    }

    public int hashCode() {
        int i = this.numFiles * 31;
        String str = this.displayName;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Preprocessing(numFiles=");
        sbU.append(this.numFiles);
        sbU.append(", displayName=");
        sbU.append(this.displayName);
        sbU.append(", mimeType=");
        return a.J(sbU, this.mimeType, ")");
    }
}
