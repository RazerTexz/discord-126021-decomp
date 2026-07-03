package p007b.p008a.p025i;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.v5 */
/* JADX INFO: compiled from: WidgetRemoteAuthNotFoundBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1071v5 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final LinearLayout f1326a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final MaterialButton f1327b;

    public C1071v5(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton) {
        this.f1326a = linearLayout;
        this.f1327b = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1326a;
    }
}
