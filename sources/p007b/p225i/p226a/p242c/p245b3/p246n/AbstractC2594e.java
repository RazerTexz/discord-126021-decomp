package p007b.p225i.p226a.p242c.p245b3.p246n;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2587k;
import p007b.p225i.p226a.p242c.p245b3.C2586j;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g;
import p007b.p225i.p226a.p242c.p245b3.InterfaceC2584h;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2958f;

/* JADX INFO: renamed from: b.i.a.c.b3.n.e */
/* JADX INFO: compiled from: CeaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2594e implements InterfaceC2584h {

    /* JADX INFO: renamed from: a */
    public final ArrayDeque<b> f5906a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b */
    public final ArrayDeque<AbstractC2587k> f5907b;

    /* JADX INFO: renamed from: c */
    public final PriorityQueue<b> f5908c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public b f5909d;

    /* JADX INFO: renamed from: e */
    public long f5910e;

    /* JADX INFO: renamed from: f */
    public long f5911f;

    /* JADX INFO: renamed from: b.i.a.c.b3.n.e$b */
    /* JADX INFO: compiled from: CeaDecoder.java */
    public static final class b extends C2586j implements Comparable<b> {

        /* JADX INFO: renamed from: s */
        public long f5912s;

        public b() {
        }

        @Override // java.lang.Comparable
        public int compareTo(b bVar) {
            b bVar2 = bVar;
            if (m3555n() == bVar2.m3555n()) {
                long j = this.f19780n - bVar2.f19780n;
                if (j == 0) {
                    j = this.f5912s - bVar2.f5912s;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
            } else if (m3555n()) {
                return 1;
            }
            return -1;
        }

        public b(a aVar) {
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.n.e$c */
    /* JADX INFO: compiled from: CeaDecoder.java */
    public static final class c extends AbstractC2587k {

        /* JADX INFO: renamed from: n */
        public AbstractC2958f.a<c> f5913n;

        public c(AbstractC2958f.a<c> aVar) {
            this.f5913n = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p265v2.AbstractC2958f
        /* JADX INFO: renamed from: p */
        public final void mo2611p() {
            AbstractC2594e abstractC2594e = ((C2591b) this.f5913n).f5819a;
            Objects.requireNonNull(abstractC2594e);
            m2618q();
            abstractC2594e.f5907b.add(this);
        }
    }

    public AbstractC2594e() {
        for (int i = 0; i < 10; i++) {
            this.f5906a.add(new b(null));
        }
        this.f5907b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f5907b.add(new c(new C2591b(this)));
        }
        this.f5908c = new PriorityQueue<>();
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2584h
    /* JADX INFO: renamed from: a */
    public void mo2607a(long j) {
        this.f5910e = j;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: c */
    public C2586j mo2609c() throws DecoderException {
        C1460d.m426D(this.f5909d == null);
        if (this.f5906a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f5906a.pollFirst();
        this.f5909d = bVarPollFirst;
        return bVarPollFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    /* JADX INFO: renamed from: d */
    public void mo2610d(C2586j c2586j) throws DecoderException {
        C2586j c2586j2 = c2586j;
        C1460d.m531j(c2586j2 == this.f5909d);
        b bVar = (b) c2586j2;
        if (bVar.m3554m()) {
            m2659i(bVar);
        } else {
            long j = this.f5911f;
            this.f5911f = 1 + j;
            bVar.f5912s = j;
            this.f5908c.add(bVar);
        }
        this.f5909d = null;
    }

    /* JADX INFO: renamed from: e */
    public abstract InterfaceC2583g mo2634e();

    /* JADX INFO: renamed from: f */
    public abstract void mo2635f(C2586j c2586j);

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    public void flush() {
        this.f5911f = 0L;
        this.f5910e = 0L;
        while (!this.f5908c.isEmpty()) {
            b bVarPoll = this.f5908c.poll();
            int i = C2738e0.f6708a;
            m2659i(bVarPoll);
        }
        b bVar = this.f5909d;
        if (bVar != null) {
            m2659i(bVar);
            this.f5909d = null;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public AbstractC2587k mo2608b() throws SubtitleDecoderException {
        if (this.f5907b.isEmpty()) {
            return null;
        }
        while (!this.f5908c.isEmpty()) {
            b bVarPeek = this.f5908c.peek();
            int i = C2738e0.f6708a;
            if (bVarPeek.f19780n > this.f5910e) {
                break;
            }
            b bVarPoll = this.f5908c.poll();
            if (bVarPoll.m3555n()) {
                AbstractC2587k abstractC2587kPollFirst = this.f5907b.pollFirst();
                abstractC2587kPollFirst.m3551j(4);
                m2659i(bVarPoll);
                return abstractC2587kPollFirst;
            }
            mo2635f(bVarPoll);
            if (mo2637h()) {
                InterfaceC2583g interfaceC2583gMo2634e = mo2634e();
                AbstractC2587k abstractC2587kPollFirst2 = this.f5907b.pollFirst();
                abstractC2587kPollFirst2.m2619r(bVarPoll.f19780n, interfaceC2583gMo2634e, RecyclerView.FOREVER_NS);
                m2659i(bVarPoll);
                return abstractC2587kPollFirst2;
            }
            m2659i(bVarPoll);
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public abstract boolean mo2637h();

    /* JADX INFO: renamed from: i */
    public final void m2659i(b bVar) {
        bVar.mo3856p();
        this.f5906a.add(bVar);
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    public void release() {
    }
}
