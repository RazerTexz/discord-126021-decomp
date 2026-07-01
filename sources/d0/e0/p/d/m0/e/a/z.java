package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class z {
    public static final z a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.g.b f3360b = new d0.e0.p.d.m0.g.b("kotlin.jvm.JvmField");

    static {
        d0.z.d.m.checkNotNullExpressionValue(d0.e0.p.d.m0.g.a.topLevel(new d0.e0.p.d.m0.g.b("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    public static final String getterName(String str) {
        d0.z.d.m.checkNotNullParameter(str, "propertyName");
        return startsWithIsPrefix(str) ? str : d0.z.d.m.stringPlus("get", d0.e0.p.d.m0.o.m.a.capitalizeAsciiOnly(str));
    }

    public static final boolean isGetterName(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.g0.t.startsWith$default(str, "get", false, 2, null) || d0.g0.t.startsWith$default(str, "is", false, 2, null);
    }

    public static final boolean isSetterName(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.g0.t.startsWith$default(str, "set", false, 2, null);
    }

    public static final String setterName(String str) {
        String strCapitalizeAsciiOnly;
        d0.z.d.m.checkNotNullParameter(str, "propertyName");
        if (startsWithIsPrefix(str)) {
            strCapitalizeAsciiOnly = str.substring(2);
            d0.z.d.m.checkNotNullExpressionValue(strCapitalizeAsciiOnly, "(this as java.lang.String).substring(startIndex)");
        } else {
            strCapitalizeAsciiOnly = d0.e0.p.d.m0.o.m.a.capitalizeAsciiOnly(str);
        }
        return d0.z.d.m.stringPlus("set", strCapitalizeAsciiOnly);
    }

    public static final boolean startsWithIsPrefix(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!d0.g0.t.startsWith$default(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return d0.z.d.m.compare(97, cCharAt) > 0 || d0.z.d.m.compare(cCharAt, 122) > 0;
    }
}
