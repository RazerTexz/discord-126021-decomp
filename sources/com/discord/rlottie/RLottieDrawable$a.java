package com.discord.rlottie;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.util.Log;
import d0.t.k;
import d0.z.d.m;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class RLottieDrawable$a implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public RLottieDrawable$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ThreadPoolExecutor threadPoolExecutor;
        switch (this.j) {
            case 0:
                Objects.requireNonNull((RLottieDrawable) this.k);
                if (((RLottieDrawable) this.k).Q == 0) {
                    RLottieDrawable.j.post(((RLottieDrawable) this.k).S);
                    return;
                }
                if (((RLottieDrawable) this.k).E == null) {
                    try {
                        RLottieDrawable rLottieDrawable = (RLottieDrawable) this.k;
                        rLottieDrawable.E = Bitmap.createBitmap(rLottieDrawable.p, rLottieDrawable.q, Bitmap$Config.ARGB_8888);
                    } catch (Throwable th) {
                        Log.e("RLottieDrawable", "Error Loading Frame in Runnable", th);
                    }
                    break;
                }
                if (((RLottieDrawable) this.k).E != null) {
                    try {
                        if (!((RLottieDrawable) this.k).v.isEmpty()) {
                            for (Map$Entry<String, Integer> map$Entry : ((RLottieDrawable) this.k).v.entrySet()) {
                                RLottieDrawable.o.setLayerColor(((RLottieDrawable) this.k).Q, map$Entry.getKey(), map$Entry.getValue().intValue());
                            }
                            ((RLottieDrawable) this.k).v.clear();
                        }
                        break;
                    } catch (Exception unused) {
                    }
                    RLottieDrawable rLottieDrawable2 = (RLottieDrawable) this.k;
                    Integer[] numArr = rLottieDrawable2.t;
                    if (numArr != null) {
                        RLottieDrawable.o.replaceColors(rLottieDrawable2.Q, k.toIntArray(numArr));
                    }
                    RLottieDrawable rLottieDrawable3 = (RLottieDrawable) this.k;
                    rLottieDrawable3.t = null;
                    try {
                        RLottieDrawable$Companion rLottieDrawable$Companion = RLottieDrawable.o;
                        long j = rLottieDrawable3.Q;
                        RLottieDrawable rLottieDrawable4 = (RLottieDrawable) this.k;
                        int i = rLottieDrawable4.I;
                        Bitmap bitmap = rLottieDrawable4.E;
                        if (bitmap == null) {
                            m.throwNpe();
                        }
                        RLottieDrawable rLottieDrawable5 = (RLottieDrawable) this.k;
                        int i2 = rLottieDrawable5.p;
                        int i3 = rLottieDrawable5.q;
                        Bitmap bitmap2 = rLottieDrawable5.E;
                        if (bitmap2 == null) {
                            m.throwNpe();
                        }
                        if (rLottieDrawable$Companion.getFrame(j, i, bitmap, i2, i3, bitmap2.getRowBytes(), true) == -1) {
                            RLottieDrawable.j.post(((RLottieDrawable) this.k).S);
                            return;
                        }
                        RLottieDrawable rLottieDrawable6 = (RLottieDrawable) this.k;
                        int i4 = 2;
                        if (rLottieDrawable6.r[2] != 0) {
                            RLottieDrawable.j.post(rLottieDrawable6.W);
                            ((RLottieDrawable) this.k).r[2] = 0;
                        }
                        RLottieDrawable rLottieDrawable7 = (RLottieDrawable) this.k;
                        rLottieDrawable7.D = rLottieDrawable7.E;
                        RLottieDrawable rLottieDrawable8 = (RLottieDrawable) this.k;
                        if (!rLottieDrawable8.J) {
                            i4 = 1;
                        }
                        int i5 = rLottieDrawable8.I + i4;
                        if (i5 >= rLottieDrawable8.r[0]) {
                            RLottieDrawable$PlaybackMode rLottieDrawable$PlaybackMode = rLottieDrawable8.w;
                            if (rLottieDrawable$PlaybackMode == RLottieDrawable$PlaybackMode.LOOP) {
                                rLottieDrawable8.I = 0;
                                rLottieDrawable8.f2769z = false;
                            } else if (rLottieDrawable$PlaybackMode == RLottieDrawable$PlaybackMode.ONCE) {
                                rLottieDrawable8.I = 0;
                                rLottieDrawable8.f2769z = true;
                                ((RLottieDrawable) this.k).f2767x++;
                            } else {
                                rLottieDrawable8.f2769z = true;
                            }
                        } else if (rLottieDrawable8.w == RLottieDrawable$PlaybackMode.FREEZE) {
                            rLottieDrawable8.f2769z = true;
                            ((RLottieDrawable) this.k).f2767x++;
                        } else {
                            rLottieDrawable8.I = i5;
                            rLottieDrawable8.f2769z = false;
                        }
                    } catch (Exception e) {
                        Log.e("RLottieDrawable", "Error loading frame", e);
                    }
                }
                RLottieDrawable.j.post(((RLottieDrawable) this.k).U);
                return;
            case 1:
                RLottieDrawable rLottieDrawable9 = (RLottieDrawable) this.k;
                rLottieDrawable9.G = true;
                rLottieDrawable9.c();
                RLottieDrawable.a((RLottieDrawable) this.k);
                return;
            case 2:
                RLottieDrawable rLottieDrawable10 = (RLottieDrawable) this.k;
                rLottieDrawable10.A = null;
                RLottieDrawable.a(rLottieDrawable10);
                return;
            case 3:
                Objects.requireNonNull((RLottieDrawable) this.k);
                Objects.requireNonNull((RLottieDrawable) this.k);
                if (((RLottieDrawable) this.k).Q != 0 && (threadPoolExecutor = RLottieDrawable.n) != null) {
                    RLottieDrawable rLottieDrawable11 = (RLottieDrawable) this.k;
                    Runnable runnable = rLottieDrawable11.V;
                    rLottieDrawable11.A = runnable;
                    threadPoolExecutor.execute(runnable);
                }
                RLottieDrawable.a((RLottieDrawable) this.k);
                return;
            case 4:
                RLottieDrawable rLottieDrawable12 = (RLottieDrawable) this.k;
                if (rLottieDrawable12.A != null) {
                    RLottieDrawable$Companion rLottieDrawable$Companion2 = RLottieDrawable.o;
                    long j2 = rLottieDrawable12.Q;
                    RLottieDrawable rLottieDrawable13 = (RLottieDrawable) this.k;
                    rLottieDrawable$Companion2.createCache(j2, rLottieDrawable13.p, rLottieDrawable13.q);
                    RLottieDrawable.j.post(((RLottieDrawable) this.k).T);
                    return;
                }
                return;
            case 5:
                throw null;
            case 6:
                RLottieDrawable rLottieDrawable14 = (RLottieDrawable) this.k;
                rLottieDrawable14.B = null;
                RLottieDrawable.a(rLottieDrawable14);
                return;
            default:
                throw null;
        }
    }
}
