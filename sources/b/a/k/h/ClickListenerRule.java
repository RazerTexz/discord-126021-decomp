package b.a.k.h;

import b.a.k.f.HookNode2;
import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: renamed from: b.a.k.h.d, reason: use source file name */
/* JADX INFO: compiled from: ClickListenerRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClickListenerRule<S> extends Rule<RenderContext, HookNode2, S> {
    public ClickListenerRule(Pattern pattern) {
        super(pattern);
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RenderContext, S> parse(Matcher matcher, Parser<RenderContext, ? super HookNode2, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup);
        HookNode2 hookNode2 = new HookNode2(strGroup);
        int iStart = matcher.start(1);
        int iEnd = matcher.end(1);
        Intrinsics3.checkNotNullParameter(hookNode2, "node");
        return new ParseSpec<>(hookNode2, s2, iStart, iEnd);
    }
}
