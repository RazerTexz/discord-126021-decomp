package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CodeVerificationView;

/* JADX INFO: renamed from: b.a.i.p0 */
/* JADX INFO: compiled from: LayoutContactSyncVerifyPhoneBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1024p0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f1122a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CodeVerificationView f1123b;

    public C1024p0(@NonNull ConstraintLayout constraintLayout, @NonNull CodeVerificationView codeVerificationView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f1122a = constraintLayout;
        this.f1123b = codeVerificationView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1122a;
    }
}
