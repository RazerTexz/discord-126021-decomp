package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestionDelete;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$71 extends k implements Function1<FriendSuggestionDelete, Unit> {
    public StoreStream$initGatewaySocketListeners$71(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFriendSuggestionDelete", "handleFriendSuggestionDelete(Lcom/discord/api/friendsuggestions/FriendSuggestionDelete;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestionDelete friendSuggestionDelete) {
        invoke2(friendSuggestionDelete);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendSuggestionDelete friendSuggestionDelete) {
        m.checkNotNullParameter(friendSuggestionDelete, "p1");
        ((StoreStream) this.receiver).handleFriendSuggestionDelete(friendSuggestionDelete);
    }
}
