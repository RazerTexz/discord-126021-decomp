package p617h0.p620b.p621a.p624d;

import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.a.d.a */
/* JADX INFO: compiled from: GCJInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12442a<T> extends AbstractC12443b<T> {
    public C12442a(Class<T> cls) {
        super(cls);
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            Class<T> cls = this.f26396c;
            return cls.cast(AbstractC12443b.f26394a.invoke(AbstractC12443b.f26395b, cls, Object.class));
        } catch (IllegalAccessException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        } catch (InvocationTargetException e3) {
            throw new ObjenesisException(e3);
        }
    }
}
