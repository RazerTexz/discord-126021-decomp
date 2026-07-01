package b.i.a.g.j;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: b.i.a.g.j.a, reason: use source file name */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClearTextEndIconDelegate extends EndIconDelegate {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.OnEditTextAttachedListener f;
    public final TextInputLayout.OnEndIconChangedListener g;
    public AnimatorSet h;
    public ValueAnimator i;

    /* JADX INFO: renamed from: b.i.a.g.j.a$a */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            if (ClearTextEndIconDelegate.this.a.getSuffixText() != null) {
                return;
            }
            ClearTextEndIconDelegate.this.d(editable.length() > 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$b */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            ClearTextEndIconDelegate.this.d((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z2);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$c */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class c implements TextInputLayout.OnEditTextAttachedListener {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001c  */
        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            boolean z2;
            EditText editText = textInputLayout.getEditText();
            if (editText.hasFocus()) {
                z2 = editText.getText().length() > 0;
            }
            textInputLayout.setEndIconVisible(z2);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(ClearTextEndIconDelegate.this.e);
            editText.removeTextChangedListener(ClearTextEndIconDelegate.this.d);
            editText.addTextChangedListener(ClearTextEndIconDelegate.this.d);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$d */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class d implements TextInputLayout.OnEndIconChangedListener {

        /* JADX INFO: renamed from: b.i.a.g.j.a$d$a */
        /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
        public class a implements Runnable {
            public final /* synthetic */ EditText j;

            public a(EditText editText) {
                this.j = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.j.removeTextChangedListener(ClearTextEndIconDelegate.this.d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i != 2) {
                return;
            }
            editText.post(new a(editText));
            if (editText.getOnFocusChangeListener() == ClearTextEndIconDelegate.this.e) {
                editText.setOnFocusChangeListener(null);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.a$e */
    /* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Editable text = ClearTextEndIconDelegate.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            ClearTextEndIconDelegate.this.a.refreshEndIconDrawableState();
        }
    }

    public ClearTextEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c();
        this.g = new d();
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.addOnEditTextAttachedListener(this.f);
        this.a.addOnEndIconChangedListener(this.g);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ClearTextEndIconDelegate5(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new ClearTextEndIconDelegate4(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.h.addListener(new ClearTextEndIconDelegate2(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new ClearTextEndIconDelegate4(this));
        this.i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new ClearTextEndIconDelegate3(this));
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public void c(boolean z2) {
        if (this.a.getSuffixText() == null) {
            return;
        }
        d(z2);
    }

    public final void d(boolean z2) {
        boolean z3 = this.a.isEndIconVisible() == z2;
        if (z2 && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (z3) {
                this.h.end();
                return;
            }
            return;
        }
        if (z2) {
            return;
        }
        this.h.cancel();
        this.i.start();
        if (z3) {
            this.i.end();
        }
    }
}
