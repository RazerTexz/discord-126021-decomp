package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1 extends AbstractC12240o implements Function1<User, Unit> {
    public static final WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1 INSTANCE = new WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1();

    public WidgetSettingsBlockedUsersAdapter$onClickUserProfile$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        C12238m.checkNotNullParameter(user, "it");
    }
}
