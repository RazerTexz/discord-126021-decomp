package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.p.ImplicitClassReceiver;
import d0.e0.p.d.m0.k.a0.p.ReceiverValue;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.r, reason: use source file name */
/* JADX INFO: compiled from: LazyClassReceiverParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    public final ClassDescriptor m;
    public final ImplicitClassReceiver n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyClassReceiverParameterDescriptor(ClassDescriptor classDescriptor) {
        super(Annotations4.f.getEMPTY());
        if (classDescriptor == null) {
            a(0);
            throw null;
        }
        this.m = classDescriptor;
        this.n = new ImplicitClassReceiver(classDescriptor, null);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.m;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        a(2);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.n;
        if (implicitClassReceiver != null) {
            return implicitClassReceiver;
        }
        a(1);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.DeclarationDescriptorImpl
    public String toString() {
        StringBuilder sbU = outline.U("class ");
        sbU.append(this.m.getName());
        sbU.append("::this");
        return sbU.toString();
    }
}
