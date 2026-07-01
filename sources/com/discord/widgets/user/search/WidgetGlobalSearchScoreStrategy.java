package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: WidgetGlobalSearchScoreStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchScoreStrategy {
    public static final int FRECENCY_PRI_LIMIT = 50;
    private static final int FUZZY_MATCH_SCORE_BASE = -100;
    private static final int FUZZY_MATCH_SCORE_MAX_DEDUCTION = 20;
    public static final WidgetGlobalSearchScoreStrategy INSTANCE = new WidgetGlobalSearchScoreStrategy();
    private static final int MENTIONS_MATCH_SCORE = 100;

    private WidgetGlobalSearchScoreStrategy() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    public final int score(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, int i, Collection<Long> collection) {
        int iScoreChannel;
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "$this$score");
        m.checkNotNullParameter(collection, "frecencyChannels");
        Channel channel = widgetGlobalSearchModel$ItemDataPayload.getChannel();
        int iScoreFrecency = scoreFrecency(collection, channel != null ? channel.getId() : 0L);
        if (!(widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemUser)) {
            if (widgetGlobalSearchModel$ItemDataPayload instanceof WidgetGlobalSearchModel$ItemChannel) {
                iScoreChannel = scoreChannel((WidgetGlobalSearchModel$ItemChannel) widgetGlobalSearchModel$ItemDataPayload);
            }
            if (widgetGlobalSearchModel$ItemDataPayload.getMentions() > 0) {
                iScoreFrecency += widgetGlobalSearchModel$ItemDataPayload.getMentions() + 100;
            }
            return scoreMatchedResult(widgetGlobalSearchModel$ItemDataPayload.getMatchedResult()) + iScoreFrecency;
        }
        iScoreChannel = scoreUser((WidgetGlobalSearchModel$ItemUser) widgetGlobalSearchModel$ItemDataPayload, i);
        iScoreFrecency += iScoreChannel;
        if (widgetGlobalSearchModel$ItemDataPayload.getMentions() > 0) {
            iScoreFrecency += widgetGlobalSearchModel$ItemDataPayload.getMentions() + 100;
        }
        return scoreMatchedResult(widgetGlobalSearchModel$ItemDataPayload.getMatchedResult()) + iScoreFrecency;
    }

    public final int scoreChannel(WidgetGlobalSearchModel$ItemChannel widgetGlobalSearchModel$ItemChannel) {
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemChannel, "$this$scoreChannel");
        Guild guild = widgetGlobalSearchModel$ItemChannel.getGuild();
        return (guild != null ? guild.getMemberCount() : 0) > 200 ? -5 : 0;
    }

    public final int scoreFrecency(Collection<Long> collection, long j) {
        m.checkNotNullParameter(collection, "$this$scoreFrecency");
        int iIndexOf = u.indexOf(collection, Long.valueOf(j));
        if (iIndexOf == -1) {
            return 0;
        }
        if (iIndexOf >= 0 && 5 > iIndexOf) {
            return 60 - iIndexOf;
        }
        if (5 <= iIndexOf && 50 > iIndexOf) {
            return 55 - iIndexOf;
        }
        return 2;
    }

    public final int scoreMatchedResult(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult) {
        int firstMatchIndex;
        m.checkNotNullParameter(widgetGlobalSearchModel$MatchedResult, "$this$scoreMatchedResult");
        int firstMatchIndex2 = widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex();
        int i = 0;
        if (firstMatchIndex2 == -1) {
            firstMatchIndex = (-100) - Math.min(widgetGlobalSearchModel$MatchedResult.getValue().length(), 20);
        } else {
            firstMatchIndex = (firstMatchIndex2 >= 0 && 10 >= firstMatchIndex2) ? 15 - widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex() : 0;
        }
        if (widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex() == 0) {
            i = 2;
        } else if (widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex() > 0 && !Character.isLetterOrDigit(widgetGlobalSearchModel$MatchedResult.getValue().charAt(widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex() - 1))) {
            i = 1;
        }
        return firstMatchIndex + i;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0028  */
    public final int scoreUser(WidgetGlobalSearchModel$ItemUser widgetGlobalSearchModel$ItemUser, int i) {
        int i2;
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemUser, "$this$scoreUser");
        WidgetGlobalSearchScoreStrategy$SearchType widgetGlobalSearchScoreStrategy$SearchType = i != 1 ? WidgetGlobalSearchScoreStrategy$SearchType.NONE : WidgetGlobalSearchScoreStrategy$SearchType.USER;
        Presence presence = widgetGlobalSearchModel$ItemUser.getPresence();
        ClientStatus status = presence != null ? presence.getStatus() : null;
        if (status != null) {
            int iOrdinal = status.ordinal();
            if (iOrdinal == 0) {
                i2 = 4;
            } else if (iOrdinal == 1) {
                i2 = 3;
            } else if (iOrdinal != 2) {
                i2 = 0;
            } else {
                i2 = 2;
            }
        } else {
            i2 = 0;
        }
        return i2 + (widgetGlobalSearchModel$ItemUser.isFriend() ? widgetGlobalSearchScoreStrategy$SearchType.getFriendWeight() : 0) + (widgetGlobalSearchModel$ItemUser.getChannel() != null ? widgetGlobalSearchScoreStrategy$SearchType.getDmChannelWeight() : 0) + (m.areEqual(widgetGlobalSearchModel$ItemUser.getMatchedResult().getValue(), widgetGlobalSearchModel$ItemUser.getUser().getUsername()) ? 2 : 0);
    }
}
