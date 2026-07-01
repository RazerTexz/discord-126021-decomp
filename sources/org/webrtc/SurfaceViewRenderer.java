package org.webrtc;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder$Callback;
import android.view.SurfaceView;
import b.d.b.a.a;
import h0.c.y;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder$Callback, VideoSink, RendererCommon$RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private RendererCommon$RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon$VideoLayoutMeasure videoLayoutMeasure;

    public SurfaceViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon$VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
    }

    private String getResourceName() {
        try {
            return getResources().getResourceEntryName(getId());
        } catch (Resources$NotFoundException unused) {
            return "";
        }
    }

    private void logD(String str) {
        Logging.d(TAG, this.resourceName + ": " + str);
    }

    private void postOrRun(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    private void updateSurfaceSize() {
        ThreadUtils.checkIsOnMainThread();
        if (!this.enableFixedSize || this.rotatedFrameWidth == 0 || this.rotatedFrameHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            this.surfaceHeight = 0;
            this.surfaceWidth = 0;
            getHolder().setSizeFromLayout();
            return;
        }
        float width = getWidth() / getHeight();
        int i = this.rotatedFrameWidth;
        int i2 = this.rotatedFrameHeight;
        if (i / i2 > width) {
            i = (int) (i2 * width);
        } else {
            i2 = (int) (i / width);
        }
        int iMin = Math.min(getWidth(), i);
        int iMin2 = Math.min(getHeight(), i2);
        StringBuilder sbU = a.U("updateSurfaceSize. Layout size: ");
        sbU.append(getWidth());
        sbU.append("x");
        sbU.append(getHeight());
        sbU.append(", frame size: ");
        sbU.append(this.rotatedFrameWidth);
        sbU.append("x");
        sbU.append(this.rotatedFrameHeight);
        sbU.append(", requested surface size: ");
        sbU.append(iMin);
        sbU.append("x");
        sbU.append(iMin2);
        sbU.append(", old surface size: ");
        sbU.append(this.surfaceWidth);
        sbU.append("x");
        sbU.append(this.surfaceHeight);
        logD(sbU.toString());
        if (iMin == this.surfaceWidth && iMin2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = iMin;
        this.surfaceHeight = iMin2;
        getHolder().setFixedSize(iMin, iMin2);
    }

    public /* synthetic */ void a(int i, int i2) {
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
        updateSurfaceSize();
        requestLayout();
    }

    public void addFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener, float f, RendererCommon$GlDrawer rendererCommon$GlDrawer) {
        this.eglRenderer.addFrameListener(eglRenderer$FrameListener, f, rendererCommon$GlDrawer);
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void init(EglBase$Context eglBase$Context, RendererCommon$RendererEvents rendererCommon$RendererEvents) {
        init(eglBase$Context, rendererCommon$RendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    @Override // org.webrtc.RendererCommon$RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon$RendererEvents rendererCommon$RendererEvents = this.rendererEvents;
        if (rendererCommon$RendererEvents != null) {
            rendererCommon$RendererEvents.onFirstFrameRendered();
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon$RendererEvents
    public void onFrameResolutionChanged(int i, int i2, int i3) {
        RendererCommon$RendererEvents rendererCommon$RendererEvents = this.rendererEvents;
        if (rendererCommon$RendererEvents != null) {
            rendererCommon$RendererEvents.onFrameResolutionChanged(i, i2, i3);
        }
        int i4 = (i3 == 0 || i3 == 180) ? i : i2;
        if (i3 == 0 || i3 == 180) {
            i = i2;
        }
        postOrRun(new y(this, i4, i));
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.setLayoutAspectRatio((i3 - i) / (i4 - i2));
        updateSurfaceSize();
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        ThreadUtils.checkIsOnMainThread();
        Point pointMeasure = this.videoLayoutMeasure.measure(i, i2, this.rotatedFrameWidth, this.rotatedFrameHeight);
        setMeasuredDimension(pointMeasure.x, pointMeasure.y);
        StringBuilder sbU = a.U("onMeasure(). New size: ");
        sbU.append(pointMeasure.x);
        sbU.append("x");
        sbU.append(pointMeasure.y);
        logD(sbU.toString());
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void removeFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener) {
        this.eglRenderer.removeFrameListener(eglRenderer$FrameListener);
    }

    public void setEnableHardwareScaler(boolean z2) {
        ThreadUtils.checkIsOnMainThread();
        this.enableFixedSize = z2;
        updateSurfaceSize();
    }

    public void setFpsReduction(float f) {
        this.eglRenderer.setFpsReduction(f);
    }

    public void setMirror(boolean z2) {
        this.eglRenderer.setMirror(z2);
    }

    public void setScalingType(RendererCommon$ScalingType rendererCommon$ScalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(rendererCommon$ScalingType);
        requestLayout();
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    @Override // android.view.SurfaceHolder$Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void addFrameListener(EglRenderer$FrameListener eglRenderer$FrameListener, float f) {
        this.eglRenderer.addFrameListener(eglRenderer$FrameListener, f);
    }

    public void init(EglBase$Context eglBase$Context, RendererCommon$RendererEvents rendererCommon$RendererEvents, int[] iArr, RendererCommon$GlDrawer rendererCommon$GlDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererCommon$RendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(eglBase$Context, this, iArr, rendererCommon$GlDrawer);
    }

    public void setScalingType(RendererCommon$ScalingType rendererCommon$ScalingType, RendererCommon$ScalingType rendererCommon$ScalingType2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(rendererCommon$ScalingType, rendererCommon$ScalingType2);
        requestLayout();
    }

    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoLayoutMeasure = new RendererCommon$VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
    }
}
