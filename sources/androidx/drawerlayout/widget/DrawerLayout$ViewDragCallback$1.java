package androidx.drawerlayout.widget;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout$ViewDragCallback$1 implements Runnable {
    public final /* synthetic */ DrawerLayout$ViewDragCallback this$1;

    public DrawerLayout$ViewDragCallback$1(DrawerLayout$ViewDragCallback drawerLayout$ViewDragCallback) {
        this.this$1 = drawerLayout$ViewDragCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$1.peekDrawer();
    }
}
