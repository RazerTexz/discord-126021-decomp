package com.discord.utilities.search.suggestion.entries;

import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.g0.w;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HasSuggestion.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HasSuggestion$Companion {
    private HasSuggestion$Companion() {
    }

    public final boolean canComplete(CharSequence currentInput, HasAnswerOption hasAnswerOption, SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(currentInput, "currentInput");
        m.checkNotNullParameter(hasAnswerOption, "hasAnswerOption");
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        return w.contains$default((CharSequence) hasAnswerOption.getLocalizedInputText(searchStringProvider), currentInput, false, 2, (Object) null);
    }

    public /* synthetic */ HasSuggestion$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
