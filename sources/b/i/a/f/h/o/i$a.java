package b.i.a.f.h.o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi$a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i$a extends d<SafetyNetApi$a> {
    public e l;

    public i$a(b.i.a.f.e.h.c cVar) {
        super(cVar);
        this.l = new k(this);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ b.i.a.f.e.h.h d(Status status) {
        return new i$b(status, null);
    }
}
