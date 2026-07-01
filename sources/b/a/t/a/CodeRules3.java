package b.a.t.a;

import android.text.SpannableStringBuilder;
import b.a.t.b.a.TextNode;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.c, reason: use source file name */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeRules3<R, S> extends Rule<R, Node<R>, S> {
    public final /* synthetic */ StyleNode.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StyleNode.a f288b;

    /* JADX INFO: renamed from: b.a.t.a.c$a */
    /* JADX INFO: compiled from: CodeRules.kt */
    public static final class a extends Node.a<R> {
        public a(CodeNode codeNode, Node[] nodeArr) {
            super(nodeArr);
        }

        @Override // com.discord.simpleast.core.node.Node.a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            Intrinsics3.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, r);
            Iterator<?> it = CodeRules3.this.f288b.get(r).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeRules3(CodeRules5 codeRules5, StyleNode.a aVar, StyleNode.a aVar2, Pattern pattern) {
        super(pattern);
        this.a = aVar;
        this.f288b = aVar2;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            strGroup = "";
        }
        if (!(strGroup.length() == 0)) {
            CodeNode codeNode = new CodeNode(new CodeNode.a.b(strGroup), null, this.a);
            a aVar = new a(codeNode, new Node[]{codeNode});
            Intrinsics3.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        String strGroup2 = matcher.group();
        Intrinsics3.checkNotNullExpressionValue(strGroup2, "matcher.group()");
        TextNode textNode = new TextNode(strGroup2);
        Intrinsics3.checkNotNullParameter(textNode, "node");
        return new ParseSpec<>(textNode, s2);
    }
}
