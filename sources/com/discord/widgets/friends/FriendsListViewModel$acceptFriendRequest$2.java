package com.discord.widgets.friends;

import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPIAbortMessages;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$acceptFriendRequest$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ String $username;
    public final /* synthetic */ FriendsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$acceptFriendRequest$2(FriendsListViewModel friendsListViewModel, String str) {
        super(1);
        this.this$0 = friendsListViewModel;
        this.$username = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        RestAPIAbortMessages.INSTANCE.handleAbortCodeOrDefault(error, new FriendsListViewModel$acceptFriendRequest$2$1(this, error), new FriendsListViewModel$acceptFriendRequest$2$2(this));
    }
}
