package p630i0;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: i0.u */
/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12567u {

    /* JADX INFO: renamed from: a */
    public static final C12567u f26614a;

    /* JADX INFO: renamed from: b */
    public final boolean f26615b;

    /* JADX INFO: renamed from: c */
    public final Constructor<MethodHandles.Lookup> f26616c;

    /* JADX INFO: renamed from: i0.u$a */
    /* JADX INFO: compiled from: Platform.java */
    public static final class a extends C12567u {

        /* JADX INFO: renamed from: i0.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Platform.java */
        public static final class ExecutorC13347a implements Executor {

            /* JADX INFO: renamed from: j */
            public final Handler f26617j = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f26617j.post(runnable);
            }
        }

        public a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // p630i0.C12567u
        /* JADX INFO: renamed from: a */
        public Executor mo10716a() {
            return new ExecutorC13347a();
        }

        @Override // p630i0.C12567u
        /* JADX INFO: renamed from: b */
        public Object mo10717b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.mo10717b(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    static {
        f26614a = "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new C12567u(true);
    }

    public C12567u(boolean z2) {
        this.f26615b = z2;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z2) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f26616c = declaredConstructor;
    }

    /* JADX INFO: renamed from: a */
    public Executor mo10716a() {
        return null;
    }

    @IgnoreJRERequirement
    /* JADX INFO: renamed from: b */
    public Object mo10717b(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.f26616c;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }
}
