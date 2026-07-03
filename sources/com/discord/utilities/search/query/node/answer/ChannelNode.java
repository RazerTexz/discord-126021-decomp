package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelNode extends AnswerNode {
    private final String channelName;

    public ChannelNode(String str) {
        C12238m.checkNotNullParameter(str, "channelName");
        this.channelName = str;
    }

    public static /* synthetic */ ChannelNode copy$default(ChannelNode channelNode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelNode.channelName;
        }
        return channelNode.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    public final ChannelNode copy(String channelName) {
        C12238m.checkNotNullParameter(channelName, "channelName");
        return new ChannelNode(channelName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelNode) && C12238m.areEqual(this.channelName, ((ChannelNode) other).channelName);
        }
        return true;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return C12146m0.setOf(FilterType.IN);
    }

    public int hashCode() {
        String str = this.channelName;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        C12238m.checkNotNullParameter(searchData, "searchData");
        return searchData.getChannelNameIndex().containsKey(this.channelName);
    }

    public String toString() {
        return C1643a.m822J(C1643a.m833U("ChannelNode(channelName="), this.channelName, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        Long l;
        C12238m.checkNotNullParameter(queryBuilder, "queryBuilder");
        C12238m.checkNotNullParameter(searchData, "searchData");
        if (C12163u.contains(getValidFilters(), filterType) && (l = searchData.getChannelNameIndex().get(this.channelName)) != null) {
            queryBuilder.appendParam(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, String.valueOf(l.longValue()));
        }
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.CHANNELS_CHAR);
        sbM829Q.append(this.channelName);
        return sbM829Q.toString();
    }
}
