package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;

/* JADX INFO: renamed from: b.a.i.i5 */
/* JADX INFO: compiled from: WidgetHomePanelCenterBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0980i5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RoundedRelativeLayout f960a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FragmentContainerView f961b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C0987j5 f962c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FragmentContainerView f963d;

    public C0980i5(@NonNull RoundedRelativeLayout roundedRelativeLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull C0987j5 c0987j5, @NonNull FragmentContainerView fragmentContainerView2) {
        this.f960a = roundedRelativeLayout;
        this.f961b = fragmentContainerView;
        this.f962c = c0987j5;
        this.f963d = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f960a;
    }
}
