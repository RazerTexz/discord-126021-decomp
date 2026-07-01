package b.a.k.h;

import android.text.style.StyleSpan;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ItalicsRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h<T> extends Rule<T, Node<T>, b.a.k.g.c> {
    public h(Pattern pattern) {
        super(pattern);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0049  */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, b.a.k.g.c cVar) {
        int iStart;
        int iEnd;
        b.a.k.g.c cVar2 = cVar;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        m.checkNotNullParameter(cVar2, "state");
        Node node$a = cVar2.a ? new Node$a(new Node[0]) : new StyleNode(d0.t.m.listOf(new StyleSpan(2)));
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            iStart = matcher.start(1);
            iEnd = matcher.end(1);
        } else {
            if (strGroup.length() > 0) {
                iStart = matcher.start(2);
                iEnd = matcher.end(2);
            } else {
                iStart = matcher.start(1);
                iEnd = matcher.end(1);
            }
        }
        m.checkNotNullParameter(node$a, "node");
        return new ParseSpec(node$a, cVar2, iStart, iEnd);
    }
}
