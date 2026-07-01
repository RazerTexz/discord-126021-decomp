package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.x, reason: use source file name */
/* JADX INFO: compiled from: GuildChannelSideBarActionsViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class GuildChannelSideBarActionsViewBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f226b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final MaterialButton e;

    public GuildChannelSideBarActionsViewBinding(@NonNull View view, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull MaterialButton materialButton3, @NonNull MaterialButton materialButton4) {
        this.a = view;
        this.f226b = materialButton;
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
