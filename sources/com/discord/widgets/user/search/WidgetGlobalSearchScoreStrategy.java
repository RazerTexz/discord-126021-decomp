package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.presence.ClientStatus;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: compiled from: WidgetGlobalSearchScoreStrategy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchScoreStrategy {
    public static final int FRECENCY_PRI_LIMIT = 50;
    private static final int FUZZY_MATCH_SCORE_BASE = -100;
    private static final int FUZZY_MATCH_SCORE_MAX_DEDUCTION = 20;
    public static final WidgetGlobalSearchScoreStrategy INSTANCE = new WidgetGlobalSearchScoreStrategy();
    private static final int MENTIONS_MATCH_SCORE = 100;

    /* JADX INFO: compiled from: WidgetGlobalSearchScoreStrategy.kt */
    public enum SearchType {
        USER(10, 5),
        NONE(1, 1);

        private final int dmChannelWeight;
        private final int friendWeight;

        SearchType(int i, int i2) {
            this.friendWeight = i;
            this.dmChannelWeight = i2;
        }

        public final int getDmChannelWeight() {
            return this.dmChannelWeight;
        }

        public final int getFriendWeight() {
            return this.friendWeight;
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ClientStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ClientStatus.ONLINE.ordinal()] = 1;
            iArr[ClientStatus.IDLE.ordinal()] = 2;
            iArr[ClientStatus.DND.ordinal()] = 3;
        }
    }

    private WidgetGlobalSearchScoreStrategy() {
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003a  */
    public final int score(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, int i, Collection<Long> collection) {
        int iScoreChannel;
        Intrinsics3.checkNotNullParameter(itemDataPayload, "$this$score");
        Intrinsics3.checkNotNullParameter(collection, "frecencyChannels");
        Channel channel = itemDataPayload.getChannel();
        int iScoreFrecency = scoreFrecency(collection, channel != null ? channel.getId() : 0L);
        if (!(itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser)) {
            if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) {
                iScoreChannel = scoreChannel((WidgetGlobalSearchModel.ItemChannel) itemDataPayload);
            }
            if (itemDataPayload.getMentions() > 0) {
                iScoreFrecency += itemDataPayload.getMentions() + 100;
            }
            return scoreMatchedResult(itemDataPayload.getMatchedResult()) + iScoreFrecency;
        }
        iScoreChannel = scoreUser((WidgetGlobalSearchModel.ItemUser) itemDataPayload, i);
        iScoreFrecency += iScoreChannel;
        if (itemDataPayload.getMentions() > 0) {
            iScoreFrecency += itemDataPayload.getMentions() + 100;
        }
        return scoreMatchedResult(itemDataPayload.getMatchedResult()) + iScoreFrecency;
    }

    public final int scoreChannel(WidgetGlobalSearchModel.ItemChannel itemChannel) {
        Intrinsics3.checkNotNullParameter(itemChannel, "$this$scoreChannel");
        Guild guild = itemChannel.getGuild();
        return (guild != null ? guild.getMemberCount() : 0) > 200 ? -5 : 0;
    }

    public final int scoreFrecency(Collection<Long> collection, long j) {
        Intrinsics3.checkNotNullParameter(collection, "$this$scoreFrecency");
        int iIndexOf = _Collections.indexOf(collection, Long.valueOf(j));
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

    public final int scoreMatchedResult(WidgetGlobalSearchModel.MatchedResult matchedResult) {
        int firstMatchIndex;
        Intrinsics3.checkNotNullParameter(matchedResult, "$this$scoreMatchedResult");
        int firstMatchIndex2 = matchedResult.getFirstMatchIndex();
        int i = 0;
        if (firstMatchIndex2 == -1) {
            firstMatchIndex = (-100) - Math.min(matchedResult.getValue().length(), 20);
        } else {
            firstMatchIndex = (firstMatchIndex2 >= 0 && 10 >= firstMatchIndex2) ? 15 - matchedResult.getFirstMatchIndex() : 0;
        }
        if (matchedResult.getFirstMatchIndex() == 0) {
            i = 2;
        } else if (matchedResult.getFirstMatchIndex() > 0 && !Character.isLetterOrDigit(matchedResult.getValue().charAt(matchedResult.getFirstMatchIndex() - 1))) {
            i = 1;
        }
        return firstMatchIndex + i;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0028  */
    public final int scoreUser(WidgetGlobalSearchModel.ItemUser itemUser, int i) {
        int i2;
        Intrinsics3.checkNotNullParameter(itemUser, "$this$scoreUser");
        SearchType searchType = i != 1 ? SearchType.NONE : SearchType.USER;
        Presence presence = itemUser.getPresence();
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
        return i2 + (itemUser.isFriend() ? searchType.getFriendWeight() : 0) + (itemUser.getChannel() != null ? searchType.getDmChannelWeight() : 0) + (Intrinsics3.areEqual(itemUser.getMatchedResult().getValue(), itemUser.getUser().getUsername()) ? 2 : 0);
    }
}
