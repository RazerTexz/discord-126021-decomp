package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.e6 */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0950e6 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f823a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f824b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f825c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f826d;

    public C0950e6(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f823a = linearLayout;
        this.f824b = loadingButton;
        this.f825c = textView;
        this.f826d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f823a;
    }
}
