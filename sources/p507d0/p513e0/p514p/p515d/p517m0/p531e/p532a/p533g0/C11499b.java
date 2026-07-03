package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Collection;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11518i;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11499b implements InterfaceC11340c, InterfaceC11518i {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ KProperty<Object>[] f23223a = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11499b.class), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;"))};

    /* JADX INFO: renamed from: b */
    public final C11713b f23224b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11467u0 f23225c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11900j f23226d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC11566b f23227e;

    /* JADX INFO: renamed from: f */
    public final boolean f23228f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.b$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11934j0> {

        /* JADX INFO: renamed from: $c */
        public final /* synthetic */ C11529g f23229$c;
        public final /* synthetic */ C11499b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11529g c11529g, C11499b c11499b) {
            super(0);
            this.f23229$c = c11529g;
            this.this$0 = c11499b;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11934j0 invoke() {
            AbstractC11934j0 defaultType = this.f23229$c.getModule().getBuiltIns().getBuiltInClassByFqName(this.this$0.getFqName()).getDefaultType();
            C12238m.checkNotNullExpressionValue(defaultType, "c.module.builtIns.getBuiltInClassByFqName(fqName).defaultType");
            return defaultType;
        }
    }

    public C11499b(C11529g c11529g, InterfaceC11564a interfaceC11564a, C11713b c11713b) {
        Collection<InterfaceC11566b> arguments;
        C12238m.checkNotNullParameter(c11529g, "c");
        C12238m.checkNotNullParameter(c11713b, "fqName");
        this.f23224b = c11713b;
        InterfaceC11467u0 interfaceC11467u0Source = interfaceC11564a == null ? null : c11529g.getComponents().getSourceElementFactory().source(interfaceC11564a);
        if (interfaceC11467u0Source == null) {
            interfaceC11467u0Source = InterfaceC11467u0.f23099a;
            C12238m.checkNotNullExpressionValue(interfaceC11467u0Source, "NO_SOURCE");
        }
        this.f23225c = interfaceC11467u0Source;
        this.f23226d = c11529g.getStorageManager().createLazyValue(new a(c11529g, this));
        this.f23227e = (interfaceC11564a == null || (arguments = interfaceC11564a.getArguments()) == null) ? null : (InterfaceC11566b) C12163u.firstOrNull(arguments);
        this.f23228f = C12238m.areEqual(interfaceC11564a != null ? Boolean.valueOf(interfaceC11564a.isIdeExternalAnnotation()) : null, Boolean.TRUE);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public Map<C11716e, AbstractC11815g<?>> getAllValueArguments() {
        return C12136h0.emptyMap();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public C11713b getFqName() {
        return this.f23224b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public InterfaceC11467u0 getSource() {
        return this.f23225c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p534h0.InterfaceC11518i
    public boolean isIdeExternalAnnotation() {
        return this.f23228f;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public AbstractC11934j0 getType() {
        return (AbstractC11934j0) C11904n.getValue(this.f23226d, this, (KProperty<?>) f23223a[0]);
    }
}
