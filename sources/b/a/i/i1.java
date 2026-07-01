package b.a.i;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* JADX INFO: compiled from: ReactionViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class i1 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f132b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextSwitcher d;

    @NonNull
    public final SimpleDraweeSpanTextView e;

    public i1(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextSwitcher textSwitcher, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.a = view;
        this.f132b = textView;
        this.c = textView2;
        this.d = textSwitcher;
        this.e = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
