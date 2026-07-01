package h0.b.a.c;

import h0.b.a.ObjectInstantiator;
import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.a.c.a, reason: use source file name */
/* JADX INFO: compiled from: AccessibleInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class AccessibleInstantiator<T> implements ObjectInstantiator {
    public Constructor<T> a;

    public AccessibleInstantiator(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
            this.a = declaredConstructor;
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }

    @Override // h0.b.a.ObjectInstantiator
    public Object newInstance() {
        try {
            return this.a.newInstance(null);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
