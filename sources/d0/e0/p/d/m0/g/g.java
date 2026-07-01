package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: SpecialNames.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final e a = e.special("<no name provided>");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f3425b;
    public static final e c;

    static {
        e.special("<root package>");
        f3425b = e.identifier("Companion");
        c = e.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        e.special("<anonymous>");
    }

    public static /* synthetic */ void a(int i) {
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

    public static boolean isSafeIdentifier(e eVar) {
        if (eVar != null) {
            return (eVar.asString().isEmpty() || eVar.isSpecial()) ? false : true;
        }
        a(1);
        throw null;
    }

    public static e safeIdentifier(e eVar) {
        if (eVar == null || eVar.isSpecial()) {
            eVar = c;
        }
        if (eVar != null) {
            return eVar;
        }
        a(0);
        throw null;
    }
}
