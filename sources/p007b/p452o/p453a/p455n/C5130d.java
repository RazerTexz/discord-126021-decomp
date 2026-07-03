package p007b.p452o.p453a.p455n;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4363g;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.AbstractC5135i;
import p007b.p452o.p453a.p455n.p456o.AbstractC5145e;
import p007b.p452o.p453a.p455n.p456o.AbstractC5146f;
import p007b.p452o.p453a.p455n.p456o.C5147g;
import p007b.p452o.p453a.p455n.p456o.C5148h;
import p007b.p452o.p453a.p455n.p456o.C5149i;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5141a;
import p007b.p452o.p453a.p455n.p456o.InterfaceC5143c;
import p007b.p452o.p453a.p455n.p458q.C5157b;
import p007b.p452o.p453a.p455n.p459r.AbstractC5158a;
import p007b.p452o.p453a.p455n.p459r.C5164g;
import p007b.p452o.p453a.p455n.p459r.C5165h;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p462u.C5173b;
import p007b.p452o.p453a.p455n.p463v.C5179f;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p455n.p463v.RunnableC5181h;
import p007b.p452o.p453a.p455n.p463v.RunnableC5182i;
import p007b.p452o.p453a.p465p.AbstractC5190c;
import p007b.p452o.p453a.p465p.C5189b;
import p007b.p452o.p453a.p465p.C5192e;
import p007b.p452o.p453a.p466q.EnumC5193a;
import p007b.p452o.p453a.p467r.C5201b;
import p007b.p452o.p453a.p469t.C5211b;
import p007b.p452o.p453a.p471v.C5217b;
import p007b.p452o.p453a.p471v.C5221f;
import p007b.p452o.p453a.p472w.InterfaceC5229e;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p453a.p473x.C5238d;
import p007b.p452o.p453a.p473x.C5239e;
import p007b.p452o.p453a.p473x.C5240f;
import p007b.p452o.p453a.p473x.C5246l;
import p007b.p452o.p453a.p473x.InterfaceC5237c;

/* JADX INFO: renamed from: b.o.a.n.d */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5130d extends AbstractC5133g implements ImageReader.OnImageAvailableListener, InterfaceC5143c {

    /* JADX INFO: renamed from: d0 */
    public final CameraManager f13802d0;

    /* JADX INFO: renamed from: e0 */
    public String f13803e0;

    /* JADX INFO: renamed from: f0 */
    public CameraDevice f13804f0;

    /* JADX INFO: renamed from: g0 */
    public CameraCharacteristics f13805g0;

    /* JADX INFO: renamed from: h0 */
    public CameraCaptureSession f13806h0;

    /* JADX INFO: renamed from: i0 */
    public CaptureRequest.Builder f13807i0;

    /* JADX INFO: renamed from: j0 */
    public TotalCaptureResult f13808j0;

    /* JADX INFO: renamed from: k0 */
    public final C5157b f13809k0;

    /* JADX INFO: renamed from: l0 */
    public ImageReader f13810l0;

    /* JADX INFO: renamed from: m0 */
    public Surface f13811m0;

    /* JADX INFO: renamed from: n0 */
    public Surface f13812n0;

    /* JADX INFO: renamed from: o0 */
    public ImageReader f13813o0;

    /* JADX INFO: renamed from: p0 */
    public final List<InterfaceC5141a> f13814p0;

    /* JADX INFO: renamed from: q0 */
    public C5164g f13815q0;

    /* JADX INFO: renamed from: r0 */
    public final CameraCaptureSession.CaptureCallback f13816r0;

    /* JADX INFO: renamed from: b.o.a.n.d$a */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5119f f13817j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ EnumC5119f f13818k;

        public a(EnumC5119f enumC5119f, EnumC5119f enumC5119f2) {
            this.f13817j = enumC5119f;
            this.f13818k = enumC5119f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            boolean zM7233h1 = c5130d.m7233h1(c5130d.f13807i0, this.f13817j);
            C5130d c5130d2 = C5130d.this;
            if (!(c5130d2.f13922n.f14028f == EnumC5178e.PREVIEW)) {
                if (zM7233h1) {
                    c5130d2.m7236k1();
                    return;
                }
                return;
            }
            c5130d2.f13903w = EnumC5119f.OFF;
            c5130d2.m7233h1(c5130d2.f13807i0, this.f13817j);
            try {
                C5130d c5130d3 = C5130d.this;
                c5130d3.f13806h0.capture(c5130d3.f13807i0.build(), null, null);
                C5130d c5130d4 = C5130d.this;
                c5130d4.f13903w = this.f13818k;
                c5130d4.m7233h1(c5130d4.f13807i0, this.f13817j);
                C5130d.this.m7236k1();
            } catch (CameraAccessException e) {
                throw C5130d.this.m7240o1(e);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$b */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Location f13820j;

        public b(Location location) {
            this.f13820j = location;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            CaptureRequest.Builder builder = c5130d.f13807i0;
            Location location = c5130d.f13868C;
            if (location != null) {
                builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
            }
            C5130d.this.m7236k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$c */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5126m f13822j;

        public c(EnumC5126m enumC5126m) {
            this.f13822j = enumC5126m;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.m7238m1(c5130d.f13807i0, this.f13822j)) {
                C5130d.this.m7236k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$d */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5121h f13824j;

        public d(EnumC5121h enumC5121h) {
            this.f13824j = enumC5121h;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.m7234i1(c5130d.f13807i0, this.f13824j)) {
                C5130d.this.m7236k1();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$e */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class e implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13826j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13827k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ float f13828l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ PointF[] f13829m;

        public e(float f, boolean z2, float f2, PointF[] pointFArr) {
            this.f13826j = f;
            this.f13827k = z2;
            this.f13828l = f2;
            this.f13829m = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.m7239n1(c5130d.f13807i0, this.f13826j)) {
                C5130d.this.m7236k1();
                if (this.f13827k) {
                    ((CameraView.C11195b) C5130d.this.f13921m).m9316f(this.f13828l, this.f13829m);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$f */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class f implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13831j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13832k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ float f13833l;

        /* JADX INFO: renamed from: m */
        public final /* synthetic */ float[] f13834m;

        /* JADX INFO: renamed from: n */
        public final /* synthetic */ PointF[] f13835n;

        public f(float f, boolean z2, float f2, float[] fArr, PointF[] pointFArr) {
            this.f13831j = f;
            this.f13832k = z2;
            this.f13833l = f2;
            this.f13834m = fArr;
            this.f13835n = pointFArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.m7232g1(c5130d.f13807i0, this.f13831j)) {
                C5130d.this.m7236k1();
                if (this.f13832k) {
                    ((CameraView.C11195b) C5130d.this.f13921m).m9313c(this.f13833l, this.f13834m, this.f13835n);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$g */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class g implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ float f13837j;

        public g(float f) {
            this.f13837j = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.m7235j1(c5130d.f13807i0, this.f13837j)) {
                C5130d.this.m7236k1();
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
            C5130d.this.m7327X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$i */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class i extends CameraCaptureSession.CaptureCallback {
        public i() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            C5130d c5130d = C5130d.this;
            c5130d.f13808j0 = totalCaptureResult;
            Iterator<InterfaceC5141a> it = c5130d.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7248b(C5130d.this, captureRequest, totalCaptureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
            Iterator<InterfaceC5141a> it = C5130d.this.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7332d(C5130d.this, captureRequest, captureResult);
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(@NonNull CameraCaptureSession cameraCaptureSession, @NonNull CaptureRequest captureRequest, long j, long j2) {
            Iterator<InterfaceC5141a> it = C5130d.this.f13814p0.iterator();
            while (it.hasNext()) {
                it.next().mo7331c(C5130d.this, captureRequest);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$j */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class j implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ boolean f13841j;

        public j(boolean z2) {
            this.f13841j = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            EnumC5178e enumC5178e = C5130d.this.f13922n.f14028f;
            EnumC5178e enumC5178e2 = EnumC5178e.BIND;
            if (enumC5178e.m7367f(enumC5178e2) && C5130d.this.m7324O()) {
                C5130d.this.mo7217k0(this.f13841j);
                return;
            }
            C5130d c5130d = C5130d.this;
            c5130d.f13902v = this.f13841j;
            if (c5130d.f13922n.f14028f.m7367f(enumC5178e2)) {
                C5130d.this.m7328Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$k */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class k implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f13843j;

        public k(int i) {
            this.f13843j = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            EnumC5178e enumC5178e = C5130d.this.f13922n.f14028f;
            EnumC5178e enumC5178e2 = EnumC5178e.BIND;
            if (enumC5178e.m7367f(enumC5178e2) && C5130d.this.m7324O()) {
                C5130d.this.mo7212g0(this.f13843j);
                return;
            }
            C5130d c5130d = C5130d.this;
            int i = this.f13843j;
            if (i <= 0) {
                i = 35;
            }
            c5130d.f13901u = i;
            if (c5130d.f13922n.f14028f.m7367f(enumC5178e2)) {
                C5130d.this.m7328Y();
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$l */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class l implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5193a f13845j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ PointF f13846k;

        /* JADX INFO: renamed from: l */
        public final /* synthetic */ C5211b f13847l;

        /* JADX INFO: renamed from: b.o.a.n.d$l$a */
        /* JADX INFO: compiled from: Camera2Engine.java */
        public class a extends AbstractC5146f {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ C5164g f13849a;

            /* JADX INFO: renamed from: b.o.a.n.d$l$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Camera2Engine.java */
            public class RunnableC13244a implements Runnable {
                public RunnableC13244a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    C5130d.m7226b1(C5130d.this);
                }
            }

            public a(C5164g c5164g) {
                this.f13849a = c5164g;
            }

            @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5146f
            /* JADX INFO: renamed from: b */
            public void mo7247b(@NonNull InterfaceC5141a interfaceC5141a) {
                boolean z2;
                l lVar = l.this;
                AbstractC5135i.g gVar = C5130d.this.f13921m;
                EnumC5193a enumC5193a = lVar.f13845j;
                Iterator<AbstractC5158a> it = this.f13849a.f13977f.iterator();
                while (true) {
                    z2 = true;
                    if (!it.hasNext()) {
                        C5164g.f13976e.m7159a(1, "isSuccessful:", "returning true.");
                        break;
                    } else if (!it.next().f13967g) {
                        C5164g.f13976e.m7159a(1, "isSuccessful:", "returning false.");
                        z2 = false;
                        break;
                    }
                }
                ((CameraView.C11195b) gVar).m9314d(enumC5193a, z2, l.this.f13846k);
                C5130d.this.f13922n.m7366e("reset metering", 0);
                if (C5130d.this.m7278a1()) {
                    C5130d c5130d = C5130d.this;
                    C5179f c5179f = c5130d.f13922n;
                    c5179f.m7364c("reset metering", true, c5130d.f13888W, new RunnableC5182i(c5179f, EnumC5178e.PREVIEW, new RunnableC13244a()));
                }
            }
        }

        public l(EnumC5193a enumC5193a, PointF pointF, C5211b c5211b) {
            this.f13845j = enumC5193a;
            this.f13846k = pointF;
            this.f13847l = c5211b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d c5130d = C5130d.this;
            if (c5130d.f13896p.f13696o) {
                ((CameraView.C11195b) c5130d.f13921m).m9315e(this.f13845j, this.f13846k);
                C5164g c5164gM7241p1 = C5130d.this.m7241p1(this.f13847l);
                C5149i c5149i = new C5149i(5000L, c5164gM7241p1);
                c5149i.mo7333e(C5130d.this);
                c5149i.m7337f(new a(c5164gM7241p1));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$m */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class m extends CameraDevice.StateCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ TaskCompletionSource f13852a;

        public m(TaskCompletionSource taskCompletionSource) {
            this.f13852a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(@NonNull CameraDevice cameraDevice) {
            CameraException cameraException = new CameraException(3);
            if (this.f13852a.f20845a.mo6020o()) {
                AbstractC5135i.f13918j.m7159a(1, "CameraDevice.StateCallback reported disconnection.");
                throw cameraException;
            }
            this.f13852a.m9125a(cameraException);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(@NonNull CameraDevice cameraDevice, int i) {
            int i2 = 1;
            if (this.f13852a.f20845a.mo6020o()) {
                AbstractC5135i.f13918j.m7159a(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i));
                throw new CameraException(3);
            }
            TaskCompletionSource taskCompletionSource = this.f13852a;
            Objects.requireNonNull(C5130d.this);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                i2 = 0;
            }
            taskCompletionSource.m9125a(new CameraException(i2));
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(@NonNull CameraDevice cameraDevice) {
            int i;
            C5130d.this.f13804f0 = cameraDevice;
            try {
                AbstractC5135i.f13918j.m7159a(1, "onStartEngine:", "Opened camera device.");
                C5130d c5130d = C5130d.this;
                c5130d.f13805g0 = c5130d.f13802d0.getCameraCharacteristics(c5130d.f13803e0);
                boolean zM7357b = C5130d.this.f13877L.m7357b(EnumC5171b.SENSOR, EnumC5171b.VIEW);
                int iOrdinal = C5130d.this.f13867B.ordinal();
                if (iOrdinal == 0) {
                    i = 256;
                } else {
                    if (iOrdinal != 1) {
                        throw new IllegalArgumentException("Unknown format:" + C5130d.this.f13867B);
                    }
                    i = 32;
                }
                C5130d c5130d2 = C5130d.this;
                c5130d2.f13896p = new C5173b(c5130d2.f13802d0, c5130d2.f13803e0, zM7357b, i);
                C5130d c5130d3 = C5130d.this;
                Objects.requireNonNull(c5130d3);
                c5130d3.m7242q1(1);
                this.f13852a.m9126b(C5130d.this.f13896p);
            } catch (CameraAccessException e) {
                this.f13852a.m9125a(C5130d.this.m7240o1(e));
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$n */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class n implements Callable<Void> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Object f13854j;

        public n(Object obj) {
            this.f13854j = obj;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            SurfaceHolder surfaceHolder = (SurfaceHolder) this.f13854j;
            C5236b c5236b = C5130d.this.f13899s;
            surfaceHolder.setFixedSize(c5236b.f14251j, c5236b.f14252k);
            return null;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$o */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class o extends CameraCaptureSession.StateCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ TaskCompletionSource f13856a;

        public o(TaskCompletionSource taskCompletionSource) {
            this.f13856a = taskCompletionSource;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
            RuntimeException runtimeException = new RuntimeException(AbstractC5135i.f13918j.m7159a(3, "onConfigureFailed! Session", cameraCaptureSession));
            if (this.f13856a.f20845a.mo6020o()) {
                throw new CameraException(3);
            }
            this.f13856a.m9125a(new CameraException(runtimeException, 2));
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            C5130d.this.f13806h0 = cameraCaptureSession;
            AbstractC5135i.f13918j.m7159a(1, "onStartBind:", "Completed");
            this.f13856a.m9126b(null);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(@NonNull CameraCaptureSession cameraCaptureSession) {
            super.onReady(cameraCaptureSession);
            AbstractC5135i.f13918j.m7159a(1, "CameraCaptureSession.StateCallback reported onReady.");
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$p */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class p extends AbstractC5145e {

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ TaskCompletionSource f13858e;

        public p(C5130d c5130d, TaskCompletionSource taskCompletionSource) {
            this.f13858e = taskCompletionSource;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5145e, p007b.p452o.p453a.p455n.p456o.InterfaceC5141a
        /* JADX INFO: renamed from: b */
        public void mo7248b(@NonNull InterfaceC5143c interfaceC5143c, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            m7341l(Integer.MAX_VALUE);
            this.f13858e.m9126b(null);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$q */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class q extends AbstractC5146f {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C5113l.a f13859a;

        public q(C5113l.a aVar) {
            this.f13859a = aVar;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5146f
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull InterfaceC5141a interfaceC5141a) {
            C5130d c5130d = C5130d.this;
            c5130d.f13873H = false;
            c5130d.mo7270P0(this.f13859a);
            C5130d.this.f13873H = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$r */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class r extends AbstractC5146f {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C5113l.a f13861a;

        public r(C5113l.a aVar) {
            this.f13861a = aVar;
        }

        @Override // p007b.p452o.p453a.p455n.p456o.AbstractC5146f
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull InterfaceC5141a interfaceC5141a) {
            C5130d c5130d = C5130d.this;
            c5130d.f13872G = false;
            c5130d.mo7269O0(this.f13861a);
            C5130d.this.f13872G = true;
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.d$s */
    /* JADX INFO: compiled from: Camera2Engine.java */
    public class s implements Runnable {
        public s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5130d.m7226b1(C5130d.this);
        }
    }

    public C5130d(AbstractC5135i.g gVar) {
        super(gVar);
        if (C5157b.f13961a == null) {
            C5157b.f13961a = new C5157b();
        }
        this.f13809k0 = C5157b.f13961a;
        this.f13814p0 = new CopyOnWriteArrayList();
        this.f13816r0 = new i();
        this.f13802d0 = (CameraManager) ((CameraView.C11195b) this.f13921m).m9317g().getSystemService(ChatInputComponentTypes.CAMERA);
        new C5147g().mo7333e(this);
    }

    /* JADX INFO: renamed from: b1 */
    public static void m7226b1(C5130d c5130d) {
        Objects.requireNonNull(c5130d);
        new C5148h(Arrays.asList(new C5132f(c5130d), new C5165h())).mo7333e(c5130d);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: F0 */
    public void mo7190F0(@NonNull EnumC5126m enumC5126m) {
        EnumC5126m enumC5126m2 = this.f13904x;
        this.f13904x = enumC5126m;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("white balance (" + enumC5126m + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new c(enumC5126m2)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: G0 */
    public void mo7191G0(float f2, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13869D;
        this.f13869D = f2;
        this.f13922n.m7366e("zoom", 20);
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("zoom", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new e(f3, z2, f2, pointFArr)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: I0 */
    public void mo7192I0(@Nullable EnumC5193a enumC5193a, @NonNull C5211b c5211b, @NonNull PointF pointF) {
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("autofocus (" + enumC5193a + ")", true, new RunnableC5181h(c5179f, EnumC5178e.PREVIEW, new l(enumC5193a, pointF, c5211b)));
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
    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: P */
    public Task<Void> mo7193P() {
        Handler handler;
        int i2;
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStartBind:", "Started");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f13898r = m7271Q0(this.f13882Q);
        this.f13899s = m7272R0();
        ArrayList arrayList = new ArrayList();
        Class clsMo7430j = this.f13895o.mo7430j();
        Object objMo7429i = this.f13895o.mo7429i();
        if (clsMo7430j == SurfaceHolder.class) {
            try {
                c5103b.m7159a(1, "onStartBind:", "Waiting on UI thread...");
                C3404f.m4303j(C3404f.m4323o(C4363g.f11479a, new n(objMo7429i)));
                this.f13812n0 = ((SurfaceHolder) objMo7429i).getSurface();
            } catch (InterruptedException | ExecutionException e2) {
                throw new CameraException(e2, 1);
            }
        } else {
            if (clsMo7430j != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) objMo7429i;
            C5236b c5236b = this.f13899s;
            surfaceTexture.setDefaultBufferSize(c5236b.f14251j, c5236b.f14252k);
            this.f13812n0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.f13812n0);
        if (this.f13882Q == EnumC5122i.PICTURE) {
            int iOrdinal = this.f13867B.ordinal();
            if (iOrdinal == 0) {
                i2 = 256;
            } else {
                if (iOrdinal != 1) {
                    StringBuilder sbM833U = C1643a.m833U("Unknown format:");
                    sbM833U.append(this.f13867B);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                i2 = 32;
            }
            C5236b c5236b2 = this.f13898r;
            ImageReader imageReaderNewInstance = ImageReader.newInstance(c5236b2.f14251j, c5236b2.f14252k, i2, 2);
            this.f13813o0 = imageReaderNewInstance;
            arrayList.add(imageReaderNewInstance.getSurface());
        }
        if (this.f13902v) {
            List<C5236b> listM7244s1 = m7244s1();
            boolean zM7357b = this.f13877L.m7357b(EnumC5171b.SENSOR, EnumC5171b.VIEW);
            ArrayList<C5236b> arrayList2 = (ArrayList) listM7244s1;
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            for (C5236b c5236bM7451f : arrayList2) {
                if (zM7357b) {
                    c5236bM7451f = c5236bM7451f.m7451f();
                }
                arrayList3.add(c5236bM7451f);
            }
            C5236b c5236b3 = this.f13899s;
            C5235a c5235aM7447f = C5235a.m7447f(c5236b3.f14251j, c5236b3.f14252k);
            if (zM7357b) {
                c5235aM7447f = C5235a.m7447f(c5235aM7447f.f14250l, c5235aM7447f.f14249k);
            }
            int i3 = this.f13891Z;
            int i4 = this.f13892a0;
            if (i3 <= 0 || i3 == Integer.MAX_VALUE) {
                i3 = 640;
            }
            if (i4 <= 0 || i4 == Integer.MAX_VALUE) {
                i4 = 640;
            }
            C5236b c5236b4 = new C5236b(i3, i4);
            C5103b c5103b2 = AbstractC5135i.f13918j;
            c5103b2.m7159a(1, "computeFrameProcessingSize:", "targetRatio:", c5235aM7447f, "targetMaxSize:", c5236b4);
            InterfaceC5237c interfaceC5237cM4200D1 = C3404f.m4200D1(new C5238d(c5235aM7447f.m7450i(), 0.0f));
            InterfaceC5237c interfaceC5237cM4291g = C3404f.m4291g(C3404f.m4220K0(i4), C3404f.m4223L0(i3), new C5239e());
            C5236b c5236bM7451f2 = ((C5246l) C3404f.m4238Q0(C3404f.m4291g(interfaceC5237cM4200D1, interfaceC5237cM4291g), interfaceC5237cM4291g, new C5240f())).mo7452a(arrayList3).get(0);
            if (!arrayList3.contains(c5236bM7451f2)) {
                throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
            }
            if (zM7357b) {
                c5236bM7451f2 = c5236bM7451f2.m7451f();
            }
            c5103b2.m7159a(1, "computeFrameProcessingSize:", "result:", c5236bM7451f2, "flip:", Boolean.valueOf(zM7357b));
            this.f13900t = c5236bM7451f2;
            ImageReader imageReaderNewInstance2 = ImageReader.newInstance(c5236bM7451f2.f14251j, c5236bM7451f2.f14252k, this.f13901u, this.f13893b0 + 1);
            this.f13810l0 = imageReaderNewInstance2;
            handler = null;
            imageReaderNewInstance2.setOnImageAvailableListener(this, null);
            Surface surface = this.f13810l0.getSurface();
            this.f13811m0 = surface;
            arrayList.add(surface);
        } else {
            handler = null;
            this.f13810l0 = null;
            this.f13900t = null;
            this.f13811m0 = null;
        }
        try {
            this.f13804f0.createCaptureSession(arrayList, new o(taskCompletionSource), handler);
            return taskCompletionSource.f20845a;
        } catch (CameraAccessException e3) {
            throw m7240o1(e3);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: Q */
    public Task<AbstractC5104c> mo7194Q() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            this.f13802d0.openCamera(this.f13803e0, new m(taskCompletionSource), (Handler) null);
            return taskCompletionSource.f20845a;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: R */
    public Task<Void> mo7195R() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        ((CameraView.C11195b) this.f13921m).m9318h();
        EnumC5171b enumC5171b = EnumC5171b.VIEW;
        C5236b c5236bMo7254C = mo7254C(enumC5171b);
        if (c5236bMo7254C == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.f13895o.m7439s(c5236bMo7254C.f14251j, c5236bMo7254C.f14252k);
        this.f13895o.mo7438r(this.f13877L.m7358c(EnumC5171b.BASE, enumC5171b, 1));
        if (this.f13902v) {
            m7273S0().mo7382e(this.f13901u, this.f13900t, this.f13877L);
        }
        c5103b.m7159a(1, "onStartPreview:", "Starting preview.");
        m7228c1(new Surface[0]);
        m7237l1(false, 2);
        c5103b.m7159a(1, "onStartPreview:", "Started preview.");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        new p(this, taskCompletionSource).mo7333e(this);
        return taskCompletionSource.f20845a;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: S */
    public Task<Void> mo7196S() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStopBind:", "About to clean up.");
        this.f13811m0 = null;
        this.f13812n0 = null;
        this.f13899s = null;
        this.f13898r = null;
        this.f13900t = null;
        ImageReader imageReader = this.f13810l0;
        if (imageReader != null) {
            imageReader.close();
            this.f13810l0 = null;
        }
        ImageReader imageReader2 = this.f13813o0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.f13813o0 = null;
        }
        this.f13806h0.close();
        this.f13806h0 = null;
        c5103b.m7159a(1, "onStopBind:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: T */
    public Task<Void> mo7197T() {
        try {
            C5103b c5103b = AbstractC5135i.f13918j;
            c5103b.m7159a(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.f13804f0.close();
            c5103b.m7159a(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e2) {
            AbstractC5135i.f13918j.m7159a(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e2);
        }
        this.f13804f0 = null;
        AbstractC5135i.f13918j.m7159a(1, "onStopEngine:", "Aborting actions.");
        Iterator<InterfaceC5141a> it = this.f13814p0.iterator();
        while (it.hasNext()) {
            it.next().mo7330a(this);
        }
        this.f13805g0 = null;
        this.f13896p = null;
        this.f13807i0 = null;
        AbstractC5135i.f13918j.m7159a(2, "onStopEngine:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    @NonNull
    /* JADX INFO: renamed from: T0 */
    public List<C5236b> mo7198T0() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f13802d0.getCameraCharacteristics(this.f13803e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f13895o.mo7430j());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                C5236b c5236b = new C5236b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(c5236b)) {
                    arrayList.add(c5236b);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: U */
    public Task<Void> mo7199U() {
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "onStopPreview:", "Started.");
        this.f13897q = null;
        if (this.f13902v) {
            m7273S0().mo7381d();
        }
        this.f13807i0.removeTarget(this.f13812n0);
        Surface surface = this.f13811m0;
        if (surface != null) {
            this.f13807i0.removeTarget(surface);
        }
        this.f13808j0 = null;
        c5103b.m7159a(1, "onStopPreview:", "Returning.");
        return C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    @NonNull
    /* JADX INFO: renamed from: V0 */
    public AbstractC5190c mo7200V0(int i2) {
        return new C5192e(i2);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: X0 */
    public void mo7201X0() {
        AbstractC5135i.f13918j.m7159a(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        m7328Y();
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: Y0 */
    public void mo7202Y0(@NonNull C5113l.a aVar, boolean z2) {
        if (z2) {
            AbstractC5135i.f13918j.m7159a(1, "onTakePicture:", "doMetering is true. Delaying.");
            C5149i c5149i = new C5149i(2500L, m7241p1(null));
            c5149i.m7337f(new r(aVar));
            c5149i.mo7333e(this);
            return;
        }
        AbstractC5135i.f13918j.m7159a(1, "onTakePicture:", "doMetering is false. Performing.");
        C5170a c5170a = this.f13877L;
        EnumC5171b enumC5171b = EnumC5171b.SENSOR;
        EnumC5171b enumC5171b2 = EnumC5171b.OUTPUT;
        aVar.f13717c = c5170a.m7358c(enumC5171b, enumC5171b2, 2);
        aVar.f13718d = mo7309w(enumC5171b2);
        try {
            CaptureRequest.Builder builderCreateCaptureRequest = this.f13804f0.createCaptureRequest(2);
            m7229d1(builderCreateCaptureRequest, this.f13807i0);
            C5217b c5217b = new C5217b(aVar, this, builderCreateCaptureRequest, this.f13813o0);
            this.f13897q = c5217b;
            c5217b.mo7417c();
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g
    /* JADX INFO: renamed from: Z0 */
    public void mo7203Z0(@NonNull C5113l.a aVar, @NonNull C5235a c5235a, boolean z2) {
        if (z2) {
            AbstractC5135i.f13918j.m7159a(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            C5149i c5149i = new C5149i(2500L, m7241p1(null));
            c5149i.m7337f(new q(aVar));
            c5149i.mo7333e(this);
            return;
        }
        AbstractC5135i.f13918j.m7159a(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.f13895o instanceof InterfaceC5229e)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        EnumC5171b enumC5171b = EnumC5171b.OUTPUT;
        aVar.f13718d = mo7260F(enumC5171b);
        aVar.f13717c = this.f13877L.m7358c(EnumC5171b.VIEW, enumC5171b, 1);
        C5221f c5221f = new C5221f(aVar, this, (InterfaceC5229e) this.f13895o, c5235a);
        this.f13897q = c5221f;
        c5221f.mo7417c();
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5133g, p007b.p452o.p453a.p471v.AbstractC5219d.a
    /* JADX INFO: renamed from: a */
    public void mo7227a(@Nullable C5113l.a aVar, @Nullable Exception exc) {
        boolean z2 = this.f13897q instanceof C5217b;
        super.mo7227a(aVar, exc);
        if ((z2 && this.f13872G) || (!z2 && this.f13873H)) {
            C5179f c5179f = this.f13922n;
            c5179f.m7363b("reset metering after picture", true, new RunnableC5181h(c5179f, EnumC5178e.PREVIEW, new s()));
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: c */
    public final boolean mo7205c(@NonNull EnumC5118e enumC5118e) {
        Objects.requireNonNull(this.f13809k0);
        int iIntValue = C5157b.f13962b.get(enumC5118e).intValue();
        try {
            String[] cameraIdList = this.f13802d0.getCameraIdList();
            AbstractC5135i.f13918j.m7159a(1, "collectCameraInfo", "Facing:", enumC5118e, "Internal:", Integer.valueOf(iIntValue), "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    CameraCharacteristics cameraCharacteristics = this.f13802d0.getCameraCharacteristics(str);
                    if (iIntValue == ((Integer) m7246u1(cameraCharacteristics, CameraCharacteristics.LENS_FACING, -99)).intValue()) {
                        this.f13803e0 = str;
                        this.f13877L.m7361f(enumC5118e, ((Integer) m7246u1(cameraCharacteristics, CameraCharacteristics.SENSOR_ORIENTATION, 0)).intValue());
                        return true;
                    }
                    continue;
                } catch (CameraAccessException unused) {
                }
            }
            return false;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    /* JADX INFO: renamed from: c1 */
    public final void m7228c1(@NonNull Surface... surfaceArr) {
        this.f13807i0.addTarget(this.f13812n0);
        Surface surface = this.f13811m0;
        if (surface != null) {
            this.f13807i0.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.f13807i0.addTarget(surface2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: d0 */
    public void mo7207d0(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr, boolean z2) {
        float f3 = this.f13870E;
        this.f13870E = f2;
        this.f13922n.m7366e("exposure correction", 20);
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("exposure correction", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new f(f3, z2, f2, fArr, pointFArr)));
    }

    /* JADX INFO: renamed from: d1 */
    public final void m7229d1(@NonNull CaptureRequest.Builder builder, @Nullable CaptureRequest.Builder builder2) {
        AbstractC5135i.f13918j.m7159a(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        m7231f1(builder);
        m7233h1(builder, EnumC5119f.OFF);
        Location location = this.f13868C;
        if (location != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        m7238m1(builder, EnumC5126m.AUTO);
        m7234i1(builder, EnumC5121h.OFF);
        m7239n1(builder, 0.0f);
        m7232g1(builder, 0.0f);
        m7235j1(builder, 0.0f);
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

    /* JADX INFO: renamed from: e1 */
    public void m7230e1(@NonNull InterfaceC5141a interfaceC5141a, @NonNull CaptureRequest.Builder builder) throws CameraAccessException {
        if (this.f13922n.f14028f != EnumC5178e.PREVIEW || m7324O()) {
            return;
        }
        this.f13806h0.capture(builder.build(), this.f13816r0, null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: f0 */
    public void mo7210f0(@NonNull EnumC5119f enumC5119f) {
        EnumC5119f enumC5119f2 = this.f13903w;
        this.f13903w = enumC5119f;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("flash (" + enumC5119f + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new a(enumC5119f2, enumC5119f)));
    }

    /* JADX INFO: renamed from: f1 */
    public void m7231f1(@NonNull CaptureRequest.Builder builder) {
        int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (this.f13882Q == EnumC5122i.VIDEO && arrayList.contains(3)) {
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

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: g0 */
    public void mo7212g0(int i2) {
        if (this.f13901u == 0) {
            this.f13901u = 35;
        }
        this.f13922n.m7363b(C1643a.m873r("frame processing format (", i2, ")"), true, new k(i2));
    }

    /* JADX INFO: renamed from: g1 */
    public boolean m7232g1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.f13896p.f13693l) {
            this.f13870E = f2;
            return false;
        }
        Rational rational = (Rational) m7245t1(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.f13870E)));
        return true;
    }

    /* JADX INFO: renamed from: h1 */
    public boolean m7233h1(@NonNull CaptureRequest.Builder builder, @NonNull EnumC5119f enumC5119f) {
        if (this.f13896p.m7163c(this.f13903w)) {
            int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2));
            }
            C5157b c5157b = this.f13809k0;
            EnumC5119f enumC5119f2 = this.f13903w;
            Objects.requireNonNull(c5157b);
            ArrayList<Pair> arrayList2 = new ArrayList();
            int iOrdinal = enumC5119f2.ordinal();
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
                    C5103b c5103b = AbstractC5135i.f13918j;
                    c5103b.m7159a(1, "applyFlash: setting CONTROL_AE_MODE to", pair.first);
                    c5103b.m7159a(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.f13903w = enumC5119f;
        return false;
    }

    /* JADX INFO: renamed from: i1 */
    public boolean m7234i1(@NonNull CaptureRequest.Builder builder, @NonNull EnumC5121h enumC5121h) {
        if (!this.f13896p.m7163c(this.f13866A)) {
            this.f13866A = enumC5121h;
            return false;
        }
        C5157b c5157b = this.f13809k0;
        EnumC5121h enumC5121h2 = this.f13866A;
        Objects.requireNonNull(c5157b);
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, Integer.valueOf(C5157b.f13964d.get(enumC5121h2).intValue()));
        return true;
    }

    /* JADX INFO: renamed from: j1 */
    public boolean m7235j1(@NonNull CaptureRequest.Builder builder, float f2) {
        Range<Integer>[] rangeArr = (Range[]) m7245t1(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new C5131e(this, this.f13875J && this.f13874I != 0.0f));
        float f3 = this.f13874I;
        if (f3 == 0.0f) {
            for (Range range : (ArrayList) m7243r1(rangeArr)) {
                if (range.contains(30) || range.contains(24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float fMin = Math.min(f3, this.f13896p.f13698q);
            this.f13874I = fMin;
            this.f13874I = Math.max(fMin, this.f13896p.f13697p);
            for (Range range2 : (ArrayList) m7243r1(rangeArr)) {
                if (range2.contains(Integer.valueOf(Math.round(this.f13874I)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.f13874I = f2;
        return false;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: k0 */
    public void mo7217k0(boolean z2) {
        this.f13922n.m7363b("has frame processors (" + z2 + ")", true, new j(z2));
    }

    /* JADX INFO: renamed from: k1 */
    public void m7236k1() {
        m7237l1(true, 3);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: l0 */
    public void mo7219l0(@NonNull EnumC5121h enumC5121h) {
        EnumC5121h enumC5121h2 = this.f13866A;
        this.f13866A = enumC5121h;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("hdr (" + enumC5121h + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new d(enumC5121h2)));
    }

    /* JADX INFO: renamed from: l1 */
    public final void m7237l1(boolean z2, int i2) {
        if ((this.f13922n.f14028f != EnumC5178e.PREVIEW || m7324O()) && z2) {
            return;
        }
        try {
            this.f13806h0.setRepeatingRequest(this.f13807i0.build(), this.f13816r0, null);
        } catch (CameraAccessException e2) {
            throw new CameraException(e2, i2);
        } catch (IllegalStateException e3) {
            C5103b c5103b = AbstractC5135i.f13918j;
            C5179f c5179f = this.f13922n;
            c5103b.m7159a(3, "applyRepeatingRequestBuilder: session is invalid!", e3, "checkStarted:", Boolean.valueOf(z2), "currentThread:", Thread.currentThread().getName(), "state:", c5179f.f14028f, "targetState:", c5179f.f14029g);
            throw new CameraException(3);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: m0 */
    public void mo7221m0(@Nullable Location location) {
        Location location2 = this.f13868C;
        this.f13868C = location;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b(ModelAuditLogEntry.CHANGE_KEY_LOCATION, true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new b(location2)));
    }

    /* JADX INFO: renamed from: m1 */
    public boolean m7238m1(@NonNull CaptureRequest.Builder builder, @NonNull EnumC5126m enumC5126m) {
        if (!this.f13896p.m7163c(this.f13904x)) {
            this.f13904x = enumC5126m;
            return false;
        }
        C5157b c5157b = this.f13809k0;
        EnumC5126m enumC5126m2 = this.f13904x;
        Objects.requireNonNull(c5157b);
        builder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(C5157b.f13963c.get(enumC5126m2).intValue()));
        return true;
    }

    /* JADX INFO: renamed from: n1 */
    public boolean m7239n1(@NonNull CaptureRequest.Builder builder, float f2) {
        if (!this.f13896p.f13692k) {
            this.f13869D = f2;
            return false;
        }
        float fFloatValue = ((Float) m7245t1(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f3 = fFloatValue - 1.0f;
        float f4 = (this.f13869D * f3) + 1.0f;
        Rect rect = (Rect) m7245t1(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
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
    /* JADX INFO: renamed from: o1 */
    public final CameraException m7240o1(@NonNull CameraAccessException cameraAccessException) {
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
        AbstractC5135i.f13918j.m7159a(0, "onImageAvailable:", "trying to acquire Image.");
        Image imageAcquireLatestImage = null;
        try {
            imageAcquireLatestImage = imageReader.acquireLatestImage();
        } catch (Exception unused) {
        }
        if (imageAcquireLatestImage == null) {
            AbstractC5135i.f13918j.m7159a(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.f13922n.f14028f != EnumC5178e.PREVIEW || m7324O()) {
            AbstractC5135i.f13918j.m7159a(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            imageAcquireLatestImage.close();
            return;
        }
        C5189b c5189bM7385a = m7273S0().m7385a(imageAcquireLatestImage, System.currentTimeMillis());
        if (c5189bM7385a == null) {
            AbstractC5135i.f13918j.m7159a(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            AbstractC5135i.f13918j.m7159a(0, "onImageAvailable:", "Image acquired, dispatching.");
            ((CameraView.C11195b) this.f13921m).m9312b(c5189bM7385a);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: p0 */
    public void mo7223p0(@NonNull EnumC5123j enumC5123j) {
        if (enumC5123j != this.f13867B) {
            this.f13867B = enumC5123j;
            C5179f c5179f = this.f13922n;
            c5179f.m7363b("picture format (" + enumC5123j + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new h()));
        }
    }

    @NonNull
    /* JADX INFO: renamed from: p1 */
    public final C5164g m7241p1(@Nullable C5211b c5211b) {
        C5164g c5164g = this.f13815q0;
        if (c5164g != null) {
            c5164g.mo7330a(this);
        }
        CaptureRequest.Builder builder = this.f13807i0;
        int[] iArr = (int[]) m7245t1(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.f13882Q == EnumC5122i.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        C5164g c5164g2 = new C5164g(this, c5211b, c5211b == null);
        this.f13815q0 = c5164g2;
        return c5164g2;
    }

    @NonNull
    /* JADX INFO: renamed from: q1 */
    public final CaptureRequest.Builder m7242q1(int i2) throws CameraAccessException {
        CaptureRequest.Builder builder = this.f13807i0;
        CaptureRequest.Builder builderCreateCaptureRequest = this.f13804f0.createCaptureRequest(i2);
        this.f13807i0 = builderCreateCaptureRequest;
        builderCreateCaptureRequest.setTag(Integer.valueOf(i2));
        m7229d1(this.f13807i0, builder);
        return this.f13807i0;
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
    /* JADX INFO: renamed from: r1 */
    public List<Range<Integer>> m7243r1(@NonNull Range<Integer>[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int iRound = Math.round(this.f13896p.f13697p);
        int iRound2 = Math.round(this.f13896p.f13698q);
        for (Range<Integer> range : rangeArr) {
            if (range.contains(Integer.valueOf(iRound)) || range.contains(Integer.valueOf(iRound2))) {
                C5103b c5103b = C5201b.f14103a;
                String str = Build.MODEL;
                boolean z2 = true;
                String str2 = Build.MANUFACTURER;
                c5103b.m7159a(1, "Build.MODEL:", str, "Build.BRAND:", Build.BRAND, "Build.MANUFACTURER:", str2);
                List<Range<Integer>> list = C5201b.f14104b.get(str2 + " " + str);
                if (list != null && list.contains(range)) {
                    c5103b.m7159a(1, "Dropping range:", range);
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
    /* JADX INFO: renamed from: s1 */
    public List<C5236b> m7244s1() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.f13802d0.getCameraCharacteristics(this.f13803e0).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f13901u);
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                C5236b c5236b = new C5236b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(c5236b)) {
                    arrayList.add(c5236b);
                }
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw m7240o1(e2);
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: t0 */
    public void mo7224t0(boolean z2) {
        this.f13871F = z2;
        C3404f.m4264Z(null);
    }

    @NonNull
    @VisibleForTesting
    /* JADX INFO: renamed from: t1 */
    public <T> T m7245t1(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) this.f13805g0.get(key);
        return t2 == null ? t : t2;
    }

    @NonNull
    /* JADX INFO: renamed from: u1 */
    public final <T> T m7246u1(@NonNull CameraCharacteristics cameraCharacteristics, @NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) cameraCharacteristics.get(key);
        return t2 == null ? t : t2;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: v0 */
    public void mo7225v0(float f2) {
        float f3 = this.f13874I;
        this.f13874I = f2;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("preview fps (" + f2 + ")", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new g(f3)));
    }
}
