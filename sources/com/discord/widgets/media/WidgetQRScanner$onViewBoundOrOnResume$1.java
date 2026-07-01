package com.discord.widgets.media;

import android.os.Handler;
import d0.z.d.o;
import e0.a.a.a.b;
import e0.a.a.a.c;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetQRScanner$onViewBoundOrOnResume$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetQRScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetQRScanner$onViewBoundOrOnResume$1(WidgetQRScanner widgetQRScanner) {
        super(0);
        this.this$0 = widgetQRScanner;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ZXingScannerView zXingScannerView = WidgetQRScanner.access$getBinding$p(this.this$0).f2515b;
        if (zXingScannerView.n == null) {
            zXingScannerView.n = new c(zXingScannerView);
        }
        c cVar = zXingScannerView.n;
        Objects.requireNonNull(cVar);
        new Handler(cVar.getLooper()).post(new b(cVar, 0));
    }
}
