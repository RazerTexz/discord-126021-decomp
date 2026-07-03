package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: renamed from: b.a.i.h */
/* JADX INFO: compiled from: ConnectedAccountActionsDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0967h implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f891a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f892b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f893c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f894d;

    public C0967h(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f891a = linearLayout;
        this.f892b = textView;
        this.f893c = textView2;
        this.f894d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f891a;
    }
}
