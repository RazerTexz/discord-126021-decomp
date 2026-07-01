package com.discord.widgets.settings.premium;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$onViewBound$1 implements View$OnClickListener {
    public static final WidgetSettingsGifting$onViewBound$1 INSTANCE = new WidgetSettingsGifting$onViewBound$1();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getEntitlements().fetchMyGiftEntitlements();
    }
}
