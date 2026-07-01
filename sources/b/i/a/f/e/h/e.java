package b.i.a.f.e.h;

import b.i.a.f.e.h.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class e<R extends h> extends BasePendingResult<R> {
    public final R l;

    public e(c cVar, R r) {
        super(cVar);
        this.l = r;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R d(Status status) {
        return this.l;
    }
}
