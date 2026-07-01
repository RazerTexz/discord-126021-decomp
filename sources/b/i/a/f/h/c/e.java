package b.i.a.f.h.c;

import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements b.i.a.f.c.a.d.b {
    public final Status j;

    @Nullable
    public final Credential k;

    public e(Status status, @Nullable Credential credential) {
        this.j = status;
        this.k = credential;
    }

    @Override // b.i.a.f.c.a.d.b
    @Nullable
    public final Credential R() {
        return this.k;
    }

    @Override // b.i.a.f.e.h.h
    public final Status b0() {
        return this.j;
    }
}
