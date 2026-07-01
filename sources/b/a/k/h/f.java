package b.a.k.h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: compiled from: HookRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f<S> extends Rule<RenderContext, b.a.k.f.c, S> {
    public f(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, S> parse(Matcher matcher, Parser<RenderContext, ? super b.a.k.f.c, S> parser, S s2) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        m.checkNotNull(strGroup);
        if (matcher.start(1) == matcher.end(1)) {
            b.a.k.f.c cVar = new b.a.k.f.c(strGroup);
            m.checkNotNullParameter(cVar, "node");
            return new ParseSpec<>(cVar, s2);
        }
        b.a.k.f.c cVar2 = new b.a.k.f.c(strGroup);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        m.checkNotNullParameter(cVar2, "node");
        return new ParseSpec<>(cVar2, s2, iStart, iEnd);
    }
}
