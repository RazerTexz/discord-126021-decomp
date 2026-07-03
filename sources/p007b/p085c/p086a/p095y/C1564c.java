package p007b.p085c.p086a.p095y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.c */
/* JADX INFO: compiled from: DocumentData.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C1564c {

    /* JADX INFO: renamed from: a */
    public final String f2693a;

    /* JADX INFO: renamed from: b */
    public final String f2694b;

    /* JADX INFO: renamed from: c */
    public final float f2695c;

    /* JADX INFO: renamed from: d */
    public final int f2696d;

    /* JADX INFO: renamed from: e */
    public final int f2697e;

    /* JADX INFO: renamed from: f */
    public final float f2698f;

    /* JADX INFO: renamed from: g */
    public final float f2699g;

    /* JADX INFO: renamed from: h */
    @ColorInt
    public final int f2700h;

    /* JADX INFO: renamed from: i */
    @ColorInt
    public final int f2701i;

    /* JADX INFO: renamed from: j */
    public final float f2702j;

    /* JADX INFO: renamed from: k */
    public final boolean f2703k;

    public C1564c(String str, String str2, float f, int i, int i2, float f2, float f3, @ColorInt int i3, @ColorInt int i4, float f4, boolean z2) {
        this.f2693a = str;
        this.f2694b = str2;
        this.f2695c = f;
        this.f2696d = i;
        this.f2697e = i2;
        this.f2698f = f2;
        this.f2699g = f3;
        this.f2700h = i3;
        this.f2701i = i4;
        this.f2702j = f4;
        this.f2703k = z2;
    }

    public int hashCode() {
        int iM758h = ((C1563b.m758h(this.f2696d) + (((int) (C1643a.m863m(this.f2694b, this.f2693a.hashCode() * 31, 31) + this.f2695c)) * 31)) * 31) + this.f2697e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f2698f);
        return (((iM758h * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f2700h;
    }
}
