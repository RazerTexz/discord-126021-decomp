package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemUploadProgress$Model$Single extends WidgetChatListAdapterItemUploadProgress$Model {
    private final String mimeType;
    private final String name;
    private final int progress;
    private final long sizeBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress$Model$Single(String str, String str2, long j, int i) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(str2, "mimeType");
        this.name = str;
        this.mimeType = str2;
        this.sizeBytes = j;
        this.progress = i;
    }

    public static /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Single copy$default(WidgetChatListAdapterItemUploadProgress$Model$Single widgetChatListAdapterItemUploadProgress$Model$Single, String str, String str2, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = widgetChatListAdapterItemUploadProgress$Model$Single.name;
        }
        if ((i2 & 2) != 0) {
            str2 = widgetChatListAdapterItemUploadProgress$Model$Single.mimeType;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            j = widgetChatListAdapterItemUploadProgress$Model$Single.sizeBytes;
        }
        long j2 = j;
        if ((i2 & 8) != 0) {
            i = widgetChatListAdapterItemUploadProgress$Model$Single.progress;
        }
        return widgetChatListAdapterItemUploadProgress$Model$Single.copy(str, str3, j2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    public final WidgetChatListAdapterItemUploadProgress$Model$Single copy(String name, String mimeType, long sizeBytes, int progress) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(mimeType, "mimeType");
        return new WidgetChatListAdapterItemUploadProgress$Model$Single(name, mimeType, sizeBytes, progress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemUploadProgress$Model$Single)) {
            return false;
        }
        WidgetChatListAdapterItemUploadProgress$Model$Single widgetChatListAdapterItemUploadProgress$Model$Single = (WidgetChatListAdapterItemUploadProgress$Model$Single) other;
        return m.areEqual(this.name, widgetChatListAdapterItemUploadProgress$Model$Single.name) && m.areEqual(this.mimeType, widgetChatListAdapterItemUploadProgress$Model$Single.mimeType) && this.sizeBytes == widgetChatListAdapterItemUploadProgress$Model$Single.sizeBytes && this.progress == widgetChatListAdapterItemUploadProgress$Model$Single.progress;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final int getProgress() {
        return this.progress;
    }

    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.mimeType;
        return ((b.a(this.sizeBytes) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.progress;
    }

    public String toString() {
        StringBuilder sbU = a.U("Single(name=");
        sbU.append(this.name);
        sbU.append(", mimeType=");
        sbU.append(this.mimeType);
        sbU.append(", sizeBytes=");
        sbU.append(this.sizeBytes);
        sbU.append(", progress=");
        return a.B(sbU, this.progress, ")");
    }
}
