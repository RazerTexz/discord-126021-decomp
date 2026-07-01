package com.discord.widgets.user.search;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetGlobalSearchModel$ItemUser implements WidgetGlobalSearchModel$ItemDataPayload {
    private final List<CharSequence> aliases;
    private final Channel channel;
    private final boolean isFriend;
    private final String key;
    private final WidgetGlobalSearchModel$MatchedResult matchedResult;
    private final int mentions;
    private final Presence presence;
    private final int type;
    private final boolean unread;
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetGlobalSearchModel$ItemUser(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, User user, List<? extends CharSequence> list, boolean z2, Presence presence, Channel channel, int i, boolean z3) {
        m.checkNotNullParameter(widgetGlobalSearchModel$MatchedResult, "matchedResult");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(list, "aliases");
        this.matchedResult = widgetGlobalSearchModel$MatchedResult;
        this.user = user;
        this.aliases = list;
        this.isFriend = z2;
        this.presence = presence;
        this.channel = channel;
        this.mentions = i;
        this.unread = z3;
        this.type = 1;
        this.key = String.valueOf(user.getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetGlobalSearchModel$ItemUser copy$default(WidgetGlobalSearchModel$ItemUser widgetGlobalSearchModel$ItemUser, WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, User user, List list, boolean z2, Presence presence, Channel channel, int i, boolean z3, int i2, Object obj) {
        return widgetGlobalSearchModel$ItemUser.copy((i2 & 1) != 0 ? widgetGlobalSearchModel$ItemUser.getMatchedResult() : widgetGlobalSearchModel$MatchedResult, (i2 & 2) != 0 ? widgetGlobalSearchModel$ItemUser.user : user, (i2 & 4) != 0 ? widgetGlobalSearchModel$ItemUser.aliases : list, (i2 & 8) != 0 ? widgetGlobalSearchModel$ItemUser.isFriend : z2, (i2 & 16) != 0 ? widgetGlobalSearchModel$ItemUser.presence : presence, (i2 & 32) != 0 ? widgetGlobalSearchModel$ItemUser.getChannel() : channel, (i2 & 64) != 0 ? widgetGlobalSearchModel$ItemUser.getMentions() : i, (i2 & 128) != 0 ? widgetGlobalSearchModel$ItemUser.getUnread() : z3);
    }

    public final WidgetGlobalSearchModel$MatchedResult component1() {
        return getMatchedResult();
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final List<CharSequence> component3() {
        return this.aliases;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Presence getPresence() {
        return this.presence;
    }

    public final Channel component6() {
        return getChannel();
    }

    public final int component7() {
        return getMentions();
    }

    public final boolean component8() {
        return getUnread();
    }

    public final WidgetGlobalSearchModel$ItemUser copy(WidgetGlobalSearchModel$MatchedResult matchedResult, User user, List<? extends CharSequence> aliases, boolean isFriend, Presence presence, Channel channel, int mentions, boolean unread) {
        m.checkNotNullParameter(matchedResult, "matchedResult");
        m.checkNotNullParameter(user, "user");
        m.checkNotNullParameter(aliases, "aliases");
        return new WidgetGlobalSearchModel$ItemUser(matchedResult, user, aliases, isFriend, presence, channel, mentions, unread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGlobalSearchModel$ItemUser)) {
            return false;
        }
        WidgetGlobalSearchModel$ItemUser widgetGlobalSearchModel$ItemUser = (WidgetGlobalSearchModel$ItemUser) other;
        return m.areEqual(getMatchedResult(), widgetGlobalSearchModel$ItemUser.getMatchedResult()) && m.areEqual(this.user, widgetGlobalSearchModel$ItemUser.user) && m.areEqual(this.aliases, widgetGlobalSearchModel$ItemUser.aliases) && this.isFriend == widgetGlobalSearchModel$ItemUser.isFriend && m.areEqual(this.presence, widgetGlobalSearchModel$ItemUser.presence) && m.areEqual(getChannel(), widgetGlobalSearchModel$ItemUser.getChannel()) && getMentions() == widgetGlobalSearchModel$ItemUser.getMentions() && getUnread() == widgetGlobalSearchModel$ItemUser.getUnread();
    }

    public final List<CharSequence> getAliases() {
        return this.aliases;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public Channel getChannel() {
        return this.channel;
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

    public final Presence getPresence() {
        return this.presence;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    @Override // com.discord.widgets.user.search.WidgetGlobalSearchModel$ItemDataPayload
    public boolean getUnread() {
        return this.unread;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        WidgetGlobalSearchModel$MatchedResult matchedResult = getMatchedResult();
        int iHashCode = (matchedResult != null ? matchedResult.hashCode() : 0) * 31;
        User user = this.user;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        List<CharSequence> list = this.aliases;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.isFriend;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        Presence presence = this.presence;
        int iHashCode4 = (i + (presence != null ? presence.hashCode() : 0)) * 31;
        Channel channel = getChannel();
        int mentions = (getMentions() + ((iHashCode4 + (channel != null ? channel.hashCode() : 0)) * 31)) * 31;
        boolean unread = getUnread();
        return mentions + (unread ? 1 : unread);
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public String toString() {
        StringBuilder sbQ = a.Q(MentionUtilsKt.MENTIONS_CHAR);
        sbQ.append(getMatchedResult().getValue());
        return sbQ.toString();
    }

    public /* synthetic */ WidgetGlobalSearchModel$ItemUser(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, User user, List list, boolean z2, Presence presence, Channel channel, int i, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetGlobalSearchModel$MatchedResult, user, list, (i2 & 8) != 0 ? false : z2, presence, (i2 & 32) != 0 ? null : channel, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? false : z3);
    }
}
