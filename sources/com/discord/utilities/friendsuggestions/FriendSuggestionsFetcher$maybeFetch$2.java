package com.discord.utilities.friendsuggestions;

import com.discord.api.friendsuggestions.FriendSuggestion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendSuggestionsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendSuggestionsFetcher$maybeFetch$2 extends o implements Function1<List<? extends FriendSuggestion>, Unit> {
    public final /* synthetic */ FriendSuggestionsFetcher this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendSuggestionsFetcher$maybeFetch$2(FriendSuggestionsFetcher friendSuggestionsFetcher) {
        super(1);
        this.this$0 = friendSuggestionsFetcher;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
        invoke2((List<FriendSuggestion>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<FriendSuggestion> list) {
        m.checkNotNullParameter(list, "response");
        FriendSuggestionsFetcher.access$getDispatcher$p(this.this$0).schedule(new FriendSuggestionsFetcher$maybeFetch$2$1(this, list));
    }
}
