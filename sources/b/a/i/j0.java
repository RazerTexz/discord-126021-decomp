package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: compiled from: LayoutContactSyncAddPhoneBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class j0 implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final PhoneOrEmailInputView f138b;

    @NonNull
    public final MaterialButton c;

    public j0(@NonNull ConstraintLayout constraintLayout, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.a = constraintLayout;
        this.f138b = phoneOrEmailInputView;
        this.c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
