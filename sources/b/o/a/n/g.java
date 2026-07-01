package b.o.a.n;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.o.a.l$a;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView$b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends i {
    public b.o.a.m.h A;
    public b.o.a.m.j B;
    public Location C;
    public float D;
    public float E;
    public boolean F;
    public boolean G;
    public boolean H;
    public float I;
    public boolean J;
    public b.o.a.p.c K;
    public final b.o.a.n.t.a L;

    @Nullable
    public b.o.a.x.c M;
    public b.o.a.x.c N;
    public b.o.a.x.c O;
    public b.o.a.m.e P;
    public b.o.a.m.i Q;
    public b.o.a.m.a R;
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
    public b.o.a.u.a f1930c0;
    public b.o.a.w.a o;
    public b.o.a.c p;
    public b.o.a.v.d q;
    public b.o.a.x.b r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public b.o.a.x.b f1931s;
    public b.o.a.x.b t;
    public int u;
    public boolean v;
    public b.o.a.m.f w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b.o.a.m.m f1932x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b.o.a.m.l f1933y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b.o.a.m.b f1934z;

    public g(@NonNull i$g i_g) {
        super(i_g);
        this.L = new b.o.a.n.t.a();
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
        b.i.a.f.e.o.f.Z(null);
    }

    @Override // b.o.a.n.i
    public final float A() {
        return this.I;
    }

    @Override // b.o.a.n.i
    public final void A0(int i) {
        this.U = i;
    }

    @Override // b.o.a.n.i
    public final boolean B() {
        return this.J;
    }

    @Override // b.o.a.n.i
    public final void B0(@NonNull b.o.a.m.l lVar) {
        this.f1933y = lVar;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final b.o.a.x.b C(@NonNull b.o.a.n.t.b bVar) {
        b.o.a.x.b bVar2 = this.f1931s;
        if (bVar2 == null) {
            return null;
        }
        return this.L.b(b.o.a.n.t.b.SENSOR, bVar) ? bVar2.f() : bVar2;
    }

    @Override // b.o.a.n.i
    public final void C0(int i) {
        this.T = i;
    }

    @Override // b.o.a.n.i
    public final int D() {
        return this.Y;
    }

    @Override // b.o.a.n.i
    public final void D0(long j) {
        this.S = j;
    }

    @Override // b.o.a.n.i
    public final int E() {
        return this.X;
    }

    @Override // b.o.a.n.i
    public final void E0(@NonNull b.o.a.x.c cVar) {
        this.O = cVar;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final b.o.a.x.b F(@NonNull b.o.a.n.t.b bVar) {
        b.o.a.x.b bVarC = C(bVar);
        if (bVarC == null) {
            return null;
        }
        boolean zB = this.L.b(bVar, b.o.a.n.t.b.VIEW);
        int i = zB ? this.Y : this.X;
        int i2 = zB ? this.X : this.Y;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        HashMap<String, b.o.a.x.a> map = b.o.a.x.a.j;
        float fI = b.o.a.x.a.f(bVarC.j, bVarC.k).i();
        if (b.o.a.x.a.f(i, i2).i() >= fI) {
            int iMin = Math.min(bVarC.k, i2);
            return new b.o.a.x.b((int) Math.floor(iMin * fI), iMin);
        }
        int iMin2 = Math.min(bVarC.j, i);
        return new b.o.a.x.b(iMin2, (int) Math.floor(iMin2 / fI));
    }

    @Override // b.o.a.n.i
    public final int G() {
        return this.U;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.l H() {
        return this.f1933y;
    }

    @Override // b.o.a.n.i
    public final int I() {
        return this.T;
    }

    @Override // b.o.a.n.i
    public final long J() {
        return this.S;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final b.o.a.x.b K(@NonNull b.o.a.n.t.b bVar) {
        b.o.a.x.b bVar2 = this.r;
        if (bVar2 == null || this.Q == b.o.a.m.i.PICTURE) {
            return null;
        }
        return this.L.b(b.o.a.n.t.b.SENSOR, bVar) ? bVar2.f() : bVar2;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.x.c L() {
        return this.O;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.m M() {
        return this.f1932x;
    }

    @Override // b.o.a.n.i
    public final float N() {
        return this.D;
    }

    @Override // b.o.a.n.i
    public void O0(@NonNull l$a l_a) {
        boolean z2 = this.G;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("take picture", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.BIND, new g$c(this, l_a, z2)));
    }

    @Override // b.o.a.n.i
    public void P0(@NonNull l$a l_a) {
        boolean z2 = this.H;
        b.o.a.n.v.f fVar = this.n;
        fVar.b("take picture snapshot", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.BIND, new g$d(this, l_a, z2)));
    }

    @NonNull
    public final b.o.a.x.b Q0(@NonNull b.o.a.m.i iVar) {
        b.o.a.x.c cVar;
        Set setUnmodifiableSet;
        boolean zB = this.L.b(b.o.a.n.t.b.SENSOR, b.o.a.n.t.b.VIEW);
        if (iVar == b.o.a.m.i.PICTURE) {
            cVar = this.N;
            setUnmodifiableSet = Collections.unmodifiableSet(this.p.e);
        } else {
            cVar = this.O;
            setUnmodifiableSet = Collections.unmodifiableSet(this.p.f);
        }
        b.o.a.x.c cVarQ0 = b.i.a.f.e.o.f.Q0(cVar, new b.o.a.x.e());
        ArrayList arrayList = new ArrayList(setUnmodifiableSet);
        b.o.a.x.b bVar = ((b.o.a.x.l) cVarQ0).a(arrayList).get(0);
        if (!arrayList.contains(bVar)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        i.j.a(1, "computeCaptureSize:", "result:", bVar, "flip:", Boolean.valueOf(zB), "mode:", iVar);
        return zB ? bVar.f() : bVar;
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
    public final b.o.a.x.b R0() {
        b.o.a.n.t.b bVar = b.o.a.n.t.b.VIEW;
        List<b.o.a.x.b> listT0 = T0();
        boolean zB = this.L.b(b.o.a.n.t.b.SENSOR, bVar);
        ArrayList arrayList = new ArrayList(listT0.size());
        for (b.o.a.x.b bVarF : listT0) {
            if (zB) {
                bVarF = bVarF.f();
            }
            arrayList.add(bVarF);
        }
        b.o.a.x.b bVarU0 = U0(bVar);
        if (bVarU0 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        b.o.a.x.b bVar2 = this.r;
        b.o.a.x.a aVarF = b.o.a.x.a.f(bVar2.j, bVar2.k);
        if (zB) {
            aVarF = b.o.a.x.a.f(aVarF.l, aVarF.k);
        }
        b.o.a.b bVar3 = i.j;
        bVar3.a(1, "computePreviewStreamSize:", "targetRatio:", aVarF, "targetMinSize:", bVarU0);
        b.o.a.x.c cVarG = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.D1(new b.o.a.x.d(aVarF.i(), 0.0f)), new b.o.a.x.e());
        b.o.a.x.c cVarG2 = b.i.a.f.e.o.f.g(b.i.a.f.e.o.f.M0(bVarU0.k), b.i.a.f.e.o.f.N0(bVarU0.j), new b.o.a.x.f());
        b.o.a.x.c cVarQ0 = b.i.a.f.e.o.f.Q0(b.i.a.f.e.o.f.g(cVarG, cVarG2), cVarG2, cVarG, new b.o.a.x.e());
        b.o.a.x.c cVar = this.M;
        if (cVar != null) {
            cVarQ0 = b.i.a.f.e.o.f.Q0(cVar, cVarQ0);
        }
        b.o.a.x.b bVarF2 = ((b.o.a.x.l) cVarQ0).a(arrayList).get(0);
        if (!arrayList.contains(bVarF2)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (zB) {
            bVarF2 = bVarF2.f();
        }
        bVar3.a(1, "computePreviewStreamSize:", "result:", bVarF2, "flip:", Boolean.valueOf(zB));
        return bVarF2;
    }

    @NonNull
    public b.o.a.p.c S0() {
        if (this.K == null) {
            this.K = V0(this.f1929b0);
        }
        return this.K;
    }

    @NonNull
    public abstract List<b.o.a.x.b> T0();

    @Nullable
    public final b.o.a.x.b U0(@NonNull b.o.a.n.t.b bVar) {
        b.o.a.w.a aVar = this.o;
        if (aVar == null) {
            return null;
        }
        return this.L.b(b.o.a.n.t.b.VIEW, bVar) ? aVar.l().f() : aVar.l();
    }

    @NonNull
    public abstract b.o.a.p.c V0(int i);

    public final boolean W0() {
        return this.q != null;
    }

    public abstract void X0();

    public abstract void Y0(@NonNull l$a l_a, boolean z2);

    @Override // b.o.a.n.i
    public final void Z(@NonNull b.o.a.m.a aVar) {
        if (this.R != aVar) {
            this.R = aVar;
        }
    }

    public abstract void Z0(@NonNull l$a l_a, @NonNull b.o.a.x.a aVar, boolean z2);

    public void a(@Nullable l$a l_a, @Nullable Exception exc) {
        this.q = null;
        if (l_a == null) {
            i.j.a(3, "onPictureResult", "result is null: something went wrong.", exc);
            ((CameraView$b) this.m).a(new CameraException(exc, 4));
        } else {
            CameraView$b cameraView$b = (CameraView$b) this.m;
            cameraView$b.f3177b.a(1, "dispatchOnPictureTaken", l_a);
            cameraView$b.c.u.post(new b.o.a.i(cameraView$b, l_a));
        }
    }

    @Override // b.o.a.n.i
    public final void a0(int i) {
        this.V = i;
    }

    public final boolean a1() {
        long j = this.W;
        return j > 0 && j != RecyclerView.FOREVER_NS;
    }

    @Override // b.o.a.n.i
    public final void b0(@NonNull b.o.a.m.b bVar) {
        this.f1934z = bVar;
    }

    @Override // b.o.a.n.i
    public final void c0(long j) {
        this.W = j;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.n.t.a e() {
        return this.L;
    }

    @Override // b.o.a.n.i
    public final void e0(@NonNull b.o.a.m.e eVar) {
        b.o.a.m.e eVar2 = this.P;
        if (eVar != eVar2) {
            this.P = eVar;
            b.o.a.n.v.f fVar = this.n;
            fVar.b("facing", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new g$a(this, eVar, eVar2)));
        }
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.a f() {
        return this.R;
    }

    @Override // b.o.a.n.i
    public final int g() {
        return this.V;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.b h() {
        return this.f1934z;
    }

    @Override // b.o.a.n.i
    public final void h0(int i) {
        this.f1928a0 = i;
    }

    @Override // b.o.a.n.i
    public final long i() {
        return this.W;
    }

    @Override // b.o.a.n.i
    public final void i0(int i) {
        this.Z = i;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final b.o.a.c j() {
        return this.p;
    }

    @Override // b.o.a.n.i
    public final void j0(int i) {
        this.f1929b0 = i;
    }

    @Override // b.o.a.n.i
    public final float k() {
        return this.E;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.e l() {
        return this.P;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.f m() {
        return this.w;
    }

    @Override // b.o.a.n.i
    public final int n() {
        return this.u;
    }

    @Override // b.o.a.n.i
    public final void n0(@NonNull b.o.a.m.i iVar) {
        if (iVar != this.Q) {
            this.Q = iVar;
            b.o.a.n.v.f fVar = this.n;
            fVar.b("mode", true, new b.o.a.n.v.h(fVar, b.o.a.n.v.e.ENGINE, new g$b(this)));
        }
    }

    @Override // b.o.a.n.i
    public final int o() {
        return this.f1928a0;
    }

    @Override // b.o.a.n.i
    public final void o0(@Nullable b.o.a.u.a aVar) {
        this.f1930c0 = aVar;
    }

    @Override // b.o.a.n.i
    public final int p() {
        return this.Z;
    }

    @Override // b.o.a.n.i
    public final int q() {
        return this.f1929b0;
    }

    @Override // b.o.a.n.i
    public final void q0(boolean z2) {
        this.G = z2;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.h r() {
        return this.A;
    }

    @Override // b.o.a.n.i
    public final void r0(@NonNull b.o.a.x.c cVar) {
        this.N = cVar;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final Location s() {
        return this.C;
    }

    @Override // b.o.a.n.i
    public final void s0(boolean z2) {
        this.H = z2;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.i t() {
        return this.Q;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.m.j u() {
        return this.B;
    }

    @Override // b.o.a.n.i
    public final void u0(@NonNull b.o.a.w.a aVar) {
        b.o.a.w.a aVar2 = this.o;
        if (aVar2 != null) {
            aVar2.t(null);
        }
        this.o = aVar;
        aVar.t(this);
    }

    @Override // b.o.a.n.i
    public final boolean v() {
        return this.G;
    }

    @Override // b.o.a.n.i
    @Nullable
    public final b.o.a.x.b w(@NonNull b.o.a.n.t.b bVar) {
        b.o.a.x.b bVar2 = this.r;
        if (bVar2 == null || this.Q == b.o.a.m.i.VIDEO) {
            return null;
        }
        return this.L.b(b.o.a.n.t.b.SENSOR, bVar) ? bVar2.f() : bVar2;
    }

    @Override // b.o.a.n.i
    public final void w0(boolean z2) {
        this.J = z2;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.x.c x() {
        return this.N;
    }

    @Override // b.o.a.n.i
    public final void x0(@Nullable b.o.a.x.c cVar) {
        this.M = cVar;
    }

    @Override // b.o.a.n.i
    public final boolean y() {
        return this.H;
    }

    @Override // b.o.a.n.i
    public final void y0(int i) {
        this.Y = i;
    }

    @Override // b.o.a.n.i
    @NonNull
    public final b.o.a.w.a z() {
        return this.o;
    }

    @Override // b.o.a.n.i
    public final void z0(int i) {
        this.X = i;
    }
}
