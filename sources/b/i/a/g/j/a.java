package b.i.a.g.j;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.TextWatcher;
import android.view.View$OnFocusChangeListener;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;

/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends m {
    public final TextWatcher d;
    public final View$OnFocusChangeListener e;
    public final TextInputLayout$OnEditTextAttachedListener f;
    public final TextInputLayout$OnEndIconChangedListener g;
    public AnimatorSet h;
    public ValueAnimator i;

    public a(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a$a(this);
        this.e = new a$b(this);
        this.f = new a$c(this);
        this.g = new a$d(this);
    }

    @Override // b.i.a.g.j.m
    public void a() {
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new a$e(this));
        this.a.addOnEditTextAttachedListener(this.f);
        this.a.addOnEndIconChangedListener(this.g);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new e(this));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(100L);
        valueAnimatorOfFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.h.addListener(new b(this));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(100L);
        valueAnimatorOfFloat3.addUpdateListener(new d(this));
        this.i = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c(this));
    }

    @Override // b.i.a.g.j.m
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
