package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.EnumC11508k;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11991o0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11994p0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.e */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11557e {

    /* JADX INFO: renamed from: a */
    public static final C11713b f23431a = new C11713b("java.lang.Class");

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.e$a */
    /* JADX INFO: compiled from: JavaTypeResolver.kt */
    public static final class a extends AbstractC12240o implements Function0<AbstractC11934j0> {
        public final /* synthetic */ InterfaceC11477z0 $this_getErasedUpperBound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11477z0 interfaceC11477z0) {
            super(0);
            this.$this_getErasedUpperBound = interfaceC11477z0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final AbstractC11934j0 invoke() {
            StringBuilder sbM833U = C1643a.m833U("Can't compute erased upper bound of type parameter `");
            sbM833U.append(this.$this_getErasedUpperBound);
            sbM833U.append('`');
            AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(sbM833U.toString());
            C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Can't compute erased upper bound of type parameter `$this`\")");
            return abstractC11934j0CreateErrorType;
        }
    }

    public static final AbstractC11913c0 getErasedUpperBound(InterfaceC11477z0 interfaceC11477z0, InterfaceC11477z0 interfaceC11477z1, Function0<? extends AbstractC11913c0> function0) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "<this>");
        C12238m.checkNotNullParameter(function0, "defaultValue");
        if (interfaceC11477z0 == interfaceC11477z1) {
            return function0.invoke();
        }
        List<AbstractC11913c0> upperBounds = interfaceC11477z0.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds, "upperBounds");
        AbstractC11913c0 abstractC11913c0 = (AbstractC11913c0) C12163u.first((List) upperBounds);
        if (abstractC11913c0.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11330e) {
            C12238m.checkNotNullExpressionValue(abstractC11913c0, "firstUpperBound");
            return C11992a.replaceArgumentsWithStarProjections(abstractC11913c0);
        }
        if (interfaceC11477z1 != null) {
            interfaceC11477z0 = interfaceC11477z1;
        }
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            InterfaceC11477z0 interfaceC11477z2 = (InterfaceC11477z0) declarationDescriptor;
            if (C12238m.areEqual(interfaceC11477z2, interfaceC11477z0)) {
                return function0.invoke();
            }
            List<AbstractC11913c0> upperBounds2 = interfaceC11477z2.getUpperBounds();
            C12238m.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            AbstractC11913c0 abstractC11913c1 = (AbstractC11913c0) C12163u.first((List) upperBounds2);
            if (abstractC11913c1.getConstructor().getDeclarationDescriptor() instanceof InterfaceC11330e) {
                C12238m.checkNotNullExpressionValue(abstractC11913c1, "nextUpperBound");
                return C11992a.replaceArgumentsWithStarProjections(abstractC11913c1);
            }
            declarationDescriptor = abstractC11913c1.getConstructor().getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static /* synthetic */ AbstractC11913c0 getErasedUpperBound$default(InterfaceC11477z0 interfaceC11477z0, InterfaceC11477z0 interfaceC11477z1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC11477z1 = null;
        }
        if ((i & 2) != 0) {
            function0 = new a(interfaceC11477z0);
        }
        return getErasedUpperBound(interfaceC11477z0, interfaceC11477z1, function0);
    }

    public static final InterfaceC12012w0 makeStarProjection(InterfaceC11477z0 interfaceC11477z0, C11553a c11553a) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "typeParameter");
        C12238m.checkNotNullParameter(c11553a, "attr");
        return c11553a.getHowThisTypeIsUsed() == EnumC11508k.SUPERTYPE ? new C12016y0(C11994p0.starProjectionType(interfaceC11477z0)) : new C11991o0(interfaceC11477z0);
    }

    public static final C11553a toAttributes(EnumC11508k enumC11508k, boolean z2, InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(enumC11508k, "<this>");
        return new C11553a(enumC11508k, null, z2, interfaceC11477z0, 2, null);
    }

    public static /* synthetic */ C11553a toAttributes$default(EnumC11508k enumC11508k, boolean z2, InterfaceC11477z0 interfaceC11477z0, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        if ((i & 2) != 0) {
            interfaceC11477z0 = null;
        }
        return toAttributes(enumC11508k, z2, interfaceC11477z0);
    }
}
