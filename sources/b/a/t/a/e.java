package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.simpleast.core.parser.Rule;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f290b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final e f = new e();

    static {
        Pattern patternCompile = Pattern.compile("^```(?:([\\w+\\-.]+?)?(\\s*\\n))?([^\\n].*?)\\n*```", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^```(…n*```\"\"\", Pattern.DOTALL)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^(``?)([^`]*)\\1", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^(``?…]*)\\1\"\"\", Pattern.DOTALL)");
        f290b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^(?:\\n\\s*)+");
        d0.z.d.m.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^(?:\\n\\s*)+\"\"\")");
        c = patternCompile3;
        Pattern patternCompile4 = Pattern.compile("^[\\s\\S]+?(?=\\b|[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");
        d0.z.d.m.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^[\\s\\…|\\n| {2,}\\n|\\w+:\\S|$)\"\"\")");
        d = patternCompile4;
        Pattern patternCompile5 = Pattern.compile("^\\b\\d+?\\b");
        d0.z.d.m.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\\b\\d+?\\b\"\"\")");
        e = patternCompile5;
    }

    public static /* synthetic */ List b(e eVar, f fVar, List list, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, int i) {
        return eVar.a(fVar, list, strArr, strArr2, strArr3, (i & 32) != 0 ? new String[]{" "} : null);
    }

    public static Rule e(e eVar, Pattern pattern, int i, StyleNode$a styleNode$a, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            styleNode$a = null;
        }
        d0.z.d.m.checkNotNullParameter(pattern, "$this$toMatchGroupRule");
        return new d(pattern, i, styleNode$a, pattern);
    }

    public final <R, S> List<Rule<R, Node<R>, S>> a(f<R> fVar, List<? extends Rule<R, Node<R>, S>> list, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String[] strArr5 = (String[]) Arrays.copyOf(strArr, strArr.length);
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        d0.z.d.m.checkNotNullParameter(strArr5, "identifiers");
        StringBuilder sbU = b.d.b.a.a.U("^\\b(");
        sbU.append(d0.t.k.joinToString$default(strArr5, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbU.append(")(\\s+\\w+)");
        Pattern patternCompile = Pattern.compile(sbU.toString());
        d0.z.d.m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\\b($…String(\"|\")})(\\s+\\w+)\"\"\")");
        Pattern patternD = d((String[]) Arrays.copyOf(strArr2, strArr2.length));
        d0.z.d.m.checkNotNullExpressionValue(patternD, "createWordPattern(*builtIns)");
        Pattern patternD2 = d((String[]) Arrays.copyOf(strArr3, strArr3.length));
        d0.z.d.m.checkNotNullExpressionValue(patternD2, "createWordPattern(*keywords)");
        Pattern patternD3 = d((String[]) Arrays.copyOf(strArr4, strArr4.length));
        d0.z.d.m.checkNotNullExpressionValue(patternD3, "createWordPattern(*types)");
        return d0.t.u.plus((Collection) list, (Iterable) d0.t.n.listOf((Object[]) new Rule[]{new b(fVar, strArr5, patternCompile), e(this, patternD, 0, fVar.g, 1), e(this, patternD2, 0, fVar.d, 1), e(this, patternD3, 0, fVar.f, 1), e(this, e, 0, fVar.c, 1), e(this, c, 0, null, 3), e(this, d, 0, null, 3)}));
    }

    public final Pattern c(String str) {
        return Pattern.compile("^(?:" + str + ".*?(?=\\n|$))");
    }

    public final Pattern d(String... strArr) {
        d0.z.d.m.checkNotNullParameter(strArr, "words");
        StringBuilder sbU = b.d.b.a.a.U("^\\b(?:");
        sbU.append(d0.t.k.joinToString$default(strArr, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbU.append(")\\b");
        return Pattern.compile(sbU.toString());
    }
}
