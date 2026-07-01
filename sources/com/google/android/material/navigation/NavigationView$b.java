package com.google.android.material.navigation;

import android.R$id;
import android.app.Activity;
import android.graphics.Color;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import com.google.android.material.internal.ContextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NavigationView$b implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ NavigationView j;

    public NavigationView$b(NavigationView navigationView) {
        this.j = navigationView;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        NavigationView navigationView = this.j;
        navigationView.getLocationOnScreen(NavigationView.access$000(navigationView));
        boolean z2 = NavigationView.access$000(this.j)[1] == 0;
        NavigationView.access$100(this.j).setBehindStatusBar(z2);
        this.j.setDrawTopInsetForeground(z2);
        Activity activity = ContextUtils.getActivity(this.j.getContext());
        if (activity != null) {
            this.j.setDrawBottomInsetForeground((activity.findViewById(R$id.content).getHeight() == this.j.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
        }
    }
}
