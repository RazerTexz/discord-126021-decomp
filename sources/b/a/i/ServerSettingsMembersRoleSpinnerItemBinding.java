package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.k1, reason: use source file name */
/* JADX INFO: compiled from: ServerSettingsMembersRoleSpinnerItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ServerSettingsMembersRoleSpinnerItemBinding implements ViewBinding {

    @NonNull
    public final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f145b;

    public ServerSettingsMembersRoleSpinnerItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.a = textView;
        this.f145b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
