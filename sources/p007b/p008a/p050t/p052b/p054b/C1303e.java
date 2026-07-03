package p007b.p008a.p050t.p052b.p054b;

import android.text.style.CharacterStyle;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p050t.p052b.p053a.C1298a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.b.b.e */
/* JADX INFO: compiled from: SimpleMarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1303e {

    /* JADX INFO: renamed from: h */
    public static final C1303e f1988h = new C1303e();

    /* JADX INFO: renamed from: a */
    public static final Pattern f1981a = Pattern.compile("^\\*\\*([\\s\\S]+?)\\*\\*(?!\\*)");

    /* JADX INFO: renamed from: b */
    public static final Pattern f1982b = Pattern.compile("^__([\\s\\S]+?)__(?!_)");

    /* JADX INFO: renamed from: c */
    public static final Pattern f1983c = Pattern.compile("^~~(?=\\S)([\\s\\S]*?\\S)~~");

    /* JADX INFO: renamed from: d */
    public static final Pattern f1984d = Pattern.compile("^(?:\\n *)*\\n");

    /* JADX INFO: renamed from: e */
    public static final Pattern f1985e = Pattern.compile("^[\\s\\S]+?(?=[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");

    /* JADX INFO: renamed from: f */
    public static final Pattern f1986f = Pattern.compile("^\\\\([^0-9A-Za-z\\s])");

    /* JADX INFO: renamed from: g */
    public static final Pattern f1987g = Pattern.compile("^\\b_((?:__|\\\\[\\s\\S]|[^\\\\_])+?)_\\b|^\\*(?=\\S)((?:\\*\\*|\\s+(?:[^*\\s]|\\*\\*)|[^\\s*])+?)\\*(?!\\*)");

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$a */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class a<R, S> extends Rule<R, Node<R>, S> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function0 f1989a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Pattern pattern, Pattern pattern2) {
            super(pattern2);
            this.f1989a = function0;
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            StyleNode styleNode = new StyleNode((List) this.f1989a.invoke());
            int iStart = matcher.start(1);
            int iEnd = matcher.end(1);
            C12238m.checkNotNullParameter(styleNode, "node");
            return new ParseSpec<>(styleNode, s2, iStart, iEnd);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* JADX INFO: renamed from: b.a.t.b.b.e$b */
    /* JADX INFO: compiled from: SimpleMarkdownRules.kt */
    public static final class b<R, S> extends Rule<R, Node<R>, S> {
        public b(C1303e c1303e, Pattern pattern) {
            super(pattern);
        }

        @Override // com.discord.simpleast.core.parser.Rule
        public ParseSpec<R, S> parse(Matcher matcher, Parser<R, ? super Node<R>, S> parser, S s2) {
            C12238m.checkNotNullParameter(matcher, "matcher");
            C12238m.checkNotNullParameter(parser, "parser");
            String strGroup = matcher.group();
            C12238m.checkNotNullExpressionValue(strGroup, "matcher.group()");
            C1298a c1298a = new C1298a(strGroup);
            C12238m.checkNotNullParameter(c1298a, "node");
            return new ParseSpec<>(c1298a, s2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final <R, S> List<Rule<R, Node<R>, S>> m371a(boolean z2, boolean z3) {
        ArrayList arrayList = new ArrayList();
        if (z3) {
            C1303e c1303e = f1988h;
            Pattern pattern = f1986f;
            C12238m.checkNotNullExpressionValue(pattern, "PATTERN_ESCAPE");
            arrayList.add(new C1300b(c1303e, pattern));
        }
        C1303e c1303e2 = f1988h;
        Pattern pattern2 = f1984d;
        C12238m.checkNotNullExpressionValue(pattern2, "PATTERN_NEWLINE");
        arrayList.add(new C1302d(c1303e2, pattern2));
        Pattern pattern3 = f1981a;
        C12238m.checkNotNullExpressionValue(pattern3, "PATTERN_BOLD");
        arrayList.add(m373c(pattern3, C1299a.f1980j));
        Pattern pattern4 = f1982b;
        C12238m.checkNotNullExpressionValue(pattern4, "PATTERN_UNDERLINE");
        arrayList.add(m373c(pattern4, C1305g.f1991j));
        Pattern pattern5 = f1987g;
        C12238m.checkNotNullExpressionValue(pattern5, "PATTERN_ITALICS");
        arrayList.add(new C1301c(c1303e2, pattern5));
        Pattern pattern6 = f1983c;
        C12238m.checkNotNullExpressionValue(pattern6, "PATTERN_STRIKETHRU");
        arrayList.add(m373c(pattern6, C1304f.f1990j));
        if (z2) {
            arrayList.add(c1303e2.m374d());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ List m372b(boolean z2, boolean z3, int i) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        if ((i & 2) != 0) {
            z3 = true;
        }
        return m371a(z2, z3);
    }

    /* JADX INFO: renamed from: c */
    public static final <R, S> Rule<R, Node<R>, S> m373c(Pattern pattern, Function0<? extends List<? extends CharacterStyle>> function0) {
        C12238m.checkNotNullParameter(pattern, "pattern");
        C12238m.checkNotNullParameter(function0, "styleFactory");
        return new a(function0, pattern, pattern);
    }

    /* JADX INFO: renamed from: d */
    public final <R, S> Rule<R, Node<R>, S> m374d() {
        Pattern pattern = f1985e;
        C12238m.checkNotNullExpressionValue(pattern, "PATTERN_TEXT");
        return new b(this, pattern);
    }
}
