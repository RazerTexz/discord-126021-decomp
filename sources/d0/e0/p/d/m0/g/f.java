package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import kotlin.text.Regex;

/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final Regex a = new Regex("[^\\p{L}\\p{Digit}]");

    public static final String sanitizeAsJavaIdentifier(String str) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return a.replace(str, "_");
    }
}
