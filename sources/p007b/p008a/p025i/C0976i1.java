package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;

/* JADX INFO: renamed from: b.a.i.i1 */
/* JADX INFO: compiled from: ReactionViewBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0976i1 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f941a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f942b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f943c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextSwitcher f944d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final SimpleDraweeSpanTextView f945e;

    public C0976i1(@NonNull View view, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextSwitcher textSwitcher, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView) {
        this.f941a = view;
        this.f942b = textView;
        this.f943c = textView2;
        this.f944d = textSwitcher;
        this.f945e = simpleDraweeSpanTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f941a;
    }
}
