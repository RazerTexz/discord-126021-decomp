package b.o.a.n;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera$CameraInfo;
import android.hardware.Camera$ErrorCallback;
import android.hardware.Camera$Parameters;
import android.hardware.Camera$PreviewCallback;
import android.hardware.Camera$Size;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.l$a;
import b.o.a.p.a$a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView$b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends g implements Camera$PreviewCallback, Camera$ErrorCallback, a$a {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final b.o.a.n.q.a f1913d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Camera f1914e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @VisibleForTesting
    public int f1915f0;

    public b(@NonNull i$g i_g) {
        super(i_g);
        this.f1913d0 = b.o.a.n.q.a.a();
    }

    @Override // b.o.a.n.i
    public void F0(@NonNull b.o.a.m.m mVar) {
        b.o.a.m.m mVar2 = this.f1932x;
        this.f1932x = mVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("white balance (" + mVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$d(this, mVar2)));
    }

    @Override // b.o.a.n.i
    public void G0(float f, @Nullable PointF[] pointFArr, boolean z2) {
        float f2 = this.D;
        this.D = f;
        this.n.e("zoom", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("zoom", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$f(this, f2, z2, pointFArr)));
    }

    @Override // b.o.a.n.i
    public void I0(@Nullable b.o.a.q.a aVar, @NonNull b.o.a.t.b bVar, @NonNull PointF pointF) {
        b.o.a.n.v.f fVar = this.n;
        fVar.b("auto focus", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.BIND, new b$a(this, bVar, aVar, pointF)));
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> P() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStartBind:", "Started");
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
            bVar.a(1, "onStartBind:", "Returning");
            return b.i.a.f.e.o.f.Z(null);
        } catch (IOException e) {
            i.j.a(3, "onStartBind:", "Failed to bind.", e);
            throw new CameraException(e, 2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<b.o.a.c> Q() {
        try {
            Camera cameraOpen = Camera.open(this.f1915f0);
            this.f1914e0 = cameraOpen;
            if (cameraOpen == null) {
                i.j.a(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            cameraOpen.setErrorCallback(this);
            b.o.a.b bVar = i.j;
            bVar.a(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera$Parameters parameters = this.f1914e0.getParameters();
                int i = this.f1915f0;
                b.o.a.n.t.a aVar = this.L;
                b.o.a.n.t.b bVar2 = b.o.a.n.t.b.SENSOR;
                b.o.a.n.t.b bVar3 = b.o.a.n.t.b.VIEW;
                this.p = new b.o.a.n.u.a(parameters, i, aVar.b(bVar2, bVar3));
                b1(parameters);
                this.f1914e0.setParameters(parameters);
                try {
                    this.f1914e0.setDisplayOrientation(this.L.c(bVar2, bVar3, 1));
                    bVar.a(1, "onStartEngine:", "Ended");
                    return b.i.a.f.e.o.f.Z(this.p);
                } catch (Exception unused) {
                    i.j.a(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e) {
                i.j.a(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e, 1);
            }
        } catch (Exception e2) {
            i.j.a(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e2, 1);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> R() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView$b) this.m).h();
        b.o.a.x.b bVarC = C(b.o.a.n.t.b.VIEW);
        if (bVarC == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(bVarC.j, bVarC.k);
        this.o.r(0);
        try {
            Camera$Parameters parameters = this.f1914e0.getParameters();
            parameters.setPreviewFormat(17);
            b.o.a.x.b bVar2 = this.f1931s;
            parameters.setPreviewSize(bVar2.j, bVar2.k);
            b.o.a.m.i iVar = this.Q;
            b.o.a.m.i iVar2 = b.o.a.m.i.PICTURE;
            if (iVar == iVar2) {
                b.o.a.x.b bVar3 = this.r;
                parameters.setPictureSize(bVar3.j, bVar3.k);
            } else {
                b.o.a.x.b bVarQ0 = Q0(iVar2);
                parameters.setPictureSize(bVarQ0.j, bVarQ0.k);
            }
            try {
                this.f1914e0.setParameters(parameters);
                this.f1914e0.setPreviewCallbackWithBuffer(null);
                this.f1914e0.setPreviewCallbackWithBuffer(this);
                l1().e(17, this.f1931s, this.L);
                bVar.a(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.f1914e0.startPreview();
                    bVar.a(1, "onStartPreview", "Started preview.");
                    return b.i.a.f.e.o.f.Z(null);
                } catch (Exception e) {
                    i.j.a(3, "onStartPreview", "Failed to start preview.", e);
                    throw new CameraException(e, 2);
                }
            } catch (Exception e2) {
                i.j.a(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e2, 2);
            }
        } catch (Exception e3) {
            i.j.a(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e3, 2);
        }
    }

    @Override // b.o.a.n.i
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
        } catch (IOException e) {
            i.j.a(3, "onStopBind", "Could not release surface", e);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> T() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStopEngine:", "About to clean up.");
        this.n.e("focus reset", 0);
        this.n.e("focus end", 0);
        if (this.f1914e0 != null) {
            try {
                bVar.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.f1914e0.release();
                bVar.a(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e) {
                i.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
            }
            this.f1914e0 = null;
            this.p = null;
        }
        this.p = null;
        this.f1914e0 = null;
        i.j.a(2, "onStopEngine:", "Clean up.", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public List<b.o.a.x.b> T0() {
        try {
            List<Camera$Size> supportedPreviewSizes = this.f1914e0.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera$Size camera$Size : supportedPreviewSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(camera$Size.width, camera$Size.height);
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            i.j.a(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e) {
            i.j.a(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e, 2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> U() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStopPreview:", "Started.");
        this.q = null;
        l1().d();
        bVar.a(1, "onStopPreview:", "Releasing preview buffers.");
        this.f1914e0.setPreviewCallbackWithBuffer(null);
        try {
            bVar.a(1, "onStopPreview:", "Stopping preview.");
            this.f1914e0.stopPreview();
            bVar.a(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e) {
            i.j.a(3, "stopPreview", "Could not stop preview", e);
        }
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public b.o.a.p.c V0(int i) {
        return new b.o.a.p.a(i, this);
    }

    @Override // b.o.a.n.g
    public void X0() {
        i.j.a(1, "RESTART PREVIEW:", "scheduled. State:", this.n.f);
        N0(false);
        K0();
    }

    @Override // b.o.a.n.g
    public void Y0(@NonNull l$a l_a, boolean z2) {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onTakePicture:", "executing.");
        b.o.a.n.t.a aVar = this.L;
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.SENSOR;
        b.o.a.n.t.b bVar3 = b.o.a.n.t.b.OUTPUT;
        l_a.c = aVar.c(bVar2, bVar3, 2);
        l_a.d = w(bVar3);
        b.o.a.v.a aVar2 = new b.o.a.v.a(l_a, this, this.f1914e0);
        this.q = aVar2;
        aVar2.c();
        bVar.a(1, "onTakePicture:", "executed.");
    }

    @Override // b.o.a.n.g
    public void Z0(@NonNull l$a l_a, @NonNull b.o.a.x.a aVar, boolean z2) {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onTakePictureSnapshot:", "executing.");
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.OUTPUT;
        l_a.d = F(bVar2);
        if (this.o instanceof b.o.a.w.e) {
            l_a.c = this.L.c(b.o.a.n.t.b.VIEW, bVar2, 1);
            this.q = new b.o.a.v.g(l_a, this, (b.o.a.w.e) this.o, aVar, this.f1930c0);
        } else {
            l_a.c = this.L.c(b.o.a.n.t.b.SENSOR, bVar2, 2);
            this.q = new b.o.a.v.e(l_a, this, this.f1914e0, aVar);
        }
        this.q.c();
        bVar.a(1, "onTakePictureSnapshot:", "executed.");
    }

    public final void b1(@NonNull Camera$Parameters camera$Parameters) {
        camera$Parameters.setRecordingHint(this.Q == b.o.a.m.i.VIDEO);
        c1(camera$Parameters);
        e1(camera$Parameters, b.o.a.m.f.OFF);
        g1(camera$Parameters);
        j1(camera$Parameters, b.o.a.m.m.AUTO);
        f1(camera$Parameters, b.o.a.m.h.OFF);
        k1(camera$Parameters, 0.0f);
        d1(camera$Parameters, 0.0f);
        h1(this.F);
        i1(camera$Parameters, 0.0f);
    }

    @Override // b.o.a.n.i
    public boolean c(@NonNull b.o.a.m.e eVar) {
        Objects.requireNonNull(this.f1913d0);
        int iIntValue = b.o.a.n.q.a.d.get(eVar).intValue();
        i.j.a(1, "collectCameraInfo", "Facing:", eVar, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, camera$CameraInfo);
            if (camera$CameraInfo.facing == iIntValue) {
                this.L.f(eVar, camera$CameraInfo.orientation);
                this.f1915f0 = i;
                return true;
            }
        }
        return false;
    }

    public final void c1(@NonNull Camera$Parameters camera$Parameters) {
        List<String> supportedFocusModes = camera$Parameters.getSupportedFocusModes();
        if (this.Q == b.o.a.m.i.VIDEO && supportedFocusModes.contains("continuous-video")) {
            camera$Parameters.setFocusMode("continuous-video");
            return;
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            camera$Parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            camera$Parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            camera$Parameters.setFocusMode("fixed");
        }
    }

    @Override // b.o.a.n.i
    public void d0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f2 = this.E;
        this.E = f;
        this.n.e("exposure correction", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("exposure correction", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$g(this, f2, z2, fArr, pointFArr)));
    }

    public final boolean d1(@NonNull Camera$Parameters camera$Parameters, float f) {
        b.o.a.c cVar = this.p;
        if (!cVar.l) {
            this.E = f;
            return false;
        }
        float f2 = cVar.n;
        float f3 = cVar.m;
        float f4 = this.E;
        if (f4 < f3) {
            f2 = f3;
        } else if (f4 <= f2) {
            f2 = f4;
        }
        this.E = f2;
        camera$Parameters.setExposureCompensation((int) (f2 / camera$Parameters.getExposureCompensationStep()));
        return true;
    }

    public final boolean e1(@NonNull Camera$Parameters camera$Parameters, @NonNull b.o.a.m.f fVar) {
        if (!this.p.c(this.w)) {
            this.w = fVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.f fVar2 = this.w;
        Objects.requireNonNull(aVar);
        camera$Parameters.setFlashMode(b.o.a.n.q.a.f1936b.get(fVar2));
        return true;
    }

    @Override // b.o.a.n.i
    public void f0(@NonNull b.o.a.m.f fVar) {
        b.o.a.m.f fVar2 = this.w;
        this.w = fVar;
        b.o.a.n.v.f fVar3 = this.n;
        fVar3.b("flash (" + fVar + ")", true, new b.o.a.n.v.h(fVar3, b.o.a.n.v.e.ENGINE, new b$b(this, fVar2)));
    }

    public final boolean f1(@NonNull Camera$Parameters camera$Parameters, @NonNull b.o.a.m.h hVar) {
        if (!this.p.c(this.A)) {
            this.A = hVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.h hVar2 = this.A;
        Objects.requireNonNull(aVar);
        camera$Parameters.setSceneMode(b.o.a.n.q.a.e.get(hVar2));
        return true;
    }

    @Override // b.o.a.n.i
    public void g0(int i) {
        this.u = 17;
    }

    public final boolean g1(@NonNull Camera$Parameters camera$Parameters) {
        Location location = this.C;
        if (location == null) {
            return true;
        }
        camera$Parameters.setGpsLatitude(location.getLatitude());
        camera$Parameters.setGpsLongitude(this.C.getLongitude());
        camera$Parameters.setGpsAltitude(this.C.getAltitude());
        camera$Parameters.setGpsTimestamp(this.C.getTime());
        camera$Parameters.setGpsProcessingMethod(this.C.getProvider());
        return true;
    }

    @TargetApi(17)
    public final boolean h1(boolean z2) {
        Camera$CameraInfo camera$CameraInfo = new Camera$CameraInfo();
        Camera.getCameraInfo(this.f1915f0, camera$CameraInfo);
        if (camera$CameraInfo.canDisableShutterSound) {
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

    public final boolean i1(@NonNull Camera$Parameters camera$Parameters, float f) {
        List<int[]> supportedPreviewFpsRange = camera$Parameters.getSupportedPreviewFpsRange();
        if (!this.J || this.I == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new a(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new c(this));
        }
        float f2 = this.I;
        if (f2 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                float f3 = iArr[0] / 1000.0f;
                float f4 = iArr[1] / 1000.0f;
                if ((f3 <= 30.0f && 30.0f <= f4) || (f3 <= 24.0f && 24.0f <= f4)) {
                    camera$Parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f2, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f5 = iArr2[0] / 1000.0f;
                float f6 = iArr2[1] / 1000.0f;
                float fRound = Math.round(this.I);
                if (f5 <= fRound && fRound <= f6) {
                    camera$Parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.I = f;
        return false;
    }

    public final boolean j1(@NonNull Camera$Parameters camera$Parameters, @NonNull b.o.a.m.m mVar) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = mVar;
            return false;
        }
        b.o.a.n.q.a aVar = this.f1913d0;
        b.o.a.m.m mVar2 = this.f1932x;
        Objects.requireNonNull(aVar);
        camera$Parameters.setWhiteBalance(b.o.a.n.q.a.c.get(mVar2));
        camera$Parameters.remove("auto-whitebalance-lock");
        return true;
    }

    @Override // b.o.a.n.i
    public void k0(boolean z2) {
        this.v = z2;
    }

    public final boolean k1(@NonNull Camera$Parameters camera$Parameters, float f) {
        if (!this.p.k) {
            this.D = f;
            return false;
        }
        camera$Parameters.setZoom((int) (this.D * camera$Parameters.getMaxZoom()));
        this.f1914e0.setParameters(camera$Parameters);
        return true;
    }

    @Override // b.o.a.n.i
    public void l0(@NonNull b.o.a.m.h hVar) {
        b.o.a.m.h hVar2 = this.A;
        this.A = hVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("hdr (" + hVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$e(this, hVar2)));
    }

    @NonNull
    public b.o.a.p.a l1() {
        return (b.o.a.p.a) S0();
    }

    @Override // b.o.a.n.i
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        b.o.a.n.v.f fVar = this.n;
        fVar.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$c(this, location2)));
    }

    public void m1(@NonNull byte[] bArr) {
        b.o.a.n.v.e eVar = this.n.f;
        b.o.a.n.v.e eVar2 = b.o.a.n.v.e.ENGINE;
        if (eVar.f(eVar2) && this.n.g.f(eVar2)) {
            this.f1914e0.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera$ErrorCallback
    public void onError(int i, Camera camera) {
        throw new CameraException(new RuntimeException(i.j.a(3, "Internal Camera1 error.", Integer.valueOf(i))), (i == 1 || i == 2 || i == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera$PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        b.o.a.p.b bVarA;
        if (bArr == null || (bVarA = l1().a(bArr, System.currentTimeMillis())) == null) {
            return;
        }
        ((CameraView$b) this.m).b(bVarA);
    }

    @Override // b.o.a.n.i
    public void p0(@NonNull b.o.a.m.j jVar) {
        if (jVar == b.o.a.m.j.JPEG) {
            this.B = jVar;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + jVar);
    }

    @Override // b.o.a.n.i
    public void t0(boolean z2) {
        boolean z3 = this.F;
        this.F = z2;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("play sounds (" + z2 + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$h(this, z3)));
    }

    @Override // b.o.a.n.i
    public void v0(float f) {
        this.I = f;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("preview fps (" + f + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new b$i(this, f)));
    }
}
