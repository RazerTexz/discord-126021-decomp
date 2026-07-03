package p007b.p008a.p025i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.phone.PhoneOrEmailInputView;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: renamed from: b.a.i.j0 */
/* JADX INFO: compiled from: LayoutContactSyncAddPhoneBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0982j0 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f966a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final PhoneOrEmailInputView f967b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final MaterialButton f968c;

    public C0982j0(@NonNull ConstraintLayout constraintLayout, @NonNull PhoneOrEmailInputView phoneOrEmailInputView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f966a = constraintLayout;
        this.f967b = phoneOrEmailInputView;
        this.f968c = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f966a;
    }
}
