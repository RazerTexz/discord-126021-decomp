package p007b.p452o.p453a.p465p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.LinkedBlockingQueue;
import p007b.p452o.p453a.p455n.C5128b;
import p007b.p452o.p453a.p455n.p461t.C5170a;
import p007b.p452o.p453a.p473x.C5236b;

/* JADX INFO: renamed from: b.o.a.p.a */
/* JADX INFO: compiled from: ByteBufferFrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5188a extends AbstractC5190c<byte[]> {

    /* JADX INFO: renamed from: i */
    public LinkedBlockingQueue<byte[]> f14050i;

    /* JADX INFO: renamed from: j */
    public a f14051j;

    /* JADX INFO: renamed from: k */
    public final int f14052k;

    /* JADX INFO: renamed from: b.o.a.p.a$a */
    /* JADX INFO: compiled from: ByteBufferFrameManager.java */
    public interface a {
    }

    public C5188a(int i, @Nullable a aVar) {
        super(i, byte[].class);
        this.f14051j = aVar;
        this.f14052k = 0;
    }

    @Override // p007b.p452o.p453a.p465p.AbstractC5190c
    /* JADX INFO: renamed from: c */
    public void mo7380c(@NonNull byte[] bArr, boolean z2) {
        byte[] bArr2 = bArr;
        if (z2 && bArr2.length == this.f14060c) {
            if (this.f14052k == 0) {
                ((C5128b) this.f14051j).m7222m1(bArr2);
            } else {
                this.f14050i.offer(bArr2);
            }
        }
    }

    @Override // p007b.p452o.p453a.p465p.AbstractC5190c
    /* JADX INFO: renamed from: d */
    public void mo7381d() {
        super.mo7381d();
        if (this.f14052k == 1) {
            this.f14050i.clear();
        }
    }

    @Override // p007b.p452o.p453a.p465p.AbstractC5190c
    /* JADX INFO: renamed from: e */
    public void mo7382e(int i, @NonNull C5236b c5236b, @NonNull C5170a c5170a) {
        super.mo7382e(i, c5236b, c5170a);
        int i2 = this.f14060c;
        for (int i3 = 0; i3 < this.f14059b; i3++) {
            if (this.f14052k == 0) {
                ((C5128b) this.f14051j).m7222m1(new byte[i2]);
            } else {
                this.f14050i.offer(new byte[i2]);
            }
        }
    }
}
