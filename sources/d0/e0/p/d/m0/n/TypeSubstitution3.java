package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0, reason: use source file name */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeSubstitution3 extends TypeSubstitution5 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3542b = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0$a */
    /* JADX INFO: compiled from: TypeSubstitution.kt */
    public static final class a {

        /* JADX INFO: renamed from: d0.e0.p.d.m0.n.v0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: TypeSubstitution.kt */
        public static final class C0415a extends TypeSubstitution3 {
            public final /* synthetic */ Map<TypeConstructor, TypeProjection> c;
            public final /* synthetic */ boolean d;

            /* JADX WARN: Multi-variable type inference failed */
            public C0415a(Map<TypeConstructor, ? extends TypeProjection> map, boolean z2) {
                this.c = map;
                this.d = z2;
            }

            @Override // d0.e0.p.d.m0.n.TypeSubstitution5
            public boolean approximateCapturedTypes() {
                return this.d;
            }

            @Override // d0.e0.p.d.m0.n.TypeSubstitution3
            public TypeProjection get(TypeConstructor typeConstructor) {
                Intrinsics3.checkNotNullParameter(typeConstructor, "key");
                return this.c.get(typeConstructor);
            }

            @Override // d0.e0.p.d.m0.n.TypeSubstitution5
            public boolean isEmpty() {
                return this.c.isEmpty();
            }
        }

        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static /* synthetic */ TypeSubstitution3 createByConstructorsMap$default(a aVar, Map map, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            return aVar.createByConstructorsMap(map, z2);
        }

        public final TypeSubstitution5 create(KotlinType kotlinType) {
            Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        public final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
            Intrinsics3.checkNotNullParameter(map, "map");
            return createByConstructorsMap$default(this, map, false, 2, null);
        }

        public final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map, boolean z2) {
            Intrinsics3.checkNotNullParameter(map, "map");
            return new C0415a(map, z2);
        }

        public final TypeSubstitution5 create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics3.checkNotNullParameter(typeConstructor, "typeConstructor");
            Intrinsics3.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) _Collections.lastOrNull((List) parameters);
            if (!Intrinsics3.areEqual(typeParameterDescriptor == null ? null : Boolean.valueOf(typeParameterDescriptor.isCapturedFromOuterDeclaration()), Boolean.TRUE)) {
                return new TypeSubstitution4(parameters, list);
            }
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters2, 10));
            Iterator<T> it = parameters2.iterator();
            while (it.hasNext()) {
                arrayList.add(((TypeParameterDescriptor) it.next()).getTypeConstructor());
            }
            return createByConstructorsMap$default(this, Maps6.toMap(_Collections.zip(arrayList, list)), false, 2, null);
        }
    }

    public static final TypeSubstitution5 create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return f3542b.create(typeConstructor, list);
    }

    public static final TypeSubstitution3 createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
        return f3542b.createByConstructorsMap(map);
    }

    @Override // d0.e0.p.d.m0.n.TypeSubstitution5
    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);
}
