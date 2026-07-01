package d0.z.d;

import d0.e0.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.z.d.y, reason: use source file name */
/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // d0.e0.KProperty3
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public PropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }
}
