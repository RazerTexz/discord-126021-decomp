package p007b.p008a.p050t.p051a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function3;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.a */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1275a<R, S> extends Rule<R, Node<R>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Map f1891a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1892b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Function3 f1893c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1275a(C1279e c1279e, Map map, StyleNode.InterfaceC5656a interfaceC5656a, Function3 function3, Pattern pattern) {
        super(pattern);
        this.f1891a = map;
        this.f1892b = interfaceC5656a;
        this.f1893c = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        CodeNode.AbstractC5653a bVar;
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(3);
        if (strGroup2 == null) {
            strGroup2 = "";
        }
        String strGroup3 = matcher.group(2);
        boolean zContains$default = strGroup3 != null ? C12106w.contains$default((CharSequence) strGroup3, '\n', false, 2, (Object) null) : false;
        List<? extends Rule<R, ? extends T, S>> list = strGroup != null ? (List) this.f1891a.get(strGroup) : 0;
        if (list != 0) {
            List<T> list2 = parser.parse(strGroup2, s2, list);
            Objects.requireNonNull(list2, "null cannot be cast to non-null type kotlin.collections.List<com.discord.simpleast.core.node.Node<R>>");
            bVar = new CodeNode.AbstractC5653a.a(strGroup2, list2);
        } else {
            bVar = new CodeNode.AbstractC5653a.b(strGroup2);
        }
        Node node = (Node) this.f1893c.invoke(new CodeNode(bVar, strGroup, this.f1892b), Boolean.valueOf(zContains$default), s2);
        C12238m.checkNotNullParameter(node, "node");
        return new ParseSpec<>(node, s2);
    }
}
