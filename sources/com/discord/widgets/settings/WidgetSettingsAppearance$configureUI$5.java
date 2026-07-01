package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$configureUI$5 implements View$OnClickListener {
    public static final WidgetSettingsAppearance$configureUI$5 INSTANCE = new WidgetSettingsAppearance$configureUI$5();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getUserSettingsSystem().setFontScale(-1);
    }
}
