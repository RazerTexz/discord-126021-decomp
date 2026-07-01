package b.i.d;

import b.d.b.a.outline;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.d.c, reason: use source file name */
/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FieldNamingPolicy implements FieldNamingStrategy {
    public static final FieldNamingPolicy j;
    public static final FieldNamingPolicy k;
    public static final FieldNamingPolicy l;
    public static final FieldNamingPolicy m;
    public static final FieldNamingPolicy n;
    public static final FieldNamingPolicy o;
    public static final /* synthetic */ FieldNamingPolicy[] p;

    /* JADX INFO: renamed from: b.i.d.c$a */
    /* JADX INFO: compiled from: FieldNamingPolicy.java */
    public final enum a extends FieldNamingPolicy {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // b.i.d.FieldNamingStrategy
        public String f(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        j = aVar;
        FieldNamingPolicy fieldNamingPolicy = new FieldNamingPolicy("UPPER_CAMEL_CASE", 1) { // from class: b.i.d.c.b
            @Override // b.i.d.FieldNamingStrategy
            public String f(Field field) {
                return FieldNamingPolicy.h(field.getName());
            }
        };
        k = fieldNamingPolicy;
        FieldNamingPolicy fieldNamingPolicy2 = new FieldNamingPolicy("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: b.i.d.c.c
            @Override // b.i.d.FieldNamingStrategy
            public String f(Field field) {
                return FieldNamingPolicy.h(FieldNamingPolicy.g(field.getName(), " "));
            }
        };
        l = fieldNamingPolicy2;
        FieldNamingPolicy fieldNamingPolicy3 = new FieldNamingPolicy("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: b.i.d.c.d
            @Override // b.i.d.FieldNamingStrategy
            public String f(Field field) {
                return FieldNamingPolicy.g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        m = fieldNamingPolicy3;
        FieldNamingPolicy fieldNamingPolicy4 = new FieldNamingPolicy("LOWER_CASE_WITH_DASHES", 4) { // from class: b.i.d.c.e
            @Override // b.i.d.FieldNamingStrategy
            public String f(Field field) {
                return FieldNamingPolicy.g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        n = fieldNamingPolicy4;
        FieldNamingPolicy fieldNamingPolicy5 = new FieldNamingPolicy("LOWER_CASE_WITH_DOTS", 5) { // from class: b.i.d.c.f
            @Override // b.i.d.FieldNamingStrategy
            public String f(Field field) {
                return FieldNamingPolicy.g(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        o = fieldNamingPolicy5;
        p = new FieldNamingPolicy[]{aVar, fieldNamingPolicy, fieldNamingPolicy2, fieldNamingPolicy3, fieldNamingPolicy4, fieldNamingPolicy5};
    }

    public FieldNamingPolicy(String str, int i, a aVar) {
        super(str, i);
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static String h(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char cCharAt = str.charAt(i);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        if (i == 0) {
            StringBuilder sbQ = outline.Q(upperCase);
            sbQ.append(str.substring(1));
            return sbQ.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) p.clone();
    }
}
