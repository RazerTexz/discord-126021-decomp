package i0;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles$Lookup;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
public class u {
    public static final u a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3758b;
    public final Constructor<MethodHandles$Lookup> c;

    static {
        a = "Dalvik".equals(System.getProperty("java.vm.name")) ? new u$a() : new u(true);
    }

    public u(boolean z2) {
        this.f3758b = z2;
        Constructor<MethodHandles$Lookup> declaredConstructor = null;
        if (z2) {
            try {
                declaredConstructor = MethodHandles$Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.c = declaredConstructor;
    }

    public Executor a() {
        return null;
    }

    @IgnoreJRERequirement
    public Object b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles$Lookup> constructor = this.c;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
