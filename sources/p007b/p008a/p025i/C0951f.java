package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.f */
/* JADX INFO: compiled from: CardSegmentViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0951f implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f827a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f828b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f829c;

    public C0951f(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f827a = view;
        this.f828b = textView;
        this.f829c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f827a;
    }
}
