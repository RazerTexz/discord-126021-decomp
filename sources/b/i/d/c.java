package b.i.d;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements d {
    public static final c j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final /* synthetic */ c[] p;

    static {
        c$a c_a = new c$a("IDENTITY", 0);
        j = c_a;
        c$b c_b = new c$b("UPPER_CAMEL_CASE", 1);
        k = c_b;
        c$c c_c = new c$c("UPPER_CAMEL_CASE_WITH_SPACES", 2);
        l = c_c;
        c$d c_d = new c$d("LOWER_CASE_WITH_UNDERSCORES", 3);
        m = c_d;
        c$e c_e = new c$e("LOWER_CASE_WITH_DASHES", 4);
        n = c_e;
        c$f c_f = new c$f("LOWER_CASE_WITH_DOTS", 5);
        o = c_f;
        p = new c[]{c_a, c_b, c_c, c_d, c_e, c_f};
    }

    public c(String str, int i, c$a c_a) {
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
            StringBuilder sbQ = b.d.b.a.a.Q(upperCase);
            sbQ.append(str.substring(1));
            return sbQ.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static c valueOf(String str) {
        return (c) Enum.valueOf(c.class, str);
    }

    public static c[] values() {
        return (c[]) p.clone();
    }
}
