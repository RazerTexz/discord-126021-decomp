package b.i.a.g.j;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class p extends m {
    public final TextWatcher d;
    public final TextInputLayout$OnEditTextAttachedListener e;
    public final TextInputLayout$OnEndIconChangedListener f;

    public p(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new p$a(this);
        this.e = new p$b(this);
        this.f = new p$c(this);
    }

    public static boolean d(p pVar) {
        EditText editText = pVar.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // b.i.a.g.j.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new p$d(this));
        this.a.addOnEditTextAttachedListener(this.e);
        this.a.addOnEndIconChangedListener(this.f);
        EditText editText = this.a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
