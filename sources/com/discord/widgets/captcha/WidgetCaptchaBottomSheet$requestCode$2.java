package com.discord.widgets.captcha;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCaptchaBottomSheet$requestCode$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCaptchaBottomSheet$requestCode$2(WidgetCaptchaBottomSheet widgetCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
