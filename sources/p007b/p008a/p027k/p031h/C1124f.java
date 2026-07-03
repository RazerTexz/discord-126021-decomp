package p007b.p008a.p027k.p031h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p029f.C1113c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: renamed from: b.a.k.h.f */
/* JADX INFO: compiled from: HookRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1124f<S> extends Rule<RenderContext, C1113c, S> {
    public C1124f(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, S> parse(Matcher matcher, Parser<RenderContext, ? super C1113c, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        C12238m.checkNotNull(strGroup);
        if (matcher.start(1) == matcher.end(1)) {
            C1113c c1113c = new C1113c(strGroup);
            C12238m.checkNotNullParameter(c1113c, "node");
            return new ParseSpec<>(c1113c, s2);
        }
        C1113c c1113c2 = new C1113c(strGroup);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        C12238m.checkNotNullParameter(c1113c2, "node");
        return new ParseSpec<>(c1113c2, s2, iStart, iEnd);
    }
}
