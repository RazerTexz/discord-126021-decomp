package com.discord.utilities.friendsuggestions;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher$maybeFetch$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ FriendSuggestionsFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendSuggestionsFetcher$maybeFetch$3(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        super(1);
        this.this$0 = friendSuggestionsFetcher;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        FriendSuggestionsFetcher.access$getDispatcher$p(this.this$0).schedule(new FriendSuggestionsFetcher$maybeFetch$3$1(this));
    }
}
