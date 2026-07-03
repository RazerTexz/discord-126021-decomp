package p617h0.p620b.p621a.p622b;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.b.b */
/* JADX INFO: compiled from: Android17Instantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12438b<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public final Class<T> f26378a;

    /* JADX INFO: renamed from: b */
    public final Method f26379b;

    /* JADX INFO: renamed from: c */
    public final Integer f26380c;

    public C12438b(Class<T> cls) {
        this.f26378a = cls;
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            this.f26379b = declaredMethod;
            try {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                this.f26380c = (Integer) declaredMethod2.invoke(null, Object.class);
            } catch (IllegalAccessException e) {
                throw new ObjenesisException(e);
            } catch (NoSuchMethodException e2) {
                throw new ObjenesisException(e2);
            } catch (RuntimeException e3) {
                throw new ObjenesisException(e3);
            } catch (InvocationTargetException e4) {
                throw new ObjenesisException(e4);
            }
        } catch (NoSuchMethodException e5) {
            throw new ObjenesisException(e5);
        } catch (RuntimeException e6) {
            throw new ObjenesisException(e6);
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            Class<T> cls = this.f26378a;
            return cls.cast(this.f26379b.invoke(null, cls, this.f26380c));
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
