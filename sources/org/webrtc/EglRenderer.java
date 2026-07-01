package org.webrtc;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import h0.c.e;
import h0.c.f;
import h0.c.g;
import h0.c.h;
import h0.c.i;
import h0.c.j;
import h0.c.k;
import h0.c.l;
import h0.c.n0;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class EglRenderer implements VideoSink {
    private static final long LOG_INTERVAL_SEC = 4;
    private static final String TAG = "EglRenderer";
    private final GlTextureFrameBuffer bitmapTextureFramebuffer;
    private final Matrix drawMatrix;

    @Nullable
    private RendererCommon$GlDrawer drawer;

    @Nullable
    private EglBase eglBase;
    private final EglRenderer$EglSurfaceCreation eglSurfaceCreationRunnable;
    private volatile EglRenderer$ErrorCallback errorCallback;
    private final Object fpsReductionLock;
    private final VideoFrameDrawer frameDrawer;
    private final ArrayList<EglRenderer$FrameListenerAndParams> frameListeners;
    private final Object frameLock;
    private int framesDropped;
    private int framesReceived;
    private int framesRendered;
    private final Object handlerLock;
    private float layoutAspectRatio;
    private final Object layoutLock;
    private final Runnable logStatisticsRunnable;
    private long minRenderPeriodNs;
    private boolean mirrorHorizontally;
    private boolean mirrorVertically;
    public final String name;
    private long nextFrameTimeNs;

    @Nullable
    private VideoFrame pendingFrame;
    private long renderSwapBufferTimeNs;

    @Nullable
    private Handler renderThreadHandler;
    private long renderTimeNs;
    private final Object statisticsLock;
    private long statisticsStartTimeNs;
    private boolean usePresentationTimeStamp;

    public EglRenderer(String str) {
        this(str, new VideoFrameDrawer());
    }

    public static /* synthetic */ EglBase access$000(EglRenderer eglRenderer) {
        return eglRenderer.eglBase;
    }

    public static /* synthetic */ void access$100(EglRenderer eglRenderer) {
        eglRenderer.logStatistics();
    }

    public static /* synthetic */ Object access$200(EglRenderer eglRenderer) {
        return eglRenderer.handlerLock;
    }

    public static /* synthetic */ Handler access$300(EglRenderer eglRenderer) {
        return eglRenderer.renderThreadHandler;
    }

    public static /* synthetic */ Handler access$302(EglRenderer eglRenderer, Handler handler) {
        eglRenderer.renderThreadHandler = handler;
        return handler;
    }

    public static /* synthetic */ Runnable access$400(EglRenderer eglRenderer) {
        return eglRenderer.logStatisticsRunnable;
    }

    private String averageTimeAsString(long j, int i) {
        if (i <= 0) {
            return "NA";
        }
        return TimeUnit.NANOSECONDS.toMicros(j / ((long) i)) + " us";
    }

    public static /* synthetic */ void c(EglRenderer eglRenderer) throws Throwable {
        eglRenderer.renderFrameOnRenderThread();
    }

    private void clearSurfaceOnRenderThread(float f, float f2, float f3, float f4) {
        EglBase eglBase = this.eglBase;
        if (eglBase == null || !eglBase.hasSurface()) {
            return;
        }
        logD("clearSurface");
        GLES20.glClearColor(f, f2, f3, f4);
        GLES20.glClear(16384);
        this.eglBase.swapBuffers();
    }

    private void createEglSurfaceInternal(Object obj) {
        this.eglSurfaceCreationRunnable.setSurface(obj);
        postToRenderThread(this.eglSurfaceCreationRunnable);
    }

    private void lambda$init$0(EglBase$Context eglBase$Context, int[] iArr) {
        if (eglBase$Context != null) {
            logD("EglBase.create shared context");
            this.eglBase = n0.b(eglBase$Context, iArr);
        } else {
            logD("EglBase10.create context");
            Object obj = EglBase.lock;
            this.eglBase = new EglBase10Impl(null, iArr);
        }
    }

    private void logD(String str) {
        Logging.d(TAG, this.name + str);
    }

    private void logE(String str, Throwable th) {
        Logging.e(TAG, this.name + str, th);
    }

    private void logStatistics() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        long jNanoTime = System.nanoTime();
        synchronized (this.statisticsLock) {
            long j = jNanoTime - this.statisticsStartTimeNs;
            if (j > 0 && (this.minRenderPeriodNs != RecyclerView.FOREVER_NS || this.framesReceived != 0)) {
                logD("Duration: " + TimeUnit.NANOSECONDS.toMillis(j) + " ms. Frames received: " + this.framesReceived + ". Dropped: " + this.framesDropped + ". Rendered: " + this.framesRendered + ". Render fps: " + decimalFormat.format((((long) this.framesRendered) * TimeUnit.SECONDS.toNanos(1L)) / j) + ". Average render time: " + averageTimeAsString(this.renderTimeNs, this.framesRendered) + ". Average swapBuffer time: " + averageTimeAsString(this.renderSwapBufferTimeNs, this.framesRendered) + ".");
                resetStatistics(jNanoTime);
            }
        }
    }

    private void logW(String str) {
        Logging.w(TAG, this.name + str);
    }

    private void notifyCallbacks(VideoFrame videoFrame, boolean z2) {
        if (this.frameListeners.isEmpty()) {
            return;
        }
        this.drawMatrix.reset();
        this.drawMatrix.preTranslate(0.5f, 0.5f);
        this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
        this.drawMatrix.preScale(1.0f, -1.0f);
        this.drawMatrix.preTranslate(-0.5f, -0.5f);
        Iterator<EglRenderer$FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            EglRenderer$FrameListenerAndParams next = it.next();
            if (z2 || !next.applyFpsReduction) {
                it.remove();
                int rotatedWidth = (int) (next.scale * videoFrame.getRotatedWidth());
                int rotatedHeight = (int) (next.scale * videoFrame.getRotatedHeight());
                if (rotatedWidth == 0 || rotatedHeight == 0) {
                    next.listener.onFrame(null);
                } else {
                    this.bitmapTextureFramebuffer.setSize(rotatedWidth, rotatedHeight);
                    GLES20.glBindFramebuffer(36160, this.bitmapTextureFramebuffer.getFrameBufferId());
                    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.bitmapTextureFramebuffer.getTextureId(), 0);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                    GLES20.glClear(16384);
                    this.frameDrawer.drawFrame(videoFrame, next.drawer, this.drawMatrix, 0, 0, rotatedWidth, rotatedHeight);
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
                    GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
                    GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, byteBufferAllocateDirect);
                    GLES20.glBindFramebuffer(36160, 0);
                    GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap$Config.ARGB_8888);
                    bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocateDirect);
                    next.listener.onFrame(bitmapCreateBitmap);
                }
            }
        }
    }

    private void postToRenderThread(Runnable runnable) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler != null) {
                handler.post(runnable);
            }
        }
    }

    private void renderFrameOnRenderThread() throws Throwable {
        boolean z2;
        boolean z3;
        float f;
        float f2;
        float f3;
        synchronized (this.frameLock) {
            VideoFrame videoFrame = this.pendingFrame;
            if (videoFrame == null) {
                return;
            }
            this.pendingFrame = null;
            EglBase eglBase = this.eglBase;
            if (eglBase == null || !eglBase.hasSurface()) {
                logD("Dropping frame - No surface");
                videoFrame.release();
                return;
            }
            synchronized (this.fpsReductionLock) {
                long j = this.minRenderPeriodNs;
                z2 = true;
                if (j != RecyclerView.FOREVER_NS) {
                    if (j > 0) {
                        long jNanoTime = System.nanoTime();
                        long j2 = this.nextFrameTimeNs;
                        if (jNanoTime < j2) {
                            logD("Skipping frame rendering - fps reduction is active.");
                            z3 = false;
                        } else {
                            long j3 = j2 + this.minRenderPeriodNs;
                            this.nextFrameTimeNs = j3;
                            this.nextFrameTimeNs = Math.max(j3, jNanoTime);
                        }
                    }
                    z3 = true;
                } else {
                    z3 = false;
                }
            }
            long jNanoTime2 = System.nanoTime();
            float rotatedWidth = videoFrame.getRotatedWidth() / videoFrame.getRotatedHeight();
            synchronized (this.layoutLock) {
                f = this.layoutAspectRatio;
                if (f == 0.0f) {
                    f = rotatedWidth;
                }
            }
            if (rotatedWidth > f) {
                f3 = f / rotatedWidth;
                f2 = 1.0f;
            } else {
                f2 = rotatedWidth / f;
                f3 = 1.0f;
            }
            this.drawMatrix.reset();
            this.drawMatrix.preTranslate(0.5f, 0.5f);
            this.drawMatrix.preScale(this.mirrorHorizontally ? -1.0f : 1.0f, this.mirrorVertically ? -1.0f : 1.0f);
            this.drawMatrix.preScale(f3, f2);
            this.drawMatrix.preTranslate(-0.5f, -0.5f);
            try {
                try {
                    notifyCallbacks(videoFrame, z3);
                    if (z3) {
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
                        GLES20.glClear(16384);
                        this.frameDrawer.drawFrame(videoFrame, this.drawer, this.drawMatrix, 0, 0, this.eglBase.surfaceWidth(), this.eglBase.surfaceHeight());
                        long jNanoTime3 = System.nanoTime();
                        try {
                            if (this.usePresentationTimeStamp) {
                                long timestampNs = videoFrame.getTimestampNs();
                                videoFrame.release();
                                this.eglBase.swapBuffers(timestampNs);
                            } else {
                                videoFrame.release();
                                this.eglBase.swapBuffers();
                            }
                            long jNanoTime4 = System.nanoTime();
                            synchronized (this.statisticsLock) {
                                try {
                                    this.framesRendered++;
                                    this.renderTimeNs = (jNanoTime4 - jNanoTime2) + this.renderTimeNs;
                                    this.renderSwapBufferTimeNs = (jNanoTime4 - jNanoTime3) + this.renderSwapBufferTimeNs;
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            z2 = false;
                        } catch (GlUtil$GlOutOfMemoryException e) {
                            e = e;
                            z2 = false;
                            logE("Error while drawing frame", e);
                            EglRenderer$ErrorCallback eglRenderer$ErrorCallback = this.errorCallback;
                            if (eglRenderer$ErrorCallback != null) {
                                eglRenderer$ErrorCallback.onGlOutOfMemory();
                            }
                            this.drawer.release();
                            this.frameDrawer.release();
                            this.bitmapTextureFramebuffer.release();
                            if (!z2) {
                                return;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            z2 = false;
                            if (z2) {
                                videoFrame.release();
                            }
                            throw th;
                        }
                    }
                    notifyCallbacks(videoFrame, z3);
                    if (!z2) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (GlUtil$GlOutOfMemoryException e2) {
                e = e2;
            }
            videoFrame.release();
        }
    }

    private void resetStatistics(long j) {
        synchronized (this.statisticsLock) {
            this.statisticsStartTimeNs = j;
            this.framesReceived = 0;
            this.framesDropped = 0;
            this.framesRendered = 0;
            this.renderTimeNs = 0L;
            this.renderSwapBufferTimeNs = 0L;
        }
    }

    public /* synthetic */ void a(RendererCommon$GlDrawer rendererCommon$GlDrawer, EglRenderer$FrameListener eglRenderer$FrameListener, float f, boolean z2) {
        if (rendererCommon$GlDrawer == null) {
            rendererCommon$GlDrawer = this.drawer;
        }
        this.frameListeners.add(new EglRenderer$FrameListenerAndParams(eglRenderer$FrameListener, f, rendererCommon$GlDrawer, z2));
    }

    public void addFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener, float f) {
        addFrameListener(eglRenderer$FrameListener, f, null, false);
    }

    public /* synthetic */ void b(float f, float f2, float f3, float f4) {
        clearSurfaceOnRenderThread(f, f2, f3, f4);
    }

    public void clearImage() {
        clearImage(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void createEglSurface(Surface surface) {
        createEglSurfaceInternal(surface);
    }

    public /* synthetic */ void d(EglBase$Context eglBase$Context, int[] iArr) {
        lambda$init$0(eglBase$Context, iArr);
    }

    public void disableFpsReduction() {
        setFpsReduction(Float.POSITIVE_INFINITY);
    }

    public /* synthetic */ void e(CountDownLatch countDownLatch) {
        synchronized (EglBase.lock) {
            GLES20.glUseProgram(0);
        }
        RendererCommon$GlDrawer rendererCommon$GlDrawer = this.drawer;
        if (rendererCommon$GlDrawer != null) {
            rendererCommon$GlDrawer.release();
            this.drawer = null;
        }
        this.frameDrawer.release();
        this.bitmapTextureFramebuffer.release();
        if (this.eglBase != null) {
            logD("eglBase detach and release.");
            this.eglBase.detachCurrent();
            this.eglBase.release();
            this.eglBase = null;
        }
        this.frameListeners.clear();
        countDownLatch.countDown();
    }

    public /* synthetic */ void f(Looper looper) {
        logD("Quitting render thread.");
        looper.quit();
    }

    public /* synthetic */ void g(Runnable runnable) {
        EglBase eglBase = this.eglBase;
        if (eglBase != null) {
            eglBase.detachCurrent();
            this.eglBase.releaseSurface();
        }
        runnable.run();
    }

    public /* synthetic */ void h(CountDownLatch countDownLatch, EglRenderer$FrameListener eglRenderer$FrameListener) {
        countDownLatch.countDown();
        Iterator<EglRenderer$FrameListenerAndParams> it = this.frameListeners.iterator();
        while (it.hasNext()) {
            if (it.next().listener == eglRenderer$FrameListener) {
                it.remove();
            }
        }
    }

    public void init(@Nullable EglBase$Context eglBase$Context, int[] iArr, RendererCommon$GlDrawer rendererCommon$GlDrawer, boolean z2) {
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler != null) {
                throw new IllegalStateException(this.name + "Already initialized");
            }
            logD("Initializing EglRenderer");
            this.drawer = rendererCommon$GlDrawer;
            this.usePresentationTimeStamp = z2;
            HandlerThread handlerThread = new HandlerThread(this.name + TAG);
            handlerThread.start();
            EglRenderer$HandlerWithExceptionCallback eglRenderer$HandlerWithExceptionCallback = new EglRenderer$HandlerWithExceptionCallback(handlerThread.getLooper(), new EglRenderer$2(this));
            this.renderThreadHandler = eglRenderer$HandlerWithExceptionCallback;
            ThreadUtils.invokeAtFrontUninterruptibly(eglRenderer$HandlerWithExceptionCallback, new j(this, eglBase$Context, iArr));
            this.renderThreadHandler.post(this.eglSurfaceCreationRunnable);
            resetStatistics(System.nanoTime());
            this.renderThreadHandler.postDelayed(this.logStatisticsRunnable, TimeUnit.SECONDS.toMillis(4L));
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        boolean z2;
        synchronized (this.statisticsLock) {
            this.framesReceived++;
        }
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                logD("Dropping frame - Not initialized or already released.");
                return;
            }
            synchronized (this.frameLock) {
                VideoFrame videoFrame2 = this.pendingFrame;
                z2 = videoFrame2 != null;
                if (z2) {
                    videoFrame2.release();
                }
                this.pendingFrame = videoFrame;
                videoFrame.retain();
                this.renderThreadHandler.post(new i(this));
            }
            if (z2) {
                synchronized (this.statisticsLock) {
                    this.framesDropped++;
                }
            }
        }
    }

    public void pauseVideo() {
        setFpsReduction(0.0f);
    }

    public void printStackTrace() {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            Thread thread = handler == null ? null : handler.getLooper().getThread();
            if (thread != null) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace.length > 0) {
                    logW("EglRenderer stack trace:");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        logW(stackTraceElement.toString());
                    }
                }
            }
        }
    }

    public void release() {
        logD("Releasing.");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                logD("Already released");
                return;
            }
            handler.removeCallbacks(this.logStatisticsRunnable);
            this.renderThreadHandler.postAtFrontOfQueue(new h(this, countDownLatch));
            this.renderThreadHandler.post(new k(this, this.renderThreadHandler.getLooper()));
            this.renderThreadHandler = null;
            ThreadUtils.awaitUninterruptibly(countDownLatch);
            synchronized (this.frameLock) {
                VideoFrame videoFrame = this.pendingFrame;
                if (videoFrame != null) {
                    videoFrame.release();
                    this.pendingFrame = null;
                }
            }
            logD("Releasing done.");
        }
    }

    public void releaseEglSurface(Runnable runnable) {
        this.eglSurfaceCreationRunnable.setSurface(null);
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                runnable.run();
            } else {
                handler.removeCallbacks(this.eglSurfaceCreationRunnable);
                this.renderThreadHandler.postAtFrontOfQueue(new e(this, runnable));
            }
        }
    }

    public void removeFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        synchronized (this.handlerLock) {
            if (this.renderThreadHandler == null) {
                return;
            }
            if (Thread.currentThread() == this.renderThreadHandler.getLooper().getThread()) {
                throw new RuntimeException("removeFrameListener must not be called on the render thread.");
            }
            postToRenderThread(new g(this, countDownLatch, eglRenderer$FrameListener));
            ThreadUtils.awaitUninterruptibly(countDownLatch);
        }
    }

    public void setErrorCallback(EglRenderer$ErrorCallback eglRenderer$ErrorCallback) {
        this.errorCallback = eglRenderer$ErrorCallback;
    }

    public void setFpsReduction(float f) {
        logD("setFpsReduction: " + f);
        synchronized (this.fpsReductionLock) {
            long j = this.minRenderPeriodNs;
            if (f <= 0.0f) {
                this.minRenderPeriodNs = RecyclerView.FOREVER_NS;
            } else {
                this.minRenderPeriodNs = (long) (TimeUnit.SECONDS.toNanos(1L) / f);
            }
            if (this.minRenderPeriodNs != j) {
                this.nextFrameTimeNs = System.nanoTime();
            }
        }
    }

    public void setLayoutAspectRatio(float f) {
        logD("setLayoutAspectRatio: " + f);
        synchronized (this.layoutLock) {
            this.layoutAspectRatio = f;
        }
    }

    public void setMirror(boolean z2) {
        logD("setMirrorHorizontally: " + z2);
        synchronized (this.layoutLock) {
            this.mirrorHorizontally = z2;
        }
    }

    public void setMirrorVertically(boolean z2) {
        logD("setMirrorVertically: " + z2);
        synchronized (this.layoutLock) {
            this.mirrorVertically = z2;
        }
    }

    public EglRenderer(String str, VideoFrameDrawer videoFrameDrawer) {
        this.handlerLock = new Object();
        this.frameListeners = new ArrayList<>();
        this.fpsReductionLock = new Object();
        this.drawMatrix = new Matrix();
        this.frameLock = new Object();
        this.layoutLock = new Object();
        this.statisticsLock = new Object();
        this.bitmapTextureFramebuffer = new GlTextureFrameBuffer(6408);
        this.logStatisticsRunnable = new EglRenderer$1(this);
        this.eglSurfaceCreationRunnable = new EglRenderer$EglSurfaceCreation(this, null);
        this.name = str;
        this.frameDrawer = videoFrameDrawer;
    }

    public void addFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener, float f, RendererCommon$GlDrawer rendererCommon$GlDrawer) {
        addFrameListener(eglRenderer$FrameListener, f, rendererCommon$GlDrawer, false);
    }

    public void clearImage(float f, float f2, float f3, float f4) {
        synchronized (this.handlerLock) {
            Handler handler = this.renderThreadHandler;
            if (handler == null) {
                return;
            }
            handler.postAtFrontOfQueue(new f(this, f, f2, f3, f4));
        }
    }

    public void createEglSurface(SurfaceTexture surfaceTexture) {
        createEglSurfaceInternal(surfaceTexture);
    }

    public void addFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener, float f, @Nullable RendererCommon$GlDrawer rendererCommon$GlDrawer, boolean z2) {
        postToRenderThread(new l(this, rendererCommon$GlDrawer, eglRenderer$FrameListener, f, z2));
    }

    public void init(@Nullable EglBase$Context eglBase$Context, int[] iArr, RendererCommon$GlDrawer rendererCommon$GlDrawer) {
        init(eglBase$Context, iArr, rendererCommon$GlDrawer, false);
    }
}
