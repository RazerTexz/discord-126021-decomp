package com.discord.widgets.media;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetQrScannerBinding;
import com.google.android.material.chip.Chip;
import kotlin.jvm.functions.Function1;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetQRScanner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner$binding$2 extends C12236k implements Function1<View, WidgetQrScannerBinding> {
    public static final WidgetQRScanner$binding$2 INSTANCE = new WidgetQRScanner$binding$2();

    public WidgetQRScanner$binding$2() {
        super(1, WidgetQrScannerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetQrScannerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetQrScannerBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.qr_scanner;
        ZXingScannerView zXingScannerView = (ZXingScannerView) view.findViewById(C5419R.id.qr_scanner);
        if (zXingScannerView != null) {
            i = C5419R.id.qr_scanner_chip;
            Chip chip = (Chip) view.findViewById(C5419R.id.qr_scanner_chip);
            if (chip != null) {
                return new WidgetQrScannerBinding((FrameLayout) view, zXingScannerView, chip);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
