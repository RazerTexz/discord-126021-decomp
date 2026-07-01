package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: compiled from: HasNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasNode extends AnswerNode {
    private final HasNode2 hasAnswerOption;
    private final CharSequence text;

    public HasNode(HasNode2 hasNode2, CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.hasAnswerOption = hasNode2;
        this.text = charSequence;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public static /* synthetic */ HasNode copy$default(HasNode hasNode, HasNode2 hasNode2, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            hasNode2 = hasNode.hasAnswerOption;
        }
        if ((i & 2) != 0) {
            charSequence = hasNode.getText();
        }
        return hasNode.copy(hasNode2, charSequence);
    }

    public final CharSequence component2() {
        return getText();
    }

    public final HasNode copy(HasNode2 hasAnswerOption, CharSequence text) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new HasNode(hasAnswerOption, text);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HasNode)) {
            return false;
        }
        HasNode hasNode = (HasNode) other;
        return Intrinsics3.areEqual(this.hasAnswerOption, hasNode.hasAnswerOption) && Intrinsics3.areEqual(getText(), hasNode.getText());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return SetsJVM.setOf(FilterType.HAS);
    }

    public int hashCode() {
        HasNode2 hasNode2 = this.hasAnswerOption;
        int iHashCode = (hasNode2 != null ? hasNode2.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        return true;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HasNode(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(", text=");
        sbU.append(getText());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        Intrinsics3.checkNotNullParameter(queryBuilder, "queryBuilder");
        Intrinsics3.checkNotNullParameter(searchData, "searchData");
        if (_Collections.contains(getValidFilters(), filterType)) {
            queryBuilder.appendParam("has", this.hasAnswerOption.getRestParamValue());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HasNode(String str, SearchStringProvider searchStringProvider) {
        this(HasNode2.INSTANCE.getOptionFromString(str, searchStringProvider), str);
        Intrinsics3.checkNotNullParameter(str, "match");
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
    }
}
