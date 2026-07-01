package org.webrtc;

import android.os.Handler;
import androidx.annotation.Nullable;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceTextureHelper$1 implements Callable<SurfaceTextureHelper> {
    public final /* synthetic */ boolean val$alignTimestamps;
    public final /* synthetic */ SurfaceTextureHelper$FrameRefMonitor val$frameRefMonitor;
    public final /* synthetic */ Handler val$handler;
    public final /* synthetic */ EglBase$Context val$sharedContext;
    public final /* synthetic */ String val$threadName;
    public final /* synthetic */ YuvConverter val$yuvConverter;

    public SurfaceTextureHelper$1(EglBase$Context eglBase$Context, Handler handler, boolean z2, YuvConverter yuvConverter, SurfaceTextureHelper$FrameRefMonitor surfaceTextureHelper$FrameRefMonitor, String str) {
        this.val$sharedContext = eglBase$Context;
        this.val$handler = handler;
        this.val$alignTimestamps = z2;
        this.val$yuvConverter = yuvConverter;
        this.val$frameRefMonitor = surfaceTextureHelper$FrameRefMonitor;
        this.val$threadName = str;
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    public /* bridge */ /* synthetic */ SurfaceTextureHelper call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    @Nullable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public SurfaceTextureHelper call2() {
        try {
            return new SurfaceTextureHelper(this.val$sharedContext, this.val$handler, this.val$alignTimestamps, this.val$yuvConverter, this.val$frameRefMonitor, null);
        } catch (RuntimeException e) {
            Logging.e("SurfaceTextureHelper", this.val$threadName + " create failure", e);
            return null;
        }
    }
}
