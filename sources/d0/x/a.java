package d0.x;

import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        m.checkNotNullParameter(th, "cause");
        m.checkNotNullParameter(th2, "exception");
        Method method = a$a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public d0.c0.c defaultPlatformRandom() {
        return new d0.c0.b();
    }
}
