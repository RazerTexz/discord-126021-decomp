package p007b.p008a.p027k.p031h;

import android.text.style.StyleSpan;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p030g.C1117c;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.a.k.h.h */
/* JADX INFO: compiled from: ItalicsRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1126h<T> extends Rule<T, Node<T>, C1117c> {
    public C1126h(Pattern pattern) {
        super(pattern);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0049  */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, C1117c c1117c) {
        int iStart;
        int iEnd;
        C1117c c1117c2 = c1117c;
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        C12238m.checkNotNullParameter(c1117c2, "state");
        Node c5655a = c1117c2.f1501a ? new Node.C5655a(new Node[0]) : new StyleNode(C12145m.listOf(new StyleSpan(2)));
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
        C12238m.checkNotNullParameter(c5655a, "node");
        return new ParseSpec(c5655a, c1117c2, iStart, iEnd);
    }
}
