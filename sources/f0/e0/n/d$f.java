package f0.e0.n;

import d0.z.d.m;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okio.ByteString;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$f extends f0.e0.f.a {
    public final /* synthetic */ d e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$f(String str, boolean z2, String str2, boolean z3, d dVar, i iVar, ByteString byteString, Ref$ObjectRef ref$ObjectRef, Ref$IntRef ref$IntRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, Ref$ObjectRef ref$ObjectRef4, Ref$ObjectRef ref$ObjectRef5) {
        super(str2, z3);
        this.e = dVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        f0.e eVar = this.e.c;
        if (eVar == null) {
            m.throwNpe();
        }
        eVar.cancel();
        return -1L;
    }
}
