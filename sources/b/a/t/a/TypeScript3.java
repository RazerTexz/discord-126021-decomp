package b.a.t.a;

import b.a.t.a.TypeScript2;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [RC, S] */
/* JADX INFO: renamed from: b.a.t.a.s, reason: use source file name */
/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypeScript3<RC, S> extends Rule<RC, Node<RC>, S> {
    public final /* synthetic */ CodeStyleProviders a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeScript3(TypeScript2.b.a aVar, CodeStyleProviders codeStyleProviders, Pattern pattern) {
        super(pattern);
        this.a = codeStyleProviders;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup);
        Intrinsics3.checkNotNull(strGroup2);
        TypeScript2.b bVar = new TypeScript2.b(strGroup, strGroup2, this.a);
        Intrinsics3.checkNotNullParameter(bVar, "node");
        return new ParseSpec<>(bVar, s2);
    }
}
