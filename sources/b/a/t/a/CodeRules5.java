package b.a.t.a;

import b.d.b.a.outline;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.simpleast.core.parser.Rule;
import d0.t.Collections2;
import d0.t._Arrays;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.t.a.e, reason: use source file name */
/* JADX INFO: compiled from: CodeRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CodeRules5 {
    public static final Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f290b;
    public static final Pattern c;
    public static final Pattern d;
    public static final Pattern e;
    public static final CodeRules5 f = new CodeRules5();

    static {
        Pattern patternCompile = Pattern.compile("^```(?:([\\w+\\-.]+?)?(\\s*\\n))?([^\\n].*?)\\n*```", 32);
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^```(…n*```\"\"\", Pattern.DOTALL)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^(``?)([^`]*)\\1", 32);
        Intrinsics3.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\"\"\"^(``?…]*)\\1\"\"\", Pattern.DOTALL)");
        f290b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^(?:\\n\\s*)+");
        Intrinsics3.checkNotNullExpressionValue(patternCompile3, "Pattern.compile(\"\"\"^(?:\\n\\s*)+\"\"\")");
        c = patternCompile3;
        Pattern patternCompile4 = Pattern.compile("^[\\s\\S]+?(?=\\b|[^0-9A-Za-z\\s\\u00c0-\\uffff]|\\n| {2,}\\n|\\w+:\\S|$)");
        Intrinsics3.checkNotNullExpressionValue(patternCompile4, "Pattern.compile(\"\"\"^[\\s\\…|\\n| {2,}\\n|\\w+:\\S|$)\"\"\")");
        d = patternCompile4;
        Pattern patternCompile5 = Pattern.compile("^\\b\\d+?\\b");
        Intrinsics3.checkNotNullExpressionValue(patternCompile5, "Pattern.compile(\"\"\"^\\b\\d+?\\b\"\"\")");
        e = patternCompile5;
    }

    public static Rule e(CodeRules5 codeRules5, Pattern pattern, int i, StyleNode.a aVar, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            aVar = null;
        }
        Intrinsics3.checkNotNullParameter(pattern, "$this$toMatchGroupRule");
        return new CodeRules4(pattern, i, aVar, pattern);
    }

    public final <R, S> List<Rule<R, Node<R>, S>> a(CodeStyleProviders<R> codeStyleProviders, List<? extends Rule<R, Node<R>, S>> list, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        String[] strArr5 = (String[]) Arrays.copyOf(strArr, strArr.length);
        Intrinsics3.checkNotNullParameter(codeStyleProviders, "codeStyleProviders");
        Intrinsics3.checkNotNullParameter(strArr5, "identifiers");
        StringBuilder sbU = outline.U("^\\b(");
        sbU.append(_Arrays.joinToString$default(strArr5, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbU.append(")(\\s+\\w+)");
        Pattern patternCompile = Pattern.compile(sbU.toString());
        Intrinsics3.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^\\b($…String(\"|\")})(\\s+\\w+)\"\"\")");
        Pattern patternD = d((String[]) Arrays.copyOf(strArr2, strArr2.length));
        Intrinsics3.checkNotNullExpressionValue(patternD, "createWordPattern(*builtIns)");
        Pattern patternD2 = d((String[]) Arrays.copyOf(strArr3, strArr3.length));
        Intrinsics3.checkNotNullExpressionValue(patternD2, "createWordPattern(*keywords)");
        Pattern patternD3 = d((String[]) Arrays.copyOf(strArr4, strArr4.length));
        Intrinsics3.checkNotNullExpressionValue(patternD3, "createWordPattern(*types)");
        return _Collections.plus((Collection) list, (Iterable) Collections2.listOf((Object[]) new Rule[]{new CodeRules2(codeStyleProviders, strArr5, patternCompile), e(this, patternD, 0, codeStyleProviders.g, 1), e(this, patternD2, 0, codeStyleProviders.d, 1), e(this, patternD3, 0, codeStyleProviders.f, 1), e(this, e, 0, codeStyleProviders.c, 1), e(this, c, 0, null, 3), e(this, d, 0, null, 3)}));
    }

    public final Pattern c(String str) {
        return Pattern.compile("^(?:" + str + ".*?(?=\\n|$))");
    }

    public final Pattern d(String... strArr) {
        Intrinsics3.checkNotNullParameter(strArr, "words");
        StringBuilder sbU = outline.U("^\\b(?:");
        sbU.append(_Arrays.joinToString$default(strArr, "|", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        sbU.append(")\\b");
        return Pattern.compile(sbU.toString());
    }
}
