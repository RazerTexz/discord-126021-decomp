package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.z.d.j */
/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12235j extends AbstractC12221d implements InterfaceC12234i, KFunction {
    private final int arity;
    private final int flags;

    public C12235j(int i) {
        this(i, AbstractC12221d.NO_RECEIVER, null, null, null, 0);
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KCallable computeReflected() {
        return C12216a0.function(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C12235j) {
            C12235j c12235j = (C12235j) obj;
            return C12238m.areEqual(getOwner(), c12235j.getOwner()) && getName().equals(c12235j.getName()) && getSignature().equals(c12235j.getSignature()) && this.flags == c12235j.flags && this.arity == c12235j.arity && C12238m.areEqual(getBoundReceiver(), c12235j.getBoundReceiver());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // p507d0.p592z.p594d.InterfaceC12234i
    public int getArity() {
        return this.arity;
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

    @Override // p507d0.p592z.p594d.AbstractC12221d, kotlin.reflect.KCallable, kotlin.reflect.KFunction
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
        StringBuilder sbM833U = C1643a.m833U("function ");
        sbM833U.append(getName());
        sbM833U.append(" (Kotlin reflection is not available)");
        return sbM833U.toString();
    }

    public C12235j(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    public C12235j(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
