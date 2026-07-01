package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* JADX INFO: renamed from: b.a.i.n5, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelRightBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelRightBinding implements ViewBinding {

    @NonNull
    public final FrameLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundedRelativeLayout f169b;

    @NonNull
    public final FragmentContainerView c;

    public WidgetHomePanelRightBinding(@NonNull FrameLayout frameLayout, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3) {
        this.a = frameLayout;
        this.f169b = roundedRelativeLayout;
        this.c = fragmentContainerView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
