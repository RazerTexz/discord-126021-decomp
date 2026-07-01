package com.discord.widgets.settings.developer;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupCrashes$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsDeveloper this$0;

    public WidgetSettingsDeveloper$setupCrashes$4(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        this.this$0 = widgetSettingsDeveloper;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getGatewaySocket().simulateReconnectForTesting();
        m.j(this.this$0, "Done.", 0, 4);
    }
}
