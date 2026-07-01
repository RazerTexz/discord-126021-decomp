package androidx.appcompat.widget;

/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow$ListSelectorHider implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$ListSelectorHider(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.clearListSelection();
    }
}
