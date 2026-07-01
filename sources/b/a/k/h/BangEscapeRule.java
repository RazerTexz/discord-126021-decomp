package b.a.k.h;

import b.a.k.g.ParseState;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.a.k.h.a, reason: use source file name */
/* JADX INFO: compiled from: BangEscapeRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BangEscapeRule<T> extends Rule<T, Node<T>, ParseState> {
    public BangEscapeRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, ParseState parseState) {
        ParseState parseState2 = parseState;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        Intrinsics3.checkNotNullParameter(parseState2, "state");
        ParseState parseState3 = new ParseState(true, parseState2.f246b);
        Node.a aVar = new Node.a(new Node[0]);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec(aVar, parseState3, iStart, iEnd);
    }
}
