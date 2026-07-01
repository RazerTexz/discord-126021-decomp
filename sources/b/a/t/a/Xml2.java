package b.a.t.a;

import b.a.t.a.Xml;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: renamed from: b.a.t.a.w, reason: use source file name */
/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Xml2<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ CodeStyleProviders a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Xml2(Xml xml, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        String strGroup2 = matcher.group(3);
        if (matcher.group(2) == null) {
            Xml.a aVar = new Xml.a(strGroup, strGroup2, this.a);
            Intrinsics3.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        Xml.a aVar2 = new Xml.a(strGroup, strGroup2, this.a);
        int iStart = matcher.start(2);
        int iEnd = matcher.end(2);
        Intrinsics3.checkNotNullParameter(aVar2, "node");
        return new ParseSpec<>(aVar2, s2, iStart, iEnd);
    }
}
