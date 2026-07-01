package b.a.i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.u4, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputGuardBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatInputGuardBinding implements ViewBinding {

    @NonNull
    public final LinearLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f211b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    public WidgetChatInputGuardBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = linearLayout;
        this.f211b = materialButton;
        this.c = materialButton2;
        this.d = textView;
        this.e = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
