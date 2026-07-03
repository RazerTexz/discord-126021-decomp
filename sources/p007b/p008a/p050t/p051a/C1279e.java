package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.Rule;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.t.a.e */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1279e {

    /* JADX INFO: renamed from: a */
    public static final Pattern f1900a;

    /* JADX INFO: renamed from: b */
    public static final Pattern f1901b;

    /* JADX INFO: renamed from: c */
    public static final Pattern f1902c;

    /* JADX INFO: renamed from: d */
    public static final Pattern f1903d;

    /* JADX INFO: renamed from: e */
    public static final Pattern f1904e;

    /* JADX INFO: renamed from: f */
    public static final C1279e f1905f = new C1279e();

    static {
        Pattern patternCompile = Pattern.compile("^```(?:([\\w+\\-.]+?)?(\\s*\\n))?([^\\n].*?)\\n*```", 32);
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^```(…n*```\"\"\", Pattern.DOTALL)");
        f1900a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^(``?)([^`]*)\\1", 32);
        C12238m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^(``?…]*)\\1\"\"\", Pattern.DOTALL)");
        f1901b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^(?:\\n\\s*)+");
        C12238m.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^(?:\\n\\s*)+\"\"\")");
        f1902c = patternCompile3;
        Pattern patternCompile4 = Pattern.compile("^[\\s\\S]+?(?=\\b|[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");
        C12238m.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^[\\s\\…|\\n| {2,}\\n|\\w+:\\S|$)\"\"\")");
        f1903d = patternCompile4;
        Pattern patternCompile5 = Pattern.compile("^\\b\\d+?\\b");
        C12238m.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\\b\\d+?\\b\"\"\")");
        f1904e = patternCompile5;
    }

    /* JADX INFO: renamed from: e */
    public static Rule m367e(C1279e c1279e, Pattern pattern, int i, StyleNode.InterfaceC5656a interfaceC5656a, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            interfaceC5656a = null;
        }
        C12238m.checkNotNullParameter(pattern, "$this$toMatchGroupRule");
        return new C1278d(pattern, i, interfaceC5656a, pattern);
    }

    /* JADX INFO: renamed from: a */
    public final <R, S> List<Rule<R, Node<R>, S>> m368a(C1280f<R> c1280f, List<? extends Rule<R, Node<R>, S>> list, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String[] strArr5 = (String[]) Arrays.copyOf(strArr, strArr.length);
        C12238m.checkNotNullParameter(c1280f, "codeStyleProviders");
        C12238m.checkNotNullParameter(strArr5, "identifiers");
        StringBuilder sbM833U = C1643a.m833U("^\\b(");
        sbM833U.append(C12141k.joinToString$default(strArr5, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbM833U.append(")(\\s+\\w+)");
        Pattern patternCompile = Pattern.compile(sbM833U.toString());
        C12238m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\\b($…String(\"|\")})(\\s+\\w+)\"\"\")");
        Pattern patternM370d = m370d((String[]) Arrays.copyOf(strArr2, strArr2.length));
        C12238m.checkNotNullExpressionValue(patternM370d, "createWordPattern(*builtIns)");
        Pattern patternM370d2 = m370d((String[]) Arrays.copyOf(strArr3, strArr3.length));
        C12238m.checkNotNullExpressionValue(patternM370d2, "createWordPattern(*keywords)");
        Pattern patternM370d3 = m370d((String[]) Arrays.copyOf(strArr4, strArr4.length));
        C12238m.checkNotNullExpressionValue(patternM370d3, "createWordPattern(*types)");
        return C12163u.plus((Collection) list, (Iterable) C12147n.listOf((Object[]) new Rule[]{new C1276b(c1280f, strArr5, patternCompile), m367e(this, patternM370d, 0, c1280f.f1912g, 1), m367e(this, patternM370d2, 0, c1280f.f1909d, 1), m367e(this, patternM370d3, 0, c1280f.f1911f, 1), m367e(this, f1904e, 0, c1280f.f1908c, 1), m367e(this, f1902c, 0, null, 3), m367e(this, f1903d, 0, null, 3)}));
    }

    /* JADX INFO: renamed from: c */
    public final Pattern m369c(String str) {
        return Pattern.compile("^(?:" + str + ".*?(?=\\n|$))");
    }

    /* JADX INFO: renamed from: d */
    public final Pattern m370d(String... strArr) {
        C12238m.checkNotNullParameter(strArr, "words");
        StringBuilder sbM833U = C1643a.m833U("^\\b(?:");
        sbM833U.append(C12141k.joinToString$default(strArr, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbM833U.append(")\\b");
        return Pattern.compile(sbM833U.toString());
    }
}
