package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.C11529g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11566b;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11572e;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11580m;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.i */
/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11506i extends C11499b {

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ KProperty<Object>[] f23247g = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11506i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: h */
    public final InterfaceC11900j f23248h;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.g0.i$a */
    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    public static final class a extends AbstractC12240o implements Function0<Map<C11716e, ? extends AbstractC11815g<? extends Object>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<C11716e, ? extends AbstractC11815g<? extends Object>> invoke() {
            AbstractC11815g<?> abstractC11815gMapJavaTargetArguments$descriptors_jvm;
            InterfaceC11566b interfaceC11566b = C11506i.this.f23227e;
            if (interfaceC11566b instanceof InterfaceC11572e) {
                abstractC11815gMapJavaTargetArguments$descriptors_jvm = C11501d.f23236a.mapJavaTargetArguments$descriptors_jvm(((InterfaceC11572e) interfaceC11566b).getElements());
            } else {
                abstractC11815gMapJavaTargetArguments$descriptors_jvm = interfaceC11566b instanceof InterfaceC11580m ? C11501d.f23236a.mapJavaTargetArguments$descriptors_jvm(C12145m.listOf(interfaceC11566b)) : null;
            }
            Map<C11716e, ? extends AbstractC11815g<? extends Object>> mapMapOf = abstractC11815gMapJavaTargetArguments$descriptors_jvm != null ? C12134g0.mapOf(C12116o.m10073to(C11500c.f23230a.getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm(), abstractC11815gMapJavaTargetArguments$descriptors_jvm)) : null;
            return mapMapOf != null ? mapMapOf : C12136h0.emptyMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11506i(InterfaceC11564a interfaceC11564a, C11529g c11529g) {
        super(c11529g, interfaceC11564a, C11291k.a.f22504A);
        C12238m.checkNotNullParameter(interfaceC11564a, "annotation");
        C12238m.checkNotNullParameter(c11529g, "c");
        this.f23248h = c11529g.getStorageManager().createLazyValue(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.C11499b, p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c
    public Map<C11716e, AbstractC11815g<Object>> getAllValueArguments() {
        return (Map) C11904n.getValue(this.f23248h, this, (KProperty<?>) f23247g[0]);
    }
}
