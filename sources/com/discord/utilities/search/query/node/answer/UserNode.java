package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.utilities.search.network.SearchQuery$Builder;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import d0.t.n0;
import d0.z.d.m;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: UserNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserNode extends AnswerNode {
    private final int discriminator;
    private final String userName;

    public UserNode(String str, int i) {
        m.checkNotNullParameter(str, "userName");
        this.userName = str;
        this.discriminator = i;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getDiscriminator() {
        return this.discriminator;
    }

    public static /* synthetic */ UserNode copy$default(UserNode userNode, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userNode.userName;
        }
        if ((i2 & 2) != 0) {
            i = userNode.discriminator;
        }
        return userNode.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    public final UserNode copy(String userName, int discriminator) {
        m.checkNotNullParameter(userName, "userName");
        return new UserNode(userName, discriminator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserNode)) {
            return false;
        }
        UserNode userNode = (UserNode) other;
        return m.areEqual(this.userName, userNode.userName) && this.discriminator == userNode.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public /* bridge */ /* synthetic */ CharSequence getText() {
        return getText();
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return n0.setOf((Object[]) new FilterType[]{FilterType.FROM, FilterType.MENTIONS});
    }

    public int hashCode() {
        String str = this.userName;
        return ((str != null ? str.hashCode() : 0) * 31) + this.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        m.checkNotNullParameter(searchData, "searchData");
        return searchData.getUserId(this.userName, this.discriminator) != null;
    }

    public String toString() {
        StringBuilder sbU = a.U("UserNode(userName=");
        sbU.append(this.userName);
        sbU.append(", discriminator=");
        return a.B(sbU, this.discriminator, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery$Builder queryBuilder, SearchData searchData, FilterType filterType) {
        String str;
        m.checkNotNullParameter(queryBuilder, "queryBuilder");
        m.checkNotNullParameter(searchData, "searchData");
        if (filterType == null) {
            return;
        }
        int iOrdinal = filterType.ordinal();
        if (iOrdinal == 0) {
            str = "author_id";
        } else if (iOrdinal != 1) {
            return;
        } else {
            str = "mentions";
        }
        queryBuilder.appendParam(str, String.valueOf(searchData.getUserId(this.userName, this.discriminator)));
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public String getText() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.userName);
        sb.append("#");
        String str = String.format("%04d", Arrays.copyOf(new Object[]{Integer.valueOf(this.discriminator)}, 1));
        m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        return sb.toString();
    }
}
