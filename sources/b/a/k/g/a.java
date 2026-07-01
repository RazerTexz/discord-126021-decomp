package b.a.k.g;

import b.a.k.h.e;
import b.a.k.h.f;
import b.a.k.h.g;
import b.a.k.h.h;
import b.a.k.h.i;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.m;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: FormattingParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends Parser<RenderContext, Node<RenderContext>, c> {
    public a() {
        super(false, 1, null);
        Pattern pattern = b.a.k.h.b.a;
        m.checkNotNullExpressionValue(pattern, "PATTERN_BANG_ESCAPE");
        addRule(new b.a.k.h.a(pattern));
        Pattern pattern2 = g.a;
        m.checkNotNullExpressionValue(pattern2, "PATTERN_HOOK");
        addRule(new f(pattern2));
        Pattern pattern3 = e.a;
        m.checkNotNullExpressionValue(pattern3, "PATTERN_CLICK_LISTENER");
        addRule(new b.a.k.h.d(pattern3));
        b.a.t.b.b.e eVar = b.a.t.b.b.e.h;
        Pattern pattern4 = b.a.t.b.b.e.a;
        m.checkNotNullExpressionValue(pattern4, "SimpleMarkdownRules.PATTERN_BOLD");
        addRule(new b.a.k.h.c(pattern4));
        Pattern pattern5 = b.a.t.b.b.e.g;
        m.checkNotNullExpressionValue(pattern5, "SimpleMarkdownRules.PATTERN_ITALICS");
        addRule(new h(pattern5));
        Pattern pattern6 = b.a.t.b.b.e.c;
        m.checkNotNullExpressionValue(pattern6, "SimpleMarkdownRules.PATTERN_STRIKETHRU");
        addRule(new i(pattern6));
        addRule(eVar.d());
    }
}
