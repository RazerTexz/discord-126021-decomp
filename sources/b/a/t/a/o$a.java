package b.a.t.a;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.simpleast.core.node.Node$a;
import com.discord.simpleast.core.node.StyleNode$b;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Kotlin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class o$a<RC> extends Node$a<RC> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o$a$a f299b = new o$a$a(null);
    public static final Pattern a = Pattern.compile("^(val|var)(\\s+\\w+)", 32);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o$a(String str, String str2, f<RC> fVar) {
        super(new StyleNode$b(str, fVar.d), new StyleNode$b(str2, fVar.e));
        d0.z.d.m.checkNotNullParameter(str, "definition");
        d0.z.d.m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(fVar, "codeStyleProviders");
    }
}
