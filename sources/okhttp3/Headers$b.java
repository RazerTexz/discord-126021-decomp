package okhttp3;

import d0.d0.f;
import d0.g0.w;
import d0.z.d.m;
import f0.e0.c;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers$b {
    public Headers$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(String str) {
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!('!' <= cCharAt && '~' >= cCharAt)) {
                throw new IllegalArgumentException(c.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
            }
        }
    }

    public final void b(String str, String str2) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                throw new IllegalArgumentException(c.j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
            }
        }
    }

    public final Headers c(String... strArr) {
        m.checkParameterIsNotNull(strArr, "namesAndValues");
        if (!(strArr.length % 2 == 0)) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        Object objClone = strArr.clone();
        if (objClone == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        }
        String[] strArr2 = (String[]) objClone;
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            if (!(strArr2[i] != null)) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            String str = strArr2[i];
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            strArr2[i] = w.trim(str).toString();
        }
        IntProgression intProgressionStep = f.step(f.until(0, strArr2.length), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                String str2 = strArr2[first];
                String str3 = strArr2[first + 1];
                a(str2);
                b(str3, str2);
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return new Headers(strArr2, null);
    }
}
