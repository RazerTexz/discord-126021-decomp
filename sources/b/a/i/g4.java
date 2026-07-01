package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;

/* JADX INFO: compiled from: ViewUsernameBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class g4 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f120b;

    @NonNull
    public final SimpleDraweeSpanTextView c;

    public g4(@NonNull View view, @NonNull TextView textView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.a = view;
        this.f120b = textView;
        this.c = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
