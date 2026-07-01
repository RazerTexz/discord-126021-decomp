package f0.e0.j;

import f0.e0.f.Task2;

/* JADX INFO: renamed from: f0.e0.j.j, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue7 extends Task2 {
    public final /* synthetic */ Http2Connection e;
    public final /* synthetic */ int f;
    public final /* synthetic */ ErrorCode2 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue7(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, ErrorCode2 errorCode2) {
        super(str2, z3);
        this.e = http2Connection;
        this.f = i;
        this.g = errorCode2;
    }

    @Override // f0.e0.f.Task2
    public long a() {
        this.e.w.c(this.f, this.g);
        synchronized (this.e) {
            this.e.M.remove(Integer.valueOf(this.f));
        }
        return -1L;
    }
}
