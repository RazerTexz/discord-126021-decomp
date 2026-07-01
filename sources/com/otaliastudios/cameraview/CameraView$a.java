package com.otaliastudios.cameraview;

import androidx.annotation.NonNull;
import b.d.b.a.a;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView$a implements ThreadFactory {
    public final AtomicInteger j = new AtomicInteger(1);

    public CameraView$a(CameraView cameraView) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        StringBuilder sbU = a.U("FrameExecutor #");
        sbU.append(this.j.getAndIncrement());
        return new Thread(runnable, sbU.toString());
    }
}
