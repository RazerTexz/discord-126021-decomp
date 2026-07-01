package b.a.t.a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.b, reason: use source file name */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeRules2<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ CodeStyleProviders a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules2(CodeStyleProviders codeStyleProviders, String[] strArr, Pattern pattern) {
        super(pattern);
        this.a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup2);
        CodeNode.b bVar = new CodeNode.b(strGroup, strGroup2, this.a);
        Intrinsics3.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
