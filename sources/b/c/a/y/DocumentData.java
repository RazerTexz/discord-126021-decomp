package b.c.a.y;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.c, reason: use source file name */
/* JADX INFO: compiled from: DocumentData.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f405b;
    public final float c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;

    @ColorInt
    public final int h;

    @ColorInt
    public final int i;
    public final float j;
    public final boolean k;

    public DocumentData(String str, String str2, float f, int i, int i2, float f2, float f3, @ColorInt int i3, @ColorInt int i4, float f4, boolean z2) {
        this.a = str;
        this.f405b = str2;
        this.c = f;
        this.d = i;
        this.e = i2;
        this.f = f2;
        this.g = f3;
        this.h = i3;
        this.i = i4;
        this.j = f4;
        this.k = z2;
    }

    public int hashCode() {
        int iH = ((b.h(this.d) + (((int) (outline.m(this.f405b, this.a.hashCode() * 31, 31) + this.c)) * 31)) * 31) + this.e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f);
        return (((iH * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.h;
    }
}
