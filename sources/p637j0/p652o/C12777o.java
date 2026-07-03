package p637j0.p652o;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: j0.o.o */
/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12777o {

    /* JADX INFO: renamed from: a */
    public static final C12777o f27384a = new C12777o();

    /* JADX INFO: renamed from: b */
    public static final AbstractC12764b f27385b = new a();

    /* JADX INFO: renamed from: c */
    public final AtomicReference<AbstractC12764b> f27386c = new AtomicReference<>();

    /* JADX INFO: renamed from: d */
    public final AtomicReference<AbstractC12775m> f27387d = new AtomicReference<>();

    /* JADX INFO: renamed from: e */
    public final AtomicReference<AbstractC12779q> f27388e = new AtomicReference<>();

    /* JADX INFO: renamed from: f */
    public final AtomicReference<AbstractC12763a> f27389f = new AtomicReference<>();

    /* JADX INFO: renamed from: g */
    public final AtomicReference<C12778p> f27390g = new AtomicReference<>();

    /* JADX INFO: renamed from: j0.o.o$a */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public static class a extends AbstractC12764b {
    }

    /* JADX INFO: renamed from: j0.o.o$b */
    /* JADX INFO: compiled from: RxJavaPlugins.java */
    public class b extends AbstractC12763a {
        public b(C12777o c12777o) {
        }
    }

    /* JADX INFO: renamed from: d */
    public static Object m10866d(Class<?> cls, Properties properties) {
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
            throw new IllegalStateException(C1643a.m886y(simpleName, " implementation class not found: ", property), e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(C1643a.m886y(simpleName, " implementation not able to be accessed: ", property), e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(C1643a.m886y(simpleName, " implementation not able to be instantiated: ", property), e5);
        }
    }

    /* JADX INFO: renamed from: g */
    public static Properties m10867g() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX INFO: renamed from: a */
    public AbstractC12763a m10868a() {
        if (this.f27389f.get() == null) {
            Object objM10866d = m10866d(AbstractC12763a.class, m10867g());
            if (objM10866d == null) {
                this.f27389f.compareAndSet(null, new b(this));
            } else {
                this.f27389f.compareAndSet(null, (AbstractC12763a) objM10866d);
            }
        }
        return this.f27389f.get();
    }

    /* JADX INFO: renamed from: b */
    public AbstractC12764b m10869b() {
        if (this.f27386c.get() == null) {
            Object objM10866d = m10866d(AbstractC12764b.class, m10867g());
            if (objM10866d == null) {
                this.f27386c.compareAndSet(null, f27385b);
            } else {
                this.f27386c.compareAndSet(null, (AbstractC12764b) objM10866d);
            }
        }
        return this.f27386c.get();
    }

    /* JADX INFO: renamed from: c */
    public AbstractC12775m m10870c() {
        if (this.f27387d.get() == null) {
            Object objM10866d = m10866d(AbstractC12775m.class, m10867g());
            if (objM10866d == null) {
                this.f27387d.compareAndSet(null, C12776n.f27383a);
            } else {
                this.f27387d.compareAndSet(null, (AbstractC12775m) objM10866d);
            }
        }
        return this.f27387d.get();
    }

    /* JADX INFO: renamed from: e */
    public C12778p m10871e() {
        if (this.f27390g.get() == null) {
            Object objM10866d = m10866d(C12778p.class, m10867g());
            if (objM10866d == null) {
                this.f27390g.compareAndSet(null, C12778p.f27391a);
            } else {
                this.f27390g.compareAndSet(null, (C12778p) objM10866d);
            }
        }
        return this.f27390g.get();
    }

    /* JADX INFO: renamed from: f */
    public AbstractC12779q m10872f() {
        if (this.f27388e.get() == null) {
            Object objM10866d = m10866d(AbstractC12779q.class, m10867g());
            if (objM10866d == null) {
                this.f27388e.compareAndSet(null, C12780r.f27392a);
            } else {
                this.f27388e.compareAndSet(null, (AbstractC12779q) objM10866d);
            }
        }
        return this.f27388e.get();
    }
}
