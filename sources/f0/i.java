package f0;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3671b;

    public i(String str, Map<String, String> map) {
        String lowerCase;
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        d0.z.d.m.checkParameterIsNotNull(map, "authParams");
        this.f3671b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<String, String> map$Entry : map.entrySet()) {
            String key = map$Entry.getKey();
            String value = map$Entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                d0.z.d.m.checkExpressionValueIsNotNull(locale, "US");
                lowerCase = key.toLowerCase(locale);
                d0.z.d.m.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        d0.z.d.m.checkExpressionValueIsNotNull(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.a = mapUnmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (d0.z.d.m.areEqual(iVar.f3671b, this.f3671b) && d0.z.d.m.areEqual(iVar.a, this.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + b.d.b.a.a.m(this.f3671b, 899, 31);
    }

    public String toString() {
        return this.f3671b + " authParams=" + this.a;
    }
}
