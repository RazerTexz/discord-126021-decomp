package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter$onClickUnblock$1 extends o implements Function1<User, Unit> {
    public static final WidgetSettingsBlockedUsersAdapter$onClickUnblock$1 INSTANCE = new WidgetSettingsBlockedUsersAdapter$onClickUnblock$1();

    public WidgetSettingsBlockedUsersAdapter$onClickUnblock$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        m.checkNotNullParameter(user, "it");
    }
}
