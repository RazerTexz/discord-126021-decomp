package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11336g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11489c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11627u;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.C11631y;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.EnumC11485a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11593z;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0.C11603i;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.EnumC12040h;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a */
/* JADX INFO: compiled from: context.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11523a {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a$a */
    /* JADX INFO: compiled from: context.kt */
    public static final class a extends AbstractC12240o implements Function0<C11631y> {
        public final /* synthetic */ InterfaceC11336g $containingDeclaration;
        public final /* synthetic */ C11529g $this_childForClassOrPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11529g c11529g, InterfaceC11336g interfaceC11336g) {
            super(0);
            this.$this_childForClassOrPackage = c11529g;
            this.$containingDeclaration = interfaceC11336g;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11631y invoke() {
            return C11523a.computeNewDefaultTypeQualifiers(this.$this_childForClassOrPackage, this.$containingDeclaration.getAnnotations());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.a$b */
    /* JADX INFO: compiled from: context.kt */
    public static final class b extends AbstractC12240o implements Function0<C11631y> {
        public final /* synthetic */ InterfaceC11344g $additionalAnnotations;
        public final /* synthetic */ C11529g $this_copyWithNewDefaultTypeQualifiers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C11529g c11529g, InterfaceC11344g interfaceC11344g) {
            super(0);
            this.$this_copyWithNewDefaultTypeQualifiers = c11529g;
            this.$additionalAnnotations = interfaceC11344g;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final C11631y invoke() {
            return C11523a.computeNewDefaultTypeQualifiers(this.$this_copyWithNewDefaultTypeQualifiers, this.$additionalAnnotations);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final C11529g m9460a(C11529g c11529g, InterfaceC11450m interfaceC11450m, InterfaceC11593z interfaceC11593z, int i, Lazy<C11631y> lazy) {
        C11524b components = c11529g.getComponents();
        InterfaceC11533k c11530h = interfaceC11593z == null ? null : new C11530h(c11529g, interfaceC11450m, interfaceC11593z, i);
        if (c11530h == null) {
            c11530h = c11529g.getTypeParameterResolver();
        }
        return new C11529g(components, c11530h, lazy);
    }

    public static final C11529g child(C11529g c11529g, InterfaceC11533k interfaceC11533k) {
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(interfaceC11533k, "typeParameterResolver");
        return new C11529g(c11529g.getComponents(), interfaceC11533k, c11529g.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static final C11529g childForClassOrPackage(C11529g c11529g, InterfaceC11336g interfaceC11336g, InterfaceC11593z interfaceC11593z, int i) {
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(interfaceC11336g, "containingDeclaration");
        return m9460a(c11529g, interfaceC11336g, interfaceC11593z, i, C12083g.lazy(EnumC12110i.NONE, new a(c11529g, interfaceC11336g)));
    }

    public static /* synthetic */ C11529g childForClassOrPackage$default(C11529g c11529g, InterfaceC11336g interfaceC11336g, InterfaceC11593z interfaceC11593z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC11593z = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForClassOrPackage(c11529g, interfaceC11336g, interfaceC11593z, i);
    }

    public static final C11529g childForMethod(C11529g c11529g, InterfaceC11450m interfaceC11450m, InterfaceC11593z interfaceC11593z, int i) {
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11593z, "typeParameterOwner");
        return m9460a(c11529g, interfaceC11450m, interfaceC11593z, i, c11529g.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }

    public static /* synthetic */ C11529g childForMethod$default(C11529g c11529g, InterfaceC11450m interfaceC11450m, InterfaceC11593z interfaceC11593z, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return childForMethod(c11529g, interfaceC11450m, interfaceC11593z, i);
    }

    public static final C11631y computeNewDefaultTypeQualifiers(C11529g c11529g, InterfaceC11344g interfaceC11344g) {
        boolean z2;
        EnumMap enumMap;
        EnumMap<EnumC11485a, C11627u> defaultQualifiers;
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(interfaceC11344g, "additionalAnnotations");
        if (c11529g.getComponents().getJavaTypeEnhancementState().getDisabledDefaultAnnotations()) {
            return c11529g.getDefaultTypeQualifiers();
        }
        ArrayList<C11627u> arrayList = new ArrayList();
        Iterator<InterfaceC11340c> it = interfaceC11344g.iterator();
        while (true) {
            z2 = false;
            enumMap = null;
            c11627u = null;
            c11627u = null;
            C11627u c11627u = null;
            enumMap = null;
            if (!it.hasNext()) {
                break;
            }
            InterfaceC11340c next = it.next();
            C11489c annotationTypeQualifierResolver = c11529g.getComponents().getAnnotationTypeQualifierResolver();
            C11627u c11627uResolveQualifierBuiltInDefaultAnnotation = annotationTypeQualifierResolver.resolveQualifierBuiltInDefaultAnnotation(next);
            if (c11627uResolveQualifierBuiltInDefaultAnnotation == null) {
                C11489c.a aVarResolveTypeQualifierDefaultAnnotation = annotationTypeQualifierResolver.resolveTypeQualifierDefaultAnnotation(next);
                if (aVarResolveTypeQualifierDefaultAnnotation != null) {
                    InterfaceC11340c interfaceC11340cComponent1 = aVarResolveTypeQualifierDefaultAnnotation.component1();
                    List<EnumC11485a> listComponent2 = aVarResolveTypeQualifierDefaultAnnotation.component2();
                    EnumC12040h enumC12040hResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305CustomState(next);
                    if (enumC12040hResolveJsr305CustomState == null) {
                        enumC12040hResolveJsr305CustomState = annotationTypeQualifierResolver.resolveJsr305AnnotationState(interfaceC11340cComponent1);
                    }
                    if (!enumC12040hResolveJsr305CustomState.isIgnore()) {
                        C11603i c11603iExtractNullability = c11529g.getComponents().getSignatureEnhancement().extractNullability(interfaceC11340cComponent1, c11529g.getComponents().getSettings().getTypeEnhancementImprovements(), false);
                        C11603i c11603iCopy$default = c11603iExtractNullability == null ? null : C11603i.copy$default(c11603iExtractNullability, null, enumC12040hResolveJsr305CustomState.isWarning(), 1, null);
                        if (c11603iCopy$default != null) {
                            c11627u = new C11627u(c11603iCopy$default, listComponent2, false, 4, null);
                        }
                    }
                }
            } else {
                c11627u = c11627uResolveQualifierBuiltInDefaultAnnotation;
            }
            if (c11627u != null) {
                arrayList.add(c11627u);
            }
        }
        if (arrayList.isEmpty()) {
            return c11529g.getDefaultTypeQualifiers();
        }
        C11631y defaultTypeQualifiers = c11529g.getDefaultTypeQualifiers();
        if (defaultTypeQualifiers != null && (defaultQualifiers = defaultTypeQualifiers.getDefaultQualifiers()) != null) {
            enumMap = new EnumMap((EnumMap) defaultQualifiers);
        }
        if (enumMap == null) {
            enumMap = new EnumMap(EnumC11485a.class);
        }
        for (C11627u c11627u2 : arrayList) {
            Iterator<EnumC11485a> it2 = c11627u2.getQualifierApplicabilityTypes().iterator();
            while (it2.hasNext()) {
                enumMap.put(it2.next(), c11627u2);
                z2 = true;
            }
        }
        return !z2 ? c11529g.getDefaultTypeQualifiers() : new C11631y(enumMap);
    }

    public static final C11529g copyWithNewDefaultTypeQualifiers(C11529g c11529g, InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(interfaceC11344g, "additionalAnnotations");
        return interfaceC11344g.isEmpty() ? c11529g : new C11529g(c11529g.getComponents(), c11529g.getTypeParameterResolver(), C12083g.lazy(EnumC12110i.NONE, new b(c11529g, interfaceC11344g)));
    }

    public static final C11529g replaceComponents(C11529g c11529g, C11524b c11524b) {
        C12238m.checkNotNullParameter(c11529g, "<this>");
        C12238m.checkNotNullParameter(c11524b, "components");
        return new C11529g(c11524b, c11529g.getTypeParameterResolver(), c11529g.getDelegateForDefaultTypeQualifiers$descriptors_jvm());
    }
}
