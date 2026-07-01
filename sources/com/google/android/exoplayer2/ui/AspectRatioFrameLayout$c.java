package com.google.android.exoplayer2.ui;

/* JADX INFO: loaded from: classes3.dex */
public final class AspectRatioFrameLayout$c implements Runnable {
    public float j;
    public float k;
    public boolean l;
    public boolean m;
    public final /* synthetic */ AspectRatioFrameLayout n;

    public AspectRatioFrameLayout$c(AspectRatioFrameLayout aspectRatioFrameLayout, AspectRatioFrameLayout$a aspectRatioFrameLayout$a) {
        this.n = aspectRatioFrameLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m = false;
        AspectRatioFrameLayout$b aspectRatioFrameLayout$b = this.n.k;
        if (aspectRatioFrameLayout$b == null) {
            return;
        }
        aspectRatioFrameLayout$b.a(this.j, this.k, this.l);
    }
}
