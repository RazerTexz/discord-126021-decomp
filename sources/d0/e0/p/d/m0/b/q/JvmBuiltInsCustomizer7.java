package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.b.q.JvmBuiltInsCustomizer2;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.e.b.SignatureBuildingComponents;
import d0.e0.p.d.m0.e.b.methodSignatureBuildingUtils;
import d0.e0.p.d.m0.p.DFS;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.q.l, reason: use source file name */
/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmBuiltInsCustomizer7 extends DFS.b<ClassDescriptor, JvmBuiltInsCustomizer2.a> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef<JvmBuiltInsCustomizer2.a> f3241b;

    public JvmBuiltInsCustomizer7(String str, Ref$ObjectRef<JvmBuiltInsCustomizer2.a> ref$ObjectRef) {
        this.a = str;
        this.f3241b = ref$ObjectRef;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [T, d0.e0.p.d.m0.b.q.g$a] */
    @Override // d0.e0.p.d.m0.p.DFS.d
    public boolean beforeChildren(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "javaClassDescriptor");
        String strSignature = methodSignatureBuildingUtils.signature(SignatureBuildingComponents.a, classDescriptor, this.a);
        JvmBuiltInsSignatures jvmBuiltInsSignatures = JvmBuiltInsSignatures.a;
        if (jvmBuiltInsSignatures.getHIDDEN_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = JvmBuiltInsCustomizer2.a.HIDDEN;
        } else if (jvmBuiltInsSignatures.getVISIBLE_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = JvmBuiltInsCustomizer2.a.VISIBLE;
        } else if (jvmBuiltInsSignatures.getDROP_LIST_METHOD_SIGNATURES().contains(strSignature)) {
            this.f3241b.element = JvmBuiltInsCustomizer2.a.DROP;
        }
        return this.f3241b.element == null;
    }

    @Override // d0.e0.p.d.m0.p.DFS.d
    public JvmBuiltInsCustomizer2.a result() {
        JvmBuiltInsCustomizer2.a aVar = this.f3241b.element;
        return aVar == null ? JvmBuiltInsCustomizer2.a.NOT_CONSIDERED : aVar;
    }
}
