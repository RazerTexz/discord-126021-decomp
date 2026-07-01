package d0.g0;

import java.util.regex.Matcher;
import kotlin.text.MatchResult;

/* JADX INFO: renamed from: d0.g0.h, reason: use source file name */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex4 {
    public static final MatchResult access$findNext(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new Regex3(matcher, charSequence);
        }
        return null;
    }

    public static final MatchResult access$matchEntire(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new Regex3(matcher, charSequence);
        }
        return null;
    }
}
