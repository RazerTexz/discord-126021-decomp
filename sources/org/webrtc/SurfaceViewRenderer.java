package org.webrtc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import org.webrtc.EglBase;
import org.webrtc.EglRenderer;
import org.webrtc.RendererCommon;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes3.dex */
public class SurfaceViewRenderer extends SurfaceView implements SurfaceHolder.Callback, VideoSink, RendererCommon.RendererEvents {
    private static final String TAG = "SurfaceViewRenderer";
    private final SurfaceEglRenderer eglRenderer;
    private boolean enableFixedSize;
    private RendererCommon.RendererEvents rendererEvents;
    private final String resourceName;
    private int rotatedFrameHeight;
    private int rotatedFrameWidth;
    private int surfaceHeight;
    private int surfaceWidth;
    private final RendererCommon.VideoLayoutMeasure videoLayoutMeasure;

    public SurfaceViewRenderer(Context context) {
        super(context);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
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
        } catch (Resources.NotFoundException unused) {
            return "";
        }
    }

    private void logD(String str) {
        Logging.m11027d(TAG, this.resourceName + ": " + str);
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
        StringBuilder sbM833U = C1643a.m833U("updateSurfaceSize. Layout size: ");
        sbM833U.append(getWidth());
        sbM833U.append("x");
        sbM833U.append(getHeight());
        sbM833U.append(", frame size: ");
        sbM833U.append(this.rotatedFrameWidth);
        sbM833U.append("x");
        sbM833U.append(this.rotatedFrameHeight);
        sbM833U.append(", requested surface size: ");
        sbM833U.append(iMin);
        sbM833U.append("x");
        sbM833U.append(iMin2);
        sbM833U.append(", old surface size: ");
        sbM833U.append(this.surfaceWidth);
        sbM833U.append("x");
        sbM833U.append(this.surfaceHeight);
        logD(sbM833U.toString());
        if (iMin == this.surfaceWidth && iMin2 == this.surfaceHeight) {
            return;
        }
        this.surfaceWidth = iMin;
        this.surfaceHeight = iMin2;
        getHolder().setFixedSize(iMin, iMin2);
    }

    /* JADX INFO: renamed from: a */
    public /* synthetic */ void m11047a(int i, int i2) {
        this.rotatedFrameWidth = i;
        this.rotatedFrameHeight = i2;
        updateSurfaceSize();
        requestLayout();
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.addFrameListener(frameListener, f, glDrawer);
    }

    public void clearImage() {
        this.eglRenderer.clearImage();
    }

    public void disableFpsReduction() {
        this.eglRenderer.disableFpsReduction();
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents) {
        init(context, rendererEvents, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFirstFrameRendered() {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFirstFrameRendered();
        }
    }

    @Override // org.webrtc.VideoSink
    public void onFrame(VideoFrame videoFrame) {
        this.eglRenderer.onFrame(videoFrame);
    }

    @Override // org.webrtc.RendererCommon.RendererEvents
    public void onFrameResolutionChanged(final int i, int i2, int i3) {
        RendererCommon.RendererEvents rendererEvents = this.rendererEvents;
        if (rendererEvents != null) {
            rendererEvents.onFrameResolutionChanged(i, i2, i3);
        }
        final int i4 = (i3 == 0 || i3 == 180) ? i : i2;
        if (i3 == 0 || i3 == 180) {
            i = i2;
        }
        postOrRun(new Runnable() { // from class: h0.c.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f26469j.m11047a(i4, i);
            }
        });
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
        StringBuilder sbM833U = C1643a.m833U("onMeasure(). New size: ");
        sbM833U.append(pointMeasure.x);
        sbM833U.append("x");
        sbM833U.append(pointMeasure.y);
        logD(sbM833U.toString());
    }

    public void pauseVideo() {
        this.eglRenderer.pauseVideo();
    }

    public void release() {
        this.eglRenderer.release();
    }

    public void removeFrameListener(EglRenderer.FrameListener frameListener) {
        this.eglRenderer.removeFrameListener(frameListener);
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

    public void setScalingType(RendererCommon.ScalingType scalingType) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType);
        requestLayout();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.surfaceHeight = 0;
        this.surfaceWidth = 0;
        updateSurfaceSize();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public void addFrameListener(EglRenderer.FrameListener frameListener, float f) {
        this.eglRenderer.addFrameListener(frameListener, f);
    }

    public void init(EglBase.Context context, RendererCommon.RendererEvents rendererEvents, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        ThreadUtils.checkIsOnMainThread();
        this.rendererEvents = rendererEvents;
        this.rotatedFrameWidth = 0;
        this.rotatedFrameHeight = 0;
        this.eglRenderer.init(context, this, iArr, glDrawer);
    }

    public void setScalingType(RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2) {
        ThreadUtils.checkIsOnMainThread();
        this.videoLayoutMeasure.setScalingType(scalingType, scalingType2);
        requestLayout();
    }

    public SurfaceViewRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.videoLayoutMeasure = new RendererCommon.VideoLayoutMeasure();
        String resourceName = getResourceName();
        this.resourceName = resourceName;
        SurfaceEglRenderer surfaceEglRenderer = new SurfaceEglRenderer(resourceName);
        this.eglRenderer = surfaceEglRenderer;
        getHolder().addCallback(this);
        getHolder().addCallback(surfaceEglRenderer);
    }
}
