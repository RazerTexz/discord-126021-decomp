package org.webrtc;

import android.annotation.TargetApi;
import android.opengl.EGLContext;

/* JADX INFO: loaded from: classes3.dex */
public class EglBase14Impl$Context implements EglBase14$Context {
    private final EGLContext egl14Context;

    public EglBase14Impl$Context(EGLContext eGLContext) {
        this.egl14Context = eGLContext;
    }

    @Override // org.webrtc.EglBase$Context
    @TargetApi(21)
    public long getNativeEglContext() {
        return EglBase14Impl.access$000() >= 21 ? this.egl14Context.getNativeHandle() : this.egl14Context.getHandle();
    }

    @Override // org.webrtc.EglBase14$Context
    public EGLContext getRawContext() {
        return this.egl14Context;
    }
}
