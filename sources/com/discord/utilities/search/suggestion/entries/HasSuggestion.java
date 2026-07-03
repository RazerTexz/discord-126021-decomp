package com.discord.utilities.search.suggestion.entries;

import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: HasSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasSuggestion implements SearchSuggestion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final HasAnswerOption hasAnswerOption;

    /* JADX INFO: compiled from: HasSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(CharSequence currentInput, HasAnswerOption hasAnswerOption, SearchStringProvider searchStringProvider) {
            C12238m.checkNotNullParameter(currentInput, "currentInput");
            C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
            C12238m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            return C12106w.contains$default((CharSequence) hasAnswerOption.getLocalizedInputText(searchStringProvider), currentInput, false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HasSuggestion(HasAnswerOption hasAnswerOption) {
        C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        this.hasAnswerOption = hasAnswerOption;
        this.category = SearchSuggestion.Category.HAS;
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
        C12238m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        return new HasSuggestion(hasAnswerOption);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HasSuggestion) && C12238m.areEqual(this.hasAnswerOption, ((HasSuggestion) other).hasAnswerOption);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
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
        StringBuilder sbM833U = C1643a.m833U("HasSuggestion(hasAnswerOption=");
        sbM833U.append(this.hasAnswerOption);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
