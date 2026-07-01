package b.i.a.f.h.o;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafetyNetApi$a;
import com.google.android.gms.safetynet.zzf;

/* JADX INFO: loaded from: classes3.dex */
public class i$b implements SafetyNetApi$a {
    public final Status j;
    public final zzf k;

    public i$b(Status status, zzf zzfVar) {
        this.j = status;
        this.k = zzfVar;
    }

    @Override // com.google.android.gms.safetynet.SafetyNetApi$a
    public final String C() {
        zzf zzfVar = this.k;
        if (zzfVar == null) {
            return null;
        }
        return zzfVar.j;
    }

    @Override // b.i.a.f.e.h.h
    public final Status b0() {
        return this.j;
    }
}
