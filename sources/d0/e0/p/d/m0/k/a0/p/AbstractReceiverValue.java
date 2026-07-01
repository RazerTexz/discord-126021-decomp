package d0.e0.p.d.m0.k.a0.p;

import d0.e0.p.d.m0.n.KotlinType;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractReceiverValue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractReceiverValue implements ReceiverValue {
    public final KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReceiverValue f3465b;

    public AbstractReceiverValue(KotlinType kotlinType, ReceiverValue receiverValue) {
        if (kotlinType == null) {
            a(0);
            throw null;
        }
        this.a = kotlinType;
        this.f3465b = receiverValue == null ? this : receiverValue;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.k.a0.p.ReceiverValue
    public KotlinType getType() {
        KotlinType kotlinType = this.a;
        if (kotlinType != null) {
            return kotlinType;
        }
        a(1);
        throw null;
    }
}
