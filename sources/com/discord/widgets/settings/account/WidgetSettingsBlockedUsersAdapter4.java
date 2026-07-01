package com.discord.widgets.settings.account;

import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsersAdapter$onClickUnblock$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBlockedUsersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsersAdapter4 extends Lambda implements Function1<User, Unit> {
    public static final WidgetSettingsBlockedUsersAdapter4 INSTANCE = new WidgetSettingsBlockedUsersAdapter4();

    public WidgetSettingsBlockedUsersAdapter4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(User user) {
        invoke2(user);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(User user) {
        Intrinsics3.checkNotNullParameter(user, "it");
    }
}
