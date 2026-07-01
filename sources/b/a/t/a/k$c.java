package b.a.t.a;

import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: JavaScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k$c<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k$c$a f297b = new k$c$a(null);
    public static final Pattern a = Pattern.compile("^([\\{\\[\\,])(\\s*[a-zA-Z0-9_$]+)(\\s*:)");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c(String str, String str2, String str3, f<RC> fVar) {
        super(new StyleNode$b(str, fVar.a), new StyleNode$b(str2, fVar.e), new StyleNode$b(str3, fVar.a));
        d0.z.d.m.checkNotNullParameter(str, "prefix");
        d0.z.d.m.checkNotNullParameter(str2, "property");
        d0.z.d.m.checkNotNullParameter(str3, "suffix");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
    }
}
