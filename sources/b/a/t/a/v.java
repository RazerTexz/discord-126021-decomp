package b.a.t.a;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: Xml.kt */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final Pattern a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f306b;
    public static final v c = new v();

    static {
        Pattern patternCompile = Pattern.compile("^<!--[\\s\\S]*?-->", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile, "Pattern.compile(\"\"\"^<!--…*?-->\"\"\", Pattern.DOTALL)");
        a = patternCompile;
        Pattern patternCompile2 = Pattern.compile("^<([\\s\\S]+?)(?:>(.*?)<\\/([\\s\\S]+?))?>", 32);
        d0.z.d.m.checkNotNullExpressionValue(patternCompile2, "Pattern.compile(\n      \"…?))?>\"\"\", Pattern.DOTALL)");
        f306b = patternCompile2;
    }
}
