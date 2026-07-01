package b.i.a.g.j;

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
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.j.h, reason: use source file name */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public final TextWatcher d;
    public final View.OnFocusChangeListener e;
    public final TextInputLayout.AccessibilityDelegate f;
    public final TextInputLayout.OnEditTextAttachedListener g;

    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.OnEndIconChangedListener h;
    public boolean i;
    public boolean j;
    public long k;
    public StateListDrawable l;
    public MaterialShapeDrawable m;

    @Nullable
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* JADX INFO: renamed from: b.i.a.g.j.h$a */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class a extends TextWatcherAdapter {

        /* JADX INFO: renamed from: b.i.a.g.j.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class RunnableC0043a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView j;

            public RunnableC0043a(AutoCompleteTextView autoCompleteTextView) {
                this.j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPopupShowing = this.j.isPopupShowing();
                DropdownMenuEndIconDelegate.f(DropdownMenuEndIconDelegate.this, zIsPopupShowing);
                DropdownMenuEndIconDelegate.this.i = zIsPopupShowing;
            }
        }

        public a() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView autoCompleteTextViewD = DropdownMenuEndIconDelegate.d(DropdownMenuEndIconDelegate.this.a.getEditText());
            if (DropdownMenuEndIconDelegate.this.n.isTouchExplorationEnabled() && DropdownMenuEndIconDelegate.e(autoCompleteTextViewD) && !DropdownMenuEndIconDelegate.this.c.hasFocus()) {
                autoCompleteTextViewD.dismissDropDown();
            }
            autoCompleteTextViewD.post(new RunnableC0043a(autoCompleteTextViewD));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$b */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z2) {
            DropdownMenuEndIconDelegate.this.a.setEndIconActivated(z2);
            if (z2) {
                return;
            }
            DropdownMenuEndIconDelegate.f(DropdownMenuEndIconDelegate.this, false);
            DropdownMenuEndIconDelegate.this.i = false;
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
            if (!DropdownMenuEndIconDelegate.e(DropdownMenuEndIconDelegate.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView autoCompleteTextViewD = DropdownMenuEndIconDelegate.d(DropdownMenuEndIconDelegate.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && DropdownMenuEndIconDelegate.this.n.isTouchExplorationEnabled() && !DropdownMenuEndIconDelegate.e(DropdownMenuEndIconDelegate.this.a.getEditText())) {
                DropdownMenuEndIconDelegate.g(DropdownMenuEndIconDelegate.this, autoCompleteTextViewD);
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
            AutoCompleteTextView autoCompleteTextViewD = DropdownMenuEndIconDelegate.d(textInputLayout.getEditText());
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            int boxBackgroundMode = dropdownMenuEndIconDelegate.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextViewD.setDropDownBackgroundDrawable(dropdownMenuEndIconDelegate.l);
            }
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate2 = DropdownMenuEndIconDelegate.this;
            Objects.requireNonNull(dropdownMenuEndIconDelegate2);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                int boxBackgroundMode2 = dropdownMenuEndIconDelegate2.a.getBoxBackgroundMode();
                MaterialShapeDrawable boxBackground = dropdownMenuEndIconDelegate2.a.getBoxBackground();
                int color = MaterialColors.getColor(autoCompleteTextViewD, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{android.R.attr.state_pressed}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int color2 = MaterialColors.getColor(autoCompleteTextViewD, R.attr.colorSurface);
                    MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    int iLayer = MaterialColors.layer(color, color2, 0.1f);
                    materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{iLayer, 0}));
                    materialShapeDrawable.setTint(color2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iLayer, color2});
                    MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(boxBackground.getShapeAppearanceModel());
                    materialShapeDrawable2.setTint(-1);
                    ViewCompat.setBackground(autoCompleteTextViewD, new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable, materialShapeDrawable2), boxBackground}));
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = dropdownMenuEndIconDelegate2.a.getBoxBackgroundColor();
                    ViewCompat.setBackground(autoCompleteTextViewD, new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.layer(color, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground));
                }
            }
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate3 = DropdownMenuEndIconDelegate.this;
            Objects.requireNonNull(dropdownMenuEndIconDelegate3);
            autoCompleteTextViewD.setOnTouchListener(new DropdownMenuEndIconDelegate3(dropdownMenuEndIconDelegate3, autoCompleteTextViewD));
            autoCompleteTextViewD.setOnFocusChangeListener(dropdownMenuEndIconDelegate3.e);
            autoCompleteTextViewD.setOnDismissListener(new DropdownMenuEndIconDelegate4(dropdownMenuEndIconDelegate3));
            autoCompleteTextViewD.setThreshold(0);
            autoCompleteTextViewD.removeTextChangedListener(DropdownMenuEndIconDelegate.this.d);
            autoCompleteTextViewD.addTextChangedListener(DropdownMenuEndIconDelegate.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!(autoCompleteTextViewD.getKeyListener() != null)) {
                ViewCompat.setImportantForAccessibility(DropdownMenuEndIconDelegate.this.c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(DropdownMenuEndIconDelegate.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.j.h$e */
    /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
    public class e implements TextInputLayout.OnEndIconChangedListener {

        /* JADX INFO: renamed from: b.i.a.g.j.h$e$a */
        /* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView j;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.j = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.j.removeTextChangedListener(DropdownMenuEndIconDelegate.this.d);
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
            if (autoCompleteTextView.getOnFocusChangeListener() == DropdownMenuEndIconDelegate.this.e) {
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
            DropdownMenuEndIconDelegate.g(DropdownMenuEndIconDelegate.this, (AutoCompleteTextView) DropdownMenuEndIconDelegate.this.a.getEditText());
        }
    }

    public DropdownMenuEndIconDelegate(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.d = new a();
        this.e = new b();
        this.f = new c(this.a);
        this.g = new d();
        this.h = new e();
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

    public static void f(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, boolean z2) {
        if (dropdownMenuEndIconDelegate.j != z2) {
            dropdownMenuEndIconDelegate.j = z2;
            dropdownMenuEndIconDelegate.p.cancel();
            dropdownMenuEndIconDelegate.o.start();
        }
    }

    public static void g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(dropdownMenuEndIconDelegate);
        if (autoCompleteTextView == null) {
            return;
        }
        if (dropdownMenuEndIconDelegate.i()) {
            dropdownMenuEndIconDelegate.i = false;
        }
        if (dropdownMenuEndIconDelegate.i) {
            dropdownMenuEndIconDelegate.i = false;
            return;
        }
        boolean z2 = dropdownMenuEndIconDelegate.j;
        boolean z3 = !z2;
        if (z2 != z3) {
            dropdownMenuEndIconDelegate.j = z3;
            dropdownMenuEndIconDelegate.p.cancel();
            dropdownMenuEndIconDelegate.o.start();
        }
        if (!dropdownMenuEndIconDelegate.j) {
            autoCompleteTextView.dismissDropDown();
        } else {
            autoCompleteTextView.requestFocus();
            autoCompleteTextView.showDropDown();
        }
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public void a() {
        float dimensionPixelOffset = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.f1626b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        MaterialShapeDrawable materialShapeDrawableH = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        MaterialShapeDrawable materialShapeDrawableH2 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = materialShapeDrawableH;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, materialShapeDrawableH);
        this.l.addState(new int[0], materialShapeDrawableH2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.f1626b, R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.addOnEditTextAttachedListener(this.g);
        this.a.addOnEndIconChangedListener(this.h);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(67);
        valueAnimatorOfFloat.addUpdateListener(new DropdownMenuEndIconDelegate2(this));
        this.p = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(50);
        valueAnimatorOfFloat2.addUpdateListener(new DropdownMenuEndIconDelegate2(this));
        this.o = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new DropdownMenuEndIconDelegate5(this));
        this.n = (AccessibilityManager) this.f1626b.getSystemService("accessibility");
    }

    @Override // b.i.a.g.j.EndIconDelegate
    public boolean b(int i) {
        return i != 0;
    }

    public final MaterialShapeDrawable h(float f2, float f3, float f4, int i) {
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder().setTopLeftCornerSize(f2).setTopRightCornerSize(f2).setBottomLeftCornerSize(f3).setBottomRightCornerSize(f3).build();
        MaterialShapeDrawable materialShapeDrawableCreateWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(this.f1626b, f4);
        materialShapeDrawableCreateWithElevationOverlay.setShapeAppearanceModel(shapeAppearanceModelBuild);
        materialShapeDrawableCreateWithElevationOverlay.setPadding(0, i, 0, i);
        return materialShapeDrawableCreateWithElevationOverlay;
    }

    public final boolean i() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }
}
