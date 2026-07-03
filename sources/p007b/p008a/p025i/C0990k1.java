package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.k1 */
/* JADX INFO: compiled from: ServerSettingsMembersRoleSpinnerItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0990k1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TextView f996a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f997b;

    public C0990k1(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f996a = textView;
        this.f997b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f996a;
    }
}
