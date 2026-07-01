package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.a1, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeSubstitution {
    public static final KotlinType4 asSimpleType(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        KotlinType4 kotlinType4 = kotlinType3Unwrap instanceof KotlinType4 ? (KotlinType4) kotlinType3Unwrap : null;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        throw new IllegalStateException(Intrinsics3.stringPlus("This is should be simple type: ", kotlinType).toString());
    }

    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> list, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(list, "newArguments");
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return replace$default(kotlinType, list, annotations4, null, 4, null);
    }

    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> list, Annotations4 annotations4, List<? extends TypeProjection> list2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics3.checkNotNullParameter(list, "newArguments");
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        Intrinsics3.checkNotNullParameter(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == kotlinType.getArguments()) && annotations4 == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (kotlinType3Unwrap instanceof KotlinType6) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            KotlinType6 kotlinType6 = (KotlinType6) kotlinType3Unwrap;
            return KotlinTypeFactory.flexibleType(replace(kotlinType6.getLowerBound(), list, annotations4), replace(kotlinType6.getUpperBound(), list2, annotations4));
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            return replace((KotlinType4) kotlinType3Unwrap, list, annotations4);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List list, Annotations4 annotations4, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations4 = kotlinType.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations4, list2);
    }

    public static /* synthetic */ KotlinType4 replace$default(KotlinType4 kotlinType4, List list, Annotations4 annotations4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kotlinType4.getArguments();
        }
        if ((i & 2) != 0) {
            annotations4 = kotlinType4.getAnnotations();
        }
        return replace(kotlinType4, (List<? extends TypeProjection>) list, annotations4);
    }

    public static final KotlinType4 replace(KotlinType4 kotlinType4, List<? extends TypeProjection> list, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "<this>");
        Intrinsics3.checkNotNullParameter(list, "newArguments");
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        if (list.isEmpty() && annotations4 == kotlinType4.getAnnotations()) {
            return kotlinType4;
        }
        if (list.isEmpty()) {
            return kotlinType4.replaceAnnotations(annotations4);
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        return KotlinTypeFactory.simpleType$default(annotations4, kotlinType4.getConstructor(), list, kotlinType4.isMarkedNullable(), null, 16, null);
    }
}
