package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGift.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemGift$Model$Invalid extends WidgetChatListAdapterItemGift$Model {
    private final Long gifterUserId;
    private final long meId;

    public WidgetChatListAdapterItemGift$Model$Invalid(Long l, long j) {
        super(null);
        this.gifterUserId = l;
        this.meId = j;
    }

    public static /* synthetic */ WidgetChatListAdapterItemGift$Model$Invalid copy$default(WidgetChatListAdapterItemGift$Model$Invalid widgetChatListAdapterItemGift$Model$Invalid, Long l, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            l = widgetChatListAdapterItemGift$Model$Invalid.gifterUserId;
        }
        if ((i & 2) != 0) {
            j = widgetChatListAdapterItemGift$Model$Invalid.meId;
        }
        return widgetChatListAdapterItemGift$Model$Invalid.copy(l, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getGifterUserId() {
        return this.gifterUserId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMeId() {
        return this.meId;
    }

    public final WidgetChatListAdapterItemGift$Model$Invalid copy(Long gifterUserId, long meId) {
        return new WidgetChatListAdapterItemGift$Model$Invalid(gifterUserId, meId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemGift$Model$Invalid)) {
            return false;
        }
        WidgetChatListAdapterItemGift$Model$Invalid widgetChatListAdapterItemGift$Model$Invalid = (WidgetChatListAdapterItemGift$Model$Invalid) other;
        return m.areEqual(this.gifterUserId, widgetChatListAdapterItemGift$Model$Invalid.gifterUserId) && this.meId == widgetChatListAdapterItemGift$Model$Invalid.meId;
    }

    public final Long getGifterUserId() {
        return this.gifterUserId;
    }

    public final long getMeId() {
        return this.meId;
    }

    public int hashCode() {
        Long l = this.gifterUserId;
        return b.a(this.meId) + ((l != null ? l.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Invalid(gifterUserId=");
        sbU.append(this.gifterUserId);
        sbU.append(", meId=");
        return a.C(sbU, this.meId, ")");
    }
}
