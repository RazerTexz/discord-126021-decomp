package b.o.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.o.a.n.Camera1Engine2;
import b.o.a.n.t.Angles;
import b.o.a.x.Size3;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: b.o.a.p.a, reason: use source file name */
/* JADX INFO: compiled from: ByteBufferFrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferFrameManager extends FrameManager<byte[]> {
    public LinkedBlockingQueue<byte[]> i;
    public a j;
    public final int k;

    /* JADX INFO: renamed from: b.o.a.p.a$a */
    /* JADX INFO: compiled from: ByteBufferFrameManager.java */
    public interface a {
    }

    public ByteBufferFrameManager(int i, @Nullable a aVar) {
        super(i, byte[].class);
        this.j = aVar;
        this.k = 0;
    }

    @Override // b.o.a.p.FrameManager
    public void c(@NonNull byte[] bArr, boolean z2) {
        byte[] bArr2 = bArr;
        if (z2 && bArr2.length == this.c) {
            if (this.k == 0) {
                ((Camera1Engine2) this.j).m1(bArr2);
            } else {
                this.i.offer(bArr2);
            }
        }
    }

    @Override // b.o.a.p.FrameManager
    public void d() {
        super.d();
        if (this.k == 1) {
            this.i.clear();
        }
    }

    @Override // b.o.a.p.FrameManager
    public void e(int i, @NonNull Size3 size3, @NonNull Angles angles) {
        super.e(i, size3, angles);
        int i2 = this.c;
        for (int i3 = 0; i3 < this.f1946b; i3++) {
            if (this.k == 0) {
                ((Camera1Engine2) this.j).m1(new byte[i2]);
            } else {
                this.i.offer(new byte[i2]);
            }
        }
    }
}
