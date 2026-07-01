package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.NonNull;
import b.i.a.g.h.a;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;

/* JADX INFO: loaded from: classes3.dex */
public class BaseTransientBottomBar$r implements SwipeDismissBehavior$OnDismissListener {
    public final /* synthetic */ BaseTransientBottomBar a;

    public BaseTransientBottomBar$r(BaseTransientBottomBar baseTransientBottomBar) {
        this.a = baseTransientBottomBar;
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener
    public void onDismiss(@NonNull View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        this.a.dispatchDismiss(0);
    }

    @Override // com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener
    public void onDragStateChanged(int i) {
        if (i == 0) {
            a.b().f(this.a.managerCallback);
        } else if (i == 1 || i == 2) {
            a.b().e(this.a.managerCallback);
        }
    }
}
