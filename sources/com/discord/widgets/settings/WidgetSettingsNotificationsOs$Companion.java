package com.discord.widgets.settings;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsNotificationsOs.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsNotificationsOs$Companion {
    private WidgetSettingsNotificationsOs$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new WidgetSettingsNotificationsOs().show(fragmentManager, "javaClass");
    }

    public /* synthetic */ WidgetSettingsNotificationsOs$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
