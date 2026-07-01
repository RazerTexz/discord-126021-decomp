package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: compiled from: ChannelNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelNode extends AnswerNode {
    private final String channelName;

    public ChannelNode(String str) {
        Intrinsics3.checkNotNullParameter(str, "channelName");
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
        Intrinsics3.checkNotNullParameter(channelName, "channelName");
        return new ChannelNode(channelName);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ChannelNode) && Intrinsics3.areEqual(this.channelName, ((ChannelNode) other).channelName);
        }
        return true;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return SetsJVM.setOf(FilterType.IN);
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
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return searchData.getChannelNameIndex().containsKey(this.channelName);
    }

    public String toString() {
        return outline.J(outline.U("ChannelNode(channelName="), this.channelName, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        Long l;
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        if (_Collections.contains(getValidFilters(), filterType) && (l = searchData.getChannelNameIndex().get(this.channelName)) != null) {
            queryBuilder.appendParam(ModelAuditLogEntry.CHANGE_KEY_CHANNEL_ID, String.valueOf(l.longValue()));
        }
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
        sbQ.append(this.channelName);
        return sbQ.toString();
    }
}
