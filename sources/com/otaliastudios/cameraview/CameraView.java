package com.otaliastudios.cameraview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.o.a.CameraListener;
import b.o.a.CameraLogger;
import b.o.a.CameraOptions;
import b.o.a.CameraUtils2;
import b.o.a.PictureResult;
import b.o.a.m.Audio;
import b.o.a.m.AudioCodec;
import b.o.a.m.Control;
import b.o.a.m.Engine;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Grid;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.Preview;
import b.o.a.m.VideoCodec;
import b.o.a.m.WhiteBalance;
import b.o.a.n.Camera1Engine2;
import b.o.a.n.Camera2Engine;
import b.o.a.n.CameraEngine;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.n.v.CameraState2;
import b.o.a.o.Filter2;
import b.o.a.o.NoFilter;
import b.o.a.o.OneParameterFilter;
import b.o.a.o.TwoParameterFilter;
import b.o.a.p.Frame2;
import b.o.a.p.FrameProcessor;
import b.o.a.q.Gesture;
import b.o.a.q.GestureAction;
import b.o.a.q.GestureFinder;
import b.o.a.q.PinchGestureFinder;
import b.o.a.q.ScrollGestureFinder;
import b.o.a.q.TapGestureFinder;
import b.o.a.r.GridLinesLayout;
import b.o.a.r.OrientationHelper2;
import b.o.a.s.AutoFocusMarker;
import b.o.a.s.AutoFocusTrigger;
import b.o.a.s.MarkerLayout;
import b.o.a.t.MeteringRegion;
import b.o.a.t.MeteringRegions;
import b.o.a.u.OverlayLayout;
import b.o.a.w.CameraPreview;
import b.o.a.w.FilterCameraPreview;
import b.o.a.w.GlCameraPreview2;
import b.o.a.w.SurfaceCameraPreview2;
import b.o.a.w.TextureCameraPreview2;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import b.o.a.x.SizeSelector;
import b.o.a.x.SizeSelectors;
import b.o.a.x.SizeSelectors2;
import b.o.a.x.SizeSelectors3;
import b.o.a.x.SizeSelectors4;
import b.o.a.x.SizeSelectors5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView extends FrameLayout implements LifecycleObserver {
    public static final String j;
    public static final CameraLogger k;
    public Size3 A;
    public MediaActionSound B;
    public AutoFocusMarker C;

    @VisibleForTesting
    public List<CameraListener> D;

    @VisibleForTesting
    public List<FrameProcessor> E;
    public Lifecycle F;

    @VisibleForTesting
    public PinchGestureFinder G;

    @VisibleForTesting
    public TapGestureFinder H;

    @VisibleForTesting
    public ScrollGestureFinder I;

    @VisibleForTesting
    public GridLinesLayout J;

    @VisibleForTesting
    public MarkerLayout K;
    public boolean L;
    public boolean M;

    @VisibleForTesting
    public OverlayLayout N;
    public boolean l;
    public boolean m;
    public boolean n;
    public HashMap<Gesture, GestureAction> o;
    public Preview p;
    public Engine q;
    public Filter2 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3173s;
    public int t;
    public Handler u;
    public Executor v;

    @VisibleForTesting
    public b w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CameraPreview f3174x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public OrientationHelper2 f3175y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CameraEngine f3176z;

    public class a implements ThreadFactory {
        public final AtomicInteger j = new AtomicInteger(1);

        public a(CameraView cameraView) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder sbU = outline.U("FrameExecutor #");
            sbU.append(this.j.getAndIncrement());
            return new Thread(runnable, sbU.toString());
        }
    }

    @VisibleForTesting
    public class b implements CameraEngine.g, OrientationHelper2.c, GestureFinder.a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CameraLogger f3177b;

        public class a implements Runnable {
            public final /* synthetic */ float j;
            public final /* synthetic */ PointF[] k;

            public a(float f, PointF[] pointFArr) {
                this.j = f;
                this.k = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$b, reason: collision with other inner class name */
        public class RunnableC0371b implements Runnable {
            public final /* synthetic */ float j;
            public final /* synthetic */ float[] k;
            public final /* synthetic */ PointF[] l;

            public RunnableC0371b(float f, float[] fArr, PointF[] pointFArr) {
                this.j = f;
                this.k = fArr;
                this.l = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ Frame2 j;

            public c(Frame2 frame2) {
                this.j = frame2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f3177b.a(0, "dispatchFrame: executing. Passing", Long.valueOf(this.j.a()), "to processors.");
                Iterator<FrameProcessor> it = CameraView.this.E.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(this.j);
                    } catch (Exception e) {
                        b.this.f3177b.a(2, "Frame processor crashed:", e);
                    }
                }
                this.j.b();
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ CameraException j;

            public d(CameraException cameraException) {
                this.j = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    it.next().b(this.j);
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.requestLayout();
            }
        }

        public class f implements Runnable {
            public final /* synthetic */ PointF j;
            public final /* synthetic */ Gesture k;

            public f(PointF pointF, Gesture gesture) {
                this.j = pointF;
                this.k = gesture;
            }

            @Override // java.lang.Runnable
            public void run() {
                MarkerLayout markerLayout = CameraView.this.K;
                PointF[] pointFArr = {this.j};
                View view = markerLayout.j.get(1);
                if (view != null) {
                    view.clearAnimation();
                    PointF pointF = pointFArr[0];
                    float width = (int) (pointF.x - (view.getWidth() / 2));
                    float height = (int) (pointF.y - (view.getHeight() / 2));
                    view.setTranslationX(width);
                    view.setTranslationY(height);
                }
                AutoFocusMarker autoFocusMarker = CameraView.this.C;
                if (autoFocusMarker != null) {
                    autoFocusMarker.a(this.k != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.j);
                }
                Iterator<CameraListener> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public class g implements Runnable {
            public final /* synthetic */ boolean j;
            public final /* synthetic */ Gesture k;
            public final /* synthetic */ PointF l;

            public g(boolean z2, Gesture gesture, PointF pointF) {
                this.j = z2;
                this.k = gesture;
                this.l = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView;
                boolean z2;
                if (this.j && (z2 = (cameraView = CameraView.this).l) && z2) {
                    if (cameraView.B == null) {
                        cameraView.B = new MediaActionSound();
                    }
                    cameraView.B.play(1);
                }
                AutoFocusMarker autoFocusMarker = CameraView.this.C;
                if (autoFocusMarker != null) {
                    autoFocusMarker.c(this.k != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.j, this.l);
                }
                Iterator<CameraListener> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public b() {
            String simpleName = b.class.getSimpleName();
            this.a = simpleName;
            this.f3177b = new CameraLogger(simpleName);
        }

        public void a(CameraException cameraException) {
            this.f3177b.a(1, "dispatchError", cameraException);
            CameraView.this.u.post(new d(cameraException));
        }

        public void b(@NonNull Frame2 frame2) {
            this.f3177b.a(0, "dispatchFrame:", Long.valueOf(frame2.a()), "processors:", Integer.valueOf(CameraView.this.E.size()));
            if (CameraView.this.E.isEmpty()) {
                frame2.b();
            } else {
                CameraView.this.v.execute(new c(frame2));
            }
        }

        public void c(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.f3177b.a(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f2));
            CameraView.this.u.post(new RunnableC0371b(f2, fArr, pointFArr));
        }

        public void d(@Nullable Gesture gesture, boolean z2, @NonNull PointF pointF) {
            this.f3177b.a(1, "dispatchOnFocusEnd", gesture, Boolean.valueOf(z2), pointF);
            CameraView.this.u.post(new g(z2, gesture, pointF));
        }

        public void e(@Nullable Gesture gesture, @NonNull PointF pointF) {
            this.f3177b.a(1, "dispatchOnFocusStart", gesture, pointF);
            CameraView.this.u.post(new f(pointF, gesture));
        }

        public void f(float f2, @Nullable PointF[] pointFArr) {
            this.f3177b.a(1, "dispatchOnZoomChanged", Float.valueOf(f2));
            CameraView.this.u.post(new a(f2, pointFArr));
        }

        @NonNull
        public Context g() {
            return CameraView.this.getContext();
        }

        public void h() {
            Size3 size3C = CameraView.this.f3176z.C(Reference2.VIEW);
            if (size3C == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            }
            if (size3C.equals(CameraView.this.A)) {
                this.f3177b.a(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", size3C);
            } else {
                this.f3177b.a(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", size3C);
                CameraView.this.u.post(new e());
            }
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        j = simpleName;
        k = new CameraLogger(simpleName);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        Filter2 noFilter;
        super(context, attributeSet);
        this.o = new HashMap<>(4);
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        boolean zIsInEditMode = isInEditMode();
        this.M = zIsInEditMode;
        if (zIsInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.c.CameraView, 0, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraPreview, Preview.GL_SURFACE.g());
        int i3 = R.c.CameraView_cameraFacing;
        Facing facing = Facing.BACK;
        if (!CameraUtils2.a(facing)) {
            Facing facing2 = Facing.FRONT;
            if (CameraUtils2.a(facing2)) {
                facing = facing2;
            }
        }
        int integer2 = typedArrayObtainStyledAttributes.getInteger(i3, facing.g());
        int integer3 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFlash, Flash.OFF.g());
        int integer4 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGrid, Grid.OFF.g());
        int integer5 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraWhiteBalance, WhiteBalance.AUTO.g());
        int integer6 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraMode, Mode3.PICTURE.g());
        int integer7 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraHdr, Hdr.OFF.g());
        int integer8 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudio, Audio.ON.g());
        int integer9 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoCodec, VideoCodec.DEVICE_DEFAULT.g());
        int integer10 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudioCodec, AudioCodec.DEVICE_DEFAULT.g());
        int integer11 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraEngine, Engine.CAMERA1.g());
        int integer12 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraPictureFormat, PictureFormat.JPEG.g());
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPlaySounds, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraUseDeviceOrientation, true);
        this.L = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraExperimental, false);
        this.n = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraRequestPermissions, true);
        this.p = Preview.f(integer);
        this.q = Engine.f(integer11);
        int color = typedArrayObtainStyledAttributes.getColor(R.c.CameraView_cameraGridColor, GridLinesLayout.j);
        long j2 = (long) typedArrayObtainStyledAttributes.getFloat(R.c.CameraView_cameraVideoMaxSize, 0.0f);
        int integer13 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoMaxDuration, 0);
        int integer14 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoBitRate, 0);
        int integer15 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudioBitRate, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.c.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPreviewFrameRateExact, false);
        long integer16 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAutoFocusResetDelay, PathInterpolatorCompat.MAX_NUM_POINTS);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureMetering, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSnapshotMetering, false);
        int integer17 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraSnapshotMaxWidth, 0);
        int integer18 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraSnapshotMaxHeight, 0);
        int integer19 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer20 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer21 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingFormat, 0);
        int integer22 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer23 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingExecutors, 1);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraDrawHardwareOverlays, false);
        ArrayList arrayList = new ArrayList(3);
        int i4 = R.c.CameraView_cameraPictureSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            i = 0;
            arrayList.add(f.N0(typedArrayObtainStyledAttributes.getInteger(i4, 0)));
        } else {
            i = 0;
        }
        int i5 = R.c.CameraView_cameraPictureSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            arrayList.add(f.L0(typedArrayObtainStyledAttributes.getInteger(i5, i)));
        }
        int i6 = R.c.CameraView_cameraPictureSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            arrayList.add(f.M0(typedArrayObtainStyledAttributes.getInteger(i6, i)));
        }
        int i7 = R.c.CameraView_cameraPictureSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            arrayList.add(f.K0(typedArrayObtainStyledAttributes.getInteger(i7, i)));
        }
        int i8 = R.c.CameraView_cameraPictureSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            arrayList.add(f.D1(new SizeSelectors5(typedArrayObtainStyledAttributes.getInteger(i8, i))));
        }
        int i9 = R.c.CameraView_cameraPictureSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            arrayList.add(f.D1(new SizeSelectors4(typedArrayObtainStyledAttributes.getInteger(i9, 0))));
        }
        int i10 = R.c.CameraView_cameraPictureSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            arrayList.add(f.D1(new SizeSelectors(AspectRatio2.h(typedArrayObtainStyledAttributes.getString(i10)).i(), 0.0f)));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(new SizeSelectors3());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(new SizeSelectors2());
        }
        SizeSelector sizeSelectorG = !arrayList.isEmpty() ? f.g((SizeSelector[]) arrayList.toArray(new SizeSelector[0])) : new SizeSelectors2();
        ArrayList arrayList2 = new ArrayList(3);
        int i11 = R.c.CameraView_cameraVideoSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            i2 = 0;
            arrayList2.add(f.N0(typedArrayObtainStyledAttributes.getInteger(i11, 0)));
        } else {
            i2 = 0;
        }
        int i12 = R.c.CameraView_cameraVideoSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            arrayList2.add(f.L0(typedArrayObtainStyledAttributes.getInteger(i12, i2)));
        }
        int i13 = R.c.CameraView_cameraVideoSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            arrayList2.add(f.M0(typedArrayObtainStyledAttributes.getInteger(i13, i2)));
        }
        int i14 = R.c.CameraView_cameraVideoSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            arrayList2.add(f.K0(typedArrayObtainStyledAttributes.getInteger(i14, i2)));
        }
        int i15 = R.c.CameraView_cameraVideoSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            arrayList2.add(f.D1(new SizeSelectors5(typedArrayObtainStyledAttributes.getInteger(i15, i2))));
        }
        int i16 = R.c.CameraView_cameraVideoSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            arrayList2.add(f.D1(new SizeSelectors4(typedArrayObtainStyledAttributes.getInteger(i16, 0))));
        }
        int i17 = R.c.CameraView_cameraVideoSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            arrayList2.add(f.D1(new SizeSelectors(AspectRatio2.h(typedArrayObtainStyledAttributes.getString(i17)).i(), 0.0f)));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(new SizeSelectors3());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(new SizeSelectors2());
        }
        SizeSelector sizeSelectorG2 = !arrayList2.isEmpty() ? f.g((SizeSelector[]) arrayList2.toArray(new SizeSelector[0])) : new SizeSelectors2();
        int i18 = R.c.CameraView_cameraGestureTap;
        GestureAction gestureAction = GestureAction.j;
        int integer24 = typedArrayObtainStyledAttributes.getInteger(i18, gestureAction.h());
        int integer25 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureLongTap, gestureAction.h());
        int integer26 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGesturePinch, gestureAction.h());
        int integer27 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureScrollHorizontal, gestureAction.h());
        int integer28 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureScrollVertical, gestureAction.h());
        String string = typedArrayObtainStyledAttributes.getString(R.c.CameraView_cameraAutoFocusMarker);
        AutoFocusMarker autoFocusMarker = null;
        if (string != null) {
            try {
                autoFocusMarker = (AutoFocusMarker) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
        try {
            noFilter = (Filter2) Class.forName(typedArrayObtainStyledAttributes.getString(R.c.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused2) {
            noFilter = new NoFilter();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.w = new b();
        this.u = new Handler(Looper.getMainLooper());
        this.G = new PinchGestureFinder(this.w);
        this.H = new TapGestureFinder(this.w);
        this.I = new ScrollGestureFinder(this.w);
        this.J = new GridLinesLayout(context);
        this.N = new OverlayLayout(context);
        this.K = new MarkerLayout(context);
        addView(this.J);
        addView(this.K);
        addView(this.N);
        b();
        setPlaySounds(z2);
        setUseDeviceOrientation(z3);
        setGrid(Grid.f(integer4));
        setGridColor(color);
        setDrawHardwareOverlays(z7);
        setFacing(Facing.f(integer2));
        setFlash(Flash.f(integer3));
        setMode(Mode3.f(integer6));
        setWhiteBalance(WhiteBalance.f(integer5));
        setHdr(Hdr.f(integer7));
        setAudio(Audio.f(integer8));
        setAudioBitRate(integer15);
        setAudioCodec(AudioCodec.f(integer10));
        setPictureSize(sizeSelectorG);
        setPictureMetering(z5);
        setPictureSnapshotMetering(z6);
        setPictureFormat(PictureFormat.f(integer12));
        setVideoSize(sizeSelectorG2);
        setVideoCodec(VideoCodec.f(integer9));
        setVideoMaxSize(j2);
        setVideoMaxDuration(integer13);
        setVideoBitRate(integer14);
        setAutoFocusResetDelay(integer16);
        setPreviewFrameRateExact(z4);
        setPreviewFrameRate(f);
        setSnapshotMaxWidth(integer17);
        setSnapshotMaxHeight(integer18);
        setFrameProcessingMaxWidth(integer19);
        setFrameProcessingMaxHeight(integer20);
        setFrameProcessingFormat(integer21);
        setFrameProcessingPoolSize(integer22);
        setFrameProcessingExecutors(integer23);
        e(Gesture.k, GestureAction.f(integer24));
        e(Gesture.l, GestureAction.f(integer25));
        e(Gesture.j, GestureAction.f(integer26));
        e(Gesture.m, GestureAction.f(integer27));
        e(Gesture.n, GestureAction.f(integer28));
        setAutoFocusMarker(autoFocusMarker);
        setFilter(noFilter);
        this.f3175y = new OrientationHelper2(context, this.w);
    }

    @SuppressLint({"NewApi"})
    public boolean a(@NonNull Audio audio) {
        Audio audio2 = Audio.STEREO;
        Audio audio3 = Audio.MONO;
        Audio audio4 = Audio.ON;
        if (audio == audio4 || audio == audio3 || audio == audio2) {
            try {
                String[] strArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        throw new IllegalStateException(k.a(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
                    }
                    if (strArr[i].equals("android.permission.RECORD_AUDIO")) {
                        break;
                    }
                    i++;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z2 = audio == audio4 || audio == audio3 || audio == audio2;
        boolean z3 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z4 = z2 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z3 && !z4) {
            return true;
        }
        if (this.n) {
            Activity activity = null;
            for (Context context2 = getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (z3) {
                arrayList.add("android.permission.CAMERA");
            }
            if (z4) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (activity != null) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.M) {
            Objects.requireNonNull(this.N);
            if (layoutParams instanceof OverlayLayout.a) {
                this.N.addView(view, layoutParams);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b() {
        CameraEngine camera1Engine2;
        CameraLogger cameraLogger = k;
        cameraLogger.a(2, "doInstantiateEngine:", "instantiating. engine:", this.q);
        Engine engine = this.q;
        b bVar = this.w;
        if (this.L && engine == Engine.CAMERA2) {
            camera1Engine2 = new Camera2Engine(bVar);
        } else {
            this.q = Engine.CAMERA1;
            camera1Engine2 = new Camera1Engine2(bVar);
        }
        this.f3176z = camera1Engine2;
        cameraLogger.a(2, "doInstantiateEngine:", "instantiated. engine:", camera1Engine2.getClass().getSimpleName());
        this.f3176z.o0(this.N);
    }

    public final boolean c() {
        CameraEngine cameraEngine = this.f3176z;
        return cameraEngine.n.f == CameraState2.OFF && !cameraEngine.O();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.M) {
            return;
        }
        OrientationHelper2 orientationHelper2 = this.f3175y;
        if (orientationHelper2.h) {
            orientationHelper2.h = false;
            orientationHelper2.d.disable();
            ((DisplayManager) orientationHelper2.f1951b.getSystemService("display")).unregisterDisplayListener(orientationHelper2.f);
            orientationHelper2.g = -1;
            orientationHelper2.e = -1;
        }
        this.f3176z.L0(false);
        CameraPreview cameraPreview = this.f3174x;
        if (cameraPreview != null) {
            cameraPreview.p();
        }
    }

    public boolean d() {
        CameraState2 cameraState2 = this.f3176z.n.f;
        CameraState2 cameraState3 = CameraState2.ENGINE;
        return cameraState2.f(cameraState3) && this.f3176z.n.g.f(cameraState3);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.M) {
            return;
        }
        this.D.clear();
        boolean z2 = this.E.size() > 0;
        this.E.clear();
        if (z2) {
            this.f3176z.k0(false);
        }
        this.f3176z.d(true, 0);
        CameraPreview cameraPreview = this.f3174x;
        if (cameraPreview != null) {
            cameraPreview.o();
        }
    }

    public boolean e(@NonNull Gesture gesture, @NonNull GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.j;
        if (!gesture.f(gestureAction)) {
            e(gesture, gestureAction2);
            return false;
        }
        this.o.put(gesture, gestureAction);
        int iOrdinal = gesture.ordinal();
        if (iOrdinal == 0) {
            this.G.a = this.o.get(Gesture.j) != gestureAction2;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            this.H.a = (this.o.get(Gesture.k) == gestureAction2 && this.o.get(Gesture.l) == gestureAction2) ? false : true;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            this.I.a = (this.o.get(Gesture.m) == gestureAction2 && this.o.get(Gesture.n) == gestureAction2) ? false : true;
        }
        this.t = 0;
        Iterator<GestureAction> it = this.o.values().iterator();
        while (it.hasNext()) {
            this.t += it.next() == gestureAction2 ? 0 : 1;
        }
        return true;
    }

    public final String f(int i) {
        if (i == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    public final void g(@NonNull GestureFinder gestureFinder, @NonNull CameraOptions cameraOptions) {
        Gesture gesture = gestureFinder.f1947b;
        GestureAction gestureAction = this.o.get(gesture);
        PointF[] pointFArr = gestureFinder.c;
        switch (gestureAction.ordinal()) {
            case 1:
                float width = getWidth();
                float height = getHeight();
                RectF rectFA = MeteringRegions.a(pointFArr[0], width * 0.05f, 0.05f * height);
                ArrayList<MeteringRegion> arrayList = new ArrayList();
                PointF pointF = new PointF(rectFA.centerX(), rectFA.centerY());
                float fWidth = rectFA.width();
                float fHeight = rectFA.height();
                arrayList.add(new MeteringRegion(rectFA, 1000));
                arrayList.add(new MeteringRegion(MeteringRegions.a(pointF, fWidth * 1.5f, fHeight * 1.5f), Math.round(1000 * 0.1f)));
                ArrayList arrayList2 = new ArrayList();
                for (MeteringRegion meteringRegion : arrayList) {
                    Objects.requireNonNull(meteringRegion);
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    RectF rectF2 = new RectF();
                    rectF2.set(Math.max(rectF.left, meteringRegion.j.left), Math.max(rectF.top, meteringRegion.j.top), Math.min(rectF.right, meteringRegion.j.right), Math.min(rectF.bottom, meteringRegion.j.bottom));
                    arrayList2.add(new MeteringRegion(rectF2, meteringRegion.k));
                }
                this.f3176z.I0(gesture, new MeteringRegions(arrayList2), pointFArr[0]);
                break;
            case 2:
                this.f3176z.O0(new PictureResult.a());
                break;
            case 3:
                this.f3176z.P0(new PictureResult.a());
                break;
            case 4:
                float fN = this.f3176z.N();
                float fA = gestureFinder.a(fN, 0.0f, 1.0f);
                if (fA != fN) {
                    this.f3176z.G0(fA, pointFArr, true);
                }
                break;
            case 5:
                float fK = this.f3176z.k();
                float f = cameraOptions.m;
                float f2 = cameraOptions.n;
                float fA2 = gestureFinder.a(fK, f, f2);
                if (fA2 != fK) {
                    this.f3176z.d0(fA2, new float[]{f, f2}, pointFArr, true);
                }
                break;
            case 6:
                if (getFilter() instanceof OneParameterFilter) {
                    OneParameterFilter oneParameterFilter = (OneParameterFilter) getFilter();
                    float fI = oneParameterFilter.i();
                    float fA3 = gestureFinder.a(fI, 0.0f, 1.0f);
                    if (fA3 != fI) {
                        oneParameterFilter.d(fA3);
                    }
                }
                break;
            case 7:
                if (getFilter() instanceof TwoParameterFilter) {
                    TwoParameterFilter twoParameterFilter = (TwoParameterFilter) getFilter();
                    float fG = twoParameterFilter.g();
                    float fA4 = gestureFinder.a(fG, 0.0f, 1.0f);
                    if (fA4 != fG) {
                        twoParameterFilter.b(fA4);
                    }
                }
                break;
        }
    }

    @NonNull
    public Audio getAudio() {
        return this.f3176z.f();
    }

    public int getAudioBitRate() {
        return this.f3176z.g();
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        return this.f3176z.h();
    }

    public long getAutoFocusResetDelay() {
        return this.f3176z.i();
    }

    @Nullable
    public CameraOptions getCameraOptions() {
        return this.f3176z.j();
    }

    public boolean getDrawHardwareOverlays() {
        return this.N.getHardwareCanvasEnabled();
    }

    @NonNull
    public Engine getEngine() {
        return this.q;
    }

    public float getExposureCorrection() {
        return this.f3176z.k();
    }

    @NonNull
    public Facing getFacing() {
        return this.f3176z.l();
    }

    @NonNull
    public Filter2 getFilter() {
        Object obj = this.f3174x;
        if (obj == null) {
            return this.r;
        }
        if (obj instanceof FilterCameraPreview) {
            return ((FilterCameraPreview) obj).c();
        }
        StringBuilder sbU = outline.U("Filters are only supported by the GL_SURFACE preview. Current:");
        sbU.append(this.p);
        throw new RuntimeException(sbU.toString());
    }

    @NonNull
    public Flash getFlash() {
        return this.f3176z.m();
    }

    public int getFrameProcessingExecutors() {
        return this.f3173s;
    }

    public int getFrameProcessingFormat() {
        return this.f3176z.n();
    }

    public int getFrameProcessingMaxHeight() {
        return this.f3176z.o();
    }

    public int getFrameProcessingMaxWidth() {
        return this.f3176z.p();
    }

    public int getFrameProcessingPoolSize() {
        return this.f3176z.q();
    }

    @NonNull
    public Grid getGrid() {
        return this.J.getGridMode();
    }

    public int getGridColor() {
        return this.J.getGridColor();
    }

    @NonNull
    public Hdr getHdr() {
        return this.f3176z.r();
    }

    @Nullable
    public Location getLocation() {
        return this.f3176z.s();
    }

    @NonNull
    public Mode3 getMode() {
        return this.f3176z.t();
    }

    @NonNull
    public PictureFormat getPictureFormat() {
        return this.f3176z.u();
    }

    public boolean getPictureMetering() {
        return this.f3176z.v();
    }

    @Nullable
    public Size3 getPictureSize() {
        return this.f3176z.w(Reference2.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.f3176z.y();
    }

    public boolean getPlaySounds() {
        return this.l;
    }

    @NonNull
    public Preview getPreview() {
        return this.p;
    }

    public float getPreviewFrameRate() {
        return this.f3176z.A();
    }

    public boolean getPreviewFrameRateExact() {
        return this.f3176z.B();
    }

    public int getSnapshotMaxHeight() {
        return this.f3176z.D();
    }

    public int getSnapshotMaxWidth() {
        return this.f3176z.E();
    }

    @Nullable
    public Size3 getSnapshotSize() {
        Size3 size3 = null;
        if (getWidth() != 0 && getHeight() != 0) {
            CameraEngine cameraEngine = this.f3176z;
            Reference2 reference2 = Reference2.VIEW;
            Size3 size3F = cameraEngine.F(reference2);
            if (size3F == null) {
                return null;
            }
            Rect rectL = f.L(size3F, AspectRatio2.f(getWidth(), getHeight()));
            size3 = new Size3(rectL.width(), rectL.height());
            if (this.f3176z.e().b(reference2, Reference2.OUTPUT)) {
                return size3.f();
            }
        }
        return size3;
    }

    public boolean getUseDeviceOrientation() {
        return this.m;
    }

    public int getVideoBitRate() {
        return this.f3176z.G();
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        return this.f3176z.H();
    }

    public int getVideoMaxDuration() {
        return this.f3176z.I();
    }

    public long getVideoMaxSize() {
        return this.f3176z.J();
    }

    @Nullable
    public Size3 getVideoSize() {
        return this.f3176z.K(Reference2.OUTPUT);
    }

    @NonNull
    public WhiteBalance getWhiteBalance() {
        return this.f3176z.M();
    }

    public float getZoom() {
        return this.f3176z.N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        CameraPreview surfaceCameraPreview2;
        super.onAttachedToWindow();
        if (!this.M && this.f3174x == null) {
            CameraLogger cameraLogger = k;
            cameraLogger.a(2, "doInstantiateEngine:", "instantiating. preview:", this.p);
            Preview preview = this.p;
            Context context = getContext();
            int iOrdinal = preview.ordinal();
            if (iOrdinal == 0) {
                surfaceCameraPreview2 = new SurfaceCameraPreview2(context, this);
            } else if (iOrdinal == 1 && isHardwareAccelerated()) {
                surfaceCameraPreview2 = new TextureCameraPreview2(context, this);
            } else {
                this.p = Preview.GL_SURFACE;
                surfaceCameraPreview2 = new GlCameraPreview2(context, this);
            }
            this.f3174x = surfaceCameraPreview2;
            cameraLogger.a(2, "doInstantiateEngine:", "instantiated. preview:", surfaceCameraPreview2.getClass().getSimpleName());
            this.f3176z.u0(this.f3174x);
            Filter2 filter2 = this.r;
            if (filter2 != null) {
                setFilter(filter2);
                this.r = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.t > 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.M) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), BasicMeasure.EXACTLY));
            return;
        }
        Size3 size3C = this.f3176z.C(Reference2.VIEW);
        this.A = size3C;
        if (size3C == null) {
            k.a(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Size3 size3 = this.A;
        float f = size3.j;
        float f2 = size3.k;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f3174x.u()) {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = BasicMeasure.EXACTLY;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = BasicMeasure.EXACTLY;
            }
        } else {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        }
        CameraLogger cameraLogger = k;
        StringBuilder sbV = outline.V("requested dimensions are (", size, "[");
        sbV.append(f(mode));
        sbV.append("]x");
        sbV.append(size2);
        sbV.append("[");
        sbV.append(f(mode2));
        sbV.append("])");
        cameraLogger.a(1, "onMeasure:", sbV.toString());
        cameraLogger.a(1, "onMeasure:", "previewSize is", "(" + f + "x" + f2 + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            cameraLogger.a(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            cameraLogger.a(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f + "x" + f2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) f2, BasicMeasure.EXACTLY));
            return;
        }
        float f3 = f2 / f;
        if (mode == 0 || mode2 == 0) {
            if (mode == 0) {
                size = Math.round(size2 / f3);
            } else {
                size2 = Math.round(size * f3);
            }
            cameraLogger.a(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(Math.round(size2 / f3), size);
            } else {
                size2 = Math.min(Math.round(size * f3), size2);
            }
            cameraLogger.a(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        float f4 = size2;
        float f5 = size;
        if (f4 / f5 >= f3) {
            size2 = Math.round(f5 * f3);
        } else {
            size = Math.round(f4 / f3);
        }
        cameraLogger.a(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!d()) {
            return true;
        }
        CameraOptions cameraOptionsJ = this.f3176z.j();
        if (cameraOptionsJ == null) {
            throw new IllegalStateException("Options should not be null here.");
        }
        PinchGestureFinder pinchGestureFinder = this.G;
        if (!pinchGestureFinder.a ? false : pinchGestureFinder.c(motionEvent)) {
            k.a(1, "onTouchEvent", "pinch!");
            g(this.G, cameraOptionsJ);
        } else {
            ScrollGestureFinder scrollGestureFinder = this.I;
            if (!scrollGestureFinder.a ? false : scrollGestureFinder.c(motionEvent)) {
                k.a(1, "onTouchEvent", "scroll!");
                g(this.I, cameraOptionsJ);
            } else {
                TapGestureFinder tapGestureFinder = this.H;
                if (!tapGestureFinder.a ? false : tapGestureFinder.c(motionEvent)) {
                    k.a(1, "onTouchEvent", "tap!");
                    g(this.H, cameraOptionsJ);
                }
            }
        }
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.M) {
            return;
        }
        CameraPreview cameraPreview = this.f3174x;
        if (cameraPreview != null) {
            cameraPreview.q();
        }
        if (a(getAudio())) {
            OrientationHelper2 orientationHelper2 = this.f3175y;
            if (!orientationHelper2.h) {
                orientationHelper2.h = true;
                orientationHelper2.g = orientationHelper2.a();
                ((DisplayManager) orientationHelper2.f1951b.getSystemService("display")).registerDisplayListener(orientationHelper2.f, orientationHelper2.a);
                orientationHelper2.d.enable();
            }
            Angles anglesE = this.f3176z.e();
            int i = this.f3175y.g;
            anglesE.e(i);
            anglesE.d = i;
            anglesE.d();
            this.f3176z.H0();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.M && layoutParams != null) {
            Objects.requireNonNull(this.N);
            if (layoutParams instanceof OverlayLayout.a) {
                this.N.removeView(view);
                return;
            }
        }
        super.removeView(view);
    }

    public void set(@NonNull Control control) {
        if (control instanceof Audio) {
            setAudio((Audio) control);
            return;
        }
        if (control instanceof Facing) {
            setFacing((Facing) control);
            return;
        }
        if (control instanceof Flash) {
            setFlash((Flash) control);
            return;
        }
        if (control instanceof Grid) {
            setGrid((Grid) control);
            return;
        }
        if (control instanceof Hdr) {
            setHdr((Hdr) control);
            return;
        }
        if (control instanceof Mode3) {
            setMode((Mode3) control);
            return;
        }
        if (control instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) control);
            return;
        }
        if (control instanceof VideoCodec) {
            setVideoCodec((VideoCodec) control);
            return;
        }
        if (control instanceof AudioCodec) {
            setAudioCodec((AudioCodec) control);
            return;
        }
        if (control instanceof Preview) {
            setPreview((Preview) control);
        } else if (control instanceof Engine) {
            setEngine((Engine) control);
        } else if (control instanceof PictureFormat) {
            setPictureFormat((PictureFormat) control);
        }
    }

    public void setAudio(@NonNull Audio audio) {
        if (audio == getAudio() || c()) {
            this.f3176z.Z(audio);
        } else if (a(audio)) {
            this.f3176z.Z(audio);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i) {
        this.f3176z.a0(i);
    }

    public void setAudioCodec(@NonNull AudioCodec audioCodec) {
        this.f3176z.b0(audioCodec);
    }

    public void setAutoFocusMarker(@Nullable AutoFocusMarker autoFocusMarker) {
        View viewB;
        this.C = autoFocusMarker;
        MarkerLayout markerLayout = this.K;
        View view = markerLayout.j.get(1);
        if (view != null) {
            markerLayout.removeView(view);
        }
        if (autoFocusMarker == null || (viewB = autoFocusMarker.b(markerLayout.getContext(), markerLayout)) == null) {
            return;
        }
        markerLayout.j.put(1, viewB);
        markerLayout.addView(viewB);
    }

    public void setAutoFocusResetDelay(long j2) {
        this.f3176z.c0(j2);
    }

    public void setDrawHardwareOverlays(boolean z2) {
        this.N.setHardwareCanvasEnabled(z2);
    }

    public void setEngine(@NonNull Engine engine) {
        if (c()) {
            this.q = engine;
            CameraEngine cameraEngine = this.f3176z;
            b();
            CameraPreview cameraPreview = this.f3174x;
            if (cameraPreview != null) {
                this.f3176z.u0(cameraPreview);
            }
            setFacing(cameraEngine.l());
            setFlash(cameraEngine.m());
            setMode(cameraEngine.t());
            setWhiteBalance(cameraEngine.M());
            setHdr(cameraEngine.r());
            setAudio(cameraEngine.f());
            setAudioBitRate(cameraEngine.g());
            setAudioCodec(cameraEngine.h());
            setPictureSize(cameraEngine.x());
            setPictureFormat(cameraEngine.u());
            setVideoSize(cameraEngine.L());
            setVideoCodec(cameraEngine.H());
            setVideoMaxSize(cameraEngine.J());
            setVideoMaxDuration(cameraEngine.I());
            setVideoBitRate(cameraEngine.G());
            setAutoFocusResetDelay(cameraEngine.i());
            setPreviewFrameRate(cameraEngine.A());
            setPreviewFrameRateExact(cameraEngine.B());
            setSnapshotMaxWidth(cameraEngine.E());
            setSnapshotMaxHeight(cameraEngine.D());
            setFrameProcessingMaxWidth(cameraEngine.p());
            setFrameProcessingMaxHeight(cameraEngine.o());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.q());
            this.f3176z.k0(!this.E.isEmpty());
        }
    }

    public void setExperimental(boolean z2) {
        this.L = z2;
    }

    public void setExposureCorrection(float f) {
        CameraOptions cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f2 = cameraOptions.m;
            float f3 = cameraOptions.n;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                f = f3;
            }
            this.f3176z.d0(f, new float[]{f2, f3}, null, false);
        }
    }

    public void setFacing(@NonNull Facing facing) {
        this.f3176z.e0(facing);
    }

    public void setFilter(@NonNull Filter2 filter2) {
        Object obj = this.f3174x;
        if (obj == null) {
            this.r = filter2;
            return;
        }
        boolean z2 = obj instanceof FilterCameraPreview;
        if (!(filter2 instanceof NoFilter) && !z2) {
            StringBuilder sbU = outline.U("Filters are only supported by the GL_SURFACE preview. Current preview:");
            sbU.append(this.p);
            throw new RuntimeException(sbU.toString());
        }
        if (z2) {
            ((FilterCameraPreview) obj).a(filter2);
        }
    }

    public void setFlash(@NonNull Flash flash) {
        this.f3176z.f0(flash);
    }

    public void setFrameProcessingExecutors(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(outline.q("Need at least 1 executor, got ", i));
        }
        this.f3173s = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.v = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i) {
        this.f3176z.g0(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.f3176z.h0(i);
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.f3176z.i0(i);
    }

    public void setFrameProcessingPoolSize(int i) {
        this.f3176z.j0(i);
    }

    public void setGrid(@NonNull Grid grid) {
        this.J.setGridMode(grid);
    }

    public void setGridColor(@ColorInt int i) {
        this.J.setGridColor(i);
    }

    public void setHdr(@NonNull Hdr hdr) {
        this.f3176z.l0(hdr);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Lifecycle lifecycle = this.F;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
                this.F = null;
                return;
            }
            return;
        }
        Lifecycle lifecycle2 = this.F;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
            this.F = null;
        }
        Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
        this.F = lifecycle3;
        lifecycle3.addObserver(this);
    }

    public void setLocation(@Nullable Location location) {
        this.f3176z.m0(location);
    }

    public void setMode(@NonNull Mode3 mode3) {
        this.f3176z.n0(mode3);
    }

    public void setPictureFormat(@NonNull PictureFormat pictureFormat) {
        this.f3176z.p0(pictureFormat);
    }

    public void setPictureMetering(boolean z2) {
        this.f3176z.q0(z2);
    }

    public void setPictureSize(@NonNull SizeSelector sizeSelector) {
        this.f3176z.r0(sizeSelector);
    }

    public void setPictureSnapshotMetering(boolean z2) {
        this.f3176z.s0(z2);
    }

    public void setPlaySounds(boolean z2) {
        this.l = z2;
        this.f3176z.t0(z2);
    }

    public void setPreview(@NonNull Preview preview) {
        CameraPreview cameraPreview;
        if (preview != this.p) {
            this.p = preview;
            if ((getWindowToken() != null) || (cameraPreview = this.f3174x) == null) {
                return;
            }
            cameraPreview.o();
            this.f3174x = null;
        }
    }

    public void setPreviewFrameRate(float f) {
        this.f3176z.v0(f);
    }

    public void setPreviewFrameRateExact(boolean z2) {
        this.f3176z.w0(z2);
    }

    public void setPreviewStreamSize(@NonNull SizeSelector sizeSelector) {
        this.f3176z.x0(sizeSelector);
    }

    public void setRequestPermissions(boolean z2) {
        this.n = z2;
    }

    public void setSnapshotMaxHeight(int i) {
        this.f3176z.y0(i);
    }

    public void setSnapshotMaxWidth(int i) {
        this.f3176z.z0(i);
    }

    public void setUseDeviceOrientation(boolean z2) {
        this.m = z2;
    }

    public void setVideoBitRate(int i) {
        this.f3176z.A0(i);
    }

    public void setVideoCodec(@NonNull VideoCodec videoCodec) {
        this.f3176z.B0(videoCodec);
    }

    public void setVideoMaxDuration(int i) {
        this.f3176z.C0(i);
    }

    public void setVideoMaxSize(long j2) {
        this.f3176z.D0(j2);
    }

    public void setVideoSize(@NonNull SizeSelector sizeSelector) {
        this.f3176z.E0(sizeSelector);
    }

    public void setWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        this.f3176z.F0(whiteBalance);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f3176z.G0(f, null, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.M) {
            OverlayLayout overlayLayout = this.N;
            Objects.requireNonNull(overlayLayout);
            boolean z2 = false;
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = overlayLayout.getContext().obtainStyledAttributes(attributeSet, R.c.CameraView_Layout);
                z2 = typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnPreview) || typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnPictureSnapshot) || typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnVideoSnapshot);
                typedArrayObtainStyledAttributes.recycle();
            }
            if (z2) {
                return this.N.generateLayoutParams(attributeSet);
            }
        }
        return super.generateLayoutParams(attributeSet);
    }
}
