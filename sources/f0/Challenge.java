package f0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: f0.i, reason: use source file name */
/* JADX INFO: compiled from: Challenge.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Challenge {
    public final Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3671b;

    public Challenge(String str, Map<String, String> map) {
        String lowerCase;
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        Intrinsics3.checkParameterIsNotNull(map, "authParams");
        this.f3671b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                Intrinsics3.checkExpressionValueIsNotNull(locale, "US");
                lowerCase = key.toLowerCase(locale);
                Intrinsics3.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics3.checkExpressionValueIsNotNull(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.a = mapUnmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Challenge) {
            Challenge challenge = (Challenge) obj;
            if (Intrinsics3.areEqual(challenge.f3671b, this.f3671b) && Intrinsics3.areEqual(challenge.a, this.a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + outline.m(this.f3671b, 899, 31);
    }

    public String toString() {
        return this.f3671b + " authParams=" + this.a;
    }
}
