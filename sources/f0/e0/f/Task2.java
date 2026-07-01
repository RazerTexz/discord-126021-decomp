package f0.e0.f;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: f0.e0.f.a, reason: use source file name */
/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Task2 {
    public TaskQueue2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3609b;
    public final String c;
    public final boolean d;

    public Task2(String str, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.c = str;
        this.d = z2;
        this.f3609b = -1L;
    }

    public abstract long a();

    public String toString() {
        return this.c;
    }

    public /* synthetic */ Task2(String str, boolean z2, int i) {
        this(str, (i & 2) != 0 ? true : z2);
    }
}
