package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$5 implements Runnable {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$5(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.execPendingActions(true);
    }
}
