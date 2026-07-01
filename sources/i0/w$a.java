package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;

/* JADX INFO: compiled from: RequestFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class w$a {
    public static final Pattern a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3762b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    public final y c;
    public final Method d;
    public final Annotation[] e;
    public final Annotation[][] f;
    public final Type[] g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3763s;
    public String t;
    public Headers u;
    public MediaType v;
    public Set<String> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t<?>[] f3764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3765y;

    public w$a(y yVar, Method method) {
        this.c = yVar;
        this.d = method;
        this.e = method.getAnnotations();
        this.g = method.getGenericParameterTypes();
        this.f = method.getParameterAnnotations();
    }

    public static Class<?> a(Class<?> cls) {
        if (Boolean.TYPE == cls) {
            return Boolean.class;
        }
        if (Byte.TYPE == cls) {
            return Byte.class;
        }
        if (Character.TYPE == cls) {
            return Character.class;
        }
        if (Double.TYPE == cls) {
            return Double.class;
        }
        if (Float.TYPE == cls) {
            return Float.class;
        }
        if (Integer.TYPE == cls) {
            return Integer.class;
        }
        if (Long.TYPE == cls) {
            return Long.class;
        }
        return Short.TYPE == cls ? Short.class : cls;
    }

    public final void b(String str, String str2, boolean z2) {
        String str3 = this.p;
        if (str3 != null) {
            throw c0.j(this.d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }
        this.p = str;
        this.q = z2;
        if (str2.isEmpty()) {
            return;
        }
        int iIndexOf = str2.indexOf(63);
        if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
            String strSubstring = str2.substring(iIndexOf + 1);
            if (a.matcher(strSubstring).find()) {
                throw c0.j(this.d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
            }
        }
        this.t = str2;
        Matcher matcher = a.matcher(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        this.w = linkedHashSet;
    }

    public final void c(int i, Type type) {
        if (c0.h(type)) {
            throw c0.l(this.d, i, "Parameter type must not include a type variable or wildcard: %s", type);
        }
    }
}
