package h0.b.a.f;

import java.lang.reflect.Field;
import org.objenesis.ObjenesisException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: UnsafeFactoryInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b<T> implements h0.b.a.a<T> {
    public static Unsafe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<T> f3733b;

    public b(Class<T> cls) {
        if (a == null) {
            try {
                Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                declaredField.setAccessible(true);
                try {
                    a = (Unsafe) declaredField.get(null);
                } catch (IllegalAccessException e) {
                    throw new ObjenesisException(e);
                }
            } catch (NoSuchFieldException e2) {
                throw new ObjenesisException(e2);
            }
        }
        this.f3733b = cls;
    }

    @Override // h0.b.a.a
    public T newInstance() {
        try {
            Class<T> cls = this.f3733b;
            return cls.cast(a.allocateInstance(cls));
        } catch (InstantiationException e) {
            throw new ObjenesisException(e);
        }
    }
}
