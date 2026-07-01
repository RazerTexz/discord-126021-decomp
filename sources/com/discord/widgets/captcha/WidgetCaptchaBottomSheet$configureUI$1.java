package com.discord.widgets.captcha;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCaptchaBottomSheet this$0;

    public WidgetCaptchaBottomSheet$configureUI$1(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        this.this$0 = widgetCaptchaBottomSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCaptchaBottomSheet.access$openCaptcha(this.this$0);
    }
}
