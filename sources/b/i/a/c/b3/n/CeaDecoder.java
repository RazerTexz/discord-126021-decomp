package b.i.a.c.b3.n;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.b3.SubtitleDecoder;
import b.i.a.c.b3.SubtitleInputBuffer;
import b.i.a.c.b3.SubtitleOutputBuffer;
import b.i.a.c.f3.Util2;
import b.i.a.c.v2.DecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;

/* JADX INFO: renamed from: b.i.a.c.b3.n.e, reason: use source file name */
/* JADX INFO: compiled from: CeaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CeaDecoder implements SubtitleDecoder {
    public final ArrayDeque<b> a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<SubtitleOutputBuffer> f860b;
    public final PriorityQueue<b> c;

    @Nullable
    public b d;
    public long e;
    public long f;

    /* JADX INFO: renamed from: b.i.a.c.b3.n.e$b */
    /* JADX INFO: compiled from: CeaDecoder.java */
    public static final class b extends SubtitleInputBuffer implements Comparable<b> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f861s;

        public b() {
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            if (n() == bVar2.n()) {
                long j = this.n - bVar2.n;
                if (j == 0) {
                    j = this.f861s - bVar2.f861s;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (n()) {
                return 1;
            }
            return -1;
        }

        public b(a aVar) {
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.n.e$c */
    /* JADX INFO: compiled from: CeaDecoder.java */
    public static final class c extends SubtitleOutputBuffer {
        public DecoderOutputBuffer.a<c> n;

        public c(DecoderOutputBuffer.a<c> aVar) {
            this.n = aVar;
        }

        @Override // b.i.a.c.v2.DecoderOutputBuffer
        public final void p() {
            CeaDecoder ceaDecoder = ((b.i.a.c.b3.n.b) this.n).a;
            Objects.requireNonNull(ceaDecoder);
            q();
            ceaDecoder.f860b.add(this);
        }
    }

    public CeaDecoder() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b(null));
        }
        this.f860b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f860b.add(new c(new b.i.a.c.b3.n.b(this)));
        }
        this.c = new PriorityQueue<>();
    }

    @Override // b.i.a.c.b3.SubtitleDecoder
    public void a(long j) {
        this.e = j;
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    public SubtitleInputBuffer c() throws DecoderException {
        AnimatableValueParser.D(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.a.pollFirst();
        this.d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // b.i.a.c.v2.Decoder
    public void d(SubtitleInputBuffer subtitleInputBuffer) throws DecoderException {
        SubtitleInputBuffer subtitleInputBuffer2 = subtitleInputBuffer;
        AnimatableValueParser.j(subtitleInputBuffer2 == this.d);
        b bVar = (b) subtitleInputBuffer2;
        if (bVar.m()) {
            i(bVar);
        } else {
            long j = this.f;
            this.f = 1 + j;
            bVar.f861s = j;
            this.c.add(bVar);
        }
        this.d = null;
    }

    public abstract Subtitle e();

    public abstract void f(SubtitleInputBuffer subtitleInputBuffer);

    @Override // b.i.a.c.v2.Decoder
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            b bVarPoll = this.c.poll();
            int i = Util2.a;
            i(bVarPoll);
        }
        b bVar = this.d;
        if (bVar != null) {
            i(bVar);
            this.d = null;
        }
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public SubtitleOutputBuffer b() throws SubtitleDecoderException {
        if (this.f860b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty()) {
            b bVarPeek = this.c.peek();
            int i = Util2.a;
            if (bVarPeek.n > this.e) {
                break;
            }
            b bVarPoll = this.c.poll();
            if (bVarPoll.n()) {
                SubtitleOutputBuffer subtitleOutputBufferPollFirst = this.f860b.pollFirst();
                subtitleOutputBufferPollFirst.j(4);
                i(bVarPoll);
                return subtitleOutputBufferPollFirst;
            }
            f(bVarPoll);
            if (h()) {
                Subtitle subtitleE = e();
                SubtitleOutputBuffer subtitleOutputBufferPollFirst2 = this.f860b.pollFirst();
                subtitleOutputBufferPollFirst2.r(bVarPoll.n, subtitleE, RecyclerView.FOREVER_NS);
                i(bVarPoll);
                return subtitleOutputBufferPollFirst2;
            }
            i(bVarPoll);
        }
        return null;
    }

    public abstract boolean h();

    public final void i(b bVar) {
        bVar.p();
        this.a.add(bVar);
    }

    @Override // b.i.a.c.v2.Decoder
    public void release() {
    }
}
