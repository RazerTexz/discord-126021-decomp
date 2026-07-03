package p617h0.p620b.p621a.p626f;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.f.a */
/* JADX INFO: compiled from: SunReflectionFactoryInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12445a<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public final Constructor<T> f26399a;

    public C12445a(Class<T> cls) {
        try {
            Constructor constructor = Object.class.getConstructor(null);
            try {
                Class<?> cls2 = Class.forName("sun.reflect.ReflectionFactory");
                try {
                    try {
                        try {
                            Constructor<T> constructor2 = (Constructor) cls2.getDeclaredMethod("newConstructorForSerialization", Class.class, Constructor.class).invoke(cls2.getDeclaredMethod("getReflectionFactory", new Class[0]).invoke(null, new Object[0]), cls, constructor);
                            this.f26399a = constructor2;
                            constructor2.setAccessible(true);
                        } catch (IllegalAccessException e) {
                            throw new ObjenesisException(e);
                        } catch (IllegalArgumentException e2) {
                            throw new ObjenesisException(e2);
                        } catch (InvocationTargetException e3) {
                            throw new ObjenesisException(e3);
                        }
                    } catch (NoSuchMethodException e4) {
                        throw new ObjenesisException(e4);
                    }
                } catch (IllegalAccessException e5) {
                    throw new ObjenesisException(e5);
                } catch (IllegalArgumentException e6) {
                    throw new ObjenesisException(e6);
                } catch (NoSuchMethodException e7) {
                    throw new ObjenesisException(e7);
                } catch (InvocationTargetException e8) {
                    throw new ObjenesisException(e8);
                }
            } catch (ClassNotFoundException e9) {
                throw new ObjenesisException(e9);
            }
        } catch (NoSuchMethodException e10) {
            throw new ObjenesisException(e10);
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            return this.f26399a.newInstance(null);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
