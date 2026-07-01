package d0.x;

import d0.c0.PlatformRandom2;
import d0.c0.Random;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: d0.x.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformImplementations {

    /* JADX INFO: renamed from: d0.x.a$a */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    public static final class a {
        public static final Method a;

        /* JADX WARN: Code duplicated, block: B:10:0x003a  */
        static {
            Method method;
            boolean z2;
            Method[] methods = Throwable.class.getMethods();
            Intrinsics3.checkNotNullExpressionValue(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    method = null;
                    break;
                }
                method = methods[i];
                Intrinsics3.checkNotNullExpressionValue(method, "it");
                if (Intrinsics3.areEqual(method.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Intrinsics3.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (Intrinsics3.areEqual((Class) _Arrays.singleOrNull(parameterTypes), Throwable.class)) {
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
            a = method;
            for (Method method2 : methods) {
                Intrinsics3.checkNotNullExpressionValue(method2, "it");
                if (Intrinsics3.areEqual(method2.getName(), "getSuppressed")) {
                    return;
                }
            }
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        Intrinsics3.checkNotNullParameter(th, "cause");
        Intrinsics3.checkNotNullParameter(th2, "exception");
        Method method = a.a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public Random defaultPlatformRandom() {
        return new PlatformRandom2();
    }
}
