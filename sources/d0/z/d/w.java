package d0.z.d;

import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: PropertyReference0Impl.java */
/* JADX INFO: loaded from: classes3.dex */
public class w extends v {
    public w(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(d.NO_RECEIVER, ((e) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof d0.e0.c) ? 1 : 0);
    }

    public Object get() {
        return mo112getGetter().call(new Object[0]);
    }

    public w(Class cls, String str, String str2, int i) {
        super(d.NO_RECEIVER, cls, str, str2, i);
    }

    public w(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
