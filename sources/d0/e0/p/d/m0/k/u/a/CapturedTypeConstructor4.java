package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.SpecialTypes2;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.TypeProjectionImpl;
import d0.e0.p.d.m0.n.TypeSubstitution2;
import d0.e0.p.d.m0.n.TypeSubstitution4;
import d0.e0.p.d.m0.n.TypeSubstitution5;
import d0.e0.p.d.m0.n.Variance;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeConstructor4 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$a */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TypeProjection typeProjection) {
            super(0);
            this.$this_createCapturedIfNeeded = typeProjection;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType invoke() {
            KotlinType type = this.$this_createCapturedIfNeeded.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.d$b */
    /* JADX INFO: compiled from: CapturedTypeConstructor.kt */
    public static final class b extends TypeSubstitution2 {
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z2, TypeSubstitution5 typeSubstitution5) {
            super(typeSubstitution5);
            this.c = z2;
        }

        @Override // d0.e0.p.d.m0.n.TypeSubstitution5
        public boolean approximateContravariantCapturedTypes() {
            return this.c;
        }

        @Override // d0.e0.p.d.m0.n.TypeSubstitution2, d0.e0.p.d.m0.n.TypeSubstitution5
        public TypeProjection get(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "key");
            TypeProjection typeProjection = super.get(kotlinType);
            if (typeProjection == null) {
                return null;
            }
            ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
            return CapturedTypeConstructor4.a(typeProjection, declarationDescriptor instanceof TypeParameterDescriptor ? (TypeParameterDescriptor) declarationDescriptor : null);
        }
    }

    public static final TypeProjection a(TypeProjection typeProjection, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor == null || typeProjection.getProjectionKind() == Variance.INVARIANT) {
            return typeProjection;
        }
        if (typeParameterDescriptor.getVariance() != typeProjection.getProjectionKind()) {
            return new TypeProjectionImpl(createCapturedType(typeProjection));
        }
        if (!typeProjection.isStarProjection()) {
            return new TypeProjectionImpl(typeProjection.getType());
        }
        StorageManager storageManager = LockBasedStorageManager.f3514b;
        Intrinsics3.checkNotNullExpressionValue(storageManager, "NO_LOCKS");
        return new TypeProjectionImpl(new SpecialTypes2(storageManager, new a(typeProjection)));
    }

    public static final KotlinType createCapturedType(TypeProjection typeProjection) {
        Intrinsics3.checkNotNullParameter(typeProjection, "typeProjection");
        return new CapturedTypeConstructor(typeProjection, null, false, null, 14, null);
    }

    public static final boolean isCaptured(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.getConstructor() instanceof CapturedTypeConstructor2;
    }

    public static final TypeSubstitution5 wrapWithCapturingSubstitution(TypeSubstitution5 typeSubstitution5, boolean z2) {
        Intrinsics3.checkNotNullParameter(typeSubstitution5, "<this>");
        if (!(typeSubstitution5 instanceof TypeSubstitution4)) {
            return new b(z2, typeSubstitution5);
        }
        TypeSubstitution4 typeSubstitution4 = (TypeSubstitution4) typeSubstitution5;
        TypeParameterDescriptor[] parameters = typeSubstitution4.getParameters();
        List<Tuples2> listZip = _Arrays.zip(typeSubstitution4.getArguments(), typeSubstitution4.getParameters());
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZip, 10));
        for (Tuples2 tuples2 : listZip) {
            arrayList.add(a((TypeProjection) tuples2.getFirst(), (TypeParameterDescriptor) tuples2.getSecond()));
        }
        Object[] array = arrayList.toArray(new TypeProjection[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new TypeSubstitution4(parameters, (TypeProjection[]) array, z2);
    }

    public static /* synthetic */ TypeSubstitution5 wrapWithCapturingSubstitution$default(TypeSubstitution5 typeSubstitution5, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return wrapWithCapturingSubstitution(typeSubstitution5, z2);
    }
}
