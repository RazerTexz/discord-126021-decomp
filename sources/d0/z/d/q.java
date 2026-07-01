package d0.z.d;

import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MutablePropertyReference0Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class q extends p {
    public q(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(d.NO_RECEIVER, ((e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof d0.e0.c) ? 1 : 0);
    }

    public Object get() {
        return mo112getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        mo113getSetter().call(obj);
    }

    public q(Class cls, String str, String str2, int i) {
        super(d.NO_RECEIVER, cls, str, str2, i);
    }

    public q(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
