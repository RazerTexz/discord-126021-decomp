package p007b.p225i.p226a.p242c.p279z2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p225i.p226a.p242c.AbstractC2951v0;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.z2.f */
/* JADX INFO: compiled from: MetadataRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3160f extends AbstractC2951v0 implements Handler.Callback {

    /* JADX INFO: renamed from: A */
    public boolean f9138A;

    /* JADX INFO: renamed from: B */
    public long f9139B;

    /* JADX INFO: renamed from: C */
    public long f9140C;

    /* JADX INFO: renamed from: D */
    @Nullable
    public Metadata f9141D;

    /* JADX INFO: renamed from: u */
    public final InterfaceC3157c f9142u;

    /* JADX INFO: renamed from: v */
    public final InterfaceC3159e f9143v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public final Handler f9144w;

    /* JADX INFO: renamed from: x */
    public final C3158d f9145x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public InterfaceC3156b f9146y;

    /* JADX INFO: renamed from: z */
    public boolean f9147z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3160f(InterfaceC3159e interfaceC3159e, @Nullable Looper looper) {
        Handler handler;
        super(5);
        InterfaceC3157c interfaceC3157c = InterfaceC3157c.f9136a;
        Objects.requireNonNull(interfaceC3159e);
        this.f9143v = interfaceC3159e;
        if (looper == null) {
            handler = null;
        } else {
            int i = C2738e0.f6708a;
            handler = new Handler(looper, this);
        }
        this.f9144w = handler;
        this.f9142u = interfaceC3157c;
        this.f9145x = new C3158d();
        this.f9140C = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: B */
    public void mo2621B() {
        this.f9141D = null;
        this.f9140C = -9223372036854775807L;
        this.f9146y = null;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: D */
    public void mo2622D(long j, boolean z2) {
        this.f9141D = null;
        this.f9140C = -9223372036854775807L;
        this.f9147z = false;
        this.f9138A = false;
    }

    @Override // p007b.p225i.p226a.p242c.AbstractC2951v0
    /* JADX INFO: renamed from: H */
    public void mo2623H(C2811j1[] c2811j1Arr, long j, long j2) {
        this.f9146y = this.f9142u.mo3897b(c2811j1Arr[0]);
    }

    /* JADX INFO: renamed from: J */
    public final void m3898J(Metadata metadata, List<Metadata.Entry> list) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.f19936j;
            if (i >= entryArr.length) {
                return;
            }
            C2811j1 c2811j1Mo8880y = entryArr[i].mo8880y();
            if (c2811j1Mo8880y == null || !this.f9142u.mo3896a(c2811j1Mo8880y)) {
                list.add(metadata.f19936j[i]);
            } else {
                InterfaceC3156b interfaceC3156bMo3897b = this.f9142u.mo3897b(c2811j1Mo8880y);
                byte[] bArrMo8879o0 = metadata.f19936j[i].mo8879o0();
                Objects.requireNonNull(bArrMo8879o0);
                this.f9145x.mo3856p();
                this.f9145x.m8812r(bArrMo8879o0.length);
                ByteBuffer byteBuffer = this.f9145x.f19778l;
                int i2 = C2738e0.f6708a;
                byteBuffer.put(bArrMo8879o0);
                this.f9145x.m8813s();
                Metadata metadataMo3895a = interfaceC3156bMo3897b.mo3895a(this.f9145x);
                if (metadataMo3895a != null) {
                    m3898J(metadataMo3895a, list);
                }
            }
            i++;
        }
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2763g2
    /* JADX INFO: renamed from: a */
    public int mo2630a(C2811j1 c2811j1) {
        if (this.f9142u.mo3896a(c2811j1)) {
            return (c2811j1.f7142P == 0 ? 4 : 2) | 0 | 0;
        }
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: b */
    public boolean mo2631b() {
        return this.f9138A;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: d */
    public boolean mo2632d() {
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2, p007b.p225i.p226a.p242c.InterfaceC2763g2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.f9143v.mo3298b((Metadata) message.obj);
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2728f2
    /* JADX INFO: renamed from: q */
    public void mo2633q(long j, long j2) {
        boolean z2 = true;
        while (z2) {
            if (!this.f9147z && this.f9141D == null) {
                this.f9145x.mo3856p();
                C2815k1 c2815k1M3547A = m3547A();
                int iM3548I = m3548I(c2815k1M3547A, this.f9145x, 0);
                if (iM3548I == -4) {
                    if (this.f9145x.m3555n()) {
                        this.f9147z = true;
                    } else {
                        C3158d c3158d = this.f9145x;
                        c3158d.f9137r = this.f9139B;
                        c3158d.m8813s();
                        InterfaceC3156b interfaceC3156b = this.f9146y;
                        int i = C2738e0.f6708a;
                        Metadata metadataMo3895a = interfaceC3156b.mo3895a(this.f9145x);
                        if (metadataMo3895a != null) {
                            ArrayList arrayList = new ArrayList(metadataMo3895a.f19936j.length);
                            m3898J(metadataMo3895a, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.f9141D = new Metadata(arrayList);
                                this.f9140C = this.f9145x.f19780n;
                            }
                        }
                    }
                } else if (iM3548I == -5) {
                    C2811j1 c2811j1 = c2815k1M3547A.f7196b;
                    Objects.requireNonNull(c2811j1);
                    this.f9139B = c2811j1.f7127A;
                }
            }
            Metadata metadata = this.f9141D;
            if (metadata == null || this.f9140C > j) {
                z2 = false;
            } else {
                Handler handler = this.f9144w;
                if (handler != null) {
                    handler.obtainMessage(0, metadata).sendToTarget();
                } else {
                    this.f9143v.mo3298b(metadata);
                }
                this.f9141D = null;
                this.f9140C = -9223372036854775807L;
                z2 = true;
            }
            if (this.f9147z && this.f9141D == null) {
                this.f9138A = true;
            }
        }
    }
}
