package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestion;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$friendSuggestions$1 extends C12236k implements Function1<List<? extends FriendSuggestion>, Unit> {
    public StoreStream$friendSuggestions$1(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFriendSuggestionsFetched", "handleFriendSuggestionsFetched(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends FriendSuggestion> list) {
        invoke2((List<FriendSuggestion>) list);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<FriendSuggestion> list) {
        C12238m.checkNotNullParameter(list, "p1");
        ((StoreStream) this.receiver).handleFriendSuggestionsFetched(list);
    }
}
