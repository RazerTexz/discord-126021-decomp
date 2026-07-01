package b.i.a.c.z2;

import android.os.Handler;
import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import b.i.a.c.j1;
import b.i.a.c.k1;
import b.i.a.c.v0;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: MetadataRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends v0 implements Handler$Callback {
    public boolean A;
    public long B;
    public long C;

    @Nullable
    public Metadata D;
    public final c u;
    public final e v;

    @Nullable
    public final Handler w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f1319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public b f1320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1321z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e eVar, @Nullable Looper looper) {
        Handler handler;
        super(5);
        c cVar = c.a;
        Objects.requireNonNull(eVar);
        this.v = eVar;
        if (looper == null) {
            handler = null;
        } else {
            int i = e0.a;
            handler = new Handler(looper, this);
        }
        this.w = handler;
        this.u = cVar;
        this.f1319x = new d();
        this.C = -9223372036854775807L;
    }

    @Override // b.i.a.c.v0
    public void B() {
        this.D = null;
        this.C = -9223372036854775807L;
        this.f1320y = null;
    }

    @Override // b.i.a.c.v0
    public void D(long j, boolean z2) {
        this.D = null;
        this.C = -9223372036854775807L;
        this.f1321z = false;
        this.A = false;
    }

    @Override // b.i.a.c.v0
    public void H(j1[] j1VarArr, long j, long j2) {
        this.f1320y = this.u.b(j1VarArr[0]);
    }

    public final void J(Metadata metadata, List<Metadata$Entry> list) {
        int i = 0;
        while (true) {
            Metadata$Entry[] metadata$EntryArr = metadata.j;
            if (i >= metadata$EntryArr.length) {
                return;
            }
            j1 j1VarY = metadata$EntryArr[i].y();
            if (j1VarY == null || !this.u.a(j1VarY)) {
                list.add(metadata.j[i]);
            } else {
                b bVarB = this.u.b(j1VarY);
                byte[] bArrO0 = metadata.j[i].o0();
                Objects.requireNonNull(bArrO0);
                this.f1319x.p();
                this.f1319x.r(bArrO0.length);
                ByteBuffer byteBuffer = this.f1319x.l;
                int i2 = e0.a;
                byteBuffer.put(bArrO0);
                this.f1319x.s();
                Metadata metadataA = bVarB.a(this.f1319x);
                if (metadataA != null) {
                    J(metadataA, list);
                }
            }
            i++;
        }
    }

    @Override // b.i.a.c.g2
    public int a(j1 j1Var) {
        if (this.u.a(j1Var)) {
            return (j1Var.P == 0 ? 4 : 2) | 0 | 0;
        }
        return 0;
    }

    @Override // b.i.a.c.f2
    public boolean b() {
        return this.A;
    }

    @Override // b.i.a.c.f2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.f2, b.i.a.c.g2
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.v.b((Metadata) message.obj);
        return true;
    }

    @Override // b.i.a.c.f2
    public void q(long j, long j2) {
        boolean z2 = true;
        while (z2) {
            if (!this.f1321z && this.D == null) {
                this.f1319x.p();
                k1 k1VarA = A();
                int I = I(k1VarA, this.f1319x, 0);
                if (I == -4) {
                    if (this.f1319x.n()) {
                        this.f1321z = true;
                    } else {
                        d dVar = this.f1319x;
                        dVar.r = this.B;
                        dVar.s();
                        b bVar = this.f1320y;
                        int i = e0.a;
                        Metadata metadataA = bVar.a(this.f1319x);
                        if (metadataA != null) {
                            ArrayList arrayList = new ArrayList(metadataA.j.length);
                            J(metadataA, arrayList);
                            if (!arrayList.isEmpty()) {
                                this.D = new Metadata(arrayList);
                                this.C = this.f1319x.n;
                            }
                        }
                    }
                } else if (I == -5) {
                    j1 j1Var = k1VarA.f1027b;
                    Objects.requireNonNull(j1Var);
                    this.B = j1Var.A;
                }
            }
            Metadata metadata = this.D;
            if (metadata == null || this.C > j) {
                z2 = false;
            } else {
                Handler handler = this.w;
                if (handler != null) {
                    handler.obtainMessage(0, metadata).sendToTarget();
                } else {
                    this.v.b(metadata);
                }
                this.D = null;
                this.C = -9223372036854775807L;
                z2 = true;
            }
            if (this.f1321z && this.D == null) {
                this.A = true;
            }
        }
    }
}
