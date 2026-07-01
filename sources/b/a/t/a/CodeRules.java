package b.a.t.a;

import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.a, reason: use source file name */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeRules<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ Map a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode.a f287b;
    public final /* synthetic */ Function3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules(CodeRules5 codeRules5, Map map, StyleNode.a aVar, Function3 function3, Pattern pattern) {
        super(pattern);
        this.a = map;
        this.f287b = aVar;
        this.c = function3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        CodeNode.a bVar;
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(3);
        if (strGroup2 == null) {
            strGroup2 = "";
        }
        String strGroup3 = matcher.group(2);
        boolean zContains$default = strGroup3 != null ? Strings4.contains$default((CharSequence) strGroup3, '\n', false, 2, (Object) null) : false;
        List<? extends Rule<R, ? extends T, S>> list = strGroup != null ? (List) this.a.get(strGroup) : 0;
        if (list != 0) {
            List<T> list2 = parser.parse(strGroup2, s2, list);
            Objects.requireNonNull(list2, "null cannot be cast to non-null type kotlin.collections.List<com.discord.simpleast.core.node.Node<R>>");
            bVar = new CodeNode.a.C0068a(strGroup2, list2);
        } else {
            bVar = new CodeNode.a.b(strGroup2);
        }
        Node node = (Node) this.c.invoke(new CodeNode(bVar, strGroup, this.f287b), Boolean.valueOf(zContains$default), s2);
        Intrinsics3.checkNotNullParameter(node, "node");
        return new ParseSpec<>(node, s2);
    }
}
