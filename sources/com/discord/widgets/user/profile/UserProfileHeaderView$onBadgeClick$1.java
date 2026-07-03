package com.discord.widgets.user.profile;

import com.discord.widgets.user.Badge;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserProfileHeaderView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderView$onBadgeClick$1 extends AbstractC12240o implements Function1<Badge, Unit> {
    public static final UserProfileHeaderView$onBadgeClick$1 INSTANCE = new UserProfileHeaderView$onBadgeClick$1();

    public UserProfileHeaderView$onBadgeClick$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        C12238m.checkNotNullParameter(badge, "it");
    }
}
