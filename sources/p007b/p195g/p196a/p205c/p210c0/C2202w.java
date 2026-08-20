package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.EnumC2366p;
import p007b.p195g.p196a.p205c.p211d0.C2207a;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p221z.AbstractC2394l;

/* JADX INFO: renamed from: b.g.a.c.c0.w */
/* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2202w extends AbstractC2173a {

    /* JADX INFO: renamed from: a */
    public final a f4751a;

    /* JADX INFO: renamed from: b */
    public final boolean f4752b;

    /* JADX INFO: renamed from: c */
    public final String f4753c;

    /* JADX INFO: renamed from: d */
    public final String f4754d;

    /* JADX INFO: renamed from: e */
    public final String f4755e;

    /* JADX INFO: renamed from: b.g.a.c.c0.w$a */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        boolean m1932a(char c, String str, int i);
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.w$b */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class b extends AbstractC2173a.a implements Serializable {
        private static final long serialVersionUID = 1;
        public final String _setterPrefix = "set";
        public final String _withPrefix = "with";
        public final String _getterPrefix = "get";
        public final String _isGetterPrefix = "is";
        public final a _baseNameValidator = null;
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.w$c */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class c extends C2202w {

        /* JADX INFO: renamed from: f */
        public final Set<String> f4756f;

        public c(AbstractC2394l<?> abstractC2394l, C2177c c2177c) {
            super(abstractC2394l, c2177c, null, "get", "is", null);
            this.f4756f = new HashSet();
            Class<?> cls = c2177c.f4655l;
            RuntimeException runtimeException = C2207a.f4767b;
            if (runtimeException != null) {
                throw runtimeException;
            }
            C2207a c2207a = C2207a.f4766a;
            Objects.requireNonNull(c2207a);
            try {
                Object[] objArr = (Object[]) c2207a.f4768c.invoke(cls, new Object[0]);
                int length = objArr.length;
                String[] strArr = new String[length];
                for (int i = 0; i < objArr.length; i++) {
                    try {
                        strArr[i] = (String) c2207a.f4769d.invoke(objArr[i], new Object[0]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArr.length), C2342d.m2189u(cls)), e);
                    }
                }
                for (int i2 = 0; i2 < length; i2++) {
                    this.f4756f.add(strArr[i2]);
                }
            } catch (Exception unused) {
                StringBuilder sbM833U = C1643a.m833U("Failed to access RecordComponents of type ");
                sbM833U.append(C2342d.m2189u(cls));
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }

        @Override // p007b.p195g.p196a.p205c.p210c0.C2202w, p007b.p195g.p196a.p205c.p210c0.AbstractC2173a
        /* JADX INFO: renamed from: c */
        public String mo1817c(C2189j c2189j, String str) {
            return this.f4756f.contains(str) ? str : super.mo1817c(c2189j, str);
        }
    }

    public C2202w(AbstractC2394l<?> abstractC2394l, C2177c c2177c, String str, String str2, String str3, a aVar) {
        this.f4752b = abstractC2394l.m2279q(EnumC2366p.USE_STD_BEAN_NAMING);
        this.f4755e = str;
        this.f4753c = str2;
        this.f4754d = str3;
        this.f4751a = aVar;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2173a
    /* JADX INFO: renamed from: a */
    public String mo1815a(C2189j c2189j, String str) {
        if (this.f4754d == null) {
            return null;
        }
        Class<?> clsMo1820d = c2189j.mo1820d();
        if ((clsMo1820d == Boolean.class || clsMo1820d == Boolean.TYPE) && str.startsWith(this.f4754d)) {
            return this.f4752b ? m1931e(str, 2) : m1930d(str, 2);
        }
        return null;
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2173a
    /* JADX INFO: renamed from: b */
    public String mo1816b(C2189j c2189j, String str) {
        String str2 = this.f4755e;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f4752b ? m1931e(str, this.f4755e.length()) : m1930d(str, this.f4755e.length());
    }

    @Override // p007b.p195g.p196a.p205c.p210c0.AbstractC2173a
    /* JADX INFO: renamed from: c */
    public String mo1817c(C2189j c2189j, String str) {
        String str2 = this.f4753c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> clsMo1820d = c2189j.mo1820d();
            boolean z2 = false;
            if (clsMo1820d.isArray()) {
                String name = clsMo1820d.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && c2189j.mo1820d().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.f4752b ? m1931e(str, this.f4753c.length()) : m1930d(str, this.f4753c.length());
    }

    /* JADX INFO: renamed from: d */
    public String m1930d(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.f4751a;
        if (aVar != null && !aVar.m1932a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char cCharAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(cCharAt2);
            if (cCharAt2 == lowerCase2) {
                sb.append((CharSequence) str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public String m1931e(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        a aVar = this.f4751a;
        if (aVar != null && !aVar.m1932a(cCharAt, str, i)) {
            return null;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        if (cCharAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append((CharSequence) str, i2, length);
        return sb.toString();
    }
}
