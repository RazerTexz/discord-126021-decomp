package b.a.k.h;

import android.text.style.StyleSpan;
import b.a.k.g.ParseState;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: b.a.k.h.h, reason: use source file name */
/* JADX INFO: compiled from: ItalicsRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ItalicsRule<T> extends Rule<T, Node<T>, ParseState> {
    public ItalicsRule(Pattern pattern) {
        super(pattern);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0049  */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec parse(Matcher matcher, Parser parser, ParseState parseState) {
        int iStart;
        int iEnd;
        ParseState parseState2 = parseState;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        Intrinsics3.checkNotNullParameter(parseState2, "state");
        Node aVar = parseState2.a ? new Node.a(new Node[0]) : new StyleNode(CollectionsJVM.listOf(new StyleSpan(2)));
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
        Intrinsics3.checkNotNullParameter(aVar, "node");
        return new ParseSpec(aVar, parseState2, iStart, iEnd);
    }
}
