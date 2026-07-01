package b.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.l5, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelLeftBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetHomePanelLeftBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f155b;

    @NonNull
    public final FragmentContainerView c;

    public WidgetHomePanelLeftBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull FrameLayout frameLayout) {
        this.a = relativeLayout;
        this.f155b = textView;
        this.c = fragmentContainerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
