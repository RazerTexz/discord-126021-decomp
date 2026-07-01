package com.discord.widgets.home;

import android.content.Context;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome$onCreate$1 extends o implements Function1<Context, Locale> {
    public final /* synthetic */ WidgetHome this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHome$onCreate$1(WidgetHome widgetHome) {
        super(1);
        this.this$0 = widgetHome;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Locale invoke(Context context) {
        return invoke2(context);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Locale invoke2(Context context) {
        m.checkNotNullParameter(context, "context");
        return WidgetHome.access$getLocaleManager$p(this.this$0).getPrimaryLocale(context);
    }
}
