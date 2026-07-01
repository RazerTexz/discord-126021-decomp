package f0.e0.j;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ long f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(String str, String str2, e eVar, long j) {
        super(str2, true);
        this.e = eVar;
        this.f = j;
    }

    @Override // f0.e0.f.a
    public long a() {
        e eVar;
        boolean z2;
        synchronized (this.e) {
            eVar = this.e;
            long j = eVar.f3640y;
            long j2 = eVar.f3639x;
            if (j < j2) {
                z2 = true;
            } else {
                eVar.f3639x = j2 + 1;
                z2 = false;
            }
        }
        if (!z2) {
            eVar.q(false, 1, 0);
            return this.f;
        }
        a aVar = a.PROTOCOL_ERROR;
        eVar.a(aVar, aVar, null);
        return -1L;
    }
}
