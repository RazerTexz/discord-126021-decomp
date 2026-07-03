package p007b.p225i.p361c.p362j.p363a.p364c;

import android.os.Bundle;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p225i.p226a.p288f.p330i.p331a.C3967a;
import p007b.p225i.p361c.p369m.C4588a;

/* JADX INFO: renamed from: b.i.c.j.a.c.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4556f implements C3967a.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4554d f12159a;

    public C4556f(C4554d c4554d) {
        this.f12159a = c4554d;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5
    /* JADX INFO: renamed from: a */
    public final void mo5979a(String str, String str2, Bundle bundle, long j) {
        if (str == null || str.equals("crash") || !(!C4553c.f12149a.contains(str2))) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(ModelAuditLogEntry.CHANGE_KEY_NAME, str2);
        bundle2.putLong("timestampInMillis", j);
        bundle2.putBundle("params", bundle);
        ((C4588a) this.f12159a.f12155a).m6361a(3, bundle2);
    }
}
