package b.a.f.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.f.h.a, reason: use source file name */
/* JADX INFO: compiled from: ViewChipDefaultBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewChipDefaultBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f67b;

    @NonNull
    public final TextView c;

    public ViewChipDefaultBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.a = relativeLayout;
        this.f67b = imageView;
        this.c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
