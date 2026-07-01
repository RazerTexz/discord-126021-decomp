package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatListAdapterItemInvite$Model$Resolved extends WidgetChatListAdapterItemInvite$Model {
    private final User authorUser;
    private final Channel channel;
    private final ModelInvite invite;
    private final boolean isMemberOfGuild;
    private final long meId;
    private final boolean shouldAnimateGuildIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite$Model$Resolved(ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3) {
        super(null);
        m.checkNotNullParameter(modelInvite, "invite");
        this.invite = modelInvite;
        this.meId = j;
        this.authorUser = user;
        this.isMemberOfGuild = z2;
        this.channel = channel;
        this.shouldAnimateGuildIcon = z3;
    }

    public static /* synthetic */ WidgetChatListAdapterItemInvite$Model$Resolved copy$default(WidgetChatListAdapterItemInvite$Model$Resolved widgetChatListAdapterItemInvite$Model$Resolved, ModelInvite modelInvite, long j, User user, boolean z2, Channel channel, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = widgetChatListAdapterItemInvite$Model$Resolved.invite;
        }
        if ((i & 2) != 0) {
            j = widgetChatListAdapterItemInvite$Model$Resolved.meId;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            user = widgetChatListAdapterItemInvite$Model$Resolved.authorUser;
        }
        User user2 = user;
        if ((i & 8) != 0) {
            z2 = widgetChatListAdapterItemInvite$Model$Resolved.isMemberOfGuild;
        }
        boolean z4 = z2;
        if ((i & 16) != 0) {
            channel = widgetChatListAdapterItemInvite$Model$Resolved.channel;
        }
        Channel channel2 = channel;
        if ((i & 32) != 0) {
            z3 = widgetChatListAdapterItemInvite$Model$Resolved.shouldAnimateGuildIcon;
        }
        return widgetChatListAdapterItemInvite$Model$Resolved.copy(modelInvite, j2, user2, z4, channel2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getMeId() {
        return this.meId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getAuthorUser() {
        return this.authorUser;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsMemberOfGuild() {
        return this.isMemberOfGuild;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShouldAnimateGuildIcon() {
        return this.shouldAnimateGuildIcon;
    }

    public final WidgetChatListAdapterItemInvite$Model$Resolved copy(ModelInvite invite, long meId, User authorUser, boolean isMemberOfGuild, Channel channel, boolean shouldAnimateGuildIcon) {
        m.checkNotNullParameter(invite, "invite");
        return new WidgetChatListAdapterItemInvite$Model$Resolved(invite, meId, authorUser, isMemberOfGuild, channel, shouldAnimateGuildIcon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatListAdapterItemInvite$Model$Resolved)) {
            return false;
        }
        WidgetChatListAdapterItemInvite$Model$Resolved widgetChatListAdapterItemInvite$Model$Resolved = (WidgetChatListAdapterItemInvite$Model$Resolved) other;
        return m.areEqual(this.invite, widgetChatListAdapterItemInvite$Model$Resolved.invite) && this.meId == widgetChatListAdapterItemInvite$Model$Resolved.meId && m.areEqual(this.authorUser, widgetChatListAdapterItemInvite$Model$Resolved.authorUser) && this.isMemberOfGuild == widgetChatListAdapterItemInvite$Model$Resolved.isMemberOfGuild && m.areEqual(this.channel, widgetChatListAdapterItemInvite$Model$Resolved.channel) && this.shouldAnimateGuildIcon == widgetChatListAdapterItemInvite$Model$Resolved.shouldAnimateGuildIcon;
    }

    public final User getAuthorUser() {
        return this.authorUser;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final long getMeId() {
        return this.meId;
    }

    public final boolean getShouldAnimateGuildIcon() {
        return this.shouldAnimateGuildIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iA = (b.a(this.meId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
        User user = this.authorUser;
        int iHashCode = (iA + (user != null ? user.hashCode() : 0)) * 31;
        boolean z2 = this.isMemberOfGuild;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = (iHashCode + r0) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z3 = this.shouldAnimateGuildIcon;
        return iHashCode2 + (z3 ? 1 : z3);
    }

    public final boolean isMemberOfGuild() {
        return this.isMemberOfGuild;
    }

    public String toString() {
        StringBuilder sbU = a.U("Resolved(invite=");
        sbU.append(this.invite);
        sbU.append(", meId=");
        sbU.append(this.meId);
        sbU.append(", authorUser=");
        sbU.append(this.authorUser);
        sbU.append(", isMemberOfGuild=");
        sbU.append(this.isMemberOfGuild);
        sbU.append(", channel=");
        sbU.append(this.channel);
        sbU.append(", shouldAnimateGuildIcon=");
        return a.O(sbU, this.shouldAnimateGuildIcon, ")");
    }
}
