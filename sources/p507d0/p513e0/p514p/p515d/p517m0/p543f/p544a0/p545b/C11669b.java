package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p588x.C12197c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.b */
/* JADX INFO: compiled from: ClassMapperLite.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11669b {

    /* JADX INFO: renamed from: a */
    public static final C11669b f23700a = new C11669b();

    /* JADX INFO: renamed from: b */
    public static final String f23701b = C12163u.joinToString$default(C12147n.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c */
    public static final Map<String, String> f23702c;

    static {
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listListOf = C12147n.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = C12197c.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                StringBuilder sb = new StringBuilder();
                String str = f23701b;
                sb.append(str);
                sb.append(MentionUtilsKt.SLASH_CHAR);
                sb.append((String) listListOf.get(i2));
                int i4 = i2 + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i4));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(MentionUtilsKt.SLASH_CHAR);
                linkedHashMap.put(C1643a.m822J(sb2, (String) listListOf.get(i2), "Array"), C12238m.stringPlus("[", listListOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                } else {
                    i2 = i3;
                }
            }
        }
        linkedHashMap.put(C12238m.stringPlus(f23701b, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m9585a(linkedHashMap, "Any", "java/lang/Object");
        m9585a(linkedHashMap, "Nothing", "java/lang/Void");
        m9585a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : C12147n.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            m9585a(linkedHashMap, str2, C12238m.stringPlus("java/lang/", str2));
        }
        for (String str3 : C12147n.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            m9585a(linkedHashMap, C12238m.stringPlus("collections/", str3), C12238m.stringPlus("java/util/", str3));
            m9585a(linkedHashMap, C12238m.stringPlus("collections/Mutable", str3), C12238m.stringPlus("java/util/", str3));
        }
        m9585a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m9585a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m9585a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m9585a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String strStringPlus = C12238m.stringPlus("Function", Integer.valueOf(i));
            StringBuilder sb3 = new StringBuilder();
            String str4 = f23701b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i);
            m9585a(linkedHashMap, strStringPlus, sb3.toString());
            m9585a(linkedHashMap, C12238m.stringPlus("reflect/KFunction", Integer.valueOf(i)), C12238m.stringPlus(str4, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            } else {
                i = i5;
            }
        }
        for (String str5 : C12147n.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            m9585a(linkedHashMap, C12238m.stringPlus(str5, ".Companion"), f23701b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f23702c = linkedHashMap;
    }

    /* JADX INFO: renamed from: a */
    public static final void m9585a(Map<String, String> map, String str, String str2) {
        map.put(f23701b + MentionUtilsKt.SLASH_CHAR + str, 'L' + str2 + ';');
    }

    public static final String mapClass(String str) {
        C12238m.checkNotNullParameter(str, "classId");
        String str2 = f23702c.get(str);
        return str2 == null ? C1643a.m820H(C1643a.m829Q('L'), C12103t.replace$default(str, '.', '$', false, 4, (Object) null), ';') : str2;
    }
}
