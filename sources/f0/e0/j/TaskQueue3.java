package f0.e0.j;

import f0.e0.f.Task2;
import f0.e0.j.Http2Connection;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: renamed from: f0.e0.j.f, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue3 extends Task2 {
    public final /* synthetic */ Http2Connection.d e;
    public final /* synthetic */ Ref$ObjectRef f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue3(String str, boolean z2, String str2, boolean z3, Http2Connection.d dVar, boolean z4, Ref$ObjectRef ref$ObjectRef, Settings3 settings3, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
        super(str2, z3);
        this.e = dVar;
        this.f = ref$ObjectRef;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f0.e0.f.Task2
    public long a() {
        Http2Connection http2Connection = this.e.k;
        http2Connection.m.a(http2Connection, (Settings3) this.f.element);
        return -1L;
    }
}
