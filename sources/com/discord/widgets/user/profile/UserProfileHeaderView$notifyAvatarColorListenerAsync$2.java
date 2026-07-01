package com.discord.widgets.user.profile;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$notifyAvatarColorListenerAsync$2 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ UserProfileHeaderView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderView$notifyAvatarColorListenerAsync$2(UserProfileHeaderView userProfileHeaderView) {
        super(1);
        this.this$0 = userProfileHeaderView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        if (num != null) {
            this.this$0.getOnAvatarRepresentativeColorUpdated().invoke(num);
        }
    }
}
