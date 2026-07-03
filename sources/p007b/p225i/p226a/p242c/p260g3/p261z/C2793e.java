package p007b.p225i.p226a.p242c.p260g3.p261z;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;
import p007b.p225i.p226a.p242c.AbstractC2951v0;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2757x;

/* JADX INFO: renamed from: b.i.a.c.g3.z.e */
/* JADX INFO: compiled from: CameraMotionRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2793e extends AbstractC2951v0 {

    /* JADX INFO: renamed from: u */
    public final DecoderInputBuffer f6963u;

    /* JADX INFO: renamed from: v */
    public final C2757x f6964v;

    /* JADX INFO: renamed from: w */
    public long f6965w;

    /* JADX INFO: renamed from: x */
    @Nullable
    public InterfaceC2792d f6966x;

    /* JADX INFO: renamed from: y */
    public long f6967y;

    public C2793e() {
        super(6);
        this.f6963u = new DecoderInputBuffer(1);
        this.f6964v = new C2757x();
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: B */
    public void mo2621B() {
        InterfaceC2792d interfaceC2792d = this.f6966x;
        if (interfaceC2792d != null) {
            interfaceC2792d.mo3197c();
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: D */
    public void mo2622D(long j, boolean z2) {
        this.f6967y = Long.MIN_VALUE;
        InterfaceC2792d interfaceC2792d = this.f6966x;
        if (interfaceC2792d != null) {
            interfaceC2792d.mo3197c();
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: H */
    public void mo2623H(C2811j1[] c2811j1Arr, long j, long j2) {
        this.f6965w = j2;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2763g2
    /* JADX INFO: renamed from: a */
    public int mo2630a(C2811j1 c2811j1) {
        return "application/x-camera-motion".equals(c2811j1.f7155w) ? 4 : 0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: b */
    public boolean mo2631b() {
        return mo2935j();
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: d */
    public boolean mo2632d() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2, p007b.p225i.p226a.p242c.InterfaceC2763g2
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: q */
    public void mo2633q(long j, long j2) {
        float[] fArr;
        while (!mo2935j() && this.f6967y < 100000 + j) {
            this.f6963u.mo3856p();
            if (m3548I(m3547A(), this.f6963u, 0) != -4 || this.f6963u.m3555n()) {
                return;
            }
            DecoderInputBuffer decoderInputBuffer = this.f6963u;
            this.f6967y = decoderInputBuffer.f19780n;
            if (this.f6966x != null && !decoderInputBuffer.m3554m()) {
                this.f6963u.m8813s();
                ByteBuffer byteBuffer = this.f6963u.f19778l;
                int i = C2738e0.f6708a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    this.f6964v.m3077C(byteBuffer.array(), byteBuffer.limit());
                    this.f6964v.m3079E(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i2 = 0; i2 < 3; i2++) {
                        fArr2[i2] = Float.intBitsToFloat(this.f6964v.m3088h());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.f6966x.mo3196a(this.f6967y - this.f6965w, fArr);
                }
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0, p007b.p225i.p226a.p242c.C2576b2.b
    /* JADX INFO: renamed from: r */
    public void mo2603r(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 8) {
            this.f6966x = (InterfaceC2792d) obj;
        }
    }
}
