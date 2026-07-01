package b.a.i;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: renamed from: b.a.i.j5, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelCenterChatBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelCenterChatBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f142b;

    @NonNull
    public final WidgetHomePanelCenterContentUnreadBinding c;

    @NonNull
    public final FragmentContainerView d;

    @NonNull
    public final FragmentContainerView e;

    public WidgetHomePanelCenterChatBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull WidgetHomePanelCenterContentUnreadBinding widgetHomePanelCenterContentUnreadBinding, @NonNull View view, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull FragmentContainerView fragmentContainerView5, @NonNull ConstraintLayout constraintLayout2, @NonNull FragmentContainerView fragmentContainerView6, @NonNull FragmentContainerView fragmentContainerView7) {
        this.a = constraintLayout;
        this.f142b = viewStub2;
        this.c = widgetHomePanelCenterContentUnreadBinding;
        this.d = fragmentContainerView;
        this.e = fragmentContainerView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
