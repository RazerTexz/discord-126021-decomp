package p507d0.p588x;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p507d0.p510c0.AbstractC11216c;
import p507d0.p510c0.C11215b;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.x.a */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12195a {

    /* JADX INFO: renamed from: d0.x.a$a */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final Method f25251a;

        /* JADX WARN: Code duplicated, block: B:10:0x003a  */
        static {
            Method method;
            boolean z2;
            Method[] methods = Throwable.class.getMethods();
            C12238m.checkNotNullExpressionValue(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methods[i];
                C12238m.checkNotNullExpressionValue(method, "it");
                if (C12238m.areEqual(method.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    C12238m.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (C12238m.areEqual((Class) C12141k.singleOrNull(parameterTypes), Throwable.class)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                } else {
                    i++;
                }
            }
            f25251a = method;
            for (Method method2 : methods) {
                C12238m.checkNotNullExpressionValue(method2, "it");
                if (C12238m.areEqual(method2.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        C12238m.checkNotNullParameter(th, "cause");
        C12238m.checkNotNullParameter(th2, "exception");
        Method method = a.f25251a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public AbstractC11216c defaultPlatformRandom() {
        return new C11215b();
    }
}
