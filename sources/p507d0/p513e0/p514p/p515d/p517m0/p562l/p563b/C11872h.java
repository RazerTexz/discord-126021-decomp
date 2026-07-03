package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11353h0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11859d;
import p507d0.p580t.C12146m0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h */
/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11872h {

    /* JADX INFO: renamed from: a */
    public static final b f24629a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final Set<C11712a> f24630b = C12146m0.setOf(C11712a.topLevel(C11291k.a.f22536d.toSafe()));

    /* JADX INFO: renamed from: c */
    public final C11874j f24631c;

    /* JADX INFO: renamed from: d */
    public final Function1<a, InterfaceC11330e> f24632d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$a */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C11712a f24633a;

        /* JADX INFO: renamed from: b */
        public final C11870f f24634b;

        public a(C11712a c11712a, C11870f c11870f) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            this.f24633a = c11712a;
            this.f24634b = c11870f;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && C12238m.areEqual(this.f24633a, ((a) obj).f24633a);
        }

        public final C11870f getClassData() {
            return this.f24634b;
        }

        public final C11712a getClassId() {
            return this.f24633a;
        }

        public int hashCode() {
            return this.f24633a.hashCode();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$b */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final Set<C11712a> getBLACK_LIST() {
            return C11872h.f24630b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.h$c */
    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class c extends AbstractC12240o implements Function1<a, InterfaceC11330e> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11330e invoke(a aVar) {
            C12238m.checkNotNullParameter(aVar, "key");
            return C11872h.access$createClass(C11872h.this, aVar);
        }
    }

    public C11872h(C11874j c11874j) {
        C12238m.checkNotNullParameter(c11874j, "components");
        this.f24631c = c11874j;
        this.f24632d = c11874j.getStorageManager().createMemoizedFunctionWithNullableValues(new c());
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    public static final InterfaceC11330e access$createClass(C11872h c11872h, a aVar) {
        Object next;
        C11876l c11876lCreateContext;
        boolean z2;
        Objects.requireNonNull(c11872h);
        C11712a classId = aVar.getClassId();
        Iterator<InterfaceC11355b> it = c11872h.f24631c.getFictitiousClassDescriptorFactories().iterator();
        while (it.hasNext()) {
            InterfaceC11330e interfaceC11330eCreateClass = it.next().createClass(classId);
            if (interfaceC11330eCreateClass != null) {
                return interfaceC11330eCreateClass;
            }
        }
        if (f24629a.getBLACK_LIST().contains(classId)) {
            return null;
        }
        C11870f classData = aVar.getClassData();
        if (classData == null && (classData = c11872h.f24631c.getClassDataFinder().findClassData(classId)) == null) {
            return null;
        }
        InterfaceC11704c interfaceC11704cComponent1 = classData.component1();
        C11678c c11678cComponent2 = classData.component2();
        AbstractC11702a abstractC11702aComponent3 = classData.component3();
        InterfaceC11467u0 interfaceC11467u0Component4 = classData.component4();
        C11712a outerClassId = classId.getOuterClassId();
        if (outerClassId != null) {
            InterfaceC11330e interfaceC11330eDeserializeClass$default = deserializeClass$default(c11872h, outerClassId, null, 2, null);
            C11859d c11859d = interfaceC11330eDeserializeClass$default instanceof C11859d ? (C11859d) interfaceC11330eDeserializeClass$default : null;
            if (c11859d == null) {
                return null;
            }
            C11716e shortClassName = classId.getShortClassName();
            C12238m.checkNotNullExpressionValue(shortClassName, "classId.shortClassName");
            if (!c11859d.hasNestedClass$deserialization(shortClassName)) {
                return null;
            }
            c11876lCreateContext = c11859d.getC();
        } else {
            InterfaceC11334f0 packageFragmentProvider = c11872h.f24631c.getPackageFragmentProvider();
            C11713b packageFqName = classId.getPackageFqName();
            C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            Iterator<T> it2 = C11353h0.packageFragments(packageFragmentProvider, packageFqName).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                InterfaceC11331e0 interfaceC11331e0 = (InterfaceC11331e0) next;
                if (interfaceC11331e0 instanceof AbstractC11878n) {
                    C11716e shortClassName2 = classId.getShortClassName();
                    C12238m.checkNotNullExpressionValue(shortClassName2, "classId.shortClassName");
                    if (((AbstractC11878n) interfaceC11331e0).hasTopLevelClass(shortClassName2)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
            } while (!z2);
            InterfaceC11331e0 interfaceC11331e1 = (InterfaceC11331e0) next;
            if (interfaceC11331e1 == null) {
                return null;
            }
            C11874j c11874j = c11872h.f24631c;
            C11695t typeTable = c11678cComponent2.getTypeTable();
            C12238m.checkNotNullExpressionValue(typeTable, "classProto.typeTable");
            C11708g c11708g = new C11708g(typeTable);
            C11710i.a aVar2 = C11710i.f24073a;
            C11698w versionRequirementTable = c11678cComponent2.getVersionRequirementTable();
            C12238m.checkNotNullExpressionValue(versionRequirementTable, "classProto.versionRequirementTable");
            c11876lCreateContext = c11874j.createContext(interfaceC11331e1, interfaceC11704cComponent1, c11708g, aVar2.create(versionRequirementTable), abstractC11702aComponent3, null);
        }
        return new C11859d(c11876lCreateContext, c11678cComponent2, interfaceC11704cComponent1, abstractC11702aComponent3, interfaceC11467u0Component4);
    }

    public static /* synthetic */ InterfaceC11330e deserializeClass$default(C11872h c11872h, C11712a c11712a, C11870f c11870f, int i, Object obj) {
        if ((i & 2) != 0) {
            c11870f = null;
        }
        return c11872h.deserializeClass(c11712a, c11870f);
    }

    public final InterfaceC11330e deserializeClass(C11712a c11712a, C11870f c11870f) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        return this.f24632d.invoke(new a(c11712a, c11870f));
    }
}
