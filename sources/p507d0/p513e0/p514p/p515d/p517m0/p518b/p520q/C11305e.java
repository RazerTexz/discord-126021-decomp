package p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.InterfaceC11282b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11377i;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e */
/* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11305e implements InterfaceC11355b {

    /* JADX INFO: renamed from: a */
    public static final b f22631a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f22632b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11305e.class), "cloneable", "getCloneable()Lorg/jetbrains/kotlin/descriptors/impl/ClassDescriptorImpl;"))};

    /* JADX INFO: renamed from: c */
    public static final C11713b f22633c = C11291k.f22499l;

    /* JADX INFO: renamed from: d */
    public static final C11716e f22634d;

    /* JADX INFO: renamed from: e */
    public static final C11712a f22635e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC11325c0 f22636f;

    /* JADX INFO: renamed from: g */
    public final Function1<InterfaceC11325c0, InterfaceC11450m> f22637g;

    /* JADX INFO: renamed from: h */
    public final InterfaceC11900j f22638h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$a */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class a extends AbstractC12240o implements Function1<InterfaceC11325c0, InterfaceC11282b> {

        /* JADX INFO: renamed from: j */
        public static final a f22639j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11282b invoke(InterfaceC11325c0 interfaceC11325c0) {
            C12238m.checkNotNullParameter(interfaceC11325c0, "module");
            List<InterfaceC11331e0> fragments = interfaceC11325c0.getPackage(C11305e.f22633c).getFragments();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fragments) {
                if (obj instanceof InterfaceC11282b) {
                    arrayList.add(obj);
                }
            }
            return (InterfaceC11282b) C12163u.first((List) arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$b */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11712a getCLONEABLE_CLASS_ID() {
            return C11305e.f22635e;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.e$c */
    /* JADX INFO: compiled from: JvmBuiltInClassDescriptorFactory.kt */
    public static final class c extends AbstractC12240o implements Function0<C11377i> {
        public final /* synthetic */ InterfaceC11905o $storageManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(InterfaceC11905o interfaceC11905o) {
            super(0);
            this.$storageManager = interfaceC11905o;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11377i invoke() {
            C11377i c11377i = new C11377i((InterfaceC11450m) C11305e.this.f22637g.invoke(C11305e.this.f22636f), C11305e.f22634d, EnumC11476z.ABSTRACT, EnumC11333f.INTERFACE, C12145m.listOf(C11305e.this.f22636f.getBuiltIns().getAnyType()), InterfaceC11467u0.f23099a, false, this.$storageManager);
            c11377i.initialize(new C11301a(this.$storageManager, c11377i), C12148n0.emptySet(), null);
            return c11377i;
        }
    }

    static {
        C11714c c11714c = C11291k.a.f22536d;
        C11716e c11716eShortName = c11714c.shortName();
        C12238m.checkNotNullExpressionValue(c11716eShortName, "cloneable.shortName()");
        f22634d = c11716eShortName;
        C11712a c11712a = C11712a.topLevel(c11714c.toSafe());
        C12238m.checkNotNullExpressionValue(c11712a, "topLevel(StandardNames.FqNames.cloneable.toSafe())");
        f22635e = c11712a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11305e(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, Function1<? super InterfaceC11325c0, ? extends InterfaceC11450m> function1) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        C12238m.checkNotNullParameter(function1, "computeContainingDeclaration");
        this.f22636f = interfaceC11325c0;
        this.f22637g = function1;
        this.f22638h = interfaceC11905o.createLazyValue(new c(interfaceC11905o));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public InterfaceC11330e createClass(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        if (C12238m.areEqual(c11712a, f22631a.getCLONEABLE_CLASS_ID())) {
            return (C11377i) C11904n.getValue(this.f22638h, this, (KProperty<?>) f22632b[0]);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public Collection<InterfaceC11330e> getAllContributedClassesIfPossible(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        return C12238m.areEqual(c11713b, f22633c) ? C12146m0.setOf((C11377i) C11904n.getValue(this.f22638h, this, (KProperty<?>) f22632b[0])) : C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b
    public boolean shouldCreateClass(C11713b c11713b, C11716e c11716e) {
        C12238m.checkNotNullParameter(c11713b, "packageFqName");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12238m.areEqual(c11716e, f22634d) && C12238m.areEqual(c11713b, f22633c);
    }

    public /* synthetic */ C11305e(InterfaceC11905o interfaceC11905o, InterfaceC11325c0 interfaceC11325c0, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11905o, interfaceC11325c0, (i & 4) != 0 ? a.f22639j : function1);
    }
}
