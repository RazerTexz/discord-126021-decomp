package com.discord.widgets.user.profile;

import com.discord.widgets.user.Badge;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderView$onBadgeClick$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView6 extends Lambda implements Function1<Badge, Unit> {
    public static final UserProfileHeaderView6 INSTANCE = new UserProfileHeaderView6();

    public UserProfileHeaderView6() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        Intrinsics3.checkNotNullParameter(badge, "it");
    }
}
