package kotlin.text;

import b.d.b.a.a;
import d0.f0.n;
import d0.g0.h;
import d0.g0.i;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex implements Serializable {
    public static final Regex$a j = new Regex$a(null);
    private Set<? extends i> _options;
    private final Pattern nativePattern;

    public Regex(Pattern pattern) {
        m.checkNotNullParameter(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        m.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new Regex$b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return h.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(CharSequence input, int startIndex) {
        m.checkNotNullParameter(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return n.generateSequence((Function0) new Regex$c(this, input, startIndex), (Function1) Regex$d.j);
        }
        StringBuilder sbV = a.V("Start index out of bounds: ", startIndex, ", input length: ");
        sbV.append(input.length());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final MatchResult matchEntire(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return h.access$matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        m.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        m.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        m.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        m.checkNotNullParameter(input, "input");
        m.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            m.checkNotNull(matchResultFind$default);
            sb.append(input, iIntValue, matchResultFind$default.getRange().getStart().intValue());
            sb.append(transform.invoke(matchResultFind$default));
            iIntValue = matchResultFind$default.getRange().getEndInclusive().intValue() + 1;
            matchResultFind$default = matchResultFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (matchResultFind$default != null);
        if (iIntValue < length) {
            sb.append(input, iIntValue, length);
        }
        String string = sb.toString();
        m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, i iVar) {
        m.checkNotNullParameter(str, "pattern");
        m.checkNotNullParameter(iVar, "option");
        Pattern patternCompile = Pattern.compile(str, Regex$a.access$ensureUnicodeCase(j, iVar.getValue()));
        m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }
}
