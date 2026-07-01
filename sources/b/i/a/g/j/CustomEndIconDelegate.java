package b.i.a.g.j;

import androidx.annotation.NonNull;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.f, reason: use source file name */
/* JADX INFO: compiled from: CustomEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class CustomEndIconDelegate extends EndIconDelegate {
    public CustomEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public void a() {
        this.a.setEndIconOnClickListener(null);
        this.a.setEndIconOnLongClickListener(null);
    }
}
