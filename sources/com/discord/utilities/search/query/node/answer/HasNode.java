package com.discord.utilities.search.query.node.answer;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.utilities.search.network.SearchQuery$Builder;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.validation.SearchData;
import d0.t.m0;
import d0.t.u;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: HasNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasNode extends AnswerNode {
    private final HasAnswerOption hasAnswerOption;
    private final CharSequence text;

    public HasNode(HasAnswerOption hasAnswerOption, CharSequence charSequence) {
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        m.checkNotNullParameter(charSequence, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
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
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
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
        return m.areEqual(this.hasAnswerOption, hasNode.hasAnswerOption) && m.areEqual(getText(), hasNode.getText());
    }

    @Override // com.discord.utilities.search.query.node.QueryNode
    public CharSequence getText() {
        return this.text;
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public Set<FilterType> getValidFilters() {
        return m0.setOf(FilterType.HAS);
    }

    public int hashCode() {
        HasAnswerOption hasAnswerOption = this.hasAnswerOption;
        int iHashCode = (hasAnswerOption != null ? hasAnswerOption.hashCode() : 0) * 31;
        CharSequence text = getText();
        return iHashCode + (text != null ? text.hashCode() : 0);
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public boolean isValid(SearchData searchData) {
        m.checkNotNullParameter(searchData, "searchData");
        return true;
    }

    public String toString() {
        StringBuilder sbU = a.U("HasNode(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(", text=");
        sbU.append(getText());
        sbU.append(")");
        return sbU.toString();
    }

    @Override // com.discord.utilities.search.query.node.answer.AnswerNode
    public void updateQuery(SearchQuery$Builder queryBuilder, SearchData searchData, FilterType filterType) {
        m.checkNotNullParameter(queryBuilder, "queryBuilder");
        m.checkNotNullParameter(searchData, "searchData");
        if (u.contains(getValidFilters(), filterType)) {
            queryBuilder.appendParam("has", this.hasAnswerOption.getRestParamValue());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HasNode(String str, SearchStringProvider searchStringProvider) {
        this(HasAnswerOption.Companion.getOptionFromString(str, searchStringProvider), str);
        m.checkNotNullParameter(str, "match");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
    }
}
