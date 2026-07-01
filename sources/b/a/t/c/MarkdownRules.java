package b.a.t.c;

import android.text.style.CharacterStyle;
import b.a.t.b.b.SimpleMarkdownRules5;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.Regex;

/* JADX INFO: renamed from: b.a.t.c.a, reason: use source file name */
/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MarkdownRules {
    public static final Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f309b;
    public static final Pattern c;
    public static final Pattern d;
    public static final MarkdownRules e = new MarkdownRules();

    /* JADX INFO: renamed from: b.a.t.c.a$c */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class c<R, S> extends Rule.BlockRule<R, Node<R>, S> {
        private final Function1<Integer, CharacterStyle> styleSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern);
            Intrinsics3.checkNotNullParameter(pattern, "pattern");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            this.styleSpanProvider = function1;
        }

        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            Intrinsics3.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(CollectionsJVM.listOf(this.styleSpanProvider.invoke(Integer.valueOf(str.length()))));
        }

        public final Function1<Integer, CharacterStyle> getStyleSpanProvider() {
            return this.styleSpanProvider;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
            StyleNode<R, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            Intrinsics3.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2, iStart, iEnd);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(Function1<? super Integer, ? extends CharacterStyle> function1) {
            this(MarkdownRules.f309b, function1);
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            MarkdownRules markdownRules = MarkdownRules.e;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^\\*[ \\t](.*)(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^\\s*(#+)[ \\t](.*) *(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
        f309b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^\\s*(.+)\\n *(=|-){3,} *(?=\\n|$)", 0);
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "java.util.regex.Pattern.compile(this, flags)");
        c = patternCompile3;
        d = new Regex("^\\s*(?:(?:(.+)(?: +\\{([\\w ]*)\\}))|(.*))[ \\t]*\\n *([=\\-]){3,}[ \\t]*(?=\\n|$)").getNativePattern();
    }

    /* JADX INFO: renamed from: b.a.t.c.a$a */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class a<RC, T, S> extends b<RC, S> {
        private final Function1<String, T> classSpanProvider;
        private final List<Rule<RC, Node<RC>, S>> innerRules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2, List<? extends Rule<RC, Node<RC>, S>> list) {
            super(MarkdownRules.d, function1);
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function2, "classSpanProvider");
            Intrinsics3.checkNotNullParameter(list, "innerRules");
            MarkdownRules markdownRules = MarkdownRules.e;
            this.classSpanProvider = function2;
            this.innerRules = list;
        }

        public final Function1<String, T> getClassSpanProvider() {
            return this.classSpanProvider;
        }

        public final List<Rule<RC, Node<RC>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // b.a.t.c.MarkdownRules.b, b.a.t.c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
            List listEmptyList;
            String string;
            Intrinsics3.checkNotNullParameter(matcher, "matcher");
            Intrinsics3.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(4);
            Intrinsics3.checkNotNullExpressionValue(strGroup, "matcher.group(4)");
            StyleNode<RC, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            String strGroup2 = matcher.group(1);
            if (strGroup2 == null) {
                strGroup2 = matcher.group(3);
            }
            Intrinsics3.checkNotNullExpressionValue(strGroup2, "headerBody");
            for (Object obj : parser.parse(strGroup2, s2, this.innerRules)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                styleNodeCreateHeaderStyleNode.addChild((Node) obj);
            }
            String strGroup3 = matcher.group(2);
            List listSplit$default = (strGroup3 == null || (string = Strings4.trim(strGroup3).toString()) == null) ? null : Strings4.split$default((CharSequence) string, new char[]{' '}, false, 0, 6, (Object) null);
            if (listSplit$default != null) {
                listEmptyList = new ArrayList();
                Iterator<T> it = listSplit$default.iterator();
                while (it.hasNext()) {
                    T tInvoke = this.classSpanProvider.invoke((String) it.next());
                    if (tInvoke != null) {
                        listEmptyList.add(tInvoke);
                    }
                }
            } else {
                listEmptyList = Collections2.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                StyleNode<RC, CharacterStyle> styleNode = new StyleNode<>(listEmptyList);
                styleNode.addChild(styleNodeCreateHeaderStyleNode);
                styleNodeCreateHeaderStyleNode = styleNode;
            }
            Intrinsics3.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2) {
            this(function1, function2, _Collections.plus((Collection<? extends Rule>) SimpleMarkdownRules5.b(false, false, 2), SimpleMarkdownRules5.h.d()));
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
            Intrinsics3.checkNotNullParameter(function2, "classSpanProvider");
        }
    }

    /* JADX INFO: renamed from: b.a.t.c.a$b */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class b<R, S> extends c<R, S> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Pattern pattern, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                MarkdownRules markdownRules = MarkdownRules.e;
                pattern = MarkdownRules.c;
            }
            this(pattern, function1);
        }

        @Override // b.a.t.c.MarkdownRules.c
        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            Intrinsics3.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(CollectionsJVM.listOf(getStyleSpanProvider().invoke(Integer.valueOf((str.hashCode() == 61 && str.equals("=")) ? 1 : 2))));
        }

        @Override // b.a.t.c.MarkdownRules.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern, function1);
            Intrinsics3.checkNotNullParameter(pattern, "pattern");
            Intrinsics3.checkNotNullParameter(function1, "styleSpanProvider");
        }
    }
}
