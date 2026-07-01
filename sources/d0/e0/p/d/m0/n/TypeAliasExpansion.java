package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.r0, reason: use source file name */
/* JADX INFO: compiled from: TypeAliasExpansion.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeAliasExpansion {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAliasExpansion f3537b;
    public final TypeAliasDescriptor c;
    public final List<TypeProjection> d;
    public final Map<TypeParameterDescriptor, TypeProjection> e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.r0$a */
    /* JADX INFO: compiled from: TypeAliasExpansion.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
            Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics3.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics3.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(parameters, 10));
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((TypeParameterDescriptor) it.next()).getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, Maps6.toMap(_Collections.zip(arrayList, list)), null);
        }
    }

    public TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3537b = typeAliasExpansion;
        this.c = typeAliasDescriptor;
        this.d = list;
        this.e = map;
    }

    public final List<TypeProjection> getArguments() {
        return this.d;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.c;
    }

    public final TypeProjection getReplacement(TypeConstructor typeConstructor) {
        Intrinsics3.checkNotNullParameter(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.e.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics3.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics3.areEqual(this.c, typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.f3537b;
            if (!(typeAliasExpansion == null ? false : typeAliasExpansion.isRecursion(typeAliasDescriptor))) {
                return false;
            }
        }
        return true;
    }
}
