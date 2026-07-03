package p007b.p008a.p050t.p051a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.b */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1276b<R, S> extends Rule<R, Node<R>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1280f f1894a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1276b(C1280f c1280f, String[] strArr, Pattern pattern) {
        super(pattern);
        this.f1894a = c1280f;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        C12238m.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        C12238m.checkNotNull(strGroup2);
        CodeNode.C5654b c5654b = new CodeNode.C5654b(strGroup, strGroup2, this.f1894a);
        C12238m.checkNotNullParameter(c5654b, "node");
        return new ParseSpec<>(c5654b, s2);
    }
}
