package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import p507d0.C12116o;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12219c;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;
import p600f0.p601e0.C12272c;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, InterfaceC12228a {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String[] namesAndValues;

    /* JADX INFO: renamed from: okhttp3.Headers$a */
    /* JADX INFO: compiled from: Headers.kt */
    public static final class C12930a {

        /* JADX INFO: renamed from: a */
        public final List<String> f27512a = new ArrayList(20);

        /* JADX INFO: renamed from: a */
        public final C12930a m10958a(String str, String str2) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(str2, "value");
            Companion companion = Headers.INSTANCE;
            companion.m10962a(str);
            companion.m10963b(str2, str);
            m10959b(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final C12930a m10959b(String str, String str2) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(str2, "value");
            this.f27512a.add(str);
            this.f27512a.add(C12106w.trim(str2).toString());
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final Headers m10960c() {
            Object[] array = this.f27512a.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        /* JADX INFO: renamed from: d */
        public final C12930a m10961d(String str) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            int i = 0;
            while (i < this.f27512a.size()) {
                if (C12103t.equals(str, this.f27512a.get(i), true)) {
                    this.f27512a.remove(i);
                    this.f27512a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: okhttp3.Headers$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Headers.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m10962a(String str) {
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(C12272c.m10129j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str).toString());
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public final void m10963b(String str, String str2) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (!(cCharAt == '\t' || (' ' <= cCharAt && '~' >= cCharAt))) {
                    throw new IllegalArgumentException(C12272c.m10129j("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str).toString());
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public final Headers m10964c(String... strArr) {
            C12238m.checkParameterIsNotNull(strArr, "namesAndValues");
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
                strArr2[i] = C12106w.trim(str).toString();
            }
            IntProgression intProgressionStep = C11226f.step(C11226f.until(0, strArr2.length), 2);
            int first = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if (step < 0 ? first >= last : first <= last) {
                while (true) {
                    String str2 = strArr2[first];
                    String str3 = strArr2[first + 1];
                    m10962a(str2);
                    m10963b(str3, str2);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
            return new Headers(strArr2, null);
        }
    }

    public Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this.namesAndValues = strArr;
    }

    /* JADX INFO: renamed from: c */
    public final String m10954c(String name) {
        C12238m.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String[] strArr = this.namesAndValues;
        IntProgression intProgressionStep = C11226f.step(C11226f.downTo(strArr.length - 2, 0), 2);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (!C12103t.equals(name, strArr[first], true)) {
                if (first != last) {
                    first += step;
                }
            }
            return strArr[first + 1];
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final String m10955d(int index) {
        return this.namesAndValues[index * 2];
    }

    /* JADX INFO: renamed from: e */
    public final C12930a m10956e() {
        C12930a c12930a = new C12930a();
        C12160r.addAll(c12930a.f27512a, this.namesAndValues);
        return c12930a;
    }

    public boolean equals(Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    /* JADX INFO: renamed from: g */
    public final String m10957g(int index) {
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
            pairArr[i] = C12116o.m10073to(m10955d(i), m10957g(i));
        }
        return C12219c.iterator(pairArr);
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(m10955d(i));
            sb.append(": ");
            sb.append(m10957g(i));
            sb.append("\n");
        }
        String string = sb.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
