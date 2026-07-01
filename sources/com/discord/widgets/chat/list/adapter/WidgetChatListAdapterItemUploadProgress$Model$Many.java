package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemUploadProgress$Model$Many extends WidgetChatListAdapterItemUploadProgress$Model {
    private final int numFiles;
    private final int progress;
    private final long sizeBytes;

    public WidgetChatListAdapterItemUploadProgress$Model$Many(int i, long j, int i2) {
        super(null);
        this.numFiles = i;
        this.sizeBytes = j;
        this.progress = i2;
    }

    public static /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Many copy$default(WidgetChatListAdapterItemUploadProgress$Model$Many widgetChatListAdapterItemUploadProgress$Model$Many, int i, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = widgetChatListAdapterItemUploadProgress$Model$Many.numFiles;
        }
        if ((i3 & 2) != 0) {
            j = widgetChatListAdapterItemUploadProgress$Model$Many.sizeBytes;
        }
        if ((i3 & 4) != 0) {
            i2 = widgetChatListAdapterItemUploadProgress$Model$Many.progress;
        }
        return widgetChatListAdapterItemUploadProgress$Model$Many.copy(i, j, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumFiles() {
        return this.numFiles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    public final WidgetChatListAdapterItemUploadProgress$Model$Many copy(int numFiles, long sizeBytes, int progress) {
        return new WidgetChatListAdapterItemUploadProgress$Model$Many(numFiles, sizeBytes, progress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemUploadProgress$Model$Many)) {
            return false;
        }
        WidgetChatListAdapterItemUploadProgress$Model$Many widgetChatListAdapterItemUploadProgress$Model$Many = (WidgetChatListAdapterItemUploadProgress$Model$Many) other;
        return this.numFiles == widgetChatListAdapterItemUploadProgress$Model$Many.numFiles && this.sizeBytes == widgetChatListAdapterItemUploadProgress$Model$Many.sizeBytes && this.progress == widgetChatListAdapterItemUploadProgress$Model$Many.progress;
    }

    public final int getNumFiles() {
        return this.numFiles;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public int hashCode() {
        return ((b.a(this.sizeBytes) + (this.numFiles * 31)) * 31) + this.progress;
    }

    public String toString() {
        StringBuilder sbU = a.U("Many(numFiles=");
        sbU.append(this.numFiles);
        sbU.append(", sizeBytes=");
        sbU.append(this.sizeBytes);
        sbU.append(", progress=");
        return a.B(sbU, this.progress, ")");
    }
}
