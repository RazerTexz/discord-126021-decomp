package androidx.legacy.app;

import android.R$id;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarDrawerToggle$SetIndicatorInfo {
    public Method mSetHomeActionContentDescription;
    public Method mSetHomeAsUpIndicator;
    public ImageView mUpIndicatorView;

    public ActionBarDrawerToggle$SetIndicatorInfo(Activity activity) {
        try {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", Drawable.class);
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", Integer.TYPE);
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
                this.mUpIndicatorView = (ImageView) childAt;
            }
        }
    }
}
