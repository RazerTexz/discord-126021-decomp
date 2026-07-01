package d0.e0.p.d.m0.k.a0.p;

import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.b, reason: use source file name */
/* JADX INFO: compiled from: ExtensionReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExtensionReceiver extends AbstractReceiverValue implements ReceiverValue {
    public final CallableDescriptor c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtensionReceiver(CallableDescriptor callableDescriptor, KotlinType kotlinType, ReceiverValue receiverValue) {
        super(kotlinType, receiverValue);
        if (callableDescriptor == null) {
            a(0);
            throw null;
        }
        if (kotlinType == null) {
            a(1);
            throw null;
        }
        this.c = callableDescriptor;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "receiverType";
        } else if (i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.c + "}";
    }
}
