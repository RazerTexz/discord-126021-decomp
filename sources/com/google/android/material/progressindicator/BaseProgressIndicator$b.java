package com.google.android.material.progressindicator;

/* JADX INFO: loaded from: classes3.dex */
public class BaseProgressIndicator$b implements Runnable {
    public final /* synthetic */ BaseProgressIndicator j;

    public BaseProgressIndicator$b(BaseProgressIndicator baseProgressIndicator) {
        this.j = baseProgressIndicator;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseProgressIndicator.access$100(this.j);
        BaseProgressIndicator.access$202(this.j, -1L);
    }
}
