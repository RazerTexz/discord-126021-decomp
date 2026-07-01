package b.l.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.linecorp.apng.decoder.Apng;
import com.linecorp.apng.decoder.ApngException;
import d0.t.k;
import d0.z.d.m;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ApngDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends Drawable implements Animatable2Compat {

    @IntRange(from = 0, to = 2147483647L)
    public final int j;

    @IntRange(from = 1, to = 2147483647L)
    public final int k;
    public final List<Integer> l;

    @IntRange(from = 0, to = 2147483647L)
    public final int m;

    @IntRange(from = -1, to = 2147483647L)
    public int n;
    public final Paint o;
    public final List<Animatable2Compat$AnimationCallback> p;
    public final List<b> q;
    public final int[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1900s;
    public int t;
    public boolean u;
    public long v;
    public Long w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a$a f1901x;

    @VisibleForTesting
    public a(a$a a_a) {
        m.checkNotNullParameter(a_a, "apngState");
        this.f1901x = a_a;
        this.j = a_a.a.getDuration();
        int frameCount = this.f1901x.a.getFrameCount();
        this.k = frameCount;
        this.l = k.toList(this.f1901x.a.getFrameDurations());
        this.m = this.f1901x.a.getByteCount();
        this.f1901x.a.getAllFrameByteCount();
        this.n = this.f1901x.a.getLoopCount();
        this.f1901x.a.isRecycled();
        this.o = new Paint(6);
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new int[frameCount];
        a$a a_a2 = this.f1901x;
        this.f1900s = a_a2.f1902b;
        this.t = a_a2.c;
        for (int i = 1; i < frameCount; i++) {
            int[] iArr = this.r;
            int i2 = i - 1;
            iArr[i] = iArr[i2] + this.f1901x.a.getFrameDurations()[i2];
        }
        Rect bounds = getBounds();
        a$a a_a3 = this.f1901x;
        bounds.set(0, 0, a_a3.f1902b, a_a3.c);
    }

    @WorkerThread
    public static final a a(InputStream inputStream, @IntRange(from = 1, to = 2147483647L) Integer num, @IntRange(from = 1, to = 2147483647L) Integer num2) throws ApngException {
        m.checkNotNullParameter(inputStream, "stream");
        boolean z2 = true;
        if (!(!((num == null) ^ (num2 == null)))) {
            throw new IllegalArgumentException(("Can not specify only one side of size. width = " + num + ", height = " + num2).toString());
        }
        if (!(num == null || num.intValue() > 0)) {
            throw new IllegalArgumentException(("Can not specify 0 or negative as width value. width = " + num).toString());
        }
        if (num2 != null && num2.intValue() <= 0) {
            z2 = false;
        }
        if (z2) {
            int i = (num == null && num2 == null) ? Opcodes.IF_ICMPNE : 0;
            Apng apngDecode = Apng.Companion.decode(inputStream);
            return new a(new a$a(apngDecode, num != null ? num.intValue() : apngDecode.getWidth(), num2 != null ? num2.intValue() : apngDecode.getHeight(), i, a$a$a.j));
        }
        throw new IllegalArgumentException(("Can not specify 0 or negative as height value. height = " + num2).toString());
    }

    public final boolean b() {
        return this.n != 0 && d() > this.n - 1;
    }

    public final int c() {
        int i;
        int i2 = 0;
        long j = (this.v % ((long) this.j)) + ((long) (b() ? this.j : 0));
        int i3 = this.k - 1;
        while (true) {
            i = (i2 + i3) / 2;
            int[] iArr = this.r;
            int i4 = i + 1;
            if (iArr.length > i4 && j >= iArr[i4]) {
                i2 = i4;
            } else {
                if (i2 == i3 || j >= iArr[i]) {
                    break;
                }
                i3 = i;
            }
        }
        return i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        this.p.clear();
    }

    public final int d() {
        return (int) (this.v / ((long) this.j));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x006f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0078  */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:46:0x009e A[LOOP:1: B:44:0x0098->B:46:0x009e, LOOP_END] */
    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        m.checkNotNullParameter(canvas, "canvas");
        if (this.u) {
            int iC = c();
            long jLongValue = this.f1901x.e.invoke().longValue();
            Long l = this.w;
            this.v = l == null ? this.v : (this.v + jLongValue) - l.longValue();
            this.w = Long.valueOf(jLongValue);
            boolean z4 = c() != iC;
            if (this.u) {
                if (!(c() == 0)) {
                    if (c() == this.k - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.n == 0 && d() >= this.n - 1) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3 && z4) {
                            while (r0.hasNext()) {
                                bVar.b(this, d() + 2);
                                bVar.a(this, d() + 1);
                            }
                        }
                    }
                } else if ((d() == 0) && l == null) {
                    Iterator<T> it = this.p.iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat$AnimationCallback) it.next()).onAnimationStart(this);
                    }
                } else {
                    if (c() == this.k - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.n == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            for (b bVar : this.q) {
                                bVar.b(this, d() + 2);
                                bVar.a(this, d() + 1);
                            }
                        }
                    }
                }
            }
            if (b()) {
                this.u = false;
                Iterator<T> it2 = this.p.iterator();
                while (it2.hasNext()) {
                    ((Animatable2Compat$AnimationCallback) it2.next()).onAnimationEnd(this);
                }
            }
        }
        Apng apng = this.f1901x.a;
        int iC2 = c();
        Rect bounds = getBounds();
        m.checkNotNullExpressionValue(bounds, "bounds");
        apng.drawWithIndex(iC2, canvas, null, bounds, this.o);
        if (this.u) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable$ConstantState getConstantState() {
        return this.f1901x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1900s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.u;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f1901x = new a$a(this.f1901x);
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        m.checkNotNullParameter(animatable2Compat$AnimationCallback, "callback");
        this.p.add(animatable2Compat$AnimationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.o.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.o.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.u = true;
        this.w = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.u = false;
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat$AnimationCallback animatable2Compat$AnimationCallback) {
        m.checkNotNullParameter(animatable2Compat$AnimationCallback, "callback");
        return this.p.remove(animatable2Compat$AnimationCallback);
    }
}
