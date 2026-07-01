package org.webrtc;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class EglBase10Impl$1FakeSurfaceHolder implements SurfaceHolder {
    private final Surface surface;
    public final /* synthetic */ EglBase10Impl this$0;

    public EglBase10Impl$1FakeSurfaceHolder(EglBase10Impl eglBase10Impl, Surface surface) {
        this.this$0 = eglBase10Impl;
        this.surface = surface;
    }

    @Override // android.view.SurfaceHolder
    public void addCallback(SurfaceHolder$Callback surfaceHolder$Callback) {
    }

    @Override // android.view.SurfaceHolder
    public Surface getSurface() {
        return this.surface;
    }

    @Override // android.view.SurfaceHolder
    @Nullable
    public Rect getSurfaceFrame() {
        return null;
    }

    @Override // android.view.SurfaceHolder
    public boolean isCreating() {
        return false;
    }

    @Override // android.view.SurfaceHolder
    @Nullable
    public Canvas lockCanvas() {
        return null;
    }

    @Override // android.view.SurfaceHolder
    @Nullable
    public Canvas lockCanvas(Rect rect) {
        return null;
    }

    @Override // android.view.SurfaceHolder
    public void removeCallback(SurfaceHolder$Callback surfaceHolder$Callback) {
    }

    @Override // android.view.SurfaceHolder
    public void setFixedSize(int i, int i2) {
    }

    @Override // android.view.SurfaceHolder
    public void setFormat(int i) {
    }

    @Override // android.view.SurfaceHolder
    public void setKeepScreenOn(boolean z2) {
    }

    @Override // android.view.SurfaceHolder
    public void setSizeFromLayout() {
    }

    @Override // android.view.SurfaceHolder
    @Deprecated
    public void setType(int i) {
    }

    @Override // android.view.SurfaceHolder
    public void unlockCanvasAndPost(Canvas canvas) {
    }
}
