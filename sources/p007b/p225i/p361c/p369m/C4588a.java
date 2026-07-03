package p007b.p225i.p361c.p369m;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p007b.p225i.p361c.p369m.p370d.p371i.InterfaceC4600b;

/* JADX INFO: renamed from: b.i.c.m.a */
/* JADX INFO: compiled from: CrashlyticsAnalyticsListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4588a implements InterfaceC4549a.b {

    /* JADX INFO: renamed from: a */
    public InterfaceC4600b f12219a;

    /* JADX INFO: renamed from: b */
    public InterfaceC4600b f12220b;

    /* JADX INFO: renamed from: a */
    public void m6361a(int i, @Nullable Bundle bundle) {
        C4592b.f12227a.m6371b("Received Analytics message: " + i + " " + bundle);
        String string = bundle.getString(ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (string != null) {
            Bundle bundle2 = bundle.getBundle("params");
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            InterfaceC4600b interfaceC4600b = "clx".equals(bundle2.getString("_o")) ? this.f12219a : this.f12220b;
            if (interfaceC4600b == null) {
                return;
            }
            interfaceC4600b.mo6387b(string, bundle2);
        }
    }
}
