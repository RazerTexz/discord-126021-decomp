package com.google.android.material.textfield;

import android.R;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.C10817R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p341g.p351j.AbstractC4442m;
import p007b.p225i.p226a.p341g.p351j.C4430a;
import p007b.p225i.p226a.p341g.p351j.C4435f;
import p007b.p225i.p226a.p341g.p351j.C4436g;
import p007b.p225i.p226a.p341g.p351j.C4437h;
import p007b.p225i.p226a.p341g.p351j.C4443n;
import p007b.p225i.p226a.p341g.p351j.C4444o;
import p007b.p225i.p226a.p341g.p351j.C4445p;

/* JADX INFO: loaded from: classes3.dex */
public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int DEF_STYLE_RES = C10817R.style.Widget_Design_TextInputLayout;
    public static final int END_ICON_CLEAR_TEXT = 2;
    public static final int END_ICON_CUSTOM = -1;
    public static final int END_ICON_DROPDOWN_MENU = 3;
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;

    @Nullable
    private MaterialShapeDrawable boxBackground;

    @ColorInt
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private int boxCollapsedPaddingTopPx;
    private final int boxLabelCutoutPaddingPx;

    @ColorInt
    private int boxStrokeColor;
    private int boxStrokeWidthDefaultPx;
    private int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;

    @Nullable
    private MaterialShapeDrawable boxUnderline;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    private int counterMaxLength;
    private int counterOverflowTextAppearance;

    @Nullable
    private ColorStateList counterOverflowTextColor;
    private boolean counterOverflowed;
    private int counterTextAppearance;

    @Nullable
    private ColorStateList counterTextColor;

    @Nullable
    private TextView counterView;

    @ColorInt
    private int defaultFilledBackgroundColor;
    private ColorStateList defaultHintTextColor;

    @ColorInt
    private int defaultStrokeColor;

    @ColorInt
    private int disabledColor;

    @ColorInt
    private int disabledFilledBackgroundColor;
    public EditText editText;
    private final LinkedHashSet<OnEditTextAttachedListener> editTextAttachedListeners;

    @Nullable
    private Drawable endDummyDrawable;
    private int endDummyDrawableWidth;
    private final LinkedHashSet<OnEndIconChangedListener> endIconChangedListeners;
    private final SparseArray<AbstractC4442m> endIconDelegates;

    @NonNull
    private final FrameLayout endIconFrame;
    private int endIconMode;
    private View.OnLongClickListener endIconOnLongClickListener;
    private ColorStateList endIconTintList;
    private PorterDuff.Mode endIconTintMode;

    @NonNull
    private final CheckableImageButton endIconView;

    @NonNull
    private final LinearLayout endLayout;
    private View.OnLongClickListener errorIconOnLongClickListener;
    private ColorStateList errorIconTintList;

    @NonNull
    private final CheckableImageButton errorIconView;
    private boolean expandedHintEnabled;

    @ColorInt
    private int focusedFilledBackgroundColor;

    @ColorInt
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasEndIconTintList;
    private boolean hasEndIconTintMode;
    private boolean hasStartIconTintList;
    private boolean hasStartIconTintMode;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;

    @ColorInt
    private int hoveredFilledBackgroundColor;

    @ColorInt
    private int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final C4443n indicatorViewController;

    @NonNull
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private boolean placeholderEnabled;
    private CharSequence placeholderText;
    private int placeholderTextAppearance;

    @Nullable
    private ColorStateList placeholderTextColor;
    private TextView placeholderTextView;

    @Nullable
    private CharSequence prefixText;

    @NonNull
    private final TextView prefixTextView;
    private boolean restoringSavedState;

    @NonNull
    private ShapeAppearanceModel shapeAppearanceModel;

    @Nullable
    private Drawable startDummyDrawable;
    private int startDummyDrawableWidth;
    private View.OnLongClickListener startIconOnLongClickListener;
    private ColorStateList startIconTintList;
    private PorterDuff.Mode startIconTintMode;

    @NonNull
    private final CheckableImageButton startIconView;

    @NonNull
    private final LinearLayout startLayout;
    private ColorStateList strokeErrorColor;

    @Nullable
    private CharSequence suffixText;

    @NonNull
    private final TextView suffixTextView;
    private final Rect tmpBoundsRect;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final TextInputLayout layout;

        public AccessibilityDelegate(@NonNull TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(@NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z2 = !TextUtils.isEmpty(text);
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !this.layout.isHintExpanded();
            boolean z5 = !TextUtils.isEmpty(error);
            boolean z6 = z5 || !TextUtils.isEmpty(counterOverflowDescription);
            String string = z3 ? hint.toString() : "";
            if (z2) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.setText(string);
                if (z4 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(string);
                } else {
                    if (z2) {
                        string = ((Object) text) + ", " + string;
                    }
                    accessibilityNodeInfoCompat.setText(string);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z2);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z6) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(C10817R.id.textinput_helper_text);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(@NonNull TextInputLayout textInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(@NonNull TextInputLayout textInputLayout, int i);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C11014a();

        /* JADX INFO: renamed from: j */
        @Nullable
        public CharSequence f21172j;

        /* JADX INFO: renamed from: k */
        public boolean f21173k;

        /* JADX INFO: renamed from: l */
        @Nullable
        public CharSequence f21174l;

        /* JADX INFO: renamed from: m */
        @Nullable
        public CharSequence f21175m;

        /* JADX INFO: renamed from: n */
        @Nullable
        public CharSequence f21176n;

        /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$SavedState$a */
        public static class C11014a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            public Object createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @NonNull
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("TextInputLayout.SavedState{");
            sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
            sbM833U.append(" error=");
            sbM833U.append((Object) this.f21172j);
            sbM833U.append(" hint=");
            sbM833U.append((Object) this.f21174l);
            sbM833U.append(" helperText=");
            sbM833U.append((Object) this.f21175m);
            sbM833U.append(" placeholderText=");
            sbM833U.append((Object) this.f21176n);
            sbM833U.append("}");
            return sbM833U.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f21172j, parcel, i);
            parcel.writeInt(this.f21173k ? 1 : 0);
            TextUtils.writeToParcel(this.f21174l, parcel, i);
            TextUtils.writeToParcel(this.f21175m, parcel, i);
            TextUtils.writeToParcel(this.f21176n, parcel, i);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f21172j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f21173k = parcel.readInt() == 1;
            this.f21174l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f21175m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f21176n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$a */
    public class C11015a implements TextWatcher {
        public C11015a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@NonNull Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.counterEnabled) {
                textInputLayout2.updateCounter(editable.length());
            }
            if (TextInputLayout.this.placeholderEnabled) {
                TextInputLayout.this.updatePlaceholderText(editable.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$b */
    public class RunnableC11016b implements Runnable {
        public RunnableC11016b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.endIconView.performClick();
            TextInputLayout.this.endIconView.jumpDrawablesToCurrentState();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$c */
    public class RunnableC11017c implements Runnable {
        public RunnableC11017c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.editText.requestLayout();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.textfield.TextInputLayout$d */
    public class C11018d implements ValueAnimator.AnimatorUpdateListener {
        public C11018d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TextInputLayout.this.collapsingTextHelper.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public TextInputLayout(@NonNull Context context) {
        this(context, null);
    }

    private void addPlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            this.inputFrame.addView(textView);
            this.placeholderTextView.setVisibility(0);
        }
    }

    private void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText == null || this.boxBackgroundMode != 1) {
            return;
        }
        if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
            EditText editText = this.editText;
            ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), getResources().getDimensionPixelSize(C10817R.dimen.material_filled_edittext_font_2_0_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(C10817R.dimen.material_filled_edittext_font_2_0_padding_bottom));
        } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
            EditText editText2 = this.editText;
            ViewCompat.setPaddingRelative(editText2, ViewCompat.getPaddingStart(editText2), getResources().getDimensionPixelSize(C10817R.dimen.material_filled_edittext_font_1_3_padding_top), ViewCompat.getPaddingEnd(this.editText), getResources().getDimensionPixelSize(C10817R.dimen.material_filled_edittext_font_1_3_padding_bottom));
        }
    }

    private void applyBoxAttributes() {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable == null) {
            return;
        }
        materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
        if (canDrawOutlineStroke()) {
            this.boxBackground.setStroke(this.boxStrokeWidthPx, this.boxStrokeColor);
        }
        int iCalculateBoxBackgroundColor = calculateBoxBackgroundColor();
        this.boxBackgroundColor = iCalculateBoxBackgroundColor;
        this.boxBackground.setFillColor(ColorStateList.valueOf(iCalculateBoxBackgroundColor));
        if (this.endIconMode == 3) {
            this.editText.getBackground().invalidateSelf();
        }
        applyBoxUnderlineAttributes();
        invalidate();
    }

    private void applyBoxUnderlineAttributes() {
        if (this.boxUnderline == null) {
            return;
        }
        if (canDrawStroke()) {
            this.boxUnderline.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
        }
        invalidate();
    }

    private void applyCutoutPadding(@NonNull RectF rectF) {
        float f = rectF.left;
        int i = this.boxLabelCutoutPaddingPx;
        rectF.left = f - i;
        rectF.top -= i;
        rectF.right += i;
        rectF.bottom += i;
    }

    private void applyEndIconTint() {
        applyIconTint(this.endIconView, this.hasEndIconTintList, this.endIconTintList, this.hasEndIconTintMode, this.endIconTintMode);
    }

    private void applyIconTint(@NonNull CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (z2) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
            if (z3) {
                DrawableCompat.setTintMode(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void applyStartIconTint() {
        applyIconTint(this.startIconView, this.hasStartIconTintList, this.startIconTintList, this.hasStartIconTintMode, this.startIconTintMode);
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderline = null;
            return;
        }
        if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderline = new MaterialShapeDrawable();
        } else {
            if (i != 2) {
                throw new IllegalArgumentException(C1643a.m814B(new StringBuilder(), this.boxBackgroundMode, " is illegal; only @BoxBackgroundMode constants are supported."));
            }
            if (!this.hintEnabled || (this.boxBackground instanceof C4436g)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                this.boxBackground = new C4436g(this.shapeAppearanceModel);
            }
            this.boxUnderline = null;
        }
    }

    private int calculateBoxBackgroundColor() {
        return this.boxBackgroundMode == 1 ? MaterialColors.layer(MaterialColors.getColor(this, C10817R.attr.colorSurface, 0), this.boxBackgroundColor) : this.boxBackgroundColor;
    }

    @NonNull
    private Rect calculateCollapsedTextBounds(@NonNull Rect rect) {
        if (this.editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        rect2.bottom = rect.bottom;
        int i = this.boxBackgroundMode;
        if (i == 1) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z2);
            rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z2);
            return rect2;
        }
        if (i != 2) {
            rect2.left = getLabelLeftBoundAlightWithPrefix(rect.left, z2);
            rect2.top = getPaddingTop();
            rect2.right = getLabelRightBoundAlignedWithSuffix(rect.right, z2);
            return rect2;
        }
        rect2.left = this.editText.getPaddingLeft() + rect.left;
        rect2.top = rect.top - calculateLabelMarginTop();
        rect2.right = rect.right - this.editText.getPaddingRight();
        return rect2;
    }

    private int calculateExpandedLabelBottom(@NonNull Rect rect, @NonNull Rect rect2, float f) {
        return isSingleLineFilledTextField() ? (int) (rect2.top + f) : rect.bottom - this.editText.getCompoundPaddingBottom();
    }

    private int calculateExpandedLabelTop(@NonNull Rect rect, float f) {
        if (isSingleLineFilledTextField()) {
            return (int) (rect.centerY() - (f / 2.0f));
        }
        return this.editText.getCompoundPaddingTop() + rect.top;
    }

    @NonNull
    private Rect calculateExpandedTextBounds(@NonNull Rect rect) {
        if (this.editText == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.tmpBoundsRect;
        float expandedTextHeight = this.collapsingTextHelper.getExpandedTextHeight();
        rect2.left = this.editText.getCompoundPaddingLeft() + rect.left;
        rect2.top = calculateExpandedLabelTop(rect, expandedTextHeight);
        rect2.right = rect.right - this.editText.getCompoundPaddingRight();
        rect2.bottom = calculateExpandedLabelBottom(rect, rect2, expandedTextHeight);
        return rect2;
    }

    private int calculateLabelMarginTop() {
        float collapsedTextHeight;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight();
        } else {
            if (i != 2) {
                return 0;
            }
            collapsedTextHeight = this.collapsingTextHelper.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    private boolean canDrawOutlineStroke() {
        return this.boxBackgroundMode == 2 && canDrawStroke();
    }

    private boolean canDrawStroke() {
        return this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0;
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((C4436g) this.boxBackground).m6149a(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void collapseHint(boolean z2) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z2 && this.hintAnimationEnabled) {
            animateToExpansionFraction(1.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
        updatePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof C4436g);
    }

    private void dispatchOnEditTextAttached() {
        Iterator<OnEditTextAttachedListener> it = this.editTextAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEditTextAttached(this);
        }
    }

    private void dispatchOnEndIconChanged(int i) {
        Iterator<OnEndIconChangedListener> it = this.endIconChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onEndIconChanged(this, i);
        }
    }

    private void drawBoxUnderline(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            Rect bounds = materialShapeDrawable.getBounds();
            bounds.top = bounds.bottom - this.boxStrokeWidthPx;
            this.boxUnderline.draw(canvas);
        }
    }

    private void drawHint(@NonNull Canvas canvas) {
        if (this.hintEnabled) {
            this.collapsingTextHelper.draw(canvas);
        }
    }

    private void expandHint(boolean z2) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (z2 && this.hintAnimationEnabled) {
            animateToExpansionFraction(0.0f);
        } else {
            this.collapsingTextHelper.setExpansionFraction(0.0f);
        }
        if (cutoutEnabled() && (!((C4436g) this.boxBackground).f11789k.isEmpty())) {
            closeCutout();
        }
        this.hintExpanded = true;
        hidePlaceholderText();
        updatePrefixTextVisibility();
        updateSuffixTextVisibility();
    }

    private AbstractC4442m getEndIconDelegate() {
        AbstractC4442m abstractC4442m = this.endIconDelegates.get(this.endIconMode);
        return abstractC4442m != null ? abstractC4442m : this.endIconDelegates.get(0);
    }

    @Nullable
    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.errorIconView.getVisibility() == 0) {
            return this.errorIconView;
        }
        if (hasEndIcon() && isEndIconVisible()) {
            return this.endIconView;
        }
        return null;
    }

    private int getLabelLeftBoundAlightWithPrefix(int i, boolean z2) {
        int compoundPaddingLeft = this.editText.getCompoundPaddingLeft() + i;
        return (this.prefixText == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.prefixTextView.getMeasuredWidth()) + this.prefixTextView.getPaddingLeft();
    }

    private int getLabelRightBoundAlignedWithSuffix(int i, boolean z2) {
        int compoundPaddingRight = i - this.editText.getCompoundPaddingRight();
        return (this.prefixText == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.prefixTextView.getMeasuredWidth() - this.prefixTextView.getPaddingRight());
    }

    private boolean hasEndIcon() {
        return this.endIconMode != 0;
    }

    private void hidePlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText((CharSequence) null);
        this.placeholderTextView.setVisibility(4);
    }

    private boolean isErrorIconVisible() {
        return this.errorIconView.getVisibility() == 0;
    }

    private boolean isSingleLineFilledTextField() {
        return this.boxBackgroundMode == 1 && this.editText.getMinLines() <= 1;
    }

    private int[] mergeIconState(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        return iArrCopyOf;
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        setEditTextBoxBackground();
        updateTextInputBoxState();
        updateBoxCollapsedPaddingTop();
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.getCollapsedTextActualBounds(rectF, this.editText.getWidth(), this.editText.getGravity());
            applyCutoutPadding(rectF);
            rectF.offset(-getPaddingLeft(), -getPaddingTop());
            C4436g c4436g = (C4436g) this.boxBackground;
            Objects.requireNonNull(c4436g);
            c4436g.m6149a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    private static void recursiveSetEnabled(@NonNull ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z2);
            }
        }
    }

    private void refreshIconDrawableState(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int colorForState = colorStateList.getColorForState(mergeIconState(checkableImageButton), colorStateList.getDefaultColor());
        Drawable drawableMutate = DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTintList(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    private void removePlaceholderTextView() {
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (this.endIconMode != 3 && !(editText instanceof TextInputEditText)) {
            Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.editText = editText;
        onApplyBoxBackgroundMode();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.collapsingTextHelper.setTypefaces(this.editText.getTypeface());
        this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
        int gravity = this.editText.getGravity();
        this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
        this.collapsingTextHelper.setExpandedTextGravity(gravity);
        this.editText.addTextChangedListener(new C11015a());
        if (this.defaultHintTextColor == null) {
            this.defaultHintTextColor = this.editText.getHintTextColors();
        }
        if (this.hintEnabled) {
            if (TextUtils.isEmpty(this.hint)) {
                CharSequence hint = this.editText.getHint();
                this.originalHint = hint;
                setHint(hint);
                this.editText.setHint((CharSequence) null);
            }
            this.isProvidingHint = true;
        }
        if (this.counterView != null) {
            updateCounter(this.editText.getText().length());
        }
        updateEditTextBackground();
        this.indicatorViewController.m6158b();
        this.startLayout.bringToFront();
        this.endLayout.bringToFront();
        this.endIconFrame.bringToFront();
        this.errorIconView.bringToFront();
        dispatchOnEditTextAttached();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        updateLabelState(false, true);
    }

    private void setEditTextBoxBackground() {
        if (shouldUseEditTextBackgroundForBoxBackground()) {
            ViewCompat.setBackground(this.editText, this.boxBackground);
        }
    }

    private void setErrorIconVisible(boolean z2) {
        this.errorIconView.setVisibility(z2 ? 0 : 8);
        this.endIconFrame.setVisibility(z2 ? 8 : 0);
        updateSuffixTextViewPadding();
        if (hasEndIcon()) {
            return;
        }
        updateDummyDrawables();
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.hint)) {
            return;
        }
        this.hint = charSequence;
        this.collapsingTextHelper.setText(charSequence);
        if (this.hintExpanded) {
            return;
        }
        openCutout();
    }

    private static void setIconClickable(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        boolean zHasOnClickListeners = ViewCompat.hasOnClickListeners(checkableImageButton);
        boolean z2 = onLongClickListener != null;
        boolean z3 = zHasOnClickListeners || z2;
        checkableImageButton.setFocusable(z3);
        checkableImageButton.setClickable(zHasOnClickListeners);
        checkableImageButton.setPressable(zHasOnClickListeners);
        checkableImageButton.setLongClickable(z2);
        ViewCompat.setImportantForAccessibility(checkableImageButton, z3 ? 1 : 2);
    }

    private static void setIconOnClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnClickListener onClickListener, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private static void setIconOnLongClickListener(@NonNull CheckableImageButton checkableImageButton, @Nullable View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        setIconClickable(checkableImageButton, onLongClickListener);
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.placeholderEnabled == z2) {
            return;
        }
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(C10817R.id.textinput_placeholder);
            ViewCompat.setAccessibilityLiveRegion(this.placeholderTextView, 1);
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            addPlaceholderTextView();
        } else {
            removePlaceholderTextView();
            this.placeholderTextView = null;
        }
        this.placeholderEnabled = z2;
    }

    private boolean shouldUpdateEndDummyDrawable() {
        return (this.errorIconView.getVisibility() == 0 || ((hasEndIcon() && isEndIconVisible()) || this.suffixText != null)) && this.endLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUpdateStartDummyDrawable() {
        return !(getStartIconDrawable() == null && this.prefixText == null) && this.startLayout.getMeasuredWidth() > 0;
    }

    private boolean shouldUseEditTextBackgroundForBoxBackground() {
        EditText editText = this.editText;
        return (editText == null || this.boxBackground == null || editText.getBackground() != null || this.boxBackgroundMode == 0) ? false : true;
    }

    private void showPlaceholderText() {
        TextView textView = this.placeholderTextView;
        if (textView == null || !this.placeholderEnabled) {
            return;
        }
        textView.setText(this.placeholderText);
        this.placeholderTextView.setVisibility(0);
        this.placeholderTextView.bringToFront();
    }

    private void tintEndIconOnError(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            applyEndIconTint();
            return;
        }
        Drawable drawableMutate = DrawableCompat.wrap(getEndIconDrawable()).mutate();
        DrawableCompat.setTint(drawableMutate, this.indicatorViewController.m6163g());
        this.endIconView.setImageDrawable(drawableMutate);
    }

    private void updateBoxCollapsedPaddingTop() {
        if (this.boxBackgroundMode == 1) {
            if (MaterialResources.isFontScaleAtLeast2_0(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(C10817R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (MaterialResources.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(C10817R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
    }

    private void updateBoxUnderlineBounds(@NonNull Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.boxUnderline;
        if (materialShapeDrawable != null) {
            int i = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i - this.boxStrokeWidthFocusedPx, rect.right, i);
        }
    }

    private void updateCounter() {
        if (this.counterView != null) {
            EditText editText = this.editText;
            updateCounter(editText == null ? 0 : editText.getText().length());
        }
    }

    private static void updateCounterContentDescription(@NonNull Context context, @NonNull TextView textView, int i, int i2, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? C10817R.string.character_counter_overflowed_content_description : C10817R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    private void updateCounterTextAppearanceAndColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.counterView;
        if (textView != null) {
            setTextAppearanceCompatWithErrorFallback(textView, this.counterOverflowed ? this.counterOverflowTextAppearance : this.counterTextAppearance);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (!this.counterOverflowed || (colorStateList = this.counterOverflowTextColor) == null) {
                return;
            }
            this.counterView.setTextColor(colorStateList);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    private boolean updateDummyDrawables() {
        boolean z2;
        if (this.editText == null) {
            return false;
        }
        boolean z3 = true;
        if (shouldUpdateStartDummyDrawable()) {
            int measuredWidth = this.startLayout.getMeasuredWidth() - this.editText.getPaddingLeft();
            if (this.startDummyDrawable == null || this.startDummyDrawableWidth != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.startDummyDrawable = colorDrawable;
                this.startDummyDrawableWidth = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.startDummyDrawable;
            if (drawable != drawable2) {
                TextViewCompat.setCompoundDrawablesRelative(this.editText, drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z2 = true;
            } else {
                z2 = false;
            }
        } else if (this.startDummyDrawable != null) {
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            TextViewCompat.setCompoundDrawablesRelative(this.editText, null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
            this.startDummyDrawable = null;
            z2 = true;
        } else {
            z2 = false;
        }
        if (shouldUpdateEndDummyDrawable()) {
            int measuredWidth2 = this.suffixTextView.getMeasuredWidth() - this.editText.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()) + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            Drawable drawable3 = this.endDummyDrawable;
            if (drawable3 == null || this.endDummyDrawableWidth == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.endDummyDrawable = colorDrawable2;
                    this.endDummyDrawableWidth = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.endDummyDrawable;
                if (drawable4 != drawable5) {
                    this.originalEditTextEndDrawable = compoundDrawablesRelative3[2];
                    TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z3 = z2;
                }
            } else {
                this.endDummyDrawableWidth = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.endDummyDrawable, compoundDrawablesRelative3[3]);
            }
        } else {
            if (this.endDummyDrawable == null) {
                return z2;
            }
            Drawable[] compoundDrawablesRelative4 = TextViewCompat.getCompoundDrawablesRelative(this.editText);
            if (compoundDrawablesRelative4[2] == this.endDummyDrawable) {
                TextViewCompat.setCompoundDrawablesRelative(this.editText, compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.originalEditTextEndDrawable, compoundDrawablesRelative4[3]);
            } else {
                z3 = z2;
            }
            this.endDummyDrawable = null;
        }
        return z3;
    }

    private boolean updateEditTextHeightBasedOnIcon() {
        int iMax;
        if (this.editText == null || this.editText.getMeasuredHeight() >= (iMax = Math.max(this.endLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            return false;
        }
        this.editText.setMinimumHeight(iMax);
        return true;
    }

    private void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
            int iCalculateLabelMarginTop = calculateLabelMarginTop();
            if (iCalculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = iCalculateLabelMarginTop;
                this.inputFrame.requestLayout();
            }
        }
    }

    private void updatePlaceholderMeasurementsBasedOnEditText() {
        EditText editText;
        if (this.placeholderTextView == null || (editText = this.editText) == null) {
            return;
        }
        this.placeholderTextView.setGravity(editText.getGravity());
        this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
    }

    private void updatePlaceholderText() {
        EditText editText = this.editText;
        updatePlaceholderText(editText == null ? 0 : editText.getText().length());
    }

    private void updatePrefixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.prefixTextView, isStartIconVisible() ? 0 : ViewCompat.getPaddingStart(this.editText), this.editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(C10817R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getCompoundPaddingBottom());
    }

    private void updatePrefixTextVisibility() {
        this.prefixTextView.setVisibility((this.prefixText == null || isHintExpanded()) ? 8 : 0);
        updateDummyDrawables();
    }

    private void updateStrokeErrorColor(boolean z2, boolean z3) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{R.attr.state_activated, R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.boxStrokeColor = colorForState2;
        } else if (z3) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    private void updateSuffixTextViewPadding() {
        if (this.editText == null) {
            return;
        }
        ViewCompat.setPaddingRelative(this.suffixTextView, getContext().getResources().getDimensionPixelSize(C10817R.dimen.material_input_text_to_prefix_suffix_padding), this.editText.getPaddingTop(), (isEndIconVisible() || isErrorIconVisible()) ? 0 : ViewCompat.getPaddingEnd(this.editText), this.editText.getPaddingBottom());
    }

    private void updateSuffixTextVisibility() {
        int visibility = this.suffixTextView.getVisibility();
        boolean z2 = (this.suffixText == null || isHintExpanded()) ? false : true;
        this.suffixTextView.setVisibility(z2 ? 0 : 8);
        if (visibility != this.suffixTextView.getVisibility()) {
            getEndIconDelegate().mo6147c(z2);
        }
        updateDummyDrawables();
    }

    public void addOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.add(onEditTextAttachedListener);
        if (this.editText != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void addOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.add(onEndIconChangedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i, @NonNull ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.inputFrame.addView(view, layoutParams2);
        this.inputFrame.setLayoutParams(layoutParams);
        updateInputLayoutMargins();
        setEditText((EditText) view);
    }

    @VisibleForTesting
    public void animateToExpansionFraction(float f) {
        if (this.collapsingTextHelper.getExpansionFraction() == f) {
            return;
        }
        if (this.animator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.animator = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            this.animator.setDuration(167L);
            this.animator.addUpdateListener(new C11018d());
        }
        this.animator.setFloatValues(this.collapsingTextHelper.getExpansionFraction(), f);
        this.animator.start();
    }

    public void clearOnEditTextAttachedListeners() {
        this.editTextAttachedListeners.clear();
    }

    public void clearOnEndIconChangedListeners() {
        this.endIconChangedListeners.clear();
    }

    @VisibleForTesting
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && (((C4436g) this.boxBackground).f11789k.isEmpty() ^ true);
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(26)
    public void dispatchProvideAutofillStructure(@NonNull ViewStructure viewStructure, int i) {
        EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z2 = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
                return;
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
        onProvideAutofillVirtualStructure(viewStructure, i);
        viewStructure.setChildCount(this.inputFrame.getChildCount());
        for (int i2 = 0; i2 < this.inputFrame.getChildCount(); i2++) {
            View childAt = this.inputFrame.getChildAt(i2);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i2);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i);
            if (childAt == this.editText) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(@NonNull SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        drawHint(canvas);
        drawBoxUnderline(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.inDrawableStateChanged) {
            return;
        }
        this.inDrawableStateChanged = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        boolean state = collapsingTextHelper != null ? collapsingTextHelper.setState(drawableState) | false : false;
        if (this.editText != null) {
            updateLabelState(ViewCompat.isLaidOut(this) && isEnabled());
        }
        updateEditTextBackground();
        updateTextInputBoxState();
        if (state) {
            invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        if (editText == null) {
            return super.getBaseline();
        }
        return getPaddingTop() + editText.getBaseline() + calculateLabelMarginTop();
    }

    @NonNull
    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxBackground.getBottomLeftCornerResolvedSize();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxBackground.getBottomRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxBackground.getTopRightCornerResolvedSize();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxBackground.getTopLeftCornerResolvedSize();
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    @Nullable
    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    @Nullable
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.counterEnabled && this.counterOverflowed && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    @Nullable
    public ColorStateList getCounterOverflowTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    @Nullable
    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    @Nullable
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getEndIconContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    public Drawable getEndIconDrawable() {
        return this.endIconView.getDrawable();
    }

    public int getEndIconMode() {
        return this.endIconMode;
    }

    @NonNull
    public CheckableImageButton getEndIconView() {
        return this.endIconView;
    }

    @Nullable
    public CharSequence getError() {
        C4443n c4443n = this.indicatorViewController;
        if (c4443n.f11832k) {
            return c4443n.f11831j;
        }
        return null;
    }

    @Nullable
    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.f11834m;
    }

    @ColorInt
    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.m6163g();
    }

    @Nullable
    public Drawable getErrorIconDrawable() {
        return this.errorIconView.getDrawable();
    }

    @VisibleForTesting
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.m6163g();
    }

    @Nullable
    public CharSequence getHelperText() {
        C4443n c4443n = this.indicatorViewController;
        if (c4443n.f11838q) {
            return c4443n.f11837p;
        }
        return null;
    }

    @ColorInt
    public int getHelperTextCurrentTextColor() {
        TextView textView = this.indicatorViewController.f11839r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    @Nullable
    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    @VisibleForTesting
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    @VisibleForTesting
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    @Nullable
    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    @Nullable
    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endIconView.getContentDescription();
    }

    @Nullable
    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endIconView.getDrawable();
    }

    @Nullable
    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    @StyleRes
    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    @Nullable
    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    @Nullable
    public CharSequence getPrefixText() {
        return this.prefixText;
    }

    @Nullable
    public ColorStateList getPrefixTextColor() {
        return this.prefixTextView.getTextColors();
    }

    @NonNull
    public TextView getPrefixTextView() {
        return this.prefixTextView;
    }

    @Nullable
    public CharSequence getStartIconContentDescription() {
        return this.startIconView.getContentDescription();
    }

    @Nullable
    public Drawable getStartIconDrawable() {
        return this.startIconView.getDrawable();
    }

    @Nullable
    public CharSequence getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public ColorStateList getSuffixTextColor() {
        return this.suffixTextView.getTextColors();
    }

    @NonNull
    public TextView getSuffixTextView() {
        return this.suffixTextView;
    }

    @Nullable
    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isEndIconCheckable() {
        return this.endIconView.isCheckable();
    }

    public boolean isEndIconVisible() {
        return this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.f11832k;
    }

    public boolean isExpandedHintEnabled() {
        return this.expandedHintEnabled;
    }

    @VisibleForTesting
    public final boolean isHelperTextDisplayed() {
        C4443n c4443n = this.indicatorViewController;
        return (c4443n.f11829h != 2 || c4443n.f11839r == null || TextUtils.isEmpty(c4443n.f11837p)) ? false : true;
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.f11838q;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    @VisibleForTesting
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    @Deprecated
    public boolean isPasswordVisibilityToggleEnabled() {
        return this.endIconMode == 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public boolean isStartIconCheckable() {
        return this.startIconView.isCheckable();
    }

    public boolean isStartIconVisible() {
        return this.startIconView.getVisibility() == 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        EditText editText = this.editText;
        if (editText != null) {
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(this, editText, rect);
            updateBoxUnderlineBounds(rect);
            if (this.hintEnabled) {
                this.collapsingTextHelper.setExpandedTextSize(this.editText.getTextSize());
                int gravity = this.editText.getGravity();
                this.collapsingTextHelper.setCollapsedTextGravity((gravity & (-113)) | 48);
                this.collapsingTextHelper.setExpandedTextGravity(gravity);
                this.collapsingTextHelper.setCollapsedBounds(calculateCollapsedTextBounds(rect));
                this.collapsingTextHelper.setExpandedBounds(calculateExpandedTextBounds(rect));
                this.collapsingTextHelper.recalculate();
                if (!cutoutEnabled() || this.hintExpanded) {
                    return;
                }
                openCutout();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        boolean zUpdateEditTextHeightBasedOnIcon = updateEditTextHeightBasedOnIcon();
        boolean zUpdateDummyDrawables = updateDummyDrawables();
        if (zUpdateEditTextHeightBasedOnIcon || zUpdateDummyDrawables) {
            this.editText.post(new RunnableC11017c());
        }
        updatePlaceholderMeasurementsBasedOnEditText();
        updatePrefixTextViewPadding();
        updateSuffixTextViewPadding();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f21172j);
        if (savedState.f21173k) {
            this.endIconView.post(new RunnableC11016b());
        }
        setHint(savedState.f21174l);
        setHelperText(savedState.f21175m);
        setPlaceholderText(savedState.f21176n);
        requestLayout();
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.m6161e()) {
            savedState.f21172j = getError();
        }
        savedState.f21173k = hasEndIcon() && this.endIconView.isChecked();
        savedState.f21174l = getHint();
        savedState.f21175m = getHelperText();
        savedState.f21176n = getPlaceholderText();
        return savedState;
    }

    @Deprecated
    public void passwordVisibilityToggleRequested(boolean z2) {
        if (this.endIconMode == 1) {
            this.endIconView.performClick();
            if (z2) {
                this.endIconView.jumpDrawablesToCurrentState();
            }
        }
    }

    public void refreshEndIconDrawableState() {
        refreshIconDrawableState(this.endIconView, this.endIconTintList);
    }

    public void refreshErrorIconDrawableState() {
        refreshIconDrawableState(this.errorIconView, this.errorIconTintList);
    }

    public void refreshStartIconDrawableState() {
        refreshIconDrawableState(this.startIconView, this.startIconTintList);
    }

    public void removeOnEditTextAttachedListener(@NonNull OnEditTextAttachedListener onEditTextAttachedListener) {
        this.editTextAttachedListeners.remove(onEditTextAttachedListener);
    }

    public void removeOnEndIconChangedListener(@NonNull OnEndIconChangedListener onEndIconChangedListener) {
        this.endIconChangedListeners.remove(onEndIconChangedListener);
    }

    public void setBoxBackgroundColor(@ColorInt int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(@ColorRes int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(@NonNull ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.boxBackgroundMode) {
            return;
        }
        this.boxBackgroundMode = i;
        if (this.editText != null) {
            onApplyBoxBackgroundMode();
        }
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null && materialShapeDrawable.getTopLeftCornerResolvedSize() == f && this.boxBackground.getTopRightCornerResolvedSize() == f2 && this.boxBackground.getBottomRightCornerResolvedSize() == f4 && this.boxBackground.getBottomLeftCornerResolvedSize() == f3) {
            return;
        }
        this.shapeAppearanceModel = this.shapeAppearanceModel.toBuilder().setTopLeftCornerSize(f).setTopRightCornerSize(f2).setBottomRightCornerSize(f4).setBottomLeftCornerSize(f3).build();
        applyBoxAttributes();
    }

    public void setBoxCornerRadiiResources(@DimenRes int i, @DimenRes int i2, @DimenRes int i3, @DimenRes int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i4), getContext().getResources().getDimension(i3));
    }

    public void setBoxStrokeColor(@ColorInt int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(@Nullable ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(@DimenRes int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(@DimenRes int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.counterEnabled != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.counterView = appCompatTextView;
                appCompatTextView.setId(C10817R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                this.indicatorViewController.m6157a(this.counterView, 2);
                MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams(), getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                updateCounter();
            } else {
                this.indicatorViewController.m6166j(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z2;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                updateCounter();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(@Nullable ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setDefaultHintTextColor(@Nullable ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        recursiveSetEnabled(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.endIconView.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.endIconView.setCheckable(z2);
    }

    public void setEndIconContentDescription(@StringRes int i) {
        setEndIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setEndIconDrawable(@DrawableRes int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconMode(int i) {
        int i2 = this.endIconMode;
        this.endIconMode = i;
        dispatchOnEndIconChanged(i2);
        setEndIconVisible(i != 0);
        if (getEndIconDelegate().mo6154b(this.boxBackgroundMode)) {
            getEndIconDelegate().mo6146a();
            applyEndIconTint();
        } else {
            StringBuilder sbM833U = C1643a.m833U("The current box background mode ");
            sbM833U.append(this.boxBackgroundMode);
            sbM833U.append(" is not supported by the end icon mode ");
            sbM833U.append(i);
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    public void setEndIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.endIconView, onClickListener, this.endIconOnLongClickListener);
    }

    public void setEndIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.endIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.endIconView, onLongClickListener);
    }

    public void setEndIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.endIconTintList != colorStateList) {
            this.endIconTintList = colorStateList;
            this.hasEndIconTintList = true;
            applyEndIconTint();
        }
    }

    public void setEndIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.endIconTintMode != mode) {
            this.endIconTintMode = mode;
            this.hasEndIconTintMode = true;
            applyEndIconTint();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (isEndIconVisible() != z2) {
            this.endIconView.setVisibility(z2 ? 0 : 8);
            updateSuffixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setError(@Nullable CharSequence charSequence) {
        if (!this.indicatorViewController.f11832k) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.m6165i();
            return;
        }
        C4443n c4443n = this.indicatorViewController;
        c4443n.m6159c();
        c4443n.f11831j = charSequence;
        c4443n.f11833l.setText(charSequence);
        int i = c4443n.f11829h;
        if (i != 1) {
            c4443n.f11830i = 1;
        }
        c4443n.m6168l(i, c4443n.f11830i, c4443n.m6167k(c4443n.f11833l, charSequence));
    }

    public void setErrorContentDescription(@Nullable CharSequence charSequence) {
        C4443n c4443n = this.indicatorViewController;
        c4443n.f11834m = charSequence;
        TextView textView = c4443n.f11833l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        C4443n c4443n = this.indicatorViewController;
        if (c4443n.f11832k == z2) {
            return;
        }
        c4443n.m6159c();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c4443n.f11822a);
            c4443n.f11833l = appCompatTextView;
            appCompatTextView.setId(C10817R.id.textinput_error);
            c4443n.f11833l.setTextAlignment(5);
            Typeface typeface = c4443n.f11842u;
            if (typeface != null) {
                c4443n.f11833l.setTypeface(typeface);
            }
            int i = c4443n.f11835n;
            c4443n.f11835n = i;
            TextView textView = c4443n.f11833l;
            if (textView != null) {
                c4443n.f11823b.setTextAppearanceCompatWithErrorFallback(textView, i);
            }
            ColorStateList colorStateList = c4443n.f11836o;
            c4443n.f11836o = colorStateList;
            TextView textView2 = c4443n.f11833l;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            CharSequence charSequence = c4443n.f11834m;
            c4443n.f11834m = charSequence;
            TextView textView3 = c4443n.f11833l;
            if (textView3 != null) {
                textView3.setContentDescription(charSequence);
            }
            c4443n.f11833l.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(c4443n.f11833l, 1);
            c4443n.m6157a(c4443n.f11833l, 0);
        } else {
            c4443n.m6165i();
            c4443n.m6166j(c4443n.f11833l, 0);
            c4443n.f11833l = null;
            c4443n.f11823b.updateEditTextBackground();
            c4443n.f11823b.updateTextInputBoxState();
        }
        c4443n.f11832k = z2;
    }

    public void setErrorIconDrawable(@DrawableRes int i) {
        setErrorIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
        refreshErrorIconDrawableState();
    }

    public void setErrorIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.errorIconView, onClickListener, this.errorIconOnLongClickListener);
    }

    public void setErrorIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.errorIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.errorIconView, onLongClickListener);
    }

    public void setErrorIconTintList(@Nullable ColorStateList colorStateList) {
        this.errorIconTintList = colorStateList;
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(@Nullable PorterDuff.Mode mode) {
        Drawable drawable = this.errorIconView.getDrawable();
        if (drawable != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintMode(drawable, mode);
        }
        if (this.errorIconView.getDrawable() != drawable) {
            this.errorIconView.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(@StyleRes int i) {
        C4443n c4443n = this.indicatorViewController;
        c4443n.f11835n = i;
        TextView textView = c4443n.f11833l;
        if (textView != null) {
            c4443n.f11823b.setTextAppearanceCompatWithErrorFallback(textView, i);
        }
    }

    public void setErrorTextColor(@Nullable ColorStateList colorStateList) {
        C4443n c4443n = this.indicatorViewController;
        c4443n.f11836o = colorStateList;
        TextView textView = c4443n.f11833l;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.expandedHintEnabled != z2) {
            this.expandedHintEnabled = z2;
            updateLabelState(false);
        }
    }

    public void setHelperText(@Nullable CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (isHelperTextEnabled()) {
                setHelperTextEnabled(false);
                return;
            }
            return;
        }
        if (!isHelperTextEnabled()) {
            setHelperTextEnabled(true);
        }
        C4443n c4443n = this.indicatorViewController;
        c4443n.m6159c();
        c4443n.f11837p = charSequence;
        c4443n.f11839r.setText(charSequence);
        int i = c4443n.f11829h;
        if (i != 2) {
            c4443n.f11830i = 2;
        }
        c4443n.m6168l(i, c4443n.f11830i, c4443n.m6167k(c4443n.f11839r, charSequence));
    }

    public void setHelperTextColor(@Nullable ColorStateList colorStateList) {
        C4443n c4443n = this.indicatorViewController;
        c4443n.f11841t = colorStateList;
        TextView textView = c4443n.f11839r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        C4443n c4443n = this.indicatorViewController;
        if (c4443n.f11838q == z2) {
            return;
        }
        c4443n.m6159c();
        if (z2) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(c4443n.f11822a);
            c4443n.f11839r = appCompatTextView;
            appCompatTextView.setId(C10817R.id.textinput_helper_text);
            c4443n.f11839r.setTextAlignment(5);
            Typeface typeface = c4443n.f11842u;
            if (typeface != null) {
                c4443n.f11839r.setTypeface(typeface);
            }
            c4443n.f11839r.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(c4443n.f11839r, 1);
            int i = c4443n.f11840s;
            c4443n.f11840s = i;
            TextView textView = c4443n.f11839r;
            if (textView != null) {
                TextViewCompat.setTextAppearance(textView, i);
            }
            ColorStateList colorStateList = c4443n.f11841t;
            c4443n.f11841t = colorStateList;
            TextView textView2 = c4443n.f11839r;
            if (textView2 != null && colorStateList != null) {
                textView2.setTextColor(colorStateList);
            }
            c4443n.m6157a(c4443n.f11839r, 1);
        } else {
            c4443n.m6159c();
            int i2 = c4443n.f11829h;
            if (i2 == 2) {
                c4443n.f11830i = 0;
            }
            c4443n.m6168l(i2, c4443n.f11830i, c4443n.m6167k(c4443n.f11839r, null));
            c4443n.m6166j(c4443n.f11839r, 1);
            c4443n.f11839r = null;
            c4443n.f11823b.updateEditTextBackground();
            c4443n.f11823b.updateTextInputBoxState();
        }
        c4443n.f11838q = z2;
    }

    public void setHelperTextTextAppearance(@StyleRes int i) {
        C4443n c4443n = this.indicatorViewController;
        c4443n.f11840s = i;
        TextView textView = c4443n.f11839r;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.hintAnimationEnabled = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.hintEnabled) {
            this.hintEnabled = z2;
            if (z2) {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            } else {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(@StyleRes int i) {
        this.collapsingTextHelper.setCollapsedTextAppearance(i);
        this.focusedTextColor = this.collapsingTextHelper.getCollapsedTextColor();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(@Nullable ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@StringRes int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@DrawableRes int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.endIconMode != 1) {
            setEndIconMode(1);
        } else {
            if (z2) {
                return;
            }
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(@Nullable ColorStateList colorStateList) {
        this.endIconTintList = colorStateList;
        this.hasEndIconTintList = true;
        applyEndIconTint();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(@Nullable PorterDuff.Mode mode) {
        this.endIconTintMode = mode;
        this.hasEndIconTintMode = true;
        applyEndIconTint();
    }

    public void setPlaceholderText(@Nullable CharSequence charSequence) {
        if (this.placeholderEnabled && TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        updatePlaceholderText();
    }

    public void setPlaceholderTextAppearance(@StyleRes int i) {
        this.placeholderTextAppearance = i;
        TextView textView = this.placeholderTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, i);
        }
    }

    public void setPlaceholderTextColor(@Nullable ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            TextView textView = this.placeholderTextView;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(@Nullable CharSequence charSequence) {
        this.prefixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.prefixTextView.setText(charSequence);
        updatePrefixTextVisibility();
    }

    public void setPrefixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.prefixTextView, i);
    }

    public void setPrefixTextColor(@NonNull ColorStateList colorStateList) {
        this.prefixTextView.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.startIconView.setCheckable(z2);
    }

    public void setStartIconContentDescription(@StringRes int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(@DrawableRes int i) {
        setStartIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setStartIconOnClickListener(@Nullable View.OnClickListener onClickListener) {
        setIconOnClickListener(this.startIconView, onClickListener, this.startIconOnLongClickListener);
    }

    public void setStartIconOnLongClickListener(@Nullable View.OnLongClickListener onLongClickListener) {
        this.startIconOnLongClickListener = onLongClickListener;
        setIconOnLongClickListener(this.startIconView, onLongClickListener);
    }

    public void setStartIconTintList(@Nullable ColorStateList colorStateList) {
        if (this.startIconTintList != colorStateList) {
            this.startIconTintList = colorStateList;
            this.hasStartIconTintList = true;
            applyStartIconTint();
        }
    }

    public void setStartIconTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.startIconTintMode != mode) {
            this.startIconTintMode = mode;
            this.hasStartIconTintMode = true;
            applyStartIconTint();
        }
    }

    public void setStartIconVisible(boolean z2) {
        if (isStartIconVisible() != z2) {
            this.startIconView.setVisibility(z2 ? 0 : 8);
            updatePrefixTextViewPadding();
            updateDummyDrawables();
        }
    }

    public void setSuffixText(@Nullable CharSequence charSequence) {
        this.suffixText = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.suffixTextView.setText(charSequence);
        updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(@StyleRes int i) {
        TextViewCompat.setTextAppearance(this.suffixTextView, i);
    }

    public void setSuffixTextColor(@NonNull ColorStateList colorStateList) {
        this.suffixTextView.setTextColor(colorStateList);
    }

    public void setTextAppearanceCompatWithErrorFallback(@NonNull TextView textView, @StyleRes int i) {
        boolean z2 = true;
        try {
            TextViewCompat.setTextAppearance(textView, i);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            TextViewCompat.setTextAppearance(textView, C10817R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(ContextCompat.getColor(getContext(), C10817R.color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(@Nullable AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(@Nullable Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            C4443n c4443n = this.indicatorViewController;
            if (typeface != c4443n.f11842u) {
                c4443n.f11842u = typeface;
                TextView textView = c4443n.f11833l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = c4443n.f11839r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.counterView;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void updateEditTextBackground() {
        Drawable background;
        TextView textView;
        EditText editText = this.editText;
        if (editText == null || this.boxBackgroundMode != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.canSafelyMutateDrawable(background)) {
            background = background.mutate();
        }
        if (this.indicatorViewController.m6161e()) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.indicatorViewController.m6163g(), PorterDuff.Mode.SRC_IN));
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.editText.refreshDrawableState();
        }
    }

    public void updateLabelState(boolean z2) {
        updateLabelState(z2, false);
    }

    public void updateTextInputBoxState() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground == null || this.boxBackgroundMode == 0) {
            return;
        }
        boolean z2 = false;
        boolean z3 = isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus());
        boolean z4 = isHovered() || ((editText = this.editText) != null && editText.isHovered());
        if (!isEnabled()) {
            this.boxStrokeColor = this.disabledColor;
        } else if (this.indicatorViewController.m6161e()) {
            if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z3, z4);
            } else {
                this.boxStrokeColor = this.indicatorViewController.m6163g();
            }
        } else if (!this.counterOverflowed || (textView = this.counterView) == null) {
            if (z3) {
                this.boxStrokeColor = this.focusedStrokeColor;
            } else if (z4) {
                this.boxStrokeColor = this.hoveredStrokeColor;
            } else {
                this.boxStrokeColor = this.defaultStrokeColor;
            }
        } else if (this.strokeErrorColor != null) {
            updateStrokeErrorColor(z3, z4);
        } else {
            this.boxStrokeColor = textView.getCurrentTextColor();
        }
        if (getErrorIconDrawable() != null) {
            C4443n c4443n = this.indicatorViewController;
            if (c4443n.f11832k && c4443n.m6161e()) {
                z2 = true;
            }
        }
        setErrorIconVisible(z2);
        refreshErrorIconDrawableState();
        refreshStartIconDrawableState();
        refreshEndIconDrawableState();
        AbstractC4442m endIconDelegate = getEndIconDelegate();
        Objects.requireNonNull(endIconDelegate);
        if (endIconDelegate instanceof C4437h) {
            tintEndIconOnError(this.indicatorViewController.m6161e());
        }
        if (z3 && isEnabled()) {
            this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
        } else {
            this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        }
        if (this.boxBackgroundMode == 1) {
            if (!isEnabled()) {
                this.boxBackgroundColor = this.disabledFilledBackgroundColor;
            } else if (z4 && !z3) {
                this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
            } else if (z3) {
                this.boxBackgroundColor = this.focusedFilledBackgroundColor;
            } else {
                this.boxBackgroundColor = this.defaultFilledBackgroundColor;
            }
        }
        applyBoxAttributes();
    }

    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, C10817R.attr.textInputStyle);
    }

    private void updateLabelState(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.editText;
        boolean z4 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.editText;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean zM6161e = this.indicatorViewController.m6161e();
        ColorStateList colorStateList2 = this.defaultHintTextColor;
        if (colorStateList2 != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList2);
            this.collapsingTextHelper.setExpandedTextColor(this.defaultHintTextColor);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.defaultHintTextColor;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.disabledColor) : this.disabledColor;
            this.collapsingTextHelper.setCollapsedTextColor(ColorStateList.valueOf(colorForState));
            this.collapsingTextHelper.setExpandedTextColor(ColorStateList.valueOf(colorForState));
        } else if (zM6161e) {
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            TextView textView2 = this.indicatorViewController.f11833l;
            collapsingTextHelper.setCollapsedTextColor(textView2 != null ? textView2.getTextColors() : null);
        } else if (this.counterOverflowed && (textView = this.counterView) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(textView.getTextColors());
        } else if (z5 && (colorStateList = this.focusedTextColor) != null) {
            this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
        }
        if (z4 || !this.expandedHintEnabled || (isEnabled() && z5)) {
            if (z3 || this.hintExpanded) {
                collapseHint(z2);
                return;
            }
            return;
        }
        if (z3 || !this.hintExpanded) {
            expandHint(z2);
        }
    }

    private void updatePlaceholderText(int i) {
        if (i != 0 || this.hintExpanded) {
            hidePlaceholderText();
        } else {
            showPlaceholderText();
        }
    }

    public void setEndIconContentDescription(@Nullable CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.endIconView.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setStartIconContentDescription(@Nullable CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.startIconView.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(@Nullable Drawable drawable) {
        this.startIconView.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            refreshStartIconDrawableState();
        } else {
            setStartIconVisible(false);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            setStartIconContentDescription((CharSequence) null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2;
        int i3;
        int i4 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i4), attributeSet, i);
        this.indicatorViewController = new C4443n(this);
        this.tmpRect = new Rect();
        this.tmpBoundsRect = new Rect();
        this.tmpRectF = new RectF();
        this.editTextAttachedListeners = new LinkedHashSet<>();
        this.endIconMode = 0;
        this.endIconDelegates = new SparseArray<>();
        this.endIconChangedListeners = new LinkedHashSet<>();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.startLayout = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.START));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.endLayout = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, GravityCompat.END));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.endIconFrame = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper.setTextSizeInterpolator(timeInterpolator);
        collapsingTextHelper.setPositionInterpolator(timeInterpolator);
        collapsingTextHelper.setCollapsedTextGravity(BadgeDrawable.TOP_START);
        int[] iArr = C10817R.styleable.TextInputLayout;
        int i5 = C10817R.styleable.TextInputLayout_counterTextAppearance;
        int i6 = C10817R.styleable.TextInputLayout_counterOverflowTextAppearance;
        int i7 = C10817R.styleable.TextInputLayout_errorTextAppearance;
        int i8 = C10817R.styleable.TextInputLayout_helperTextTextAppearance;
        int i9 = C10817R.styleable.TextInputLayout_hintTextAppearance;
        TintTypedArray tintTypedArrayObtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, iArr, i, i4, i5, i6, i7, i8, i9);
        this.hintEnabled = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_hintEnabled, true);
        setHint(tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_android_hint));
        this.hintAnimationEnabled = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.expandedHintEnabled = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_expandedHintEnabled, true);
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, i, i4).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(C10817R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelOffset(C10817R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxStrokeWidthDefaultPx = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(C10817R.styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(C10817R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = tintTypedArrayObtainTintedStyledAttributes.getDimensionPixelSize(C10817R.styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(C10817R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = tintTypedArrayObtainTintedStyledAttributes.getDimension(C10817R.styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float dimension2 = tintTypedArrayObtainTintedStyledAttributes.getDimension(C10817R.styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float dimension3 = tintTypedArrayObtainTintedStyledAttributes.getDimension(C10817R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float dimension4 = tintTypedArrayObtainTintedStyledAttributes.getDimension(C10817R.styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (dimension >= 0.0f) {
            builder.setTopLeftCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.setTopRightCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.setBottomRightCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.setBottomLeftCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, C10817R.styleable.TextInputLayout_boxBackgroundColor);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                i2 = 2;
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_focused, R.attr.state_enabled}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{R.attr.state_hovered, R.attr.state_enabled}, -1);
            } else {
                i2 = 2;
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateList2 = AppCompatResources.getColorStateList(context2, C10817R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{R.attr.state_hovered}, -1);
            }
        } else {
            i2 = 2;
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        int i10 = C10817R.styleable.TextInputLayout_android_textColorHint;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i10)) {
            ColorStateList colorStateList3 = tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i10);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        int i11 = C10817R.styleable.TextInputLayout_boxStrokeColor;
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i11);
        this.focusedStrokeColor = tintTypedArrayObtainTintedStyledAttributes.getColor(i11, 0);
        this.defaultStrokeColor = ContextCompat.getColor(context2, C10817R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = ContextCompat.getColor(context2, C10817R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = ContextCompat.getColor(context2, C10817R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        int i12 = C10817R.styleable.TextInputLayout_boxStrokeErrorColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i12)) {
            setBoxStrokeErrorColor(MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i12));
        }
        if (tintTypedArrayObtainTintedStyledAttributes.getResourceId(i9, -1) != -1) {
            setHintTextAppearance(tintTypedArrayObtainTintedStyledAttributes.getResourceId(i9, 0));
        }
        int resourceId = tintTypedArrayObtainTintedStyledAttributes.getResourceId(i7, 0);
        CharSequence text = tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_errorContentDescription);
        boolean z2 = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_errorEnabled, false);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int i13 = C10817R.layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflaterFrom.inflate(i13, (ViewGroup) linearLayout2, false);
        this.errorIconView = checkableImageButton;
        checkableImageButton.setId(C10817R.id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        int i14 = C10817R.styleable.TextInputLayout_errorIconDrawable;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i14)) {
            setErrorIconDrawable(tintTypedArrayObtainTintedStyledAttributes.getDrawable(i14));
        }
        int i15 = C10817R.styleable.TextInputLayout_errorIconTint;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i15)) {
            setErrorIconTintList(MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i15));
        }
        int i16 = C10817R.styleable.TextInputLayout_errorIconTintMode;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i16)) {
            setErrorIconTintMode(ViewUtils.parseTintMode(tintTypedArrayObtainTintedStyledAttributes.getInt(i16, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(C10817R.string.error_icon_content_description));
        ViewCompat.setImportantForAccessibility(checkableImageButton, i2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int resourceId2 = tintTypedArrayObtainTintedStyledAttributes.getResourceId(i8, 0);
        boolean z3 = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence text2 = tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_helperText);
        int resourceId3 = tintTypedArrayObtainTintedStyledAttributes.getResourceId(C10817R.styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence text3 = tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_placeholderText);
        int resourceId4 = tintTypedArrayObtainTintedStyledAttributes.getResourceId(C10817R.styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence text4 = tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_prefixText);
        int resourceId5 = tintTypedArrayObtainTintedStyledAttributes.getResourceId(C10817R.styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence text5 = tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_suffixText);
        boolean z4 = tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(tintTypedArrayObtainTintedStyledAttributes.getInt(C10817R.styleable.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = tintTypedArrayObtainTintedStyledAttributes.getResourceId(i5, 0);
        this.counterOverflowTextAppearance = tintTypedArrayObtainTintedStyledAttributes.getResourceId(i6, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(C10817R.layout.design_text_input_start_icon, (ViewGroup) this.startLayout, false);
        this.startIconView = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            MarginLayoutParamsCompat.setMarginEnd((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams(), 0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i17 = C10817R.styleable.TextInputLayout_startIconDrawable;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i17)) {
            setStartIconDrawable(tintTypedArrayObtainTintedStyledAttributes.getDrawable(i17));
            int i18 = C10817R.styleable.TextInputLayout_startIconContentDescription;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i18)) {
                setStartIconContentDescription(tintTypedArrayObtainTintedStyledAttributes.getText(i18));
            }
            setStartIconCheckable(tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_startIconCheckable, true));
        }
        int i19 = C10817R.styleable.TextInputLayout_startIconTint;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i19)) {
            setStartIconTintList(MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i19));
        }
        int i20 = C10817R.styleable.TextInputLayout_startIconTintMode;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i20)) {
            setStartIconTintMode(ViewUtils.parseTintMode(tintTypedArrayObtainTintedStyledAttributes.getInt(i20, -1), null));
        }
        setBoxBackgroundMode(tintTypedArrayObtainTintedStyledAttributes.getInt(C10817R.styleable.TextInputLayout_boxBackgroundMode, 0));
        this.endIconView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i13, (ViewGroup) this.endIconFrame, false);
        this.endIconFrame.addView(this.endIconView);
        this.endIconView.setVisibility(8);
        if (MaterialResources.isFontScaleAtLeast1_3(context2)) {
            i3 = 0;
            MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.endIconView.getLayoutParams(), 0);
        } else {
            i3 = 0;
        }
        this.endIconDelegates.append(-1, new C4435f(this));
        this.endIconDelegates.append(i3, new C4444o(this));
        this.endIconDelegates.append(1, new C4445p(this));
        this.endIconDelegates.append(2, new C4430a(this));
        this.endIconDelegates.append(3, new C4437h(this));
        int i21 = C10817R.styleable.TextInputLayout_endIconMode;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i21)) {
            setEndIconMode(tintTypedArrayObtainTintedStyledAttributes.getInt(i21, 0));
            int i22 = C10817R.styleable.TextInputLayout_endIconDrawable;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i22)) {
                setEndIconDrawable(tintTypedArrayObtainTintedStyledAttributes.getDrawable(i22));
            }
            int i23 = C10817R.styleable.TextInputLayout_endIconContentDescription;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i23)) {
                setEndIconContentDescription(tintTypedArrayObtainTintedStyledAttributes.getText(i23));
            }
            setEndIconCheckable(tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_endIconCheckable, true));
        } else {
            int i24 = C10817R.styleable.TextInputLayout_passwordToggleEnabled;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i24)) {
                setEndIconMode(tintTypedArrayObtainTintedStyledAttributes.getBoolean(i24, false) ? 1 : 0);
                setEndIconDrawable(tintTypedArrayObtainTintedStyledAttributes.getDrawable(C10817R.styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(tintTypedArrayObtainTintedStyledAttributes.getText(C10817R.styleable.TextInputLayout_passwordToggleContentDescription));
                int i25 = C10817R.styleable.TextInputLayout_passwordToggleTint;
                if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i25)) {
                    setEndIconTintList(MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i25));
                }
                int i26 = C10817R.styleable.TextInputLayout_passwordToggleTintMode;
                if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i26)) {
                    setEndIconTintMode(ViewUtils.parseTintMode(tintTypedArrayObtainTintedStyledAttributes.getInt(i26, -1), null));
                }
            }
        }
        if (!tintTypedArrayObtainTintedStyledAttributes.hasValue(C10817R.styleable.TextInputLayout_passwordToggleEnabled)) {
            int i27 = C10817R.styleable.TextInputLayout_endIconTint;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i27)) {
                setEndIconTintList(MaterialResources.getColorStateList(context2, tintTypedArrayObtainTintedStyledAttributes, i27));
            }
            int i28 = C10817R.styleable.TextInputLayout_endIconTintMode;
            if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i28)) {
                setEndIconTintMode(ViewUtils.parseTintMode(tintTypedArrayObtainTintedStyledAttributes.getInt(i28, -1), null));
            }
        }
        AppCompatTextView appCompatTextView = new AppCompatTextView(context2);
        this.prefixTextView = appCompatTextView;
        appCompatTextView.setId(C10817R.id.textinput_prefix_text);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView, 1);
        this.startLayout.addView(this.startIconView);
        this.startLayout.addView(appCompatTextView);
        AppCompatTextView appCompatTextView2 = new AppCompatTextView(context2);
        this.suffixTextView = appCompatTextView2;
        appCompatTextView2.setId(C10817R.id.textinput_suffix_text);
        appCompatTextView2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        ViewCompat.setAccessibilityLiveRegion(appCompatTextView2, 1);
        this.endLayout.addView(appCompatTextView2);
        this.endLayout.addView(this.errorIconView);
        this.endLayout.addView(this.endIconFrame);
        setHelperTextEnabled(z3);
        setHelperText(text2);
        setHelperTextTextAppearance(resourceId2);
        setErrorEnabled(z2);
        setErrorTextAppearance(resourceId);
        setErrorContentDescription(text);
        setCounterTextAppearance(this.counterTextAppearance);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        setPrefixText(text4);
        setPrefixTextAppearance(resourceId4);
        setSuffixText(text5);
        setSuffixTextAppearance(resourceId5);
        int i29 = C10817R.styleable.TextInputLayout_errorTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i29)) {
            setErrorTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i29));
        }
        int i30 = C10817R.styleable.TextInputLayout_helperTextTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i30)) {
            setHelperTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i30));
        }
        int i31 = C10817R.styleable.TextInputLayout_hintTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i31)) {
            setHintTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i31));
        }
        int i32 = C10817R.styleable.TextInputLayout_counterTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i32)) {
            setCounterTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i32));
        }
        int i33 = C10817R.styleable.TextInputLayout_counterOverflowTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i33)) {
            setCounterOverflowTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i33));
        }
        int i34 = C10817R.styleable.TextInputLayout_placeholderTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i34)) {
            setPlaceholderTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i34));
        }
        int i35 = C10817R.styleable.TextInputLayout_prefixTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i35)) {
            setPrefixTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i35));
        }
        int i36 = C10817R.styleable.TextInputLayout_suffixTextColor;
        if (tintTypedArrayObtainTintedStyledAttributes.hasValue(i36)) {
            setSuffixTextColor(tintTypedArrayObtainTintedStyledAttributes.getColorStateList(i36));
        }
        setCounterEnabled(z4);
        setEnabled(tintTypedArrayObtainTintedStyledAttributes.getBoolean(C10817R.styleable.TextInputLayout_android_enabled, true));
        tintTypedArrayObtainTintedStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
    }

    public void setErrorIconDrawable(@Nullable Drawable drawable) {
        this.errorIconView.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.indicatorViewController.f11832k);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(@Nullable CharSequence charSequence) {
        this.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(@Nullable Drawable drawable) {
        this.endIconView.setImageDrawable(drawable);
    }

    public void updateCounter(int i) {
        boolean z2 = this.counterOverflowed;
        int i2 = this.counterMaxLength;
        if (i2 == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            this.counterOverflowed = i > i2;
            updateCounterContentDescription(getContext(), this.counterView, i, this.counterMaxLength, this.counterOverflowed);
            if (z2 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            this.counterView.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(C10817R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength))));
        }
        if (this.editText == null || z2 == this.counterOverflowed) {
            return;
        }
        updateLabelState(false);
        updateTextInputBoxState();
        updateEditTextBackground();
    }

    public void setHint(@StringRes int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }
}
