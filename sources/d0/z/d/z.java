package d0.z.d;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends d implements KProperty {
    public z() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return getOwner().equals(zVar.getOwner()) && getName().equals(zVar.getName()) && getSignature().equals(zVar.getSignature()) && m.areEqual(getBoundReceiver(), zVar.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // d0.z.d.d
    public /* bridge */ /* synthetic */ KCallable getReflected() {
        return getReflected();
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
        StringBuilder sbU = b.d.b.a.a.U("property ");
        sbU.append(getName());
        sbU.append(" (Kotlin reflection is not available)");
        return sbU.toString();
    }

    public z(Object obj) {
        super(obj);
    }

    @Override // d0.z.d.d
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    public z(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }
}
