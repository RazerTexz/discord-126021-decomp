package p617h0.p620b.p621a.p623c;

import java.lang.reflect.Constructor;
import org.objenesis.ObjenesisException;
import p617h0.p620b.p621a.InterfaceC12436a;

/* JADX INFO: renamed from: h0.b.a.c.a */
/* JADX INFO: compiled from: AccessibleInstantiator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12440a<T> implements InterfaceC12436a {

    /* JADX INFO: renamed from: a */
    public Constructor<T> f26384a;

    public C12440a(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
            this.f26384a = declaredConstructor;
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
            }
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }

    @Override // p617h0.p620b.p621a.InterfaceC12436a
    public Object newInstance() {
        try {
            return this.f26384a.newInstance(null);
        } catch (Exception e) {
            throw new ObjenesisException(e);
        }
    }
}
