package d0.e0.p.d.m0.n.l1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeSubstitution3;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l1.k, reason: use source file name */
/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NewCapturedType3 {
    /* JADX WARN: Code duplicated, block: B:20:0x0057  */
    public static final KotlinType4 captureFromArguments(KotlinType4 kotlinType4, d0.e0.p.d.m0.n.n1.b bVar) {
        ArrayList arrayList;
        Intrinsics3.checkNotNullParameter(kotlinType4, "type");
        Intrinsics3.checkNotNullParameter(bVar, "status");
        Variance variance = Variance.INVARIANT;
        if (kotlinType4.getArguments().size() != kotlinType4.getConstructor().getParameters().size()) {
            arrayList = null;
        } else {
            List<TypeProjection> arguments = kotlinType4.getArguments();
            boolean z2 = true;
            int i = 0;
            if (!(arguments instanceof Collection) || !arguments.isEmpty()) {
                Iterator<T> it = arguments.iterator();
                while (it.hasNext()) {
                    if (!(((TypeProjection) it.next()).getProjectionKind() == variance)) {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                arrayList = null;
            } else {
                List<TypeParameterDescriptor> parameters = kotlinType4.getConstructor().getParameters();
                Intrinsics3.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
                List<Tuples2> listZip = _Collections.zip(arguments, parameters);
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listZip, 10));
                for (Tuples2 tuples2 : listZip) {
                    TypeProjection typeProjectionAsTypeProjection = (TypeProjection) tuples2.component1();
                    TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) tuples2.component2();
                    if (typeProjectionAsTypeProjection.getProjectionKind() != variance) {
                        KotlinType3 kotlinType3Unwrap = (typeProjectionAsTypeProjection.isStarProjection() || typeProjectionAsTypeProjection.getProjectionKind() != Variance.IN_VARIANCE) ? null : typeProjectionAsTypeProjection.getType().unwrap();
                        Intrinsics3.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                        typeProjectionAsTypeProjection = TypeUtils2.asTypeProjection(new NewCapturedType(bVar, kotlinType3Unwrap, typeProjectionAsTypeProjection, typeParameterDescriptor));
                    }
                    arrayList2.add(typeProjectionAsTypeProjection);
                }
                TypeSubstitutor2 typeSubstitutor2BuildSubstitutor = TypeSubstitution3.f3542b.create(kotlinType4.getConstructor(), arrayList2).buildSubstitutor();
                int size = arguments.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        TypeProjection typeProjection = arguments.get(i);
                        TypeProjection typeProjection2 = (TypeProjection) arrayList2.get(i);
                        if (typeProjection.getProjectionKind() != variance) {
                            List<KotlinType> upperBounds = kotlinType4.getConstructor().getParameters().get(i).getUpperBounds();
                            ArrayList arrayListA0 = outline.a0(upperBounds, "type.constructor.parameters[index].upperBounds");
                            Iterator<T> it2 = upperBounds.iterator();
                            while (it2.hasNext()) {
                                arrayListA0.add(NewKotlinTypeChecker.f3529b.getDefault().transformToNewType(typeSubstitutor2BuildSubstitutor.safeSubstitute((KotlinType) it2.next(), variance).unwrap()));
                            }
                            if (!typeProjection.isStarProjection() && typeProjection.getProjectionKind() == Variance.OUT_VARIANCE) {
                                arrayListA0.add(NewKotlinTypeChecker.f3529b.getDefault().transformToNewType(typeProjection.getType().unwrap()));
                            }
                            ((NewCapturedType) typeProjection2.getType()).getConstructor().initializeSupertypes(arrayListA0);
                        }
                        if (i2 > size) {
                            break;
                        }
                        i = i2;
                    }
                }
                arrayList = arrayList2;
            }
        }
        if (arrayList == null) {
            return null;
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.simpleType$default(kotlinType4.getAnnotations(), kotlinType4.getConstructor(), arrayList, kotlinType4.isMarkedNullable(), null, 16, null);
    }
}
