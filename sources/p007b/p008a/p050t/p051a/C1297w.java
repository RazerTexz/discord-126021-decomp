package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: renamed from: b.a.t.a.w */
/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1297w<RC, S> extends Rule<RC, Node<RC>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1280f f1979a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1297w(C1296v c1296v, C1280f c1280f, Pattern pattern) {
        super(pattern);
        this.f1979a = c1280f;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        C12238m.checkNotNull(strGroup);
        String strGroup2 = matcher.group(3);
        if (matcher.group(2) == null) {
            C1296v.a aVar = new C1296v.a(strGroup, strGroup2, this.f1979a);
            C12238m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        C1296v.a aVar2 = new C1296v.a(strGroup, strGroup2, this.f1979a);
        int iStart = matcher.start(2);
        int iEnd = matcher.end(2);
        C12238m.checkNotNullParameter(aVar2, "node");
        return new ParseSpec<>(aVar2, s2, iStart, iEnd);
    }
}
