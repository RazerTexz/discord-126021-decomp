package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11359i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p0 */
/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11994p0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.p0$a */
    /* JADX INFO: compiled from: StarProjectionImpl.kt */
    public static final class a extends AbstractC12010v0 {

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ List<InterfaceC12008u0> f24855c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends InterfaceC12008u0> list) {
            this.f24855c = list;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0
        public InterfaceC12012w0 get(InterfaceC12008u0 interfaceC12008u0) {
            C12238m.checkNotNullParameter(interfaceC12008u0, "key");
            if (!this.f24855c.contains(interfaceC12008u0)) {
                return null;
            }
            InterfaceC11352h declarationDescriptor = interfaceC12008u0.getDeclarationDescriptor();
            Objects.requireNonNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return C11920e1.makeStarProjection((InterfaceC11477z0) declarationDescriptor);
        }
    }

    public static final AbstractC11913c0 starProjectionType(InterfaceC11477z0 interfaceC11477z0) {
        C12238m.checkNotNullParameter(interfaceC11477z0, "<this>");
        List<InterfaceC11477z0> parameters = ((InterfaceC11359i) interfaceC11477z0.getContainingDeclaration()).getTypeConstructor().getParameters();
        C12238m.checkNotNullExpressionValue(parameters, "classDescriptor.typeConstructor.parameters");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(parameters, 10));
        Iterator<T> it = parameters.iterator();
        while (it.hasNext()) {
            arrayList.add(((InterfaceC11477z0) it.next()).getTypeConstructor());
        }
        C11914c1 c11914c1Create = C11914c1.create(new a(arrayList));
        List<AbstractC11913c0> upperBounds = interfaceC11477z0.getUpperBounds();
        C12238m.checkNotNullExpressionValue(upperBounds, "this.upperBounds");
        AbstractC11913c0 abstractC11913c0Substitute = c11914c1Create.substitute((AbstractC11913c0) C12163u.first((List) upperBounds), EnumC11935j1.OUT_VARIANCE);
        if (abstractC11913c0Substitute != null) {
            return abstractC11913c0Substitute;
        }
        AbstractC11934j0 defaultBound = C11836a.getBuiltIns(interfaceC11477z0).getDefaultBound();
        C12238m.checkNotNullExpressionValue(defaultBound, "builtIns.defaultBound");
        return defaultBound;
    }
}
