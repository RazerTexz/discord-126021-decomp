package p007b.p008a.p025i;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;

/* JADX INFO: renamed from: b.a.i.j5 */
/* JADX INFO: compiled from: WidgetHomePanelCenterChatBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0987j5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f982a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ViewStub f983b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C0994k5 f984c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final FragmentContainerView f985d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final FragmentContainerView f986e;

    public C0987j5(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull C0994k5 c0994k5, @NonNull View view, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FragmentContainerView fragmentContainerView3, @NonNull FragmentContainerView fragmentContainerView4, @NonNull FragmentContainerView fragmentContainerView5, @NonNull ConstraintLayout constraintLayout2, @NonNull FragmentContainerView fragmentContainerView6, @NonNull FragmentContainerView fragmentContainerView7) {
        this.f982a = constraintLayout;
        this.f983b = viewStub2;
        this.f984c = c0994k5;
        this.f985d = fragmentContainerView;
        this.f986e = fragmentContainerView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f982a;
    }
}
