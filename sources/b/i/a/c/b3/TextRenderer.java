package b.i.a.c.b3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.BaseRenderer;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.b3.SubtitleDecoderFactory;
import b.i.a.c.b3.n.Cea608Decoder;
import b.i.a.c.b3.n.Cea708Decoder;
import b.i.a.c.b3.o.DvbDecoder;
import b.i.a.c.b3.p.PgsDecoder;
import b.i.a.c.b3.r.SsaDecoder;
import b.i.a.c.b3.s.SubripDecoder;
import b.i.a.c.b3.t.TtmlDecoder;
import b.i.a.c.b3.u.Tx3gDecoder;
import b.i.a.c.b3.v.Mp4WebvttDecoder;
import b.i.a.c.b3.v.WebvttDecoder;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.b3.m, reason: use source file name */
/* JADX INFO: compiled from: TextRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TextRenderer extends BaseRenderer implements Handler.Callback {
    public boolean A;
    public int B;

    @Nullable
    public Format2 C;

    @Nullable
    public SubtitleDecoder D;

    @Nullable
    public SubtitleInputBuffer E;

    @Nullable
    public SubtitleOutputBuffer F;

    @Nullable
    public SubtitleOutputBuffer G;
    public int H;
    public long I;

    @Nullable
    public final Handler u;
    public final TextOutput v;
    public final SubtitleDecoderFactory w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FormatHolder f844x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f845y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f846z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextRenderer(TextOutput textOutput, @Nullable Looper looper) {
        Handler handler;
        super(3);
        SubtitleDecoderFactory subtitleDecoderFactory = SubtitleDecoderFactory.a;
        Objects.requireNonNull(textOutput);
        this.v = textOutput;
        if (looper == null) {
            handler = null;
        } else {
            int i = Util2.a;
            handler = new Handler(looper, this);
        }
        this.u = handler;
        this.w = subtitleDecoderFactory;
        this.f844x = new FormatHolder();
        this.I = -9223372036854775807L;
    }

    @Override // b.i.a.c.BaseRenderer
    public void B() {
        this.C = null;
        this.I = -9223372036854775807L;
        J();
        N();
        SubtitleDecoder subtitleDecoder = this.D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.release();
        this.D = null;
        this.B = 0;
    }

    @Override // b.i.a.c.BaseRenderer
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
        SubtitleDecoder subtitleDecoder = this.D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.flush();
    }

    @Override // b.i.a.c.BaseRenderer
    public void H(Format2[] format2Arr, long j, long j2) {
        this.C = format2Arr[0];
        if (this.D != null) {
            this.B = 1;
        } else {
            M();
        }
    }

    public final void J() {
        List<Cue> listEmptyList = Collections.emptyList();
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
        Subtitle subtitle = this.F.l;
        Objects.requireNonNull(subtitle);
        if (i >= subtitle.i()) {
            return RecyclerView.FOREVER_NS;
        }
        SubtitleOutputBuffer subtitleOutputBuffer = this.F;
        int i2 = this.H;
        Subtitle subtitle2 = subtitleOutputBuffer.l;
        Objects.requireNonNull(subtitle2);
        return subtitle2.g(i2) + subtitleOutputBuffer.m;
    }

    public final void L(SubtitleDecoderException subtitleDecoderException) {
        String strValueOf = String.valueOf(this.C);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 39);
        sb.append("Subtitle decoding failed. streamFormat=");
        sb.append(strValueOf);
        Log2.b("TextRenderer", sb.toString(), subtitleDecoderException);
        J();
        O();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:6:0x001b  */
    public final void M() {
        SubtitleDecoder dvbDecoder;
        byte b2 = 1;
        this.A = true;
        SubtitleDecoderFactory subtitleDecoderFactory = this.w;
        Format2 format2 = this.C;
        Objects.requireNonNull(format2);
        Objects.requireNonNull((SubtitleDecoderFactory.a) subtitleDecoderFactory);
        String str = format2.w;
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
                    dvbDecoder = new DvbDecoder(format2.f1019y);
                    break;
                case 1:
                    dvbDecoder = new PgsDecoder();
                    break;
                case 2:
                    dvbDecoder = new Mp4WebvttDecoder();
                    break;
                case 3:
                    dvbDecoder = new WebvttDecoder();
                    break;
                case 4:
                    dvbDecoder = new Tx3gDecoder(format2.f1019y);
                    break;
                case 5:
                    dvbDecoder = new SsaDecoder(format2.f1019y);
                    break;
                case 6:
                case 8:
                    dvbDecoder = new Cea608Decoder(str, format2.O, 16000L);
                    break;
                case 7:
                    dvbDecoder = new ExoplayerCuesDecoder();
                    break;
                case 9:
                    dvbDecoder = new Cea708Decoder(format2.O, format2.f1019y);
                    break;
                case 10:
                    dvbDecoder = new SubripDecoder();
                    break;
                case 11:
                    dvbDecoder = new TtmlDecoder();
                    break;
            }
            this.D = dvbDecoder;
            return;
        }
        String strValueOf = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf.length() != 0 ? "Attempted to create decoder for unsupported MIME type: ".concat(strValueOf) : new String("Attempted to create decoder for unsupported MIME type: "));
    }

    public final void N() {
        this.E = null;
        this.H = -1;
        SubtitleOutputBuffer subtitleOutputBuffer = this.F;
        if (subtitleOutputBuffer != null) {
            subtitleOutputBuffer.p();
            this.F = null;
        }
        SubtitleOutputBuffer subtitleOutputBuffer2 = this.G;
        if (subtitleOutputBuffer2 != null) {
            subtitleOutputBuffer2.p();
            this.G = null;
        }
    }

    public final void O() {
        N();
        SubtitleDecoder subtitleDecoder = this.D;
        Objects.requireNonNull(subtitleDecoder);
        subtitleDecoder.release();
        this.D = null;
        this.B = 0;
        M();
    }

    @Override // b.i.a.c.RendererCapabilities
    public int a(Format2 format2) {
        Objects.requireNonNull((SubtitleDecoderFactory.a) this.w);
        String str = format2.w;
        if ("text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str) || "text/x-exoplayer-cues".equals(str)) {
            return (format2.P == 0 ? 4 : 2) | 0 | 0;
        }
        return MimeTypes.i(format2.w) ? 1 : 0;
    }

    @Override // b.i.a.c.Renderer2
    public boolean b() {
        return this.f846z;
    }

    @Override // b.i.a.c.Renderer2
    public boolean d() {
        return true;
    }

    @Override // b.i.a.c.Renderer2, b.i.a.c.RendererCapabilities
    public String getName() {
        return "TextRenderer";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        this.v.e((List) message.obj);
        return true;
    }

    @Override // b.i.a.c.Renderer2
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
            SubtitleDecoder subtitleDecoder = this.D;
            Objects.requireNonNull(subtitleDecoder);
            subtitleDecoder.a(j);
            try {
                SubtitleDecoder subtitleDecoder2 = this.D;
                Objects.requireNonNull(subtitleDecoder2);
                this.G = subtitleDecoder2.b();
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
        SubtitleOutputBuffer subtitleOutputBuffer = this.G;
        if (subtitleOutputBuffer != null) {
            if (subtitleOutputBuffer.n()) {
                if (!z2 && K() == RecyclerView.FOREVER_NS) {
                    if (this.B == 2) {
                        O();
                    } else {
                        N();
                        this.f846z = true;
                    }
                }
            } else if (subtitleOutputBuffer.k <= j) {
                SubtitleOutputBuffer subtitleOutputBuffer2 = this.F;
                if (subtitleOutputBuffer2 != null) {
                    subtitleOutputBuffer2.p();
                }
                Subtitle subtitle = subtitleOutputBuffer.l;
                Objects.requireNonNull(subtitle);
                this.H = subtitle.f(j - subtitleOutputBuffer.m);
                this.F = subtitleOutputBuffer;
                this.G = null;
                z2 = true;
            }
        }
        if (z2) {
            Objects.requireNonNull(this.F);
            SubtitleOutputBuffer subtitleOutputBuffer3 = this.F;
            Subtitle subtitle2 = subtitleOutputBuffer3.l;
            Objects.requireNonNull(subtitle2);
            List<Cue> listH = subtitle2.h(j - subtitleOutputBuffer3.m);
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
                SubtitleInputBuffer subtitleInputBufferC = this.E;
                if (subtitleInputBufferC == null) {
                    SubtitleDecoder subtitleDecoder3 = this.D;
                    Objects.requireNonNull(subtitleDecoder3);
                    subtitleInputBufferC = subtitleDecoder3.c();
                    if (subtitleInputBufferC == null) {
                        return;
                    } else {
                        this.E = subtitleInputBufferC;
                    }
                }
                if (this.B == 1) {
                    subtitleInputBufferC.j = 4;
                    SubtitleDecoder subtitleDecoder4 = this.D;
                    Objects.requireNonNull(subtitleDecoder4);
                    subtitleDecoder4.d(subtitleInputBufferC);
                    this.E = null;
                    this.B = 2;
                    return;
                }
                int I = I(this.f844x, subtitleInputBufferC, 0);
                if (I == -4) {
                    if (subtitleInputBufferC.n()) {
                        this.f845y = true;
                        this.A = false;
                    } else {
                        Format2 format2 = this.f844x.f1027b;
                        if (format2 == null) {
                            return;
                        }
                        subtitleInputBufferC.r = format2.A;
                        subtitleInputBufferC.s();
                        this.A &= !subtitleInputBufferC.o();
                    }
                    if (!this.A) {
                        SubtitleDecoder subtitleDecoder5 = this.D;
                        Objects.requireNonNull(subtitleDecoder5);
                        subtitleDecoder5.d(subtitleInputBufferC);
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
