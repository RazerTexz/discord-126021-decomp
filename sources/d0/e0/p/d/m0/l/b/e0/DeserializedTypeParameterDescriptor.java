package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.SupertypeLoopChecker;
import d0.e0.p.d.m0.c.g1.AnnotationDescriptor;
import d0.e0.p.d.m0.c.i1.AbstractLazyTypeParameterDescriptor;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.l.b.NameResolverUtil;
import d0.e0.p.d.m0.l.b.ProtoEnumFlags;
import d0.e0.p.d.m0.l.b.TypeDeserializer;
import d0.e0.p.d.m0.l.b.context6;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.m, reason: use source file name */
/* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    public final context6 t;
    public final s u;
    public final DeserializedAnnotations v;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.m$a */
    /* JADX INFO: compiled from: DeserializedTypeParameterDescriptor.kt */
    public static final class a extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends AnnotationDescriptor> invoke() {
            return _Collections.toList(DeserializedTypeParameterDescriptor.this.t.getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(DeserializedTypeParameterDescriptor.this.getProto(), DeserializedTypeParameterDescriptor.this.t.getNameResolver()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedTypeParameterDescriptor(context6 context6Var, s sVar, int i) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(sVar, "proto");
        StorageManager storageManager = context6Var.getStorageManager();
        DeclarationDescriptor containingDeclaration = context6Var.getContainingDeclaration();
        Name name = NameResolverUtil.getName(context6Var.getNameResolver(), sVar.getName());
        ProtoEnumFlags protoEnumFlags = ProtoEnumFlags.a;
        s.c variance = sVar.getVariance();
        Intrinsics3.checkNotNullExpressionValue(variance, "proto.variance");
        super(storageManager, containingDeclaration, name, protoEnumFlags.variance(variance), sVar.getReified(), i, SourceElement.a, SupertypeLoopChecker.a.a);
        this.t = context6Var;
        this.u = sVar;
        this.v = new DeserializedAnnotations(context6Var.getStorageManager(), new a());
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public void c(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        throw new IllegalStateException(Intrinsics3.stringPlus("There should be no cycles for deserialized type parameters, but found for: ", this));
    }

    @Override // d0.e0.p.d.m0.c.i1.AbstractTypeParameterDescriptor
    public List<KotlinType> d() {
        List<q> listUpperBounds = protoTypeTableUtil.upperBounds(this.u, this.t.getTypeTable());
        if (listUpperBounds.isEmpty()) {
            return CollectionsJVM.listOf(DescriptorUtils2.getBuiltIns(this).getDefaultBound());
        }
        TypeDeserializer typeDeserializer = this.t.getTypeDeserializer();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listUpperBounds, 10));
        Iterator<T> it = listUpperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(typeDeserializer.type((q) it.next()));
        }
        return arrayList;
    }

    public final s getProto() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.c.g1.AnnotatedImpl, d0.e0.p.d.m0.c.g1.Annotations3
    public DeserializedAnnotations getAnnotations() {
        return this.v;
    }
}
