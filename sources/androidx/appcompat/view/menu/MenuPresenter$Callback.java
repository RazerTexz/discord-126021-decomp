package androidx.appcompat.view.menu;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface MenuPresenter$Callback {
    void onCloseMenu(@NonNull MenuBuilder menuBuilder, boolean z2);

    boolean onOpenSubMenu(@NonNull MenuBuilder menuBuilder);
}
