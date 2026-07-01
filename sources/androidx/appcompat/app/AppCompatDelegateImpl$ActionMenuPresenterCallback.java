package androidx.appcompat.app;

import android.view.Window$Callback;
import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatDelegateImpl$ActionMenuPresenterCallback implements MenuPresenter$Callback {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z2) {
        this.this$0.checkCloseActionMenu(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter$Callback
    public boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder) {
        Window$Callback windowCallback = this.this$0.getWindowCallback();
        if (windowCallback == null) {
            return true;
        }
        windowCallback.onMenuOpened(108, menuBuilder);
        return true;
    }
}
