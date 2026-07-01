package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.y, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class methodSignatureMapping4 implements descriptorBasedTypeSignatureMapping2<methodSignatureMapping> {
    public static final methodSignatureMapping4 a = new methodSignatureMapping4();

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public KotlinType commonSupertype(Collection<? extends KotlinType> collection) {
        Intrinsics3.checkNotNullParameter(collection, "types");
        throw new AssertionError(Intrinsics3.stringPlus("There should be no intersection type in existing descriptors, but found: ", _Collections.joinToString$default(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        return descriptorBasedTypeSignatureMapping2.a.getPredefinedFullInternalNameForClass(this, classDescriptor);
    }

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public methodSignatureMapping getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public KotlinType preprocessType(KotlinType kotlinType) {
        return descriptorBasedTypeSignatureMapping2.a.preprocessType(this, kotlinType);
    }

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor) {
        Intrinsics3.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics3.checkNotNullParameter(classDescriptor, "descriptor");
    }

    @Override // d0.e0.p.d.m0.e.b.descriptorBasedTypeSignatureMapping2
    public boolean releaseCoroutines() {
        return descriptorBasedTypeSignatureMapping2.a.releaseCoroutines(this);
    }
}
