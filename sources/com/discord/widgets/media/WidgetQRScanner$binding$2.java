package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetQrScannerBinding;
import com.google.android.material.chip.Chip;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner$binding$2 extends k implements Function1<View, WidgetQrScannerBinding> {
    public static final WidgetQRScanner$binding$2 INSTANCE = new WidgetQRScanner$binding$2();

    public WidgetQRScanner$binding$2() {
        super(1, WidgetQrScannerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQrScannerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetQrScannerBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetQrScannerBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.qr_scanner;
        ZXingScannerView zXingScannerView = (ZXingScannerView) view.findViewById(R$id.qr_scanner);
        if (zXingScannerView != null) {
            i = R$id.qr_scanner_chip;
            Chip chip = (Chip) view.findViewById(R$id.qr_scanner_chip);
            if (chip != null) {
                return new WidgetQrScannerBinding((FrameLayout) view, zXingScannerView, chip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
