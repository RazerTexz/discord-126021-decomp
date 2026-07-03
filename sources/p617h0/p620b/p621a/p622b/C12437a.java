package p617h0.p620b.p621a.p622b;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.b.a */
/* JADX INFO: compiled from: Android10Instantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12437a<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public final Class<T> f26376a;

    /* JADX INFO: renamed from: b */
    public final Method f26377b;

    public C12437a(Class<T> cls) {
        this.f26376a = cls;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
            declaredMethod.setAccessible(true);
            this.f26377b = declaredMethod;
        } catch (NoSuchMethodException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            Class<T> cls = this.f26376a;
            return cls.cast(this.f26377b.invoke(null, cls, Object.class));
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
