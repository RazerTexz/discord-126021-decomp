package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;
import kotlin.text.Regex;

/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r$c<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r$c$a f304b = new r$c$a(null);
    public static final Pattern a = new Regex("^((?:function\\*?|static|get|set|async)\\s)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)?(\\s*<.*>)?", d0.g0.i.DOT_MATCHES_ALL).getNativePattern();

    /* JADX WARN: Illegal instructions before constructor call */
    public r$c(String str, String str2, String str3, f<RC> fVar) {
        d0.z.d.m.checkNotNullParameter(str, "pre");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        Node[] nodeArr = new Node[3];
        nodeArr[0] = new StyleNode$b(str, fVar.d);
        nodeArr[1] = str2 != null ? new StyleNode$b(str2, fVar.e) : null;
        nodeArr[2] = str3 != null ? new StyleNode$b(str3, fVar.g) : null;
        super(nodeArr);
    }
}
