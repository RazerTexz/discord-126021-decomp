package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;
import kotlin.text.Regex;

/* JADX INFO: compiled from: Kotlin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$b<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o$b$a f300b = new o$b$a(null);
    public static final Pattern a = new Regex("^(fun)( *<.*>)?( \\w+)( *\\(.*?\\))", d0.g0.i.DOT_MATCHES_ALL).getNativePattern();

    /* JADX WARN: Illegal instructions before constructor call */
    public o$b(String str, String str2, String str3, String str4, f<RC> fVar) {
        d0.z.d.m.checkNotNullParameter(str, "pre");
        d0.z.d.m.checkNotNullParameter(str3, "signature");
        d0.z.d.m.checkNotNullParameter(str4, "params");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        Node[] nodeArr = new Node[4];
        nodeArr[0] = new StyleNode$b(str, fVar.d);
        nodeArr[1] = str2 != null ? new StyleNode$b(str2, fVar.g) : null;
        nodeArr[2] = new StyleNode$b(str3, fVar.e);
        nodeArr[3] = new StyleNode$b(str4, fVar.h);
        super(nodeArr);
    }
}
