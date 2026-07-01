package b.i.a.f.e.k;

import androidx.annotation.BinderThread;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends z {
    public final /* synthetic */ b g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @BinderThread
    public m0(b bVar, int i) {
        super(bVar, i, null);
        this.g = bVar;
    }

    @Override // b.i.a.f.e.k.z
    public final boolean d() {
        this.g.k.a(ConnectionResult.j);
        return true;
    }

    @Override // b.i.a.f.e.k.z
    public final void e(ConnectionResult connectionResult) {
        Objects.requireNonNull(this.g);
        this.g.k.a(connectionResult);
        Objects.requireNonNull(this.g);
        System.currentTimeMillis();
    }
}
