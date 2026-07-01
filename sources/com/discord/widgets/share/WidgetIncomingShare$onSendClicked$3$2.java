package com.discord.widgets.share;

import com.discord.app.AppFragment;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onSendClicked$3$2 extends o implements Function2<AppFragment, CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetIncomingShare$onSendClicked$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onSendClicked$3$2(WidgetIncomingShare$onSendClicked$3 widgetIncomingShare$onSendClicked$3) {
        super(2);
        this.this$0 = widgetIncomingShare$onSendClicked$3;
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
        WidgetIncomingShare$onSendClicked$3 widgetIncomingShare$onSendClicked$3 = this.this$0;
        WidgetIncomingShare.access$onSendClicked(widgetIncomingShare$onSendClicked$3.this$0, widgetIncomingShare$onSendClicked$3.$context, widgetIncomingShare$onSendClicked$3.$receiver, widgetIncomingShare$onSendClicked$3.$gameInviteModel, widgetIncomingShare$onSendClicked$3.$contentModel, widgetIncomingShare$onSendClicked$3.$isOnCooldown, widgetIncomingShare$onSendClicked$3.$maxFileSizeMB, widgetIncomingShare$onSendClicked$3.$isUserPremium, captchaHelper$CaptchaPayload);
    }
}
