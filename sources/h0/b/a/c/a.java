package h0.b.a.c;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;

/* JADX INFO: compiled from: AccessibleInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> implements h0.b.a.a {
    public Constructor<T> a;

    public a(Class<T> cls) {
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

    @Override // h0.b.a.a
    public Object newInstance() {
        try {
            return this.a.newInstance(null);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
