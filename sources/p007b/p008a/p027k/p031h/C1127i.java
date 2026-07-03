package p007b.p008a.p027k.p031h;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p029f.C1114d;
import p007b.p008a.p027k.p030g.C1117c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.h.i */
/* JADX INFO: compiled from: StrikethroughRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1127i extends Rule<RenderContext, Node<RenderContext>, C1117c> {
    public C1127i(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, C1117c> parse(Matcher matcher, Parser parser, C1117c c1117c) {
        C1117c c1117c2 = c1117c;
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        C12238m.checkNotNullParameter(c1117c2, "state");
        Node c5655a = c1117c2.f1501a ? new Node.C5655a(new Node[0]) : new C1114d();
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        C12238m.checkNotNullParameter(c5655a, "node");
        return new ParseSpec<>(c5655a, c1117c2, iStart, iEnd);
    }
}
