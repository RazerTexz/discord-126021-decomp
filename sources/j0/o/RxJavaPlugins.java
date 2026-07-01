package j0.o;

import b.d.b.a.outline;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: j0.o.o, reason: use source file name */
/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public class RxJavaPlugins {
    public static final RxJavaPlugins a = new RxJavaPlugins();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RxJavaErrorHandler f3802b = new a();
    public final AtomicReference<RxJavaErrorHandler> c = new AtomicReference<>();
    public final AtomicReference<RxJavaObservableExecutionHook> d = new AtomicReference<>();
    public final AtomicReference<RxJavaSingleExecutionHook> e = new AtomicReference<>();
    public final AtomicReference<RxJavaCompletableExecutionHook> f = new AtomicReference<>();
    public final AtomicReference<RxJavaSchedulersHook> g = new AtomicReference<>();

    /* JADX INFO: renamed from: j0.o.o$a */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public static class a extends RxJavaErrorHandler {
    }

    /* JADX INFO: renamed from: j0.o.o$b */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public class b extends RxJavaCompletableExecutionHook {
        public b(RxJavaPlugins rxJavaPlugins) {
        }
    }

    public static Object d(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                for (Map.Entry entry : properties2.entrySet()) {
                    String string = entry.getKey().toString();
                    if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        String str = "rxjava.plugin." + string.substring(0, string.length() - 6).substring(14) + ".impl";
                        property = properties2.getProperty(str);
                        if (property != null) {
                            break;
                        }
                        throw new IllegalStateException("Implementing class declaration for " + simpleName + " missing: " + str);
                    }
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e2) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e2);
        } catch (ClassNotFoundException e3) {
            throw new IllegalStateException(outline.y(simpleName, " implementation class not found: ", property), e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(outline.y(simpleName, " implementation not able to be accessed: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(outline.y(simpleName, " implementation not able to be instantiated: ", property), e5);
        }
    }

    public static Properties g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public RxJavaCompletableExecutionHook a() {
        if (this.f.get() == null) {
            Object objD = d(RxJavaCompletableExecutionHook.class, g());
            if (objD == null) {
                this.f.compareAndSet(null, new b(this));
            } else {
                this.f.compareAndSet(null, (RxJavaCompletableExecutionHook) objD);
            }
        }
        return this.f.get();
    }

    public RxJavaErrorHandler b() {
        if (this.c.get() == null) {
            Object objD = d(RxJavaErrorHandler.class, g());
            if (objD == null) {
                this.c.compareAndSet(null, f3802b);
            } else {
                this.c.compareAndSet(null, (RxJavaErrorHandler) objD);
            }
        }
        return this.c.get();
    }

    public RxJavaObservableExecutionHook c() {
        if (this.d.get() == null) {
            Object objD = d(RxJavaObservableExecutionHook.class, g());
            if (objD == null) {
                this.d.compareAndSet(null, RxJavaObservableExecutionHookDefault.a);
            } else {
                this.d.compareAndSet(null, (RxJavaObservableExecutionHook) objD);
            }
        }
        return this.d.get();
    }

    public RxJavaSchedulersHook e() {
        if (this.g.get() == null) {
            Object objD = d(RxJavaSchedulersHook.class, g());
            if (objD == null) {
                this.g.compareAndSet(null, RxJavaSchedulersHook.a);
            } else {
                this.g.compareAndSet(null, (RxJavaSchedulersHook) objD);
            }
        }
        return this.g.get();
    }

    public RxJavaSingleExecutionHook f() {
        if (this.e.get() == null) {
            Object objD = d(RxJavaSingleExecutionHook.class, g());
            if (objD == null) {
                this.e.compareAndSet(null, RxJavaSingleExecutionHookDefault.a);
            } else {
                this.e.compareAndSet(null, (RxJavaSingleExecutionHook) objD);
            }
        }
        return this.e.get();
    }
}
