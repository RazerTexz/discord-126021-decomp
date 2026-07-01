package com.discord.utilities.search.suggestion;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchSuggestionEngine.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class SearchSuggestionEngine$setupMemberRequestSubscription$2 extends k implements Function1<CharSequence, Boolean> {
    public static final SearchSuggestionEngine$setupMemberRequestSubscription$2 INSTANCE = new SearchSuggestionEngine$setupMemberRequestSubscription$2();

    public SearchSuggestionEngine$setupMemberRequestSubscription$2() {
        super(1, d0.g0.k.class, "isNotEmpty", "isNotEmpty(Ljava/lang/CharSequence;)Z", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence) {
        return Boolean.valueOf(invoke((String) charSequence));
    }

    public final boolean invoke(String str) {
        m.checkNotNullParameter(str, "p1");
        return str.length() > 0;
    }
}
