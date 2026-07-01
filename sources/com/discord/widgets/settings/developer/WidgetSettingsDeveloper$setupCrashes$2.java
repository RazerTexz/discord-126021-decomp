package com.discord.widgets.settings.developer;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.m;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupCrashes$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetSettingsDeveloper this$0;

    public WidgetSettingsDeveloper$setupCrashes$2(WidgetSettingsDeveloper widgetSettingsDeveloper) {
        this.this$0 = widgetSettingsDeveloper;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        try {
            throw new RuntimeException("This is a developer triggered crash (caught).");
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "setupCrashes", e, null, 4, null);
            m.j(this.this$0, "Done.", 0, 4);
        }
    }
}
