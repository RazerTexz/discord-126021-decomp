package b.a.i;

import android.view.View;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: ViewCodeVerificationSpaceBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class f2 implements ViewBinding {

    @NonNull
    public final Space a;

    public f2(@NonNull Space space) {
        this.a = space;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
