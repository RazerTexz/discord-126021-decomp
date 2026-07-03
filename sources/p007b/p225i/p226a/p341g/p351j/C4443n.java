package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.g.j.n */
/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4443n {

    /* JADX INFO: renamed from: a */
    public final Context f11822a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextInputLayout f11823b;

    /* JADX INFO: renamed from: c */
    public LinearLayout f11824c;

    /* JADX INFO: renamed from: d */
    public int f11825d;

    /* JADX INFO: renamed from: e */
    public FrameLayout f11826e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public Animator f11827f;

    /* JADX INFO: renamed from: g */
    public final float f11828g;

    /* JADX INFO: renamed from: h */
    public int f11829h;

    /* JADX INFO: renamed from: i */
    public int f11830i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public CharSequence f11831j;

    /* JADX INFO: renamed from: k */
    public boolean f11832k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public TextView f11833l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public CharSequence f11834m;

    /* JADX INFO: renamed from: n */
    public int f11835n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public ColorStateList f11836o;

    /* JADX INFO: renamed from: p */
    public CharSequence f11837p;

    /* JADX INFO: renamed from: q */
    public boolean f11838q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public TextView f11839r;

    /* JADX INFO: renamed from: s */
    public int f11840s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public ColorStateList f11841t;

    /* JADX INFO: renamed from: u */
    public Typeface f11842u;

    /* JADX INFO: renamed from: b.i.a.g.j.n$a */
    /* JADX INFO: compiled from: IndicatorViewController.java */
    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ int f11843a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ TextView f11844b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ int f11845c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ TextView f11846d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f11843a = i;
            this.f11844b = textView;
            this.f11845c = i2;
            this.f11846d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            C4443n c4443n = C4443n.this;
            c4443n.f11829h = this.f11843a;
            c4443n.f11827f = null;
            TextView textView2 = this.f11844b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f11845c == 1 && (textView = C4443n.this.f11833l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f11846d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f11846d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f11846d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public C4443n(@NonNull TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f11822a = context;
        this.f11823b = textInputLayout;
        this.f11828g = context.getResources().getDimensionPixelSize(C10817R.dimen.design_textinput_caption_translate_y);
    }

    /* JADX INFO: renamed from: a */
    public void m6157a(TextView textView, int i) {
        if (this.f11824c == null && this.f11826e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f11822a);
            this.f11824c = linearLayout;
            linearLayout.setOrientation(0);
            this.f11823b.addView(this.f11824c, -1, -2);
            this.f11826e = new FrameLayout(this.f11822a);
            this.f11824c.addView(this.f11826e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f11823b.getEditText() != null) {
                m6158b();
            }
        }
        if (i == 0 || i == 1) {
            this.f11826e.setVisibility(0);
            this.f11826e.addView(textView);
        } else {
            this.f11824c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f11824c.setVisibility(0);
        this.f11825d++;
    }

    /* JADX INFO: renamed from: b */
    public void m6158b() {
        if ((this.f11824c == null || this.f11823b.getEditText() == null) ? false : true) {
            EditText editText = this.f11823b.getEditText();
            boolean zIsFontScaleAtLeast1_3 = MaterialResources.isFontScaleAtLeast1_3(this.f11822a);
            LinearLayout linearLayout = this.f11824c;
            int i = C10817R.dimen.material_helper_text_font_1_3_padding_horizontal;
            ViewCompat.setPaddingRelative(linearLayout, m6164h(zIsFontScaleAtLeast1_3, i, ViewCompat.getPaddingStart(editText)), m6164h(zIsFontScaleAtLeast1_3, C10817R.dimen.material_helper_text_font_1_3_padding_top, this.f11822a.getResources().getDimensionPixelSize(C10817R.dimen.material_helper_text_default_padding_top)), m6164h(zIsFontScaleAtLeast1_3, i, ViewCompat.getPaddingEnd(editText)), 0);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6159c() {
        Animator animator = this.f11827f;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m6160d(@NonNull List<Animator> list, boolean z2, @Nullable TextView textView, int i, int i2, int i3) {
        if (textView == null || !z2) {
            return;
        }
        if (i == i3 || i == i2) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, i3 == i ? 1.0f : 0.0f);
            objectAnimatorOfFloat.setDuration(167L);
            objectAnimatorOfFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            list.add(objectAnimatorOfFloat);
            if (i3 == i) {
                ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f11828g, 0.0f);
                objectAnimatorOfFloat2.setDuration(217L);
                objectAnimatorOfFloat2.setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
                list.add(objectAnimatorOfFloat2);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m6161e() {
        return (this.f11830i != 1 || this.f11833l == null || TextUtils.isEmpty(this.f11831j)) ? false : true;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public final TextView m6162f(int i) {
        if (i == 1) {
            return this.f11833l;
        }
        if (i != 2) {
            return null;
        }
        return this.f11839r;
    }

    @ColorInt
    /* JADX INFO: renamed from: g */
    public int m6163g() {
        TextView textView = this.f11833l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: renamed from: h */
    public final int m6164h(boolean z2, @DimenRes int i, int i2) {
        return z2 ? this.f11822a.getResources().getDimensionPixelSize(i) : i2;
    }

    /* JADX INFO: renamed from: i */
    public void m6165i() {
        this.f11831j = null;
        m6159c();
        if (this.f11829h == 1) {
            if (!this.f11838q || TextUtils.isEmpty(this.f11837p)) {
                this.f11830i = 0;
            } else {
                this.f11830i = 2;
            }
        }
        m6168l(this.f11829h, this.f11830i, m6167k(this.f11833l, null));
    }

    /* JADX INFO: renamed from: j */
    public void m6166j(TextView textView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f11824c;
        if (linearLayout == null) {
            return;
        }
        if (!(i == 0 || i == 1) || (frameLayout = this.f11826e) == null) {
            linearLayout.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i2 = this.f11825d - 1;
        this.f11825d = i2;
        LinearLayout linearLayout2 = this.f11824c;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: k */
    public final boolean m6167k(@Nullable TextView textView, @Nullable CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f11823b) && this.f11823b.isEnabled() && !(this.f11830i == this.f11829h && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* JADX INFO: renamed from: l */
    public final void m6168l(int i, int i2, boolean z2) {
        TextView textViewM6162f;
        TextView textViewM6162f2;
        if (i == i2) {
            return;
        }
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f11827f = animatorSet;
            ArrayList arrayList = new ArrayList();
            m6160d(arrayList, this.f11838q, this.f11839r, 2, i, i2);
            m6160d(arrayList, this.f11832k, this.f11833l, 1, i, i2);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            animatorSet.addListener(new a(i2, m6162f(i), i, m6162f(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (textViewM6162f2 = m6162f(i2)) != null) {
                textViewM6162f2.setVisibility(0);
                textViewM6162f2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewM6162f = m6162f(i)) != null) {
                textViewM6162f.setVisibility(4);
                if (i == 1) {
                    textViewM6162f.setText((CharSequence) null);
                }
            }
            this.f11829h = i2;
        }
        this.f11823b.updateEditTextBackground();
        this.f11823b.updateLabelState(z2);
        this.f11823b.updateTextInputBoxState();
    }
}
