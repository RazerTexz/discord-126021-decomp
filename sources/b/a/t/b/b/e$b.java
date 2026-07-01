package b.a.t.b.b;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$b<R, S> extends Rule<R, Node<R>, S> {
    public e$b(e eVar, Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group();
        m.checkNotNullExpressionValue(strGroup, "matcher.group()");
        b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup);
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
