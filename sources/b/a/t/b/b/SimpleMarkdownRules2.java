package b.a.t.b.b;

import b.a.t.b.a.TextNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.b.b.b, reason: use source file name */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleMarkdownRules2<R, S> extends Rule<R, Node<R>, S> {
    public SimpleMarkdownRules2(SimpleMarkdownRules5 simpleMarkdownRules5, Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        TextNode textNode = new TextNode(strGroup);
        Intrinsics3.checkNotNullParameter(textNode, "node");
        return new ParseSpec<>(textNode, s2);
    }
}
