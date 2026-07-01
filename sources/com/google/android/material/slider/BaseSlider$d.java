package com.google.android.material.slider;

/* JADX INFO: loaded from: classes3.dex */
public class BaseSlider$d implements Runnable {
    public int j = -1;
    public final /* synthetic */ BaseSlider k;

    public BaseSlider$d(BaseSlider baseSlider, BaseSlider$a baseSlider$a) {
        this.k = baseSlider;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseSlider.access$300(this.k).sendEventForVirtualView(this.j, 4);
    }
}
