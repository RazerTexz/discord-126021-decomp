package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.validation.SearchData;
import java.util.Arrays;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(str, "userName");
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
        C12238m.checkNotNullParameter(userName, "userName");
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
        return C12238m.areEqual(this.userName, userNode.userName) && this.discriminator == userNode.discriminator;
    }

    public final String getUserName() {
        return this.userName;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return C12148n0.setOf((Object[]) new FilterType[]{FilterType.FROM, FilterType.MENTIONS});
    }

    public int hashCode() {
        String str = this.userName;
        return ((str != null ? str.hashCode() : 0) * 31) + this.discriminator;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        C12238m.checkNotNullParameter(searchData, "searchData");
        return searchData.getUserId(this.userName, this.discriminator) != null;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("UserNode(userName=");
        sbM833U.append(this.userName);
        sbM833U.append(", discriminator=");
        return C1643a.m814B(sbM833U, this.discriminator, ")");
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        String str;
        C12238m.checkNotNullParameter(queryBuilder, "queryBuilder");
        C12238m.checkNotNullParameter(searchData, "searchData");
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
        C12238m.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        sb.append(str);
        return sb.toString();
    }
}
