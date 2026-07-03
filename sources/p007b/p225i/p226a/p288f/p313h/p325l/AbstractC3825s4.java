package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import p007b.p225i.p226a.p288f.p313h.p325l.C3680h4;

/* JADX INFO: renamed from: b.i.a.f.h.l.s4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3825s4<T extends C3680h4> {

    /* JADX INFO: renamed from: a */
    public static final Logger f10311a = Logger.getLogger(zzhi.class.getName());

    /* JADX INFO: renamed from: b */
    public static String f10312b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    /* JADX INFO: renamed from: b */
    public static <T extends C3680h4> T m5215b(Class<T> cls) {
        String str;
        ClassLoader classLoader = AbstractC3825s4.class.getClassLoader();
        if (cls.equals(C3680h4.class)) {
            str = f10312b;
        } else {
            if (!cls.getPackage().equals(AbstractC3825s4.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    try {
                        return cls.cast(((AbstractC3825s4) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).m5216a());
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (NoSuchMethodException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(AbstractC3825s4.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((AbstractC3825s4) it.next()).m5216a()));
                } catch (ServiceConfigurationError e5) {
                    Logger logger = f10311a;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", simpleName.length() != 0 ? "Unable to load ".concat(simpleName) : new String("Unable to load "), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract T m5216a();
}
