package com.discord.utilities.search.suggestion.entries;

import b.d.b.a.outline;
import com.discord.utilities.search.query.node.answer.HasNode2;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HasSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HasSuggestion implements SearchSuggestion {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final HasNode2 hasAnswerOption;

    /* JADX INFO: compiled from: HasSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(CharSequence currentInput, HasNode2 hasAnswerOption, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(currentInput, "currentInput");
            Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            return Strings4.contains$default((CharSequence) hasAnswerOption.getLocalizedInputText(searchStringProvider), currentInput, false, 2, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public HasSuggestion(HasNode2 hasNode2) {
        Intrinsics3.checkNotNullParameter(hasNode2, "hasAnswerOption");
        this.hasAnswerOption = hasNode2;
        this.category = SearchSuggestion.Category.HAS;
    }

    public static /* synthetic */ HasSuggestion copy$default(HasSuggestion hasSuggestion, HasNode2 hasNode2, int i, Object obj) {
        if ((i & 1) != 0) {
            hasNode2 = hasSuggestion.hasAnswerOption;
        }
        return hasSuggestion.copy(hasNode2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public final HasSuggestion copy(HasNode2 hasAnswerOption) {
        Intrinsics3.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        return new HasSuggestion(hasAnswerOption);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HasSuggestion) && Intrinsics3.areEqual(this.hasAnswerOption, ((HasSuggestion) other).hasAnswerOption);
        }
        return true;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final HasNode2 getHasAnswerOption() {
        return this.hasAnswerOption;
    }

    public int hashCode() {
        HasNode2 hasNode2 = this.hasAnswerOption;
        if (hasNode2 != null) {
            return hasNode2.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = outline.U("HasSuggestion(hasAnswerOption=");
        sbU.append(this.hasAnswerOption);
        sbU.append(")");
        return sbU.toString();
    }
}
