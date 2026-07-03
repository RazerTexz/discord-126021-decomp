package p007b.p443l.p444a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import androidx.annotation.IntRange;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.linecorp.apng.decoder.Apng;
import com.linecorp.apng.decoder.ApngException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import org.objectweb.asm.Opcodes;
import p507d0.p580t.C12141k;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.l.a.a */
/* JADX INFO: compiled from: ApngDrawable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C5080a extends Drawable implements Animatable2Compat {

    /* JADX INFO: renamed from: j */
    @IntRange(from = 0, m76to = 2147483647L)
    public final int f13618j;

    /* JADX INFO: renamed from: k */
    @IntRange(from = 1, m76to = 2147483647L)
    public final int f13619k;

    /* JADX INFO: renamed from: l */
    public final List<Integer> f13620l;

    /* JADX INFO: renamed from: m */
    @IntRange(from = 0, m76to = 2147483647L)
    public final int f13621m;

    /* JADX INFO: renamed from: n */
    @IntRange(from = -1, m76to = 2147483647L)
    public int f13622n;

    /* JADX INFO: renamed from: o */
    public final Paint f13623o;

    /* JADX INFO: renamed from: p */
    public final List<Animatable2Compat.AnimationCallback> f13624p;

    /* JADX INFO: renamed from: q */
    public final List<InterfaceC5081b> f13625q;

    /* JADX INFO: renamed from: r */
    public final int[] f13626r;

    /* JADX INFO: renamed from: s */
    public int f13627s;

    /* JADX INFO: renamed from: t */
    public int f13628t;

    /* JADX INFO: renamed from: u */
    public boolean f13629u;

    /* JADX INFO: renamed from: v */
    public long f13630v;

    /* JADX INFO: renamed from: w */
    public Long f13631w;

    /* JADX INFO: renamed from: x */
    public a f13632x;

    /* JADX INFO: renamed from: b.l.a.a$a */
    /* JADX INFO: compiled from: ApngDrawable.kt */
    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        public final Apng f13633a;

        /* JADX INFO: renamed from: b */
        public final int f13634b;

        /* JADX INFO: renamed from: c */
        public final int f13635c;

        /* JADX INFO: renamed from: d */
        public final int f13636d;

        /* JADX INFO: renamed from: e */
        public final Function0<Long> f13637e;

        /* JADX INFO: renamed from: b.l.a.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ApngDrawable.kt */
        public static final class C13240a extends AbstractC12240o implements Function0<Long> {

            /* JADX INFO: renamed from: j */
            public static final C13240a f13638j = new C13240a();

            public C13240a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Long invoke() {
                return Long.valueOf(AnimationUtils.currentAnimationTimeMillis());
            }
        }

        public a(Apng apng, @IntRange(from = 1, m76to = 2147483647L) int i, @IntRange(from = 1, m76to = 2147483647L) int i2, int i3, Function0<Long> function0) {
            C12238m.checkNotNullParameter(apng, "apng");
            C12238m.checkNotNullParameter(function0, "currentTimeProvider");
            this.f13633a = apng;
            this.f13634b = i;
            this.f13635c = i2;
            this.f13636d = i3;
            this.f13637e = function0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C5080a(new a(this));
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(a aVar) {
            this(aVar.f13633a.copy(), aVar.f13634b, aVar.f13635c, aVar.f13636d, aVar.f13637e);
            C12238m.checkNotNullParameter(aVar, "apngState");
        }
    }

    @VisibleForTesting
    public C5080a(a aVar) {
        C12238m.checkNotNullParameter(aVar, "apngState");
        this.f13632x = aVar;
        this.f13618j = aVar.f13633a.getDuration();
        int frameCount = this.f13632x.f13633a.getFrameCount();
        this.f13619k = frameCount;
        this.f13620l = C12141k.toList(this.f13632x.f13633a.getFrameDurations());
        this.f13621m = this.f13632x.f13633a.getByteCount();
        this.f13632x.f13633a.getAllFrameByteCount();
        this.f13622n = this.f13632x.f13633a.getLoopCount();
        this.f13632x.f13633a.isRecycled();
        this.f13623o = new Paint(6);
        this.f13624p = new ArrayList();
        this.f13625q = new ArrayList();
        this.f13626r = new int[frameCount];
        a aVar2 = this.f13632x;
        this.f13627s = aVar2.f13634b;
        this.f13628t = aVar2.f13635c;
        for (int i = 1; i < frameCount; i++) {
            int[] iArr = this.f13626r;
            int i2 = i - 1;
            iArr[i] = iArr[i2] + this.f13632x.f13633a.getFrameDurations()[i2];
        }
        Rect bounds = getBounds();
        a aVar3 = this.f13632x;
        bounds.set(0, 0, aVar3.f13634b, aVar3.f13635c);
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    public static final C5080a m7121a(InputStream inputStream, @IntRange(from = 1, m76to = 2147483647L) Integer num, @IntRange(from = 1, m76to = 2147483647L) Integer num2) throws ApngException {
        C12238m.checkNotNullParameter(inputStream, "stream");
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
            Apng apngDecode = Apng.INSTANCE.decode(inputStream);
            return new C5080a(new a(apngDecode, num != null ? num.intValue() : apngDecode.getWidth(), num2 != null ? num2.intValue() : apngDecode.getHeight(), i, a.C13240a.f13638j));
        }
        throw new IllegalArgumentException(("Can not specify 0 or negative as height value. height = " + num2).toString());
    }

    /* JADX INFO: renamed from: b */
    public final boolean m7122b() {
        return this.f13622n != 0 && m7124d() > this.f13622n - 1;
    }

    /* JADX INFO: renamed from: c */
    public final int m7123c() {
        int i;
        int i2 = 0;
        long j = (this.f13630v % ((long) this.f13618j)) + ((long) (m7122b() ? this.f13618j : 0));
        int i3 = this.f13619k - 1;
        while (true) {
            i = (i2 + i3) / 2;
            int[] iArr = this.f13626r;
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
        this.f13624p.clear();
    }

    /* JADX INFO: renamed from: d */
    public final int m7124d() {
        return (int) (this.f13630v / ((long) this.f13618j));
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
        C12238m.checkNotNullParameter(canvas, "canvas");
        if (this.f13629u) {
            int iM7123c = m7123c();
            long jLongValue = this.f13632x.f13637e.invoke().longValue();
            Long l = this.f13631w;
            this.f13630v = l == null ? this.f13630v : (this.f13630v + jLongValue) - l.longValue();
            this.f13631w = Long.valueOf(jLongValue);
            boolean z4 = m7123c() != iM7123c;
            if (this.f13629u) {
                if (!(m7123c() == 0)) {
                    if (m7123c() == this.f13619k - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.f13622n == 0 && m7124d() >= this.f13622n - 1) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3 && z4) {
                            while (r0.hasNext()) {
                                interfaceC5081b.m7126b(this, m7124d() + 2);
                                interfaceC5081b.m7125a(this, m7124d() + 1);
                            }
                        }
                    }
                } else if ((m7124d() == 0) && l == null) {
                    Iterator<T> it = this.f13624p.iterator();
                    while (it.hasNext()) {
                        ((Animatable2Compat.AnimationCallback) it.next()).onAnimationStart(this);
                    }
                } else {
                    if (m7123c() == this.f13619k - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.f13622n == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            for (InterfaceC5081b interfaceC5081b : this.f13625q) {
                                interfaceC5081b.m7126b(this, m7124d() + 2);
                                interfaceC5081b.m7125a(this, m7124d() + 1);
                            }
                        }
                    }
                }
            }
            if (m7122b()) {
                this.f13629u = false;
                Iterator<T> it2 = this.f13624p.iterator();
                while (it2.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) it2.next()).onAnimationEnd(this);
                }
            }
        }
        Apng apng = this.f13632x.f13633a;
        int iM7123c2 = m7123c();
        Rect bounds = getBounds();
        C12238m.checkNotNullExpressionValue(bounds, "bounds");
        apng.drawWithIndex(iM7123c2, canvas, null, bounds, this.f13623o);
        if (this.f13629u) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13632x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f13628t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f13627s;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f13629u;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f13632x = new a(this.f13632x);
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        C12238m.checkNotNullParameter(animationCallback, "callback");
        this.f13624p.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f13623o.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13623o.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f13629u = true;
        this.f13631w = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f13629u = false;
        invalidateSelf();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        C12238m.checkNotNullParameter(animationCallback, "callback");
        return this.f13624p.remove(animationCallback);
    }
}
