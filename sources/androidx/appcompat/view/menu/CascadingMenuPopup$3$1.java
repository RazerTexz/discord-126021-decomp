package androidx.appcompat.view.menu;

import android.view.MenuItem;

/* JADX INFO: loaded from: classes.dex */
public class CascadingMenuPopup$3$1 implements Runnable {
    public final /* synthetic */ CascadingMenuPopup$3 this$1;
    public final /* synthetic */ MenuItem val$item;
    public final /* synthetic */ MenuBuilder val$menu;
    public final /* synthetic */ CascadingMenuPopup$CascadingMenuInfo val$nextInfo;

    public CascadingMenuPopup$3$1(CascadingMenuPopup$3 cascadingMenuPopup$3, CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo, MenuItem menuItem, MenuBuilder menuBuilder) {
        this.this$1 = cascadingMenuPopup$3;
        this.val$nextInfo = cascadingMenuPopup$CascadingMenuInfo;
        this.val$item = menuItem;
        this.val$menu = menuBuilder;
    }

    @Override // java.lang.Runnable
    public void run() {
        CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo = this.val$nextInfo;
        if (cascadingMenuPopup$CascadingMenuInfo != null) {
            this.this$1.this$0.mShouldCloseImmediately = true;
            cascadingMenuPopup$CascadingMenuInfo.menu.close(false);
            this.this$1.this$0.mShouldCloseImmediately = false;
        }
        if (this.val$item.isEnabled() && this.val$item.hasSubMenu()) {
            this.val$menu.performItemAction(this.val$item, 4);
        }
    }
}
