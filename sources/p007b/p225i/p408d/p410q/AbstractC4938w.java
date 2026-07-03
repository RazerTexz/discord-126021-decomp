package p007b.p225i.p408d.p410q;

import java.lang.reflect.Modifier;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.d.q.w */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4938w {
    /* JADX INFO: renamed from: a */
    public static void m6872a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            StringBuilder sbM833U = C1643a.m833U("Interface can't be instantiated! Interface name: ");
            sbM833U.append(cls.getName());
            throw new UnsupportedOperationException(sbM833U.toString());
        }
        if (Modifier.isAbstract(modifiers)) {
            StringBuilder sbM833U2 = C1643a.m833U("Abstract class can't be instantiated! Class name: ");
            sbM833U2.append(cls.getName());
            throw new UnsupportedOperationException(sbM833U2.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract <T> T mo6871b(Class<T> cls) throws Exception;
}
