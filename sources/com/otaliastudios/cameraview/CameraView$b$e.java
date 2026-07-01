package com.otaliastudios.cameraview;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$b$e implements Runnable {
    public final /* synthetic */ CameraView$b j;

    public CameraView$b$e(CameraView$b cameraView$b) {
        this.j = cameraView$b;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.c.requestLayout();
    }
}
