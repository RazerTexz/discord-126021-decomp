package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$ItemGuild implements WidgetGlobalSearchModel$ItemDataPayload {
    private final Channel channel;
    private final Guild guild;
    private final String key;
    private final WidgetGlobalSearchModel$MatchedResult matchedResult;
    private final int mentions;
    private final int type;
    private final boolean unread;

    public WidgetGlobalSearchModel$ItemGuild(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Guild guild, Channel channel, int i, boolean z2) {
        m.checkNotNullParameter(widgetGlobalSearchModel$MatchedResult, "matchedResult");
        m.checkNotNullParameter(guild, "guild");
        this.matchedResult = widgetGlobalSearchModel$MatchedResult;
        this.guild = guild;
        this.channel = channel;
        this.mentions = i;
        this.unread = z2;
        this.type = 2;
        this.key = String.valueOf(guild.getId());
    }

    public static /* synthetic */ WidgetGlobalSearchModel$ItemGuild copy$default(WidgetGlobalSearchModel$ItemGuild widgetGlobalSearchModel$ItemGuild, WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            widgetGlobalSearchModel$MatchedResult = widgetGlobalSearchModel$ItemGuild.getMatchedResult();
        }
        if ((i2 & 2) != 0) {
            guild = widgetGlobalSearchModel$ItemGuild.guild;
        }
        Guild guild2 = guild;
        if ((i2 & 4) != 0) {
            channel = widgetGlobalSearchModel$ItemGuild.getChannel();
        }
        Channel channel2 = channel;
        if ((i2 & 8) != 0) {
            i = widgetGlobalSearchModel$ItemGuild.getMentions();
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z2 = widgetGlobalSearchModel$ItemGuild.getUnread();
        }
        return widgetGlobalSearchModel$ItemGuild.copy(widgetGlobalSearchModel$MatchedResult, guild2, channel2, i3, z2);
    }

    public final WidgetGlobalSearchModel$MatchedResult component1() {
        return getMatchedResult();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Channel component3() {
        return getChannel();
    }

    public final int component4() {
        return getMentions();
    }

    public final boolean component5() {
        return getUnread();
    }

    public final WidgetGlobalSearchModel$ItemGuild copy(WidgetGlobalSearchModel$MatchedResult matchedResult, Guild guild, Channel channel, int mentions, boolean unread) {
        m.checkNotNullParameter(matchedResult, "matchedResult");
        m.checkNotNullParameter(guild, "guild");
        return new WidgetGlobalSearchModel$ItemGuild(matchedResult, guild, channel, mentions, unread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$ItemGuild)) {
            return false;
        }
        WidgetGlobalSearchModel$ItemGuild widgetGlobalSearchModel$ItemGuild = (WidgetGlobalSearchModel$ItemGuild) other;
        return m.areEqual(getMatchedResult(), widgetGlobalSearchModel$ItemGuild.getMatchedResult()) && m.areEqual(this.guild, widgetGlobalSearchModel$ItemGuild.guild) && m.areEqual(getChannel(), widgetGlobalSearchModel$ItemGuild.getChannel()) && getMentions() == widgetGlobalSearchModel$ItemGuild.getMentions() && getUnread() == widgetGlobalSearchModel$ItemGuild.getUnread();
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public Channel getChannel() {
        return this.channel;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public WidgetGlobalSearchModel$MatchedResult getMatchedResult() {
        return this.matchedResult;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public int getMentions() {
        return this.mentions;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public boolean getUnread() {
        return this.unread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        WidgetGlobalSearchModel$MatchedResult matchedResult = getMatchedResult();
        int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
        Guild guild = this.guild;
        int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
        Channel channel = getChannel();
        int mentions = (getMentions() + ((iHashCode2 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
        boolean unread = getUnread();
        ?? r0 = unread;
        if (unread) {
            r0 = 1;
        }
        return mentions + r0;
    }

    public String toString() {
        return String.valueOf('*') + this.guild.getName();
    }

    public /* synthetic */ WidgetGlobalSearchModel$ItemGuild(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Guild guild, Channel channel, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetGlobalSearchModel$MatchedResult, guild, (i2 & 4) != 0 ? null : channel, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z2);
    }
}
