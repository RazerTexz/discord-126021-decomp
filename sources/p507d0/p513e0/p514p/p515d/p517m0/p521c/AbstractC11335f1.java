package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.f1 */
/* JADX INFO: compiled from: Visibility.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11335f1 {

    /* JADX INFO: renamed from: a */
    public final String f22712a;

    /* JADX INFO: renamed from: b */
    public final boolean f22713b;

    public AbstractC11335f1(String str, boolean z2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.f22712a = str;
        this.f22713b = z2;
    }

    public Integer compareTo(AbstractC11335f1 abstractC11335f1) {
        C12238m.checkNotNullParameter(abstractC11335f1, "visibility");
        return C11332e1.f22694a.compareLocal$compiler_common(this, abstractC11335f1);
    }

    public String getInternalDisplayName() {
        return this.f22712a;
    }

    public final boolean isPublicAPI() {
        return this.f22713b;
    }

    public AbstractC11335f1 normalize() {
        return this;
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
