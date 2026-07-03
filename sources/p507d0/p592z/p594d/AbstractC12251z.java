package p507d0.p592z.p594d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.z.d.z */
/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12251z extends AbstractC12221d implements KProperty {
    public AbstractC12251z() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC12251z) {
            AbstractC12251z abstractC12251z = (AbstractC12251z) obj;
            return getOwner().equals(abstractC12251z.getOwner()) && getName().equals(abstractC12251z.getName()) && getSignature().equals(abstractC12251z.getSignature()) && C12238m.areEqual(getBoundReceiver(), abstractC12251z.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        StringBuilder sbM833U = C1643a.m833U("property ");
        sbM833U.append(getName());
        sbM833U.append(" (Kotlin reflection is not available)");
        return sbM833U.toString();
    }

    public AbstractC12251z(Object obj) {
        super(obj);
    }

    @Override // p507d0.p592z.p594d.AbstractC12221d
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    public AbstractC12251z(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }
}
