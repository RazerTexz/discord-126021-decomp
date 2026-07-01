package com.discord.stores;

import com.discord.api.friendsuggestions.FriendSuggestion;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreStream.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreStream$initGatewaySocketListeners$70 extends k implements Function1<FriendSuggestion, Unit> {
    public StoreStream$initGatewaySocketListeners$70(StoreStream storeStream) {
        super(1, storeStream, StoreStream.class, "handleFriendSuggestionCreate", "handleFriendSuggestionCreate(Lcom/discord/api/friendsuggestions/FriendSuggestion;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FriendSuggestion friendSuggestion) {
        invoke2(friendSuggestion);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FriendSuggestion friendSuggestion) {
        m.checkNotNullParameter(friendSuggestion, "p1");
        ((StoreStream) this.receiver).handleFriendSuggestionCreate(friendSuggestion);
    }
}
