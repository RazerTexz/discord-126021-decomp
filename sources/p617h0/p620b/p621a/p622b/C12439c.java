package p617h0.p620b.p621a.p622b;

import java.io.ObjectStreamClass;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.b.c */
/* JADX INFO: compiled from: Android18Instantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12439c<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public final Class<T> f26381a;

    /* JADX INFO: renamed from: b */
    public final Method f26382b;

    /* JADX INFO: renamed from: c */
    public final Long f26383c;

    public C12439c(Class<T> cls) {
        this.f26381a = cls;
        try {
            Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Long.TYPE);
            declaredMethod.setAccessible(true);
            this.f26382b = declaredMethod;
            try {
                Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                declaredMethod2.setAccessible(true);
                this.f26383c = (Long) declaredMethod2.invoke(null, Object.class);
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
            Class<T> cls = this.f26381a;
            return cls.cast(this.f26382b.invoke(null, cls, this.f26383c));
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
