package com.google.android.material.snackbar;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.a.g.h.a;
import b.i.a.g.h.a$b;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class BaseTransientBottomBar$BehaviorDelegate {
    private a$b managerCallback;

    public BaseTransientBottomBar$BehaviorDelegate(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
        swipeDismissBehavior.setStartAlphaSwipeDistance(0.1f);
        swipeDismissBehavior.setEndAlphaSwipeDistance(0.6f);
        swipeDismissBehavior.setSwipeDirection(0);
    }

    public boolean canSwipeDismissView(View view) {
        return view instanceof BaseTransientBottomBar$SnackbarBaseLayout;
    }

    public void onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                a.b().e(this.managerCallback);
            }
        } else if (actionMasked == 1 || actionMasked == 3) {
            a.b().f(this.managerCallback);
        }
    }

    public void setBaseTransientBottomBar(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
        this.managerCallback = baseTransientBottomBar.managerCallback;
    }
}
