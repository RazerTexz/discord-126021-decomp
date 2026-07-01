package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: compiled from: JavaScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k$a$a k_a_a, f fVar, Pattern pattern) {
        super(pattern);
        this.a = fVar;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        d0.z.d.m.checkNotNull(strGroup);
        d0.z.d.m.checkNotNull(strGroup2);
        k$a k_a = new k$a(strGroup, strGroup2, this.a);
        d0.z.d.m.checkNotNullParameter(k_a, "node");
        return new ParseSpec<>(k_a, s2);
    }
}
