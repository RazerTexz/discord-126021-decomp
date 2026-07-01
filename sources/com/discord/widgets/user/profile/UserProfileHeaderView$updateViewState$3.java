package com.discord.widgets.user.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$updateViewState$3 implements View$OnClickListener {
    public final /* synthetic */ UserProfileHeaderViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ UserProfileHeaderView this$0;

    public UserProfileHeaderView$updateViewState$3(UserProfileHeaderView userProfileHeaderView, UserProfileHeaderViewModel$ViewState$Loaded userProfileHeaderViewModel$ViewState$Loaded) {
        this.this$0 = userProfileHeaderView;
        this.$viewState = userProfileHeaderViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        UserProfileHeaderView.access$editAvatar(this.this$0, this.$viewState);
    }
}
