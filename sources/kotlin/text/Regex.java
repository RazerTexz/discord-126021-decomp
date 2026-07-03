package kotlin.text;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p578f0.C12075n;
import p507d0.p579g0.C12091h;
import p507d0.p579g0.EnumC12092i;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex implements Serializable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends EnumC12092i> _options;
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
            C12238m.checkNotNullParameter(str, "literal");
            String strQuote = Pattern.quote(str);
            C12238m.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
            return strQuote;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$b */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class C12800b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: renamed from: kotlin.text.Regex$b$a */
        /* JADX INFO: compiled from: Regex.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        static {
            new a(null);
        }

        public C12800b(String str, int i) {
            C12238m.checkNotNullParameter(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$c */
    /* JADX INFO: compiled from: Regex.kt */
    public static final class C12801c extends AbstractC12240o implements Function0<MatchResult> {
        public final /* synthetic */ CharSequence $input;
        public final /* synthetic */ int $startIndex;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12801c(CharSequence charSequence, int i) {
            super(0);
            this.$input = charSequence;
            this.$startIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public final MatchResult invoke() {
            return Regex.this.find(this.$input, this.$startIndex);
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$d */
    /* JADX INFO: compiled from: Regex.kt */
    public static final /* synthetic */ class C12802d extends C12236k implements Function1<MatchResult, MatchResult> {

        /* JADX INFO: renamed from: j */
        public static final C12802d f27454j = new C12802d();

        public C12802d() {
            super(1, MatchResult.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final MatchResult invoke(MatchResult matchResult) {
            C12238m.checkNotNullParameter(matchResult, "p1");
            return matchResult.next();
        }
    }

    public Regex(Pattern pattern) {
        C12238m.checkNotNullParameter(pattern, "nativePattern");
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
        C12238m.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new C12800b(strPattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        C12238m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        C12238m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        C12238m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return C12091h.access$findNext(matcher, startIndex, input);
    }

    public final Sequence<MatchResult> findAll(CharSequence input, int startIndex) {
        C12238m.checkNotNullParameter(input, "input");
        if (startIndex >= 0 && startIndex <= input.length()) {
            return C12075n.generateSequence((Function0) new C12801c(input, startIndex), (Function1) C12802d.f27454j);
        }
        StringBuilder sbM834V = C1643a.m834V("Start index out of bounds: ", startIndex, ", input length: ");
        sbM834V.append(input.length());
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public final MatchResult matchEntire(CharSequence input) {
        C12238m.checkNotNullParameter(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        C12238m.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return C12091h.access$matchEntire(matcher, input);
    }

    public final boolean matches(CharSequence input) {
        C12238m.checkNotNullParameter(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        C12238m.checkNotNullParameter(input, "input");
        C12238m.checkNotNullParameter(replacement, "replacement");
        String strReplaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        C12238m.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* JADX INFO: renamed from: toPattern, reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    public String toString() {
        String string = this.nativePattern.toString();
        C12238m.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        C12238m.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        C12238m.checkNotNullParameter(input, "input");
        C12238m.checkNotNullParameter(transform, "transform");
        int iIntValue = 0;
        MatchResult matchResultFind$default = find$default(this, input, 0, 2, null);
        if (matchResultFind$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            C12238m.checkNotNull(matchResultFind$default);
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
        C12238m.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str, EnumC12092i enumC12092i) {
        C12238m.checkNotNullParameter(str, "pattern");
        C12238m.checkNotNullParameter(enumC12092i, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.access$ensureUnicodeCase(INSTANCE, enumC12092i.getValue()));
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }
}
