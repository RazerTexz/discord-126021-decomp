package d0.e0.p.d.m0.k.a0.p;

import b.d.b.a.outline;
import d0.e0.p.d.m0.n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.g, reason: use source file name */
/* JADX INFO: compiled from: TransientReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class TransientReceiver extends AbstractReceiverValue {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransientReceiver(KotlinType kotlinType) {
        super(kotlinType, null);
        if (kotlinType == null) {
            a(0);
            throw null;
        }
        if (kotlinType != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        StringBuilder sbU = outline.U("{Transient} : ");
        sbU.append(getType());
        return sbU.toString();
    }
}
