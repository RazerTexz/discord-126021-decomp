package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMutualGuilds$Model$Item implements MGRecyclerDataPayload {
    public static final WidgetUserMutualGuilds$Model$Item$Companion Companion = new WidgetUserMutualGuilds$Model$Item$Companion(null);
    public static final int TYPE_EMPTY = 0;
    public static final int TYPE_MUTUAL_SERVER = 1;
    private final Guild guild;
    private final GuildMember guildMember;
    private final String key;
    private final String nick;
    private final int type;
    private final User user;

    public WidgetUserMutualGuilds$Model$Item(int i, Guild guild, String str, User user, GuildMember guildMember) {
        this.type = i;
        this.guild = guild;
        this.nick = str;
        this.user = user;
        this.guildMember = guildMember;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(getType()));
        sb.append(String.valueOf(guild != null ? guild.getId() : 0L));
        this.key = sb.toString();
    }

    public static /* synthetic */ WidgetUserMutualGuilds$Model$Item copy$default(WidgetUserMutualGuilds$Model$Item widgetUserMutualGuilds$Model$Item, int i, Guild guild, String str, User user, GuildMember guildMember, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetUserMutualGuilds$Model$Item.getType();
        }
        if ((i2 & 2) != 0) {
            guild = widgetUserMutualGuilds$Model$Item.guild;
        }
        Guild guild2 = guild;
        if ((i2 & 4) != 0) {
            str = widgetUserMutualGuilds$Model$Item.nick;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            user = widgetUserMutualGuilds$Model$Item.user;
        }
        User user2 = user;
        if ((i2 & 16) != 0) {
            guildMember = widgetUserMutualGuilds$Model$Item.guildMember;
        }
        return widgetUserMutualGuilds$Model$Item.copy(i, guild2, str2, user2, guildMember);
    }

    public final int component1() {
        return getType();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final WidgetUserMutualGuilds$Model$Item copy(int type, Guild guild, String nick, User user, GuildMember guildMember) {
        return new WidgetUserMutualGuilds$Model$Item(type, guild, nick, user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMutualGuilds$Model$Item)) {
            return false;
        }
        WidgetUserMutualGuilds$Model$Item widgetUserMutualGuilds$Model$Item = (WidgetUserMutualGuilds$Model$Item) other;
        return getType() == widgetUserMutualGuilds$Model$Item.getType() && m.areEqual(this.guild, widgetUserMutualGuilds$Model$Item.guild) && m.areEqual(this.nick, widgetUserMutualGuilds$Model$Item.nick) && m.areEqual(this.user, widgetUserMutualGuilds$Model$Item.user) && m.areEqual(this.guildMember, widgetUserMutualGuilds$Model$Item.guildMember);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getNick() {
        return this.nick;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int type = getType() * 31;
        Guild guild = this.guild;
        int iHashCode = (type + (guild != null ? guild.hashCode() : 0)) * 31;
        String str = this.nick;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Item(type=");
        sbU.append(getType());
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", nick=");
        sbU.append(this.nick);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetUserMutualGuilds$Model$Item(int i, Guild guild, String str, User user, GuildMember guildMember, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, guild, str, user, guildMember);
    }
}
