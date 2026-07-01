package d0.g0;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;
import kotlin.text.MatchResult$a;
import kotlin.text.MatchResult$b;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements MatchResult {
    public final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f3582b;
    public final Matcher c;
    public final CharSequence d;

    public g(Matcher matcher, CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(charSequence, "input");
        this.c = matcher;
        this.d = charSequence;
        this.a = new g$b(this);
    }

    public static final java.util.regex.MatchResult access$getMatchResult$p(g gVar) {
        return gVar.c;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult$b getDestructured() {
        return MatchResult$a.getDestructured(this);
    }

    @Override // kotlin.text.MatchResult
    public List<String> getGroupValues() {
        if (this.f3582b == null) {
            this.f3582b = new g$a(this);
        }
        List<String> list = this.f3582b;
        d0.z.d.m.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public f getGroups() {
        return this.a;
    }

    @Override // kotlin.text.MatchResult
    public IntRange getRange() {
        return h.access$range(this.c);
    }

    @Override // kotlin.text.MatchResult
    public String getValue() {
        String strGroup = this.c.group();
        d0.z.d.m.checkNotNullExpressionValue(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.MatchResult
    public MatchResult next() {
        int iEnd = this.c.end() + (this.c.end() == this.c.start() ? 1 : 0);
        if (iEnd > this.d.length()) {
            return null;
        }
        Matcher matcher = this.c.pattern().matcher(this.d);
        d0.z.d.m.checkNotNullExpressionValue(matcher, "matcher.pattern().matcher(input)");
        return h.access$findNext(matcher, iEnd, this.d);
    }
}
