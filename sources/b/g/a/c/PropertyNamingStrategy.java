package b.g.a.c;

import b.g.a.c.c0.AnnotatedField;
import b.g.a.c.c0.AnnotatedMethod;
import b.g.a.c.c0.AnnotatedParameter;
import b.g.a.c.z.MapperConfig;
import java.io.Serializable;

/* JADX INFO: renamed from: b.g.a.c.u, reason: use source file name */
/* JADX INFO: compiled from: PropertyNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class PropertyNamingStrategy implements Serializable {

    @Deprecated
    public static final PropertyNamingStrategy j = new c();

    @Deprecated
    public static final PropertyNamingStrategy k = new b();
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: b.g.a.c.u$a */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static abstract class a extends PropertyNamingStrategy {
        @Override // b.g.a.c.PropertyNamingStrategy
        public String a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
            return e(str);
        }

        @Override // b.g.a.c.PropertyNamingStrategy
        public String b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
            return e(str);
        }

        @Override // b.g.a.c.PropertyNamingStrategy
        public String c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return e(str);
        }

        @Override // b.g.a.c.PropertyNamingStrategy
        public String d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
            return e(str);
        }

        public abstract String e(String str);
    }

    /* JADX INFO: renamed from: b.g.a.c.u$b */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class b extends a {
        @Override // b.g.a.c.PropertyNamingStrategy.a
        public String e(String str) {
            if (str == null) {
                return str;
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length * 2);
            int i = 0;
            boolean z2 = false;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (i2 > 0 || cCharAt != '_') {
                    if (Character.isUpperCase(cCharAt)) {
                        if (!z2 && i > 0 && sb.charAt(i - 1) != '_') {
                            sb.append('_');
                            i++;
                        }
                        cCharAt = Character.toLowerCase(cCharAt);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    sb.append(cCharAt);
                    i++;
                }
            }
            return i > 0 ? sb.toString() : str;
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.u$c */
    /* JADX INFO: compiled from: PropertyNamingStrategy.java */
    @Deprecated
    public static class c extends a {
        @Override // b.g.a.c.PropertyNamingStrategy.a
        public String e(String str) {
            char cCharAt;
            char upperCase;
            if (str == null || str.isEmpty() || cCharAt == (upperCase = Character.toUpperCase((cCharAt = str.charAt(0))))) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(0, upperCase);
            return sb.toString();
        }
    }

    public String a(MapperConfig<?> mapperConfig, AnnotatedParameter annotatedParameter, String str) {
        return str;
    }

    public String b(MapperConfig<?> mapperConfig, AnnotatedField annotatedField, String str) {
        return str;
    }

    public String c(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }

    public String d(MapperConfig<?> mapperConfig, AnnotatedMethod annotatedMethod, String str) {
        return str;
    }
}
