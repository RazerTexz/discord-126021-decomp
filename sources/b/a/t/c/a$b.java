package b.a.t.c;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.m;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public class a$b<R, S> extends a$c<R, S> {
    /* JADX WARN: Illegal instructions before constructor call */
    public a$b(Pattern pattern, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            a aVar = a.e;
            pattern = a.c;
        }
        this(pattern, function1);
    }

    @Override // b.a.t.c.a$c
    public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
        m.checkNotNullParameter(str, "headerStyleGroup");
        return new StyleNode<>(d0.t.m.listOf(getStyleSpanProvider().invoke(Integer.valueOf((str.hashCode() == 61 && str.equals("=")) ? 1 : 2))));
    }

    @Override // b.a.t.c.a$c, com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        throw null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$b(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
        super(pattern, function1);
        m.checkNotNullParameter(pattern, "pattern");
        m.checkNotNullParameter(function1, "styleSpanProvider");
    }
}
