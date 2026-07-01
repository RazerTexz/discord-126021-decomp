package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.j3, reason: use source file name */
/* JADX INFO: compiled from: ViewServerSettingsIconNameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewServerSettingsIconNameBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f140b;

    @NonNull
    public final TextInputLayout c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public ViewServerSettingsIconNameBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = constraintLayout;
        this.f140b = textView;
        this.c = textInputLayout;
        this.d = simpleDraweeView;
        this.e = textView2;
        this.f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
