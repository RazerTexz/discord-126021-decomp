package p007b.p008a.p050t.p052b.p054b;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.b.b.d */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1302d<R, S> extends Rule.BlockRule<R, Node<R>, S> {
    public C1302d(C1303e c1303e, Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        C1298a c1298a = new C1298a("\n");
        C12238m.checkNotNullParameter(c1298a, "node");
        return new ParseSpec<>(c1298a, s2);
    }
}
