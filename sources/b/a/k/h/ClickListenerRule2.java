package b.a.k.h;

import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.a.k.h.e, reason: use source file name */
/* JADX INFO: compiled from: ClickListenerRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClickListenerRule2 {
    public static final Pattern a = Pattern.compile("^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)");
}
