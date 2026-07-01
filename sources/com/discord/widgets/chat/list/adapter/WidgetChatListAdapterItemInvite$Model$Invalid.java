package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemInvite$Model$Invalid extends WidgetChatListAdapterItemInvite$Model {
    private final User authorUser;
    private final Channel channel;
    private final long meId;

    public WidgetChatListAdapterItemInvite$Model$Invalid(User user, long j, Channel channel) {
        super(null);
        this.authorUser = user;
        this.meId = j;
        this.channel = channel;
    }

    public static /* synthetic */ WidgetChatListAdapterItemInvite$Model$Invalid copy$default(WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid, User user, long j, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            user = widgetChatListAdapterItemInvite$Model$Invalid.authorUser;
        }
        if ((i & 2) != 0) {
            j = widgetChatListAdapterItemInvite$Model$Invalid.meId;
        }
        if ((i & 4) != 0) {
            channel = widgetChatListAdapterItemInvite$Model$Invalid.channel;
        }
        return widgetChatListAdapterItemInvite$Model$Invalid.copy(user, j, channel);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getAuthorUser() {
        return this.authorUser;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMeId() {
        return this.meId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    public final WidgetChatListAdapterItemInvite$Model$Invalid copy(User authorUser, long meId, Channel channel) {
        return new WidgetChatListAdapterItemInvite$Model$Invalid(authorUser, meId, channel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemInvite$Model$Invalid)) {
            return false;
        }
        WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid = (WidgetChatListAdapterItemInvite$Model$Invalid) other;
        return m.areEqual(this.authorUser, widgetChatListAdapterItemInvite$Model$Invalid.authorUser) && this.meId == widgetChatListAdapterItemInvite$Model$Invalid.meId && m.areEqual(this.channel, widgetChatListAdapterItemInvite$Model$Invalid.channel);
    }

    public final User getAuthorUser() {
        return this.authorUser;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getMeId() {
        return this.meId;
    }

    public int hashCode() {
        User user = this.authorUser;
        int iA = (b.a(this.meId) + ((user != null ? user.hashCode() : 0) * 31)) * 31;
        Channel channel = this.channel;
        return iA + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Invalid(authorUser=");
        sbU.append(this.authorUser);
        sbU.append(", meId=");
        sbU.append(this.meId);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(")");
        return sbU.toString();
    }
}
