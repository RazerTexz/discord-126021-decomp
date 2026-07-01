package b.a.t.c;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule$BlockRule;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public class a$c<R, S> extends Rule$BlockRule<R, Node<R>, S> {
    private final Function1<Integer, CharacterStyle> styleSpanProvider;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a$c(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
        super(pattern);
        m.checkNotNullParameter(pattern, "pattern");
        m.checkNotNullParameter(function1, "styleSpanProvider");
        this.styleSpanProvider = function1;
    }

    public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
        m.checkNotNullParameter(str, "headerStyleGroup");
        return new StyleNode<>(d0.t.m.listOf(this.styleSpanProvider.invoke(Integer.valueOf(str.length()))));
    }

    public final Function1<Integer, CharacterStyle> getStyleSpanProvider() {
        return this.styleSpanProvider;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        m.checkNotNullParameter(matcher, "matcher");
        m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        m.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
        StyleNode<R, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
        int iStart = matcher.start(2);
        int iEnd = matcher.end(2);
        m.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
        return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2, iStart, iEnd);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a$c(Function1<? super Integer, ? extends CharacterStyle> function1) {
        this(a.f309b, function1);
        m.checkNotNullParameter(function1, "styleSpanProvider");
        a aVar = a.e;
    }
}
