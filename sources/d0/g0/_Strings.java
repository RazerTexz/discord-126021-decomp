package d0.g0;

import b.d.b.a.outline;
import d0.d0._Ranges;
import d0.t.SlidingWindow2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.g0.y, reason: use source file name */
/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public class _Strings extends _StringsJvm {

    /* JADX INFO: renamed from: d0.g0.y$a */
    /* JADX INFO: compiled from: _Strings.kt */
    public static final class a extends Lambda implements Function1<CharSequence, String> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final List<String> chunked(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$chunked");
        return windowed(charSequence, i, i, true);
    }

    public static final CharSequence drop(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$drop");
        if (i >= 0) {
            return charSequence.subSequence(_Ranges.coerceAtMost(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(outline.r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final String dropLast(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "$this$dropLast");
        if (i >= 0) {
            return take(str, _Ranges.coerceAtLeast(str.length() - i, 0));
        }
        throw new IllegalArgumentException(outline.r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final char first(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$first");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final Character getOrNull(CharSequence charSequence, int i) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$getOrNull");
        if (i < 0 || i > Strings4.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static final char last(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$last");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(Strings4.getLastIndex(charSequence));
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final String take(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.r("Requested character count ", i, " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, _Ranges.coerceAtMost(i, str.length()));
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String takeLast(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.r("Requested character count ", i, " is less than zero.").toString());
        }
        int length = str.length();
        String strSubstring = str.substring(length - _Ranges.coerceAtMost(i, length));
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z2) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$windowed");
        return windowed(charSequence, i, i2, z2, a.j);
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z2, Function1<? super CharSequence, ? extends R> function1) {
        Intrinsics3.checkNotNullParameter(charSequence, "$this$windowed");
        Intrinsics3.checkNotNullParameter(function1, "transform");
        SlidingWindow2.checkWindowSizeStep(i, i2);
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
        Intrinsics3.checkNotNullParameter(str, "$this$drop");
        if (i >= 0) {
            String strSubstring = str.substring(_Ranges.coerceAtMost(i, str.length()));
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(outline.r("Requested character count ", i, " is less than zero.").toString());
    }
}
