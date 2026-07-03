package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: HasNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasNode extends AnswerNode {
    private final HasAnswerOption hasAnswerOption;
    private final CharSequence text;

    public HasNode(HasAnswerOption hasAnswerOption, CharSequence charSequence) {
        C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.hasAnswerOption = hasAnswerOption;
        this.text = charSequence;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    private final HasAnswerOption getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public static /* synthetic */ HasNode copy$default(HasNode hasNode, HasAnswerOption hasAnswerOption, CharSequence charSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            hasAnswerOption = hasNode.hasAnswerOption;
        }
        if ((i & 2) != 0) {
            charSequence = hasNode.getText();
        }
        return hasNode.copy(hasAnswerOption, charSequence);
    }

    public final CharSequence component2() {
        return getText();
    }

    public final HasNode copy(HasAnswerOption hasAnswerOption, CharSequence text) {
        C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        C12238m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
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
        return C12238m.areEqual(this.hasAnswerOption, hasNode.hasAnswerOption) && C12238m.areEqual(getText(), hasNode.getText());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return C12146m0.setOf(FilterType.HAS);
    }

    public int hashCode() {
        HasAnswerOption hasAnswerOption = this.hasAnswerOption;
        int iHashCode = (hasAnswerOption != null ? hasAnswerOption.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        C12238m.checkNotNullParameter(searchData, "searchData");
        return true;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("HasNode(hasAnswerOption=");
        sbM833U.append(this.hasAnswerOption);
        sbM833U.append(", text=");
        sbM833U.append(getText());
        sbM833U.append(")");
        return sbM833U.toString();
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType) {
        C12238m.checkNotNullParameter(queryBuilder, "queryBuilder");
        C12238m.checkNotNullParameter(searchData, "searchData");
        if (C12163u.contains(getValidFilters(), filterType)) {
            queryBuilder.appendParam("has", this.hasAnswerOption.getRestParamValue());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HasNode(String str, SearchStringProvider searchStringProvider) {
        this(HasAnswerOption.INSTANCE.getOptionFromString(str, searchStringProvider), str);
        C12238m.checkNotNullParameter(str, "match");
        C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
    }
}
