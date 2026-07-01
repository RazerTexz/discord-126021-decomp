package b.a.k.h;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: ClickListenerRule.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final Pattern a = Pattern.compile("^\\[((?:\\[[^]]*]|[^]]|](?=[^\\[]*]))*)]\\(\\s*<?((?:[^\\s\\\\]|\\\\.)*?)>?(?:\\s+['\"]([\\s\\S]*?)['\"])?\\s*\\)");
}
