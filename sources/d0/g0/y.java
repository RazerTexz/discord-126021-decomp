package d0.g0;

import d0.t.p0;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public class y extends x {
    public static final List<String> chunked(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$chunked");
        return windowed(charSequence, i, i, true);
    }

    public static final CharSequence drop(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$drop");
        if (i >= 0) {
            return charSequence.subSequence(d0.d0.f.coerceAtMost(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(b.d.b.a.a.r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final String dropLast(String str, int i) {
        d0.z.d.m.checkNotNullParameter(str, "$this$dropLast");
        if (i >= 0) {
            return take(str, d0.d0.f.coerceAtLeast(str.length() - i, 0));
        }
        throw new IllegalArgumentException(b.d.b.a.a.r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final char first(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$first");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final Character getOrNull(CharSequence charSequence, int i) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$getOrNull");
        if (i < 0 || i > w.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static final char last(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$last");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(w.getLastIndex(charSequence));
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final String take(String str, int i) {
        d0.z.d.m.checkNotNullParameter(str, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Requested character count ", i, " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, d0.d0.f.coerceAtMost(i, str.length()));
        d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String takeLast(String str, int i) {
        d0.z.d.m.checkNotNullParameter(str, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.r("Requested character count ", i, " is less than zero.").toString());
        }
        int length = str.length();
        String strSubstring = str.substring(length - d0.d0.f.coerceAtMost(i, length));
        d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z2) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$windowed");
        return windowed(charSequence, i, i2, z2, y$a.j);
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z2, Function1<? super CharSequence, ? extends R> function1) {
        d0.z.d.m.checkNotNullParameter(charSequence, "$this$windowed");
        d0.z.d.m.checkNotNullParameter(function1, "transform");
        p0.checkWindowSizeStep(i, i2);
        int length = charSequence.length();
        int i3 = 0;
        ArrayList arrayList = new ArrayList((length / i2) + (length % i2 == 0 ? 0 : 1));
        while (i3 >= 0 && length > i3) {
            int i4 = i3 + i;
            if (i4 < 0 || i4 > length) {
                if (!z2) {
                    break;
                }
                i4 = length;
            }
            arrayList.add(function1.invoke(charSequence.subSequence(i3, i4)));
            i3 += i2;
        }
        return arrayList;
    }

    public static final String drop(String str, int i) {
        d0.z.d.m.checkNotNullParameter(str, "$this$drop");
        if (i >= 0) {
            String strSubstring = str.substring(d0.d0.f.coerceAtMost(i, str.length()));
            d0.z.d.m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(b.d.b.a.a.r("Requested character count ", i, " is less than zero.").toString());
    }
}
