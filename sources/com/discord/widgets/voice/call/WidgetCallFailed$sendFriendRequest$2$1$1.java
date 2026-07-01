package com.discord.widgets.voice.call;

import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetCallFailed.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFailed$sendFriendRequest$2$1$1 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetCallFailed$sendFriendRequest$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFailed$sendFriendRequest$2$1$1(WidgetCallFailed$sendFriendRequest$2$1 widgetCallFailed$sendFriendRequest$2$1) {
        super(2);
        this.this$0 = widgetCallFailed$sendFriendRequest$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(appFragment, captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppFragment appFragment, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        m.checkNotNullParameter(appFragment, "<anonymous parameter 0>");
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "captchaPayload");
        WidgetCallFailed$sendFriendRequest$2 widgetCallFailed$sendFriendRequest$2 = this.this$0.this$0;
        WidgetCallFailed.access$sendFriendRequest(widgetCallFailed$sendFriendRequest$2.this$0, widgetCallFailed$sendFriendRequest$2.$userId, widgetCallFailed$sendFriendRequest$2.$username, captchaHelper$CaptchaPayload);
    }
}
