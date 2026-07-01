package b.a.t.b.b;

import android.text.style.StyleSpan;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.b.b.c, reason: use source file name */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleMarkdownRules3<R, S> extends Rule<R, Node<R>, S> {
    public SimpleMarkdownRules3(SimpleMarkdownRules5 simpleMarkdownRules5, Pattern pattern) {
        super(pattern);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028  */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        int iStart;
        int iEnd;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
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
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new StyleSpan(2));
        StyleNode styleNode = new StyleNode(arrayList);
        Intrinsics3.checkNotNullParameter(styleNode, "node");
        return new ParseSpec<>(styleNode, s2, iStart, iEnd);
    }
}
