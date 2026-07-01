package d0.e0.p.d.m0.e.a;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.o.m.capitalizeDecapitalize;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.z, reason: use source file name */
/* JADX INFO: compiled from: JvmAbi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmAbi {
    public static final JvmAbi a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FqName f3360b = new FqName("kotlin.jvm.JvmField");

    static {
        Intrinsics3.checkNotNullExpressionValue(ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.reflect.jvm.internal.ReflectionFactoryImpl\"))");
    }

    public static final String getterName(String str) {
        Intrinsics3.checkNotNullParameter(str, "propertyName");
        return startsWithIsPrefix(str) ? str : Intrinsics3.stringPlus("get", capitalizeDecapitalize.capitalizeAsciiOnly(str));
    }

    public static final boolean isGetterName(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return StringsJVM.startsWith$default(str, "get", false, 2, null) || StringsJVM.startsWith$default(str, "is", false, 2, null);
    }

    public static final boolean isSetterName(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return StringsJVM.startsWith$default(str, "set", false, 2, null);
    }

    public static final String setterName(String str) {
        String strCapitalizeAsciiOnly;
        Intrinsics3.checkNotNullParameter(str, "propertyName");
        if (startsWithIsPrefix(str)) {
            strCapitalizeAsciiOnly = str.substring(2);
            Intrinsics3.checkNotNullExpressionValue(strCapitalizeAsciiOnly, "(this as java.lang.String).substring(startIndex)");
        } else {
            strCapitalizeAsciiOnly = capitalizeDecapitalize.capitalizeAsciiOnly(str);
        }
        return Intrinsics3.stringPlus("set", strCapitalizeAsciiOnly);
    }

    public static final boolean startsWithIsPrefix(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!StringsJVM.startsWith$default(str, "is", false, 2, null) || str.length() == 2) {
            return false;
        }
        char cCharAt = str.charAt(2);
        return Intrinsics3.compare(97, cCharAt) > 0 || Intrinsics3.compare(cCharAt, 122) > 0;
    }
}
