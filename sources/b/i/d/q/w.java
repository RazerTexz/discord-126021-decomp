package b.i.d.q;

import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder sbU = b.d.b.a.a.U("Interface can't be instantiated! Interface name: ");
            sbU.append(cls.getName());
            throw new UnsupportedOperationException(sbU.toString());
        }
        if (Modifier.isAbstract(modifiers)) {
            StringBuilder sbU2 = b.d.b.a.a.U("Abstract class can't be instantiated! Class name: ");
            sbU2.append(cls.getName());
            throw new UnsupportedOperationException(sbU2.toString());
        }
    }

    public abstract <T> T b(Class<T> cls) throws Exception;
}
