package d0.z.d;

import d0.e0.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: renamed from: d0.z.d.s, reason: use source file name */
/* JADX INFO: compiled from: MutablePropertyReference1Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // d0.e0.KProperty3
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i);
    }
}
