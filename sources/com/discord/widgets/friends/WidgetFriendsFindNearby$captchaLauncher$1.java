package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$captchaLauncher$1 extends o implements Function1<CaptchaHelper$CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby$captchaLauncher$1(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        invoke2(captchaHelper$CaptchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        Integer discriminator;
        m.checkNotNullParameter(captchaHelper$CaptchaPayload, "token");
        String username = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getUsername();
        if (username == null || (discriminator = WidgetFriendsFindNearby.access$getViewModel$p(this.this$0).getDiscriminator()) == null) {
            return;
        }
        WidgetFriendsFindNearby.access$sendFriendRequest(this.this$0, username, discriminator.intValue(), captchaHelper$CaptchaPayload);
    }
}
