package p617h0.p620b.p621a.p625e;

import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.e.a */
/* JADX INFO: compiled from: PercInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12444a<T> implements InterfaceC12436a<T> {

    /* JADX INFO: renamed from: a */
    public final Method f26397a;

    /* JADX INFO: renamed from: b */
    public final Object[] f26398b;

    public C12444a(Class<T> cls) {
        Object[] objArr = {null, Boolean.FALSE};
        this.f26398b = objArr;
        objArr[0] = cls;
        try {
            Method declaredMethod = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Boolean.TYPE);
            this.f26397a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new ObjenesisException(e);
        } catch (RuntimeException e2) {
            throw new ObjenesisException(e2);
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public T newInstance() {
        try {
            return (T) this.f26397a.invoke(null, this.f26398b);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
