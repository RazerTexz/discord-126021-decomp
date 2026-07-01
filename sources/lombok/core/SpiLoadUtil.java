package lombok.core;

import com.adjust.sdk.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: app.apk:lombok/core/SpiLoadUtil.SCL.lombok */
public class SpiLoadUtil {
    private SpiLoadUtil() {
    }

    public static <T> List<T> readAllFromIterator(Iterable<T> findServices) {
        List<T> list = new ArrayList<>();
        for (T t : findServices) {
            list.add(t);
        }
        return list;
    }

    public static <C> Iterable<C> findServices(Class<C> target) throws IOException {
        return findServices(target, Thread.currentThread().getContextClassLoader());
    }

    public static <C> Iterable<C> findServices(final Class<C> target, ClassLoader loader) throws IOException {
        if (loader == null) {
            loader = ClassLoader.getSystemClassLoader();
        }
        Enumeration<URL> resources = loader.getResources("META-INF/services/" + target.getName());
        Set<String> entries = new LinkedHashSet<>();
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            readServicesFromUrl(entries, url);
        }
        final Iterator<String> names = entries.iterator();
        final ClassLoader fLoader = loader;
        return new Iterable<C>() { // from class: lombok.core.SpiLoadUtil.1
            @Override // java.lang.Iterable
            public Iterator<C> iterator() {
                final Iterator it = names;
                final Class cls = target;
                final ClassLoader classLoader = fLoader;
                return new Iterator<C>() { // from class: lombok.core.SpiLoadUtil.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public C next() {
                        try {
                            return (C) cls.cast(Class.forName((String) it.next(), true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]));
                        } catch (Exception e) {
                            Throwable cause = e;
                            if (cause instanceof InvocationTargetException) {
                                cause = cause.getCause();
                            }
                            if (cause instanceof RuntimeException) {
                                throw ((RuntimeException) cause);
                            }
                            if (cause instanceof Error) {
                                throw ((Error) cause);
                            }
                            throw new RuntimeException(cause);
                        }
                    }

                    @Override // java.util.Iterator
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0085 A[Catch: Throwable -> 0x008c, FINALLY_INSNS, TRY_LEAVE, TryCatch #0 {Throwable -> 0x008c, blocks: (B:27:0x007d, B:30:0x0085), top: B:42:0x007d }] */
    private static void readServicesFromUrl(Collection<String> list, URL url) throws IOException {
        InputStream in = url.openStream();
        BufferedReader r = null;
        if (in != null) {
            try {
                r = new BufferedReader(new InputStreamReader(in, Constants.ENCODING));
                while (true) {
                    String line = r.readLine();
                    if (line == null) {
                        break;
                    }
                    int idx = line.indexOf(35);
                    if (idx != -1) {
                        line = line.substring(0, idx);
                    }
                    String line2 = line.trim();
                    if (line2.length() != 0) {
                        list.add(line2);
                    }
                }
                if (r != null) {
                    try {
                        r.close();
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (in != null) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (r != null) {
                    try {
                        r.close();
                        if (in != null) {
                            in.close();
                        }
                    } catch (Throwable unused2) {
                    }
                } else if (in != null) {
                    in.close();
                }
            }
        }
        if (0 != 0) {
            try {
                r.close();
            } catch (Throwable unused3) {
                return;
            }
        }
        if (in != null) {
            in.close();
        }
    }

    public static Class<? extends Annotation> findAnnotationClass(Class<?> c, Class<?> base) {
        if (c == Object.class || c == null) {
            return null;
        }
        Class<? extends Annotation> answer = findAnnotationHelper(base, c.getGenericSuperclass());
        if (answer != null) {
            return answer;
        }
        for (Type iface : c.getGenericInterfaces()) {
            Class<? extends Annotation> answer2 = findAnnotationHelper(base, iface);
            if (answer2 != null) {
                return answer2;
            }
        }
        Class<? extends Annotation> potential = findAnnotationClass(c.getSuperclass(), base);
        if (potential != null) {
            return potential;
        }
        for (Class<?> iface2 : c.getInterfaces()) {
            Class<? extends Annotation> potential2 = findAnnotationClass(iface2, base);
            if (potential2 != null) {
                return potential2;
            }
        }
        return null;
    }

    private static Class<? extends Annotation> findAnnotationHelper(Class<?> base, Type iface) {
        if (iface instanceof ParameterizedType) {
            ParameterizedType p = (ParameterizedType) iface;
            if (!base.equals(p.getRawType())) {
                return null;
            }
            Type target = p.getActualTypeArguments()[0];
            if ((target instanceof Class) && Annotation.class.isAssignableFrom((Class) target)) {
                return (Class) target;
            }
            throw new ClassCastException("Not an annotation type: " + target);
        }
        return null;
    }
}
