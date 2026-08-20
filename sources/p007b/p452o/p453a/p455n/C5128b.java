package p007b.p452o.p453a.p455n;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.p458q.C5156a;
import p007b.p452o.p453a.p455n.p460s.C5168a;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p462u.C5172a;
import p007b.p452o.p453a.p455n.p463v.C5179f;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p455n.p463v.RunnableC5181h;
import p007b.p452o.p453a.p455n.p463v.RunnableC5182i;
import p007b.p452o.p453a.p465p.AbstractC5190c;
import p007b.p452o.p453a.p465p.C5188a;
import p007b.p452o.p453a.p465p.C5189b;
import p007b.p452o.p453a.p466q.EnumC5193a;
import p007b.p452o.p453a.p469t.C5211b;
import p007b.p452o.p453a.p471v.C5216a;
import p007b.p452o.p453a.p471v.C5220e;
import p007b.p452o.p453a.p471v.C5222g;
import p007b.p452o.p453a.p472w.InterfaceC5229e;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.n.b */
/* JADX INFO: compiled from: Camera1Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5128b extends AbstractC5133g implements Camera.PreviewCallback, Camera.ErrorCallback, C5188a.a {

    /* JADX INFO: renamed from: d0 */
    public final C5156a f13771d0;

    /* JADX INFO: renamed from: e0 */
    public Camera f13772e0;

    /* JADX INFO: renamed from: f0 */
    @VisibleForTesting
    public int f13773f0;

    /* JADX INFO: renamed from: b.o.a.n.b$a */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C5211b f13774j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ EnumC5193a f13775k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ PointF f13776l;

        /* JADX INFO: renamed from: b.o.a.n.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Camera1Engine.java */
        public class RunnableC13242a implements Runnable {
            public RunnableC13242a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                ((CameraView.C11195b) C5128b.this.f13921m).m9314d(aVar.f13775k, false, aVar.f13776l);
            }
        }

        /* JADX INFO: renamed from: b.o.a.n.b$a$b */
        /* JADX INFO: compiled from: Camera1Engine.java */
        public class b implements Camera.AutoFocusCallback {

            /* JADX INFO: renamed from: b.o.a.n.b$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Camera1Engine.java */
            public class RunnableC13243a implements Runnable {
                public RunnableC13243a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C5128b.this.f13772e0.cancelAutoFocus();
                    Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
                    int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                    int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                    if (maxNumFocusAreas > 0) {
                        parameters.setFocusAreas(null);
                    }
                    if (maxNumMeteringAreas > 0) {
                        parameters.setMeteringAreas(null);
                    }
                    C5128b.this.m7206c1(parameters);
                    C5128b.this.f13772e0.setParameters(parameters);
                }
            }

            public b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z2, Camera camera) {
                C5128b.this.f13922n.m7366e("focus end", 0);
                C5128b.this.f13922n.m7366e("focus reset", 0);
                a aVar = a.this;
                ((CameraView.C11195b) C5128b.this.f13921m).m9314d(aVar.f13775k, z2, aVar.f13776l);
                if (C5128b.this.m7278a1()) {
                    C5128b c5128b = C5128b.this;
                    C5179f c5179f = c5128b.f13922n;
                    c5179f.m7364c("focus reset", true, c5128b.f13888W, new RunnableC5182i(c5179f, EnumC5178e.ENGINE, new RunnableC13243a()));
                }
            }
        }

        public a(C5211b c5211b, EnumC5193a enumC5193a, PointF pointF) {
            this.f13774j = c5211b;
            this.f13775k = enumC5193a;
            this.f13776l = pointF;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C5128b.this.f13896p.f13696o) {
                C5128b c5128b = C5128b.this;
                C5168a c5168a = new C5168a(c5128b.f13877L, c5128b.f13895o.m7432l());
                C5211b c5211bM7411c = this.f13774j.m7411c(c5168a);
                Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
                int maxNumFocusAreas = parameters.getMaxNumFocusAreas();
                int maxNumMeteringAreas = parameters.getMaxNumMeteringAreas();
                if (maxNumFocusAreas > 0) {
                    parameters.setFocusAreas(c5211bM7411c.m7410b(maxNumFocusAreas, c5168a));
                }
                if (maxNumMeteringAreas > 0) {
                    parameters.setMeteringAreas(c5211bM7411c.m7410b(maxNumMeteringAreas, c5168a));
                }
                parameters.setFocusMode("auto");
                C5128b.this.f13772e0.setParameters(parameters);
                ((CameraView.C11195b) C5128b.this.f13921m).m9315e(this.f13775k, this.f13776l);
                C5128b.this.f13922n.m7366e("focus end", 0);
                C5128b.this.f13922n.m7364c("focus end", true, 2500L, new RunnableC13242a());
                try {
                    C5128b.this.f13772e0.autoFocus(new b());
                } catch (RuntimeException e) {
                    AbstractC5135i.f13918j.m7159a(3, "startAutoFocus:", "Error calling autoFocus", e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$b */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5119f f13781j;

        public b(EnumC5119f enumC5119f) {
            this.f13781j = enumC5119f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7209e1(parameters, this.f13781j)) {
                C5128b.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$c */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Location f13783j;

        public c(Location location) {
            this.f13783j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            C5128b.this.m7213g1(parameters);
            C5128b.this.f13772e0.setParameters(parameters);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$d */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5126m f13785j;

        public d(EnumC5126m enumC5126m) {
            this.f13785j = enumC5126m;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7216j1(parameters, this.f13785j)) {
                C5128b.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$e */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5121h f13787j;

        public e(EnumC5121h enumC5121h) {
            this.f13787j = enumC5121h;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7211f1(parameters, this.f13787j)) {
                C5128b.this.f13772e0.setParameters(parameters);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$f */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13789j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13790k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ PointF[] f13791l;

        public f(float f, boolean z2, PointF[] pointFArr) {
            this.f13789j = f;
            this.f13790k = z2;
            this.f13791l = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7218k1(parameters, this.f13789j)) {
                C5128b.this.f13772e0.setParameters(parameters);
                if (this.f13790k) {
                    C5128b c5128b = C5128b.this;
                    ((CameraView.C11195b) c5128b.f13921m).m9316f(c5128b.f13869D, this.f13791l);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$g */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13793j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13794k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ float[] f13795l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ PointF[] f13796m;

        public g(float f, boolean z2, float[] fArr, PointF[] pointFArr) {
            this.f13793j = f;
            this.f13794k = z2;
            this.f13795l = fArr;
            this.f13796m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7208d1(parameters, this.f13793j)) {
                C5128b.this.f13772e0.setParameters(parameters);
                if (this.f13794k) {
                    C5128b c5128b = C5128b.this;
                    ((CameraView.C11195b) c5128b.f13921m).m9313c(c5128b.f13870E, this.f13795l, this.f13796m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$h */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class h implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ boolean f13798j;

        public h(boolean z2) {
            this.f13798j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5128b.this.m7214h1(this.f13798j);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.b$i */
    /* JADX INFO: compiled from: Camera1Engine.java */
    public class i implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13800j;

        public i(float f) {
            this.f13800j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            Camera.Parameters parameters = C5128b.this.f13772e0.getParameters();
            if (C5128b.this.m7215i1(parameters, this.f13800j)) {
                C5128b.this.f13772e0.setParameters(parameters);
            }
        }
    }

    public C5128b(@NonNull AbstractC5135i.g gVar) {
        super(gVar);
        this.f13771d0 = C5156a.m7346a();
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: F0 */
    public void mo7190F0(@NonNull EnumC5126m enumC5126m) {
        EnumC5126m enumC5126m2 = this.f13904x;
        this.f13904x = enumC5126m;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("white balance (" + enumC5126m + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new d(enumC5126m2)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: G0 */
    public void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13869D;
        this.f13869D = f2;
        this.f13922n.m7366e("zoom", 20);
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("zoom", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new f(f3, z2, pointFArr)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: I0 */
    public void mo7192I0(@Nullable EnumC5193a enumC5193a, @NonNull C5211b c5211b, @NonNull PointF pointF) {
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("auto focus", true, new RunnableC5181h(c5179f, EnumC5178e.BIND, new a(c5211b, enumC5193a, pointF)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: P */
    public Task<Void> mo7193P() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStartBind:", "Started");
        try {
            if (this.f13895o.mo7430j() == SurfaceHolder.class) {
                this.f13772e0.setPreviewDisplay((SurfaceHolder) this.f13895o.mo7429i());
            } else {
                if (this.f13895o.mo7430j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f13772e0.setPreviewTexture((SurfaceTexture) this.f13895o.mo7429i());
            }
            this.f13898r = m7271Q0(this.f13882Q);
            this.f13899s = m7272R0();
            c5103b.m7159a(1, "onStartBind:", "Returning");
            return C3404f.m4264Z(null);
        } catch (IOException e2) {
            AbstractC5135i.f13918j.m7159a(3, "onStartBind:", "Failed to bind.", e2);
            throw new CameraException(e2, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: Q */
    public Task<AbstractC5104c> mo7194Q() {
        try {
            Camera cameraOpen = Camera.open(this.f13773f0);
            this.f13772e0 = cameraOpen;
            if (cameraOpen == null) {
                AbstractC5135i.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            cameraOpen.setErrorCallback(this);
            C5103b c5103b = AbstractC5135i.f13918j;
            c5103b.m7159a(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera.Parameters parameters = this.f13772e0.getParameters();
                int i2 = this.f13773f0;
                C5170a c5170a = this.f13877L;
                EnumC5171b enumC5171b = EnumC5171b.SENSOR;
                EnumC5171b enumC5171b2 = EnumC5171b.VIEW;
                this.f13896p = new C5172a(parameters, i2, c5170a.m7357b(enumC5171b, enumC5171b2));
                m7204b1(parameters);
                this.f13772e0.setParameters(parameters);
                try {
                    this.f13772e0.setDisplayOrientation(this.f13877L.m7358c(enumC5171b, enumC5171b2, 1));
                    c5103b.m7159a(1, "onStartEngine:", "Ended");
                    return C3404f.m4264Z(this.f13896p);
                } catch (Exception unused) {
                    AbstractC5135i.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e2) {
                AbstractC5135i.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e2, 1);
            }
        } catch (Exception e3) {
            AbstractC5135i.f13918j.m7159a(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e3, 1);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: R */
    public Task<Void> mo7195R() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.C11195b) this.f13921m).m9318h();
        C5236b c5236bMo7254C = mo7254C(EnumC5171b.VIEW);
        if (c5236bMo7254C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.f13895o.m7439s(c5236bMo7254C.f14251j, c5236bMo7254C.f14252k);
        this.f13895o.mo7438r(0);
        try {
            Camera.Parameters parameters = this.f13772e0.getParameters();
            parameters.setPreviewFormat(17);
            C5236b c5236b = this.f13899s;
            parameters.setPreviewSize(c5236b.f14251j, c5236b.f14252k);
            EnumC5122i enumC5122i = this.f13882Q;
            EnumC5122i enumC5122i2 = EnumC5122i.PICTURE;
            if (enumC5122i == enumC5122i2) {
                C5236b c5236b2 = this.f13898r;
                parameters.setPictureSize(c5236b2.f14251j, c5236b2.f14252k);
            } else {
                C5236b c5236bM7271Q0 = m7271Q0(enumC5122i2);
                parameters.setPictureSize(c5236bM7271Q0.f14251j, c5236bM7271Q0.f14252k);
            }
            try {
                this.f13772e0.setParameters(parameters);
                this.f13772e0.setPreviewCallbackWithBuffer(null);
                this.f13772e0.setPreviewCallbackWithBuffer(this);
                m7220l1().mo7382e(17, this.f13899s, this.f13877L);
                c5103b.m7159a(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.f13772e0.startPreview();
                    c5103b.m7159a(1, "onStartPreview", "Started preview.");
                    return C3404f.m4264Z(null);
                } catch (Exception e2) {
                    AbstractC5135i.f13918j.m7159a(3, "onStartPreview", "Failed to start preview.", e2);
                    throw new CameraException(e2, 2);
                }
            } catch (Exception e3) {
                AbstractC5135i.f13918j.m7159a(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e3, 2);
            }
        } catch (Exception e4) {
            AbstractC5135i.f13918j.m7159a(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e4, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: S */
    public Task<Void> mo7196S() {
        this.f13899s = null;
        this.f13898r = null;
        try {
            if (this.f13895o.mo7430j() == SurfaceHolder.class) {
                this.f13772e0.setPreviewDisplay(null);
            } else {
                if (this.f13895o.mo7430j() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.f13772e0.setPreviewTexture(null);
            }
        } catch (IOException e2) {
            AbstractC5135i.f13918j.m7159a(3, "onStopBind", "Could not release surface", e2);
        }
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: T */
    public Task<Void> mo7197T() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStopEngine:", "About to clean up.");
        this.f13922n.m7366e("focus reset", 0);
        this.f13922n.m7366e("focus end", 0);
        if (this.f13772e0 != null) {
            try {
                c5103b.m7159a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.f13772e0.release();
                c5103b.m7159a(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e2) {
                AbstractC5135i.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
            }
            this.f13772e0 = null;
            this.f13896p = null;
        }
        this.f13896p = null;
        this.f13772e0 = null;
        AbstractC5135i.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    @NonNull
    /* JADX INFO: renamed from: T0 */
    public List<C5236b> mo7198T0() {
        try {
            List<Camera.Size> supportedPreviewSizes = this.f13772e0.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                C5236b c5236b = new C5236b(size.width, size.height);
                if (!arrayList.contains(c5236b)) {
                    arrayList.add(c5236b);
                }
            }
            AbstractC5135i.f13918j.m7159a(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e2) {
            AbstractC5135i.f13918j.m7159a(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e2, 2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: U */
    public Task<Void> mo7199U() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStopPreview:", "Started.");
        this.f13897q = null;
        m7220l1().mo7381d();
        c5103b.m7159a(1, "onStopPreview:", "Releasing preview buffers.");
        this.f13772e0.setPreviewCallbackWithBuffer(null);
        try {
            c5103b.m7159a(1, "onStopPreview:", "Stopping preview.");
            this.f13772e0.stopPreview();
            c5103b.m7159a(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e2) {
            AbstractC5135i.f13918j.m7159a(3, "stopPreview", "Could not stop preview", e2);
        }
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    @NonNull
    /* JADX INFO: renamed from: V0 */
    public AbstractC5190c mo7200V0(int i2) {
        return new C5188a(i2, this);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: X0 */
    public void mo7201X0() {
        AbstractC5135i.f13918j.m7159a(1, "RESTART PREVIEW:", "scheduled. State:", this.f13922n.f14028f);
        m7323N0(false);
        m7320K0();
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: Y0 */
    public void mo7202Y0(@NonNull C5113l.a aVar, boolean z2) {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onTakePicture:", "executing.");
        C5170a c5170a = this.f13877L;
        EnumC5171b enumC5171b = EnumC5171b.SENSOR;
        EnumC5171b enumC5171b2 = EnumC5171b.OUTPUT;
        aVar.f13717c = c5170a.m7358c(enumC5171b, enumC5171b2, 2);
        aVar.f13718d = mo7309w(enumC5171b2);
        C5216a c5216a = new C5216a(aVar, this, this.f13772e0);
        this.f13897q = c5216a;
        c5216a.mo7417c();
        c5103b.m7159a(1, "onTakePicture:", "executed.");
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: Z0 */
    public void mo7203Z0(@NonNull C5113l.a aVar, @NonNull C5235a c5235a, boolean z2) {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onTakePictureSnapshot:", "executing.");
        EnumC5171b enumC5171b = EnumC5171b.OUTPUT;
        aVar.f13718d = mo7260F(enumC5171b);
        if (this.f13895o instanceof InterfaceC5229e) {
            aVar.f13717c = this.f13877L.m7358c(EnumC5171b.VIEW, enumC5171b, 1);
            this.f13897q = new C5222g(aVar, this, (InterfaceC5229e) this.f13895o, c5235a, this.f13894c0);
        } else {
            aVar.f13717c = this.f13877L.m7358c(EnumC5171b.SENSOR, enumC5171b, 2);
            this.f13897q = new C5220e(aVar, this, this.f13772e0, c5235a);
        }
        this.f13897q.mo7417c();
        c5103b.m7159a(1, "onTakePictureSnapshot:", "executed.");
    }

    /* JADX INFO: renamed from: b1 */
    public final void m7204b1(@NonNull Camera.Parameters parameters) {
        parameters.setRecordingHint(this.f13882Q == EnumC5122i.VIDEO);
        m7206c1(parameters);
        m7209e1(parameters, EnumC5119f.OFF);
        m7213g1(parameters);
        m7216j1(parameters, EnumC5126m.AUTO);
        m7211f1(parameters, EnumC5121h.OFF);
        m7218k1(parameters, 0.0f);
        m7208d1(parameters, 0.0f);
        m7214h1(this.f13871F);
        m7215i1(parameters, 0.0f);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: c */
    public boolean mo7205c(@NonNull EnumC5118e enumC5118e) {
        Objects.requireNonNull(this.f13771d0);
        int iIntValue = C5156a.f13959d.get(enumC5118e).intValue();
        AbstractC5135i.f13918j.m7159a(1, "collectCameraInfo", "Facing:", enumC5118e, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                this.f13877L.m7361f(enumC5118e, cameraInfo.orientation);
                this.f13773f0 = i2;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c1 */
    public final void m7206c1(@NonNull Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.f13882Q == EnumC5122i.VIDEO && supportedFocusModes.contains("continuous-video")) {
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

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: d0 */
    public void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13870E;
        this.f13870E = f2;
        this.f13922n.m7366e("exposure correction", 20);
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("exposure correction", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new g(f3, z2, fArr, pointFArr)));
    }

    /* JADX INFO: renamed from: d1 */
    public final boolean m7208d1(@NonNull Camera.Parameters parameters, float f2) {
        AbstractC5104c abstractC5104c = this.f13896p;
        if (!abstractC5104c.f13693l) {
            this.f13870E = f2;
            return false;
        }
        float f3 = abstractC5104c.f13695n;
        float f4 = abstractC5104c.f13694m;
        float f5 = this.f13870E;
        if (f5 < f4) {
            f3 = f4;
        } else if (f5 <= f3) {
            f3 = f5;
        }
        this.f13870E = f3;
        parameters.setExposureCompensation((int) (f3 / parameters.getExposureCompensationStep()));
        return true;
    }

    /* JADX INFO: renamed from: e1 */
    public final boolean m7209e1(@NonNull Camera.Parameters parameters, @NonNull EnumC5119f enumC5119f) {
        if (!this.f13896p.m7163c(this.f13903w)) {
            this.f13903w = enumC5119f;
            return false;
        }
        C5156a c5156a = this.f13771d0;
        EnumC5119f enumC5119f2 = this.f13903w;
        Objects.requireNonNull(c5156a);
        parameters.setFlashMode(C5156a.f13957b.get(enumC5119f2));
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: f0 */
    public void mo7210f0(@NonNull EnumC5119f enumC5119f) {
        EnumC5119f enumC5119f2 = this.f13903w;
        this.f13903w = enumC5119f;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("flash (" + enumC5119f + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new b(enumC5119f2)));
    }

    /* JADX INFO: renamed from: f1 */
    public final boolean m7211f1(@NonNull Camera.Parameters parameters, @NonNull EnumC5121h enumC5121h) {
        if (!this.f13896p.m7163c(this.f13866A)) {
            this.f13866A = enumC5121h;
            return false;
        }
        C5156a c5156a = this.f13771d0;
        EnumC5121h enumC5121h2 = this.f13866A;
        Objects.requireNonNull(c5156a);
        parameters.setSceneMode(C5156a.f13960e.get(enumC5121h2));
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: g0 */
    public void mo7212g0(int i2) {
        this.f13901u = 17;
    }

    /* JADX INFO: renamed from: g1 */
    public final boolean m7213g1(@NonNull Camera.Parameters parameters) {
        Location location = this.f13868C;
        if (location == null) {
            return true;
        }
        parameters.setGpsLatitude(location.getLatitude());
        parameters.setGpsLongitude(this.f13868C.getLongitude());
        parameters.setGpsAltitude(this.f13868C.getAltitude());
        parameters.setGpsTimestamp(this.f13868C.getTime());
        parameters.setGpsProcessingMethod(this.f13868C.getProvider());
        return true;
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: h1 */
    public final boolean m7214h1(boolean z2) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.f13773f0, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.f13772e0.enableShutterSound(this.f13871F);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        if (this.f13871F) {
            return true;
        }
        this.f13871F = z2;
        return false;
    }

    /* JADX INFO: renamed from: i1 */
    public final boolean m7215i1(@NonNull Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!this.f13875J || this.f13874I == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new C5127a(this));
        } else {
            Collections.sort(supportedPreviewFpsRange, new C5129c(this));
        }
        float f3 = this.f13874I;
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
            float fMin = Math.min(f3, this.f13896p.f13698q);
            this.f13874I = fMin;
            this.f13874I = Math.max(fMin, this.f13896p.f13697p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f6 = iArr2[0] / 1000.0f;
                float f7 = iArr2[1] / 1000.0f;
                float fRound = Math.round(this.f13874I);
                if (f6 <= fRound && fRound <= f7) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.f13874I = f2;
        return false;
    }

    /* JADX INFO: renamed from: j1 */
    public final boolean m7216j1(@NonNull Camera.Parameters parameters, @NonNull EnumC5126m enumC5126m) {
        if (!this.f13896p.m7163c(this.f13904x)) {
            this.f13904x = enumC5126m;
            return false;
        }
        C5156a c5156a = this.f13771d0;
        EnumC5126m enumC5126m2 = this.f13904x;
        Objects.requireNonNull(c5156a);
        parameters.setWhiteBalance(C5156a.f13958c.get(enumC5126m2));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: k0 */
    public void mo7217k0(boolean z2) {
        this.f13902v = z2;
    }

    /* JADX INFO: renamed from: k1 */
    public final boolean m7218k1(@NonNull Camera.Parameters parameters, float f2) {
        if (!this.f13896p.f13692k) {
            this.f13869D = f2;
            return false;
        }
        parameters.setZoom((int) (this.f13869D * parameters.getMaxZoom()));
        this.f13772e0.setParameters(parameters);
        return true;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: l0 */
    public void mo7219l0(@NonNull EnumC5121h enumC5121h) {
        EnumC5121h enumC5121h2 = this.f13866A;
        this.f13866A = enumC5121h;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("hdr (" + enumC5121h + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new e(enumC5121h2)));
    }

    @NonNull
    /* JADX INFO: renamed from: l1 */
    public C5188a m7220l1() {
        return (C5188a) m7273S0();
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: m0 */
    public void mo7221m0(@Nullable Location location) {
        Location location2 = this.f13868C;
        this.f13868C = location;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new c(location2)));
    }

    /* JADX INFO: renamed from: m1 */
    public void m7222m1(@NonNull byte[] bArr) {
        EnumC5178e enumC5178e = this.f13922n.f14028f;
        EnumC5178e enumC5178e2 = EnumC5178e.ENGINE;
        if (enumC5178e.m7367f(enumC5178e2) && this.f13922n.f14029g.m7367f(enumC5178e2)) {
            this.f13772e0.addCallbackBuffer(bArr);
        }
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i2, Camera camera) {
        throw new CameraException(new RuntimeException(AbstractC5135i.f13918j.m7159a(3, "Internal Camera1 error.", Integer.valueOf(i2))), (i2 == 1 || i2 == 2 || i2 == 100) ? 3 : 0);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        C5189b c5189bM7385a;
        if (bArr == null || (c5189bM7385a = m7220l1().m7385a(bArr, System.currentTimeMillis())) == null) {
            return;
        }
        ((CameraView.C11195b) this.f13921m).m9312b(c5189bM7385a);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: p0 */
    public void mo7223p0(@NonNull EnumC5123j enumC5123j) {
        if (enumC5123j == EnumC5123j.JPEG) {
            this.f13867B = enumC5123j;
            return;
        }
        throw new UnsupportedOperationException("Unsupported picture format: " + enumC5123j);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: t0 */
    public void mo7224t0(boolean z2) {
        boolean z3 = this.f13871F;
        this.f13871F = z2;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("play sounds (" + z2 + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new h(z3)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: v0 */
    public void mo7225v0(float f2) {
        this.f13874I = f2;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("preview fps (" + f2 + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new i(f2)));
    }
}
