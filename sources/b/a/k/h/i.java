package b.a.k.h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: StrikethroughRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i extends Rule<RenderContext, Node<RenderContext>, b.a.k.g.c> {
    public i(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, b.a.k.g.c> parse(Matcher matcher, Parser parser, b.a.k.g.c cVar) {
        b.a.k.g.c cVar2 = cVar;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        m.checkNotNullParameter(cVar2, "state");
        Node node$a = cVar2.a ? new Node$a(new Node[0]) : new b.a.k.f.d();
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        m.checkNotNullParameter(node$a, "node");
        return new ParseSpec<>(node$a, cVar2, iStart, iEnd);
    }
}
