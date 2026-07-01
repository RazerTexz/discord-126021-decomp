package com.discord.widgets.friends;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel$removeFriendRequest$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ int $successMessageStringRes;
    public final /* synthetic */ FriendsListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendsListViewModel$removeFriendRequest$1(FriendsListViewModel friendsListViewModel, int i) {
        super(1);
        this.this$0 = friendsListViewModel;
        this.$successMessageStringRes = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        FriendsListViewModel.access$emitShowToastEvent(this.this$0, this.$successMessageStringRes);
    }
}
