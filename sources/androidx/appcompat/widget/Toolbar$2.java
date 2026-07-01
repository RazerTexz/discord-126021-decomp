package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar$2 implements Runnable {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$2(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.showOverflowMenu();
    }
}
