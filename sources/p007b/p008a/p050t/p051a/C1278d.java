package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.d */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1278d<R, S> extends Rule<R, Node<R>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1898a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1899b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1278d(Pattern pattern, int i, StyleNode.InterfaceC5656a interfaceC5656a, Pattern pattern2) {
        super(pattern2);
        this.f1898a = i;
        this.f1899b = interfaceC5656a;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(this.f1898a);
        if (strGroup == null) {
            strGroup = "";
        }
        StyleNode.InterfaceC5656a interfaceC5656a = this.f1899b;
        Node c5657b = interfaceC5656a != null ? new StyleNode.C5657b(strGroup, interfaceC5656a) : new C1298a(strGroup);
        C12238m.checkNotNullParameter(c5657b, "node");
        return new ParseSpec<>(c5657b, s2);
    }
}
