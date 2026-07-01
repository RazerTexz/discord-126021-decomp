package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: CardSegmentViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f109b;

    @NonNull
    public final TextView c;

    public f(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = view;
        this.f109b = textView;
        this.c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
