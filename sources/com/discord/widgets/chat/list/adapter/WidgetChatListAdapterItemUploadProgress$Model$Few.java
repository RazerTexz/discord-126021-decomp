package com.discord.widgets.chat.list.adapter;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemUploadProgress$Model$Few extends WidgetChatListAdapterItemUploadProgress$Model {
    private final List<WidgetChatListAdapterItemUploadProgress$Model$Single> uploads;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress$Model$Few(List<WidgetChatListAdapterItemUploadProgress$Model$Single> list) {
        super(null);
        m.checkNotNullParameter(list, "uploads");
        this.uploads = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatListAdapterItemUploadProgress$Model$Few copy$default(WidgetChatListAdapterItemUploadProgress$Model$Few widgetChatListAdapterItemUploadProgress$Model$Few, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChatListAdapterItemUploadProgress$Model$Few.uploads;
        }
        return widgetChatListAdapterItemUploadProgress$Model$Few.copy(list);
    }

    public final List<WidgetChatListAdapterItemUploadProgress$Model$Single> component1() {
        return this.uploads;
    }

    public final WidgetChatListAdapterItemUploadProgress$Model$Few copy(List<WidgetChatListAdapterItemUploadProgress$Model$Single> uploads) {
        m.checkNotNullParameter(uploads, "uploads");
        return new WidgetChatListAdapterItemUploadProgress$Model$Few(uploads);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetChatListAdapterItemUploadProgress$Model$Few) && m.areEqual(this.uploads, ((WidgetChatListAdapterItemUploadProgress$Model$Few) other).uploads);
        }
        return true;
    }

    public final List<WidgetChatListAdapterItemUploadProgress$Model$Single> getUploads() {
        return this.uploads;
    }

    public int hashCode() {
        List<WidgetChatListAdapterItemUploadProgress$Model$Single> list = this.uploads;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Few(uploads="), this.uploads, ")");
    }
}
