package com.discord.widgets.notice;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.widgets.settings.WidgetSettingsVoice;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetNoticeNuxOverlay this$0;

    public WidgetNoticeNuxOverlay$onViewBound$1(WidgetNoticeNuxOverlay widgetNoticeNuxOverlay) {
        this.this$0 = widgetNoticeNuxOverlay;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetSettingsVoice.Companion.launch(a.x(view, "it", "it.context"), Integer.valueOf(R$id.settings_voice_overlay_toggle), true);
        this.this$0.dismiss();
    }
}
