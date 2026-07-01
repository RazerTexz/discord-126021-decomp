package com.discord.widgets.settings;

import com.discord.app.AppActivity;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBound$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSettingsLanguage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguage$onViewBound$1(WidgetSettingsLanguage widgetSettingsLanguage) {
        super(1);
        this.this$0 = widgetSettingsLanguage;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "locale");
        StoreStream.Companion.getUserSettingsSystem().setLocale(str, true, new WidgetSettingsLanguage$onViewBound$1$1(this, str));
        AppActivity appActivity = this.this$0.getAppActivity();
        if (appActivity != null) {
            appActivity.recreate();
        }
    }
}
