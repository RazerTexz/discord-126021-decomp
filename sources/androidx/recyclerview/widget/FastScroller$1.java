package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class FastScroller$1 implements Runnable {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$1(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.hide(500);
    }
}
