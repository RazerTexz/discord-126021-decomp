package com.discord.widgets.media;

import android.content.Context;
import b.a.k.b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$1$1$1 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetMedia$onViewBoundOrOnResume$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBoundOrOnResume$1$1$1(WidgetMedia$onViewBoundOrOnResume$1$1 widgetMedia$onViewBoundOrOnResume$1$1) {
        super(1);
        this.this$0 = widgetMedia$onViewBoundOrOnResume$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        if (this.this$0.this$0.this$0.isAdded()) {
            WidgetMedia$onViewBoundOrOnResume$1$1 widgetMedia$onViewBoundOrOnResume$1$1 = this.this$0;
            WidgetMedia widgetMedia = widgetMedia$onViewBoundOrOnResume$1$1.this$0.this$0;
            Context context = widgetMedia$onViewBoundOrOnResume$1$1.$context;
            m.checkNotNullExpressionValue(context, "context");
            b.a.d.m.j(widgetMedia, b.h(context, 2131888599, new Object[]{str}, null, 4), 0, 4);
        }
    }
}
