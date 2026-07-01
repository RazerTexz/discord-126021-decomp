package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0.f;
import d0.g0.t;
import d0.o;
import d0.t.r;
import d0.z.d.c;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, a {
    public static final Headers$b j = new Headers$b(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String[] namesAndValues;

    public Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.namesAndValues = strArr;
    }

    public final String c(String name) {
        m.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String[] strArr = this.namesAndValues;
        IntProgression intProgressionStep = f.step(f.downTo(strArr.length - 2, 0), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (!t.equals(name, strArr[first], true)) {
                if (first != last) {
                    first += step;
                }
            }
            return strArr[first + 1];
        }
        return null;
    }

    public final String d(int index) {
        return this.namesAndValues[index * 2];
    }

    public final Headers$a e() {
        Headers$a headers$a = new Headers$a();
        r.addAll(headers$a.a, this.namesAndValues);
        return headers$a;
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    public final String g(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = o.to(d(i), g(i));
        }
        return c.iterator(pairArr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(d(i));
            sb.append(": ");
            sb.append(g(i));
            sb.append("\n");
        }
        String string = sb.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
