package b.a.t.a;

import com.discord.simpleast.code.CodeNode$b;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, String[] strArr, Pattern pattern) {
        super(pattern);
        this.a = fVar;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        d0.z.d.m.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        d0.z.d.m.checkNotNull(strGroup2);
        CodeNode$b codeNode$b = new CodeNode$b(strGroup, strGroup2, this.a);
        d0.z.d.m.checkNotNullParameter(codeNode$b, "node");
        return new ParseSpec<>(codeNode$b, s2);
    }
}
