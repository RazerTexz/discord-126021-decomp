package com.discord.widgets.servers.settings.invites;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.models.domain.ModelInvite;
import com.discord.models.member.GuildMember;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.user.UserUtils;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsInstantInvites$Model$InviteItem implements MGRecyclerDataPayload, Comparable<WidgetServerSettingsInstantInvites$Model$InviteItem> {
    public static final WidgetServerSettingsInstantInvites$Model$InviteItem$Companion Companion = new WidgetServerSettingsInstantInvites$Model$InviteItem$Companion(null);
    public static final int TYPE_INVITE = 0;
    private final long guildId;
    private final GuildMember guildMember;
    private final ModelInvite invite;
    private final String key;
    private final int type;

    public WidgetServerSettingsInstantInvites$Model$InviteItem(ModelInvite modelInvite, long j, GuildMember guildMember) {
        m.checkNotNullParameter(modelInvite, "invite");
        this.invite = modelInvite;
        this.guildId = j;
        this.guildMember = guildMember;
        String str = modelInvite.code;
        m.checkNotNullExpressionValue(str, "invite.code");
        this.key = str;
    }

    public static /* synthetic */ WidgetServerSettingsInstantInvites$Model$InviteItem copy$default(WidgetServerSettingsInstantInvites$Model$InviteItem widgetServerSettingsInstantInvites$Model$InviteItem, ModelInvite modelInvite, long j, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = widgetServerSettingsInstantInvites$Model$InviteItem.invite;
        }
        if ((i & 2) != 0) {
            j = widgetServerSettingsInstantInvites$Model$InviteItem.guildId;
        }
        if ((i & 4) != 0) {
            guildMember = widgetServerSettingsInstantInvites$Model$InviteItem.guildMember;
        }
        return widgetServerSettingsInstantInvites$Model$InviteItem.copy(modelInvite, j, guildMember);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WidgetServerSettingsInstantInvites$Model$InviteItem widgetServerSettingsInstantInvites$Model$InviteItem) {
        return compareTo2(widgetServerSettingsInstantInvites$Model$InviteItem);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final WidgetServerSettingsInstantInvites$Model$InviteItem copy(ModelInvite invite, long guildId, GuildMember guildMember) {
        m.checkNotNullParameter(invite, "invite");
        return new WidgetServerSettingsInstantInvites$Model$InviteItem(invite, guildId, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsInstantInvites$Model$InviteItem)) {
            return false;
        }
        WidgetServerSettingsInstantInvites$Model$InviteItem widgetServerSettingsInstantInvites$Model$InviteItem = (WidgetServerSettingsInstantInvites$Model$InviteItem) other;
        return m.areEqual(this.invite, widgetServerSettingsInstantInvites$Model$InviteItem.invite) && this.guildId == widgetServerSettingsInstantInvites$Model$InviteItem.guildId && m.areEqual(this.guildMember, widgetServerSettingsInstantInvites$Model$InviteItem.guildMember);
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iA = (b.a(this.guildId) + ((modelInvite != null ? modelInvite.hashCode() : 0) * 31)) * 31;
        GuildMember guildMember = this.guildMember;
        return iA + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteItem(invite=");
        sbU.append(this.invite);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(WidgetServerSettingsInstantInvites$Model$InviteItem other) {
        String username;
        String username2;
        m.checkNotNullParameter(other, "other");
        Channel channel = this.invite.getChannel();
        String strC = channel != null ? ChannelUtils.c(channel) : null;
        Channel channel2 = other.invite.getChannel();
        String strC2 = channel2 != null ? ChannelUtils.c(channel2) : null;
        int iCompareTo = (strC == null || strC2 == null) ? 0 : t.compareTo(strC, strC2, true);
        User inviter = this.invite.getInviter();
        User inviter2 = other.invite.getInviter();
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        if (inviter == null || (username = inviter.getUsername()) == null) {
            username = "";
        }
        if (inviter2 == null || (username2 = inviter2.getUsername()) == null) {
            username2 = "";
        }
        return userUtils.compareUserNames(username, username2, null, null, inviter != null ? inviter.getId() : 0L, inviter2 != null ? inviter2.getId() : 0L);
    }
}
