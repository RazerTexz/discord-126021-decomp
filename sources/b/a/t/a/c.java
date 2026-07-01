package b.a.t.a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.code.CodeNode$a$b;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ StyleNode$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode$a f288b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, StyleNode$a styleNode$a, StyleNode$a styleNode$a2, Pattern pattern) {
        super(pattern);
        this.a = styleNode$a;
        this.f288b = styleNode$a2;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            strGroup = "";
        }
        if (!(strGroup.length() == 0)) {
            CodeNode codeNode = new CodeNode(new CodeNode$a$b(strGroup), null, this.a);
            c$a c_a = new c$a(this, codeNode, new Node[]{codeNode});
            d0.z.d.m.checkNotNullParameter(c_a, "node");
            return new ParseSpec<>(c_a, s2);
        }
        String strGroup2 = matcher.group();
        d0.z.d.m.checkNotNullExpressionValue(strGroup2, "matcher.group()");
        b.a.t.b.a.a aVar = new b.a.t.b.a.a(strGroup2);
        d0.z.d.m.checkNotNullParameter(aVar, "node");
        return new ParseSpec<>(aVar, s2);
    }
}
