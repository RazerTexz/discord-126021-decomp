package com.discord.widgets.media;

import com.discord.databinding.WidgetQrScannerBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetQRScanner$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner3 extends FunctionReferenceImpl implements Function1<WidgetQrScannerBinding, Unit> {
    public WidgetQRScanner3(WidgetQRScanner widgetQRScanner) {
        super(1, widgetQRScanner, WidgetQRScanner.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetQrScannerBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetQrScannerBinding widgetQrScannerBinding) {
        invoke2(widgetQrScannerBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetQrScannerBinding widgetQrScannerBinding) {
        Intrinsics3.checkNotNullParameter(widgetQrScannerBinding, "p1");
        ((WidgetQRScanner) this.receiver).onViewBindingDestroy(widgetQrScannerBinding);
    }
}
