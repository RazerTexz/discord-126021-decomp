package i0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: i0.u, reason: use source file name */
/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
public class Platform3 {
    public static final Platform3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3758b;
    public final Constructor<MethodHandles.Lookup> c;

    /* JADX INFO: renamed from: i0.u$a */
    /* JADX INFO: compiled from: Platform.java */
    public static final class a extends Platform3 {

        /* JADX INFO: renamed from: i0.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Platform.java */
        public static final class ExecutorC0425a implements Executor {
            public final Handler j = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.j.post(runnable);
            }
        }

        public a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // i0.Platform3
        public Executor a() {
            return new ExecutorC0425a();
        }

        @Override // i0.Platform3
        public Object b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.b(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    static {
        a = "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new Platform3(true);
    }

    public Platform3(boolean z2) {
        this.f3758b = z2;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z2) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
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
        Constructor<MethodHandles.Lookup> constructor = this.c;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
