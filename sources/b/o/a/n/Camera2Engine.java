package b.o.a.n;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import b.d.b.a.outline;
import b.o.a.CameraLogger;
import b.o.a.CameraOptions;
import b.o.a.PictureResult;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.WhiteBalance;
import b.o.a.n.CameraEngine;
import b.o.a.n.o.Action2;
import b.o.a.n.o.ActionHolder;
import b.o.a.n.o.BaseAction;
import b.o.a.n.o.CompletionCallback;
import b.o.a.n.o.LogAction;
import b.o.a.n.o.SequenceAction;
import b.o.a.n.o.TimeoutAction;
import b.o.a.n.q.Camera2Mapper;
import b.o.a.n.r.BaseMeter;
import b.o.a.n.r.MeterAction;
import b.o.a.n.r.MeterResetAction;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.n.u.Camera2Options;
import b.o.a.n.v.CameraState2;
import b.o.a.n.v.CameraStateOrchestrator;
import b.o.a.n.v.CameraStateOrchestrator3;
import b.o.a.n.v.CameraStateOrchestrator4;
import b.o.a.p.Frame2;
import b.o.a.p.FrameManager;
import b.o.a.p.ImageFrameManager;
import b.o.a.q.Gesture;
import b.o.a.r.FpsRangeValidator;
import b.o.a.t.MeteringRegions;
import b.o.a.v.Full2PictureRecorder;
import b.o.a.v.Snapshot2PictureRecorder;
import b.o.a.w.RendererCameraPreview;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import b.o.a.x.SizeSelector;
import b.o.a.x.SizeSelectors;
import b.o.a.x.SizeSelectors2;
import b.o.a.x.SizeSelectors3;
import b.o.a.x.SizeSelectors9;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: b.o.a.n.d, reason: use source file name */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Camera2Engine extends CameraBaseEngine implements ImageReader.OnImageAvailableListener, ActionHolder {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final CameraManager f1916d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f1917e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public CameraDevice f1918f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public CameraCharacteristics f1919g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public CameraCaptureSession f1920h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public CaptureRequest.Builder f1921i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public TotalCaptureResult f1922j0;
    public final Camera2Mapper k0;
    public ImageReader l0;
    public Surface m0;
    public Surface n0;
    public ImageReader o0;
    public final List<Action2> p0;
    public MeterAction q0;
    public final CameraCaptureSession.CaptureCallback r0;

    /* JADX INFO: renamed from: b.o.a.n.d$a */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class a implements Runnable {
        public final /* synthetic */ Flash j;
        public final /* synthetic */ Flash k;

        public a(Flash flash, Flash flash2) {
            this.j = flash;
            this.k = flash2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            boolean zH1 = camera2Engine.h1(camera2Engine.f1921i0, this.j);
            Camera2Engine camera2Engine2 = Camera2Engine.this;
            if (!(camera2Engine2.n.f == CameraState2.PREVIEW)) {
                if (zH1) {
                    camera2Engine2.k1();
                    return;
                }
                return;
            }
            camera2Engine2.w = Flash.OFF;
            camera2Engine2.h1(camera2Engine2.f1921i0, this.j);
            try {
                Camera2Engine camera2Engine3 = Camera2Engine.this;
                camera2Engine3.f1920h0.capture(camera2Engine3.f1921i0.build(), null, null);
                Camera2Engine camera2Engine4 = Camera2Engine.this;
                camera2Engine4.w = this.k;
                camera2Engine4.h1(camera2Engine4.f1921i0, this.j);
                Camera2Engine.this.k1();
            } catch (CameraAccessException e) {
                throw Camera2Engine.this.o1(e);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$b */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class b implements Runnable {
        public final /* synthetic */ Location j;

        public b(Location location) {
            this.j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            CaptureRequest.Builder builder = camera2Engine.f1921i0;
            Location location = camera2Engine.C;
            if (location != null) {
                builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
            }
            Camera2Engine.this.k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$c */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class c implements Runnable {
        public final /* synthetic */ WhiteBalance j;

        public c(WhiteBalance whiteBalance) {
            this.j = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.m1(camera2Engine.f1921i0, this.j)) {
                Camera2Engine.this.k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$d */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class d implements Runnable {
        public final /* synthetic */ Hdr j;

        public d(Hdr hdr) {
            this.j = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.i1(camera2Engine.f1921i0, this.j)) {
                Camera2Engine.this.k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$e */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class e implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float l;
        public final /* synthetic */ PointF[] m;

        public e(float f, boolean z2, float f2, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = f2;
            this.m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.n1(camera2Engine.f1921i0, this.j)) {
                Camera2Engine.this.k1();
                if (this.k) {
                    ((CameraView.b) Camera2Engine.this.m).f(this.l, this.m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$f */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class f implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float l;
        public final /* synthetic */ float[] m;
        public final /* synthetic */ PointF[] n;

        public f(float f, boolean z2, float f2, float[] fArr, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = f2;
            this.m = fArr;
            this.n = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.g1(camera2Engine.f1921i0, this.j)) {
                Camera2Engine.this.k1();
                if (this.k) {
                    ((CameraView.b) Camera2Engine.this.m).c(this.l, this.m, this.n);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$g */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class g implements Runnable {
        public final /* synthetic */ float j;

        public g(float f) {
            this.j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.j1(camera2Engine.f1921i0, this.j)) {
                Camera2Engine.this.k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$h */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.this.X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$i */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class i extends CameraCaptureSession.CaptureCallback {
        public i() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.f1922j0 = totalCaptureResult;
            Iterator<Action2> it = camera2Engine.p0.iterator();
            while (it.hasNext()) {
                it.next().b(Camera2Engine.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Iterator<Action2> it = Camera2Engine.this.p0.iterator();
            while (it.hasNext()) {
                it.next().d(Camera2Engine.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            Iterator<Action2> it = Camera2Engine.this.p0.iterator();
            while (it.hasNext()) {
                it.next().c(Camera2Engine.this, captureRequest);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$j */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class j implements Runnable {
        public final /* synthetic */ boolean j;

        public j(boolean z2) {
            this.j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState2 cameraState2 = Camera2Engine.this.n.f;
            CameraState2 cameraState3 = CameraState2.BIND;
            if (cameraState2.f(cameraState3) && Camera2Engine.this.O()) {
                Camera2Engine.this.k0(this.j);
                return;
            }
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.v = this.j;
            if (camera2Engine.n.f.f(cameraState3)) {
                Camera2Engine.this.Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$k */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class k implements Runnable {
        public final /* synthetic */ int j;

        public k(int i) {
            this.j = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraState2 cameraState2 = Camera2Engine.this.n.f;
            CameraState2 cameraState3 = CameraState2.BIND;
            if (cameraState2.f(cameraState3) && Camera2Engine.this.O()) {
                Camera2Engine.this.g0(this.j);
                return;
            }
            Camera2Engine camera2Engine = Camera2Engine.this;
            int i = this.j;
            if (i <= 0) {
                i = 35;
            }
            camera2Engine.u = i;
            if (camera2Engine.n.f.f(cameraState3)) {
                Camera2Engine.this.Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$l */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class l implements Runnable {
        public final /* synthetic */ Gesture j;
        public final /* synthetic */ PointF k;
        public final /* synthetic */ MeteringRegions l;

        /* JADX INFO: renamed from: b.o.a.n.d$l$a */
        /* JADX INFO: compiled from: Camera2Engine.java */
        public class a extends CompletionCallback {
            public final /* synthetic */ MeterAction a;

            /* JADX INFO: renamed from: b.o.a.n.d$l$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Camera2Engine.java */
            public class RunnableC0061a implements Runnable {
                public RunnableC0061a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera2Engine.b1(Camera2Engine.this);
                }
            }

            public a(MeterAction meterAction) {
                this.a = meterAction;
            }

            @Override // b.o.a.n.o.CompletionCallback
            public void b(@NonNull Action2 action2) {
                boolean z2;
                l lVar = l.this;
                CameraEngine.g gVar = Camera2Engine.this.m;
                Gesture gesture = lVar.j;
                Iterator<BaseMeter> it = this.a.f.iterator();
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        MeterAction.e.a(1, "isSuccessful:", "returning true.");
                        break;
                    } else if (!it.next().g) {
                        MeterAction.e.a(1, "isSuccessful:", "returning false.");
                        z2 = false;
                        break;
                    }
                }
                ((CameraView.b) gVar).d(gesture, z2, l.this.k);
                Camera2Engine.this.n.e("reset metering", 0);
                if (Camera2Engine.this.a1()) {
                    Camera2Engine camera2Engine = Camera2Engine.this;
                    CameraStateOrchestrator cameraStateOrchestrator = camera2Engine.n;
                    cameraStateOrchestrator.c("reset metering", true, camera2Engine.W, new CameraStateOrchestrator4(cameraStateOrchestrator, CameraState2.PREVIEW, new RunnableC0061a()));
                }
            }
        }

        public l(Gesture gesture, PointF pointF, MeteringRegions meteringRegions) {
            this.j = gesture;
            this.k = pointF;
            this.l = meteringRegions;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine camera2Engine = Camera2Engine.this;
            if (camera2Engine.p.o) {
                ((CameraView.b) camera2Engine.m).e(this.j, this.k);
                MeterAction meterActionP1 = Camera2Engine.this.p1(this.l);
                TimeoutAction timeoutAction = new TimeoutAction(5000L, meterActionP1);
                timeoutAction.e(Camera2Engine.this);
                timeoutAction.f(new a(meterActionP1));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$m */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class m extends CameraDevice.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public m(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (this.a.a.o()) {
                CameraEngine.j.a(1, "CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
            this.a.a(cameraException);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            int i2 = 1;
            if (this.a.a.o()) {
                CameraEngine.j.a(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
                throw new CameraException(3);
            }
            TaskCompletionSource taskCompletionSource = this.a;
            Objects.requireNonNull(Camera2Engine.this);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                i2 = 0;
            }
            taskCompletionSource.a(new CameraException(i2));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i;
            Camera2Engine.this.f1918f0 = cameraDevice;
            try {
                CameraEngine.j.a(1, "onStartEngine:", "Opened camera device.");
                Camera2Engine camera2Engine = Camera2Engine.this;
                camera2Engine.f1919g0 = camera2Engine.f1916d0.getCameraCharacteristics(camera2Engine.f1917e0);
                boolean zB = Camera2Engine.this.L.b(Reference2.SENSOR, Reference2.VIEW);
                int iOrdinal = Camera2Engine.this.B.ordinal();
                if (iOrdinal == 0) {
                    i = 256;
                } else {
                    if (iOrdinal != 1) {
                        throw new IllegalArgumentException("Unknown format:" + Camera2Engine.this.B);
                    }
                    i = 32;
                }
                Camera2Engine camera2Engine2 = Camera2Engine.this;
                camera2Engine2.p = new Camera2Options(camera2Engine2.f1916d0, camera2Engine2.f1917e0, zB, i);
                Camera2Engine camera2Engine3 = Camera2Engine.this;
                Objects.requireNonNull(camera2Engine3);
                camera2Engine3.q1(1);
                this.a.b(Camera2Engine.this.p);
            } catch (CameraAccessException e) {
                this.a.a(Camera2Engine.this.o1(e));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$n */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class n implements Callable<Void> {
        public final /* synthetic */ Object j;

        public n(Object obj) {
            this.j = obj;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SurfaceHolder surfaceHolder = (SurfaceHolder) this.j;
            Size3 size3 = Camera2Engine.this.f1931s;
            surfaceHolder.setFixedSize(size3.j, size3.k);
            return null;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$o */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class o extends CameraCaptureSession.StateCallback {
        public final /* synthetic */ TaskCompletionSource a;

        public o(TaskCompletionSource taskCompletionSource) {
            this.a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            RuntimeException runtimeException = new RuntimeException(CameraEngine.j.a(3, "onConfigureFailed! Session", cameraCaptureSession));
            if (this.a.a.o()) {
                throw new CameraException(3);
            }
            this.a.a(new CameraException(runtimeException, 2));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Camera2Engine.this.f1920h0 = cameraCaptureSession;
            CameraEngine.j.a(1, "onStartBind:", "Completed");
            this.a.b(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            CameraEngine.j.a(1, "CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$p */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class p extends BaseAction {
        public final /* synthetic */ TaskCompletionSource e;

        public p(Camera2Engine camera2Engine, TaskCompletionSource taskCompletionSource) {
            this.e = taskCompletionSource;
        }

        @Override // b.o.a.n.o.BaseAction, b.o.a.n.o.Action2
        public void b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            l(Integer.MAX_VALUE);
            this.e.b(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$q */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class q extends CompletionCallback {
        public final /* synthetic */ PictureResult.a a;

        public q(PictureResult.a aVar) {
            this.a = aVar;
        }

        @Override // b.o.a.n.o.CompletionCallback
        public void b(@NonNull Action2 action2) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.H = false;
            camera2Engine.P0(this.a);
            Camera2Engine.this.H = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$r */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class r extends CompletionCallback {
        public final /* synthetic */ PictureResult.a a;

        public r(PictureResult.a aVar) {
            this.a = aVar;
        }

        @Override // b.o.a.n.o.CompletionCallback
        public void b(@NonNull Action2 action2) {
            Camera2Engine camera2Engine = Camera2Engine.this;
            camera2Engine.G = false;
            camera2Engine.O0(this.a);
            Camera2Engine.this.G = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$s */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera2Engine.b1(Camera2Engine.this);
        }
    }

    public Camera2Engine(CameraEngine.g gVar) {
        super(gVar);
        if (Camera2Mapper.a == null) {
            Camera2Mapper.a = new Camera2Mapper();
        }
        this.k0 = Camera2Mapper.a;
        this.p0 = new CopyOnWriteArrayList();
        this.r0 = new i();
        this.f1916d0 = (CameraManager) ((CameraView.b) this.m).g().getSystemService(ChatInputComponentTypes.CAMERA);
        new LogAction().e(this);
    }

    public static void b1(Camera2Engine camera2Engine) {
        Objects.requireNonNull(camera2Engine);
        new SequenceAction(Arrays.asList(new Camera2Engine3(camera2Engine), new MeterResetAction())).e(camera2Engine);
    }

    @Override // b.o.a.n.CameraEngine
    public void F0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f1932x;
        this.f1932x = whiteBalance;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("white balance (" + whiteBalance + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new c(whiteBalance2)));
    }

    @Override // b.o.a.n.CameraEngine
    public void G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.D;
        this.D = f2;
        this.n.e("zoom", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("zoom", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new e(f3, z2, f2, pointFArr)));
    }

    @Override // b.o.a.n.CameraEngine
    public void I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("autofocus (" + gesture + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.PREVIEW, new l(gesture, pointF, meteringRegions)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> P() {
        Handler handler;
        int i2;
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.r = Q0(this.Q);
        this.f1931s = R0();
        ArrayList arrayList = new ArrayList();
        Class clsJ = this.o.j();
        Object objI = this.o.i();
        if (clsJ == SurfaceHolder.class) {
            try {
                cameraLogger.a(1, "onStartBind:", "Waiting on UI thread...");
                b.i.a.f.e.o.f.j(b.i.a.f.e.o.f.o(b.i.a.f.n.g.a, new n(objI)));
                this.n0 = ((SurfaceHolder) objI).getSurface();
            } catch (InterruptedException | ExecutionException e2) {
                throw new CameraException(e2, 1);
            }
        } else {
            if (clsJ != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) objI;
            Size3 size3 = this.f1931s;
            surfaceTexture.setDefaultBufferSize(size3.j, size3.k);
            this.n0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.n0);
        if (this.Q == Mode3.PICTURE) {
            int iOrdinal = this.B.ordinal();
            if (iOrdinal == 0) {
                i2 = 256;
            } else {
                if (iOrdinal != 1) {
                    StringBuilder sbU = outline.U("Unknown format:");
                    sbU.append(this.B);
                    throw new IllegalArgumentException(sbU.toString());
                }
                i2 = 32;
            }
            Size3 size4 = this.r;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(size4.j, size4.k, i2, 2);
            this.o0 = imageReaderNewInstance;
            arrayList.add(imageReaderNewInstance.getSurface());
        }
        if (this.v) {
            List<Size3> listS1 = s1();
            boolean zB = this.L.b(Reference2.SENSOR, Reference2.VIEW);
            ArrayList<Size3> arrayList2 = (ArrayList) listS1;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (Size3 size3F : arrayList2) {
                if (zB) {
                    size3F = size3F.f();
                }
                arrayList3.add(size3F);
            }
            Size3 size5 = this.f1931s;
            AspectRatio2 aspectRatio2F = AspectRatio2.f(size5.j, size5.k);
            if (zB) {
                aspectRatio2F = AspectRatio2.f(aspectRatio2F.l, aspectRatio2F.k);
            }
            int i3 = this.Z;
            int i4 = this.f1928a0;
            if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
                i3 = 640;
            }
            if (i4 <= 0 || i4 == Integer.MAX_VALUE) {
                i4 = 640;
            }
            Size3 size6 = new Size3(i3, i4);
            CameraLogger cameraLogger2 = CameraEngine.j;
            cameraLogger2.a(1, "computeFrameProcessingSize:", "targetRatio:", aspectRatio2F, "targetMaxSize:", size6);
            SizeSelector sizeSelectorD1 = b.i.a.f.e.o.f.D1(new SizeSelectors(aspectRatio2F.i(), 0.0f));
            SizeSelector sizeSelectorG = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.K0(i4), b.i.a.f.e.o.f.L0(i3), new SizeSelectors2());
            Size3 size3F2 = ((SizeSelectors9) b.i.a.f.e.o.f.Q0(b.i.a.f.e.o.f.g(sizeSelectorD1, sizeSelectorG), sizeSelectorG, new SizeSelectors3())).a(arrayList3).get(0);
            if (!arrayList3.contains(size3F2)) {
                throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
            }
            if (zB) {
                size3F2 = size3F2.f();
            }
            cameraLogger2.a(1, "computeFrameProcessingSize:", "result:", size3F2, "flip:", Boolean.valueOf(zB));
            this.t = size3F2;
            ImageReader imageReaderNewInstance2 = ImageReader.newInstance(size3F2.j, size3F2.k, this.u, this.f1929b0 + 1);
            this.l0 = imageReaderNewInstance2;
            handler = null;
            imageReaderNewInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.l0.getSurface();
            this.m0 = surface;
            arrayList.add(surface);
        } else {
            handler = null;
            this.l0 = null;
            this.t = null;
            this.m0 = null;
        }
        try {
            this.f1918f0.createCaptureSession(arrayList, new o(taskCompletionSource), handler);
            return taskCompletionSource.a;
        } catch (CameraAccessException e3) {
            throw o1(e3);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    @SuppressLint({"MissingPermission"})
    public Task<CameraOptions> Q() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.f1916d0.openCamera(this.f1917e0, new m(taskCompletionSource), (Handler) null);
            return taskCompletionSource.a;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> R() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.b) this.m).h();
        Reference2 reference2 = Reference2.VIEW;
        Size3 size3C = C(reference2);
        if (size3C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(size3C.j, size3C.k);
        this.o.r(this.L.c(Reference2.BASE, reference2, 1));
        if (this.v) {
            S0().e(this.u, this.t, this.L);
        }
        cameraLogger.a(1, "onStartPreview:", "Starting preview.");
        c1(new Surface[0]);
        l1(false, 2);
        cameraLogger.a(1, "onStartPreview:", "Started preview.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new p(this, taskCompletionSource).e(this);
        return taskCompletionSource.a;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> S() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStopBind:", "About to clean up.");
        this.m0 = null;
        this.n0 = null;
        this.f1931s = null;
        this.r = null;
        this.t = null;
        ImageReader imageReader = this.l0;
        if (imageReader != null) {
            imageReader.close();
            this.l0 = null;
        }
        ImageReader imageReader2 = this.o0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.o0 = null;
        }
        this.f1920h0.close();
        this.f1920h0 = null;
        cameraLogger.a(1, "onStopBind:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> T() {
        try {
            CameraLogger cameraLogger = CameraEngine.j;
            cameraLogger.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.f1918f0.close();
            cameraLogger.a(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e2) {
            CameraEngine.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
        }
        this.f1918f0 = null;
        CameraEngine.j.a(1, "onStopEngine:", "Aborting actions.");
        Iterator<Action2> it = this.p0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        this.f1919g0 = null;
        this.p = null;
        this.f1921i0 = null;
        CameraEngine.j.a(2, "onStopEngine:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraBaseEngine
    @NonNull
    public List<Size3> T0() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.o.j());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                Size3 size3 = new Size3(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> U() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStopPreview:", "Started.");
        this.q = null;
        if (this.v) {
            S0().d();
        }
        this.f1921i0.removeTarget(this.n0);
        Surface surface = this.m0;
        if (surface != null) {
            this.f1921i0.removeTarget(surface);
        }
        this.f1922j0 = null;
        cameraLogger.a(1, "onStopPreview:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraBaseEngine
    @NonNull
    public FrameManager V0(int i2) {
        return new ImageFrameManager(i2);
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void X0() {
        CameraEngine.j.a(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        Y();
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void Y0(@NonNull PictureResult.a aVar, boolean z2) {
        if (z2) {
            CameraEngine.j.a(1, "onTakePicture:", "doMetering is true. Delaying.");
            TimeoutAction timeoutAction = new TimeoutAction(2500L, p1(null));
            timeoutAction.f(new r(aVar));
            timeoutAction.e(this);
            return;
        }
        CameraEngine.j.a(1, "onTakePicture:", "doMetering is false. Performing.");
        Angles angles = this.L;
        Reference2 reference2 = Reference2.SENSOR;
        Reference2 reference3 = Reference2.OUTPUT;
        aVar.c = angles.c(reference2, reference3, 2);
        aVar.d = w(reference3);
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.f1918f0.createCaptureRequest(2);
            d1(builderCreateCaptureRequest, this.f1921i0);
            Full2PictureRecorder full2PictureRecorder = new Full2PictureRecorder(aVar, this, builderCreateCaptureRequest, this.o0);
            this.q = full2PictureRecorder;
            full2PictureRecorder.c();
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2) {
        if (z2) {
            CameraEngine.j.a(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            TimeoutAction timeoutAction = new TimeoutAction(2500L, p1(null));
            timeoutAction.f(new q(aVar));
            timeoutAction.e(this);
            return;
        }
        CameraEngine.j.a(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.o instanceof RendererCameraPreview)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        Reference2 reference2 = Reference2.OUTPUT;
        aVar.d = F(reference2);
        aVar.c = this.L.c(Reference2.VIEW, reference2, 1);
        Snapshot2PictureRecorder snapshot2PictureRecorder = new Snapshot2PictureRecorder(aVar, this, (RendererCameraPreview) this.o, aspectRatio2);
        this.q = snapshot2PictureRecorder;
        snapshot2PictureRecorder.c();
    }

    @Override // b.o.a.n.CameraBaseEngine, b.o.a.v.PictureRecorder.a
    public void a(@Nullable PictureResult.a aVar, @Nullable Exception exc) {
        boolean z2 = this.q instanceof Full2PictureRecorder;
        super.a(aVar, exc);
        if ((z2 && this.G) || (!z2 && this.H)) {
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            cameraStateOrchestrator.b("reset metering after picture", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.PREVIEW, new s()));
        }
    }

    @Override // b.o.a.n.CameraEngine
    public final boolean c(@NonNull Facing facing) {
        Objects.requireNonNull(this.k0);
        int iIntValue = Camera2Mapper.f1937b.get(facing).intValue();
        try {
            String[] cameraIdList = this.f1916d0.getCameraIdList();
            CameraEngine.j.a(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    CameraCharacteristics cameraCharacteristics = this.f1916d0.getCameraCharacteristics(str);
                    if (iIntValue == ((Integer) u1(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.f1917e0 = str;
                        this.L.f(facing, ((Integer) u1(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                    continue;
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    public final void c1(@NonNull Surface... surfaceArr) {
        this.f1921i0.addTarget(this.n0);
        Surface surface = this.m0;
        if (surface != null) {
            this.f1921i0.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.f1921i0.addTarget(surface2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.E;
        this.E = f2;
        this.n.e("exposure correction", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("exposure correction", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new f(f3, z2, f2, fArr, pointFArr)));
    }

    public final void d1(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        CameraEngine.j.a(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        f1(builder);
        h1(builder, Flash.OFF);
        Location location = this.C;
        if (location != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        m1(builder, WhiteBalance.AUTO);
        i1(builder, Hdr.OFF);
        n1(builder, 0.0f);
        g1(builder, 0.0f);
        j1(builder, 0.0f);
        if (builder2 != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, (MeteringRectangle[]) builder2.get(key));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, (MeteringRectangle[]) builder2.get(key2));
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, (MeteringRectangle[]) builder2.get(key3));
            CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, (Integer) builder2.get(key4));
        }
    }

    public void e1(@NonNull Action2 action2, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (this.n.f != CameraState2.PREVIEW || O()) {
            return;
        }
        this.f1920h0.capture(builder.build(), this.r0, null);
    }

    @Override // b.o.a.n.CameraEngine
    public void f0(@NonNull Flash flash) {
        Flash flash2 = this.w;
        this.w = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("flash (" + flash + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new a(flash2, flash)));
    }

    public void f1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (this.Q == Mode3.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            return;
        }
        if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void g0(int i2) {
        if (this.u == 0) {
            this.u = 35;
        }
        this.n.b(outline.r("frame processing format (", i2, ")"), true, new k(i2));
    }

    public boolean g1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.p.l) {
            this.E = f2;
            return false;
        }
        Rational rational = (Rational) t1(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.E)));
        return true;
    }

    public boolean h1(@NonNull CaptureRequest.Builder builder, @NonNull Flash flash) {
        if (this.p.c(this.w)) {
            int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            Camera2Mapper camera2Mapper = this.k0;
            Flash flash2 = this.w;
            Objects.requireNonNull(camera2Mapper);
            ArrayList<Pair> arrayList2 = new ArrayList();
            int iOrdinal = flash2.ordinal();
            if (iOrdinal == 0) {
                arrayList2.add(new Pair(1, 0));
                arrayList2.add(new Pair(0, 0));
            } else if (iOrdinal == 1) {
                arrayList2.add(new Pair(3, 0));
            } else if (iOrdinal == 2) {
                arrayList2.add(new Pair(2, 0));
                arrayList2.add(new Pair(4, 0));
            } else if (iOrdinal == 3) {
                arrayList2.add(new Pair(1, 2));
                arrayList2.add(new Pair(0, 2));
            }
            for (Pair pair : arrayList2) {
                if (arrayList.contains(pair.first)) {
                    CameraLogger cameraLogger = CameraEngine.j;
                    cameraLogger.a(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    cameraLogger.a(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.w = flash;
        return false;
    }

    public boolean i1(@NonNull CaptureRequest.Builder builder, @NonNull Hdr hdr) {
        if (!this.p.c(this.A)) {
            this.A = hdr;
            return false;
        }
        Camera2Mapper camera2Mapper = this.k0;
        Hdr hdr2 = this.A;
        Objects.requireNonNull(camera2Mapper);
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(Camera2Mapper.d.get(hdr2).intValue()));
        return true;
    }

    public boolean j1(@NonNull CaptureRequest.Builder builder, float f2) {
        Range<Integer>[] rangeArr = (Range[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new Camera2Engine2(this, this.J && this.I != 0.0f));
        float f3 = this.I;
        if (f3 == 0.0f) {
            for (Range range : (ArrayList) r1(rangeArr)) {
                if (range.contains(30) || range.contains(24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (Range range2 : (ArrayList) r1(rangeArr)) {
                if (range2.contains(Integer.valueOf(Math.round(this.I)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.I = f2;
        return false;
    }

    @Override // b.o.a.n.CameraEngine
    public void k0(boolean z2) {
        this.n.b("has frame processors (" + z2 + ")", true, new j(z2));
    }

    public void k1() {
        l1(true, 3);
    }

    @Override // b.o.a.n.CameraEngine
    public void l0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.A;
        this.A = hdr;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("hdr (" + hdr + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new d(hdr2)));
    }

    public final void l1(boolean z2, int i2) {
        if ((this.n.f != CameraState2.PREVIEW || O()) && z2) {
            return;
        }
        try {
            this.f1920h0.setRepeatingRequest(this.f1921i0.build(), this.r0, null);
        } catch (CameraAccessException e2) {
            throw new CameraException(e2, i2);
        } catch (IllegalStateException e3) {
            CameraLogger cameraLogger = CameraEngine.j;
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            cameraLogger.a(3, "applyRepeatingRequestBuilder: session is invalid!", e3, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", cameraStateOrchestrator.f, "targetState:", cameraStateOrchestrator.g);
            throw new CameraException(3);
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b(location2)));
    }

    public boolean m1(@NonNull CaptureRequest.Builder builder, @NonNull WhiteBalance whiteBalance) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = whiteBalance;
            return false;
        }
        Camera2Mapper camera2Mapper = this.k0;
        WhiteBalance whiteBalance2 = this.f1932x;
        Objects.requireNonNull(camera2Mapper);
        builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(Camera2Mapper.c.get(whiteBalance2).intValue()));
        return true;
    }

    public boolean n1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.p.k) {
            this.D = f2;
            return false;
        }
        float fFloatValue = ((Float) t1(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f3 = fFloatValue - 1.0f;
        float f4 = (this.D * f3) + 1.0f;
        Rect rect = (Rect) t1(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
        int iWidth = (int) (rect.width() / fFloatValue);
        int iHeight = (int) (rect.height() / fFloatValue);
        int iWidth2 = rect.width() - iWidth;
        int iHeight2 = rect.height() - iHeight;
        float f5 = f4 - 1.0f;
        int i2 = (int) (((iWidth2 * f5) / f3) / 2.0f);
        int i3 = (int) (((iHeight2 * f5) / f3) / 2.0f);
        builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i2, i3, rect.width() - i2, rect.height() - i3));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    @NonNull
    public final CameraException o1(@NonNull CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i2 = 3;
        if (reason == 1) {
            i2 = 1;
        } else if (reason != 2 && reason != 3) {
            if (reason == 4 || reason == 5) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        }
        return new CameraException(cameraAccessException, i2);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        CameraEngine.j.a(0, "onImageAvailable:", "trying to acquire Image.");
        Image imageAcquireLatestImage = null;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (Exception unused) {
        }
        if (imageAcquireLatestImage == null) {
            CameraEngine.j.a(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.n.f != CameraState2.PREVIEW || O()) {
            CameraEngine.j.a(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            imageAcquireLatestImage.close();
            return;
        }
        Frame2 frame2A = S0().a(imageAcquireLatestImage, System.currentTimeMillis());
        if (frame2A == null) {
            CameraEngine.j.a(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            CameraEngine.j.a(0, "onImageAvailable:", "Image acquired, dispatching.");
            ((CameraView.b) this.m).b(frame2A);
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void p0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat != this.B) {
            this.B = pictureFormat;
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            cameraStateOrchestrator.b("picture format (" + pictureFormat + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new h()));
        }
    }

    @NonNull
    public final MeterAction p1(@Nullable MeteringRegions meteringRegions) {
        MeterAction meterAction = this.q0;
        if (meterAction != null) {
            meterAction.a(this);
        }
        CaptureRequest.Builder builder = this.f1921i0;
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.Q == Mode3.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        MeterAction meterAction2 = new MeterAction(this, meteringRegions, meteringRegions == null);
        this.q0 = meterAction2;
        return meterAction2;
    }

    @NonNull
    public final CaptureRequest.Builder q1(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.f1921i0;
        CaptureRequest.Builder builderCreateCaptureRequest = this.f1918f0.createCaptureRequest(i2);
        this.f1921i0 = builderCreateCaptureRequest;
        builderCreateCaptureRequest.setTag(Integer.valueOf(i2));
        d1(this.f1921i0, builder);
        return this.f1921i0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @NonNull
    public List<Range<Integer>> r1(@NonNull Range<Integer>[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int iRound = Math.round(this.p.p);
        int iRound2 = Math.round(this.p.q);
        for (Range<Integer> range : rangeArr) {
            if (range.contains(Integer.valueOf(iRound)) || range.contains(Integer.valueOf(iRound2))) {
                CameraLogger cameraLogger = FpsRangeValidator.a;
                String str = Build.MODEL;
                boolean z2 = true;
                String str2 = Build.MANUFACTURER;
                cameraLogger.a(1, "Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
                List<Range<Integer>> list = FpsRangeValidator.f1949b.get(str2 + " " + str);
                if (list != null && list.contains(range)) {
                    cameraLogger.a(1, "Dropping range:", range);
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(range);
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public List<Size3> s1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.u);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                Size3 size3 = new Size3(size.getWidth(), size.getHeight());
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void t0(boolean z2) {
        this.F = z2;
        b.i.a.f.e.o.f.Z(null);
    }

    @NonNull
    @VisibleForTesting
    public <T> T t1(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) this.f1919g0.get(key);
        return t2 == null ? t : t2;
    }

    @NonNull
    public final <T> T u1(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    @Override // b.o.a.n.CameraEngine
    public void v0(float f2) {
        float f3 = this.I;
        this.I = f2;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("preview fps (" + f2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new g(f3)));
    }
}
