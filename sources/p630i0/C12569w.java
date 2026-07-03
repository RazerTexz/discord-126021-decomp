package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.MediaType;
import p600f0.C12379w;

/* JADX INFO: renamed from: i0.w */
/* JADX INFO: compiled from: RequestFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12569w {

    /* JADX INFO: renamed from: a */
    public final Method f26633a;

    /* JADX INFO: renamed from: b */
    public final C12379w f26634b;

    /* JADX INFO: renamed from: c */
    public final String f26635c;

    /* JADX INFO: renamed from: d */
    public final String f26636d;

    /* JADX INFO: renamed from: e */
    public final Headers f26637e;

    /* JADX INFO: renamed from: f */
    public final MediaType f26638f;

    /* JADX INFO: renamed from: g */
    public final boolean f26639g;

    /* JADX INFO: renamed from: h */
    public final boolean f26640h;

    /* JADX INFO: renamed from: i */
    public final boolean f26641i;

    /* JADX INFO: renamed from: j */
    public final AbstractC12566t<?>[] f26642j;

    /* JADX INFO: renamed from: k */
    public final boolean f26643k;

    /* JADX INFO: renamed from: i0.w$a */
    /* JADX INFO: compiled from: RequestFactory.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final Pattern f26644a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: b */
        public static final Pattern f26645b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* JADX INFO: renamed from: c */
        public final C12571y f26646c;

        /* JADX INFO: renamed from: d */
        public final Method f26647d;

        /* JADX INFO: renamed from: e */
        public final Annotation[] f26648e;

        /* JADX INFO: renamed from: f */
        public final Annotation[][] f26649f;

        /* JADX INFO: renamed from: g */
        public final Type[] f26650g;

        /* JADX INFO: renamed from: h */
        public boolean f26651h;

        /* JADX INFO: renamed from: i */
        public boolean f26652i;

        /* JADX INFO: renamed from: j */
        public boolean f26653j;

        /* JADX INFO: renamed from: k */
        public boolean f26654k;

        /* JADX INFO: renamed from: l */
        public boolean f26655l;

        /* JADX INFO: renamed from: m */
        public boolean f26656m;

        /* JADX INFO: renamed from: n */
        public boolean f26657n;

        /* JADX INFO: renamed from: o */
        public boolean f26658o;

        /* JADX INFO: renamed from: p */
        public String f26659p;

        /* JADX INFO: renamed from: q */
        public boolean f26660q;

        /* JADX INFO: renamed from: r */
        public boolean f26661r;

        /* JADX INFO: renamed from: s */
        public boolean f26662s;

        /* JADX INFO: renamed from: t */
        public String f26663t;

        /* JADX INFO: renamed from: u */
        public Headers f26664u;

        /* JADX INFO: renamed from: v */
        public MediaType f26665v;

        /* JADX INFO: renamed from: w */
        public Set<String> f26666w;

        /* JADX INFO: renamed from: x */
        public AbstractC12566t<?>[] f26667x;

        /* JADX INFO: renamed from: y */
        public boolean f26668y;

        public a(C12571y c12571y, Method method) {
            this.f26646c = c12571y;
            this.f26647d = method;
            this.f26648e = method.getAnnotations();
            this.f26650g = method.getGenericParameterTypes();
            this.f26649f = method.getParameterAnnotations();
        }

        /* JADX INFO: renamed from: a */
        public static Class<?> m10722a(Class<?> cls) {
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

        /* JADX INFO: renamed from: b */
        public final void m10723b(String str, String str2, boolean z2) {
            String str3 = this.f26659p;
            if (str3 != null) {
                throw C12503c0.m10690j(this.f26647d, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f26659p = str;
            this.f26660q = z2;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f26644a.matcher(strSubstring).find()) {
                    throw C12503c0.m10690j(this.f26647d, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f26663t = str2;
            Matcher matcher = f26644a.matcher(str2);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            this.f26666w = linkedHashSet;
        }

        /* JADX INFO: renamed from: c */
        public final void m10724c(int i, Type type) {
            if (C12503c0.m10688h(type)) {
                throw C12503c0.m10692l(this.f26647d, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public C12569w(a aVar) {
        this.f26633a = aVar.f26647d;
        this.f26634b = aVar.f26646c.f26675c;
        this.f26635c = aVar.f26659p;
        this.f26636d = aVar.f26663t;
        this.f26637e = aVar.f26664u;
        this.f26638f = aVar.f26665v;
        this.f26639g = aVar.f26660q;
        this.f26640h = aVar.f26661r;
        this.f26641i = aVar.f26662s;
        this.f26642j = aVar.f26667x;
        this.f26643k = aVar.f26668y;
    }
}
