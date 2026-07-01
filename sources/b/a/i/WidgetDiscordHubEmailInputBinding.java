package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.a.i.e5, reason: use source file name */
/* JADX INFO: compiled from: WidgetDiscordHubEmailInputBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetDiscordHubEmailInputBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f107b;

    @NonNull
    public final TextInputEditText c;

    @NonNull
    public final TextInputLayout d;

    @NonNull
    public final TextView e;

    @NonNull
    public final TextView f;

    public WidgetDiscordHubEmailInputBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = nestedScrollView;
        this.f107b = linkifiedTextView;
        this.c = textInputEditText;
        this.d = textInputLayout;
        this.e = textView;
        this.f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
