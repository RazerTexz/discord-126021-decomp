package p007b.p225i.p226a.p341g.p351j;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.j.h */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4437h extends AbstractC4442m {

    /* JADX INFO: renamed from: d */
    public final TextWatcher f11791d;

    /* JADX INFO: renamed from: e */
    public final View.OnFocusChangeListener f11792e;

    /* JADX INFO: renamed from: f */
    public final TextInputLayout.AccessibilityDelegate f11793f;

    /* JADX INFO: renamed from: g */
    public final TextInputLayout.OnEditTextAttachedListener f11794g;

    /* JADX INFO: renamed from: h */
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener f11795h;

    /* JADX INFO: renamed from: i */
    public boolean f11796i;

    /* JADX INFO: renamed from: j */
    public boolean f11797j;

    /* JADX INFO: renamed from: k */
    public long f11798k;

    /* JADX INFO: renamed from: l */
    public StateListDrawable f11799l;

    /* JADX INFO: renamed from: m */
    public MaterialShapeDrawable f11800m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public AccessibilityManager f11801n;

    /* JADX INFO: renamed from: o */
    public ValueAnimator f11802o;

    /* JADX INFO: renamed from: p */
    public ValueAnimator f11803p;

    /* JADX INFO: renamed from: b.i.a.g.j.h$a */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class a extends TextWatcherAdapter {

        /* JADX INFO: renamed from: b.i.a.g.j.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class RunnableC13229a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ AutoCompleteTextView f11805j;

            public RunnableC13229a(AutoCompleteTextView autoCompleteTextView) {
                this.f11805j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.f11805j.isPopupShowing();
                C4437h.m6152f(C4437h.this, zIsPopupShowing);
                C4437h.this.f11796i = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewM6150d = C4437h.m6150d(C4437h.this.f11819a.getEditText());
            if (C4437h.this.f11801n.isTouchExplorationEnabled() && C4437h.m6151e(autoCompleteTextViewM6150d) && !C4437h.this.f11821c.hasFocus()) {
                autoCompleteTextViewM6150d.dismissDropDown();
            }
            autoCompleteTextViewM6150d.post(new RunnableC13229a(autoCompleteTextViewM6150d));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$b */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            C4437h.this.f11819a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            C4437h.m6152f(C4437h.this, false);
            C4437h.this.f11796i = false;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$c */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class c extends TextInputLayout.AccessibilityDelegate {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.AccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!C4437h.m6151e(C4437h.this.f11819a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewM6150d = C4437h.m6150d(C4437h.this.f11819a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && C4437h.this.f11801n.isTouchExplorationEnabled() && !C4437h.m6151e(C4437h.this.f11819a.getEditText())) {
                C4437h.m6153g(C4437h.this, autoCompleteTextViewM6150d);
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$d */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class d implements TextInputLayout.OnEditTextAttachedListener {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEditTextAttachedListener
        public void onEditTextAttached(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView autoCompleteTextViewM6150d = C4437h.m6150d(textInputLayout.getEditText());
            C4437h c4437h = C4437h.this;
            int boxBackgroundMode = c4437h.f11819a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextViewM6150d.setDropDownBackgroundDrawable(c4437h.f11800m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextViewM6150d.setDropDownBackgroundDrawable(c4437h.f11799l);
            }
            C4437h c4437h2 = C4437h.this;
            Objects.requireNonNull(c4437h2);
            if (!(autoCompleteTextViewM6150d.getKeyListener() != null)) {
                int boxBackgroundMode2 = c4437h2.f11819a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = c4437h2.f11819a.getBoxBackground();
                int color = MaterialColors.getColor(autoCompleteTextViewM6150d, C10817R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{R.attr.state_pressed}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int color2 = MaterialColors.getColor(autoCompleteTextViewM6150d, C10817R.attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    int iLayer = MaterialColors.layer(color, color2, 0.1f);
                    materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                    materialShapeDrawable.setTint(color2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(autoCompleteTextViewM6150d, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = c4437h2.f11819a.getBoxBackgroundColor();
                    ViewCompat.setBackground(autoCompleteTextViewM6150d, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            C4437h c4437h3 = C4437h.this;
            Objects.requireNonNull(c4437h3);
            autoCompleteTextViewM6150d.setOnTouchListener(new ViewOnTouchListenerC4439j(c4437h3, autoCompleteTextViewM6150d));
            autoCompleteTextViewM6150d.setOnFocusChangeListener(c4437h3.f11792e);
            autoCompleteTextViewM6150d.setOnDismissListener(new C4440k(c4437h3));
            autoCompleteTextViewM6150d.setThreshold(0);
            autoCompleteTextViewM6150d.removeTextChangedListener(C4437h.this.f11791d);
            autoCompleteTextViewM6150d.addTextChangedListener(C4437h.this.f11791d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!(autoCompleteTextViewM6150d.getKeyListener() != null)) {
                ViewCompat.setImportantForAccessibility(C4437h.this.f11821c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(C4437h.this.f11793f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$e */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class e implements TextInputLayout.OnEndIconChangedListener {

        /* JADX INFO: renamed from: b.i.a.g.j.h$e$a */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ AutoCompleteTextView f11811j;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f11811j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f11811j.removeTextChangedListener(C4437h.this.f11791d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.OnEndIconChangedListener
        public void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == C4437h.this.f11792e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            autoCompleteTextView.setOnDismissListener(null);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$f */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4437h.m6153g(C4437h.this, (AutoCompleteTextView) C4437h.this.f11819a.getEditText());
        }
    }

    public C4437h(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f11791d = new a();
        this.f11792e = new b();
        this.f11793f = new c(this.f11819a);
        this.f11794g = new d();
        this.f11795h = new e();
        this.f11796i = false;
        this.f11797j = false;
        this.f11798k = RecyclerView.FOREVER_NS;
    }

    /* JADX INFO: renamed from: d */
    public static AutoCompleteTextView m6150d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX INFO: renamed from: e */
    public static boolean m6151e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: renamed from: f */
    public static void m6152f(C4437h c4437h, boolean z2) {
        if (c4437h.f11797j != z2) {
            c4437h.f11797j = z2;
            c4437h.f11803p.cancel();
            c4437h.f11802o.start();
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m6153g(C4437h c4437h, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(c4437h);
        if (autoCompleteTextView == null) {
            return;
        }
        if (c4437h.m6156i()) {
            c4437h.f11796i = false;
        }
        if (c4437h.f11796i) {
            c4437h.f11796i = false;
            return;
        }
        boolean z2 = c4437h.f11797j;
        boolean z3 = !z2;
        if (z2 != z3) {
            c4437h.f11797j = z3;
            c4437h.f11803p.cancel();
            c4437h.f11802o.start();
        }
        if (!c4437h.f11797j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p351j.AbstractC4442m
    /* JADX INFO: renamed from: a */
    public void mo6146a() {
        float dimensionPixelOffset = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f11820b.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableM6155h = m6155h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableM6155h2 = m6155h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f11800m = materialShapeDrawableM6155h;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f11799l = stateListDrawable;
        stateListDrawable.addState(new int[]{R.attr.state_above_anchor}, materialShapeDrawableM6155h);
        this.f11799l.addState(new int[0], materialShapeDrawableM6155h2);
        this.f11819a.setEndIconDrawable(AppCompatResources.getDrawable(this.f11820b, C10817R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f11819a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(C10817R.string.exposed_dropdown_menu_content_description));
        this.f11819a.setEndIconOnClickListener(new f());
        this.f11819a.addOnEditTextAttachedListener(this.f11794g);
        this.f11819a.addOnEndIconChangedListener(this.f11795h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new C4438i(this));
        this.f11803p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new C4438i(this));
        this.f11802o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new C4441l(this));
        this.f11801n = (AccessibilityManager) this.f11820b.getSystemService("accessibility");
    }

    @Override // p007b.p225i.p226a.p341g.p351j.AbstractC4442m
    /* JADX INFO: renamed from: b */
    public boolean mo6154b(int i) {
        return i != 0;
    }

    /* JADX INFO: renamed from: h */
    public final MaterialShapeDrawable m6155h(float f2, float f3, float f4, int i) {
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
        MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f11820b, f4);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i, 0, i);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m6156i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f11798k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
