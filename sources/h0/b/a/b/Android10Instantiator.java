package h0.b.a.b;

import h0.b.a.ObjectInstantiator;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: Android10Instantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class Android10Instantiator<T> implements ObjectInstantiator<T> {
    public final Class<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Method f3728b;

    public Android10Instantiator(Class<T> cls) {
        this.a = cls;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod.setAccessible(true);
            this.f3728b = declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        }
    }

    @Override // h0.b.a.ObjectInstantiator
    public T newInstance() {
        try {
            Class<T> cls = this.a;
            return cls.cast(this.f3728b.invoke(null, cls, Object.class));
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
