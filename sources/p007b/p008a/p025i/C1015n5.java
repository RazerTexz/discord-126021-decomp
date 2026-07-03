package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* JADX INFO: renamed from: b.a.i.n5 */
/* JADX INFO: compiled from: WidgetHomePanelRightBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1015n5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f1089a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final RoundedRelativeLayout f1090b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FragmentContainerView f1091c;

    public C1015n5(@NonNull FrameLayout frameLayout, @NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3) {
        this.f1089a = frameLayout;
        this.f1090b = roundedRelativeLayout;
        this.f1091c = fragmentContainerView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1089a;
    }
}
