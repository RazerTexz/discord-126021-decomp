package com.discord.widgets.user.profile;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserProfileHeaderView$Companion$bind$1 extends k implements Function1<UserProfileHeaderViewModel$ViewState$Loaded, Unit> {
    public UserProfileHeaderView$Companion$bind$1(UserProfileHeaderView userProfileHeaderView) {
        super(1, userProfileHeaderView, UserProfileHeaderView.class, "updateViewState", "updateViewState(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        invoke2(userProfileHeaderViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(userProfileHeaderViewModel$ViewState$Loaded, "p1");
        ((UserProfileHeaderView) this.receiver).updateViewState(userProfileHeaderViewModel$ViewState$Loaded);
    }
}
