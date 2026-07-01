package h0.b.a.d;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;

/* JADX INFO: compiled from: GCJInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a<T> extends b<T> {
    public a(Class<T> cls) {
        super(cls);
    }

    @Override // h0.b.a.a
    public T newInstance() {
        try {
            Class<T> cls = this.c;
            return cls.cast(b.a.invoke(b.f3731b, cls, Object.class));
        } catch (IllegalAccessException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        } catch (InvocationTargetException e3) {
            throw new ObjenesisException(e3);
        }
    }
}
