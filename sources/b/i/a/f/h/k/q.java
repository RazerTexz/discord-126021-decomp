package b.i.a.f.h.k;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q {
    public static final String[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Integer> f1433b;

    static {
        String[] strArr = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity", "thing_proto"};
        a = strArr;
        f1433b = new HashMap(strArr.length);
        int i = 0;
        while (true) {
            String[] strArr2 = a;
            if (i >= strArr2.length) {
                return;
            }
            f1433b.put(strArr2[i], Integer.valueOf(i));
            i++;
        }
    }
}
