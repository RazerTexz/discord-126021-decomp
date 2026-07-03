package p007b.p225i.p226a.p341g.p351j;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.C10817R;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.p */
/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4445p extends AbstractC4442m {

    /* JADX INFO: renamed from: d */
    public final TextWatcher f11848d;

    /* JADX INFO: renamed from: e */
    public final TextInputLayout.OnEditTextAttachedListener f11849e;

    /* JADX INFO: renamed from: f */
    public final TextInputLayout.OnEndIconChangedListener f11850f;

    /* JADX INFO: renamed from: b.i.a.g.j.p$a */
    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class a extends TextWatcherAdapter {
        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C4445p c4445p = C4445p.this;
            c4445p.f11821c.setChecked(!C4445p.m6169d(c4445p));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.p$b */
    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class b implements TextInputLayout.OnEditTextAttachedListener {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            C4445p c4445p = C4445p.this;
            c4445p.f11821c.setChecked(!C4445p.m6169d(c4445p));
            editText.removeTextChangedListener(C4445p.this.f11848d);
            editText.addTextChangedListener(C4445p.this.f11848d);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.p$c */
    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class c implements TextInputLayout.OnEndIconChangedListener {

        /* JADX INFO: renamed from: b.i.a.g.j.p$c$a */
        /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ EditText f11854j;

            public a(EditText editText) {
                this.f11854j = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11854j.removeTextChangedListener(C4445p.this.f11848d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.post(new a(editText));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.p$d */
    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = C4445p.this.f11819a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (C4445p.m6169d(C4445p.this)) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
            C4445p.this.f11819a.refreshEndIconDrawableState();
        }
    }

    public C4445p(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f11848d = new a();
        this.f11849e = new b();
        this.f11850f = new c();
    }

    /* JADX INFO: renamed from: d */
    public static boolean m6169d(C4445p c4445p) {
        EditText editText = c4445p.f11819a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // p007b.p225i.p226a.p341g.p351j.AbstractC4442m
    /* JADX INFO: renamed from: a */
    public void mo6146a() {
        this.f11819a.setEndIconDrawable(AppCompatResources.getDrawable(this.f11820b, C10817R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f11819a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(C10817R.string.password_toggle_content_description));
        this.f11819a.setEndIconOnClickListener(new d());
        this.f11819a.addOnEditTextAttachedListener(this.f11849e);
        this.f11819a.addOnEndIconChangedListener(this.f11850f);
        EditText editText = this.f11819a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
