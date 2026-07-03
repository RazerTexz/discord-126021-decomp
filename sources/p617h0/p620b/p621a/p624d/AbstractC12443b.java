package p617h0.p620b.p621a.p624d;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.d.b */
/* JADX INFO: compiled from: GCJInstantiatorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12443b<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public static Method f26394a;

    /* JADX INFO: renamed from: b */
    public static ObjectInputStream f26395b;

    /* JADX INFO: renamed from: c */
    public final Class<T> f26396c;

    /* JADX INFO: renamed from: h0.b.a.d.b$a */
    /* JADX INFO: compiled from: GCJInstantiatorBase.java */
    public static class a extends ObjectInputStream {
    }

    public AbstractC12443b(Class<T> cls) {
        this.f26396c = cls;
        if (f26394a == null) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                f26394a = declaredMethod;
                declaredMethod.setAccessible(true);
                f26395b = new a();
            } catch (IOException e) {
                throw new ObjenesisException(e);
            } catch (NoSuchMethodException e2) {
                throw new ObjenesisException(e2);
            } catch (RuntimeException e3) {
                throw new ObjenesisException(e3);
            }
        }
    }
}
