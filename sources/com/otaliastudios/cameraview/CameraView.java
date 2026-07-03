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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.AbstractC5102a;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5106e;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p454m.EnumC5114a;
import p007b.p452o.p453a.p454m.EnumC5115b;
import p007b.p452o.p453a.p454m.EnumC5117d;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5120g;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5124k;
import p007b.p452o.p453a.p454m.EnumC5125l;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p454m.InterfaceC5116c;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p455n.C5128b;
import p007b.p452o.p453a.p455n.C5130d;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p464o.C5185c;
import p007b.p452o.p453a.p464o.InterfaceC5184b;
import p007b.p452o.p453a.p464o.InterfaceC5186d;
import p007b.p452o.p453a.p464o.InterfaceC5187e;
import p007b.p452o.p453a.p465p.C5189b;
import p007b.p452o.p453a.p465p.InterfaceC5191d;
import p007b.p452o.p453a.p466q.AbstractC5195c;
import p007b.p452o.p453a.p466q.C5197e;
import p007b.p452o.p453a.p466q.C5198f;
import p007b.p452o.p453a.p466q.C5199g;
import p007b.p452o.p453a.p466q.EnumC5193a;
import p007b.p452o.p453a.p466q.EnumC5194b;
import p007b.p452o.p453a.p467r.C5203d;
import p007b.p452o.p453a.p467r.C5205f;
import p007b.p452o.p453a.p468s.C5209c;
import p007b.p452o.p453a.p468s.EnumC5208b;
import p007b.p452o.p453a.p468s.InterfaceC5207a;
import p007b.p452o.p453a.p469t.C5210a;
import p007b.p452o.p453a.p469t.C5211b;
import p007b.p452o.p453a.p470u.C5215c;
import p007b.p452o.p453a.p472w.AbstractC5225a;
import p007b.p452o.p453a.p472w.C5228d;
import p007b.p452o.p453a.p472w.C5232h;
import p007b.p452o.p453a.p472w.C5234j;
import p007b.p452o.p453a.p472w.InterfaceC5226b;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p453a.p473x.C5238d;
import p007b.p452o.p453a.p473x.C5239e;
import p007b.p452o.p453a.p473x.C5240f;
import p007b.p452o.p453a.p473x.C5241g;
import p007b.p452o.p453a.p473x.C5242h;
import p007b.p452o.p453a.p473x.InterfaceC5237c;

/* JADX INFO: loaded from: classes3.dex */
public class CameraView extends FrameLayout implements LifecycleObserver {

    /* JADX INFO: renamed from: j */
    public static final String f22108j;

    /* JADX INFO: renamed from: k */
    public static final C5103b f22109k;

    /* JADX INFO: renamed from: A */
    public C5236b f22110A;

    /* JADX INFO: renamed from: B */
    public MediaActionSound f22111B;

    /* JADX INFO: renamed from: C */
    public InterfaceC5207a f22112C;

    /* JADX INFO: renamed from: D */
    @VisibleForTesting
    public List<AbstractC5102a> f22113D;

    /* JADX INFO: renamed from: E */
    @VisibleForTesting
    public List<InterfaceC5191d> f22114E;

    /* JADX INFO: renamed from: F */
    public Lifecycle f22115F;

    /* JADX INFO: renamed from: G */
    @VisibleForTesting
    public C5197e f22116G;

    /* JADX INFO: renamed from: H */
    @VisibleForTesting
    public C5199g f22117H;

    /* JADX INFO: renamed from: I */
    @VisibleForTesting
    public C5198f f22118I;

    /* JADX INFO: renamed from: J */
    @VisibleForTesting
    public C5203d f22119J;

    /* JADX INFO: renamed from: K */
    @VisibleForTesting
    public C5209c f22120K;

    /* JADX INFO: renamed from: L */
    public boolean f22121L;

    /* JADX INFO: renamed from: M */
    public boolean f22122M;

    /* JADX INFO: renamed from: N */
    @VisibleForTesting
    public C5215c f22123N;

    /* JADX INFO: renamed from: l */
    public boolean f22124l;

    /* JADX INFO: renamed from: m */
    public boolean f22125m;

    /* JADX INFO: renamed from: n */
    public boolean f22126n;

    /* JADX INFO: renamed from: o */
    public HashMap<EnumC5193a, EnumC5194b> f22127o;

    /* JADX INFO: renamed from: p */
    public EnumC5124k f22128p;

    /* JADX INFO: renamed from: q */
    public EnumC5117d f22129q;

    /* JADX INFO: renamed from: r */
    public InterfaceC5184b f22130r;

    /* JADX INFO: renamed from: s */
    public int f22131s;

    /* JADX INFO: renamed from: t */
    public int f22132t;

    /* JADX INFO: renamed from: u */
    public Handler f22133u;

    /* JADX INFO: renamed from: v */
    public Executor f22134v;

    /* JADX INFO: renamed from: w */
    @VisibleForTesting
    public C11195b f22135w;

    /* JADX INFO: renamed from: x */
    public AbstractC5225a f22136x;

    /* JADX INFO: renamed from: y */
    public C5205f f22137y;

    /* JADX INFO: renamed from: z */
    public AbstractC5135i f22138z;

    /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$a */
    public class ThreadFactoryC11194a implements ThreadFactory {

        /* JADX INFO: renamed from: j */
        public final AtomicInteger f22139j = new AtomicInteger(1);

        public ThreadFactoryC11194a(CameraView cameraView) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder sbM833U = C1643a.m833U("FrameExecutor #");
            sbM833U.append(this.f22139j.getAndIncrement());
            return new Thread(runnable, sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b */
    @VisibleForTesting
    public class C11195b implements AbstractC5135i.g, C5205f.c, AbstractC5195c.a {

        /* JADX INFO: renamed from: a */
        public final String f22140a;

        /* JADX INFO: renamed from: b */
        public final C5103b f22141b;

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ float f22143j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ PointF[] f22144k;

            public a(float f, PointF[] pointFArr) {
                this.f22143j = f;
                this.f22144k = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$b */
        public class b implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ float f22146j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ float[] f22147k;

            /* JADX INFO: renamed from: l */
            public final /* synthetic */ PointF[] f22148l;

            public b(float f, float[] fArr, PointF[] pointFArr) {
                this.f22146j = f;
                this.f22147k = fArr;
                this.f22148l = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$c */
        public class c implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ C5189b f22150j;

            public c(C5189b c5189b) {
                this.f22150j = c5189b;
            }

            @Override // java.lang.Runnable
            public void run() {
                C11195b.this.f22141b.m7159a(0, "dispatchFrame: executing. Passing", Long.valueOf(this.f22150j.m7383a()), "to processors.");
                Iterator<InterfaceC5191d> it = CameraView.this.f22114E.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().m7387a(this.f22150j);
                    } catch (Exception e) {
                        C11195b.this.f22141b.m7159a(2, "Frame processor crashed:", e);
                    }
                }
                this.f22150j.m7384b();
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$d */
        public class d implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ CameraException f22152j;

            public d(CameraException cameraException) {
                this.f22152j = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    it.next().mo7156b(this.f22152j);
                }
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$e */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.requestLayout();
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$f */
        public class f implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ PointF f22155j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ EnumC5193a f22156k;

            public f(PointF pointF, EnumC5193a enumC5193a) {
                this.f22155j = pointF;
                this.f22156k = enumC5193a;
            }

            @Override // java.lang.Runnable
            public void run() {
                C5209c c5209c = CameraView.this.f22120K;
                PointF[] pointFArr = {this.f22155j};
                View view = c5209c.f14139j.get(1);
                if (view != null) {
                    view.clearAnimation();
                    PointF pointF = pointFArr[0];
                    float width = (int) (pointF.x - (view.getWidth() / 2));
                    float height = (int) (pointF.y - (view.getHeight() / 2));
                    view.setTranslationX(width);
                    view.setTranslationY(height);
                }
                InterfaceC5207a interfaceC5207a = CameraView.this.f22112C;
                if (interfaceC5207a != null) {
                    interfaceC5207a.m7405a(this.f22156k != null ? EnumC5208b.GESTURE : EnumC5208b.METHOD, this.f22155j);
                }
                Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* JADX INFO: renamed from: com.otaliastudios.cameraview.CameraView$b$g */
        public class g implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ boolean f22158j;

            /* JADX INFO: renamed from: k */
            public final /* synthetic */ EnumC5193a f22159k;

            /* JADX INFO: renamed from: l */
            public final /* synthetic */ PointF f22160l;

            public g(boolean z2, EnumC5193a enumC5193a, PointF pointF) {
                this.f22158j = z2;
                this.f22159k = enumC5193a;
                this.f22160l = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView;
                boolean z2;
                if (this.f22158j && (z2 = (cameraView = CameraView.this).f22124l) && z2) {
                    if (cameraView.f22111B == null) {
                        cameraView.f22111B = new MediaActionSound();
                    }
                    cameraView.f22111B.play(1);
                }
                InterfaceC5207a interfaceC5207a = CameraView.this.f22112C;
                if (interfaceC5207a != null) {
                    interfaceC5207a.m7407c(this.f22159k != null ? EnumC5208b.GESTURE : EnumC5208b.METHOD, this.f22158j, this.f22160l);
                }
                Iterator<AbstractC5102a> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public C11195b() {
            String simpleName = C11195b.class.getSimpleName();
            this.f22140a = simpleName;
            this.f22141b = new C5103b(simpleName);
        }

        /* JADX INFO: renamed from: a */
        public void m9311a(CameraException cameraException) {
            this.f22141b.m7159a(1, "dispatchError", cameraException);
            CameraView.this.f22133u.post(new d(cameraException));
        }

        /* JADX INFO: renamed from: b */
        public void m9312b(@NonNull C5189b c5189b) {
            this.f22141b.m7159a(0, "dispatchFrame:", Long.valueOf(c5189b.m7383a()), "processors:", Integer.valueOf(CameraView.this.f22114E.size()));
            if (CameraView.this.f22114E.isEmpty()) {
                c5189b.m7384b();
            } else {
                CameraView.this.f22134v.execute(new c(c5189b));
            }
        }

        /* JADX INFO: renamed from: c */
        public void m9313c(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.f22141b.m7159a(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f2));
            CameraView.this.f22133u.post(new b(f2, fArr, pointFArr));
        }

        /* JADX INFO: renamed from: d */
        public void m9314d(@Nullable EnumC5193a enumC5193a, boolean z2, @NonNull PointF pointF) {
            this.f22141b.m7159a(1, "dispatchOnFocusEnd", enumC5193a, Boolean.valueOf(z2), pointF);
            CameraView.this.f22133u.post(new g(z2, enumC5193a, pointF));
        }

        /* JADX INFO: renamed from: e */
        public void m9315e(@Nullable EnumC5193a enumC5193a, @NonNull PointF pointF) {
            this.f22141b.m7159a(1, "dispatchOnFocusStart", enumC5193a, pointF);
            CameraView.this.f22133u.post(new f(pointF, enumC5193a));
        }

        /* JADX INFO: renamed from: f */
        public void m9316f(float f2, @Nullable PointF[] pointFArr) {
            this.f22141b.m7159a(1, "dispatchOnZoomChanged", Float.valueOf(f2));
            CameraView.this.f22133u.post(new a(f2, pointFArr));
        }

        @NonNull
        /* JADX INFO: renamed from: g */
        public Context m9317g() {
            return CameraView.this.getContext();
        }

        /* JADX INFO: renamed from: h */
        public void m9318h() {
            C5236b c5236bMo7254C = CameraView.this.f22138z.mo7254C(EnumC5171b.VIEW);
            if (c5236bMo7254C == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            }
            if (c5236bMo7254C.equals(CameraView.this.f22110A)) {
                this.f22141b.m7159a(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", c5236bMo7254C);
            } else {
                this.f22141b.m7159a(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", c5236bMo7254C);
                CameraView.this.f22133u.post(new e());
            }
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        f22108j = simpleName;
        f22109k = new C5103b(simpleName);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        InterfaceC5184b c5185c;
        super(context, attributeSet);
        this.f22127o = new HashMap<>(4);
        this.f22113D = new CopyOnWriteArrayList();
        this.f22114E = new CopyOnWriteArrayList();
        boolean zIsInEditMode = isInEditMode();
        this.f22122M = zIsInEditMode;
        if (zIsInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11196R.c.CameraView, 0, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraPreview, EnumC5124k.GL_SURFACE.m7185g());
        int i3 = C11196R.c.CameraView_cameraFacing;
        EnumC5118e enumC5118e = EnumC5118e.BACK;
        if (!C5106e.m7164a(enumC5118e)) {
            EnumC5118e enumC5118e2 = EnumC5118e.FRONT;
            if (C5106e.m7164a(enumC5118e2)) {
                enumC5118e = enumC5118e2;
            }
        }
        int integer2 = typedArrayObtainStyledAttributes.getInteger(i3, enumC5118e.m7173g());
        int integer3 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFlash, EnumC5119f.OFF.m7175g());
        int integer4 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGrid, EnumC5120g.OFF.m7177g());
        int integer5 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraWhiteBalance, EnumC5126m.AUTO.m7189g());
        int integer6 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraMode, EnumC5122i.PICTURE.m7181g());
        int integer7 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraHdr, EnumC5121h.OFF.m7179g());
        int integer8 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudio, EnumC5114a.ON.m7167g());
        int integer9 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoCodec, EnumC5125l.DEVICE_DEFAULT.m7187g());
        int integer10 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudioCodec, EnumC5115b.DEVICE_DEFAULT.m7169g());
        int integer11 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraEngine, EnumC5117d.CAMERA1.m7171g());
        int integer12 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraPictureFormat, EnumC5123j.JPEG.m7183g());
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPlaySounds, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraUseDeviceOrientation, true);
        this.f22121L = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraExperimental, false);
        this.f22126n = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraRequestPermissions, true);
        this.f22128p = EnumC5124k.m7184f(integer);
        this.f22129q = EnumC5117d.m7170f(integer11);
        int color = typedArrayObtainStyledAttributes.getColor(C11196R.c.CameraView_cameraGridColor, C5203d.f14110j);
        long j = (long) typedArrayObtainStyledAttributes.getFloat(C11196R.c.CameraView_cameraVideoMaxSize, 0.0f);
        int integer13 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoMaxDuration, 0);
        int integer14 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoBitRate, 0);
        int integer15 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudioBitRate, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(C11196R.c.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPreviewFrameRateExact, false);
        long integer16 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAutoFocusResetDelay, PathInterpolatorCompat.MAX_NUM_POINTS);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureMetering, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSnapshotMetering, false);
        int integer17 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraSnapshotMaxWidth, 0);
        int integer18 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraSnapshotMaxHeight, 0);
        int integer19 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer20 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer21 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingFormat, 0);
        int integer22 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer23 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingExecutors, 1);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraDrawHardwareOverlays, false);
        ArrayList arrayList = new ArrayList(3);
        int i4 = C11196R.c.CameraView_cameraPictureSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            i = 0;
            arrayList.add(C3404f.m4229N0(typedArrayObtainStyledAttributes.getInteger(i4, 0)));
        } else {
            i = 0;
        }
        int i5 = C11196R.c.CameraView_cameraPictureSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i5)) {
            arrayList.add(C3404f.m4223L0(typedArrayObtainStyledAttributes.getInteger(i5, i)));
        }
        int i6 = C11196R.c.CameraView_cameraPictureSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            arrayList.add(C3404f.m4226M0(typedArrayObtainStyledAttributes.getInteger(i6, i)));
        }
        int i7 = C11196R.c.CameraView_cameraPictureSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            arrayList.add(C3404f.m4220K0(typedArrayObtainStyledAttributes.getInteger(i7, i)));
        }
        int i8 = C11196R.c.CameraView_cameraPictureSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            arrayList.add(C3404f.m4200D1(new C5242h(typedArrayObtainStyledAttributes.getInteger(i8, i))));
        }
        int i9 = C11196R.c.CameraView_cameraPictureSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            arrayList.add(C3404f.m4200D1(new C5241g(typedArrayObtainStyledAttributes.getInteger(i9, 0))));
        }
        int i10 = C11196R.c.CameraView_cameraPictureSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            arrayList.add(C3404f.m4200D1(new C5238d(C5235a.m7449h(typedArrayObtainStyledAttributes.getString(i10)).m7450i(), 0.0f)));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(new C5240f());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(new C5239e());
        }
        InterfaceC5237c interfaceC5237cM4291g = !arrayList.isEmpty() ? C3404f.m4291g((InterfaceC5237c[]) arrayList.toArray(new InterfaceC5237c[0])) : new C5239e();
        ArrayList arrayList2 = new ArrayList(3);
        int i11 = C11196R.c.CameraView_cameraVideoSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            i2 = 0;
            arrayList2.add(C3404f.m4229N0(typedArrayObtainStyledAttributes.getInteger(i11, 0)));
        } else {
            i2 = 0;
        }
        int i12 = C11196R.c.CameraView_cameraVideoSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            arrayList2.add(C3404f.m4223L0(typedArrayObtainStyledAttributes.getInteger(i12, i2)));
        }
        int i13 = C11196R.c.CameraView_cameraVideoSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            arrayList2.add(C3404f.m4226M0(typedArrayObtainStyledAttributes.getInteger(i13, i2)));
        }
        int i14 = C11196R.c.CameraView_cameraVideoSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            arrayList2.add(C3404f.m4220K0(typedArrayObtainStyledAttributes.getInteger(i14, i2)));
        }
        int i15 = C11196R.c.CameraView_cameraVideoSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            arrayList2.add(C3404f.m4200D1(new C5242h(typedArrayObtainStyledAttributes.getInteger(i15, i2))));
        }
        int i16 = C11196R.c.CameraView_cameraVideoSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            arrayList2.add(C3404f.m4200D1(new C5241g(typedArrayObtainStyledAttributes.getInteger(i16, 0))));
        }
        int i17 = C11196R.c.CameraView_cameraVideoSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            arrayList2.add(C3404f.m4200D1(new C5238d(C5235a.m7449h(typedArrayObtainStyledAttributes.getString(i17)).m7450i(), 0.0f)));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(new C5240f());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(new C5239e());
        }
        InterfaceC5237c interfaceC5237cM4291g2 = !arrayList2.isEmpty() ? C3404f.m4291g((InterfaceC5237c[]) arrayList2.toArray(new InterfaceC5237c[0])) : new C5239e();
        int i18 = C11196R.c.CameraView_cameraGestureTap;
        EnumC5194b enumC5194b = EnumC5194b.f14072j;
        int integer24 = typedArrayObtainStyledAttributes.getInteger(i18, enumC5194b.m7391h());
        int integer25 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureLongTap, enumC5194b.m7391h());
        int integer26 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGesturePinch, enumC5194b.m7391h());
        int integer27 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureScrollHorizontal, enumC5194b.m7391h());
        int integer28 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureScrollVertical, enumC5194b.m7391h());
        String string = typedArrayObtainStyledAttributes.getString(C11196R.c.CameraView_cameraAutoFocusMarker);
        InterfaceC5207a interfaceC5207a = null;
        if (string != null) {
            try {
                interfaceC5207a = (InterfaceC5207a) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
        try {
            c5185c = (InterfaceC5184b) Class.forName(typedArrayObtainStyledAttributes.getString(C11196R.c.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused2) {
            c5185c = new C5185c();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f22135w = new C11195b();
        this.f22133u = new Handler(Looper.getMainLooper());
        this.f22116G = new C5197e(this.f22135w);
        this.f22117H = new C5199g(this.f22135w);
        this.f22118I = new C5198f(this.f22135w);
        this.f22119J = new C5203d(context);
        this.f22123N = new C5215c(context);
        this.f22120K = new C5209c(context);
        addView(this.f22119J);
        addView(this.f22120K);
        addView(this.f22123N);
        m9305b();
        setPlaySounds(z2);
        setUseDeviceOrientation(z3);
        setGrid(EnumC5120g.m7176f(integer4));
        setGridColor(color);
        setDrawHardwareOverlays(z7);
        setFacing(EnumC5118e.m7172f(integer2));
        setFlash(EnumC5119f.m7174f(integer3));
        setMode(EnumC5122i.m7180f(integer6));
        setWhiteBalance(EnumC5126m.m7188f(integer5));
        setHdr(EnumC5121h.m7178f(integer7));
        setAudio(EnumC5114a.m7166f(integer8));
        setAudioBitRate(integer15);
        setAudioCodec(EnumC5115b.m7168f(integer10));
        setPictureSize(interfaceC5237cM4291g);
        setPictureMetering(z5);
        setPictureSnapshotMetering(z6);
        setPictureFormat(EnumC5123j.m7182f(integer12));
        setVideoSize(interfaceC5237cM4291g2);
        setVideoCodec(EnumC5125l.m7186f(integer9));
        setVideoMaxSize(j);
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
        m9308e(EnumC5193a.f14067k, EnumC5194b.m7389f(integer24));
        m9308e(EnumC5193a.f14068l, EnumC5194b.m7389f(integer25));
        m9308e(EnumC5193a.f14066j, EnumC5194b.m7389f(integer26));
        m9308e(EnumC5193a.f14069m, EnumC5194b.m7389f(integer27));
        m9308e(EnumC5193a.f14070n, EnumC5194b.m7389f(integer28));
        setAutoFocusMarker(interfaceC5207a);
        setFilter(c5185c);
        this.f22137y = new C5205f(context, this.f22135w);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public boolean m9304a(@NonNull EnumC5114a enumC5114a) {
        EnumC5114a enumC5114a2 = EnumC5114a.STEREO;
        EnumC5114a enumC5114a3 = EnumC5114a.MONO;
        EnumC5114a enumC5114a4 = EnumC5114a.ON;
        if (enumC5114a == enumC5114a4 || enumC5114a == enumC5114a3 || enumC5114a == enumC5114a2) {
            try {
                String[] strArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        throw new IllegalStateException(f22109k.m7159a(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
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
        boolean z2 = enumC5114a == enumC5114a4 || enumC5114a == enumC5114a3 || enumC5114a == enumC5114a2;
        boolean z3 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z4 = z2 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z3 && !z4) {
            return true;
        }
        if (this.f22126n) {
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
        if (!this.f22122M) {
            Objects.requireNonNull(this.f22123N);
            if (layoutParams instanceof C5215c.a) {
                this.f22123N.addView(view, layoutParams);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public final void m9305b() {
        AbstractC5135i c5128b;
        C5103b c5103b = f22109k;
        c5103b.m7159a(2, "doInstantiateEngine:", "instantiating. engine:", this.f22129q);
        EnumC5117d enumC5117d = this.f22129q;
        C11195b c11195b = this.f22135w;
        if (this.f22121L && enumC5117d == EnumC5117d.CAMERA2) {
            c5128b = new C5130d(c11195b);
        } else {
            this.f22129q = EnumC5117d.CAMERA1;
            c5128b = new C5128b(c11195b);
        }
        this.f22138z = c5128b;
        c5103b.m7159a(2, "doInstantiateEngine:", "instantiated. engine:", c5128b.getClass().getSimpleName());
        this.f22138z.mo7297o0(this.f22123N);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m9306c() {
        AbstractC5135i abstractC5135i = this.f22138z;
        return abstractC5135i.f13922n.f14028f == EnumC5178e.OFF && !abstractC5135i.m7324O();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.f22122M) {
            return;
        }
        C5205f c5205f = this.f22137y;
        if (c5205f.f14124h) {
            c5205f.f14124h = false;
            c5205f.f14120d.disable();
            ((DisplayManager) c5205f.f14118b.getSystemService("display")).unregisterDisplayListener(c5205f.f14122f);
            c5205f.f14123g = -1;
            c5205f.f14121e = -1;
        }
        this.f22138z.m7321L0(false);
        AbstractC5225a abstractC5225a = this.f22136x;
        if (abstractC5225a != null) {
            abstractC5225a.mo7436p();
        }
    }

    /* JADX INFO: renamed from: d */
    public boolean m9307d() {
        EnumC5178e enumC5178e = this.f22138z.f13922n.f14028f;
        EnumC5178e enumC5178e2 = EnumC5178e.ENGINE;
        return enumC5178e.m7367f(enumC5178e2) && this.f22138z.f13922n.f14029g.m7367f(enumC5178e2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.f22122M) {
            return;
        }
        this.f22113D.clear();
        boolean z2 = this.f22114E.size() > 0;
        this.f22114E.clear();
        if (z2) {
            this.f22138z.mo7217k0(false);
        }
        this.f22138z.m7329d(true, 0);
        AbstractC5225a abstractC5225a = this.f22136x;
        if (abstractC5225a != null) {
            abstractC5225a.mo7435o();
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m9308e(@NonNull EnumC5193a enumC5193a, @NonNull EnumC5194b enumC5194b) {
        EnumC5194b enumC5194b2 = EnumC5194b.f14072j;
        if (!enumC5193a.m7388f(enumC5194b)) {
            m9308e(enumC5193a, enumC5194b2);
            return false;
        }
        this.f22127o.put(enumC5193a, enumC5194b);
        int iOrdinal = enumC5193a.ordinal();
        if (iOrdinal == 0) {
            this.f22116G.f14081a = this.f22127o.get(EnumC5193a.f14066j) != enumC5194b2;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            this.f22117H.f14081a = (this.f22127o.get(EnumC5193a.f14067k) == enumC5194b2 && this.f22127o.get(EnumC5193a.f14068l) == enumC5194b2) ? false : true;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            this.f22118I.f14081a = (this.f22127o.get(EnumC5193a.f14069m) == enumC5194b2 && this.f22127o.get(EnumC5193a.f14070n) == enumC5194b2) ? false : true;
        }
        this.f22132t = 0;
        Iterator<EnumC5194b> it = this.f22127o.values().iterator();
        while (it.hasNext()) {
            this.f22132t += it.next() == enumC5194b2 ? 0 : 1;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public final String m9309f(int i) {
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

    /* JADX INFO: renamed from: g */
    public final void m9310g(@NonNull AbstractC5195c abstractC5195c, @NonNull AbstractC5104c abstractC5104c) {
        EnumC5193a enumC5193a = abstractC5195c.f14082b;
        EnumC5194b enumC5194b = this.f22127o.get(enumC5193a);
        PointF[] pointFArr = abstractC5195c.f14083c;
        switch (enumC5194b.ordinal()) {
            case 1:
                float width = getWidth();
                float height = getHeight();
                RectF rectFM7409a = C5211b.m7409a(pointFArr[0], width * 0.05f, 0.05f * height);
                ArrayList<C5210a> arrayList = new ArrayList();
                PointF pointF = new PointF(rectFM7409a.centerX(), rectFM7409a.centerY());
                float fWidth = rectFM7409a.width();
                float fHeight = rectFM7409a.height();
                arrayList.add(new C5210a(rectFM7409a, 1000));
                arrayList.add(new C5210a(C5211b.m7409a(pointF, fWidth * 1.5f, fHeight * 1.5f), Math.round(1000 * 0.1f)));
                ArrayList arrayList2 = new ArrayList();
                for (C5210a c5210a : arrayList) {
                    Objects.requireNonNull(c5210a);
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    RectF rectF2 = new RectF();
                    rectF2.set(Math.max(rectF.left, c5210a.f14140j.left), Math.max(rectF.top, c5210a.f14140j.top), Math.min(rectF.right, c5210a.f14140j.right), Math.min(rectF.bottom, c5210a.f14140j.bottom));
                    arrayList2.add(new C5210a(rectF2, c5210a.f14141k));
                }
                this.f22138z.mo7192I0(enumC5193a, new C5211b(arrayList2), pointFArr[0]);
                break;
            case 2:
                this.f22138z.mo7269O0(new C5113l.a());
                break;
            case 3:
                this.f22138z.mo7270P0(new C5113l.a());
                break;
            case 4:
                float fMo7268N = this.f22138z.mo7268N();
                float fM7392a = abstractC5195c.m7392a(fMo7268N, 0.0f, 1.0f);
                if (fM7392a != fMo7268N) {
                    this.f22138z.mo7191G0(fM7392a, pointFArr, true);
                }
                break;
            case 5:
                float fMo7291k = this.f22138z.mo7291k();
                float f = abstractC5104c.f13694m;
                float f2 = abstractC5104c.f13695n;
                float fM7392a2 = abstractC5195c.m7392a(fMo7291k, f, f2);
                if (fM7392a2 != fMo7291k) {
                    this.f22138z.mo7207d0(fM7392a2, new float[]{f, f2}, pointFArr, true);
                }
                break;
            case 6:
                if (getFilter() instanceof InterfaceC5186d) {
                    InterfaceC5186d interfaceC5186d = (InterfaceC5186d) getFilter();
                    float fM7377i = interfaceC5186d.m7377i();
                    float fM7392a3 = abstractC5195c.m7392a(fM7377i, 0.0f, 1.0f);
                    if (fM7392a3 != fM7377i) {
                        interfaceC5186d.m7376d(fM7392a3);
                    }
                }
                break;
            case 7:
                if (getFilter() instanceof InterfaceC5187e) {
                    InterfaceC5187e interfaceC5187e = (InterfaceC5187e) getFilter();
                    float fM7379g = interfaceC5187e.m7379g();
                    float fM7392a4 = abstractC5195c.m7392a(fM7379g, 0.0f, 1.0f);
                    if (fM7392a4 != fM7379g) {
                        interfaceC5187e.m7378b(fM7392a4);
                    }
                }
                break;
        }
    }

    @NonNull
    public EnumC5114a getAudio() {
        return this.f22138z.mo7283f();
    }

    public int getAudioBitRate() {
        return this.f22138z.mo7284g();
    }

    @NonNull
    public EnumC5115b getAudioCodec() {
        return this.f22138z.mo7285h();
    }

    public long getAutoFocusResetDelay() {
        return this.f22138z.mo7287i();
    }

    @Nullable
    public AbstractC5104c getCameraOptions() {
        return this.f22138z.mo7289j();
    }

    public boolean getDrawHardwareOverlays() {
        return this.f22123N.getHardwareCanvasEnabled();
    }

    @NonNull
    public EnumC5117d getEngine() {
        return this.f22129q;
    }

    public float getExposureCorrection() {
        return this.f22138z.mo7291k();
    }

    @NonNull
    public EnumC5118e getFacing() {
        return this.f22138z.mo7292l();
    }

    @NonNull
    public InterfaceC5184b getFilter() {
        Object obj = this.f22136x;
        if (obj == null) {
            return this.f22130r;
        }
        if (obj instanceof InterfaceC5226b) {
            return ((InterfaceC5226b) obj).mo7444c();
        }
        StringBuilder sbM833U = C1643a.m833U("Filters are only supported by the GL_SURFACE preview. Current:");
        sbM833U.append(this.f22128p);
        throw new RuntimeException(sbM833U.toString());
    }

    @NonNull
    public EnumC5119f getFlash() {
        return this.f22138z.mo7293m();
    }

    public int getFrameProcessingExecutors() {
        return this.f22131s;
    }

    public int getFrameProcessingFormat() {
        return this.f22138z.mo7294n();
    }

    public int getFrameProcessingMaxHeight() {
        return this.f22138z.mo7296o();
    }

    public int getFrameProcessingMaxWidth() {
        return this.f22138z.mo7298p();
    }

    public int getFrameProcessingPoolSize() {
        return this.f22138z.mo7299q();
    }

    @NonNull
    public EnumC5120g getGrid() {
        return this.f22119J.getGridMode();
    }

    public int getGridColor() {
        return this.f22119J.getGridColor();
    }

    @NonNull
    public EnumC5121h getHdr() {
        return this.f22138z.mo7301r();
    }

    @Nullable
    public Location getLocation() {
        return this.f22138z.mo7303s();
    }

    @NonNull
    public EnumC5122i getMode() {
        return this.f22138z.mo7305t();
    }

    @NonNull
    public EnumC5123j getPictureFormat() {
        return this.f22138z.mo7306u();
    }

    public boolean getPictureMetering() {
        return this.f22138z.mo7308v();
    }

    @Nullable
    public C5236b getPictureSize() {
        return this.f22138z.mo7309w(EnumC5171b.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.f22138z.mo7313y();
    }

    public boolean getPlaySounds() {
        return this.f22124l;
    }

    @NonNull
    public EnumC5124k getPreview() {
        return this.f22128p;
    }

    public float getPreviewFrameRate() {
        return this.f22138z.mo7250A();
    }

    public boolean getPreviewFrameRateExact() {
        return this.f22138z.mo7252B();
    }

    public int getSnapshotMaxHeight() {
        return this.f22138z.mo7256D();
    }

    public int getSnapshotMaxWidth() {
        return this.f22138z.mo7258E();
    }

    @Nullable
    public C5236b getSnapshotSize() {
        C5236b c5236b = null;
        if (getWidth() != 0 && getHeight() != 0) {
            AbstractC5135i abstractC5135i = this.f22138z;
            EnumC5171b enumC5171b = EnumC5171b.VIEW;
            C5236b c5236bMo7260F = abstractC5135i.mo7260F(enumC5171b);
            if (c5236bMo7260F == null) {
                return null;
            }
            Rect rectM4222L = C3404f.m4222L(c5236bMo7260F, C5235a.m7447f(getWidth(), getHeight()));
            c5236b = new C5236b(rectM4222L.width(), rectM4222L.height());
            if (this.f22138z.mo7281e().m7357b(enumC5171b, EnumC5171b.OUTPUT)) {
                return c5236b.m7451f();
            }
        }
        return c5236b;
    }

    public boolean getUseDeviceOrientation() {
        return this.f22125m;
    }

    public int getVideoBitRate() {
        return this.f22138z.mo7261G();
    }

    @NonNull
    public EnumC5125l getVideoCodec() {
        return this.f22138z.mo7262H();
    }

    public int getVideoMaxDuration() {
        return this.f22138z.mo7263I();
    }

    public long getVideoMaxSize() {
        return this.f22138z.mo7264J();
    }

    @Nullable
    public C5236b getVideoSize() {
        return this.f22138z.mo7265K(EnumC5171b.OUTPUT);
    }

    @NonNull
    public EnumC5126m getWhiteBalance() {
        return this.f22138z.mo7267M();
    }

    public float getZoom() {
        return this.f22138z.mo7268N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AbstractC5225a c5232h;
        super.onAttachedToWindow();
        if (!this.f22122M && this.f22136x == null) {
            C5103b c5103b = f22109k;
            c5103b.m7159a(2, "doInstantiateEngine:", "instantiating. preview:", this.f22128p);
            EnumC5124k enumC5124k = this.f22128p;
            Context context = getContext();
            int iOrdinal = enumC5124k.ordinal();
            if (iOrdinal == 0) {
                c5232h = new C5232h(context, this);
            } else if (iOrdinal == 1 && isHardwareAccelerated()) {
                c5232h = new C5234j(context, this);
            } else {
                this.f22128p = EnumC5124k.GL_SURFACE;
                c5232h = new C5228d(context, this);
            }
            this.f22136x = c5232h;
            c5103b.m7159a(2, "doInstantiateEngine:", "instantiated. preview:", c5232h.getClass().getSimpleName());
            this.f22138z.mo7307u0(this.f22136x);
            InterfaceC5184b interfaceC5184b = this.f22130r;
            if (interfaceC5184b != null) {
                setFilter(interfaceC5184b);
                this.f22130r = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f22110A = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f22132t > 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f22122M) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), BasicMeasure.EXACTLY));
            return;
        }
        C5236b c5236bMo7254C = this.f22138z.mo7254C(EnumC5171b.VIEW);
        this.f22110A = c5236bMo7254C;
        if (c5236bMo7254C == null) {
            f22109k.m7159a(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        C5236b c5236b = this.f22110A;
        float f = c5236b.f14251j;
        float f2 = c5236b.f14252k;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f22136x.mo7441u()) {
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
        C5103b c5103b = f22109k;
        StringBuilder sbM834V = C1643a.m834V("requested dimensions are (", size, "[");
        sbM834V.append(m9309f(mode));
        sbM834V.append("]x");
        sbM834V.append(size2);
        sbM834V.append("[");
        sbM834V.append(m9309f(mode2));
        sbM834V.append("])");
        c5103b.m7159a(1, "onMeasure:", sbM834V.toString());
        c5103b.m7159a(1, "onMeasure:", "previewSize is", "(" + f + "x" + f2 + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            c5103b.m7159a(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            c5103b.m7159a(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f + "x" + f2 + ")");
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
            c5103b.m7159a(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(Math.round(size2 / f3), size);
            } else {
                size2 = Math.min(Math.round(size * f3), size2);
            }
            c5103b.m7159a(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
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
        c5103b.m7159a(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m9307d()) {
            return true;
        }
        AbstractC5104c abstractC5104cMo7289j = this.f22138z.mo7289j();
        if (abstractC5104cMo7289j == null) {
            throw new IllegalStateException("Options should not be null here.");
        }
        C5197e c5197e = this.f22116G;
        if (!c5197e.f14081a ? false : c5197e.m7394c(motionEvent)) {
            f22109k.m7159a(1, "onTouchEvent", "pinch!");
            m9310g(this.f22116G, abstractC5104cMo7289j);
        } else {
            C5198f c5198f = this.f22118I;
            if (!c5198f.f14081a ? false : c5198f.m7395c(motionEvent)) {
                f22109k.m7159a(1, "onTouchEvent", "scroll!");
                m9310g(this.f22118I, abstractC5104cMo7289j);
            } else {
                C5199g c5199g = this.f22117H;
                if (!c5199g.f14081a ? false : c5199g.m7396c(motionEvent)) {
                    f22109k.m7159a(1, "onTouchEvent", "tap!");
                    m9310g(this.f22117H, abstractC5104cMo7289j);
                }
            }
        }
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.f22122M) {
            return;
        }
        AbstractC5225a abstractC5225a = this.f22136x;
        if (abstractC5225a != null) {
            abstractC5225a.mo7437q();
        }
        if (m9304a(getAudio())) {
            C5205f c5205f = this.f22137y;
            if (!c5205f.f14124h) {
                c5205f.f14124h = true;
                c5205f.f14123g = c5205f.m7401a();
                ((DisplayManager) c5205f.f14118b.getSystemService("display")).registerDisplayListener(c5205f.f14122f, c5205f.f14117a);
                c5205f.f14120d.enable();
            }
            C5170a c5170aMo7281e = this.f22138z.mo7281e();
            int i = this.f22137y.f14123g;
            c5170aMo7281e.m7360e(i);
            c5170aMo7281e.f13998d = i;
            c5170aMo7281e.m7359d();
            this.f22138z.m7318H0();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.f22122M && layoutParams != null) {
            Objects.requireNonNull(this.f22123N);
            if (layoutParams instanceof C5215c.a) {
                this.f22123N.removeView(view);
                return;
            }
        }
        super.removeView(view);
    }

    public void set(@NonNull InterfaceC5116c interfaceC5116c) {
        if (interfaceC5116c instanceof EnumC5114a) {
            setAudio((EnumC5114a) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5118e) {
            setFacing((EnumC5118e) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5119f) {
            setFlash((EnumC5119f) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5120g) {
            setGrid((EnumC5120g) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5121h) {
            setHdr((EnumC5121h) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5122i) {
            setMode((EnumC5122i) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5126m) {
            setWhiteBalance((EnumC5126m) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5125l) {
            setVideoCodec((EnumC5125l) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5115b) {
            setAudioCodec((EnumC5115b) interfaceC5116c);
            return;
        }
        if (interfaceC5116c instanceof EnumC5124k) {
            setPreview((EnumC5124k) interfaceC5116c);
        } else if (interfaceC5116c instanceof EnumC5117d) {
            setEngine((EnumC5117d) interfaceC5116c);
        } else if (interfaceC5116c instanceof EnumC5123j) {
            setPictureFormat((EnumC5123j) interfaceC5116c);
        }
    }

    public void setAudio(@NonNull EnumC5114a enumC5114a) {
        if (enumC5114a == getAudio() || m9306c()) {
            this.f22138z.mo7276Z(enumC5114a);
        } else if (m9304a(enumC5114a)) {
            this.f22138z.mo7276Z(enumC5114a);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i) {
        this.f22138z.mo7277a0(i);
    }

    public void setAudioCodec(@NonNull EnumC5115b enumC5115b) {
        this.f22138z.mo7279b0(enumC5115b);
    }

    public void setAutoFocusMarker(@Nullable InterfaceC5207a interfaceC5207a) {
        View viewM7406b;
        this.f22112C = interfaceC5207a;
        C5209c c5209c = this.f22120K;
        View view = c5209c.f14139j.get(1);
        if (view != null) {
            c5209c.removeView(view);
        }
        if (interfaceC5207a == null || (viewM7406b = interfaceC5207a.m7406b(c5209c.getContext(), c5209c)) == null) {
            return;
        }
        c5209c.f14139j.put(1, viewM7406b);
        c5209c.addView(viewM7406b);
    }

    public void setAutoFocusResetDelay(long j) {
        this.f22138z.mo7280c0(j);
    }

    public void setDrawHardwareOverlays(boolean z2) {
        this.f22123N.setHardwareCanvasEnabled(z2);
    }

    public void setEngine(@NonNull EnumC5117d enumC5117d) {
        if (m9306c()) {
            this.f22129q = enumC5117d;
            AbstractC5135i abstractC5135i = this.f22138z;
            m9305b();
            AbstractC5225a abstractC5225a = this.f22136x;
            if (abstractC5225a != null) {
                this.f22138z.mo7307u0(abstractC5225a);
            }
            setFacing(abstractC5135i.mo7292l());
            setFlash(abstractC5135i.mo7293m());
            setMode(abstractC5135i.mo7305t());
            setWhiteBalance(abstractC5135i.mo7267M());
            setHdr(abstractC5135i.mo7301r());
            setAudio(abstractC5135i.mo7283f());
            setAudioBitRate(abstractC5135i.mo7284g());
            setAudioCodec(abstractC5135i.mo7285h());
            setPictureSize(abstractC5135i.mo7311x());
            setPictureFormat(abstractC5135i.mo7306u());
            setVideoSize(abstractC5135i.mo7266L());
            setVideoCodec(abstractC5135i.mo7262H());
            setVideoMaxSize(abstractC5135i.mo7264J());
            setVideoMaxDuration(abstractC5135i.mo7263I());
            setVideoBitRate(abstractC5135i.mo7261G());
            setAutoFocusResetDelay(abstractC5135i.mo7287i());
            setPreviewFrameRate(abstractC5135i.mo7250A());
            setPreviewFrameRateExact(abstractC5135i.mo7252B());
            setSnapshotMaxWidth(abstractC5135i.mo7258E());
            setSnapshotMaxHeight(abstractC5135i.mo7256D());
            setFrameProcessingMaxWidth(abstractC5135i.mo7298p());
            setFrameProcessingMaxHeight(abstractC5135i.mo7296o());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(abstractC5135i.mo7299q());
            this.f22138z.mo7217k0(!this.f22114E.isEmpty());
        }
    }

    public void setExperimental(boolean z2) {
        this.f22121L = z2;
    }

    public void setExposureCorrection(float f) {
        AbstractC5104c cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f2 = cameraOptions.f13694m;
            float f3 = cameraOptions.f13695n;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                f = f3;
            }
            this.f22138z.mo7207d0(f, new float[]{f2, f3}, null, false);
        }
    }

    public void setFacing(@NonNull EnumC5118e enumC5118e) {
        this.f22138z.mo7282e0(enumC5118e);
    }

    public void setFilter(@NonNull InterfaceC5184b interfaceC5184b) {
        Object obj = this.f22136x;
        if (obj == null) {
            this.f22130r = interfaceC5184b;
            return;
        }
        boolean z2 = obj instanceof InterfaceC5226b;
        if (!(interfaceC5184b instanceof C5185c) && !z2) {
            StringBuilder sbM833U = C1643a.m833U("Filters are only supported by the GL_SURFACE preview. Current preview:");
            sbM833U.append(this.f22128p);
            throw new RuntimeException(sbM833U.toString());
        }
        if (z2) {
            ((InterfaceC5226b) obj).mo7443a(interfaceC5184b);
        }
    }

    public void setFlash(@NonNull EnumC5119f enumC5119f) {
        this.f22138z.mo7210f0(enumC5119f);
    }

    public void setFrameProcessingExecutors(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(C1643a.m871q("Need at least 1 executor, got ", i));
        }
        this.f22131s = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC11194a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f22134v = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i) {
        this.f22138z.mo7212g0(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.f22138z.mo7286h0(i);
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.f22138z.mo7288i0(i);
    }

    public void setFrameProcessingPoolSize(int i) {
        this.f22138z.mo7290j0(i);
    }

    public void setGrid(@NonNull EnumC5120g enumC5120g) {
        this.f22119J.setGridMode(enumC5120g);
    }

    public void setGridColor(@ColorInt int i) {
        this.f22119J.setGridColor(i);
    }

    public void setHdr(@NonNull EnumC5121h enumC5121h) {
        this.f22138z.mo7219l0(enumC5121h);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Lifecycle lifecycle = this.f22115F;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
                this.f22115F = null;
                return;
            }
            return;
        }
        Lifecycle lifecycle2 = this.f22115F;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
            this.f22115F = null;
        }
        Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
        this.f22115F = lifecycle3;
        lifecycle3.addObserver(this);
    }

    public void setLocation(@Nullable Location location) {
        this.f22138z.mo7221m0(location);
    }

    public void setMode(@NonNull EnumC5122i enumC5122i) {
        this.f22138z.mo7295n0(enumC5122i);
    }

    public void setPictureFormat(@NonNull EnumC5123j enumC5123j) {
        this.f22138z.mo7223p0(enumC5123j);
    }

    public void setPictureMetering(boolean z2) {
        this.f22138z.mo7300q0(z2);
    }

    public void setPictureSize(@NonNull InterfaceC5237c interfaceC5237c) {
        this.f22138z.mo7302r0(interfaceC5237c);
    }

    public void setPictureSnapshotMetering(boolean z2) {
        this.f22138z.mo7304s0(z2);
    }

    public void setPlaySounds(boolean z2) {
        this.f22124l = z2;
        this.f22138z.mo7224t0(z2);
    }

    public void setPreview(@NonNull EnumC5124k enumC5124k) {
        AbstractC5225a abstractC5225a;
        if (enumC5124k != this.f22128p) {
            this.f22128p = enumC5124k;
            if ((getWindowToken() != null) || (abstractC5225a = this.f22136x) == null) {
                return;
            }
            abstractC5225a.mo7435o();
            this.f22136x = null;
        }
    }

    public void setPreviewFrameRate(float f) {
        this.f22138z.mo7225v0(f);
    }

    public void setPreviewFrameRateExact(boolean z2) {
        this.f22138z.mo7310w0(z2);
    }

    public void setPreviewStreamSize(@NonNull InterfaceC5237c interfaceC5237c) {
        this.f22138z.mo7312x0(interfaceC5237c);
    }

    public void setRequestPermissions(boolean z2) {
        this.f22126n = z2;
    }

    public void setSnapshotMaxHeight(int i) {
        this.f22138z.mo7314y0(i);
    }

    public void setSnapshotMaxWidth(int i) {
        this.f22138z.mo7316z0(i);
    }

    public void setUseDeviceOrientation(boolean z2) {
        this.f22125m = z2;
    }

    public void setVideoBitRate(int i) {
        this.f22138z.mo7251A0(i);
    }

    public void setVideoCodec(@NonNull EnumC5125l enumC5125l) {
        this.f22138z.mo7253B0(enumC5125l);
    }

    public void setVideoMaxDuration(int i) {
        this.f22138z.mo7255C0(i);
    }

    public void setVideoMaxSize(long j) {
        this.f22138z.mo7257D0(j);
    }

    public void setVideoSize(@NonNull InterfaceC5237c interfaceC5237c) {
        this.f22138z.mo7259E0(interfaceC5237c);
    }

    public void setWhiteBalance(@NonNull EnumC5126m enumC5126m) {
        this.f22138z.mo7190F0(enumC5126m);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f22138z.mo7191G0(f, null, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.f22122M) {
            C5215c c5215c = this.f22123N;
            Objects.requireNonNull(c5215c);
            boolean z2 = false;
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = c5215c.getContext().obtainStyledAttributes(attributeSet, C11196R.c.CameraView_Layout);
                z2 = typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnPreview) || typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnPictureSnapshot) || typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnVideoSnapshot);
                typedArrayObtainStyledAttributes.recycle();
            }
            if (z2) {
                return this.f22123N.generateLayoutParams(attributeSet);
            }
        }
        return super.generateLayoutParams(attributeSet);
    }
}
