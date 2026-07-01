package b.i.a.c.b3.n;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.b3.g;
import b.i.a.c.b3.h;
import b.i.a.c.b3.j;
import b.i.a.c.b3.k;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: CeaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements h {
    public final ArrayDeque<e$b> a = new ArrayDeque<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<k> f860b;
    public final PriorityQueue<e$b> c;

    @Nullable
    public e$b d;
    public long e;
    public long f;

    public e() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new e$b(null));
        }
        this.f860b = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.f860b.add(new e$c(new b(this)));
        }
        this.c = new PriorityQueue<>();
    }

    @Override // b.i.a.c.b3.h
    public void a(long j) {
        this.e = j;
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public /* bridge */ /* synthetic */ k b() throws DecoderException {
        return g();
    }

    @Override // b.i.a.c.v2.d
    @Nullable
    public j c() throws DecoderException {
        b.c.a.a0.d.D(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        e$b e_bPollFirst = this.a.pollFirst();
        this.d = e_bPollFirst;
        return e_bPollFirst;
    }

    @Override // b.i.a.c.v2.d
    public void d(j jVar) throws DecoderException {
        j jVar2 = jVar;
        b.c.a.a0.d.j(jVar2 == this.d);
        e$b e_b = (e$b) jVar2;
        if (e_b.m()) {
            i(e_b);
        } else {
            long j = this.f;
            this.f = 1 + j;
            e_b.f861s = j;
            this.c.add(e_b);
        }
        this.d = null;
    }

    public abstract g e();

    public abstract void f(j jVar);

    @Override // b.i.a.c.v2.d
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            e$b e_bPoll = this.c.poll();
            int i = e0.a;
            i(e_bPoll);
        }
        e$b e_b = this.d;
        if (e_b != null) {
            i(e_b);
            this.d = null;
        }
    }

    @Nullable
    public k g() throws SubtitleDecoderException {
        if (this.f860b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty()) {
            e$b e_bPeek = this.c.peek();
            int i = e0.a;
            if (e_bPeek.n > this.e) {
                break;
            }
            e$b e_bPoll = this.c.poll();
            if (e_bPoll.n()) {
                k kVarPollFirst = this.f860b.pollFirst();
                kVarPollFirst.j(4);
                i(e_bPoll);
                return kVarPollFirst;
            }
            f(e_bPoll);
            if (h()) {
                g gVarE = e();
                k kVarPollFirst2 = this.f860b.pollFirst();
                kVarPollFirst2.r(e_bPoll.n, gVarE, RecyclerView.FOREVER_NS);
                i(e_bPoll);
                return kVarPollFirst2;
            }
            i(e_bPoll);
        }
        return null;
    }

    public abstract boolean h();

    public final void i(e$b e_b) {
        e_b.p();
        this.a.add(e_b);
    }

    @Override // b.i.a.c.v2.d
    public void release() {
    }
}
