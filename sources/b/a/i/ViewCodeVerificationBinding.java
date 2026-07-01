package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: renamed from: b.a.i.e2, reason: use source file name */
/* JADX INFO: compiled from: ViewCodeVerificationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewCodeVerificationBinding implements ViewBinding {

    @NonNull
    public final FlexboxLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlexboxLayout f104b;

    public ViewCodeVerificationBinding(@NonNull FlexboxLayout flexboxLayout, @NonNull FlexboxLayout flexboxLayout2) {
        this.a = flexboxLayout;
        this.f104b = flexboxLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
