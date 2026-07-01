package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.i0.l.LazyJavaTypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.k0.z;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.p.collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.h, reason: use source file name */
/* JADX INFO: compiled from: resolvers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class resolvers implements resolvers2 {
    public final context4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DeclarationDescriptor f3324b;
    public final int c;
    public final Map<y, Integer> d;
    public final storage4<y, LazyJavaTypeParameterDescriptor> e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.h$a */
    /* JADX INFO: compiled from: resolvers.kt */
    public static final class a extends Lambda implements Function1<y, LazyJavaTypeParameterDescriptor> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final LazyJavaTypeParameterDescriptor invoke(y yVar) {
            Intrinsics3.checkNotNullParameter(yVar, "typeParameter");
            Integer num = (Integer) resolvers.this.d.get(yVar);
            if (num == null) {
                return null;
            }
            resolvers resolversVar = resolvers.this;
            return new LazyJavaTypeParameterDescriptor(context.copyWithNewDefaultTypeQualifiers(context.child(resolversVar.a, resolversVar), resolversVar.f3324b.getAnnotations()), yVar, resolversVar.c + num.intValue(), resolversVar.f3324b);
        }
    }

    public resolvers(context4 context4Var, DeclarationDescriptor declarationDescriptor, z zVar, int i) {
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(zVar, "typeParameterOwner");
        this.a = context4Var;
        this.f3324b = declarationDescriptor;
        this.c = i;
        this.d = collections.mapToIndex(zVar.getTypeParameters());
        this.e = context4Var.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // d0.e0.p.d.m0.e.a.i0.resolvers2
    public TypeParameterDescriptor resolveTypeParameter(y yVar) {
        Intrinsics3.checkNotNullParameter(yVar, "javaTypeParameter");
        LazyJavaTypeParameterDescriptor lazyJavaTypeParameterDescriptorInvoke = this.e.invoke(yVar);
        return lazyJavaTypeParameterDescriptorInvoke == null ? this.a.getTypeParameterResolver().resolveTypeParameter(yVar) : lazyJavaTypeParameterDescriptorInvoke;
    }
}
