package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public static final w a = new w();

    public static final /* synthetic */ String access$escapeClassName(w wVar, String str) {
        return wVar.a(str);
    }

    public final String a(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] constructors(String... strArr) {
        d0.z.d.m.checkNotNullParameter(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final Set<String> inClass(String str, String... strArr) {
        d0.z.d.m.checkNotNullParameter(str, "internalName");
        d0.z.d.m.checkNotNullParameter(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(strArr, "signatures");
        String strJavaLang = javaLang(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaLang, strArr2);
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(strArr, "signatures");
        String strJavaUtil = javaUtil(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaUtil, strArr2);
    }

    public final String javaFunction(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.z.d.m.stringPlus("java/util/function/", str);
    }

    public final String javaLang(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.z.d.m.stringPlus("java/lang/", str);
    }

    public final String javaUtil(String str) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.z.d.m.stringPlus("java/util/", str);
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(list, "parameters");
        d0.z.d.m.checkNotNullParameter(str2, "ret");
        return str + '(' + d0.t.u.joinToString$default(list, "", null, null, 0, null, new w$a(this), 30, null) + ')' + a(str2);
    }

    public final String signature(String str, String str2) {
        d0.z.d.m.checkNotNullParameter(str, "internalName");
        d0.z.d.m.checkNotNullParameter(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
