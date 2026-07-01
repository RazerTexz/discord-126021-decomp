package e0.a.a.a;

import android.os.HandlerThread;

/* JADX INFO: renamed from: e0.a.a.a.c, reason: use source file name */
/* JADX INFO: compiled from: CameraHandlerThread.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraHandlerThread2 extends HandlerThread {
    public BarcodeScannerView j;

    public CameraHandlerThread2(BarcodeScannerView barcodeScannerView) {
        super("CameraHandlerThread");
        this.j = barcodeScannerView;
        start();
    }
}
