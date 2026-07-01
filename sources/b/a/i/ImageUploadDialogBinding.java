package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.b0, reason: use source file name */
/* JADX INFO: compiled from: ImageUploadDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ImageUploadDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f81b;

    @NonNull
    public final TextView c;

    @NonNull
    public final SimpleDraweeView d;

    @NonNull
    public final MaterialButton e;

    public ImageUploadDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull MaterialButton materialButton2) {
        this.a = linearLayout;
        this.f81b = materialButton;
        this.c = textView;
        this.d = simpleDraweeView;
        this.e = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
