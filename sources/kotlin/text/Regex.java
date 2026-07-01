package kotlin.text;

import b.d.b.a.outline;
import d0.f0.n;
import d0.g0.Regex4;
import d0.g0.Regex5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends Regex5> _options;
    private final Pattern nativePattern;

    /* JADX INFO: renamed from: kotlin.text.Regex$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final int access$ensureUnicodeCase(Companion companion, int i) {
            Objects.requireNonNull(companion);
            return (i & 2) != 0 ? i | 64 : i;
        }

        public final String escape(String str) {
            Intrinsics3.checkNotNullParameter(str, "literal");
            String strQuote = Pattern.quote(str);
            Intrinsics3.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
            return strQuote;
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: compiled from: Regex.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new a(null);
        }

        public b(String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final class c extends Lambda implements Function0<MatchResult> {
        public final /* synthetic */ CharSequence $input;
        public final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final MatchResult invoke() {
            return Regex.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: compiled from: Regex.kt */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final d j = new d();

        public d() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MatchResult invoke(MatchResult matchResult) {
            Intrinsics3.checkNotNullParameter(matchResult, "p1");
            return matchResult.next();
        }
    }

    public Regex(Pattern pattern) {
        Intrinsics3.checkNotNullParameter(pattern, "nativePattern");
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
        Intrinsics3.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics3.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return Regex4.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(CharSequence input, int startIndex) {
        Intrinsics3.checkNotNullParameter(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return n.generateSequence((Function0) new c(input, startIndex), (Function1) d.j);
        }
        StringBuilder sbV = outline.V("Start index out of bounds: ", startIndex, ", input length: ");
        sbV.append(input.length());
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics3.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return Regex4.access$matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics3.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        Intrinsics3.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics3.checkNotNullParameter(input, "input");
        Intrinsics3.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            Intrinsics3.checkNotNull(matchResultFind$default);
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
        Intrinsics3.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, Regex5 regex5) {
        Intrinsics3.checkNotNullParameter(str, "pattern");
        Intrinsics3.checkNotNullParameter(regex5, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.access$ensureUnicodeCase(INSTANCE, regex5.getValue()));
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }
}
