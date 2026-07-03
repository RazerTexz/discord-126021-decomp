package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.w4 */
/* JADX INFO: compiled from: WidgetChatInputPermReqFilesBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1077w4 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1356a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f1357b;

    public C1077w4(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView) {
        this.f1356a = linearLayout;
        this.f1357b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1356a;
    }
}
