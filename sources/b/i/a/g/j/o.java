package b.i.a.g.j;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: NoEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends m {
    public o(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // b.i.a.g.j.m
    public void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconDrawable((Drawable) null);
        this.a.setEndIconContentDescription((CharSequence) null);
    }
}
