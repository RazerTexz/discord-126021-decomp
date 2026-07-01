package b.f.j.d;

import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.f.j.d.e, reason: use source file name */
/* JADX INFO: compiled from: ResizeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class ResizeOptions {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f566b;
    public final float c;
    public final float d;

    public ResizeOptions(int i, int i2) {
        AnimatableValueParser.i(Boolean.valueOf(i > 0));
        AnimatableValueParser.i(Boolean.valueOf(i2 > 0));
        this.a = i;
        this.f566b = i2;
        this.c = 2048.0f;
        this.d = 0.6666667f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        return this.a == resizeOptions.a && this.f566b == resizeOptions.f566b;
    }

    public int hashCode() {
        return AnimatableValueParser.J0(this.a, this.f566b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.a), Integer.valueOf(this.f566b));
    }
}
