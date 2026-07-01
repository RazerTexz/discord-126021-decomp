package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.a;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import d0.z.d.m;

/* JADX INFO: compiled from: HasSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasSuggestion implements SearchSuggestion {
    public static final HasSuggestion$Companion Companion = new HasSuggestion$Companion(null);
    private final SearchSuggestion$Category category;
    private final HasAnswerOption hasAnswerOption;

    public HasSuggestion(HasAnswerOption hasAnswerOption) {
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        this.hasAnswerOption = hasAnswerOption;
        this.category = SearchSuggestion$Category.HAS;
    }

    public static /* synthetic */ HasSuggestion copy$default(HasSuggestion hasSuggestion, HasAnswerOption hasAnswerOption, int i, Object obj) {
        if ((i & 1) != 0) {
            hasAnswerOption = hasSuggestion.hasAnswerOption;
        }
        return hasSuggestion.copy(hasAnswerOption);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HasAnswerOption getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public final HasSuggestion copy(HasAnswerOption hasAnswerOption) {
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        return new HasSuggestion(hasAnswerOption);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HasSuggestion) && m.areEqual(this.hasAnswerOption, ((HasSuggestion) other).hasAnswerOption);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion$Category getCategory() {
        return this.category;
    }

    public final HasAnswerOption getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public int hashCode() {
        HasAnswerOption hasAnswerOption = this.hasAnswerOption;
        if (hasAnswerOption != null) {
            return hasAnswerOption.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("HasSuggestion(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(")");
        return sbU.toString();
    }
}
