package b.i.c;

import androidx.annotation.RecentlyNonNull;
import b.i.a.f.e.h.j.n;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class h implements n {
    @Override // b.i.a.f.e.h.j.n
    @RecentlyNonNull
    public final Exception a(@RecentlyNonNull Status status) {
        return status.p == 8 ? new FirebaseException(status.x0()) : new FirebaseApiNotAvailableException(status.x0());
    }
}
