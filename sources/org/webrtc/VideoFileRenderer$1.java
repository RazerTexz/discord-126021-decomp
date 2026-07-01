package org.webrtc;

import h0.c.n0;

/* JADX INFO: loaded from: classes3.dex */
public class VideoFileRenderer$1 implements Runnable {
    public final /* synthetic */ VideoFileRenderer this$0;
    public final /* synthetic */ EglBase$Context val$sharedContext;

    public VideoFileRenderer$1(VideoFileRenderer videoFileRenderer, EglBase$Context eglBase$Context) {
        this.this$0 = videoFileRenderer;
        this.val$sharedContext = eglBase$Context;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoFileRenderer.access$002(this.this$0, n0.b(this.val$sharedContext, EglBase.CONFIG_PIXEL_BUFFER));
        VideoFileRenderer.access$000(this.this$0).createDummyPbufferSurface();
        VideoFileRenderer.access$000(this.this$0).makeCurrent();
        VideoFileRenderer.access$102(this.this$0, new YuvConverter());
    }
}
