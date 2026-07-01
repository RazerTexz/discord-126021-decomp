package d0.z.d;

import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MutablePropertyReference1Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends r {
    public s(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(d.NO_RECEIVER, ((e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof d0.e0.c) ? 1 : 0);
    }

    @Override // d0.e0.g
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public s(Class cls, String str, String str2, int i) {
        super(d.NO_RECEIVER, cls, str, str2, i);
    }
}
