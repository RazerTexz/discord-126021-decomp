package com.discord.widgets.friends;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$acceptFriendRequest$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ FriendsListViewModel$acceptFriendRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$acceptFriendRequest$2$1(FriendsListViewModel$acceptFriendRequest$2 friendsListViewModel$acceptFriendRequest$2, Error error) {
        super(0);
        this.this$0 = friendsListViewModel$acceptFriendRequest$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FriendsListViewModel friendsListViewModel = this.this$0.this$0;
        Error$Response response = this.$error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        FriendsListViewModel.access$emitShowFriendRequestAbortToast(friendsListViewModel, response.getCode(), this.this$0.$username);
    }
}
