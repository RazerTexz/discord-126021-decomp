package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.simpleast.core.node.StyleNode$b;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode$a f289b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Pattern pattern, int i, StyleNode$a styleNode$a, Pattern pattern2) {
        super(pattern2);
        this.a = i;
        this.f289b = styleNode$a;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        d0.z.d.m.checkNotNullParameter(matcher, "matcher");
        d0.z.d.m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(this.a);
        if (strGroup == null) {
            strGroup = "";
        }
        StyleNode$a styleNode$a = this.f289b;
        Node styleNode$b = styleNode$a != null ? new StyleNode$b(strGroup, styleNode$a) : new b.a.t.b.a.a(strGroup);
        d0.z.d.m.checkNotNullParameter(styleNode$b, "node");
        return new ParseSpec<>(styleNode$b, s2);
    }
}
