package com.discord.widgets.voice.call;

import android.content.Context;
import com.discord.utilities.captcha.CaptchaErrorBody;
import com.discord.utilities.captcha.CaptchaErrorBody$Companion;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.rest.RestAPIAbortMessages$ResponseResolver;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet;
import com.discord.widgets.captcha.WidgetCaptchaBottomSheet$Companion;
import com.discord.widgets.captcha.WidgetCaptchaKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$sendFriendRequest$2$1 extends o implements Function0<Unit> {
    public final /* synthetic */ Error $error;
    public final /* synthetic */ WidgetCallFailed$sendFriendRequest$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFailed$sendFriendRequest$2$1(WidgetCallFailed$sendFriendRequest$2 widgetCallFailed$sendFriendRequest$2, Error error) {
        super(0);
        this.this$0 = widgetCallFailed$sendFriendRequest$2;
        this.$error = error;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Error error = this.$error;
        m.checkNotNullExpressionValue(error, "error");
        if (WidgetCaptchaKt.isCaptchaError(error)) {
            WidgetCaptchaBottomSheet$Companion widgetCaptchaBottomSheet$Companion = WidgetCaptchaBottomSheet.Companion;
            WidgetCallFailed$sendFriendRequest$2$1$1 widgetCallFailed$sendFriendRequest$2$1$1 = new WidgetCallFailed$sendFriendRequest$2$1$1(this);
            CaptchaErrorBody$Companion captchaErrorBody$Companion = CaptchaErrorBody.Companion;
            Error error2 = this.$error;
            m.checkNotNullExpressionValue(error2, "error");
            WidgetCaptchaBottomSheet$Companion.enqueue$default(widgetCaptchaBottomSheet$Companion, "Add Friend Captcha", widgetCallFailed$sendFriendRequest$2$1$1, null, captchaErrorBody$Companion.createFromError(error2), 4, null);
            return;
        }
        RestAPIAbortMessages$ResponseResolver restAPIAbortMessages$ResponseResolver = RestAPIAbortMessages$ResponseResolver.INSTANCE;
        Context context = this.this$0.this$0.getContext();
        Error error3 = this.$error;
        m.checkNotNullExpressionValue(error3, "error");
        Error$Response response = error3.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        b.a.d.m.h(this.this$0.this$0.getContext(), restAPIAbortMessages$ResponseResolver.getRelationshipResponse(context, response.getCode(), this.this$0.$username), 0, null, 12);
    }
}
