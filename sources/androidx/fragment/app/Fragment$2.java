package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class Fragment$2 implements Runnable {
    public final /* synthetic */ Fragment this$0;

    public Fragment$2(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.callStartTransitionListener(false);
    }
}
