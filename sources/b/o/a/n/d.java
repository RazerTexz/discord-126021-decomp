package b.o.a.n;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession$CaptureCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraCharacteristics$Key;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest$Builder;
import android.hardware.camera2.CaptureRequest$Key;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.media.ImageReader$OnImageAvailableListener;
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
import b.o.a.l$a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.ChatInputComponentTypes;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView$b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class d extends g implements ImageReader$OnImageAvailableListener, b.o.a.n.o.c {

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
    public CaptureRequest$Builder f1921i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public TotalCaptureResult f1922j0;
    public final b.o.a.n.q.b k0;
    public ImageReader l0;
    public Surface m0;
    public Surface n0;
    public ImageReader o0;
    public final List<b.o.a.n.o.a> p0;
    public b.o.a.n.r.g q0;
    public final CameraCaptureSession$CaptureCallback r0;

    public d(i$g i_g) {
        super(i_g);
        if (b.o.a.n.q.b.a == null) {
            b.o.a.n.q.b.a = new b.o.a.n.q.b();
        }
        this.k0 = b.o.a.n.q.b.a;
        this.p0 = new CopyOnWriteArrayList();
        this.r0 = new d$i(this);
        this.f1916d0 = (CameraManager) ((CameraView$b) this.m).g().getSystemService(ChatInputComponentTypes.CAMERA);
        new b.o.a.n.o.g().e(this);
    }

    public static void b1(d dVar) {
        Objects.requireNonNull(dVar);
        new b.o.a.n.o.h(Arrays.asList(new f(dVar), new b.o.a.n.r.h())).e(dVar);
    }

    @Override // b.o.a.n.i
    public void F0(@NonNull b.o.a.m.m mVar) {
        b.o.a.m.m mVar2 = this.f1932x;
        this.f1932x = mVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("white balance (" + mVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$c(this, mVar2)));
    }

    @Override // b.o.a.n.i
    public void G0(float f, @Nullable PointF[] pointFArr, boolean z2) {
        float f2 = this.D;
        this.D = f;
        this.n.e("zoom", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("zoom", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$e(this, f2, z2, f, pointFArr)));
    }

    @Override // b.o.a.n.i
    public void I0(@Nullable b.o.a.q.a aVar, @NonNull b.o.a.t.b bVar, @NonNull PointF pointF) {
        b.o.a.n.v.f fVar = this.n;
        fVar.b("autofocus (" + aVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.PREVIEW, new d$l(this, aVar, pointF, bVar)));
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
    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> P() {
        Handler handler;
        int i;
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.r = Q0(this.Q);
        this.f1931s = R0();
        ArrayList arrayList = new ArrayList();
        Class clsJ = this.o.j();
        Object objI = this.o.i();
        if (clsJ == SurfaceHolder.class) {
            try {
                bVar.a(1, "onStartBind:", "Waiting on UI thread...");
                b.i.a.f.e.o.f.j(b.i.a.f.e.o.f.o(b.i.a.f.n.g.a, new d$n(this, objI)));
                this.n0 = ((SurfaceHolder) objI).getSurface();
            } catch (InterruptedException | ExecutionException e) {
                throw new CameraException(e, 1);
            }
        } else {
            if (clsJ != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) objI;
            b.o.a.x.b bVar2 = this.f1931s;
            surfaceTexture.setDefaultBufferSize(bVar2.j, bVar2.k);
            this.n0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.n0);
        if (this.Q == b.o.a.m.i.PICTURE) {
            int iOrdinal = this.B.ordinal();
            if (iOrdinal == 0) {
                i = 256;
            } else {
                if (iOrdinal != 1) {
                    StringBuilder sbU = b.d.b.a.a.U("Unknown format:");
                    sbU.append(this.B);
                    throw new IllegalArgumentException(sbU.toString());
                }
                i = 32;
            }
            b.o.a.x.b bVar3 = this.r;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(bVar3.j, bVar3.k, i, 2);
            this.o0 = imageReaderNewInstance;
            arrayList.add(imageReaderNewInstance.getSurface());
        }
        if (this.v) {
            List<b.o.a.x.b> listS1 = s1();
            boolean zB = this.L.b(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW);
            ArrayList<b.o.a.x.b> arrayList2 = (ArrayList) listS1;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (b.o.a.x.b bVarF : arrayList2) {
                if (zB) {
                    bVarF = bVarF.f();
                }
                arrayList3.add(bVarF);
            }
            b.o.a.x.b bVar4 = this.f1931s;
            b.o.a.x.a aVarF = b.o.a.x.a.f(bVar4.j, bVar4.k);
            if (zB) {
                aVarF = b.o.a.x.a.f(aVarF.l, aVarF.k);
            }
            int i2 = this.Z;
            int i3 = this.f1928a0;
            if (i2 <= 0 || i2 == Integer.MAX_VALUE) {
                i2 = 640;
            }
            if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
                i3 = 640;
            }
            b.o.a.x.b bVar5 = new b.o.a.x.b(i2, i3);
            b.o.a.b bVar6 = i.j;
            bVar6.a(1, "computeFrameProcessingSize:", "targetRatio:", aVarF, "targetMaxSize:", bVar5);
            b.o.a.x.c cVarD1 = b.i.a.f.e.o.f.D1(new b.o.a.x.d(aVarF.i(), 0.0f));
            b.o.a.x.c cVarG = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.K0(i3), b.i.a.f.e.o.f.L0(i2), new b.o.a.x.e());
            b.o.a.x.b bVarF2 = ((b.o.a.x.l) b.i.a.f.e.o.f.Q0(b.i.a.f.e.o.f.g(cVarD1, cVarG), cVarG, new b.o.a.x.f())).a(arrayList3).get(0);
            if (!arrayList3.contains(bVarF2)) {
                throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
            }
            if (zB) {
                bVarF2 = bVarF2.f();
            }
            bVar6.a(1, "computeFrameProcessingSize:", "result:", bVarF2, "flip:", Boolean.valueOf(zB));
            this.t = bVarF2;
            ImageReader imageReaderNewInstance2 = ImageReader.newInstance(bVarF2.j, bVarF2.k, this.u, this.f1929b0 + 1);
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
            this.f1918f0.createCaptureSession(arrayList, new d$o(this, taskCompletionSource), handler);
            return taskCompletionSource.a;
        } catch (CameraAccessException e2) {
            throw o1(e2);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    @SuppressLint({"MissingPermission"})
    public Task<b.o.a.c> Q() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.f1916d0.openCamera(this.f1917e0, new d$m(this, taskCompletionSource), (Handler) null);
            return taskCompletionSource.a;
        } catch (CameraAccessException e) {
            throw o1(e);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> R() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView$b) this.m).h();
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.VIEW;
        b.o.a.x.b bVarC = C(bVar2);
        if (bVarC == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.o.s(bVarC.j, bVarC.k);
        this.o.r(this.L.c(b.o.a.n.t.b.BASE, bVar2, 1));
        if (this.v) {
            S0().e(this.u, this.t, this.L);
        }
        bVar.a(1, "onStartPreview:", "Starting preview.");
        c1(new Surface[0]);
        l1(false, 2);
        bVar.a(1, "onStartPreview:", "Started preview.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new d$p(this, taskCompletionSource).e(this);
        return taskCompletionSource.a;
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> S() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStopBind:", "About to clean up.");
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
        bVar.a(1, "onStopBind:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> T() {
        try {
            b.o.a.b bVar = i.j;
            bVar.a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.f1918f0.close();
            bVar.a(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e) {
            i.j.a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
        }
        this.f1918f0 = null;
        i.j.a(1, "onStopEngine:", "Aborting actions.");
        Iterator<b.o.a.n.o.a> it = this.p0.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        this.f1919g0 = null;
        this.p = null;
        this.f1921i0 = null;
        i.j.a(2, "onStopEngine:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public List<b.o.a.x.b> T0() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.o.j());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        } catch (CameraAccessException e) {
            throw o1(e);
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public Task<Void> U() {
        b.o.a.b bVar = i.j;
        bVar.a(1, "onStopPreview:", "Started.");
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
        bVar.a(1, "onStopPreview:", "Returning.");
        return b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.g
    @NonNull
    public b.o.a.p.c V0(int i) {
        return new b.o.a.p.e(i);
    }

    @Override // b.o.a.n.g
    public void X0() {
        i.j.a(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        Y();
    }

    @Override // b.o.a.n.g
    public void Y0(@NonNull l$a l_a, boolean z2) {
        if (z2) {
            i.j.a(1, "onTakePicture:", "doMetering is true. Delaying.");
            b.o.a.n.o.i iVar = new b.o.a.n.o.i(2500L, p1(null));
            iVar.f(new d$r(this, l_a));
            iVar.e(this);
            return;
        }
        i.j.a(1, "onTakePicture:", "doMetering is false. Performing.");
        b.o.a.n.t.a aVar = this.L;
        b.o.a.n.t.b bVar = b.o.a.n.t.b.SENSOR;
        b.o.a.n.t.b bVar2 = b.o.a.n.t.b.OUTPUT;
        l_a.c = aVar.c(bVar, bVar2, 2);
        l_a.d = w(bVar2);
        try {
            CaptureRequest$Builder captureRequest$BuilderCreateCaptureRequest = this.f1918f0.createCaptureRequest(2);
            d1(captureRequest$BuilderCreateCaptureRequest, this.f1921i0);
            b.o.a.v.b bVar3 = new b.o.a.v.b(l_a, this, captureRequest$BuilderCreateCaptureRequest, this.o0);
            this.q = bVar3;
            bVar3.c();
        } catch (CameraAccessException e) {
            throw o1(e);
        }
    }

    @Override // b.o.a.n.g
    public void Z0(@NonNull l$a l_a, @NonNull b.o.a.x.a aVar, boolean z2) {
        if (z2) {
            i.j.a(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            b.o.a.n.o.i iVar = new b.o.a.n.o.i(2500L, p1(null));
            iVar.f(new d$q(this, l_a));
            iVar.e(this);
            return;
        }
        i.j.a(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.o instanceof b.o.a.w.e)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        b.o.a.n.t.b bVar = b.o.a.n.t.b.OUTPUT;
        l_a.d = F(bVar);
        l_a.c = this.L.c(b.o.a.n.t.b.VIEW, bVar, 1);
        b.o.a.v.f fVar = new b.o.a.v.f(l_a, this, (b.o.a.w.e) this.o, aVar);
        this.q = fVar;
        fVar.c();
    }

    @Override // b.o.a.n.g, b.o.a.v.d$a
    public void a(@Nullable l$a l_a, @Nullable Exception exc) {
        boolean z2 = this.q instanceof b.o.a.v.b;
        super.a(l_a, exc);
        if ((z2 && this.G) || (!z2 && this.H)) {
            b.o.a.n.v.f fVar = this.n;
            fVar.b("reset metering after picture", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.PREVIEW, new d$s(this)));
        }
    }

    @Override // b.o.a.n.i
    public final boolean c(@NonNull b.o.a.m.e eVar) {
        Objects.requireNonNull(this.k0);
        int iIntValue = b.o.a.n.q.b.f1937b.get(eVar).intValue();
        try {
            String[] cameraIdList = this.f1916d0.getCameraIdList();
            i.j.a(1, "collectCameraInfo", "Facing:", eVar, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    CameraCharacteristics cameraCharacteristics = this.f1916d0.getCameraCharacteristics(str);
                    if (iIntValue == ((Integer) u1(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.f1917e0 = str;
                        this.L.f(eVar, ((Integer) u1(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                    continue;
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e) {
            throw o1(e);
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

    @Override // b.o.a.n.i
    public void d0(float f, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f2 = this.E;
        this.E = f;
        this.n.e("exposure correction", 20);
        b.o.a.n.v.f fVar = this.n;
        fVar.b("exposure correction", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$f(this, f2, z2, f, fArr, pointFArr)));
    }

    public final void d1(@NonNull CaptureRequest$Builder captureRequest$Builder, @Nullable CaptureRequest$Builder captureRequest$Builder2) {
        i.j.a(1, "applyAllParameters:", "called for tag", captureRequest$Builder.build().getTag());
        captureRequest$Builder.set(CaptureRequest.CONTROL_MODE, 1);
        f1(captureRequest$Builder);
        h1(captureRequest$Builder, b.o.a.m.f.OFF);
        Location location = this.C;
        if (location != null) {
            captureRequest$Builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        m1(captureRequest$Builder, b.o.a.m.m.AUTO);
        i1(captureRequest$Builder, b.o.a.m.h.OFF);
        n1(captureRequest$Builder, 0.0f);
        g1(captureRequest$Builder, 0.0f);
        j1(captureRequest$Builder, 0.0f);
        if (captureRequest$Builder2 != null) {
            CaptureRequest$Key captureRequest$Key = CaptureRequest.CONTROL_AF_REGIONS;
            captureRequest$Builder.set(captureRequest$Key, (MeteringRectangle[]) captureRequest$Builder2.get(captureRequest$Key));
            CaptureRequest$Key captureRequest$Key2 = CaptureRequest.CONTROL_AE_REGIONS;
            captureRequest$Builder.set(captureRequest$Key2, (MeteringRectangle[]) captureRequest$Builder2.get(captureRequest$Key2));
            CaptureRequest$Key captureRequest$Key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            captureRequest$Builder.set(captureRequest$Key3, (MeteringRectangle[]) captureRequest$Builder2.get(captureRequest$Key3));
            CaptureRequest$Key captureRequest$Key4 = CaptureRequest.CONTROL_AF_MODE;
            captureRequest$Builder.set(captureRequest$Key4, (Integer) captureRequest$Builder2.get(captureRequest$Key4));
        }
    }

    public void e1(@NonNull b.o.a.n.o.a aVar, @NonNull CaptureRequest$Builder captureRequest$Builder) throws CameraAccessException {
        if (this.n.f != b.o.a.n.v.e.PREVIEW || O()) {
            return;
        }
        this.f1920h0.capture(captureRequest$Builder.build(), this.r0, null);
    }

    @Override // b.o.a.n.i
    public void f0(@NonNull b.o.a.m.f fVar) {
        b.o.a.m.f fVar2 = this.w;
        this.w = fVar;
        b.o.a.n.v.f fVar3 = this.n;
        fVar3.b("flash (" + fVar + ")", true, new b.o.a.n.v.h(fVar3, b.o.a.n.v.e.ENGINE, new d$a(this, fVar2, fVar)));
    }

    public void f1(@NonNull CaptureRequest$Builder captureRequest$Builder) {
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        if (this.Q == b.o.a.m.i.VIDEO && arrayList.contains(3)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            return;
        }
        if (arrayList.contains(4)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        if (arrayList.contains(1)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            captureRequest$Builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    @Override // b.o.a.n.i
    public void g0(int i) {
        if (this.u == 0) {
            this.u = 35;
        }
        this.n.b(b.d.b.a.a.r("frame processing format (", i, ")"), true, new d$k(this, i));
    }

    public boolean g1(@NonNull CaptureRequest$Builder captureRequest$Builder, float f) {
        if (!this.p.l) {
            this.E = f;
            return false;
        }
        Rational rational = (Rational) t1(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        captureRequest$Builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.E)));
        return true;
    }

    public boolean h1(@NonNull CaptureRequest$Builder captureRequest$Builder, @NonNull b.o.a.m.f fVar) {
        if (this.p.c(this.w)) {
            int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i : iArr) {
                arrayList.add(Integer.valueOf(i));
            }
            b.o.a.n.q.b bVar = this.k0;
            b.o.a.m.f fVar2 = this.w;
            Objects.requireNonNull(bVar);
            ArrayList<Pair> arrayList2 = new ArrayList();
            int iOrdinal = fVar2.ordinal();
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
                    b.o.a.b bVar2 = i.j;
                    bVar2.a(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    bVar2.a(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    captureRequest$Builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    captureRequest$Builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.w = fVar;
        return false;
    }

    public boolean i1(@NonNull CaptureRequest$Builder captureRequest$Builder, @NonNull b.o.a.m.h hVar) {
        if (!this.p.c(this.A)) {
            this.A = hVar;
            return false;
        }
        b.o.a.n.q.b bVar = this.k0;
        b.o.a.m.h hVar2 = this.A;
        Objects.requireNonNull(bVar);
        captureRequest$Builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(b.o.a.n.q.b.d.get(hVar2).intValue()));
        return true;
    }

    public boolean j1(@NonNull CaptureRequest$Builder captureRequest$Builder, float f) {
        Range<Integer>[] rangeArr = (Range[]) t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new e(this, this.J && this.I != 0.0f));
        float f2 = this.I;
        if (f2 == 0.0f) {
            for (Range range : (ArrayList) r1(rangeArr)) {
                if (range.contains(30) || range.contains(24)) {
                    captureRequest$Builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f2, this.p.q);
            this.I = fMin;
            this.I = Math.max(fMin, this.p.p);
            for (Range range2 : (ArrayList) r1(rangeArr)) {
                if (range2.contains(Integer.valueOf(Math.round(this.I)))) {
                    captureRequest$Builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.I = f;
        return false;
    }

    @Override // b.o.a.n.i
    public void k0(boolean z2) {
        this.n.b("has frame processors (" + z2 + ")", true, new d$j(this, z2));
    }

    public void k1() {
        l1(true, 3);
    }

    @Override // b.o.a.n.i
    public void l0(@NonNull b.o.a.m.h hVar) {
        b.o.a.m.h hVar2 = this.A;
        this.A = hVar;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("hdr (" + hVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$d(this, hVar2)));
    }

    public final void l1(boolean z2, int i) {
        if ((this.n.f != b.o.a.n.v.e.PREVIEW || O()) && z2) {
            return;
        }
        try {
            this.f1920h0.setRepeatingRequest(this.f1921i0.build(), this.r0, null);
        } catch (CameraAccessException e) {
            throw new CameraException(e, i);
        } catch (IllegalStateException e2) {
            b.o.a.b bVar = i.j;
            b.o.a.n.v.f fVar = this.n;
            bVar.a(3, "applyRepeatingRequestBuilder: session is invalid!", e2, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", fVar.f, "targetState:", fVar.g);
            throw new CameraException(3);
        }
    }

    @Override // b.o.a.n.i
    public void m0(@Nullable Location location) {
        Location location2 = this.C;
        this.C = location;
        b.o.a.n.v.f fVar = this.n;
        fVar.b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$b(this, location2)));
    }

    public boolean m1(@NonNull CaptureRequest$Builder captureRequest$Builder, @NonNull b.o.a.m.m mVar) {
        if (!this.p.c(this.f1932x)) {
            this.f1932x = mVar;
            return false;
        }
        b.o.a.n.q.b bVar = this.k0;
        b.o.a.m.m mVar2 = this.f1932x;
        Objects.requireNonNull(bVar);
        captureRequest$Builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(b.o.a.n.q.b.c.get(mVar2).intValue()));
        return true;
    }

    public boolean n1(@NonNull CaptureRequest$Builder captureRequest$Builder, float f) {
        if (!this.p.k) {
            this.D = f;
            return false;
        }
        float fFloatValue = ((Float) t1(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f2 = fFloatValue - 1.0f;
        float f3 = (this.D * f2) + 1.0f;
        Rect rect = (Rect) t1(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
        int iWidth = (int) (rect.width() / fFloatValue);
        int iHeight = (int) (rect.height() / fFloatValue);
        int iWidth2 = rect.width() - iWidth;
        int iHeight2 = rect.height() - iHeight;
        float f4 = f3 - 1.0f;
        int i = (int) (((iWidth2 * f4) / f2) / 2.0f);
        int i2 = (int) (((iHeight2 * f4) / f2) / 2.0f);
        captureRequest$Builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i, i2, rect.width() - i, rect.height() - i2));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    @NonNull
    public final CameraException o1(@NonNull CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i = 3;
        if (reason == 1) {
            i = 1;
        } else if (reason != 2 && reason != 3) {
            if (reason == 4 || reason == 5) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return new CameraException(cameraAccessException, i);
    }

    @Override // android.media.ImageReader$OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader) {
        i.j.a(0, "onImageAvailable:", "trying to acquire Image.");
        Image imageAcquireLatestImage = null;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (Exception unused) {
        }
        if (imageAcquireLatestImage == null) {
            i.j.a(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.n.f != b.o.a.n.v.e.PREVIEW || O()) {
            i.j.a(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            imageAcquireLatestImage.close();
            return;
        }
        b.o.a.p.b bVarA = S0().a(imageAcquireLatestImage, System.currentTimeMillis());
        if (bVarA == null) {
            i.j.a(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            i.j.a(0, "onImageAvailable:", "Image acquired, dispatching.");
            ((CameraView$b) this.m).b(bVarA);
        }
    }

    @Override // b.o.a.n.i
    public void p0(@NonNull b.o.a.m.j jVar) {
        if (jVar != this.B) {
            this.B = jVar;
            b.o.a.n.v.f fVar = this.n;
            fVar.b("picture format (" + jVar + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$h(this)));
        }
    }

    @NonNull
    public final b.o.a.n.r.g p1(@Nullable b.o.a.t.b bVar) {
        b.o.a.n.r.g gVar = this.q0;
        if (gVar != null) {
            gVar.a(this);
        }
        CaptureRequest$Builder captureRequest$Builder = this.f1921i0;
        int[] iArr = (int[]) t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        if (arrayList.contains(1)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.Q == b.o.a.m.i.VIDEO && arrayList.contains(3)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            captureRequest$Builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        b.o.a.n.r.g gVar2 = new b.o.a.n.r.g(this, bVar, bVar == null);
        this.q0 = gVar2;
        return gVar2;
    }

    @NonNull
    public final CaptureRequest$Builder q1(int i) throws CameraAccessException {
        CaptureRequest$Builder captureRequest$Builder = this.f1921i0;
        CaptureRequest$Builder captureRequest$BuilderCreateCaptureRequest = this.f1918f0.createCaptureRequest(i);
        this.f1921i0 = captureRequest$BuilderCreateCaptureRequest;
        captureRequest$BuilderCreateCaptureRequest.setTag(Integer.valueOf(i));
        d1(this.f1921i0, captureRequest$Builder);
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
                b.o.a.b bVar = b.o.a.r.b.a;
                String str = Build.MODEL;
                boolean z2 = true;
                String str2 = Build.MANUFACTURER;
                bVar.a(1, "Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
                List<Range<Integer>> list = b.o.a.r.b.f1949b.get(str2 + " " + str);
                if (list != null && list.contains(range)) {
                    bVar.a(1, "Dropping range:", range);
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
    public List<b.o.a.x.b> s1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f1916d0.getCameraCharacteristics(this.f1917e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.u);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                b.o.a.x.b bVar = new b.o.a.x.b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        } catch (CameraAccessException e) {
            throw o1(e);
        }
    }

    @Override // b.o.a.n.i
    public void t0(boolean z2) {
        this.F = z2;
        b.i.a.f.e.o.f.Z(null);
    }

    @NonNull
    @VisibleForTesting
    public <T> T t1(@NonNull CameraCharacteristics$Key<T> cameraCharacteristics$Key, @NonNull T t) {
        T t2 = (T) this.f1919g0.get(cameraCharacteristics$Key);
        return t2 == null ? t : t2;
    }

    @NonNull
    public final <T> T u1(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics$Key<T> cameraCharacteristics$Key, @NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(cameraCharacteristics$Key);
        return t2 == null ? t : t2;
    }

    @Override // b.o.a.n.i
    public void v0(float f) {
        float f2 = this.I;
        this.I = f;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("preview fps (" + f + ")", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new d$g(this, f2)));
    }
}
