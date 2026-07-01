package com.discord.widgets.settings;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6$4 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettings$onViewBound$$inlined$with$lambda$6$1 $updateUploadDebugLogsUI$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettings$onViewBound$$inlined$with$lambda$6$4(WidgetSettings$onViewBound$$inlined$with$lambda$6$1 widgetSettings$onViewBound$$inlined$with$lambda$6$1) {
        super(0);
        this.$updateUploadDebugLogsUI$1 = widgetSettings$onViewBound$$inlined$with$lambda$6$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetSettings$onViewBound$$inlined$with$lambda$6$1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
    }
}
