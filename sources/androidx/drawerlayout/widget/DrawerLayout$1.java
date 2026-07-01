package androidx.drawerlayout.widget;

import android.view.View;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout$1 implements View$OnApplyWindowInsetsListener {
    public final /* synthetic */ DrawerLayout this$0;

    public DrawerLayout$1(DrawerLayout drawerLayout) {
        this.this$0 = drawerLayout;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ((DrawerLayout) view).setChildInsets(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
        return windowInsets.consumeSystemWindowInsets();
    }
}
