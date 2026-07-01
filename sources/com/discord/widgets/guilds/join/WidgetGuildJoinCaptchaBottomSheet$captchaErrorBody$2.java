package com.discord.widgets.guilds.join;

import com.discord.utilities.captcha.CaptchaErrorBody;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$captchaErrorBody$2 extends Lambda implements Function0<CaptchaErrorBody> {
    public final /* synthetic */ WidgetGuildJoinCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$captchaErrorBody$2(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        super(0);
        this.this$0 = widgetGuildJoinCaptchaBottomSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CaptchaErrorBody invoke() {
        Serializable serializable = this.this$0.getArgumentsOrDefault().getSerializable("INTENT_EXTRA_CAPTCHA_ERROR_BODY");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.utilities.captcha.CaptchaErrorBody");
        return (CaptchaErrorBody) serializable;
    }
}
