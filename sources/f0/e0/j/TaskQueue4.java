package f0.e0.j;

import f0.e0.f.Task2;
import g0.Buffer3;
import java.io.IOException;

/* JADX INFO: renamed from: f0.e0.j.g, reason: use source file name */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TaskQueue4 extends Task2 {
    public final /* synthetic */ Http2Connection e;
    public final /* synthetic */ int f;
    public final /* synthetic */ Buffer3 g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue4(String str, boolean z2, String str2, boolean z3, Http2Connection http2Connection, int i, Buffer3 buffer3, int i2, boolean z4) {
        super(str2, z3);
        this.e = http2Connection;
        this.f = i;
        this.g = buffer3;
        this.h = i2;
        this.i = z4;
    }

    @Override // f0.e0.f.Task2
    public long a() {
        try {
            boolean zD = this.e.w.d(this.f, this.g, this.h, this.i);
            if (zD) {
                this.e.K.n(this.f, ErrorCode2.CANCEL);
            }
            if (!zD && !this.i) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.M.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
