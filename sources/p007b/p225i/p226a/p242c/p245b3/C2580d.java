package p007b.p225i.p226a.p242c.p245b3;

import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p259f3.C2739f;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.b3.d */
/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2580d implements InterfaceC2584h {

    /* JADX INFO: renamed from: a */
    public final C2579c f5790a = new C2579c();

    /* JADX INFO: renamed from: b */
    public final C2586j f5791b = new C2586j();

    /* JADX INFO: renamed from: c */
    public final Deque<AbstractC2587k> f5792c = new ArrayDeque();

    /* JADX INFO: renamed from: d */
    public int f5793d;

    /* JADX INFO: renamed from: e */
    public boolean f5794e;

    /* JADX INFO: renamed from: b.i.a.c.b3.d$a */
    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    public class a extends AbstractC2587k {
        public a() {
        }

        @Override // p007b.p225i.p226a.p242c.p265v2.AbstractC2958f
        /* JADX INFO: renamed from: p */
        public void mo2611p() {
            C2580d c2580d = C2580d.this;
            C1460d.m426D(c2580d.f5792c.size() < 2);
            C1460d.m531j(!c2580d.f5792c.contains(this));
            m2618q();
            c2580d.f5792c.addFirst(this);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.d$b */
    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    public static final class b implements InterfaceC2583g {

        /* JADX INFO: renamed from: j */
        public final long f5796j;

        /* JADX INFO: renamed from: k */
        public final AbstractC4523p<C2578b> f5797k;

        public b(long j, AbstractC4523p<C2578b> abstractC4523p) {
            this.f5796j = j;
            this.f5797k = abstractC4523p;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
        /* JADX INFO: renamed from: f */
        public int mo2612f(long j) {
            return this.f5796j > j ? 0 : -1;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
        /* JADX INFO: renamed from: g */
        public long mo2613g(int i) {
            C1460d.m531j(i == 0);
            return this.f5796j;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
        /* JADX INFO: renamed from: h */
        public List<C2578b> mo2614h(long j) {
            if (j >= this.f5796j) {
                return this.f5797k;
            }
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            return C4508h0.f12012l;
        }

        @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2583g
        /* JADX INFO: renamed from: i */
        public int mo2615i() {
            return 1;
        }
    }

    public C2580d() {
        for (int i = 0; i < 2; i++) {
            this.f5792c.addFirst(new a());
        }
        this.f5793d = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.InterfaceC2584h
    /* JADX INFO: renamed from: a */
    public void mo2607a(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: b */
    public AbstractC2587k mo2608b() throws DecoderException {
        C1460d.m426D(!this.f5794e);
        if (this.f5793d != 2 || this.f5792c.isEmpty()) {
            return null;
        }
        AbstractC2587k abstractC2587kRemoveFirst = this.f5792c.removeFirst();
        if (this.f5791b.m3555n()) {
            abstractC2587kRemoveFirst.m3551j(4);
        } else {
            C2586j c2586j = this.f5791b;
            long j = c2586j.f19780n;
            C2579c c2579c = this.f5790a;
            ByteBuffer byteBuffer = c2586j.f19778l;
            Objects.requireNonNull(byteBuffer);
            byte[] bArrArray = byteBuffer.array();
            Objects.requireNonNull(c2579c);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.unmarshall(bArrArray, 0, bArrArray.length);
            parcelObtain.setDataPosition(0);
            Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
            parcelObtain.recycle();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("c");
            Objects.requireNonNull(parcelableArrayList);
            abstractC2587kRemoveFirst.m2619r(this.f5791b.f19780n, new b(j, C2739f.m3019a(C2578b.f5755k, parcelableArrayList)), 0L);
        }
        this.f5791b.mo3856p();
        this.f5793d = 0;
        return abstractC2587kRemoveFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: c */
    public C2586j mo2609c() throws DecoderException {
        C1460d.m426D(!this.f5794e);
        if (this.f5793d != 0) {
            return null;
        }
        this.f5793d = 1;
        return this.f5791b;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    /* JADX INFO: renamed from: d */
    public void mo2610d(C2586j c2586j) throws DecoderException {
        C2586j c2586j2 = c2586j;
        C1460d.m426D(!this.f5794e);
        C1460d.m426D(this.f5793d == 1);
        C1460d.m531j(this.f5791b == c2586j2);
        this.f5793d = 2;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    public void flush() {
        C1460d.m426D(!this.f5794e);
        this.f5791b.mo3856p();
        this.f5793d = 0;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    public void release() {
        this.f5794e = true;
    }
}
