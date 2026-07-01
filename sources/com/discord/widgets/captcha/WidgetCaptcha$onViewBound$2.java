package com.discord.widgets.captcha;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.captcha.CaptchaHelper;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptcha$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetCaptcha this$0;

    public WidgetCaptcha$onViewBound$2(WidgetCaptcha widgetCaptcha) {
        this.this$0 = widgetCaptcha;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CaptchaHelper.INSTANCE.showCaptchaHelpDialog(this.this$0.getAppActivity(), new WidgetCaptcha$onViewBound$2$1(this));
    }
}
