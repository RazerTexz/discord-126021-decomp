package p007b.p225i.p226a.p242c.p265v2;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.AbstractC2582f;
import p007b.p225i.p226a.p242c.p245b3.C2581e;
import p007b.p225i.p226a.p242c.p245b3.C2586j;
import p007b.p225i.p226a.p242c.p265v2.AbstractC2958f;

/* JADX INFO: renamed from: b.i.a.c.v2.h */
/* JADX INFO: compiled from: SimpleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2960h<I extends DecoderInputBuffer, O extends AbstractC2958f, E extends DecoderException> implements InterfaceC2956d<I, O, E> {

    /* JADX INFO: renamed from: a */
    public final Thread f7931a;

    /* JADX INFO: renamed from: b */
    public final Object f7932b = new Object();

    /* JADX INFO: renamed from: c */
    public final ArrayDeque<I> f7933c = new ArrayDeque<>();

    /* JADX INFO: renamed from: d */
    public final ArrayDeque<O> f7934d = new ArrayDeque<>();

    /* JADX INFO: renamed from: e */
    public final I[] f7935e;

    /* JADX INFO: renamed from: f */
    public final O[] f7936f;

    /* JADX INFO: renamed from: g */
    public int f7937g;

    /* JADX INFO: renamed from: h */
    public int f7938h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public I f7939i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public E f7940j;

    /* JADX INFO: renamed from: k */
    public boolean f7941k;

    /* JADX INFO: renamed from: l */
    public boolean f7942l;

    /* JADX INFO: renamed from: m */
    public int f7943m;

    /* JADX INFO: renamed from: b.i.a.c.v2.h$a */
    /* JADX INFO: compiled from: SimpleDecoder.java */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AbstractC2960h abstractC2960h = AbstractC2960h.this;
            Objects.requireNonNull(abstractC2960h);
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (abstractC2960h.m3557f());
        }
    }

    public AbstractC2960h(I[] iArr, O[] oArr) {
        this.f7935e = iArr;
        this.f7937g = iArr.length;
        for (int i = 0; i < this.f7937g; i++) {
            this.f7935e[i] = new C2586j();
        }
        this.f7936f = oArr;
        this.f7938h = oArr.length;
        for (int i2 = 0; i2 < this.f7938h; i2++) {
            this.f7936f[i2] = new C2581e((AbstractC2582f) this);
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f7931a = aVar;
        aVar.start();
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: b */
    public Object mo2608b() throws DecoderException {
        O oRemoveFirst;
        synchronized (this.f7932b) {
            m3559h();
            oRemoveFirst = this.f7934d.isEmpty() ? null : this.f7934d.removeFirst();
        }
        return oRemoveFirst;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @Nullable
    /* JADX INFO: renamed from: c */
    public Object mo2609c() throws DecoderException {
        I i;
        synchronized (this.f7932b) {
            m3559h();
            C1460d.m426D(this.f7939i == null);
            int i2 = this.f7937g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.f7935e;
                int i3 = i2 - 1;
                this.f7937g = i3;
                i = iArr[i3];
            }
            this.f7939i = i;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    /* JADX INFO: renamed from: d */
    public void mo2610d(Object obj) throws DecoderException {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) obj;
        synchronized (this.f7932b) {
            m3559h();
            C1460d.m531j(decoderInputBuffer == this.f7939i);
            this.f7933c.addLast((I) decoderInputBuffer);
            m3558g();
            this.f7939i = null;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public abstract E mo2616e(I i, O o, boolean z2);

    /* JADX INFO: renamed from: f */
    public final boolean m3557f() throws InterruptedException {
        SubtitleDecoderException subtitleDecoderException;
        SubtitleDecoderException subtitleDecoderException2;
        synchronized (this.f7932b) {
            while (!this.f7942l) {
                if (!this.f7933c.isEmpty() && this.f7938h > 0) {
                    break;
                }
                this.f7932b.wait();
            }
            if (this.f7942l) {
                return false;
            }
            I iRemoveFirst = this.f7933c.removeFirst();
            O[] oArr = this.f7936f;
            int i = this.f7938h - 1;
            this.f7938h = i;
            O o = oArr[i];
            boolean z2 = this.f7941k;
            this.f7941k = false;
            if (iRemoveFirst.m3555n()) {
                o.m3551j(4);
            } else {
                if (iRemoveFirst.m3554m()) {
                    o.m3551j(Integer.MIN_VALUE);
                }
                try {
                    subtitleDecoderException2 = (E) mo2616e(iRemoveFirst, o, z2);
                } catch (OutOfMemoryError e) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e);
                    subtitleDecoderException2 = subtitleDecoderException;
                } catch (RuntimeException e2) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e2);
                    subtitleDecoderException2 = subtitleDecoderException;
                }
                if (subtitleDecoderException2 != null) {
                    synchronized (this.f7932b) {
                        this.f7940j = subtitleDecoderException2;
                    }
                    return false;
                }
            }
            synchronized (this.f7932b) {
                if (this.f7941k) {
                    o.mo2611p();
                } else if (o.m3554m()) {
                    this.f7943m++;
                    o.mo2611p();
                } else {
                    this.f7943m = 0;
                    this.f7934d.addLast(o);
                }
                m3560i(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    public final void flush() {
        synchronized (this.f7932b) {
            this.f7941k = true;
            this.f7943m = 0;
            I i = this.f7939i;
            if (i != null) {
                m3560i(i);
                this.f7939i = null;
            }
            while (!this.f7933c.isEmpty()) {
                m3560i(this.f7933c.removeFirst());
            }
            while (!this.f7934d.isEmpty()) {
                this.f7934d.removeFirst().mo2611p();
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3558g() {
        if (!this.f7933c.isEmpty() && this.f7938h > 0) {
            this.f7932b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    /* JADX INFO: renamed from: h */
    public final void m3559h() throws E, DecoderException {
        E e = this.f7940j;
        if (e != null) {
            throw e;
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m3560i(I i) {
        i.mo3856p();
        I[] iArr = this.f7935e;
        int i2 = this.f7937g;
        this.f7937g = i2 + 1;
        iArr[i2] = i;
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.InterfaceC2956d
    @CallSuper
    public void release() {
        synchronized (this.f7932b) {
            this.f7942l = true;
            this.f7932b.notify();
        }
        try {
            this.f7931a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
