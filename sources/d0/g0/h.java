package d0.g0;

import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final MatchResult access$findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    public static final MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new g(matcher, charSequence);
        }
        return null;
    }

    public static final IntRange access$range(java.util.regex.MatchResult matchResult) {
        return d0.d0.f.until(matchResult.start(), matchResult.end());
    }

    public static final IntRange access$range(java.util.regex.MatchResult matchResult, int i) {
        return d0.d0.f.until(matchResult.start(i), matchResult.end(i));
    }
}
