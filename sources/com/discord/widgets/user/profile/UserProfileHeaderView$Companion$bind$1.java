package com.discord.widgets.user.profile;

import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class UserProfileHeaderView$Companion$bind$1 extends C12236k implements Function1<UserProfileHeaderViewModel.ViewState.Loaded, Unit> {
    public UserProfileHeaderView$Companion$bind$1(UserProfileHeaderView userProfileHeaderView) {
        super(1, userProfileHeaderView, UserProfileHeaderView.class, "updateViewState", "updateViewState(Lcom/discord/widgets/user/profile/UserProfileHeaderViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        invoke2(loaded);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        C12238m.checkNotNullParameter(loaded, "p1");
        ((UserProfileHeaderView) this.receiver).updateViewState(loaded);
    }
}
