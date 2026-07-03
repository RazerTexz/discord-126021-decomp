package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.p574m.C12031a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.z */
/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11632z {

    /* JADX INFO: renamed from: a */
    public static final C11632z f23531a = null;

    /* JADX INFO: renamed from: b */
    public static final C11713b f23532b = new C11713b("kotlin.jvm.JvmField");

    static {
        C12238m.checkNotNullExpressionValue(C11712a.topLevel(new C11713b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    public static final String getterName(String str) {
        C12238m.checkNotNullParameter(str, "propertyName");
        return startsWithIsPrefix(str) ? str : C12238m.stringPlus("get", C12031a.capitalizeAsciiOnly(str));
    }

    public static final boolean isGetterName(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12103t.startsWith$default(str, "get", false, 2, null) || C12103t.startsWith$default(str, "is", false, 2, null);
    }

    public static final boolean isSetterName(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12103t.startsWith$default(str, "set", false, 2, null);
    }

    public static final String setterName(String str) {
        String strCapitalizeAsciiOnly;
        C12238m.checkNotNullParameter(str, "propertyName");
        if (startsWithIsPrefix(str)) {
            strCapitalizeAsciiOnly = str.substring(2);
            C12238m.checkNotNullExpressionValue(strCapitalizeAsciiOnly, "(this as java.lang.String).substring(startIndex)");
        } else {
            strCapitalizeAsciiOnly = C12031a.capitalizeAsciiOnly(str);
        }
        return C12238m.stringPlus("set", strCapitalizeAsciiOnly);
    }

    public static final boolean startsWithIsPrefix(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!C12103t.startsWith$default(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return C12238m.compare(97, cCharAt) > 0 || C12238m.compare(cCharAt, 122) > 0;
    }
}
