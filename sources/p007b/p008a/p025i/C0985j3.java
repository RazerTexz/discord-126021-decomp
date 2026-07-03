package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.j3 */
/* JADX INFO: compiled from: ViewServerSettingsIconNameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0985j3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f973a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f974b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextInputLayout f975c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f976d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f977e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f978f;

    public C0985j3(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f973a = constraintLayout;
        this.f974b = textView;
        this.f975c = textInputLayout;
        this.f976d = simpleDraweeView;
        this.f977e = textView2;
        this.f978f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f973a;
    }
}
