package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.b0 */
/* JADX INFO: compiled from: ImageUploadDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0920b0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f691a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f692b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f693c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final SimpleDraweeView f694d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialButton f695e;

    public C0920b0(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton2) {
        this.f691a = linearLayout;
        this.f692b = materialButton;
        this.f693c = textView;
        this.f694d = simpleDraweeView;
        this.f695e = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f691a;
    }
}
