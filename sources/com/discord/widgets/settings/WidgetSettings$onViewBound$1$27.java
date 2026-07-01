package com.discord.widgets.settings;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$1$27 implements View$OnClickListener {
    public static final WidgetSettings$onViewBound$1$27 INSTANCE = new WidgetSettings$onViewBound$1$27();

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getNotificationUpsells().dismissPushNotificationsUpsell();
    }
}
