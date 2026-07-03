package p007b.p225i.p408d;

import java.lang.reflect.Field;
import java.util.Locale;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: b.i.d.c */
/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class EnumC4899c implements InterfaceC4900d {

    /* JADX INFO: renamed from: j */
    public static final EnumC4899c f13088j;

    /* JADX INFO: renamed from: k */
    public static final EnumC4899c f13089k;

    /* JADX INFO: renamed from: l */
    public static final EnumC4899c f13090l;

    /* JADX INFO: renamed from: m */
    public static final EnumC4899c f13091m;

    /* JADX INFO: renamed from: n */
    public static final EnumC4899c f13092n;

    /* JADX INFO: renamed from: o */
    public static final EnumC4899c f13093o;

    /* JADX INFO: renamed from: p */
    public static final /* synthetic */ EnumC4899c[] f13094p;

    /* JADX INFO: renamed from: b.i.d.c$a */
    /* JADX INFO: compiled from: FieldNamingPolicy.java */
    public final enum a extends EnumC4899c {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // p007b.p225i.p408d.InterfaceC4900d
        /* JADX INFO: renamed from: f */
        public String mo6850f(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        f13088j = aVar;
        EnumC4899c enumC4899c = new EnumC4899c("UPPER_CAMEL_CASE", 1) { // from class: b.i.d.c.b
            @Override // p007b.p225i.p408d.InterfaceC4900d
            /* JADX INFO: renamed from: f */
            public String mo6850f(Field field) {
                return EnumC4899c.m6849h(field.getName());
            }
        };
        f13089k = enumC4899c;
        EnumC4899c enumC4899c2 = new EnumC4899c("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: b.i.d.c.c
            @Override // p007b.p225i.p408d.InterfaceC4900d
            /* JADX INFO: renamed from: f */
            public String mo6850f(Field field) {
                return EnumC4899c.m6849h(EnumC4899c.m6848g(field.getName(), " "));
            }
        };
        f13090l = enumC4899c2;
        EnumC4899c enumC4899c3 = new EnumC4899c("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: b.i.d.c.d
            @Override // p007b.p225i.p408d.InterfaceC4900d
            /* JADX INFO: renamed from: f */
            public String mo6850f(Field field) {
                return EnumC4899c.m6848g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        f13091m = enumC4899c3;
        EnumC4899c enumC4899c4 = new EnumC4899c("LOWER_CASE_WITH_DASHES", 4) { // from class: b.i.d.c.e
            @Override // p007b.p225i.p408d.InterfaceC4900d
            /* JADX INFO: renamed from: f */
            public String mo6850f(Field field) {
                return EnumC4899c.m6848g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        f13092n = enumC4899c4;
        EnumC4899c enumC4899c5 = new EnumC4899c("LOWER_CASE_WITH_DOTS", 5) { // from class: b.i.d.c.f
            @Override // p007b.p225i.p408d.InterfaceC4900d
            /* JADX INFO: renamed from: f */
            public String mo6850f(Field field) {
                return EnumC4899c.m6848g(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        f13093o = enumC4899c5;
        f13094p = new EnumC4899c[]{aVar, enumC4899c, enumC4899c2, enumC4899c3, enumC4899c4, enumC4899c5};
    }

    public EnumC4899c(String str, int i, a aVar) {
        super(str, i);
    }

    /* JADX INFO: renamed from: g */
    public static String m6848g(String str, String str2) {
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

    /* JADX INFO: renamed from: h */
    public static String m6849h(String str) {
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
            StringBuilder sbM829Q = C1643a.m829Q(upperCase);
            sbM829Q.append(str.substring(1));
            return sbM829Q.toString();
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static EnumC4899c valueOf(String str) {
        return (EnumC4899c) Enum.valueOf(EnumC4899c.class, str);
    }

    public static EnumC4899c[] values() {
        return (EnumC4899c[]) f13094p.clone();
    }
}
