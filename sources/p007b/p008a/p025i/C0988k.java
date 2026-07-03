package p007b.p008a.p025i;

import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.k */
/* JADX INFO: compiled from: DialogDatePickerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0988k implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f987a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f988b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final DatePicker f989c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f990d;

    public C0988k(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull DatePicker datePicker, @NonNull TextView textView) {
        this.f987a = linearLayout;
        this.f988b = materialButton;
        this.f989c = datePicker;
        this.f990d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f987a;
    }
}
