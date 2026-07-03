package p007b.p225i.p226a.p242c.p245b3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2958f;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2960h;

/* JADX INFO: renamed from: b.i.a.c.b3.f */
/* JADX INFO: compiled from: SimpleSubtitleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2582f extends AbstractC2960h<C2586j, AbstractC2587k, SubtitleDecoderException> implements InterfaceC2584h {
    public AbstractC2582f(String str) {
        super(new C2586j[2], new AbstractC2587k[2]);
        C1460d.m426D(this.f7937g == this.f7935e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.f7935e) {
            decoderInputBuffer.m8812r(1024);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2584h
    /* JADX INFO: renamed from: a */
    public void mo2607a(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.AbstractC2960h
    @Nullable
    /* JADX INFO: renamed from: e */
    public DecoderException mo2616e(DecoderInputBuffer decoderInputBuffer, AbstractC2958f abstractC2958f, boolean z2) {
        C2586j c2586j = (C2586j) decoderInputBuffer;
        AbstractC2587k abstractC2587k = (AbstractC2587k) abstractC2958f;
        try {
            ByteBuffer byteBuffer = c2586j.f19778l;
            Objects.requireNonNull(byteBuffer);
            abstractC2587k.m2619r(c2586j.f19780n, mo2617j(byteBuffer.array(), byteBuffer.limit(), z2), c2586j.f5800r);
            abstractC2587k.f7901j &= Integer.MAX_VALUE;
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    /* JADX INFO: renamed from: j */
    public abstract InterfaceC2583g mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException;
}
