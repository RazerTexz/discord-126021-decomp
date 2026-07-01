package org.webrtc;

import javax.microedition.khronos.egl.EGLContext;

/* JADX INFO: loaded from: classes3.dex */
public class EglBase10Impl$Context implements EglBase10$Context {
    private final EGLContext eglContext;

    public EglBase10Impl$Context(EGLContext eGLContext) {
        this.eglContext = eGLContext;
    }

    @Override // org.webrtc.EglBase$Context
    public long getNativeEglContext() {
        return 0L;
    }

    @Override // org.webrtc.EglBase10$Context
    public EGLContext getRawContext() {
        return this.eglContext;
    }
}
