package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestion;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$friendSuggestions$1 extends FunctionReferenceImpl implements Function1<List<? extends FriendSuggestion>, Unit> {
    public StoreStream$friendSuggestions$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFriendSuggestionsFetched", "handleFriendSuggestionsFetched(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
        invoke2((List<FriendSuggestion>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<FriendSuggestion> list) {
        Intrinsics3.checkNotNullParameter(list, "p1");
        ((StoreStream) this.receiver).handleFriendSuggestionsFetched(list);
    }
}
