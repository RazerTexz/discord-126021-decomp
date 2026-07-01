package b.a.t.a;

import b.a.t.b.a.TextNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.d, reason: use source file name */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeRules4<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode.a f289b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules4(Pattern pattern, int i, StyleNode.a aVar, Pattern pattern2) {
        super(pattern2);
        this.a = i;
        this.f289b = aVar;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(this.a);
        if (strGroup == null) {
            strGroup = "";
        }
        StyleNode.a aVar = this.f289b;
        Node bVar = aVar != null ? new StyleNode.b(strGroup, aVar) : new TextNode(strGroup);
        Intrinsics3.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
