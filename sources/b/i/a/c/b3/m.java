package b.i.a.c.b3;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.q;
import b.i.a.c.f3.t;
import b.i.a.c.j1;
import b.i.a.c.k1;
import b.i.a.c.v0;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: TextRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends v0 implements Handler$Callback {
    public boolean A;
    public int B;

    @Nullable
    public j1 C;

    @Nullable
    public h D;

    @Nullable
    public j E;

    @Nullable
    public k F;

    @Nullable
    public k G;
    public int H;
    public long I;

    @Nullable
    public final Handler u;
    public final l v;
    public final i w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final k1 f844x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f845y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f846z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(l lVar, @Nullable Looper looper) {
        Handler handler;
        super(3);
        i iVar = i.a;
        Objects.requireNonNull(lVar);
        this.v = lVar;
        if (looper == null) {
            handler = null;
        } else {
            int i = e0.a;
            handler = new Handler(looper, this);
        }
        this.u = handler;
        this.w = iVar;
        this.f844x = new k1();
        this.I = -9223372036854775807L;
    }

    @Override // b.i.a.c.v0
    public void B() {
        this.C = null;
        this.I = -9223372036854775807L;
        J();
        N();
        h hVar = this.D;
        Objects.requireNonNull(hVar);
        hVar.release();
        this.D = null;
        this.B = 0;
    }

    @Override // b.i.a.c.v0
    public void D(long j, boolean z2) {
        J();
        this.f845y = false;
        this.f846z = false;
        this.I = -9223372036854775807L;
        if (this.B != 0) {
            O();
            return;
        }
        N();
        h hVar = this.D;
        Objects.requireNonNull(hVar);
        hVar.flush();
    }

    @Override // b.i.a.c.v0
    public void H(j1[] j1VarArr, long j, long j2) {
        this.C = j1VarArr[0];
        if (this.D != null) {
            this.B = 1;
        } else {
            M();
        }
    }

    public final void J() {
        List<b> listEmptyList = Collections.emptyList();
        Handler handler = this.u;
        if (handler != null) {
            handler.obtainMessage(0, listEmptyList).sendToTarget();
        } else {
            this.v.e(listEmptyList);
        }
    }

    public final long K() {
        if (this.H == -1) {
            return RecyclerView.FOREVER_NS;
        }
        Objects.requireNonNull(this.F);
        int i = this.H;
        g gVar = this.F.l;
        Objects.requireNonNull(gVar);
        if (i >= gVar.i()) {
            return RecyclerView.FOREVER_NS;
        }
        k kVar = this.F;
        int i2 = this.H;
        g gVar2 = kVar.l;
        Objects.requireNonNull(gVar2);
        return gVar2.g(i2) + kVar.m;
    }

    public final void L(SubtitleDecoderException subtitleDecoderException) {
        String strValueOf = String.valueOf(this.C);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(strValueOf);
        q.b("TextRenderer", sb.toString(), subtitleDecoderException);
        J();
        O();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    public final void M() {
        h aVar;
        byte b2 = 1;
        this.A = true;
        i iVar = this.w;
        j1 j1Var = this.C;
        Objects.requireNonNull(j1Var);
        Objects.requireNonNull((i$a) iVar);
        String str = j1Var.w;
        if (str != null) {
            switch (str.hashCode()) {
                case -1351681404:
                    if (!str.equals("application/dvbsubs")) {
                        b2 = -1;
                    } else {
                        b2 = 0;
                    }
                    break;
                case -1248334819:
                    if (!str.equals("application/pgs")) {
                        b2 = -1;
                    }
                    break;
                case -1026075066:
                    if (!str.equals("application/x-mp4-vtt")) {
                        b2 = -1;
                    } else {
                        b2 = 2;
                    }
                    break;
                case -1004728940:
                    if (!str.equals("text/vtt")) {
                        b2 = -1;
                    } else {
                        b2 = 3;
                    }
                    break;
                case 691401887:
                    if (!str.equals("application/x-quicktime-tx3g")) {
                        b2 = -1;
                    } else {
                        b2 = 4;
                    }
                    break;
                case 822864842:
                    if (!str.equals("text/x-ssa")) {
                        b2 = -1;
                    } else {
                        b2 = 5;
                    }
                    break;
                case 930165504:
                    if (!str.equals("application/x-mp4-cea-608")) {
                        b2 = -1;
                    } else {
                        b2 = 6;
                    }
                    break;
                case 1201784583:
                    if (!str.equals("text/x-exoplayer-cues")) {
                        b2 = -1;
                    } else {
                        b2 = 7;
                    }
                    break;
                case 1566015601:
                    if (!str.equals("application/cea-608")) {
                        b2 = -1;
                    } else {
                        b2 = 8;
                    }
                    break;
                case 1566016562:
                    if (!str.equals("application/cea-708")) {
                        b2 = -1;
                    } else {
                        b2 = 9;
                    }
                    break;
                case 1668750253:
                    if (!str.equals("application/x-subrip")) {
                        b2 = -1;
                    } else {
                        b2 = 10;
                    }
                    break;
                case 1693976202:
                    if (!str.equals("application/ttml+xml")) {
                        b2 = -1;
                    } else {
                        b2 = 11;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    aVar = new b.i.a.c.b3.o.a(j1Var.f1019y);
                    break;
                case 1:
                    aVar = new b.i.a.c.b3.p.a();
                    break;
                case 2:
                    aVar = new b.i.a.c.b3.v.c();
                    break;
                case 3:
                    aVar = new b.i.a.c.b3.v.i();
                    break;
                case 4:
                    aVar = new b.i.a.c.b3.u.a(j1Var.f1019y);
                    break;
                case 5:
                    aVar = new b.i.a.c.b3.r.a(j1Var.f1019y);
                    break;
                case 6:
                case 8:
                    aVar = new b.i.a.c.b3.n.c(str, j1Var.O, 16000L);
                    break;
                case 7:
                    aVar = new d();
                    break;
                case 9:
                    aVar = new b.i.a.c.b3.n.d(j1Var.O, j1Var.f1019y);
                    break;
                case 10:
                    aVar = new b.i.a.c.b3.s.a();
                    break;
                case 11:
                    aVar = new b.i.a.c.b3.t.c();
                    break;
            }
            this.D = aVar;
            return;
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
    }

    public final void N() {
        this.E = null;
        this.H = -1;
        k kVar = this.F;
        if (kVar != null) {
            kVar.p();
            this.F = null;
        }
        k kVar2 = this.G;
        if (kVar2 != null) {
            kVar2.p();
            this.G = null;
        }
    }

    public final void O() {
        N();
        h hVar = this.D;
        Objects.requireNonNull(hVar);
        hVar.release();
        this.D = null;
        this.B = 0;
        M();
    }

    @Override // b.i.a.c.g2
    public int a(j1 j1Var) {
        Objects.requireNonNull((i$a) this.w);
        String str = j1Var.w;
        if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str)) {
            return (j1Var.P == 0 ? 4 : 2) | 0 | 0;
        }
        return t.i(j1Var.w) ? 1 : 0;
    }

    @Override // b.i.a.c.f2
    public boolean b() {
        return this.f846z;
    }

    @Override // b.i.a.c.f2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.f2, b.i.a.c.g2
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.v.e((List) message.obj);
        return true;
    }

    @Override // b.i.a.c.f2
    public void q(long j, long j2) throws DecoderException {
        boolean z2;
        if (this.f1140s) {
            long j3 = this.I;
            if (j3 != -9223372036854775807L && j >= j3) {
                N();
                this.f846z = true;
            }
        }
        if (this.f846z) {
            return;
        }
        if (this.G == null) {
            h hVar = this.D;
            Objects.requireNonNull(hVar);
            hVar.a(j);
            try {
                h hVar2 = this.D;
                Objects.requireNonNull(hVar2);
                this.G = hVar2.b();
            } catch (SubtitleDecoderException e) {
                L(e);
                return;
            }
        }
        if (this.n != 2) {
            return;
        }
        if (this.F != null) {
            long jK = K();
            z2 = false;
            while (jK <= j) {
                this.H++;
                jK = K();
                z2 = true;
            }
        } else {
            z2 = false;
        }
        k kVar = this.G;
        if (kVar != null) {
            if (kVar.n()) {
                if (!z2 && K() == RecyclerView.FOREVER_NS) {
                    if (this.B == 2) {
                        O();
                    } else {
                        N();
                        this.f846z = true;
                    }
                }
            } else if (kVar.k <= j) {
                k kVar2 = this.F;
                if (kVar2 != null) {
                    kVar2.p();
                }
                g gVar = kVar.l;
                Objects.requireNonNull(gVar);
                this.H = gVar.f(j - kVar.m);
                this.F = kVar;
                this.G = null;
                z2 = true;
            }
        }
        if (z2) {
            Objects.requireNonNull(this.F);
            k kVar3 = this.F;
            g gVar2 = kVar3.l;
            Objects.requireNonNull(gVar2);
            List<b> listH = gVar2.h(j - kVar3.m);
            Handler handler = this.u;
            if (handler != null) {
                handler.obtainMessage(0, listH).sendToTarget();
            } else {
                this.v.e(listH);
            }
        }
        if (this.B == 2) {
            return;
        }
        while (!this.f845y) {
            try {
                j jVarC = this.E;
                if (jVarC == null) {
                    h hVar3 = this.D;
                    Objects.requireNonNull(hVar3);
                    jVarC = hVar3.c();
                    if (jVarC == null) {
                        return;
                    } else {
                        this.E = jVarC;
                    }
                }
                if (this.B == 1) {
                    jVarC.j = 4;
                    h hVar4 = this.D;
                    Objects.requireNonNull(hVar4);
                    hVar4.d(jVarC);
                    this.E = null;
                    this.B = 2;
                    return;
                }
                int I = I(this.f844x, jVarC, 0);
                if (I == -4) {
                    if (jVarC.n()) {
                        this.f845y = true;
                        this.A = false;
                    } else {
                        j1 j1Var = this.f844x.f1027b;
                        if (j1Var == null) {
                            return;
                        }
                        jVarC.r = j1Var.A;
                        jVarC.s();
                        this.A &= !jVarC.o();
                    }
                    if (!this.A) {
                        h hVar5 = this.D;
                        Objects.requireNonNull(hVar5);
                        hVar5.d(jVarC);
                        this.E = null;
                    }
                } else if (I == -3) {
                    return;
                }
            } catch (SubtitleDecoderException e2) {
                L(e2);
                return;
            }
        }
    }
}
