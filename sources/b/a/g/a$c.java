package b.a.g;

import android.graphics.Color;

/* JADX INFO: compiled from: ColorCutQuantizer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$c {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f69b;
    public int c;
    public int d;
    public int e;
    public int f;
    public final int g;
    public int h;
    public final /* synthetic */ a i;

    public a$c(a aVar, int i, int i2) {
        this.i = aVar;
        this.g = i;
        this.h = i2;
        a();
    }

    public final void a() {
        this.e = 255;
        this.c = 255;
        this.a = 255;
        this.f = 0;
        this.d = 0;
        this.f69b = 0;
        int i = this.g;
        int i2 = this.h;
        if (i > i2) {
            return;
        }
        while (true) {
            int i3 = this.i.c[i];
            int iRed = Color.red(i3);
            int iGreen = Color.green(i3);
            int iBlue = Color.blue(i3);
            if (iRed > this.f69b) {
                this.f69b = iRed;
            }
            if (iRed < this.a) {
                this.a = iRed;
            }
            if (iGreen > this.d) {
                this.d = iGreen;
            }
            if (iGreen < this.c) {
                this.c = iGreen;
            }
            if (iBlue > this.f) {
                this.f = iBlue;
            }
            if (iBlue < this.e) {
                this.e = iBlue;
            }
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    public final int b() {
        return ((this.f - this.e) + 1) * ((this.d - this.c) + 1) * ((this.f69b - this.a) + 1);
    }
}
