package me.dm7.barcodescanner.zxing;

import com.google.zxing.Result;
import e0.a.a.a.d;

/* JADX INFO: loaded from: classes3.dex */
public class ZXingScannerView$a implements Runnable {
    public final /* synthetic */ Result j;
    public final /* synthetic */ ZXingScannerView k;

    public ZXingScannerView$a(ZXingScannerView zXingScannerView, Result result) {
        this.k = zXingScannerView;
        this.j = result;
    }

    @Override // java.lang.Runnable
    public void run() {
        ZXingScannerView zXingScannerView = this.k;
        ZXingScannerView$b zXingScannerView$b = zXingScannerView.G;
        zXingScannerView.G = null;
        d dVar = zXingScannerView.k;
        if (dVar != null) {
            dVar.e();
        }
        if (zXingScannerView$b != null) {
            zXingScannerView$b.handleResult(this.j);
        }
    }
}
