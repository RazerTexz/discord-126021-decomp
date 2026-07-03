package p007b.p008a.p050t.p051a;

import android.text.SpannableStringBuilder;
import com.discord.simpleast.code.CodeNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [R, S] */
/* JADX INFO: renamed from: b.a.t.a.c */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1277c<R, S> extends Rule<R, Node<R>, S> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1895a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StyleNode.InterfaceC5656a f1896b;

    /* JADX INFO: renamed from: b.a.t.a.c$a */
    /* JADX INFO: compiled from: CodeRules.kt */
    public static final class a extends Node.C5655a<R> {
        public a(CodeNode codeNode, Node[] nodeArr) {
            super(nodeArr);
        }

        @Override // com.discord.simpleast.core.node.Node.C5655a, com.discord.simpleast.core.node.Node
        public void render(SpannableStringBuilder spannableStringBuilder, R r) {
            C12238m.checkNotNullParameter(spannableStringBuilder, "builder");
            int length = spannableStringBuilder.length();
            super.render(spannableStringBuilder, r);
            Iterator<?> it = C1277c.this.f1896b.get(r).iterator();
            while (it.hasNext()) {
                spannableStringBuilder.setSpan(it.next(), length, spannableStringBuilder.length(), 33);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1277c(C1279e c1279e, StyleNode.InterfaceC5656a interfaceC5656a, StyleNode.InterfaceC5656a interfaceC5656a2, Pattern pattern) {
        super(pattern);
        this.f1895a = interfaceC5656a;
        this.f1896b = interfaceC5656a2;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
        C12238m.checkNotNullParameter(matcher, "matcher");
        C12238m.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(2);
        if (strGroup == null) {
            strGroup = "";
        }
        if (!(strGroup.length() == 0)) {
            CodeNode codeNode = new CodeNode(new CodeNode.AbstractC5653a.b(strGroup), null, this.f1895a);
            a aVar = new a(codeNode, new Node[]{codeNode});
            C12238m.checkNotNullParameter(aVar, "node");
            return new ParseSpec<>(aVar, s2);
        }
        String strGroup2 = matcher.group();
        C12238m.checkNotNullExpressionValue(strGroup2, "matcher.group()");
        C1298a c1298a = new C1298a(strGroup2);
        C12238m.checkNotNullParameter(c1298a, "node");
        return new ParseSpec<>(c1298a, s2);
    }
}
