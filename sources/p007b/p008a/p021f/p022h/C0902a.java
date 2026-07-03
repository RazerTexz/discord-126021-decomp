package p007b.p008a.p021f.p022h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.f.h.a */
/* JADX INFO: compiled from: ViewChipDefaultBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0902a implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f623a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ImageView f624b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f625c;

    public C0902a(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f623a = relativeLayout;
        this.f624b = imageView;
        this.f625c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f623a;
    }
}
