package b.i.c.r;

import android.content.Context;
import androidx.annotation.NonNull;
import b.i.c.l.r;

/* JADX INFO: compiled from: DefaultHeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements d {
    public b.i.c.t.a<e> a;

    public c(Context context) {
        this.a = new r(new a(context));
    }

    @Override // b.i.c.r.d
    @NonNull
    public d$a a(@NonNull String str) {
        boolean zA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zA2 = this.a.get().a(str, jCurrentTimeMillis);
        e eVar = this.a.get();
        synchronized (eVar) {
            zA = eVar.a("fire-global", jCurrentTimeMillis);
        }
        if (zA2 && zA) {
            return d$a.COMBINED;
        }
        if (zA) {
            return d$a.GLOBAL;
        }
        return zA2 ? d$a.SDK : d$a.NONE;
    }
}
