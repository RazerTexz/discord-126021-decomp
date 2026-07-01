package d0.e0.p.d.m0.g;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.text.Regex;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.f, reason: use source file name */
/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NameUtils {
    public static final Regex a = new Regex("[^\\p{L}\\p{Digit}]");

    public static final String sanitizeAsJavaIdentifier(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return a.replace(str, "_");
    }
}
