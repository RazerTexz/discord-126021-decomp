package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y */
/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11889y {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11704c f24691a;

    /* JADX INFO: renamed from: b */
    public final C11708g f24692b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11467u0 f24693c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$a */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class a extends AbstractC11889y {

        /* JADX INFO: renamed from: d */
        public final C11678c f24694d;

        /* JADX INFO: renamed from: e */
        public final a f24695e;

        /* JADX INFO: renamed from: f */
        public final C11712a f24696f;

        /* JADX INFO: renamed from: g */
        public final C11678c.c f24697g;

        /* JADX INFO: renamed from: h */
        public final boolean f24698h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11678c c11678c, InterfaceC11704c interfaceC11704c, C11708g c11708g, InterfaceC11467u0 interfaceC11467u0, a aVar) {
            super(interfaceC11704c, c11708g, interfaceC11467u0, null);
            C12238m.checkNotNullParameter(c11678c, "classProto");
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(c11708g, "typeTable");
            this.f24694d = c11678c;
            this.f24695e = aVar;
            this.f24696f = C11887w.getClassId(interfaceC11704c, c11678c.getFqName());
            C11678c.c cVar = C11703b.f24034e.get(c11678c.getFlags());
            this.f24697g = cVar == null ? C11678c.c.CLASS : cVar;
            Boolean bool = C11703b.f24035f.get(c11678c.getFlags());
            C12238m.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
            this.f24698h = bool.booleanValue();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11889y
        public C11713b debugFqName() {
            C11713b c11713bAsSingleFqName = this.f24696f.asSingleFqName();
            C12238m.checkNotNullExpressionValue(c11713bAsSingleFqName, "classId.asSingleFqName()");
            return c11713bAsSingleFqName;
        }

        public final C11712a getClassId() {
            return this.f24696f;
        }

        public final C11678c getClassProto() {
            return this.f24694d;
        }

        public final C11678c.c getKind() {
            return this.f24697g;
        }

        public final a getOuterClass() {
            return this.f24695e;
        }

        public final boolean isInner() {
            return this.f24698h;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.y$b */
    /* JADX INFO: compiled from: ProtoContainer.kt */
    public static final class b extends AbstractC11889y {

        /* JADX INFO: renamed from: d */
        public final C11713b f24699d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11713b c11713b, InterfaceC11704c interfaceC11704c, C11708g c11708g, InterfaceC11467u0 interfaceC11467u0) {
            super(interfaceC11704c, c11708g, interfaceC11467u0, null);
            C12238m.checkNotNullParameter(c11713b, "fqName");
            C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
            C12238m.checkNotNullParameter(c11708g, "typeTable");
            this.f24699d = c11713b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.AbstractC11889y
        public C11713b debugFqName() {
            return this.f24699d;
        }
    }

    public AbstractC11889y(InterfaceC11704c interfaceC11704c, C11708g c11708g, InterfaceC11467u0 interfaceC11467u0, DefaultConstructorMarker defaultConstructorMarker) {
        this.f24691a = interfaceC11704c;
        this.f24692b = c11708g;
        this.f24693c = interfaceC11467u0;
    }

    public abstract C11713b debugFqName();

    public final InterfaceC11704c getNameResolver() {
        return this.f24691a;
    }

    public final InterfaceC11467u0 getSource() {
        return this.f24693c;
    }

    public final C11708g getTypeTable() {
        return this.f24692b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
