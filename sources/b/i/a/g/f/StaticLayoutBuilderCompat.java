package b.i.a.g.f;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import b.d.b.a.outline;
import java.lang.reflect.Constructor;

/* JADX INFO: renamed from: b.i.a.g.f.a, reason: use source file name */
/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StaticLayoutBuilderCompat {
    public static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static Constructor<StaticLayout> f1621b;

    @Nullable
    public static Object c;
    public CharSequence d;
    public final TextPaint e;
    public final int f;
    public int g;
    public boolean k;
    public Layout.Alignment h = Layout.Alignment.ALIGN_NORMAL;
    public int i = Integer.MAX_VALUE;
    public boolean j = true;

    @Nullable
    public TextUtils.TruncateAt l = null;

    /* JADX INFO: renamed from: b.i.a.g.f.a$a */
    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public a(Throwable th) {
            StringBuilder sbU = outline.U("Error thrown initializing StaticLayout ");
            sbU.append(th.getMessage());
            super(sbU.toString(), th);
        }
    }

    public StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.d = charSequence;
        this.e = textPaint;
        this.f = i;
        this.g = charSequence.length();
    }

    public StaticLayout a() throws a {
        if (this.d == null) {
            this.d = "";
        }
        int iMax = Math.max(0, this.f);
        CharSequence charSequenceEllipsize = this.d;
        if (this.i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.e, iMax, this.l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.g);
        this.g = iMin;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (this.k) {
                this.h = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, this.e, iMax);
            builderObtain.setAlignment(this.h);
            builderObtain.setIncludePad(this.j);
            builderObtain.setTextDirection(this.k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.l;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.i);
            return builderObtain.build();
        }
        if (!a) {
            try {
                c = this.k && i >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f1621b = declaredConstructor;
                declaredConstructor.setAccessible(true);
                a = true;
            } catch (Exception e) {
                throw new a(e);
            }
        }
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f1621b)).newInstance(charSequenceEllipsize, 0, Integer.valueOf(this.g), this.e, Integer.valueOf(iMax), this.h, Preconditions.checkNotNull(c), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.j), null, Integer.valueOf(iMax), Integer.valueOf(this.i));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }
}
