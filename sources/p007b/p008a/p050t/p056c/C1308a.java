package p007b.p008a.p050t.p056c;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
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
import p007b.p008a.p050t.p052b.p054b.C1303e;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.c.a */
/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1308a {

    /* JADX INFO: renamed from: a */
    public static final Pattern f1992a;

    /* JADX INFO: renamed from: b */
    public static final Pattern f1993b;

    /* JADX INFO: renamed from: c */
    public static final Pattern f1994c;

    /* JADX INFO: renamed from: d */
    public static final Pattern f1995d;

    /* JADX INFO: renamed from: e */
    public static final C1308a f1996e = new C1308a();

    /* JADX INFO: renamed from: b.a.t.c.a$c */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class c<R, S> extends Rule.BlockRule<R, Node<R>, S> {
        private final Function1<Integer, CharacterStyle> styleSpanProvider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern);
            C12238m.checkNotNullParameter(pattern, "pattern");
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
            this.styleSpanProvider = function1;
        }

        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            C12238m.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(C12145m.listOf(this.styleSpanProvider.invoke(Integer.valueOf(str.length()))));
        }

        public final Function1<Integer, CharacterStyle> getStyleSpanProvider() {
            return this.styleSpanProvider;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(1);
            C12238m.checkNotNullExpressionValue(strGroup, "matcher.group(1)");
            StyleNode<R, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            int iStart = matcher.start(2);
            int iEnd = matcher.end(2);
            C12238m.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2, iStart, iEnd);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(Function1<? super Integer, ? extends CharacterStyle> function1) {
            this(C1308a.f1993b, function1);
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
            C1308a c1308a = C1308a.f1996e;
        }
    }

    static {
        Pattern patternCompile = Pattern.compile("^\\*[ \\t](.*)(?=\\n|$)", 0);
        C12238m.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        f1992a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^\\s*(#+)[ \\t](.*) *(?=\\n|$)", 0);
        C12238m.checkNotNullExpressionValue(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
        f1993b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^\\s*(.+)\\n *(=|-){3,} *(?=\\n|$)", 0);
        C12238m.checkNotNullExpressionValue(patternCompile3, "java.util.regex.Pattern.compile(this, flags)");
        f1994c = patternCompile3;
        f1995d = new Regex("^\\s*(?:(?:(.+)(?: +\\{([\\w ]*)\\}))|(.*))[ \\t]*\\n *([=\\-]){3,}[ \\t]*(?=\\n|$)").getNativePattern();
    }

    /* JADX INFO: renamed from: b.a.t.c.a$a */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class a<RC, T, S> extends b<RC, S> {
        private final Function1<String, T> classSpanProvider;
        private final List<Rule<RC, Node<RC>, S>> innerRules;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2, List<? extends Rule<RC, Node<RC>, S>> list) {
            super(C1308a.f1995d, function1);
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
            C12238m.checkNotNullParameter(function2, "classSpanProvider");
            C12238m.checkNotNullParameter(list, "innerRules");
            C1308a c1308a = C1308a.f1996e;
            this.classSpanProvider = function2;
            this.innerRules = list;
        }

        public final Function1<String, T> getClassSpanProvider() {
            return this.classSpanProvider;
        }

        public final List<Rule<RC, Node<RC>, S>> getInnerRules() {
            return this.innerRules;
        }

        @Override // p007b.p008a.p050t.p056c.C1308a.b, p007b.p008a.p050t.p056c.C1308a.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<RC, S> parse(Matcher matcher, Parser<RC, ? super Node<RC>, S> parser, S s2) {
            List listEmptyList;
            String string;
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group(4);
            C12238m.checkNotNullExpressionValue(strGroup, "matcher.group(4)");
            StyleNode<RC, CharacterStyle> styleNodeCreateHeaderStyleNode = createHeaderStyleNode(strGroup);
            String strGroup2 = matcher.group(1);
            if (strGroup2 == null) {
                strGroup2 = matcher.group(3);
            }
            C12238m.checkNotNullExpressionValue(strGroup2, "headerBody");
            for (Object obj : parser.parse(strGroup2, s2, this.innerRules)) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.simpleast.core.node.Node<RC>");
                styleNodeCreateHeaderStyleNode.addChild((Node) obj);
            }
            String strGroup3 = matcher.group(2);
            List listSplit$default = (strGroup3 == null || (string = C12106w.trim(strGroup3).toString()) == null) ? null : C12106w.split$default((CharSequence) string, new char[]{' '}, false, 0, 6, (Object) null);
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
                listEmptyList = C12147n.emptyList();
            }
            if (!listEmptyList.isEmpty()) {
                StyleNode<RC, CharacterStyle> styleNode = new StyleNode<>(listEmptyList);
                styleNode.addChild(styleNodeCreateHeaderStyleNode);
                styleNodeCreateHeaderStyleNode = styleNode;
            }
            C12238m.checkNotNullParameter(styleNodeCreateHeaderStyleNode, "node");
            return new ParseSpec<>(styleNodeCreateHeaderStyleNode, s2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Function1<? super Integer, ? extends CharacterStyle> function1, Function1<? super String, ? extends T> function2) {
            this(function1, function2, C12163u.plus((Collection<? extends Rule>) C1303e.m372b(false, false, 2), C1303e.f1988h.m374d()));
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
            C12238m.checkNotNullParameter(function2, "classSpanProvider");
        }
    }

    /* JADX INFO: renamed from: b.a.t.c.a$b */
    /* JADX INFO: compiled from: MarkdownRules.kt */
    public static class b<R, S> extends c<R, S> {
        /* JADX WARN: Illegal instructions before constructor call */
        public b(Pattern pattern, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                C1308a c1308a = C1308a.f1996e;
                pattern = C1308a.f1994c;
            }
            this(pattern, function1);
        }

        @Override // p007b.p008a.p050t.p056c.C1308a.c
        public StyleNode<R, CharacterStyle> createHeaderStyleNode(String str) {
            C12238m.checkNotNullParameter(str, "headerStyleGroup");
            return new StyleNode<>(C12145m.listOf(getStyleSpanProvider().invoke(Integer.valueOf((str.hashCode() == 61 && str.equals("=")) ? 1 : 2))));
        }

        @Override // p007b.p008a.p050t.p056c.C1308a.c, com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            throw null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Pattern pattern, Function1<? super Integer, ? extends CharacterStyle> function1) {
            super(pattern, function1);
            C12238m.checkNotNullParameter(pattern, "pattern");
            C12238m.checkNotNullParameter(function1, "styleSpanProvider");
        }
    }
}
