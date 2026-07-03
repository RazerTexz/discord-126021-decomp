package p600f0;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.i */
/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12365i {

    /* JADX INFO: renamed from: a */
    public final Map<String, String> f25907a;

    /* JADX INFO: renamed from: b */
    public final String f25908b;

    public C12365i(String str, Map<String, String> map) {
        String lowerCase;
        C12238m.checkParameterIsNotNull(str, "scheme");
        C12238m.checkParameterIsNotNull(map, "authParams");
        this.f25908b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                C12238m.checkExpressionValueIsNotNull(locale, "US");
                lowerCase = key.toLowerCase(locale);
                C12238m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        C12238m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f25907a = mapUnmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12365i) {
            C12365i c12365i = (C12365i) obj;
            if (C12238m.areEqual(c12365i.f25908b, this.f25908b) && C12238m.areEqual(c12365i.f25907a, this.f25907a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f25907a.hashCode() + C1643a.m863m(this.f25908b, 899, 31);
    }

    public String toString() {
        return this.f25908b + " authParams=" + this.f25907a;
    }
}
