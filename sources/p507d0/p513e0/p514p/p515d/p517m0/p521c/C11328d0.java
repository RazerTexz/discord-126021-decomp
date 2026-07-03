package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11375h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11382k0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11387n;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11898h;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11930i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p580t.AbstractC12126c0;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0 */
/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11328d0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11905o f22685a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11325c0 f22686b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11898h<C11713b, InterfaceC11331e0> f22687c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11898h<a, InterfaceC11330e> f22688d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$a */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C11712a f22689a;

        /* JADX INFO: renamed from: b */
        public final List<Integer> f22690b;

        public a(C11712a c11712a, List<Integer> list) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            C12238m.checkNotNullParameter(list, "typeParametersCount");
            this.f22689a = c11712a;
            this.f22690b = list;
        }

        public final C11712a component1() {
            return this.f22689a;
        }

        public final List<Integer> component2() {
            return this.f22690b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C12238m.areEqual(this.f22689a, aVar.f22689a) && C12238m.areEqual(this.f22690b, aVar.f22690b);
        }

        public int hashCode() {
            return this.f22690b.hashCode() + (this.f22689a.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ClassRequest(classId=");
            sbM833U.append(this.f22689a);
            sbM833U.append(", typeParametersCount=");
            sbM833U.append(this.f22690b);
            sbM833U.append(')');
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$b */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class b extends AbstractC11375h {

        /* JADX INFO: renamed from: r */
        public final boolean f22691r;

        /* JADX INFO: renamed from: s */
        public final List<InterfaceC11477z0> f22692s;

        /* JADX INFO: renamed from: t */
        public final C11930i f22693t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC11905o interfaceC11905o, InterfaceC11450m interfaceC11450m, C11716e c11716e, boolean z2, int i) {
            super(interfaceC11905o, interfaceC11450m, c11716e, InterfaceC11467u0.f23099a, false);
            C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
            C12238m.checkNotNullParameter(interfaceC11450m, "container");
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f22691r = z2;
            IntRange intRangeUntil = C11226f.until(0, i);
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(intRangeUntil, 10));
            Iterator<Integer> it = intRangeUntil.iterator();
            while (it.hasNext()) {
                int iNextInt = ((AbstractC12126c0) it).nextInt();
                arrayList.add(C11382k0.createWithDefaultBound(this, InterfaceC11344g.f22735f.getEMPTY(), false, EnumC11935j1.INVARIANT, C11716e.identifier(C12238m.stringPlus(ExifInterface.GPS_DIRECTION_TRUE, Integer.valueOf(iNextInt))), iNextInt, interfaceC11905o));
            }
            this.f22692s = arrayList;
            this.f22693t = new C11930i(this, C11320a1.computeConstructorTypeParameters(this), C12146m0.setOf(C11836a.getModule(this).getBuiltIns().getAnyType()), interfaceC11905o);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
        public InterfaceC11344g getAnnotations() {
            return InterfaceC11344g.f22735f.getEMPTY();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public InterfaceC11330e getCompanionObjectDescriptor() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public Collection<InterfaceC11327d> getConstructors() {
            return C12148n0.emptySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
        public List<InterfaceC11477z0> getDeclaredTypeParameters() {
            return this.f22692s;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public EnumC11333f getKind() {
            return EnumC11333f.CLASS;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
        public EnumC11476z getModality() {
            return EnumC11476z.FINAL;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public Collection<InterfaceC11330e> getSealedSubclasses() {
            return C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
        public InterfaceC11770i getUnsubstitutedMemberScope(AbstractC11947g abstractC11947g) {
            C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
            return InterfaceC11770i.b.f24373b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public InterfaceC11327d getUnsubstitutedPrimaryConstructor() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11458q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
        public AbstractC11466u getVisibility() {
            AbstractC11466u abstractC11466u = C11464t.f23087e;
            C12238m.checkNotNullExpressionValue(abstractC11466u, "PUBLIC");
            return abstractC11466u;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
        public boolean isActual() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public boolean isCompanionObject() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public boolean isData() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
        public boolean isExpect() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11375h, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
        public boolean isExternal() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public boolean isFun() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public boolean isInline() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i
        public boolean isInner() {
            return this.f22691r;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public boolean isValue() {
            return false;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("class ");
            sbM833U.append(getName());
            sbM833U.append(" (not found)");
            return sbM833U.toString();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e
        public InterfaceC11770i.b getStaticScope() {
            return InterfaceC11770i.b.f24373b;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
        public C11930i getTypeConstructor() {
            return this.f22693t;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$c */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class c extends AbstractC12240o implements Function1<a, InterfaceC11330e> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11330e invoke(a aVar) {
            C12238m.checkNotNullParameter(aVar, "$dstr$classId$typeParametersCount");
            C11712a c11712aComponent1 = aVar.component1();
            List<Integer> listComponent2 = aVar.component2();
            if (c11712aComponent1.isLocal()) {
                throw new UnsupportedOperationException(C12238m.stringPlus("Unresolved local class: ", c11712aComponent1));
            }
            C11712a outerClassId = c11712aComponent1.getOuterClassId();
            InterfaceC11336g interfaceC11336g = outerClassId == null ? null : C11328d0.this.getClass(outerClassId, C12163u.drop(listComponent2, 1));
            if (interfaceC11336g == null) {
                InterfaceC11898h interfaceC11898h = C11328d0.this.f22687c;
                C11713b packageFqName = c11712aComponent1.getPackageFqName();
                C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
                interfaceC11336g = (InterfaceC11336g) ((C11896f.m) interfaceC11898h).invoke(packageFqName);
            }
            InterfaceC11336g interfaceC11336g2 = interfaceC11336g;
            boolean zIsNestedClass = c11712aComponent1.isNestedClass();
            InterfaceC11905o interfaceC11905o = C11328d0.this.f22685a;
            C11716e shortClassName = c11712aComponent1.getShortClassName();
            C12238m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            Integer num = (Integer) C12163u.firstOrNull((List) listComponent2);
            return new b(interfaceC11905o, interfaceC11336g2, shortClassName, zIsNestedClass, num == null ? 0 : num.intValue());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.d0$d */
    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class d extends AbstractC12240o implements Function1<C11713b, InterfaceC11331e0> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11331e0 invoke(C11713b c11713b) {
            C12238m.checkNotNullParameter(c11713b, "fqName");
            return new C11387n(C11328d0.this.f22686b, c11713b);
        }
    }

    public C11328d0(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        this.f22685a = interfaceC11905o;
        this.f22686b = interfaceC11325c0;
        this.f22687c = interfaceC11905o.createMemoizedFunction(new d());
        this.f22688d = interfaceC11905o.createMemoizedFunction(new c());
    }

    public final InterfaceC11330e getClass(C11712a c11712a, List<Integer> list) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        C12238m.checkNotNullParameter(list, "typeParametersCount");
        return (InterfaceC11330e) ((C11896f.m) this.f22688d).invoke(new a(c11712a, list));
    }
}
