package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* JADX INFO: renamed from: b.a.i.e6, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialogBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialogBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f108b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    public WidgetUrgentMessageDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f108b = loadingButton;
        this.c = textView;
        this.d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
