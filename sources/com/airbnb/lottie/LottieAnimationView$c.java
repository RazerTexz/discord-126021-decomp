package com.airbnb.lottie;

import b.c.a.l;

/* JADX INFO: loaded from: classes.dex */
public class LottieAnimationView$c implements l<Throwable> {
    public final /* synthetic */ LottieAnimationView a;

    public LottieAnimationView$c(LottieAnimationView lottieAnimationView) {
        this.a = lottieAnimationView;
    }

    @Override // b.c.a.l
    public void a(Throwable th) {
        Throwable th2 = th;
        LottieAnimationView lottieAnimationView = this.a;
        int i = lottieAnimationView.o;
        if (i != 0) {
            lottieAnimationView.setImageResource(i);
        }
        l<Throwable> lVar = this.a.n;
        if (lVar == null) {
            String str = LottieAnimationView.j;
            lVar = LottieAnimationView.k;
        }
        lVar.a(th2);
    }
}
