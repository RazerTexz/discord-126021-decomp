package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: UserNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class UserNode extends AnswerNode {
    private final int discriminator;
    private final String userName;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            FilterType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[FilterType.FROM.ordinal()] = 1;
            iArr[FilterType.MENTIONS.ordinal()] = 2;
        }
    }

    public UserNode(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "userName");
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
        Intrinsics3.checkNotNullParameter(userName, "userName");
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
        return Intrinsics3.areEqual(this.userName, userNode.userName) && this.discriminator == userNode.discriminator;
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return Sets5.setOf((Object[]) new FilterType[]{FilterType.FROM, FilterType.MENTIONS});
    }

    public int hashCode() {
        String str = this.userName;
        return ((str != null ? str.hashCode() : 0) * 31) + this.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return searchData.getUserId(this.userName, this.discriminator) != null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserNode(userName=");
        sbU.append(this.userName);
        sbU.append(", discriminator=");
        return outline.B(sbU, this.discriminator, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        String str;
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
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
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        return sb.toString();
    }
}
