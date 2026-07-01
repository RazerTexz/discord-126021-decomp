package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: TypeScript.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r$b<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r$b$a f303b = new r$b$a(null);
    public static final Pattern a = Pattern.compile("^(var|let|const)(\\s+[a-zA-Z_$][a-zA-Z0-9_$]*)");

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r$b(String str, String str2, f<RC> fVar) {
        super(new StyleNode$b(str, fVar.d), new StyleNode$b(str2, fVar.e));
        d0.z.d.m.checkNotNullParameter(str, "definition");
        d0.z.d.m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
    }
}
