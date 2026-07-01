package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends d implements i, KFunction {
    private final int arity;
    private final int flags;

    public j(int i) {
        this(i, d.NO_RECEIVER, null, null, null, 0);
    }

    @Override // d0.z.d.d
    public KCallable computeReflected() {
        return a0.function(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return m.areEqual(getOwner(), jVar.getOwner()) && getName().equals(jVar.getName()) && getSignature().equals(jVar.getSignature()) && this.flags == jVar.flags && this.arity == jVar.arity && m.areEqual(getBoundReceiver(), jVar.getBoundReceiver());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // d0.z.d.i
    public int getArity() {
        return this.arity;
    }

    @Override // d0.z.d.d
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KFunction
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // kotlin.reflect.KFunction
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // d0.z.d.d, kotlin.reflect.KCallable, kotlin.reflect.KFunction
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        StringBuilder sbU = b.d.b.a.a.U("function ");
        sbU.append(getName());
        sbU.append(" (Kotlin reflection is not available)");
        return sbU.toString();
    }

    public j(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // d0.z.d.d
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    public j(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
