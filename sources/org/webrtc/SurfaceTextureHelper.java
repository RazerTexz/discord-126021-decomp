package org.webrtc;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import h0.c.n0;
import h0.c.r;
import h0.c.s;
import h0.c.t;
import h0.c.u;
import h0.c.v;
import h0.c.w;
import h0.c.x;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private final SurfaceTextureHelper$FrameRefMonitor frameRefMonitor;
    private int frameRotation;
    private final Handler handler;
    private boolean hasPendingTexture;
    private boolean isQuitting;
    private volatile boolean isTextureInUse;

    @Nullable
    private VideoSink listener;
    private final int oesTextureId;

    @Nullable
    private VideoSink pendingListener;
    public final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private int textureHeight;
    private final TextureBufferImpl$RefCountMonitor textureRefCountMonitor;
    private int textureWidth;

    @Nullable
    private final TimestampAligner timestampAligner;
    private final YuvConverter yuvConverter;

    public /* synthetic */ SurfaceTextureHelper(EglBase$Context eglBase$Context, Handler handler, boolean z2, YuvConverter yuvConverter, SurfaceTextureHelper$FrameRefMonitor surfaceTextureHelper$FrameRefMonitor, SurfaceTextureHelper$1 surfaceTextureHelper$1) {
        this(eglBase$Context, handler, z2, yuvConverter, surfaceTextureHelper$FrameRefMonitor);
    }

    public static /* synthetic */ SurfaceTextureHelper$FrameRefMonitor access$100(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.frameRefMonitor;
    }

    public static /* synthetic */ void access$200(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.returnTextureFrame();
    }

    public static /* synthetic */ VideoSink access$300(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.pendingListener;
    }

    public static /* synthetic */ VideoSink access$302(SurfaceTextureHelper surfaceTextureHelper, VideoSink videoSink) {
        surfaceTextureHelper.pendingListener = videoSink;
        return videoSink;
    }

    public static /* synthetic */ VideoSink access$402(SurfaceTextureHelper surfaceTextureHelper, VideoSink videoSink) {
        surfaceTextureHelper.listener = videoSink;
        return videoSink;
    }

    public static /* synthetic */ boolean access$500(SurfaceTextureHelper surfaceTextureHelper) {
        return surfaceTextureHelper.hasPendingTexture;
    }

    public static /* synthetic */ boolean access$502(SurfaceTextureHelper surfaceTextureHelper, boolean z2) {
        surfaceTextureHelper.hasPendingTexture = z2;
        return z2;
    }

    public static /* synthetic */ void access$600(SurfaceTextureHelper surfaceTextureHelper) {
        surfaceTextureHelper.updateTexImage();
    }

    public static SurfaceTextureHelper create(String str, EglBase$Context eglBase$Context, boolean z2, YuvConverter yuvConverter, SurfaceTextureHelper$FrameRefMonitor surfaceTextureHelper$FrameRefMonitor) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler, new SurfaceTextureHelper$1(eglBase$Context, handler, z2, yuvConverter, surfaceTextureHelper$FrameRefMonitor, str));
    }

    private void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isTextureInUse || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        }
        this.yuvConverter.release();
        GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
        this.surfaceTexture.release();
        this.eglBase.release();
        this.handler.getLooper().quit();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestampAligner.dispose();
        }
    }

    private void returnTextureFrame() {
        this.handler.post(new x(this));
    }

    @TargetApi(21)
    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture, SurfaceTexture$OnFrameAvailableListener surfaceTexture$OnFrameAvailableListener, Handler handler) {
        surfaceTexture.setOnFrameAvailableListener(surfaceTexture$OnFrameAvailableListener, handler);
    }

    private void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        }
        if (this.isQuitting || !this.hasPendingTexture || this.isTextureInUse || this.listener == null) {
            return;
        }
        if (this.textureWidth == 0 || this.textureHeight == 0) {
            Logging.w(TAG, "Texture size has not been set.");
            return;
        }
        this.isTextureInUse = true;
        this.hasPendingTexture = false;
        updateTexImage();
        float[] fArr = new float[16];
        this.surfaceTexture.getTransformMatrix(fArr);
        long timestamp = this.surfaceTexture.getTimestamp();
        TimestampAligner timestampAligner = this.timestampAligner;
        if (timestampAligner != null) {
            timestamp = timestampAligner.translateTimestamp(timestamp);
        }
        TextureBufferImpl textureBufferImpl = new TextureBufferImpl(this.textureWidth, this.textureHeight, VideoFrame$TextureBuffer$Type.OES, this.oesTextureId, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), this.handler, this.yuvConverter, this.textureRefCountMonitor);
        SurfaceTextureHelper$FrameRefMonitor surfaceTextureHelper$FrameRefMonitor = this.frameRefMonitor;
        if (surfaceTextureHelper$FrameRefMonitor != null) {
            surfaceTextureHelper$FrameRefMonitor.onNewBuffer(textureBufferImpl);
        }
        VideoFrame videoFrame = new VideoFrame(textureBufferImpl, this.frameRotation, timestamp);
        this.listener.onFrame(videoFrame);
        videoFrame.release();
    }

    private void updateTexImage() {
        synchronized (EglBase.lock) {
            this.surfaceTexture.updateTexImage();
        }
    }

    public /* synthetic */ void a() {
        this.isQuitting = true;
        if (this.isTextureInUse) {
            return;
        }
        release();
    }

    public /* synthetic */ void b() {
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    public /* synthetic */ void c(SurfaceTexture surfaceTexture) {
        if (this.hasPendingTexture) {
            Logging.d(TAG, "A frame is already pending, dropping frame.");
        }
        this.hasPendingTexture = true;
        tryDeliverTextureFrame();
    }

    public /* synthetic */ void d() {
        this.isTextureInUse = false;
        if (this.isQuitting) {
            release();
        } else {
            tryDeliverTextureFrame();
        }
    }

    public void dispose() {
        Logging.d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new s(this));
    }

    public /* synthetic */ void e(int i) {
        this.frameRotation = i;
    }

    public /* synthetic */ void f(int i, int i2) {
        this.textureWidth = i;
        this.textureHeight = i2;
        tryDeliverTextureFrame();
    }

    public void forceFrame() {
        this.handler.post(new u(this));
    }

    public /* synthetic */ void g() {
        this.listener = null;
        this.pendingListener = null;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void setFrameRotation(int i) {
        this.handler.post(new v(this, i));
    }

    public void setTextureSize(int i, int i2) {
        if (i <= 0) {
            throw new IllegalArgumentException(a.q("Texture width must be positive, but was ", i));
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException(a.q("Texture height must be positive, but was ", i2));
        }
        this.surfaceTexture.setDefaultBufferSize(i, i2);
        this.handler.post(new t(this, i, i2));
    }

    public void startListening(VideoSink videoSink) {
        if (this.listener != null || this.pendingListener != null) {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
        this.pendingListener = videoSink;
        this.handler.post(this.setListenerRunnable);
    }

    public void stopListening() {
        Logging.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new w(this));
    }

    @Deprecated
    public VideoFrame$I420Buffer textureToYuv(VideoFrame$TextureBuffer videoFrame$TextureBuffer) {
        return videoFrame$TextureBuffer.toI420();
    }

    private SurfaceTextureHelper(EglBase$Context eglBase$Context, Handler handler, boolean z2, YuvConverter yuvConverter, SurfaceTextureHelper$FrameRefMonitor surfaceTextureHelper$FrameRefMonitor) {
        this.textureRefCountMonitor = new SurfaceTextureHelper$2(this);
        this.setListenerRunnable = new SurfaceTextureHelper$3(this);
        if (handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
        this.handler = handler;
        this.timestampAligner = z2 ? new TimestampAligner() : null;
        this.yuvConverter = yuvConverter;
        this.frameRefMonitor = surfaceTextureHelper$FrameRefMonitor;
        EglBase eglBaseB = n0.b(eglBase$Context, EglBase.CONFIG_PIXEL_BUFFER);
        this.eglBase = eglBaseB;
        try {
            eglBaseB.createDummyPbufferSurface();
            eglBaseB.makeCurrent();
            int iGenerateTexture = GlUtil.generateTexture(36197);
            this.oesTextureId = iGenerateTexture;
            SurfaceTexture surfaceTexture = new SurfaceTexture(iGenerateTexture);
            this.surfaceTexture = surfaceTexture;
            setOnFrameAvailableListener(surfaceTexture, new r(this), handler);
        } catch (RuntimeException e) {
            this.eglBase.release();
            handler.getLooper().quit();
            throw e;
        }
    }

    public static SurfaceTextureHelper create(String str, EglBase$Context eglBase$Context) {
        return create(str, eglBase$Context, false, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(String str, EglBase$Context eglBase$Context, boolean z2) {
        return create(str, eglBase$Context, z2, new YuvConverter(), null);
    }

    public static SurfaceTextureHelper create(String str, EglBase$Context eglBase$Context, boolean z2, YuvConverter yuvConverter) {
        return create(str, eglBase$Context, z2, yuvConverter, null);
    }
}
