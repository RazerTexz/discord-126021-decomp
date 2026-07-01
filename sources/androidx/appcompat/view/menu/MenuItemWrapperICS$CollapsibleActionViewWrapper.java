package androidx.appcompat.view.menu;

import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.CollapsibleActionView;

/* JADX INFO: loaded from: classes.dex */
public class MenuItemWrapperICS$CollapsibleActionViewWrapper extends FrameLayout implements CollapsibleActionView {
    public final android.view.CollapsibleActionView mWrappedView;

    /* JADX WARN: Multi-variable type inference failed */
    public MenuItemWrapperICS$CollapsibleActionViewWrapper(View view) {
        super(view.getContext());
        this.mWrappedView = (android.view.CollapsibleActionView) view;
        addView(view);
    }

    public View getWrappedView() {
        return (View) this.mWrappedView;
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewCollapsed() {
        this.mWrappedView.onActionViewCollapsed();
    }

    @Override // androidx.appcompat.view.CollapsibleActionView
    public void onActionViewExpanded() {
        this.mWrappedView.onActionViewExpanded();
    }
}
