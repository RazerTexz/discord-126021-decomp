package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* JADX INFO: renamed from: b.a.i.e2 */
/* JADX INFO: compiled from: ViewCodeVerificationBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0946e2 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FlexboxLayout f808a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FlexboxLayout f809b;

    public C0946e2(@NonNull FlexboxLayout flexboxLayout, @NonNull FlexboxLayout flexboxLayout2) {
        this.f808a = flexboxLayout;
        this.f809b = flexboxLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f808a;
    }
}
