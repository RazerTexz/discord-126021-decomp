package b.i.c.j.a.c;

import android.os.Bundle;
import b.i.a.f.i.a.a;
import b.i.a.f.i.b.v5;
import b.i.c.m.CrashlyticsAnalyticsListener;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements a.InterfaceC0041a {
    public final /* synthetic */ b a;

    public e(b bVar) {
        this.a = bVar;
    }

    @Override // b.i.a.f.i.b.z5
    public final void a(String str, String str2, Bundle bundle, long j) {
        if (this.a.a.contains(str2)) {
            Bundle bundle2 = new Bundle();
            Set<String> set = c.a;
            String strY1 = b.i.a.f.e.o.f.Y1(str2, v5.c, v5.a);
            if (strY1 != null) {
                str2 = strY1;
            }
            bundle2.putString("events", str2);
            ((CrashlyticsAnalyticsListener) this.a.f1657b).a(2, bundle2);
        }
    }
}
