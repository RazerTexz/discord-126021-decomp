package androidx.appcompat.app;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle$1 implements View$OnClickListener {
    public final /* synthetic */ ActionBarDrawerToggle this$0;

    public ActionBarDrawerToggle$1(ActionBarDrawerToggle actionBarDrawerToggle) {
        this.this$0 = actionBarDrawerToggle;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ActionBarDrawerToggle actionBarDrawerToggle = this.this$0;
        if (actionBarDrawerToggle.mDrawerIndicatorEnabled) {
            actionBarDrawerToggle.toggle();
            return;
        }
        View$OnClickListener view$OnClickListener = actionBarDrawerToggle.mToolbarNavigationClickListener;
        if (view$OnClickListener != null) {
            view$OnClickListener.onClick(view);
        }
    }
}
