package com.discord.widgets.guilds.join;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$requestCode$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetGuildJoinCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$requestCode$2(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetGuildJoinCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
