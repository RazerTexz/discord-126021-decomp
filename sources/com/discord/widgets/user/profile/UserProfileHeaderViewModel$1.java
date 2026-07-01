package com.discord.widgets.user.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel$1 extends o implements Function1<UserProfileHeaderViewModel$StoreState, Unit> {
    public final /* synthetic */ UserProfileHeaderViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel$1(UserProfileHeaderViewModel userProfileHeaderViewModel) {
        super(1);
        this.this$0 = userProfileHeaderViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfileHeaderViewModel$StoreState userProfileHeaderViewModel$StoreState) {
        invoke2(userProfileHeaderViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileHeaderViewModel$StoreState userProfileHeaderViewModel$StoreState) {
        m.checkNotNullParameter(userProfileHeaderViewModel$StoreState, "storeState");
        UserProfileHeaderViewModel.access$handleStoreState(this.this$0, userProfileHeaderViewModel$StoreState);
    }
}
