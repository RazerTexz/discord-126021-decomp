package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: Visibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f1 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3247b;

    public f1(String str, boolean z2) {
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.a = str;
        this.f3247b = z2;
    }

    public Integer compareTo(f1 f1Var) {
        d0.z.d.m.checkNotNullParameter(f1Var, "visibility");
        return e1.a.compareLocal$compiler_common(this, f1Var);
    }

    public String getInternalDisplayName() {
        return this.a;
    }

    public final boolean isPublicAPI() {
        return this.f3247b;
    }

    public f1 normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
