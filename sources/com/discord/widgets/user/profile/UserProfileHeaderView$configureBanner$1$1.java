package com.discord.widgets.user.profile;

import android.graphics.Bitmap;
import b.f.j.q.a;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$configureBanner$1$1 extends a {
    public final /* synthetic */ UserProfileHeaderView$configureBanner$1 this$0;

    public UserProfileHeaderView$configureBanner$1$1(UserProfileHeaderView$configureBanner$1 userProfileHeaderView$configureBanner$1) {
        this.this$0 = userProfileHeaderView$configureBanner$1;
    }

    @Override // b.f.j.q.a
    public void process(Bitmap bitmap) {
        if (bitmap != null) {
            UserProfileHeaderView$configureBanner$1 userProfileHeaderView$configureBanner$1 = this.this$0;
            if (userProfileHeaderView$configureBanner$1.$bannerColorUpdatedFromViewState.element) {
                return;
            }
            userProfileHeaderView$configureBanner$1.this$0.updateBannerColor(userProfileHeaderView$configureBanner$1.$viewState);
        }
    }
}
