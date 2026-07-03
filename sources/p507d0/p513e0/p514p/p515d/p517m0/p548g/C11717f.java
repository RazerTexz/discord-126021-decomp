package p507d0.p513e0.p514p.p515d.p517m0.p548g;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.text.Regex;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.g.f */
/* JADX INFO: compiled from: NameUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11717f {

    /* JADX INFO: renamed from: a */
    public static final Regex f24091a = new Regex("[^\\p{L}\\p{Digit}]");

    public static final String sanitizeAsJavaIdentifier(String str) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return f24091a.replace(str, "_");
    }
}
