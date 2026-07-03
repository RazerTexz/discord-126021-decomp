package p007b.p225i.p226a.p341g.p347f;

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
import java.lang.reflect.Constructor;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.g.f.a */
/* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class C4413a {

    /* JADX INFO: renamed from: a */
    public static boolean f11700a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public static Constructor<StaticLayout> f11701b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public static Object f11702c;

    /* JADX INFO: renamed from: d */
    public CharSequence f11703d;

    /* JADX INFO: renamed from: e */
    public final TextPaint f11704e;

    /* JADX INFO: renamed from: f */
    public final int f11705f;

    /* JADX INFO: renamed from: g */
    public int f11706g;

    /* JADX INFO: renamed from: k */
    public boolean f11710k;

    /* JADX INFO: renamed from: h */
    public Layout.Alignment f11707h = Layout.Alignment.ALIGN_NORMAL;

    /* JADX INFO: renamed from: i */
    public int f11708i = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: j */
    public boolean f11709j = true;

    /* JADX INFO: renamed from: l */
    @Nullable
    public TextUtils.TruncateAt f11711l = null;

    /* JADX INFO: renamed from: b.i.a.g.f.a$a */
    /* JADX INFO: compiled from: StaticLayoutBuilderCompat.java */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public a(Throwable th) {
            StringBuilder sbM833U = C1643a.m833U("Error thrown initializing StaticLayout ");
            sbM833U.append(th.getMessage());
            super(sbM833U.toString(), th);
        }
    }

    public C4413a(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f11703d = charSequence;
        this.f11704e = textPaint;
        this.f11705f = i;
        this.f11706g = charSequence.length();
    }

    /* JADX INFO: renamed from: a */
    public StaticLayout m6116a() throws a {
        if (this.f11703d == null) {
            this.f11703d = "";
        }
        int iMax = Math.max(0, this.f11705f);
        CharSequence charSequenceEllipsize = this.f11703d;
        if (this.f11708i == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f11704e, iMax, this.f11711l);
        }
        int iMin = Math.min(charSequenceEllipsize.length(), this.f11706g);
        this.f11706g = iMin;
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            if (this.f11710k) {
                this.f11707h = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, 0, iMin, this.f11704e, iMax);
            builderObtain.setAlignment(this.f11707h);
            builderObtain.setIncludePad(this.f11709j);
            builderObtain.setTextDirection(this.f11710k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f11711l;
            if (truncateAt != null) {
                builderObtain.setEllipsize(truncateAt);
            }
            builderObtain.setMaxLines(this.f11708i);
            return builderObtain.build();
        }
        if (!f11700a) {
            try {
                f11702c = this.f11710k && i >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f11701b = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f11700a = true;
            } catch (Exception e) {
                throw new a(e);
            }
        }
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f11701b)).newInstance(charSequenceEllipsize, 0, Integer.valueOf(this.f11706g), this.f11704e, Integer.valueOf(iMax), this.f11707h, Preconditions.checkNotNull(f11702c), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f11709j), null, Integer.valueOf(iMax), Integer.valueOf(this.f11708i));
        } catch (Exception e2) {
            throw new a(e2);
        }
    }
}
