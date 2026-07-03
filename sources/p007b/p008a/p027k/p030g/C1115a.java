package p007b.p008a.p027k.p030g;

import com.discord.i18n.RenderContext;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import java.util.regex.Pattern;
import p007b.p008a.p027k.p031h.C1119a;
import p007b.p008a.p027k.p031h.C1120b;
import p007b.p008a.p027k.p031h.C1121c;
import p007b.p008a.p027k.p031h.C1122d;
import p007b.p008a.p027k.p031h.C1123e;
import p007b.p008a.p027k.p031h.C1124f;
import p007b.p008a.p027k.p031h.C1125g;
import p007b.p008a.p027k.p031h.C1126h;
import p007b.p008a.p027k.p031h.C1127i;
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.k.g.a */
/* JADX INFO: compiled from: FormattingParser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1115a extends Parser<RenderContext, Node<RenderContext>, C1117c> {
    public C1115a() {
        super(false, 1, null);
        Pattern pattern = C1120b.f1507a;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_BANG_ESCAPE");
        addRule(new C1119a(pattern));
        Pattern pattern2 = C1125g.f1509a;
        C12238m.checkNotNullExpressionValue(pattern2, "PATTERN_HOOK");
        addRule(new C1124f(pattern2));
        Pattern pattern3 = C1123e.f1508a;
        C12238m.checkNotNullExpressionValue(pattern3, "PATTERN_CLICK_LISTENER");
        addRule(new C1122d(pattern3));
        C1303e c1303e = C1303e.f1988h;
        Pattern pattern4 = C1303e.f1981a;
        C12238m.checkNotNullExpressionValue(pattern4, "SimpleMarkdownRules.PATTERN_BOLD");
        addRule(new C1121c(pattern4));
        Pattern pattern5 = C1303e.f1987g;
        C12238m.checkNotNullExpressionValue(pattern5, "SimpleMarkdownRules.PATTERN_ITALICS");
        addRule(new C1126h(pattern5));
        Pattern pattern6 = C1303e.f1983c;
        C12238m.checkNotNullExpressionValue(pattern6, "SimpleMarkdownRules.PATTERN_STRIKETHRU");
        addRule(new C1127i(pattern6));
        addRule(c1303e.m374d());
    }
}
