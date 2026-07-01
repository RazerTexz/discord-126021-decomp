package com.discord.widgets.media;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia$onViewBoundOrOnResume$1$1$2 extends o implements Function1<Throwable, Unit> {
    public final /* synthetic */ WidgetMedia$onViewBoundOrOnResume$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMedia$onViewBoundOrOnResume$1$1$2(WidgetMedia$onViewBoundOrOnResume$1$1 widgetMedia$onViewBoundOrOnResume$1$1) {
        super(1);
        this.this$0 = widgetMedia$onViewBoundOrOnResume$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        m.checkNotNullParameter(th, "it");
        if (this.this$0.this$0.this$0.isAdded()) {
            WidgetMedia widgetMedia = this.this$0.this$0.this$0;
            b.a.d.m.j(widgetMedia, widgetMedia.getString(2131888598), 0, 4);
        }
    }
}
