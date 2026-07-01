package b.a.t.c;

import d0.z.d.m;
import java.util.regex.Pattern;
import kotlin.text.Regex;

/* JADX INFO: compiled from: MarkdownRules.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static final Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f309b;
    public static final Pattern c;
    public static final Pattern d;
    public static final a e = new a();

    static {
        Pattern patternCompile = Pattern.compile("^\\*[ \\t](.*)(?=\\n|$)", 0);
        m.checkNotNullExpressionValue(patternCompile, "java.util.regex.Pattern.compile(this, flags)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^\\s*(#+)[ \\t](.*) *(?=\\n|$)", 0);
        m.checkNotNullExpressionValue(patternCompile2, "java.util.regex.Pattern.compile(this, flags)");
        f309b = patternCompile2;
        Pattern patternCompile3 = Pattern.compile("^\\s*(.+)\\n *(=|-){3,} *(?=\\n|$)", 0);
        m.checkNotNullExpressionValue(patternCompile3, "java.util.regex.Pattern.compile(this, flags)");
        c = patternCompile3;
        d = new Regex("^\\s*(?:(?:(.+)(?: +\\{([\\w ]*)\\}))|(.*))[ \\t]*\\n *([=\\-]){3,}[ \\t]*(?=\\n|$)").getNativePattern();
    }
}
