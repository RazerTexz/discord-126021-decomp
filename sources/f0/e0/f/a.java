package f0.e0.f;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3609b;
    public final String c;
    public final boolean d;

    public a(String str, boolean z2) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.c = str;
        this.d = z2;
        this.f3609b = -1L;
    }

    public abstract long a();

    public String toString() {
        return this.c;
    }

    public /* synthetic */ a(String str, boolean z2, int i) {
        this(str, (i & 2) != 0 ? true : z2);
    }
}
