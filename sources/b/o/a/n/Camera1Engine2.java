package b.o.a.n;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
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
import b.o.a.n.q.Camera1Mapper;
import b.o.a.n.s.Camera1MeteringTransform;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.n.u.Camera1Options;
import b.o.a.n.v.CameraState2;
import b.o.a.n.v.CameraStateOrchestrator;
import b.o.a.n.v.CameraStateOrchestrator3;
import b.o.a.n.v.CameraStateOrchestrator4;
import b.o.a.p.ByteBufferFrameManager;
import b.o.a.p.Frame2;
import b.o.a.p.FrameManager;
import b.o.a.q.Gesture;
import b.o.a.t.MeteringRegions;
import b.o.a.v.Full1PictureRecorder;
import b.o.a.v.Snapshot1PictureRecorder;
import b.o.a.v.SnapshotGlPictureRecorder;
import b.o.a.w.RendererCameraPreview;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.n.b, reason: use source file name */
/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1Engine2 extends CameraBaseEngine implements Camera.PreviewCallback, Camera.ErrorCallback, ByteBufferFrameManager.a {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final Camera1Mapper f1913d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Camera f1914e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @VisibleForTesting
    public int f1915f0;

    /* JADX INFO: renamed from: b.o.a.n.b$a */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class a implements Runnable {
        public final /* synthetic */ MeteringRegions j;
        public final /* synthetic */ Gesture k;
        public final /* synthetic */ PointF l;

        /* JADX INFO: renamed from: b.o.a.n.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Camera1Engine.java */
        public class RunnableC0059a implements Runnable {
            public RunnableC0059a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                ((CameraView.b) Camera1Engine2.this.m).d(aVar.k, false, aVar.l);
            }
        }

        /* JADX INFO: renamed from: b.o.a.n.b$a$b */
        /* JADX INFO: compiled from: Camera1Engine.java */
        public class b implements Camera.AutoFocusCallback {

            /* JADX INFO: renamed from: b.o.a.n.b$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Camera1Engine.java */
            public class RunnableC0060a implements Runnable {
                public RunnableC0060a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Camera1Engine2.this.f1914e0.cancelAutoFocus();
                    Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    Camera1Engine2.this.c1(parameters);
                    Camera1Engine2.this.f1914e0.setParameters(parameters);
                }
            }

            public b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z2, Camera camera) {
                Camera1Engine2.this.n.e("focus end", 0);
                Camera1Engine2.this.n.e("focus reset", 0);
                a aVar = a.this;
                ((CameraView.b) Camera1Engine2.this.m).d(aVar.k, z2, aVar.l);
                if (Camera1Engine2.this.a1()) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    CameraStateOrchestrator cameraStateOrchestrator = camera1Engine2.n;
                    cameraStateOrchestrator.c("focus reset", true, camera1Engine2.W, new CameraStateOrchestrator4(cameraStateOrchestrator, CameraState2.ENGINE, new RunnableC0060a()));
                }
            }
        }

        public a(MeteringRegions meteringRegions, Gesture gesture, PointF pointF) {
            this.j = meteringRegions;
            this.k = gesture;
            this.l = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Camera1Engine2.this.p.o) {
                Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                Camera1MeteringTransform camera1MeteringTransform = new Camera1MeteringTransform(camera1Engine2.L, camera1Engine2.o.l());
                MeteringRegions meteringRegionsC = this.j.c(camera1MeteringTransform);
                Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(meteringRegionsC.b(maxNumFocusAreas, camera1MeteringTransform));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(meteringRegionsC.b(maxNumMeteringAreas, camera1MeteringTransform));
                }
                parameters.setFocusMode("auto");
                Camera1Engine2.this.f1914e0.setParameters(parameters);
                ((CameraView.b) Camera1Engine2.this.m).e(this.k, this.l);
                Camera1Engine2.this.n.e("focus end", 0);
                Camera1Engine2.this.n.c("focus end", true, 2500L, new RunnableC0059a());
                try {
                    Camera1Engine2.this.f1914e0.autoFocus(new b());
                } catch (RuntimeException e) {
                    CameraEngine.j.a(3, "startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$b */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class b implements Runnable {
        public final /* synthetic */ Flash j;

        public b(Flash flash) {
            this.j = flash;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.e1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$c */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class c implements Runnable {
        public final /* synthetic */ Location j;

        public c(Location location) {
            this.j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            Camera1Engine2.this.g1(parameters);
            Camera1Engine2.this.f1914e0.setParameters(parameters);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$d */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class d implements Runnable {
        public final /* synthetic */ WhiteBalance j;

        public d(WhiteBalance whiteBalance) {
            this.j = whiteBalance;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.j1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$e */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class e implements Runnable {
        public final /* synthetic */ Hdr j;

        public e(Hdr hdr) {
            this.j = hdr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.f1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$f */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class f implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ PointF[] l;

        public f(float f, boolean z2, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.k1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
                if (this.k) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    ((CameraView.b) camera1Engine2.m).f(camera1Engine2.D, this.l);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$g */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class g implements Runnable {
        public final /* synthetic */ float j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ float[] l;
        public final /* synthetic */ PointF[] m;

        public g(float f, boolean z2, float[] fArr, PointF[] pointFArr) {
            this.j = f;
            this.k = z2;
            this.l = fArr;
            this.m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.d1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
                if (this.k) {
                    Camera1Engine2 camera1Engine2 = Camera1Engine2.this;
                    ((CameraView.b) camera1Engine2.m).c(camera1Engine2.E, this.l, this.m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$h */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class h implements Runnable {
        public final /* synthetic */ boolean j;

        public h(boolean z2) {
            this.j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera1Engine2.this.h1(this.j);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$i */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class i implements Runnable {
        public final /* synthetic */ float j;

        public i(float f) {
            this.j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = Camera1Engine2.this.f1914e0.getParameters();
            if (Camera1Engine2.this.i1(parameters, this.j)) {
                Camera1Engine2.this.f1914e0.setParameters(parameters);
            }
        }
    }

    public Camera1Engine2(@NonNull CameraEngine.g gVar) {
        super(gVar);
        this.f1913d0 = Camera1Mapper.a();
    }

    @Override // b.o.a.n.CameraEngine
    public void F0(@NonNull WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f1932x;
        this.f1932x = whiteBalance;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("white balance (" + whiteBalance + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new d(whiteBalance2)));
    }

    @Override // b.o.a.n.CameraEngine
    public void G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.D;
        this.D = f2;
        this.n.e("zoom", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("zoom", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new f(f3, z2, pointFArr)));
    }

    @Override // b.o.a.n.CameraEngine
    public void I0(@Nullable Gesture gesture, @NonNull MeteringRegions meteringRegions, @NonNull PointF pointF) {
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("auto focus", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new a(meteringRegions, gesture, pointF)));
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> P() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStartBind:", "Started");
        try {
            if (this.o.j() == SurfaceHolder.class) {
                this.f1914e0.setPreviewDisplay((SurfaceHolder) this.o.i());
            } else {
                if (this.o.j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f1914e0.setPreviewTexture((SurfaceTexture) this.o.i());
            }
            this.r = Q0(this.Q);
            this.f1931s = R0();
            cameraLogger.a(1, "onStartBind:", "Returning");
            return b.i.a.f.e.o.f.Z(null);
        } catch (IOException e2) {
            CameraEngine.j.a(3, "onStartBind:", "Failed to bind.", e2);
            throw new CameraException(e2, 2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<CameraOptions> Q() {
        try {
            Camera cameraOpen = Camera.open(this.f1915f0);
            this.f1914e0 = cameraOpen;
            if (cameraOpen == null) {
                CameraEngine.j.a(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            cameraOpen.setErrorCallback(this);
            CameraLogger cameraLogger = CameraEngine.j;
            cameraLogger.a(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera.Parameters parameters = this.f1914e0.getParameters();
                int i2 = this.f1915f0;
                Angles angles = this.L;
                Reference2 reference2 = Reference2.SENSOR;
                Reference2 reference3 = Reference2.VIEW;
                this.p = new Camera1Options(parameters, i2, angles.b(reference2, reference3));
                b1(parameters);
                this.f1914e0.setParameters(parameters);
                try {
                    this.f1914e0.setDisplayOrientation(this.L.c(reference2, reference3, 1));
                    cameraLogger.a(1, "onStartEngine:", "Ended");
                    return b.i.a.f.e.o.f.Z(this.p);
                } catch (Exception unused) {
                    CameraEngine.j.a(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e2) {
                CameraEngine.j.a(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e2, 1);
            }
        } catch (Exception e3) {
            CameraEngine.j.a(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e3, 1);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> R() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.b) this.m).h();
        Size3 size3C = C(Reference2.VIEW);
        if (size3C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(size3C.j, size3C.k);
        this.o.r(0);
        try {
            Camera.Parameters parameters = this.f1914e0.getParameters();
            parameters.setPreviewFormat(17);
            Size3 size3 = this.f1931s;
            parameters.setPreviewSize(size3.j, size3.k);
            Mode3 mode3 = this.Q;
            Mode3 mode4 = Mode3.PICTURE;
            if (mode3 == mode4) {
                Size3 size4 = this.r;
                parameters.setPictureSize(size4.j, size4.k);
            } else {
                Size3 size3Q0 = Q0(mode4);
                parameters.setPictureSize(size3Q0.j, size3Q0.k);
            }
            try {
                this.f1914e0.setParameters(parameters);
                this.f1914e0.setPreviewCallbackWithBuffer(null);
                this.f1914e0.setPreviewCallbackWithBuffer(this);
                l1().e(17, this.f1931s, this.L);
                cameraLogger.a(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.f1914e0.startPreview();
                    cameraLogger.a(1, "onStartPreview", "Started preview.");
                    return b.i.a.f.e.o.f.Z(null);
                } catch (Exception e2) {
                    CameraEngine.j.a(3, "onStartPreview", "Failed to start preview.", e2);
                    throw new CameraException(e2, 2);
                }
            } catch (Exception e3) {
                CameraEngine.j.a(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e3, 2);
            }
        } catch (Exception e4) {
            CameraEngine.j.a(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e4, 2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> S() {
        this.f1931s = null;
        this.r = null;
        try {
            if (this.o.j() == SurfaceHolder.class) {
                this.f1914e0.setPreviewDisplay(null);
            } else {
                if (this.o.j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f1914e0.setPreviewTexture(null);
            }
        } catch (IOException e2) {
            CameraEngine.j.a(3, "onStopBind", "Could not release surface", e2);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> T() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStopEngine:", "About to clean up.");
        this.n.e("focus reset", 0);
        this.n.e("focus end", 0);
        if (this.f1914e0 != null) {
            try {
                cameraLogger.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.f1914e0.release();
                cameraLogger.a(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                CameraEngine.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
            }
            this.f1914e0 = null;
            this.p = null;
        }
        this.p = null;
        this.f1914e0 = null;
        CameraEngine.j.a(2, "onStopEngine:", "Clean up.", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraBaseEngine
    @NonNull
    public List<Size3> T0() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.f1914e0.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                Size3 size3 = new Size3(size.width, size.height);
                if (!arrayList.contains(size3)) {
                    arrayList.add(size3);
                }
            }
            CameraEngine.j.a(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e2) {
            CameraEngine.j.a(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e2, 2);
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public Task<Void> U() {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onStopPreview:", "Started.");
        this.q = null;
        l1().d();
        cameraLogger.a(1, "onStopPreview:", "Releasing preview buffers.");
        this.f1914e0.setPreviewCallbackWithBuffer(null);
        try {
            cameraLogger.a(1, "onStopPreview:", "Stopping preview.");
            this.f1914e0.stopPreview();
            cameraLogger.a(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e2) {
            CameraEngine.j.a(3, "stopPreview", "Could not stop preview", e2);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraBaseEngine
    @NonNull
    public FrameManager V0(int i2) {
        return new ByteBufferFrameManager(i2, this);
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void X0() {
        CameraEngine.j.a(1, "RESTART PREVIEW:", "scheduled. State:", this.n.f);
        N0(false);
        K0();
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void Y0(@NonNull PictureResult.a aVar, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onTakePicture:", "executing.");
        Angles angles = this.L;
        Reference2 reference2 = Reference2.SENSOR;
        Reference2 reference3 = Reference2.OUTPUT;
        aVar.c = angles.c(reference2, reference3, 2);
        aVar.d = w(reference3);
        Full1PictureRecorder full1PictureRecorder = new Full1PictureRecorder(aVar, this, this.f1914e0);
        this.q = full1PictureRecorder;
        full1PictureRecorder.c();
        cameraLogger.a(1, "onTakePicture:", "executed.");
    }

    @Override // b.o.a.n.CameraBaseEngine
    public void Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2) {
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "onTakePictureSnapshot:", "executing.");
        Reference2 reference2 = Reference2.OUTPUT;
        aVar.d = F(reference2);
        if (this.o instanceof RendererCameraPreview) {
            aVar.c = this.L.c(Reference2.VIEW, reference2, 1);
            this.q = new SnapshotGlPictureRecorder(aVar, this, (RendererCameraPreview) this.o, aspectRatio2, this.f1930c0);
        } else {
            aVar.c = this.L.c(Reference2.SENSOR, reference2, 2);
            this.q = new Snapshot1PictureRecorder(aVar, this, this.f1914e0, aspectRatio2);
        }
        this.q.c();
        cameraLogger.a(1, "onTakePictureSnapshot:", "executed.");
    }

    public final void b1(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(this.Q == Mode3.VIDEO);
        c1(parameters);
        e1(parameters, Flash.OFF);
        g1(parameters);
        j1(parameters, WhiteBalance.AUTO);
        f1(parameters, Hdr.OFF);
        k1(parameters, 0.0f);
        d1(parameters, 0.0f);
        h1(this.F);
        i1(parameters, 0.0f);
    }

    @Override // b.o.a.n.CameraEngine
    public boolean c(@NonNull Facing facing) {
        Objects.requireNonNull(this.f1913d0);
        int iIntValue = Camera1Mapper.d.get(facing).intValue();
        CameraEngine.j.a(1, "collectCameraInfo", "Facing:", facing, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                this.L.f(facing, cameraInfo.orientation);
                this.f1915f0 = i2;
                return true;
            }
        }
        return false;
    }

    public final void c1(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.Q == Mode3.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            return;
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    @Override // b.o.a.n.CameraEngine
    public void d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.E;
        this.E = f2;
        this.n.e("exposure correction", 20);
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("exposure correction", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new g(f3, z2, fArr, pointFArr)));
    }

    public final boolean d1(@NonNull Camera.Parameters parameters, float f2) {
        CameraOptions cameraOptions = this.p;
        if (!cameraOptions.l) {
            this.E = f2;
            return false;
        }
        float f3 = cameraOptions.n;
        float f4 = cameraOptions.m;
        float f5 = this.E;
        if (f5 < f4) {
            f3 = f4;
        } else if (f5 <= f3) {
            f3 = f5;
        }
        this.E = f3;
        parameters.setExposureCompensation((int) (f3 / parameters.getExposureCompensationStep()));
        return true;
    }

    public final boolean e1(@NonNull Camera.Parameters parameters, @NonNull Flash flash) {
        if (!this.p.c(this.w)) {
            this.w = flash;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f1913d0;
        Flash flash2 = this.w;
        Objects.requireNonNull(camera1Mapper);
        parameters.setFlashMode(Camera1Mapper.f1936b.get(flash2));
        return true;
    }

    @Override // b.o.a.n.CameraEngine
    public void f0(@NonNull Flash flash) {
        Flash flash2 = this.w;
        this.w = flash;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("flash (" + flash + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b(flash2)));
    }

    public final boolean f1(@NonNull Camera.Parameters parameters, @NonNull Hdr hdr) {
        if (!this.p.c(this.A)) {
            this.A = hdr;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f1913d0;
        Hdr hdr2 = this.A;
        Objects.requireNonNull(camera1Mapper);
        parameters.setSceneMode(Camera1Mapper.e.get(hdr2));
        return true;
    }

    @Override // b.o.a.n.CameraEngine
    public void g0(int i2) {
        this.u = 17;
    }

    public final boolean g1(@NonNull Camera.Parameters parameters) {
        Location location = this.C;
        if (location == null) {
            return true;
        }
        parameters.setGpsLatitude(location.getLatitude());
        parameters.setGpsLongitude(this.C.getLongitude());
        parameters.setGpsAltitude(this.C.getAltitude());
        parameters.setGpsTimestamp(this.C.getTime());
        parameters.setGpsProcessingMethod(this.C.getProvider());
        return true;
    }

    @TargetApi(17)
    public final boolean h1(boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f1915f0, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.f1914e0.enableShutterSound(this.F);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        if (this.F) {
            return true;
        }
        this.F = z2;
        return false;
    }

    public final boolean i1(@NonNull Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!this.J || this.I == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new Camera1Engine(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new Camera1Engine3(this));
        }
        float f3 = this.I;
        if (f3 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                float f4 = iArr[0] / 1000.0f;
                float f5 = iArr[1] / 1000.0f;
                if ((f4 <= 30.0f && 30.0f <= f5) || (f4 <= 24.0f && 24.0f <= f5)) {
                    parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f6 = iArr2[0] / 1000.0f;
                float f7 = iArr2[1] / 1000.0f;
                float fRound = Math.round(this.I);
                if (f6 <= fRound && fRound <= f7) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.I = f2;
        return false;
    }

    public final boolean j1(@NonNull Camera.Parameters parameters, @NonNull WhiteBalance whiteBalance) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = whiteBalance;
            return false;
        }
        Camera1Mapper camera1Mapper = this.f1913d0;
        WhiteBalance whiteBalance2 = this.f1932x;
        Objects.requireNonNull(camera1Mapper);
        parameters.setWhiteBalance(Camera1Mapper.c.get(whiteBalance2));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    @Override // b.o.a.n.CameraEngine
    public void k0(boolean z2) {
        this.v = z2;
    }

    public final boolean k1(@NonNull Camera.Parameters parameters, float f2) {
        if (!this.p.k) {
            this.D = f2;
            return false;
        }
        parameters.setZoom((int) (this.D * parameters.getMaxZoom()));
        this.f1914e0.setParameters(parameters);
        return true;
    }

    @Override // b.o.a.n.CameraEngine
    public void l0(@NonNull Hdr hdr) {
        Hdr hdr2 = this.A;
        this.A = hdr;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("hdr (" + hdr + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new e(hdr2)));
    }

    @NonNull
    public ByteBufferFrameManager l1() {
        return (ByteBufferFrameManager) S0();
    }

    @Override // b.o.a.n.CameraEngine
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new c(location2)));
    }

    public void m1(@NonNull byte[] bArr) {
        CameraState2 cameraState2 = this.n.f;
        CameraState2 cameraState3 = CameraState2.ENGINE;
        if (cameraState2.f(cameraState3) && this.n.g.f(cameraState3)) {
            this.f1914e0.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        throw new CameraException(new RuntimeException(CameraEngine.j.a(3, "Internal Camera1 error.", Integer.valueOf(i2))), (i2 == 1 || i2 == 2 || i2 == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Frame2 frame2A;
        if (bArr == null || (frame2A = l1().a(bArr, System.currentTimeMillis())) == null) {
            return;
        }
        ((CameraView.b) this.m).b(frame2A);
    }

    @Override // b.o.a.n.CameraEngine
    public void p0(@NonNull PictureFormat pictureFormat) {
        if (pictureFormat == PictureFormat.JPEG) {
            this.B = pictureFormat;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
    }

    @Override // b.o.a.n.CameraEngine
    public void t0(boolean z2) {
        boolean z3 = this.F;
        this.F = z2;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("play sounds (" + z2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new h(z3)));
    }

    @Override // b.o.a.n.CameraEngine
    public void v0(float f2) {
        this.I = f2;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("preview fps (" + f2 + ")", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new i(f2)));
    }
}
