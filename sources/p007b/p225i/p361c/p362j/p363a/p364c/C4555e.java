package p007b.p225i.p361c.p362j.p363a.p364c;

import android.os.Bundle;
import java.util.Set;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p330i.p331a.C3967a;
import p007b.p225i.p226a.p288f.p330i.p332b.C4214v5;
import p007b.p225i.p361c.p369m.C4588a;

/* JADX INFO: renamed from: b.i.c.j.a.c.e */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4555e implements C3967a.a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4552b f12158a;

    public C4555e(C4552b c4552b) {
        this.f12158a = c4552b;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4258z5
    /* JADX INFO: renamed from: a */
    public final void mo5979a(String str, String str2, Bundle bundle, long j) {
        if (this.f12158a.f12145a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            Set<String> set = C4553c.f12149a;
            String strM4263Y1 = C3404f.m4263Y1(str2, C4214v5.f11306c, C4214v5.f11304a);
            if (strM4263Y1 != null) {
                str2 = strM4263Y1;
            }
            bundle2.putString("events", str2);
            ((C4588a) this.f12158a.f12146b).m6361a(2, bundle2);
        }
    }
}
