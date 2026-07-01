package com.discord.utilities.captcha;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.discord.app.AppActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CaptchaHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CaptchaHelper$showCaptchaHelpDialog$$inlined$let$lambda$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ AppActivity $activity$inlined;
    public final /* synthetic */ Function0 $onOpenBrowser$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaHelper$showCaptchaHelpDialog$$inlined$let$lambda$1(AppActivity appActivity, Function0 function0) {
        super(1);
        this.$activity$inlined = appActivity;
        this.$onOpenBrowser$inlined = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://discord.com/app")));
        Function0 function0 = this.$onOpenBrowser$inlined;
        if (function0 != null) {
        }
    }
}
