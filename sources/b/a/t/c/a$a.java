package b.a.t.c;

import android.text.style.CharacterStyle;
import b.a.t.b.b.e;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.g0.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public class a$a<RC, T, S> extends a$b<RC, S> {
    private final Function1<String, T> classSpanProvider;
    private final List<Rule<RC, Node<RC>, S>> innerRules;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a$a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2, List<? extends Rule<RC, Node<RC>, S>> list) {
        super(a.d, function1);
        m.checkNotNullParameter(function1, "styleSpanProvider");
        m.checkNotNullParameter(function2, "classSpanProvider");
        m.checkNotNullParameter(list, "innerRules");
        a aVar = a.e;
        this.classSpanProvider = function2;
        this.innerRules = list;
    }

    public final Function1<String, T> getClassSpanProvider() {
        return this.classSpanProvider;
    }

    public final List<Rule<RC, Node<RC>, S>> getInnerRules() {
        return this.innerRules;
    }

    @Override // b.a.t.c.a$b, b.a.t.c.a$c, com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        List listEmptyList;
        String string;
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(4);
        m.checkNotNullExpressionValue(strGroup, "matcher.group(4)");
        StyleNode<RC, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
        String strGroup2 = matcher.group(1);
        if (strGroup2 == null) {
            strGroup2 = matcher.group(3);
        }
        m.checkNotNullExpressionValue(strGroup2, "headerBody");
        for (Object obj : parser.parse(strGroup2, s2, this.innerRules)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
            styleNodeCreateHeaderStyleNode.addChild((Node) obj);
        }
        String strGroup3 = matcher.group(2);
        List listSplit$default = (strGroup3 == null || (string = w.trim(strGroup3).toString()) == null) ? null : w.split$default((CharSequence) string, new char[]{' '}, false, 0, 6, (Object) null);
        if (listSplit$default != null) {
            listEmptyList = new ArrayList();
            Iterator<T> it = listSplit$default.iterator();
            while (it.hasNext()) {
                T tInvoke = this.classSpanProvider.invoke((String) it.next());
                if (tInvoke != null) {
                    listEmptyList.add(tInvoke);
                }
            }
        } else {
            listEmptyList = n.emptyList();
        }
        if (!listEmptyList.isEmpty()) {
            StyleNode<RC, CharacterStyle> styleNode = new StyleNode<>(listEmptyList);
            styleNode.addChild(styleNodeCreateHeaderStyleNode);
            styleNodeCreateHeaderStyleNode = styleNode;
        }
        m.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
        return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a$a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2) {
        this(function1, function2, u.plus((Collection<? extends Rule>) e.b(false, false, 2), e.h.d()));
        m.checkNotNullParameter(function1, "styleSpanProvider");
        m.checkNotNullParameter(function2, "classSpanProvider");
    }
}
