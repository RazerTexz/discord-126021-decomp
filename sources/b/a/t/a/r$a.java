package b.a.t.a;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r$a<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r$a$a f302b = new r$a$a(null);
    public static final Pattern a = Pattern.compile("^(@)(\\s*[a-zA-Z_$][a-zA-Z0-9_$]*)(<.*>)?", 32);

    /* JADX WARN: Illegal instructions before constructor call */
    public r$a(String str, String str2, String str3, f<RC> fVar) {
        d0.z.d.m.checkNotNullParameter(str, "prefix");
        d0.z.d.m.checkNotNullParameter(str2, "decorator");
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
        Node[] nodeArr = new Node[3];
        nodeArr[0] = new StyleNode$b(str, fVar.d);
        nodeArr[1] = new StyleNode$b(str2, fVar.g);
        nodeArr[2] = str3 != null ? new StyleNode$b(str3, fVar.g) : null;
        super(nodeArr);
    }
}
