package com.discord.widgets.user.profile;

import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$Companion$bind$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserProfileHeaderView3 extends FunctionReferenceImpl implements Function1<UserProfileHeaderViewModel.ViewState.Loaded, Unit> {
    public UserProfileHeaderView3(UserProfileHeaderView userProfileHeaderView) {
        super(1, userProfileHeaderView, UserProfileHeaderView.class, "updateViewState", "updateViewState(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        invoke2(loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        Intrinsics3.checkNotNullParameter(loaded, "p1");
        ((UserProfileHeaderView) this.receiver).updateViewState(loaded);
    }
}
