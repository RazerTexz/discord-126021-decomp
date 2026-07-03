package com.discord.widgets.media;

import com.discord.databinding.WidgetQrScannerBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner$binding$3 extends C12236k implements Function1<WidgetQrScannerBinding, Unit> {
    public WidgetQRScanner$binding$3(WidgetQRScanner widgetQRScanner) {
        super(1, widgetQRScanner, WidgetQRScanner.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetQrScannerBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetQrScannerBinding widgetQrScannerBinding) {
        invoke2(widgetQrScannerBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetQrScannerBinding widgetQrScannerBinding) {
        C12238m.checkNotNullParameter(widgetQrScannerBinding, "p1");
        ((WidgetQRScanner) this.receiver).onViewBindingDestroy(widgetQrScannerBinding);
    }
}
