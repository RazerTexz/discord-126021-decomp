package f0.e0.j;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$e extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ a g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$e(String str, boolean z2, String str2, boolean z3, e eVar, int i, a aVar) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = aVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        try {
            e eVar = this.e;
            int i = this.f;
            a aVar = this.g;
            Objects.requireNonNull(eVar);
            d0.z.d.m.checkParameterIsNotNull(aVar, "statusCode");
            eVar.K.n(i, aVar);
            return -1L;
        } catch (IOException e) {
            e eVar2 = this.e;
            a aVar2 = a.PROTOCOL_ERROR;
            eVar2.a(aVar2, aVar2, e);
            return -1L;
        }
    }
}
