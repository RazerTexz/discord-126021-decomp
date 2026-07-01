package h0.b.a.d;

import h0.b.a.ObjectInstantiator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

/* JADX INFO: renamed from: h0.b.a.d.b, reason: use source file name */
/* JADX INFO: compiled from: GCJInstantiatorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GCJInstantiatorBase<T> implements ObjectInstantiator<T> {
    public static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ObjectInputStream f3731b;
    public final Class<T> c;

    /* JADX INFO: renamed from: h0.b.a.d.b$a */
    /* JADX INFO: compiled from: GCJInstantiatorBase.java */
    public static class a extends ObjectInputStream {
    }

    public GCJInstantiatorBase(Class<T> cls) {
        this.c = cls;
        if (a == null) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
                f3731b = new a();
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
