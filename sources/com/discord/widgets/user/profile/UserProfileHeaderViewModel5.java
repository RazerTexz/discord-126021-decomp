package com.discord.widgets.user.profile;

import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$ViewState$Loaded$avatarColorId$2, reason: use source file name */
/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel5 extends Lambda implements Function0<String> {
    public final /* synthetic */ UserProfileHeaderViewModel.ViewState.Loaded this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel5(UserProfileHeaderViewModel.ViewState.Loaded loaded) {
        super(0);
        this.this$0 = loaded;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return RepresentativeColors2.getColorId(this.this$0.getUser());
    }
}
