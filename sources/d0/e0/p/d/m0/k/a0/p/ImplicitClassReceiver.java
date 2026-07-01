package d0.e0.p.d.m0.k.a0.p;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.c, reason: use source file name */
/* JADX INFO: compiled from: ImplicitClassReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ImplicitClassReceiver implements ReceiverValue, ImplicitClassReceiver2 {
    public final ClassDescriptor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassDescriptor f3466b;

    public ImplicitClassReceiver(ClassDescriptor classDescriptor, ImplicitClassReceiver implicitClassReceiver) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        this.a = classDescriptor;
        this.f3466b = classDescriptor;
    }

    public boolean equals(Object obj) {
        ClassDescriptor classDescriptor = this.a;
        ImplicitClassReceiver implicitClassReceiver = obj instanceof ImplicitClassReceiver ? (ImplicitClassReceiver) obj : null;
        return Intrinsics3.areEqual(classDescriptor, implicitClassReceiver != null ? implicitClassReceiver.a : null);
    }

    @Override // d0.e0.p.d.m0.k.a0.p.ImplicitClassReceiver2
    public final ClassDescriptor getClassDescriptor() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = outline.U("Class{");
        sbU.append(getType());
        sbU.append('}');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.k.a0.p.ReceiverValue
    public KotlinType4 getType() {
        KotlinType4 defaultType = this.a.getDefaultType();
        Intrinsics3.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }
}
