package j0.o;

import java.util.Map$Entry;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    public static final o a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f3802b = new o$a();
    public final AtomicReference<b> c = new AtomicReference<>();
    public final AtomicReference<m> d = new AtomicReference<>();
    public final AtomicReference<q> e = new AtomicReference<>();
    public final AtomicReference<a> f = new AtomicReference<>();
    public final AtomicReference<p> g = new AtomicReference<>();

    public static Object d(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                for (Map$Entry map$Entry : properties2.entrySet()) {
                    String string = map$Entry.getKey().toString();
                    if (string.startsWith("rxjava.plugin.") && string.endsWith(".class") && simpleName.equals(map$Entry.getValue().toString())) {
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
            throw new IllegalStateException(b.d.b.a.a.y(simpleName, " implementation class not found: ", property), e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(b.d.b.a.a.y(simpleName, " implementation not able to be accessed: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(b.d.b.a.a.y(simpleName, " implementation not able to be instantiated: ", property), e5);
        }
    }

    public static Properties g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    public a a() {
        if (this.f.get() == null) {
            Object objD = d(a.class, g());
            if (objD == null) {
                this.f.compareAndSet(null, new o$b(this));
            } else {
                this.f.compareAndSet(null, (a) objD);
            }
        }
        return this.f.get();
    }

    public b b() {
        if (this.c.get() == null) {
            Object objD = d(b.class, g());
            if (objD == null) {
                this.c.compareAndSet(null, f3802b);
            } else {
                this.c.compareAndSet(null, (b) objD);
            }
        }
        return this.c.get();
    }

    public m c() {
        if (this.d.get() == null) {
            Object objD = d(m.class, g());
            if (objD == null) {
                this.d.compareAndSet(null, n.a);
            } else {
                this.d.compareAndSet(null, (m) objD);
            }
        }
        return this.d.get();
    }

    public p e() {
        if (this.g.get() == null) {
            Object objD = d(p.class, g());
            if (objD == null) {
                this.g.compareAndSet(null, p.a);
            } else {
                this.g.compareAndSet(null, (p) objD);
            }
        }
        return this.g.get();
    }

    public q f() {
        if (this.e.get() == null) {
            Object objD = d(q.class, g());
            if (objD == null) {
                this.e.compareAndSet(null, r.a);
            } else {
                this.e.compareAndSet(null, (q) objD);
            }
        }
        return this.e.get();
    }
}
