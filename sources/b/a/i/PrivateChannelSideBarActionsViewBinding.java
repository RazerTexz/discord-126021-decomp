package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.g1, reason: use source file name */
/* JADX INFO: compiled from: PrivateChannelSideBarActionsViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateChannelSideBarActionsViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f118b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final MaterialButton e;

    public PrivateChannelSideBarActionsViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4) {
        this.a = view;
        this.f118b = materialButton;
        this.c = materialButton2;
        this.d = materialButton3;
        this.e = materialButton4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
