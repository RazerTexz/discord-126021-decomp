package p007b.p008a.p027k.p031h;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p030g.C1117c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.a.k.h.a */
/* JADX INFO: compiled from: BangEscapeRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1119a<T> extends Rule<T, Node<T>, C1117c> {
    public C1119a(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, C1117c c1117c) {
        C1117c c1117c2 = c1117c;
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        C12238m.checkNotNullParameter(c1117c2, "state");
        C1117c c1117c3 = new C1117c(true, c1117c2.f1502b);
        Node.C5655a c5655a = new Node.C5655a(new Node[0]);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        C12238m.checkNotNullParameter(c5655a, "node");
        return new ParseSpec(c5655a, c1117c3, iStart, iEnd);
    }
}
