package com.discord.widgets.captcha;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaRequest;
import com.discord.utilities.rx.ObservableExtensionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCaptcha.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptcha$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ CaptchaHelper$CaptchaRequest $captchaRequest;
    public final /* synthetic */ WidgetCaptcha this$0;

    public WidgetCaptcha$onViewBound$1(WidgetCaptcha widgetCaptcha, CaptchaHelper$CaptchaRequest captchaHelper$CaptchaRequest) {
        this.this$0 = widgetCaptcha;
        this.$captchaRequest = captchaHelper$CaptchaRequest;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.appSubscribe$default(CaptchaHelper.INSTANCE.tryShowCaptcha(this.$captchaRequest), this.this$0.getClass(), (Context) null, (Function1) null, new WidgetCaptcha$onViewBound$1$2(this), (Function0) null, (Function0) null, new WidgetCaptcha$onViewBound$1$1(this), 54, (Object) null);
    }
}
