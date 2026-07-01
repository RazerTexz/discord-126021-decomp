package com.discord.widgets.guilds.join;

import com.discord.app.AppActivity;
import com.discord.utilities.captcha.CaptchaHelper;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildJoinCaptchaBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildJoinCaptchaBottomSheet$openCaptcha$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetGuildJoinCaptchaBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildJoinCaptchaBottomSheet$openCaptcha$1(WidgetGuildJoinCaptchaBottomSheet widgetGuildJoinCaptchaBottomSheet) {
        super(1);
        this.this$0 = widgetGuildJoinCaptchaBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        CaptchaHelper.INSTANCE.setCaptchaToken(str);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            WidgetGuildJoinCaptchaBottomSheet.access$finishIfCaptchaTokenReceived(this.this$0, appActivity);
        }
    }
}
