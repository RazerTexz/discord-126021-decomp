package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r$d<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r$d$a f305b = new r$d$a(null);
    public static final Pattern a = Pattern.compile("^([{\\[(,;](?:\\s*-)?)(\\s*(?:public|private|protected|readonly))?(\\s*[a-zA-Z0-9_$]+)((?:\\s*\\?)?\\s*:)");

    /* JADX WARN: Illegal instructions before constructor call */
    public r$d(String str, String str2, String str3, String str4, f<RC> fVar) {
        d0.z.d.m.checkNotNullParameter(str, "prefix");
        d0.z.d.m.checkNotNullParameter(str3, "property");
        d0.z.d.m.checkNotNullParameter(str4, "suffix");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        Node[] nodeArr = new Node[4];
        nodeArr[0] = new StyleNode$b(str, fVar.a);
        nodeArr[1] = str2 != null ? new StyleNode$b(str2, fVar.d) : null;
        nodeArr[2] = new StyleNode$b(str3, fVar.e);
        nodeArr[3] = new StyleNode$b(str4, fVar.a);
        super(nodeArr);
    }
}
