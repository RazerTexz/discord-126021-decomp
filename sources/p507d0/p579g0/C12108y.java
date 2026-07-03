package p507d0.p579g0;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12152p0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.y */
/* JADX INFO: compiled from: _Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12108y extends C12107x {

    /* JADX INFO: renamed from: d0.g0.y$a */
    /* JADX INFO: compiled from: _Strings.kt */
    public static final class a extends AbstractC12240o implements Function1<CharSequence, String> {

        /* JADX INFO: renamed from: j */
        public static final a f25164j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final String invoke(CharSequence charSequence) {
            C12238m.checkNotNullParameter(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final List<String> chunked(CharSequence charSequence, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$chunked");
        return windowed(charSequence, i, i, true);
    }

    public static final CharSequence drop(CharSequence charSequence, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$drop");
        if (i >= 0) {
            return charSequence.subSequence(C11226f.coerceAtMost(i, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(C1643a.m873r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final String dropLast(String str, int i) {
        C12238m.checkNotNullParameter(str, "$this$dropLast");
        if (i >= 0) {
            return take(str, C11226f.coerceAtLeast(str.length() - i, 0));
        }
        throw new IllegalArgumentException(C1643a.m873r("Requested character count ", i, " is less than zero.").toString());
    }

    public static final char first(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$first");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    public static final Character firstOrNull(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$firstOrNull");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    public static final Character getOrNull(CharSequence charSequence, int i) {
        C12238m.checkNotNullParameter(charSequence, "$this$getOrNull");
        if (i < 0 || i > C12106w.getLastIndex(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static final char last(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$last");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(C12106w.getLastIndex(charSequence));
    }

    public static final Character singleOrNull(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "$this$singleOrNull");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    public static final String take(String str, int i) {
        C12238m.checkNotNullParameter(str, "$this$take");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested character count ", i, " is less than zero.").toString());
        }
        String strSubstring = str.substring(0, C11226f.coerceAtMost(i, str.length()));
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String takeLast(String str, int i) {
        C12238m.checkNotNullParameter(str, "$this$takeLast");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(C1643a.m873r("Requested character count ", i, " is less than zero.").toString());
        }
        int length = str.length();
        String strSubstring = str.substring(length - C11226f.coerceAtMost(i, length));
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static final List<String> windowed(CharSequence charSequence, int i, int i2, boolean z2) {
        C12238m.checkNotNullParameter(charSequence, "$this$windowed");
        return windowed(charSequence, i, i2, z2, a.f25164j);
    }

    public static final <R> List<R> windowed(CharSequence charSequence, int i, int i2, boolean z2, Function1<? super CharSequence, ? extends R> function1) {
        C12238m.checkNotNullParameter(charSequence, "$this$windowed");
        C12238m.checkNotNullParameter(function1, "transform");
        C12152p0.checkWindowSizeStep(i, i2);
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
        C12238m.checkNotNullParameter(str, "$this$drop");
        if (i >= 0) {
            String strSubstring = str.substring(C11226f.coerceAtMost(i, str.length()));
            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(C1643a.m873r("Requested character count ", i, " is less than zero.").toString());
    }
}
