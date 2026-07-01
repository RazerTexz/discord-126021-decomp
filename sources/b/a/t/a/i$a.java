package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Crystal.kt */
/* JADX INFO: loaded from: classes.dex */
public final class i$a<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i$a$a f293b = new i$a$a(null);
    public static final Pattern a = Pattern.compile("^(def)( +\\w+)( *\\( *(?:@\\w+ +: +\\w*)?\\w+(?: +[:=] +.*)? *\\))?(?!.+)");

    /* JADX WARN: Illegal instructions before constructor call */
    public i$a(String str, String str2, String str3, f<RC> fVar) {
        d0.z.d.m.checkNotNullParameter(str, "pre");
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        Node[] nodeArr = new Node[3];
        nodeArr[0] = new StyleNode$b(str, fVar.d);
        nodeArr[1] = new StyleNode$b(str2, fVar.e);
        nodeArr[2] = str3 != null ? new StyleNode$b(str3, fVar.h) : null;
        super(nodeArr);
    }
}
