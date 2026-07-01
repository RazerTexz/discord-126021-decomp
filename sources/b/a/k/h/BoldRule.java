package b.a.k.h;

import b.a.k.f.BoldNode;
import b.a.k.g.ParseState;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.a.k.h.c, reason: use source file name */
/* JADX INFO: compiled from: BoldRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BoldRule extends Rule<RenderContext, Node<RenderContext>, ParseState> {
    public BoldRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, ParseState> parse(Matcher matcher, Parser parser, ParseState parseState) {
        ParseState parseState2 = parseState;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        Intrinsics3.checkNotNullParameter(parseState2, "state");
        Node aVar = parseState2.a ? new Node.a(new Node[0]) : new BoldNode();
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, parseState2, iStart, iEnd);
    }
}
