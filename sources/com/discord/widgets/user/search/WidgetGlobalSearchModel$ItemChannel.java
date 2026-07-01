package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$ItemChannel implements WidgetGlobalSearchModel$ItemDataPayload {
    private final Channel channel;
    private final Guild guild;
    private final String key;
    private final WidgetGlobalSearchModel$MatchedResult matchedResult;
    private final int mentions;
    private final Channel parentChannel;
    private final int type;
    private final boolean unread;

    public WidgetGlobalSearchModel$ItemChannel(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2) {
        m.checkNotNullParameter(widgetGlobalSearchModel$MatchedResult, "matchedResult");
        m.checkNotNullParameter(channel, "channel");
        this.matchedResult = widgetGlobalSearchModel$MatchedResult;
        this.channel = channel;
        this.parentChannel = channel2;
        this.guild = guild;
        this.mentions = i;
        this.unread = z2;
        this.key = String.valueOf(getChannel().getId());
    }

    public static /* synthetic */ WidgetGlobalSearchModel$ItemChannel copy$default(WidgetGlobalSearchModel$ItemChannel widgetGlobalSearchModel$ItemChannel, WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            widgetGlobalSearchModel$MatchedResult = widgetGlobalSearchModel$ItemChannel.getMatchedResult();
        }
        if ((i2 & 2) != 0) {
            channel = widgetGlobalSearchModel$ItemChannel.getChannel();
        }
        Channel channel3 = channel;
        if ((i2 & 4) != 0) {
            channel2 = widgetGlobalSearchModel$ItemChannel.parentChannel;
        }
        Channel channel4 = channel2;
        if ((i2 & 8) != 0) {
            guild = widgetGlobalSearchModel$ItemChannel.guild;
        }
        Guild guild2 = guild;
        if ((i2 & 16) != 0) {
            i = widgetGlobalSearchModel$ItemChannel.getMentions();
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z2 = widgetGlobalSearchModel$ItemChannel.getUnread();
        }
        return widgetGlobalSearchModel$ItemChannel.copy(widgetGlobalSearchModel$MatchedResult, channel3, channel4, guild2, i3, z2);
    }

    public final WidgetGlobalSearchModel$MatchedResult component1() {
        return getMatchedResult();
    }

    public final Channel component2() {
        return getChannel();
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final int component5() {
        return getMentions();
    }

    public final boolean component6() {
        return getUnread();
    }

    public final WidgetGlobalSearchModel$ItemChannel copy(WidgetGlobalSearchModel$MatchedResult matchedResult, Channel channel, Channel parentChannel, Guild guild, int mentions, boolean unread) {
        m.checkNotNullParameter(matchedResult, "matchedResult");
        m.checkNotNullParameter(channel, "channel");
        return new WidgetGlobalSearchModel$ItemChannel(matchedResult, channel, parentChannel, guild, mentions, unread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$ItemChannel)) {
            return false;
        }
        WidgetGlobalSearchModel$ItemChannel widgetGlobalSearchModel$ItemChannel = (WidgetGlobalSearchModel$ItemChannel) other;
        return m.areEqual(getMatchedResult(), widgetGlobalSearchModel$ItemChannel.getMatchedResult()) && m.areEqual(getChannel(), widgetGlobalSearchModel$ItemChannel.getChannel()) && m.areEqual(this.parentChannel, widgetGlobalSearchModel$ItemChannel.parentChannel) && m.areEqual(this.guild, widgetGlobalSearchModel$ItemChannel.guild) && getMentions() == widgetGlobalSearchModel$ItemChannel.getMentions() && getUnread() == widgetGlobalSearchModel$ItemChannel.getUnread();
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

    public final Channel getParentChannel() {
        return this.parentChannel;
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
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        WidgetGlobalSearchModel$MatchedResult matchedResult = getMatchedResult();
        int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
        Channel channel = getChannel();
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int mentions = (getMentions() + ((iHashCode3 + (guild != null ? guild.hashCode() : 0)) * 31)) * 31;
        boolean unread = getUnread();
        ?? r0 = unread;
        if (unread) {
            r0 = 1;
        }
        return mentions + r0;
    }

    public String toString() {
        return String.valueOf(MentionUtilsKt.CHANNELS_CHAR) + ChannelUtils.c(getChannel());
    }

    public /* synthetic */ WidgetGlobalSearchModel$ItemChannel(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, Channel channel, Channel channel2, Guild guild, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetGlobalSearchModel$MatchedResult, channel, channel2, guild, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z2);
    }
}
