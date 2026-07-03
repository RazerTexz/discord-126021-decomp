package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;

/* JADX INFO: renamed from: b.a.i.g4 */
/* JADX INFO: compiled from: ViewUsernameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0964g4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f874a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f875b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f876c;

    public C0964g4(@NonNull View view, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.f874a = view;
        this.f875b = textView;
        this.f876c = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f874a;
    }
}
