package com.discord.widgets.settings;

import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$viewModelUserProfileHeader$2 extends Lambda implements Function0<UserProfileHeaderViewModel> {
    public static final WidgetSettings$viewModelUserProfileHeader$2 INSTANCE = new WidgetSettings$viewModelUserProfileHeader$2();

    public WidgetSettings$viewModelUserProfileHeader$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UserProfileHeaderViewModel invoke() {
        return new UserProfileHeaderViewModel(-1L, null, null, null, true, null, null, 110, null);
    }
}
