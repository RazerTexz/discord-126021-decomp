package h0.b.a.d;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;

/* JADX INFO: compiled from: GCJInstantiatorBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> implements h0.b.a.a<T> {
    public static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ObjectInputStream f3731b;
    public final Class<T> c;

    public b(Class<T> cls) {
        this.c = cls;
        if (a == null) {
            try {
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newObject", Class.class, Class.class);
                a = declaredMethod;
                declaredMethod.setAccessible(true);
                f3731b = new b$a();
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
