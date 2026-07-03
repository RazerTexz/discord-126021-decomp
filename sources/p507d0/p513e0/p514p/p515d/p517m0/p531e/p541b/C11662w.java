package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.w */
/* JADX INFO: compiled from: SignatureBuildingComponents.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11662w {

    /* JADX INFO: renamed from: a */
    public static final C11662w f23636a = new C11662w();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.w$a */
    /* JADX INFO: compiled from: SignatureBuildingComponents.kt */
    public static final class a extends AbstractC12240o implements Function1<String, CharSequence> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return C11662w.this.m9550a(str);
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m9550a(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + ';';
    }

    public final String[] constructors(String... strArr) {
        C12238m.checkNotNullParameter(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public final Set<String> inClass(String str, String... strArr) {
        C12238m.checkNotNullParameter(str, "internalName");
        C12238m.checkNotNullParameter(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    public final Set<String> inJavaLang(String str, String... strArr) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(strArr, "signatures");
        String strJavaLang = javaLang(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaLang, strArr2);
    }

    public final Set<String> inJavaUtil(String str, String... strArr) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(strArr, "signatures");
        String strJavaUtil = javaUtil(str);
        String[] strArr2 = new String[strArr.length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return inClass(strJavaUtil, strArr2);
    }

    public final String javaFunction(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12238m.stringPlus("java/util/function/", str);
    }

    public final String javaLang(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12238m.stringPlus("java/lang/", str);
    }

    public final String javaUtil(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return C12238m.stringPlus("java/util/", str);
    }

    public final String jvmDescriptor(String str, List<String> list, String str2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(list, "parameters");
        C12238m.checkNotNullParameter(str2, "ret");
        return str + '(' + C12163u.joinToString$default(list, "", null, null, 0, null, new a(), 30, null) + ')' + m9550a(str2);
    }

    public final String signature(String str, String str2) {
        C12238m.checkNotNullParameter(str, "internalName");
        C12238m.checkNotNullParameter(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
