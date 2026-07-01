package b.o.a.n;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.o.a.CameraLogger;
import b.o.a.CameraOptions;
import b.o.a.CameraView5;
import b.o.a.PictureResult;
import b.o.a.m.Audio;
import b.o.a.m.AudioCodec;
import b.o.a.m.Facing;
import b.o.a.m.Flash;
import b.o.a.m.Hdr;
import b.o.a.m.Mode3;
import b.o.a.m.PictureFormat;
import b.o.a.m.VideoCodec;
import b.o.a.m.WhiteBalance;
import b.o.a.n.CameraEngine;
import b.o.a.n.t.Angles;
import b.o.a.n.t.Reference2;
import b.o.a.n.v.CameraState2;
import b.o.a.n.v.CameraStateOrchestrator;
import b.o.a.n.v.CameraStateOrchestrator3;
import b.o.a.p.FrameManager;
import b.o.a.u.Overlay;
import b.o.a.v.PictureRecorder;
import b.o.a.w.CameraPreview;
import b.o.a.x.AspectRatio2;
import b.o.a.x.Size3;
import b.o.a.x.SizeSelector;
import b.o.a.x.SizeSelectors;
import b.o.a.x.SizeSelectors2;
import b.o.a.x.SizeSelectors3;
import b.o.a.x.SizeSelectors9;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: b.o.a.n.g, reason: use source file name */
/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraBaseEngine extends CameraEngine {
    public Hdr A;
    public PictureFormat B;
    public Location C;
    public float D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public float I;
    public boolean J;
    public FrameManager K;
    public final Angles L;

    @Nullable
    public SizeSelector M;
    public SizeSelector N;
    public SizeSelector O;
    public Facing P;
    public Mode3 Q;
    public Audio R;
    public long S;
    public int T;
    public int U;
    public int V;
    public long W;
    public int X;
    public int Y;
    public int Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f1928a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f1929b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Overlay f1930c0;
    public CameraPreview o;
    public CameraOptions p;
    public PictureRecorder q;
    public Size3 r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Size3 f1931s;
    public Size3 t;
    public int u;
    public boolean v;
    public Flash w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public WhiteBalance f1932x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public VideoCodec f1933y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public AudioCodec f1934z;

    /* JADX INFO: renamed from: b.o.a.n.g$a */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class a implements Runnable {
        public final /* synthetic */ Facing j;
        public final /* synthetic */ Facing k;

        public a(Facing facing, Facing facing2) {
            this.j = facing;
            this.k = facing2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (CameraBaseEngine.this.c(this.j)) {
                CameraBaseEngine.this.X();
            } else {
                CameraBaseEngine.this.P = this.k;
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$b */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraBaseEngine.this.X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$c */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class c implements Runnable {
        public final /* synthetic */ PictureResult.a j;
        public final /* synthetic */ boolean k;

        public c(PictureResult.a aVar, boolean z2) {
            this.j = aVar;
            this.k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.j.a(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.W0()));
            if (CameraBaseEngine.this.W0()) {
                return;
            }
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            if (cameraBaseEngine.Q == Mode3.VIDEO) {
                throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
            PictureResult.a aVar = this.j;
            aVar.a = false;
            aVar.f1912b = cameraBaseEngine.C;
            aVar.e = cameraBaseEngine.P;
            aVar.g = cameraBaseEngine.B;
            cameraBaseEngine.Y0(aVar, this.k);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$d */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class d implements Runnable {
        public final /* synthetic */ PictureResult.a j;
        public final /* synthetic */ boolean k;

        public d(PictureResult.a aVar, boolean z2) {
            this.j = aVar;
            this.k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraEngine.j.a(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(CameraBaseEngine.this.W0()));
            if (CameraBaseEngine.this.W0()) {
                return;
            }
            PictureResult.a aVar = this.j;
            CameraBaseEngine cameraBaseEngine = CameraBaseEngine.this;
            aVar.f1912b = cameraBaseEngine.C;
            aVar.a = true;
            aVar.e = cameraBaseEngine.P;
            aVar.g = PictureFormat.JPEG;
            CameraBaseEngine.this.Z0(this.j, AspectRatio2.g(cameraBaseEngine.U0(Reference2.OUTPUT)), this.k);
        }
    }

    public CameraBaseEngine(@NonNull CameraEngine.g gVar) {
        super(gVar);
        this.L = new Angles();
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.CameraEngine
    public final float A() {
        return this.I;
    }

    @Override // b.o.a.n.CameraEngine
    public final void A0(int i) {
        this.U = i;
    }

    @Override // b.o.a.n.CameraEngine
    public final boolean B() {
        return this.J;
    }

    @Override // b.o.a.n.CameraEngine
    public final void B0(@NonNull VideoCodec videoCodec) {
        this.f1933y = videoCodec;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final Size3 C(@NonNull Reference2 reference2) {
        Size3 size3 = this.f1931s;
        if (size3 == null) {
            return null;
        }
        return this.L.b(Reference2.SENSOR, reference2) ? size3.f() : size3;
    }

    @Override // b.o.a.n.CameraEngine
    public final void C0(int i) {
        this.T = i;
    }

    @Override // b.o.a.n.CameraEngine
    public final int D() {
        return this.Y;
    }

    @Override // b.o.a.n.CameraEngine
    public final void D0(long j) {
        this.S = j;
    }

    @Override // b.o.a.n.CameraEngine
    public final int E() {
        return this.X;
    }

    @Override // b.o.a.n.CameraEngine
    public final void E0(@NonNull SizeSelector sizeSelector) {
        this.O = sizeSelector;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final Size3 F(@NonNull Reference2 reference2) {
        Size3 size3C = C(reference2);
        if (size3C == null) {
            return null;
        }
        boolean zB = this.L.b(reference2, Reference2.VIEW);
        int i = zB ? this.Y : this.X;
        int i2 = zB ? this.X : this.Y;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        HashMap<String, AspectRatio2> map = AspectRatio2.j;
        float fI = AspectRatio2.f(size3C.j, size3C.k).i();
        if (AspectRatio2.f(i, i2).i() >= fI) {
            int iMin = Math.min(size3C.k, i2);
            return new Size3((int) Math.floor(iMin * fI), iMin);
        }
        int iMin2 = Math.min(size3C.j, i);
        return new Size3(iMin2, (int) Math.floor(iMin2 / fI));
    }

    @Override // b.o.a.n.CameraEngine
    public final int G() {
        return this.U;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final VideoCodec H() {
        return this.f1933y;
    }

    @Override // b.o.a.n.CameraEngine
    public final int I() {
        return this.T;
    }

    @Override // b.o.a.n.CameraEngine
    public final long J() {
        return this.S;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final Size3 K(@NonNull Reference2 reference2) {
        Size3 size3 = this.r;
        if (size3 == null || this.Q == Mode3.PICTURE) {
            return null;
        }
        return this.L.b(Reference2.SENSOR, reference2) ? size3.f() : size3;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final SizeSelector L() {
        return this.O;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final WhiteBalance M() {
        return this.f1932x;
    }

    @Override // b.o.a.n.CameraEngine
    public final float N() {
        return this.D;
    }

    @Override // b.o.a.n.CameraEngine
    public void O0(@NonNull PictureResult.a aVar) {
        boolean z2 = this.G;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("take picture", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new c(aVar, z2)));
    }

    @Override // b.o.a.n.CameraEngine
    public void P0(@NonNull PictureResult.a aVar) {
        boolean z2 = this.H;
        CameraStateOrchestrator cameraStateOrchestrator = this.n;
        cameraStateOrchestrator.b("take picture snapshot", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.BIND, new d(aVar, z2)));
    }

    @NonNull
    public final Size3 Q0(@NonNull Mode3 mode3) {
        SizeSelector sizeSelector;
        Set setUnmodifiableSet;
        boolean zB = this.L.b(Reference2.SENSOR, Reference2.VIEW);
        if (mode3 == Mode3.PICTURE) {
            sizeSelector = this.N;
            setUnmodifiableSet = Collections.unmodifiableSet(this.p.e);
        } else {
            sizeSelector = this.O;
            setUnmodifiableSet = Collections.unmodifiableSet(this.p.f);
        }
        SizeSelector sizeSelectorQ0 = b.i.a.f.e.o.f.Q0(sizeSelector, new SizeSelectors2());
        ArrayList arrayList = new ArrayList(setUnmodifiableSet);
        Size3 size3 = ((SizeSelectors9) sizeSelectorQ0).a(arrayList).get(0);
        if (!arrayList.contains(size3)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        CameraEngine.j.a(1, "computeCaptureSize:", "result:", size3, "flip:", Boolean.valueOf(zB), "mode:", mode3);
        return zB ? size3.f() : size3;
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
    @NonNull
    public final Size3 R0() {
        Reference2 reference2 = Reference2.VIEW;
        List<Size3> listT0 = T0();
        boolean zB = this.L.b(Reference2.SENSOR, reference2);
        ArrayList arrayList = new ArrayList(listT0.size());
        for (Size3 size3F : listT0) {
            if (zB) {
                size3F = size3F.f();
            }
            arrayList.add(size3F);
        }
        Size3 size3U0 = U0(reference2);
        if (size3U0 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        Size3 size3 = this.r;
        AspectRatio2 aspectRatio2F = AspectRatio2.f(size3.j, size3.k);
        if (zB) {
            aspectRatio2F = AspectRatio2.f(aspectRatio2F.l, aspectRatio2F.k);
        }
        CameraLogger cameraLogger = CameraEngine.j;
        cameraLogger.a(1, "computePreviewStreamSize:", "targetRatio:", aspectRatio2F, "targetMinSize:", size3U0);
        SizeSelector sizeSelectorG = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.D1(new SizeSelectors(aspectRatio2F.i(), 0.0f)), new SizeSelectors2());
        SizeSelector sizeSelectorG2 = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.M0(size3U0.k), b.i.a.f.e.o.f.N0(size3U0.j), new SizeSelectors3());
        SizeSelector sizeSelectorQ0 = b.i.a.f.e.o.f.Q0(b.i.a.f.e.o.f.g(sizeSelectorG, sizeSelectorG2), sizeSelectorG2, sizeSelectorG, new SizeSelectors2());
        SizeSelector sizeSelector = this.M;
        if (sizeSelector != null) {
            sizeSelectorQ0 = b.i.a.f.e.o.f.Q0(sizeSelector, sizeSelectorQ0);
        }
        Size3 size3F2 = ((SizeSelectors9) sizeSelectorQ0).a(arrayList).get(0);
        if (!arrayList.contains(size3F2)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (zB) {
            size3F2 = size3F2.f();
        }
        cameraLogger.a(1, "computePreviewStreamSize:", "result:", size3F2, "flip:", Boolean.valueOf(zB));
        return size3F2;
    }

    @NonNull
    public FrameManager S0() {
        if (this.K == null) {
            this.K = V0(this.f1929b0);
        }
        return this.K;
    }

    @NonNull
    public abstract List<Size3> T0();

    @Nullable
    public final Size3 U0(@NonNull Reference2 reference2) {
        CameraPreview cameraPreview = this.o;
        if (cameraPreview == null) {
            return null;
        }
        return this.L.b(Reference2.VIEW, reference2) ? cameraPreview.l().f() : cameraPreview.l();
    }

    @NonNull
    public abstract FrameManager V0(int i);

    public final boolean W0() {
        return this.q != null;
    }

    public abstract void X0();

    public abstract void Y0(@NonNull PictureResult.a aVar, boolean z2);

    @Override // b.o.a.n.CameraEngine
    public final void Z(@NonNull Audio audio) {
        if (this.R != audio) {
            this.R = audio;
        }
    }

    public abstract void Z0(@NonNull PictureResult.a aVar, @NonNull AspectRatio2 aspectRatio2, boolean z2);

    public void a(@Nullable PictureResult.a aVar, @Nullable Exception exc) {
        this.q = null;
        if (aVar == null) {
            CameraEngine.j.a(3, "onPictureResult", "result is null: something went wrong.", exc);
            ((CameraView.b) this.m).a(new CameraException(exc, 4));
        } else {
            CameraView.b bVar = (CameraView.b) this.m;
            bVar.f3177b.a(1, "dispatchOnPictureTaken", aVar);
            CameraView.this.u.post(new CameraView5(bVar, aVar));
        }
    }

    @Override // b.o.a.n.CameraEngine
    public final void a0(int i) {
        this.V = i;
    }

    public final boolean a1() {
        long j = this.W;
        return j > 0 && j != RecyclerView.FOREVER_NS;
    }

    @Override // b.o.a.n.CameraEngine
    public final void b0(@NonNull AudioCodec audioCodec) {
        this.f1934z = audioCodec;
    }

    @Override // b.o.a.n.CameraEngine
    public final void c0(long j) {
        this.W = j;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Angles e() {
        return this.L;
    }

    @Override // b.o.a.n.CameraEngine
    public final void e0(@NonNull Facing facing) {
        Facing facing2 = this.P;
        if (facing != facing2) {
            this.P = facing;
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            cameraStateOrchestrator.b("facing", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new a(facing, facing2)));
        }
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Audio f() {
        return this.R;
    }

    @Override // b.o.a.n.CameraEngine
    public final int g() {
        return this.V;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final AudioCodec h() {
        return this.f1934z;
    }

    @Override // b.o.a.n.CameraEngine
    public final void h0(int i) {
        this.f1928a0 = i;
    }

    @Override // b.o.a.n.CameraEngine
    public final long i() {
        return this.W;
    }

    @Override // b.o.a.n.CameraEngine
    public final void i0(int i) {
        this.Z = i;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final CameraOptions j() {
        return this.p;
    }

    @Override // b.o.a.n.CameraEngine
    public final void j0(int i) {
        this.f1929b0 = i;
    }

    @Override // b.o.a.n.CameraEngine
    public final float k() {
        return this.E;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Facing l() {
        return this.P;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Flash m() {
        return this.w;
    }

    @Override // b.o.a.n.CameraEngine
    public final int n() {
        return this.u;
    }

    @Override // b.o.a.n.CameraEngine
    public final void n0(@NonNull Mode3 mode3) {
        if (mode3 != this.Q) {
            this.Q = mode3;
            CameraStateOrchestrator cameraStateOrchestrator = this.n;
            cameraStateOrchestrator.b("mode", true, new CameraStateOrchestrator3(cameraStateOrchestrator, CameraState2.ENGINE, new b()));
        }
    }

    @Override // b.o.a.n.CameraEngine
    public final int o() {
        return this.f1928a0;
    }

    @Override // b.o.a.n.CameraEngine
    public final void o0(@Nullable Overlay overlay) {
        this.f1930c0 = overlay;
    }

    @Override // b.o.a.n.CameraEngine
    public final int p() {
        return this.Z;
    }

    @Override // b.o.a.n.CameraEngine
    public final int q() {
        return this.f1929b0;
    }

    @Override // b.o.a.n.CameraEngine
    public final void q0(boolean z2) {
        this.G = z2;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Hdr r() {
        return this.A;
    }

    @Override // b.o.a.n.CameraEngine
    public final void r0(@NonNull SizeSelector sizeSelector) {
        this.N = sizeSelector;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final Location s() {
        return this.C;
    }

    @Override // b.o.a.n.CameraEngine
    public final void s0(boolean z2) {
        this.H = z2;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final Mode3 t() {
        return this.Q;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final PictureFormat u() {
        return this.B;
    }

    @Override // b.o.a.n.CameraEngine
    public final void u0(@NonNull CameraPreview cameraPreview) {
        CameraPreview cameraPreview2 = this.o;
        if (cameraPreview2 != null) {
            cameraPreview2.t(null);
        }
        this.o = cameraPreview;
        cameraPreview.t(this);
    }

    @Override // b.o.a.n.CameraEngine
    public final boolean v() {
        return this.G;
    }

    @Override // b.o.a.n.CameraEngine
    @Nullable
    public final Size3 w(@NonNull Reference2 reference2) {
        Size3 size3 = this.r;
        if (size3 == null || this.Q == Mode3.VIDEO) {
            return null;
        }
        return this.L.b(Reference2.SENSOR, reference2) ? size3.f() : size3;
    }

    @Override // b.o.a.n.CameraEngine
    public final void w0(boolean z2) {
        this.J = z2;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final SizeSelector x() {
        return this.N;
    }

    @Override // b.o.a.n.CameraEngine
    public final void x0(@Nullable SizeSelector sizeSelector) {
        this.M = sizeSelector;
    }

    @Override // b.o.a.n.CameraEngine
    public final boolean y() {
        return this.H;
    }

    @Override // b.o.a.n.CameraEngine
    public final void y0(int i) {
        this.Y = i;
    }

    @Override // b.o.a.n.CameraEngine
    @NonNull
    public final CameraPreview z() {
        return this.o;
    }

    @Override // b.o.a.n.CameraEngine
    public final void z0(int i) {
        this.X = i;
    }
}
