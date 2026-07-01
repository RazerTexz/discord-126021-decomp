package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.MapperFeature;
import b.g.a.c.c0.AccessorNamingStrategy;
import b.g.a.c.d0.JDK14Util;
import b.g.a.c.i0.ClassUtil;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.c.c0.w, reason: use source file name */
/* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f695b;
    public final String c;
    public final String d;
    public final String e;

    /* JADX INFO: renamed from: b.g.a.c.c0.w$a */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public interface a {
        boolean a(char c, String str, int i);
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.w$b */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class b extends AccessorNamingStrategy.a implements Serializable {
        private static final long serialVersionUID = 1;
        public final String _setterPrefix = "set";
        public final String _withPrefix = "with";
        public final String _getterPrefix = "get";
        public final String _isGetterPrefix = "is";
        public final a _baseNameValidator = null;
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.w$c */
    /* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
    public static class c extends DefaultAccessorNamingStrategy {
        public final Set<String> f;

        public c(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            super(mapperConfig, annotatedClass, null, "get", "is", null);
            this.f = new HashSet();
            Class<?> cls = annotatedClass.l;
            RuntimeException runtimeException = JDK14Util.f697b;
            if (runtimeException != null) {
                throw runtimeException;
            }
            JDK14Util jDK14Util = JDK14Util.a;
            Objects.requireNonNull(jDK14Util);
            try {
                Object[] objArr = (Object[]) jDK14Util.c.invoke(cls, new Object[0]);
                int length = objArr.length;
                String[] strArr = new String[length];
                for (int i = 0; i < objArr.length; i++) {
                    try {
                        strArr[i] = (String) jDK14Util.d.invoke(objArr[i], new Object[0]);
                    } catch (Exception e) {
                        throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArr.length), ClassUtil.u(cls)), e);
                    }
                }
                for (int i2 = 0; i2 < length; i2++) {
                    this.f.add(strArr[i2]);
                }
            } catch (Exception unused) {
                StringBuilder sbU = outline.U("Failed to access RecordComponents of type ");
                sbU.append(ClassUtil.u(cls));
                throw new IllegalArgumentException(sbU.toString());
            }
        }

        @Override // b.g.a.c.c0.DefaultAccessorNamingStrategy, b.g.a.c.c0.AccessorNamingStrategy
        public String c(AnnotatedMethod annotatedMethod, String str) {
            return this.f.contains(str) ? str : super.c(annotatedMethod, str);
        }
    }

    public DefaultAccessorNamingStrategy(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, String str, String str2, String str3, a aVar) {
        this.f695b = mapperConfig.q(MapperFeature.USE_STD_BEAN_NAMING);
        this.e = str;
        this.c = str2;
        this.d = str3;
        this.a = aVar;
    }

    @Override // b.g.a.c.c0.AccessorNamingStrategy
    public String a(AnnotatedMethod annotatedMethod, String str) {
        if (this.d == null) {
            return null;
        }
        Class<?> clsD = annotatedMethod.d();
        if ((clsD == Boolean.class || clsD == Boolean.TYPE) && str.startsWith(this.d)) {
            return this.f695b ? e(str, 2) : d(str, 2);
        }
        return null;
    }

    @Override // b.g.a.c.c0.AccessorNamingStrategy
    public String b(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this.e;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        return this.f695b ? e(str, this.e.length()) : d(str, this.e.length());
    }

    @Override // b.g.a.c.c0.AccessorNamingStrategy
    public String c(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this.c;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            Class<?> clsD = annotatedMethod.d();
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
        } else if ("getMetaClass".equals(str) && annotatedMethod.d().getName().startsWith("groovy.lang")) {
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
        a aVar = this.a;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
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
        a aVar = this.a;
        if (aVar != null && !aVar.a(cCharAt, str, i)) {
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
