package b.i.a.c.v2;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.SimpleSubtitleDecoder;
import b.i.a.c.b3.SimpleSubtitleDecoder2;
import b.i.a.c.b3.SubtitleInputBuffer;
import b.i.a.c.v2.DecoderOutputBuffer;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayDeque;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.v2.h, reason: use source file name */
/* JADX INFO: compiled from: SimpleDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends DecoderOutputBuffer, E extends DecoderException> implements Decoder<I, O, E> {
    public final Thread a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1145b = new Object();
    public final ArrayDeque<I> c = new ArrayDeque<>();
    public final ArrayDeque<O> d = new ArrayDeque<>();
    public final I[] e;
    public final O[] f;
    public int g;
    public int h;

    @Nullable
    public I i;

    @Nullable
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    /* JADX INFO: renamed from: b.i.a.c.v2.h$a */
    /* JADX INFO: compiled from: SimpleDecoder.java */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SimpleDecoder simpleDecoder = SimpleDecoder.this;
            Objects.requireNonNull(simpleDecoder);
            do {
                try {
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            } while (simpleDecoder.f());
        }
    }

    public SimpleDecoder(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            this.e[i] = new SubtitleInputBuffer();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            this.f[i2] = new SimpleSubtitleDecoder((SimpleSubtitleDecoder2) this);
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.a = aVar;
        aVar.start();
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    public Object b() throws DecoderException {
        O oRemoveFirst;
        synchronized (this.f1145b) {
            h();
            oRemoveFirst = this.d.isEmpty() ? null : this.d.removeFirst();
        }
        return oRemoveFirst;
    }

    @Override // b.i.a.c.v2.Decoder
    @Nullable
    public Object c() throws DecoderException {
        I i;
        synchronized (this.f1145b) {
            h();
            AnimatableValueParser.D(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Override // b.i.a.c.v2.Decoder
    public void d(Object obj) throws DecoderException {
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) obj;
        synchronized (this.f1145b) {
            h();
            AnimatableValueParser.j(decoderInputBuffer == this.i);
            this.c.addLast((I) decoderInputBuffer);
            g();
            this.i = null;
        }
    }

    @Nullable
    public abstract E e(I i, O o, boolean z2);

    public final boolean f() throws InterruptedException {
        SubtitleDecoderException subtitleDecoderException;
        SubtitleDecoderException subtitleDecoderException2;
        synchronized (this.f1145b) {
            while (!this.l) {
                if (!this.c.isEmpty() && this.h > 0) {
                    break;
                }
                this.f1145b.wait();
            }
            if (this.l) {
                return false;
            }
            I iRemoveFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z2 = this.k;
            this.k = false;
            if (iRemoveFirst.n()) {
                o.j(4);
            } else {
                if (iRemoveFirst.m()) {
                    o.j(Integer.MIN_VALUE);
                }
                try {
                    subtitleDecoderException2 = (E) e(iRemoveFirst, o, z2);
                } catch (OutOfMemoryError e) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e);
                    subtitleDecoderException2 = subtitleDecoderException;
                } catch (RuntimeException e2) {
                    subtitleDecoderException = new SubtitleDecoderException("Unexpected decode error", e2);
                    subtitleDecoderException2 = subtitleDecoderException;
                }
                if (subtitleDecoderException2 != null) {
                    synchronized (this.f1145b) {
                        this.j = subtitleDecoderException2;
                    }
                    return false;
                }
            }
            synchronized (this.f1145b) {
                if (this.k) {
                    o.p();
                } else if (o.m()) {
                    this.m++;
                    o.p();
                } else {
                    this.m = 0;
                    this.d.addLast(o);
                }
                i(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // b.i.a.c.v2.Decoder
    public final void flush() {
        synchronized (this.f1145b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                i(i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                i(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().p();
            }
        }
    }

    public final void g() {
        if (!this.c.isEmpty() && this.h > 0) {
            this.f1145b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    public final void h() throws E, DecoderException {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    public final void i(I i) {
        i.p();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    @Override // b.i.a.c.v2.Decoder
    @CallSuper
    public void release() {
        synchronized (this.f1145b) {
            this.l = true;
            this.f1145b.notify();
        }
        try {
            this.a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
