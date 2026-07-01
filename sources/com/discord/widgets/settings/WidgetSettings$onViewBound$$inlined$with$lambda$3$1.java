package com.discord.widgets.settings;

import com.discord.widgets.media.WidgetQRScanner;
import com.discord.widgets.media.WidgetQRScanner$Companion;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$3$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetSettings$onViewBound$$inlined$with$lambda$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettings$onViewBound$$inlined$with$lambda$3$1(WidgetSettings$onViewBound$$inlined$with$lambda$3 widgetSettings$onViewBound$$inlined$with$lambda$3) {
        super(0);
        this.this$0 = widgetSettings$onViewBound$$inlined$with$lambda$3;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetQRScanner$Companion.launch$default(WidgetQRScanner.Companion, this.this$0.this$0.requireContext(), false, 2, null);
    }
}
