package com.google.android.material.progressindicator;

/* JADX INFO: loaded from: classes3.dex */
public class BaseProgressIndicator$a implements Runnable {
    public final /* synthetic */ BaseProgressIndicator j;

    public BaseProgressIndicator$a(BaseProgressIndicator baseProgressIndicator) {
        this.j = baseProgressIndicator;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseProgressIndicator.access$000(this.j);
    }
}
