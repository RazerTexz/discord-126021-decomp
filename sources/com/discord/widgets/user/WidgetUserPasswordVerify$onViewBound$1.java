package com.discord.widgets.user;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserPasswordVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserPasswordVerify$onViewBound$1 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPasswordVerify$onViewBound$1(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        super(1);
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        WidgetUserPasswordVerify.access$saveInfo(this.this$0);
    }
}
