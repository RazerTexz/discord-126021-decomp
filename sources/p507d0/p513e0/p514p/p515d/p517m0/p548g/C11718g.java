package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.g */
/* JADX INFO: compiled from: SpecialNames.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11718g {

    /* JADX INFO: renamed from: a */
    public static final C11716e f24092a = C11716e.special("<no name provided>");

    /* JADX INFO: renamed from: b */
    public static final C11716e f24093b;

    /* JADX INFO: renamed from: c */
    public static final C11716e f24094c;

    static {
        C11716e.special("<root package>");
        f24093b = C11716e.identifier("Companion");
        f24094c = C11716e.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        C11716e.special("<anonymous>");
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m9821a(int i) {
        String str = i != 1 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 1 ? 2 : 3];
        if (i != 1) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        } else {
            objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
        }
        if (i != 1) {
            objArr[1] = "safeIdentifier";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        }
        if (i == 1) {
            objArr[2] = "isSafeIdentifier";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static boolean isSafeIdentifier(C11716e c11716e) {
        if (c11716e != null) {
            return (c11716e.asString().isEmpty() || c11716e.isSpecial()) ? false : true;
        }
        m9821a(1);
        throw null;
    }

    public static C11716e safeIdentifier(C11716e c11716e) {
        if (c11716e == null || c11716e.isSpecial()) {
            c11716e = f24094c;
        }
        if (c11716e != null) {
            return c11716e;
        }
        m9821a(0);
        throw null;
    }
}
