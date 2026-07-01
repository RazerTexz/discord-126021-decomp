package com.discord.widgets.share;

import android.content.Intent;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetIncomingShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetIncomingShare$onViewBound$5 extends o implements Function1<Intent, Unit> {
    public final /* synthetic */ WidgetIncomingShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetIncomingShare$onViewBound$5(WidgetIncomingShare widgetIncomingShare) {
        super(1);
        this.this$0 = widgetIncomingShare;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
        invoke2(intent);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Intent intent) {
        m.checkNotNullParameter(intent, "it");
        WidgetIncomingShare.access$initialize(this.this$0, WidgetIncomingShare$ContentModel.Companion.get(intent));
        WidgetIncomingShare.access$getSelectedReceiverPublisher$p(this.this$0).onNext(null);
    }
}
