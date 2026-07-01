package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount$Companion {
    private WidgetSettingsAccount$Companion() {
    }

    public static /* synthetic */ void launch$default(WidgetSettingsAccount$Companion widgetSettingsAccount$Companion, Context context, boolean z2, WidgetSettingsAccount$Redirect widgetSettingsAccount$Redirect, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            widgetSettingsAccount$Redirect = null;
        }
        widgetSettingsAccount$Companion.launch(context, z2, widgetSettingsAccount$Redirect);
    }

    public final void launch(Context context) {
        launch$default(this, context, false, null, 6, null);
    }

    public final void launch(Context context, boolean z2) {
        launch$default(this, context, z2, null, 4, null);
    }

    public final void launch(Context context, boolean hintDataManagement, WidgetSettingsAccount$Redirect redirect) {
        m.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("com.discord.extra.HINT_DATA_MANAGEMENT", hintDataManagement);
        intent.putExtra("extra_redirect", redirect);
        if (redirect != null) {
            intent.addFlags(268435456);
            intent.addFlags(67108864);
        }
        j.d(context, WidgetSettingsAccount.class, intent);
    }

    public /* synthetic */ WidgetSettingsAccount$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
