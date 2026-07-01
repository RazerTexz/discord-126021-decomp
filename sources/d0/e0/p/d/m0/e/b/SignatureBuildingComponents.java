package d0.e0.p.d.m0.e.b;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.w, reason: use source file name */
/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SignatureBuildingComponents {
    public static final SignatureBuildingComponents a = new SignatureBuildingComponents();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.w$a */
    /* JADX INFO: compiled from: SignatureBuildingComponents.kt */
    public static final class a extends Lambda implements Function1<String, CharSequence> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            return SignatureBuildingComponents.this.a(str);
        }
    }

    public final String a(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] constructors(String... strArr) {
        Intrinsics3.checkNotNullParameter(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final Set<String> inClass(String str, String... strArr) {
        Intrinsics3.checkNotNullParameter(str, "internalName");
        Intrinsics3.checkNotNullParameter(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(strArr, "signatures");
        String strJavaLang = javaLang(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaLang, strArr2);
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(strArr, "signatures");
        String strJavaUtil = javaUtil(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaUtil, strArr2);
    }

    public final String javaFunction(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Intrinsics3.stringPlus("java/util/function/", str);
    }

    public final String javaLang(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Intrinsics3.stringPlus("java/lang/", str);
    }

    public final String javaUtil(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return Intrinsics3.stringPlus("java/util/", str);
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "parameters");
        Intrinsics3.checkNotNullParameter(str2, "ret");
        return str + '(' + _Collections.joinToString$default(list, "", null, null, 0, null, new a(), 30, null) + ')' + a(str2);
    }

    public final String signature(String str, String str2) {
        Intrinsics3.checkNotNullParameter(str, "internalName");
        Intrinsics3.checkNotNullParameter(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
