package com.discord.widgets.settings.developer;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupCrashes$1 implements View$OnClickListener {
    public static final WidgetSettingsDeveloper$setupCrashes$1 INSTANCE = new WidgetSettingsDeveloper$setupCrashes$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        throw new RuntimeException("This is a developer triggered crash.");
    }
}
