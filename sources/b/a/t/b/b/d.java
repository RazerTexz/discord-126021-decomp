package b.a.t.b.b;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<R, S> extends Rule$BlockRule<R, Node<R>, S> {
    public d(e eVar, Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        b.a.t.b.a.a aVar = new b.a.t.b.a.a("\n");
        m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
