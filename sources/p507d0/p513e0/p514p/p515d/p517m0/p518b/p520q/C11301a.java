package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11766e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a */
/* JADX INFO: compiled from: CloneableClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11301a extends AbstractC11766e {

    /* JADX INFO: renamed from: e */
    public static final a f22610e = new a(null);

    /* JADX INFO: renamed from: f */
    public static final C11716e f22611f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.a$a */
    /* JADX INFO: compiled from: CloneableClassScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11716e getCLONE_NAME() {
            return C11301a.f22611f;
        }
    }

    static {
        C11716e c11716eIdentifier = C11716e.identifier("clone");
        C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(\"clone\")");
        f22611f = c11716eIdentifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11301a(InterfaceC11905o interfaceC11905o, InterfaceC11330e interfaceC11330e) {
        super(interfaceC11905o, interfaceC11330e);
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11330e, "containingClass");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11766e
    /* JADX INFO: renamed from: a */
    public List<InterfaceC11472x> mo9372a() {
        C11374g0 c11374g0Create = C11374g0.create(this.f24363c, InterfaceC11344g.f22735f.getEMPTY(), f22610e.getCLONE_NAME(), InterfaceC11321b.a.DECLARATION, InterfaceC11467u0.f23099a);
        c11374g0Create.initialize((InterfaceC11459q0) null, this.f24363c.getThisAsReceiverParameter(), C12147n.emptyList(), C12147n.emptyList(), (AbstractC11913c0) C11836a.getBuiltIns(this.f24363c).getAnyType(), EnumC11476z.OPEN, C11464t.f23085c);
        return C12145m.listOf(c11374g0Create);
    }
}
