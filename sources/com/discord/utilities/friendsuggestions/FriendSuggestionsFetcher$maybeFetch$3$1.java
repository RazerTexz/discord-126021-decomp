package com.discord.utilities.friendsuggestions;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher$maybeFetch$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ FriendSuggestionsFetcher$maybeFetch$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendSuggestionsFetcher$maybeFetch$3$1(FriendSuggestionsFetcher$maybeFetch$3 friendSuggestionsFetcher$maybeFetch$3) {
        super(0);
        this.this$0 = friendSuggestionsFetcher$maybeFetch$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FriendSuggestionsFetcher.access$getOnFetchFailure$p(this.this$0.this$0).invoke();
    }
}
