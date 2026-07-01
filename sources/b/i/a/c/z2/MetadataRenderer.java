package b.i.a.c.z2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import b.i.a.c.BaseRenderer;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.z2.f, reason: use source file name */
/* JADX INFO: compiled from: MetadataRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    public boolean A;
    public long B;
    public long C;

    @Nullable
    public Metadata D;
    public final MetadataDecoderFactory u;
    public final MetadataOutput v;

    @Nullable
    public final Handler w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MetadataInputBuffer f1319x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public MetadataDecoder f1320y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1321z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetadataRenderer(MetadataOutput metadataOutput, @Nullable Looper looper) {
        Handler handler;
        super(5);
        MetadataDecoderFactory metadataDecoderFactory = MetadataDecoderFactory.a;
        Objects.requireNonNull(metadataOutput);
        this.v = metadataOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i = Util2.a;
            handler = new Handler(looper, this);
        }
        this.w = handler;
        this.u = metadataDecoderFactory;
        this.f1319x = new MetadataInputBuffer();
        this.C = -9223372036854775807L;
    }

    @Override // b.i.a.c.BaseRenderer
    public void B() {
        this.D = null;
        this.C = -9223372036854775807L;
        this.f1320y = null;
    }

    @Override // b.i.a.c.BaseRenderer
    public void D(long j, boolean z2) {
        this.D = null;
        this.C = -9223372036854775807L;
        this.f1321z = false;
        this.A = false;
    }

    @Override // b.i.a.c.BaseRenderer
    public void H(Format2[] format2Arr, long j, long j2) {
        this.f1320y = this.u.b(format2Arr[0]);
    }

    public final void J(Metadata metadata, List<Metadata.Entry> list) {
        int i = 0;
        while (true) {
            Metadata.Entry[] entryArr = metadata.j;
            if (i >= entryArr.length) {
                return;
            }
            Format2 format2Y = entryArr[i].y();
            if (format2Y == null || !this.u.a(format2Y)) {
                list.add(metadata.j[i]);
            } else {
                MetadataDecoder metadataDecoderB = this.u.b(format2Y);
                byte[] bArrO0 = metadata.j[i].o0();
                Objects.requireNonNull(bArrO0);
                this.f1319x.p();
                this.f1319x.r(bArrO0.length);
                ByteBuffer byteBuffer = this.f1319x.l;
                int i2 = Util2.a;
                byteBuffer.put(bArrO0);
                this.f1319x.s();
                Metadata metadataA = metadataDecoderB.a(this.f1319x);
                if (metadataA != null) {
                    J(metadataA, list);
                }
            }
            i++;
        }
    }

    @Override // b.i.a.c.RendererCapabilities
    public int a(Format2 format2) {
        if (this.u.a(format2)) {
            return (format2.P == 0 ? 4 : 2) | 0 | 0;
        }
        return 0;
    }

    @Override // b.i.a.c.Renderer2
    public boolean b() {
        return this.A;
    }

    @Override // b.i.a.c.Renderer2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.Renderer2, b.i.a.c.RendererCapabilities
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.v.b((Metadata) message.obj);
        return true;
    }

    @Override // b.i.a.c.Renderer2
    public void q(long j, long j2) {
        boolean z2 = true;
        while (z2) {
            if (!this.f1321z && this.D == null) {
                this.f1319x.p();
                FormatHolder formatHolderA = A();
                int I = I(formatHolderA, this.f1319x, 0);
                if (I == -4) {
                    if (this.f1319x.n()) {
                        this.f1321z = true;
                    } else {
                        MetadataInputBuffer metadataInputBuffer = this.f1319x;
                        metadataInputBuffer.r = this.B;
                        metadataInputBuffer.s();
                        MetadataDecoder metadataDecoder = this.f1320y;
                        int i = Util2.a;
                        Metadata metadataA = metadataDecoder.a(this.f1319x);
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
                    Format2 format2 = formatHolderA.f1027b;
                    Objects.requireNonNull(format2);
                    this.B = format2.A;
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
