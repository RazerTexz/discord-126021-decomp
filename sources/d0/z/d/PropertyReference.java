package d0.z.d;

import b.d.b.a.outline;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.z.d.z, reason: use source file name */
/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    public PropertyReference() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && Intrinsics3.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver());
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
        StringBuilder sbU = outline.U("property ");
        sbU.append(getName());
        sbU.append(" (Kotlin reflection is not available)");
        return sbU.toString();
    }

    public PropertyReference(Object obj) {
        super(obj);
    }

    @Override // d0.z.d.CallableReference
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }
}
