package androidx.appcompat.app;

import android.R$id;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggleHoneycomb$SetIndicatorInfo {
    public Method setHomeActionContentDescription;
    public Method setHomeAsUpIndicator;
    public ImageView upIndicatorView;

    public ActionBarDrawerToggleHoneycomb$SetIndicatorInfo(Activity activity) {
        try {
            this.setHomeAsUpIndicator = android.app.ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.setHomeActionContentDescription = android.app.ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
            View viewFindViewById = activity.findViewById(R$id.home);
            if (viewFindViewById == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            if (viewGroup.getChildCount() != 2) {
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
            if (childAt instanceof ImageView) {
                this.upIndicatorView = (ImageView) childAt;
            }
        }
    }
}
