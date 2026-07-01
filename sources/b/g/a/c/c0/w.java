package b.g.a.c.c0;

/* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class w extends a {
    public final w$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f695b;
    public final String c;
    public final String d;
    public final String e;

    public w(b.g.a.c.z.l<?> lVar, c cVar, String str, String str2, String str3, w$a w_a) {
        this.f695b = lVar.q(b.g.a.c.p.USE_STD_BEAN_NAMING);
        this.e = str;
        this.c = str2;
        this.d = str3;
        this.a = w_a;
    }

    @Override // b.g.a.c.c0.a
    public String a(j jVar, String str) {
        if (this.d == null) {
            return null;
        }
        Class<?> clsD = jVar.d();
        if ((clsD == Boolean.class || clsD == Boolean.TYPE) && str.startsWith(this.d)) {
            return this.f695b ? e(str, 2) : d(str, 2);
        }
        return null;
    }

    @Override // b.g.a.c.c0.a
    public String b(j jVar, String str) {
        String str2 = this.e;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f695b ? e(str, this.e.length()) : d(str, this.e.length());
    }

    @Override // b.g.a.c.c0.a
    public String c(j jVar, String str) {
        String str2 = this.c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> clsD = jVar.d();
            boolean z2 = false;
            if (clsD.isArray()) {
                String name = clsD.getComponentType().getName();
                if (name.contains(".cglib") && (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib"))) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && jVar.d().getName().startsWith("groovy.lang")) {
            return null;
        }
        return this.f695b ? e(str, this.c.length()) : d(str, this.c.length());
    }

    public String d(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        w$a w_a = this.a;
        if (w_a != null && !w_a.a(cCharAt, str, i)) {
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

    public String e(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char cCharAt = str.charAt(i);
        w$a w_a = this.a;
        if (w_a != null && !w_a.a(cCharAt, str, i)) {
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
