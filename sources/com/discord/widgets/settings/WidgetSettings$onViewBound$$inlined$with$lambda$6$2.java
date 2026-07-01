package com.discord.widgets.settings;

import b.a.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetSettings$onViewBound$$inlined$with$lambda$6$1 $updateUploadDebugLogsUI$1;
    public final /* synthetic */ WidgetSettings$onViewBound$$inlined$with$lambda$6 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettings$onViewBound$$inlined$with$lambda$6$2(WidgetSettings$onViewBound$$inlined$with$lambda$6 widgetSettings$onViewBound$$inlined$with$lambda$6, WidgetSettings$onViewBound$$inlined$with$lambda$6$1 widgetSettings$onViewBound$$inlined$with$lambda$6$1) {
        super(1);
        this.this$0 = widgetSettings$onViewBound$$inlined$with$lambda$6;
        this.$updateUploadDebugLogsUI$1 = widgetSettings$onViewBound$$inlined$with$lambda$6$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r4) {
        m.i(this.this$0.this$0, 2131896663, 0, 4);
        WidgetSettings$onViewBound$$inlined$with$lambda$6$1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
    }
}
