package com.discord.widgets.auth;

import com.discord.app.AppActivity;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetOauth2AuthorizeSamsung.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetOauth2AuthorizeSamsung this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetOauth2AuthorizeSamsung$startSamsungAccountLink$1(WidgetOauth2AuthorizeSamsung widgetOauth2AuthorizeSamsung) {
        super(1);
        this.this$0 = widgetOauth2AuthorizeSamsung;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) throws Exception {
        m.checkNotNullParameter(error, "error");
        WidgetOauth2AuthorizeSamsung$Companion.access$logI(WidgetOauth2AuthorizeSamsung.Companion, "GET /authorize: error " + error);
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.onBackPressed();
        }
    }
}
