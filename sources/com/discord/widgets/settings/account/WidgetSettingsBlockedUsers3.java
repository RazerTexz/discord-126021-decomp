package com.discord.widgets.settings.account;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers3 extends Lambda implements Function0<WidgetSettingsBlockedUsersViewModel> {
    public static final WidgetSettingsBlockedUsers3 INSTANCE = new WidgetSettingsBlockedUsers3();

    public WidgetSettingsBlockedUsers3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetSettingsBlockedUsersViewModel invoke() {
        return new WidgetSettingsBlockedUsersViewModel(null, null, 3, null);
    }
}
