package com.discord.widgets.friends;

import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$captchaLauncher$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby5 extends Lambda implements Function1<CaptchaHelper.CaptchaPayload, Unit> {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsFindNearby5(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        super(1);
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CaptchaHelper.CaptchaPayload captchaPayload) {
        invoke2(captchaPayload);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CaptchaHelper.CaptchaPayload captchaPayload) {
        Integer discriminator;
        Intrinsics3.checkNotNullParameter(captchaPayload, "token");
        String username = this.this$0.getViewModel().getUsername();
        if (username == null || (discriminator = this.this$0.getViewModel().getDiscriminator()) == null) {
            return;
        }
        this.this$0.sendFriendRequest(username, discriminator.intValue(), captchaPayload);
    }
}
