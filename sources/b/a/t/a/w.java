package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final class w<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, f fVar, Pattern pattern) {
        super(pattern);
        this.a = fVar;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        d0.z.d.m.checkNotNull(strGroup);
        String strGroup2 = matcher.group(3);
        if (matcher.group(2) == null) {
            v$a v_a = new v$a(strGroup, strGroup2, this.a);
            d0.z.d.m.checkNotNullParameter(v_a, "node");
            return new ParseSpec<>(v_a, s2);
        }
        v$a v_a2 = new v$a(strGroup, strGroup2, this.a);
        int iStart = matcher.start(2);
        int iEnd = matcher.end(2);
        d0.z.d.m.checkNotNullParameter(v_a2, "node");
        return new ParseSpec<>(v_a2, s2, iStart, iEnd);
    }
}
