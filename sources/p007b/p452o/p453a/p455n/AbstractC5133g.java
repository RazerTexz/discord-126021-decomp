package p007b.p452o.p453a.p455n;

import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.AbstractC5104c;
import p007b.p452o.p453a.C5103b;
import p007b.p452o.p453a.C5113l;
import p007b.p452o.p453a.RunnableC5110i;
import p007b.p452o.p453a.p454m.EnumC5114a;
import p007b.p452o.p453a.p454m.EnumC5115b;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5122i;
import p007b.p452o.p453a.p454m.EnumC5123j;
import p007b.p452o.p453a.p454m.EnumC5125l;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p455n.p461t.EnumC5171b;
import p007b.p452o.p453a.p455n.p463v.C5179f;
import p007b.p452o.p453a.p455n.p463v.EnumC5178e;
import p007b.p452o.p453a.p455n.p463v.RunnableC5181h;
import p007b.p452o.p453a.p465p.AbstractC5190c;
import p007b.p452o.p453a.p470u.InterfaceC5213a;
import p007b.p452o.p453a.p471v.AbstractC5219d;
import p007b.p452o.p453a.p472w.AbstractC5225a;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p453a.p473x.C5236b;
import p007b.p452o.p453a.p473x.C5238d;
import p007b.p452o.p453a.p473x.C5239e;
import p007b.p452o.p453a.p473x.C5240f;
import p007b.p452o.p453a.p473x.C5246l;
import p007b.p452o.p453a.p473x.InterfaceC5237c;

/* JADX INFO: renamed from: b.o.a.n.g */
/* JADX INFO: compiled from: CameraBaseEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5133g extends AbstractC5135i {

    /* JADX INFO: renamed from: A */
    public EnumC5121h f13866A;

    /* JADX INFO: renamed from: B */
    public EnumC5123j f13867B;

    /* JADX INFO: renamed from: C */
    public Location f13868C;

    /* JADX INFO: renamed from: D */
    public float f13869D;

    /* JADX INFO: renamed from: E */
    public float f13870E;

    /* JADX INFO: renamed from: F */
    public boolean f13871F;

    /* JADX INFO: renamed from: G */
    public boolean f13872G;

    /* JADX INFO: renamed from: H */
    public boolean f13873H;

    /* JADX INFO: renamed from: I */
    public float f13874I;

    /* JADX INFO: renamed from: J */
    public boolean f13875J;

    /* JADX INFO: renamed from: K */
    public AbstractC5190c f13876K;

    /* JADX INFO: renamed from: L */
    public final C5170a f13877L;

    /* JADX INFO: renamed from: M */
    @Nullable
    public InterfaceC5237c f13878M;

    /* JADX INFO: renamed from: N */
    public InterfaceC5237c f13879N;

    /* JADX INFO: renamed from: O */
    public InterfaceC5237c f13880O;

    /* JADX INFO: renamed from: P */
    public EnumC5118e f13881P;

    /* JADX INFO: renamed from: Q */
    public EnumC5122i f13882Q;

    /* JADX INFO: renamed from: R */
    public EnumC5114a f13883R;

    /* JADX INFO: renamed from: S */
    public long f13884S;

    /* JADX INFO: renamed from: T */
    public int f13885T;

    /* JADX INFO: renamed from: U */
    public int f13886U;

    /* JADX INFO: renamed from: V */
    public int f13887V;

    /* JADX INFO: renamed from: W */
    public long f13888W;

    /* JADX INFO: renamed from: X */
    public int f13889X;

    /* JADX INFO: renamed from: Y */
    public int f13890Y;

    /* JADX INFO: renamed from: Z */
    public int f13891Z;

    /* JADX INFO: renamed from: a0 */
    public int f13892a0;

    /* JADX INFO: renamed from: b0 */
    public int f13893b0;

    /* JADX INFO: renamed from: c0 */
    public InterfaceC5213a f13894c0;

    /* JADX INFO: renamed from: o */
    public AbstractC5225a f13895o;

    /* JADX INFO: renamed from: p */
    public AbstractC5104c f13896p;

    /* JADX INFO: renamed from: q */
    public AbstractC5219d f13897q;

    /* JADX INFO: renamed from: r */
    public C5236b f13898r;

    /* JADX INFO: renamed from: s */
    public C5236b f13899s;

    /* JADX INFO: renamed from: t */
    public C5236b f13900t;

    /* JADX INFO: renamed from: u */
    public int f13901u;

    /* JADX INFO: renamed from: v */
    public boolean f13902v;

    /* JADX INFO: renamed from: w */
    public EnumC5119f f13903w;

    /* JADX INFO: renamed from: x */
    public EnumC5126m f13904x;

    /* JADX INFO: renamed from: y */
    public EnumC5125l f13905y;

    /* JADX INFO: renamed from: z */
    public EnumC5115b f13906z;

    /* JADX INFO: renamed from: b.o.a.n.g$a */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ EnumC5118e f13907j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ EnumC5118e f13908k;

        public a(EnumC5118e enumC5118e, EnumC5118e enumC5118e2) {
            this.f13907j = enumC5118e;
            this.f13908k = enumC5118e2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractC5133g.this.mo7205c(this.f13907j)) {
                AbstractC5133g.this.m7327X();
            } else {
                AbstractC5133g.this.f13881P = this.f13908k;
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
            AbstractC5133g.this.m7327X();
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$c */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class c implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C5113l.a f13911j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13912k;

        public c(C5113l.a aVar, boolean z2) {
            this.f13911j = aVar;
            this.f13912k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC5135i.f13918j.m7159a(1, "takePicture:", "running. isTakingPicture:", Boolean.valueOf(AbstractC5133g.this.m7275W0()));
            if (AbstractC5133g.this.m7275W0()) {
                return;
            }
            AbstractC5133g abstractC5133g = AbstractC5133g.this;
            if (abstractC5133g.f13882Q == EnumC5122i.VIDEO) {
                throw new IllegalStateException("Can't take hq pictures while in VIDEO mode");
            }
            C5113l.a aVar = this.f13911j;
            aVar.f13715a = false;
            aVar.f13716b = abstractC5133g.f13868C;
            aVar.f13719e = abstractC5133g.f13881P;
            aVar.f13721g = abstractC5133g.f13867B;
            abstractC5133g.mo7202Y0(aVar, this.f13912k);
        }
    }

    /* JADX INFO: renamed from: b.o.a.n.g$d */
    /* JADX INFO: compiled from: CameraBaseEngine.java */
    public class d implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C5113l.a f13914j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ boolean f13915k;

        public d(C5113l.a aVar, boolean z2) {
            this.f13914j = aVar;
            this.f13915k = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC5135i.f13918j.m7159a(1, "takePictureSnapshot:", "running. isTakingPicture:", Boolean.valueOf(AbstractC5133g.this.m7275W0()));
            if (AbstractC5133g.this.m7275W0()) {
                return;
            }
            C5113l.a aVar = this.f13914j;
            AbstractC5133g abstractC5133g = AbstractC5133g.this;
            aVar.f13716b = abstractC5133g.f13868C;
            aVar.f13715a = true;
            aVar.f13719e = abstractC5133g.f13881P;
            aVar.f13721g = EnumC5123j.JPEG;
            AbstractC5133g.this.mo7203Z0(this.f13914j, C5235a.m7448g(abstractC5133g.m7274U0(EnumC5171b.OUTPUT)), this.f13915k);
        }
    }

    public AbstractC5133g(@NonNull AbstractC5135i.g gVar) {
        super(gVar);
        this.f13877L = new C5170a();
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
        C3404f.m4264Z(null);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: A */
    public final float mo7250A() {
        return this.f13874I;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: A0 */
    public final void mo7251A0(int i) {
        this.f13886U = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: B */
    public final boolean mo7252B() {
        return this.f13875J;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: B0 */
    public final void mo7253B0(@NonNull EnumC5125l enumC5125l) {
        this.f13905y = enumC5125l;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: C */
    public final C5236b mo7254C(@NonNull EnumC5171b enumC5171b) {
        C5236b c5236b = this.f13899s;
        if (c5236b == null) {
            return null;
        }
        return this.f13877L.m7357b(EnumC5171b.SENSOR, enumC5171b) ? c5236b.m7451f() : c5236b;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: C0 */
    public final void mo7255C0(int i) {
        this.f13885T = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: D */
    public final int mo7256D() {
        return this.f13890Y;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: D0 */
    public final void mo7257D0(long j) {
        this.f13884S = j;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: E */
    public final int mo7258E() {
        return this.f13889X;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: E0 */
    public final void mo7259E0(@NonNull InterfaceC5237c interfaceC5237c) {
        this.f13880O = interfaceC5237c;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: F */
    public final C5236b mo7260F(@NonNull EnumC5171b enumC5171b) {
        C5236b c5236bMo7254C = mo7254C(enumC5171b);
        if (c5236bMo7254C == null) {
            return null;
        }
        boolean zM7357b = this.f13877L.m7357b(enumC5171b, EnumC5171b.VIEW);
        int i = zM7357b ? this.f13890Y : this.f13889X;
        int i2 = zM7357b ? this.f13889X : this.f13890Y;
        if (i <= 0) {
            i = Integer.MAX_VALUE;
        }
        if (i2 <= 0) {
            i2 = Integer.MAX_VALUE;
        }
        HashMap<String, C5235a> map = C5235a.f14248j;
        float fM7450i = C5235a.m7447f(c5236bMo7254C.f14251j, c5236bMo7254C.f14252k).m7450i();
        if (C5235a.m7447f(i, i2).m7450i() >= fM7450i) {
            int iMin = Math.min(c5236bMo7254C.f14252k, i2);
            return new C5236b((int) Math.floor(iMin * fM7450i), iMin);
        }
        int iMin2 = Math.min(c5236bMo7254C.f14251j, i);
        return new C5236b(iMin2, (int) Math.floor(iMin2 / fM7450i));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: G */
    public final int mo7261G() {
        return this.f13886U;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: H */
    public final EnumC5125l mo7262H() {
        return this.f13905y;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: I */
    public final int mo7263I() {
        return this.f13885T;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: J */
    public final long mo7264J() {
        return this.f13884S;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: K */
    public final C5236b mo7265K(@NonNull EnumC5171b enumC5171b) {
        C5236b c5236b = this.f13898r;
        if (c5236b == null || this.f13882Q == EnumC5122i.PICTURE) {
            return null;
        }
        return this.f13877L.m7357b(EnumC5171b.SENSOR, enumC5171b) ? c5236b.m7451f() : c5236b;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: L */
    public final InterfaceC5237c mo7266L() {
        return this.f13880O;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: M */
    public final EnumC5126m mo7267M() {
        return this.f13904x;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: N */
    public final float mo7268N() {
        return this.f13869D;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: O0 */
    public void mo7269O0(@NonNull C5113l.a aVar) {
        boolean z2 = this.f13872G;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("take picture", true, new RunnableC5181h(c5179f, EnumC5178e.BIND, new c(aVar, z2)));
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: P0 */
    public void mo7270P0(@NonNull C5113l.a aVar) {
        boolean z2 = this.f13873H;
        C5179f c5179f = this.f13922n;
        c5179f.m7363b("take picture snapshot", true, new RunnableC5181h(c5179f, EnumC5178e.BIND, new d(aVar, z2)));
    }

    @NonNull
    /* JADX INFO: renamed from: Q0 */
    public final C5236b m7271Q0(@NonNull EnumC5122i enumC5122i) {
        InterfaceC5237c interfaceC5237c;
        Set setUnmodifiableSet;
        boolean zM7357b = this.f13877L.m7357b(EnumC5171b.SENSOR, EnumC5171b.VIEW);
        if (enumC5122i == EnumC5122i.PICTURE) {
            interfaceC5237c = this.f13879N;
            setUnmodifiableSet = Collections.unmodifiableSet(this.f13896p.f13686e);
        } else {
            interfaceC5237c = this.f13880O;
            setUnmodifiableSet = Collections.unmodifiableSet(this.f13896p.f13687f);
        }
        InterfaceC5237c interfaceC5237cM4238Q0 = C3404f.m4238Q0(interfaceC5237c, new C5239e());
        ArrayList arrayList = new ArrayList(setUnmodifiableSet);
        C5236b c5236b = ((C5246l) interfaceC5237cM4238Q0).mo7452a(arrayList).get(0);
        if (!arrayList.contains(c5236b)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        AbstractC5135i.f13918j.m7159a(1, "computeCaptureSize:", "result:", c5236b, "flip:", Boolean.valueOf(zM7357b), "mode:", enumC5122i);
        return zM7357b ? c5236b.m7451f() : c5236b;
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
    /* JADX INFO: renamed from: R0 */
    public final C5236b m7272R0() {
        EnumC5171b enumC5171b = EnumC5171b.VIEW;
        List<C5236b> listMo7198T0 = mo7198T0();
        boolean zM7357b = this.f13877L.m7357b(EnumC5171b.SENSOR, enumC5171b);
        ArrayList arrayList = new ArrayList(listMo7198T0.size());
        for (C5236b c5236bM7451f : listMo7198T0) {
            if (zM7357b) {
                c5236bM7451f = c5236bM7451f.m7451f();
            }
            arrayList.add(c5236bM7451f);
        }
        C5236b c5236bM7274U0 = m7274U0(enumC5171b);
        if (c5236bM7274U0 == null) {
            throw new IllegalStateException("targetMinSize should not be null here.");
        }
        C5236b c5236b = this.f13898r;
        C5235a c5235aM7447f = C5235a.m7447f(c5236b.f14251j, c5236b.f14252k);
        if (zM7357b) {
            c5235aM7447f = C5235a.m7447f(c5235aM7447f.f14250l, c5235aM7447f.f14249k);
        }
        C5103b c5103b = AbstractC5135i.f13918j;
        c5103b.m7159a(1, "computePreviewStreamSize:", "targetRatio:", c5235aM7447f, "targetMinSize:", c5236bM7274U0);
        InterfaceC5237c interfaceC5237cM4291g = C3404f.m4291g(C3404f.m4200D1(new C5238d(c5235aM7447f.m7450i(), 0.0f)), new C5239e());
        InterfaceC5237c interfaceC5237cM4291g2 = C3404f.m4291g(C3404f.m4226M0(c5236bM7274U0.f14252k), C3404f.m4229N0(c5236bM7274U0.f14251j), new C5240f());
        InterfaceC5237c interfaceC5237cM4238Q0 = C3404f.m4238Q0(C3404f.m4291g(interfaceC5237cM4291g, interfaceC5237cM4291g2), interfaceC5237cM4291g2, interfaceC5237cM4291g, new C5239e());
        InterfaceC5237c interfaceC5237c = this.f13878M;
        if (interfaceC5237c != null) {
            interfaceC5237cM4238Q0 = C3404f.m4238Q0(interfaceC5237c, interfaceC5237cM4238Q0);
        }
        C5236b c5236bM7451f2 = ((C5246l) interfaceC5237cM4238Q0).mo7452a(arrayList).get(0);
        if (!arrayList.contains(c5236bM7451f2)) {
            throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
        }
        if (zM7357b) {
            c5236bM7451f2 = c5236bM7451f2.m7451f();
        }
        c5103b.m7159a(1, "computePreviewStreamSize:", "result:", c5236bM7451f2, "flip:", Boolean.valueOf(zM7357b));
        return c5236bM7451f2;
    }

    @NonNull
    /* JADX INFO: renamed from: S0 */
    public AbstractC5190c m7273S0() {
        if (this.f13876K == null) {
            this.f13876K = mo7200V0(this.f13893b0);
        }
        return this.f13876K;
    }

    @NonNull
    /* JADX INFO: renamed from: T0 */
    public abstract List<C5236b> mo7198T0();

    @Nullable
    /* JADX INFO: renamed from: U0 */
    public final C5236b m7274U0(@NonNull EnumC5171b enumC5171b) {
        AbstractC5225a abstractC5225a = this.f13895o;
        if (abstractC5225a == null) {
            return null;
        }
        return this.f13877L.m7357b(EnumC5171b.VIEW, enumC5171b) ? abstractC5225a.m7432l().m7451f() : abstractC5225a.m7432l();
    }

    @NonNull
    /* JADX INFO: renamed from: V0 */
    public abstract AbstractC5190c mo7200V0(int i);

    /* JADX INFO: renamed from: W0 */
    public final boolean m7275W0() {
        return this.f13897q != null;
    }

    /* JADX INFO: renamed from: X0 */
    public abstract void mo7201X0();

    /* JADX INFO: renamed from: Y0 */
    public abstract void mo7202Y0(@NonNull C5113l.a aVar, boolean z2);

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: Z */
    public final void mo7276Z(@NonNull EnumC5114a enumC5114a) {
        if (this.f13883R != enumC5114a) {
            this.f13883R = enumC5114a;
        }
    }

    /* JADX INFO: renamed from: Z0 */
    public abstract void mo7203Z0(@NonNull C5113l.a aVar, @NonNull C5235a c5235a, boolean z2);

    /* JADX INFO: renamed from: a */
    public void mo7227a(@Nullable C5113l.a aVar, @Nullable Exception exc) {
        this.f13897q = null;
        if (aVar == null) {
            AbstractC5135i.f13918j.m7159a(3, "onPictureResult", "result is null: something went wrong.", exc);
            ((CameraView.C11195b) this.f13921m).m9311a(new CameraException(exc, 4));
        } else {
            CameraView.C11195b c11195b = (CameraView.C11195b) this.f13921m;
            c11195b.f22141b.m7159a(1, "dispatchOnPictureTaken", aVar);
            CameraView.this.f22133u.post(new RunnableC5110i(c11195b, aVar));
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: a0 */
    public final void mo7277a0(int i) {
        this.f13887V = i;
    }

    /* JADX INFO: renamed from: a1 */
    public final boolean m7278a1() {
        long j = this.f13888W;
        return j > 0 && j != RecyclerView.FOREVER_NS;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: b0 */
    public final void mo7279b0(@NonNull EnumC5115b enumC5115b) {
        this.f13906z = enumC5115b;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: c0 */
    public final void mo7280c0(long j) {
        this.f13888W = j;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: e */
    public final C5170a mo7281e() {
        return this.f13877L;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: e0 */
    public final void mo7282e0(@NonNull EnumC5118e enumC5118e) {
        EnumC5118e enumC5118e2 = this.f13881P;
        if (enumC5118e != enumC5118e2) {
            this.f13881P = enumC5118e;
            C5179f c5179f = this.f13922n;
            c5179f.m7363b("facing", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new a(enumC5118e, enumC5118e2)));
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: f */
    public final EnumC5114a mo7283f() {
        return this.f13883R;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: g */
    public final int mo7284g() {
        return this.f13887V;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: h */
    public final EnumC5115b mo7285h() {
        return this.f13906z;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: h0 */
    public final void mo7286h0(int i) {
        this.f13892a0 = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: i */
    public final long mo7287i() {
        return this.f13888W;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: i0 */
    public final void mo7288i0(int i) {
        this.f13891Z = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: j */
    public final AbstractC5104c mo7289j() {
        return this.f13896p;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: j0 */
    public final void mo7290j0(int i) {
        this.f13893b0 = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: k */
    public final float mo7291k() {
        return this.f13870E;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: l */
    public final EnumC5118e mo7292l() {
        return this.f13881P;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: m */
    public final EnumC5119f mo7293m() {
        return this.f13903w;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: n */
    public final int mo7294n() {
        return this.f13901u;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: n0 */
    public final void mo7295n0(@NonNull EnumC5122i enumC5122i) {
        if (enumC5122i != this.f13882Q) {
            this.f13882Q = enumC5122i;
            C5179f c5179f = this.f13922n;
            c5179f.m7363b("mode", true, new RunnableC5181h(c5179f, EnumC5178e.ENGINE, new b()));
        }
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: o */
    public final int mo7296o() {
        return this.f13892a0;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: o0 */
    public final void mo7297o0(@Nullable InterfaceC5213a interfaceC5213a) {
        this.f13894c0 = interfaceC5213a;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: p */
    public final int mo7298p() {
        return this.f13891Z;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: q */
    public final int mo7299q() {
        return this.f13893b0;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: q0 */
    public final void mo7300q0(boolean z2) {
        this.f13872G = z2;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: r */
    public final EnumC5121h mo7301r() {
        return this.f13866A;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: r0 */
    public final void mo7302r0(@NonNull InterfaceC5237c interfaceC5237c) {
        this.f13879N = interfaceC5237c;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: s */
    public final Location mo7303s() {
        return this.f13868C;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: s0 */
    public final void mo7304s0(boolean z2) {
        this.f13873H = z2;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: t */
    public final EnumC5122i mo7305t() {
        return this.f13882Q;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: u */
    public final EnumC5123j mo7306u() {
        return this.f13867B;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: u0 */
    public final void mo7307u0(@NonNull AbstractC5225a abstractC5225a) {
        AbstractC5225a abstractC5225a2 = this.f13895o;
        if (abstractC5225a2 != null) {
            abstractC5225a2.m7440t(null);
        }
        this.f13895o = abstractC5225a;
        abstractC5225a.m7440t(this);
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: v */
    public final boolean mo7308v() {
        return this.f13872G;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @Nullable
    /* JADX INFO: renamed from: w */
    public final C5236b mo7309w(@NonNull EnumC5171b enumC5171b) {
        C5236b c5236b = this.f13898r;
        if (c5236b == null || this.f13882Q == EnumC5122i.VIDEO) {
            return null;
        }
        return this.f13877L.m7357b(EnumC5171b.SENSOR, enumC5171b) ? c5236b.m7451f() : c5236b;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: w0 */
    public final void mo7310w0(boolean z2) {
        this.f13875J = z2;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: x */
    public final InterfaceC5237c mo7311x() {
        return this.f13879N;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: x0 */
    public final void mo7312x0(@Nullable InterfaceC5237c interfaceC5237c) {
        this.f13878M = interfaceC5237c;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: y */
    public final boolean mo7313y() {
        return this.f13873H;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: y0 */
    public final void mo7314y0(int i) {
        this.f13890Y = i;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    @NonNull
    /* JADX INFO: renamed from: z */
    public final AbstractC5225a mo7315z() {
        return this.f13895o;
    }

    @Override // p007b.p452o.p453a.p455n.AbstractC5135i
    /* JADX INFO: renamed from: z0 */
    public final void mo7316z0(int i) {
        this.f13889X = i;
    }
}
