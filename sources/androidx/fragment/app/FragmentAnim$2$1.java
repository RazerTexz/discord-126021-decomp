package androidx.fragment.app;

/* JADX INFO: loaded from: classes.dex */
public class FragmentAnim$2$1 implements Runnable {
    public final /* synthetic */ FragmentAnim$2 this$0;

    public FragmentAnim$2$1(FragmentAnim$2 fragmentAnim$2) {
        this.this$0 = fragmentAnim$2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.this$0.val$fragment.getAnimatingAway() != null) {
            this.this$0.val$fragment.setAnimatingAway(null);
            FragmentAnim$2 fragmentAnim$2 = this.this$0;
            fragmentAnim$2.val$callback.onComplete(fragmentAnim$2.val$fragment, fragmentAnim$2.val$signal);
        }
    }
}
