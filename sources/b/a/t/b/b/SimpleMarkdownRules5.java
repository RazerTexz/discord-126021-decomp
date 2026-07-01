package b.a.t.b.b;

import android.text.style.CharacterStyle;
import b.a.t.b.a.TextNode;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.t.b.b.e, reason: use source file name */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleMarkdownRules5 {
    public static final SimpleMarkdownRules5 h = new SimpleMarkdownRules5();
    public static final Pattern a = Pattern.compile("^\\*\\*([\\s\\S]+?)\\*\\*(?!\\*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f308b = Pattern.compile("^__([\\s\\S]+?)__(?!_)");
    public static final Pattern c = Pattern.compile("^~~(?=\\S)([\\s\\S]*?\\S)~~");
    public static final Pattern d = Pattern.compile("^(?:\\n *)*\\n");
    public static final Pattern e = Pattern.compile("^[\\s\\S]+?(?=[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");
    public static final Pattern f = Pattern.compile("^\\\\([^0-9A-Za-z\\s])");
    public static final Pattern g = Pattern.compile("^\\b_((?:__|\\\\[\\s\\S]|[^\\\\_])+?)_\\b|^\\*(?=\\S)((?:\\*\\*|\\s+(?:[^*\\s]|\\*\\*)|[^\\s*])+?)\\*(?!\\*)");

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$a */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class a<R, S> extends Rule<R, Node<R>, S> {
        public final /* synthetic */ Function0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Pattern pattern, Pattern pattern2) {
            super(pattern2);
            this.a = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode((List) this.a.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            Intrinsics3.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, s2, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$b */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class b<R, S> extends Rule<R, Node<R>, S> {
        public b(SimpleMarkdownRules5 simpleMarkdownRules5, Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group()");
            TextNode textNode = new TextNode(strGroup);
            Intrinsics3.checkNotNullParameter(textNode, "node");
            return new ParseSpec<>(textNode, s2);
        }
    }

    public static final <R, S> List<Rule<R, Node<R>, S>> a(boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            SimpleMarkdownRules5 simpleMarkdownRules5 = h;
            Pattern pattern = f;
            Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
            arrayList.add(new SimpleMarkdownRules2(simpleMarkdownRules5, pattern));
        }
        SimpleMarkdownRules5 simpleMarkdownRules6 = h;
        Pattern pattern2 = d;
        Intrinsics3.checkNotNullExpressionValue(pattern2, "PATTERN_NEWLINE");
        arrayList.add(new SimpleMarkdownRules4(simpleMarkdownRules6, pattern2));
        Pattern pattern3 = a;
        Intrinsics3.checkNotNullExpressionValue(pattern3, "PATTERN_BOLD");
        arrayList.add(c(pattern3, SimpleMarkdownRules.j));
        Pattern pattern4 = f308b;
        Intrinsics3.checkNotNullExpressionValue(pattern4, "PATTERN_UNDERLINE");
        arrayList.add(c(pattern4, SimpleMarkdownRules7.j));
        Pattern pattern5 = g;
        Intrinsics3.checkNotNullExpressionValue(pattern5, "PATTERN_ITALICS");
        arrayList.add(new SimpleMarkdownRules3(simpleMarkdownRules6, pattern5));
        Pattern pattern6 = c;
        Intrinsics3.checkNotNullExpressionValue(pattern6, "PATTERN_STRIKETHRU");
        arrayList.add(c(pattern6, SimpleMarkdownRules6.j));
        if (z2) {
            arrayList.add(simpleMarkdownRules6.d());
        }
        return arrayList;
    }

    public static /* synthetic */ List b(boolean z2, boolean z3, int i) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return a(z2, z3);
    }

    public static final <R, S> Rule<R, Node<R>, S> c(Pattern pattern, Function0<? extends List<? extends CharacterStyle>> function0) {
        Intrinsics3.checkNotNullParameter(pattern, "pattern");
        Intrinsics3.checkNotNullParameter(function0, "styleFactory");
        return new a(function0, pattern, pattern);
    }

    public final <R, S> Rule<R, Node<R>, S> d() {
        Pattern pattern = e;
        Intrinsics3.checkNotNullExpressionValue(pattern, "PATTERN_TEXT");
        return new b(this, pattern);
    }
}
