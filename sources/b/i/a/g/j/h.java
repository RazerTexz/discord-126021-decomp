package b.i.a.g.j;

import android.R$attr;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.StateListDrawable;
import android.text.TextWatcher;
import android.view.View$OnFocusChangeListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textfield.TextInputLayout$AccessibilityDelegate;
import com.google.android.material.textfield.TextInputLayout$OnEditTextAttachedListener;
import com.google.android.material.textfield.TextInputLayout$OnEndIconChangedListener;
import java.util.Objects;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends m {
    public final TextWatcher d;
    public final View$OnFocusChangeListener e;
    public final TextInputLayout$AccessibilityDelegate f;
    public final TextInputLayout$OnEditTextAttachedListener g;

    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout$OnEndIconChangedListener h;
    public boolean i;
    public boolean j;
    public long k;
    public StateListDrawable l;
    public MaterialShapeDrawable m;

    @Nullable
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    public h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new h$a(this);
        this.e = new h$b(this);
        this.f = new h$c(this, this.a);
        this.g = new h$d(this);
        this.h = new h$e(this);
        this.i = false;
        this.j = false;
        this.k = RecyclerView.FOREVER_NS;
    }

    public static AutoCompleteTextView d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void f(h hVar, boolean z2) {
        if (hVar.j != z2) {
            hVar.j = z2;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void g(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView == null) {
            return;
        }
        if (hVar.i()) {
            hVar.i = false;
        }
        if (hVar.i) {
            hVar.i = false;
            return;
        }
        boolean z2 = hVar.j;
        boolean z3 = !z2;
        if (z2 != z3) {
            hVar.j = z3;
            hVar.p.cancel();
            hVar.o.start();
        }
        if (!hVar.j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // b.i.a.g.j.m
    public void a() {
        float dimensionPixelOffset = this.f1626b.getResources().getDimensionPixelOffset(R$dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1626b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1626b.getResources().getDimensionPixelOffset(R$dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableH = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableH2 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = materialShapeDrawableH;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{R$attr.state_above_anchor}, materialShapeDrawableH);
        this.l.addState(new int[0], materialShapeDrawableH2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R$drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new h$f(this));
        this.a.addOnEditTextAttachedListener(this.g);
        this.a.addOnEndIconChangedListener(this.h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new i(this));
        this.p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new i(this));
        this.o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.f1626b.getSystemService("accessibility");
    }

    @Override // b.i.a.g.j.m
    public boolean b(int i) {
        return i != 0;
    }

    public final MaterialShapeDrawable h(float f, float f2, float f3, int i) {
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder().setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomLeftCornerSize(f2).setBottomRightCornerSize(f2).build();
        MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f1626b, f3);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i, 0, i);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    public final boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
