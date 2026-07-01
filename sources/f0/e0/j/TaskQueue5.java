package f0.e0.j;

import f0.e0.f.Task2;
import java.io.IOException;
import java.util.List;

/* JADX INFO: renamed from: f0.e0.j.h, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue5 extends Task2 {
    public final /* synthetic */ Http2Connection e;
    public final /* synthetic */ int f;
    public final /* synthetic */ List g;
    public final /* synthetic */ boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue5(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, List list, boolean z4) {
        super(str2, z3);
        this.e = http2Connection;
        this.f = i;
        this.g = list;
        this.h = z4;
    }

    @Override // f0.e0.f.Task2
    public long a() {
        boolean zB = this.e.w.b(this.f, this.g, this.h);
        if (zB) {
            try {
                this.e.K.n(this.f, ErrorCode2.CANCEL);
            } catch (IOException unused) {
                return -1L;
            }
        }
        if (!zB && !this.h) {
            return -1L;
        }
        synchronized (this.e) {
            this.e.M.remove(Integer.valueOf(this.f));
        }
        return -1L;
    }
}
