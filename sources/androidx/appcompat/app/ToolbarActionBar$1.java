package androidx.appcompat.app;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarActionBar$1 implements Runnable {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$1(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.populateOptionsMenu();
    }
}
