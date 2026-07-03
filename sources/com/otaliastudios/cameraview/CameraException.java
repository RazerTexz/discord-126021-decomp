package com.otaliastudios.cameraview;

/* JADX INFO: loaded from: classes3.dex */
public class CameraException extends RuntimeException {
    private int reason;

    public CameraException(Throwable th, int i) {
        super(th);
        this.reason = 0;
        this.reason = i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9303a() {
        int i = this.reason;
        return i == 1 || i == 2 || i == 3;
    }

    public CameraException(int i) {
        this.reason = 0;
        this.reason = i;
    }
}
