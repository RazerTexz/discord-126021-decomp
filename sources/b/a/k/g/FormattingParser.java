package b.a.k.g;

import b.a.k.h.BangEscapeRule;
import b.a.k.h.BangEscapeRule2;
import b.a.k.h.BoldRule;
import b.a.k.h.ClickListenerRule;
import b.a.k.h.ClickListenerRule2;
import b.a.k.h.HookRule;
import b.a.k.h.HookRule2;
import b.a.k.h.ItalicsRule;
import b.a.k.h.StrikethroughRule;
import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import d0.z.d.Intrinsics3;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.a.k.g.a, reason: use source file name */
/* JADX INFO: compiled from: FormattingParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FormattingParser extends Parser<RenderContext, Node<RenderContext>, ParseState> {
    public FormattingParser() {
        super(false, 1, null);
        Pattern pattern = BangEscapeRule2.a;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_BANG_ESCAPE");
        addRule(new BangEscapeRule(pattern));
        Pattern pattern2 = HookRule2.a;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_HOOK");
        addRule(new HookRule(pattern2));
        Pattern pattern3 = ClickListenerRule2.a;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_CLICK_LISTENER");
        addRule(new ClickListenerRule(pattern3));
        SimpleMarkdownRules5 simpleMarkdownRules5 = SimpleMarkdownRules5.h;
        Pattern pattern4 = SimpleMarkdownRules5.a;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "SimpleMarkdownRules.PATTERN_BOLD");
        addRule(new BoldRule(pattern4));
        Pattern pattern5 = SimpleMarkdownRules5.g;
        Intrinsics3.checkNotNullExpressionValue(pattern5, "SimpleMarkdownRules.PATTERN_ITALICS");
        addRule(new ItalicsRule(pattern5));
        Pattern pattern6 = SimpleMarkdownRules5.c;
        Intrinsics3.checkNotNullExpressionValue(pattern6, "SimpleMarkdownRules.PATTERN_STRIKETHRU");
        addRule(new StrikethroughRule(pattern6));
        addRule(simpleMarkdownRules5.d());
    }
}
