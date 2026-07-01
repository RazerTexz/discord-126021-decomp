package androidx.appcompat.graphics.drawable;

/* JADX INFO: loaded from: classes.dex */
public class DrawableContainer$1 implements Runnable {
    public final /* synthetic */ DrawableContainer this$0;

    public DrawableContainer$1(DrawableContainer drawableContainer) {
        this.this$0 = drawableContainer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.animate(true);
        this.this$0.invalidateSelf();
    }
}
