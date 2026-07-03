package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.e */
/* JADX INFO: compiled from: CameraCapacityDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0943e implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f801a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f802b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f803c;

    public C0943e(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout2) {
        this.f801a = linearLayout;
        this.f802b = textView;
        this.f803c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f801a;
    }
}
