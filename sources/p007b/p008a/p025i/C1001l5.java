package p007b.p008a.p025i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.l5 */
/* JADX INFO: compiled from: WidgetHomePanelLeftBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1001l5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f1035a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1036b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final FragmentContainerView f1037c;

    public C1001l5(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FrameLayout frameLayout) {
        this.f1035a = relativeLayout;
        this.f1036b = textView;
        this.f1037c = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1035a;
    }
}
