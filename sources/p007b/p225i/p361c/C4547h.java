package p007b.p225i.p361c;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3307n;

/* JADX INFO: renamed from: b.i.c.h */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4547h implements InterfaceC3307n {
    @Override // p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3307n
    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public final Exception mo4055a(@RecentlyNonNull Status status) {
        return status.f20495p == 8 ? new FirebaseException(status.m9031x0()) : new FirebaseApiNotAvailableException(status.m9031x0());
    }
}
