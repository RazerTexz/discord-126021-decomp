package androidx.appcompat.view.menu;

import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
public interface MenuView {
    int getWindowAnimations();

    void initialize(MenuBuilder menuBuilder);
}
