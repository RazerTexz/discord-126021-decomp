package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p051a.C1285k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: renamed from: b.a.t.a.l */
/* JADX INFO: compiled from: JavaScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1286l<RC, S> extends Rule<RC, Node<RC>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1280f f1940a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1286l(C1285k.b.a aVar, C1280f c1280f, Pattern pattern) {
        super(pattern);
        this.f1940a = c1280f;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        C12238m.checkNotNull(strGroup);
        C12238m.checkNotNull(strGroup3);
        C1285k.b bVar = new C1285k.b(strGroup, strGroup2, strGroup3, this.f1940a);
        C12238m.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
