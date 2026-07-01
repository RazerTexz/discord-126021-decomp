package b.i.a.f.e.k;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class b$d implements b$c {
    public final /* synthetic */ b a;

    public b$d(b bVar) {
        this.a = bVar;
    }

    @Override // b.i.a.f.e.k.b$c
    public final void a(@RecentlyNonNull ConnectionResult connectionResult) {
        if (connectionResult.x0()) {
            b bVar = this.a;
            bVar.b(null, bVar.v());
        } else {
            b$b b_b = this.a.q;
            if (b_b != null) {
                b_b.g(connectionResult);
            }
        }
    }
}
