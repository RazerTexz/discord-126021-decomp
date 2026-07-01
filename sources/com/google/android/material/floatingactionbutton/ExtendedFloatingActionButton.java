package com.google.android.material.floatingactionbutton;

import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.core.view.ViewCompat;
import b.i.a.g.e.a;
import b.i.a.g.e.b;
import b.i.a.g.e.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout$AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private int animState;
    private boolean animateShowBeforeLayout;

    @NonNull
    private final CoordinatorLayout$Behavior<ExtendedFloatingActionButton> behavior;
    private final a changeVisibilityTracker;
    private final int collapsedSize;

    @NonNull
    private final j extendStrategy;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final j hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;

    @NonNull
    public ColorStateList originalTextCsl;
    private final j showStrategy;

    @NonNull
    private final j shrinkStrategy;
    private static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    public static final Property<View, Float> WIDTH = new ExtendedFloatingActionButton$d(Float.class, "width");
    public static final Property<View, Float> HEIGHT = new ExtendedFloatingActionButton$e(Float.class, "height");
    public static final Property<View, Float> PADDING_START = new ExtendedFloatingActionButton$f(Float.class, "paddingStart");
    public static final Property<View, Float> PADDING_END = new ExtendedFloatingActionButton$g(Float.class, "paddingEnd");

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingStart;
    }

    public static /* synthetic */ int access$100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingEnd;
    }

    public static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeShown();
    }

    public static /* synthetic */ boolean access$1100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeHidden();
    }

    public static /* synthetic */ j access$200(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.shrinkStrategy;
    }

    public static /* synthetic */ j access$300(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.hideStrategy;
    }

    public static /* synthetic */ void access$400(ExtendedFloatingActionButton extendedFloatingActionButton, j jVar, ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        extendedFloatingActionButton.performMotion(jVar, extendedFloatingActionButton$OnChangedCallback);
    }

    public static /* synthetic */ j access$500(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendStrategy;
    }

    public static /* synthetic */ j access$600(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.showStrategy;
    }

    public static /* synthetic */ boolean access$700(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isExtended;
    }

    public static /* synthetic */ boolean access$702(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z2) {
        extendedFloatingActionButton.isExtended = z2;
        return z2;
    }

    public static /* synthetic */ boolean access$802(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z2) {
        extendedFloatingActionButton.isTransforming = z2;
        return z2;
    }

    public static /* synthetic */ int access$902(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        extendedFloatingActionButton.animState = i;
        return i;
    }

    private boolean isOrWillBeHidden() {
        if (getVisibility() == 0) {
            return this.animState == 1;
        }
        return this.animState != 2;
    }

    private boolean isOrWillBeShown() {
        if (getVisibility() != 0) {
            return this.animState == 2;
        }
        return this.animState != 1;
    }

    private void performMotion(@NonNull j jVar, @Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        if (jVar.d()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            jVar.c();
            jVar.g(extendedFloatingActionButton$OnChangedCallback);
            return;
        }
        measure(0, 0);
        AnimatorSet animatorSetF = jVar.f();
        animatorSetF.addListener(new ExtendedFloatingActionButton$c(this, jVar, extendedFloatingActionButton$OnChangedCallback));
        Iterator<Animator$AnimatorListener> it = ((b) jVar).c.iterator();
        while (it.hasNext()) {
            animatorSetF.addListener(it.next());
        }
        animatorSetF.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        return (ViewCompat.isLaidOut(this) || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode();
    }

    public void addOnExtendAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.extendStrategy).c.add(animator$AnimatorListener);
    }

    public void addOnHideAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.hideStrategy).c.add(animator$AnimatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.showStrategy).c.add(animator$AnimatorListener);
    }

    public void addOnShrinkAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.shrinkStrategy).c.add(animator$AnimatorListener);
    }

    public void extend() {
        performMotion(this.extendStrategy, null);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
    @NonNull
    public CoordinatorLayout$Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    @VisibleForTesting
    public int getCollapsedSize() {
        int i = this.collapsedSize;
        return i < 0 ? (Math.min(ViewCompat.getPaddingStart(this), ViewCompat.getPaddingEnd(this)) * 2) + getIconSize() : i;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return ((b) this.extendStrategy).f;
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return ((b) this.hideStrategy).f;
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return ((b) this.showStrategy).f;
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return ((b) this.shrinkStrategy).f;
    }

    public void hide() {
        performMotion(this.hideStrategy, null);
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isExtended && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.isExtended = false;
            this.shrinkStrategy.c();
        }
    }

    public void removeOnExtendAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.extendStrategy).c.remove(animator$AnimatorListener);
    }

    public void removeOnHideAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.hideStrategy).c.remove(animator$AnimatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.showStrategy).c.remove(animator$AnimatorListener);
    }

    public void removeOnShrinkAnimationListener(@NonNull Animator$AnimatorListener animator$AnimatorListener) {
        ((b) this.shrinkStrategy).c.remove(animator$AnimatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z2) {
        this.animateShowBeforeLayout = z2;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        ((b) this.extendStrategy).f = motionSpec;
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z2) {
        if (this.isExtended == z2) {
            return;
        }
        j jVar = z2 ? this.extendStrategy : this.shrinkStrategy;
        if (jVar.d()) {
            return;
        }
        jVar.c();
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        ((b) this.hideStrategy).f = motionSpec;
    }

    public void setHideMotionSpecResource(@AnimatorRes int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = i;
        this.extendedPaddingEnd = i3;
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        ((b) this.showStrategy).f = motionSpec;
    }

    public void setShowMotionSpecResource(@AnimatorRes int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        ((b) this.shrinkStrategy).f = motionSpec;
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(this.showStrategy, null);
    }

    public void shrink() {
        performMotion(this.shrinkStrategy, null);
    }

    public void silentlyUpdateTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.extendedFloatingActionButtonStyle);
    }

    public void extend(@NonNull ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        performMotion(this.extendStrategy, extendedFloatingActionButton$OnChangedCallback);
    }

    public void hide(@NonNull ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        performMotion(this.hideStrategy, extendedFloatingActionButton$OnChangedCallback);
    }

    public void show(@NonNull ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        performMotion(this.showStrategy, extendedFloatingActionButton$OnChangedCallback);
    }

    public void shrink(@NonNull ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        performMotion(this.shrinkStrategy, extendedFloatingActionButton$OnChangedCallback);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.animState = 0;
        a aVar = new a();
        this.changeVisibilityTracker = aVar;
        ExtendedFloatingActionButton$j extendedFloatingActionButton$j = new ExtendedFloatingActionButton$j(this, aVar);
        this.showStrategy = extendedFloatingActionButton$j;
        ExtendedFloatingActionButton$i extendedFloatingActionButton$i = new ExtendedFloatingActionButton$i(this, aVar);
        this.hideStrategy = extendedFloatingActionButton$i;
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context context2 = getContext();
        this.behavior = new ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.ExtendedFloatingActionButton, i, i2, new int[0]);
        MotionSpec motionSpecCreateFromAttribute = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec motionSpecCreateFromAttribute2 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec motionSpecCreateFromAttribute3 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec motionSpecCreateFromAttribute4 = MotionSpec.createFromAttribute(context2, typedArrayObtainStyledAttributes, R$styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendedPaddingStart = ViewCompat.getPaddingStart(this);
        this.extendedPaddingEnd = ViewCompat.getPaddingEnd(this);
        a aVar2 = new a();
        ExtendedFloatingActionButton$h extendedFloatingActionButton$h = new ExtendedFloatingActionButton$h(this, aVar2, new ExtendedFloatingActionButton$a(this), true);
        this.extendStrategy = extendedFloatingActionButton$h;
        ExtendedFloatingActionButton$h extendedFloatingActionButton$h2 = new ExtendedFloatingActionButton$h(this, aVar2, new ExtendedFloatingActionButton$b(this), false);
        this.shrinkStrategy = extendedFloatingActionButton$h2;
        extendedFloatingActionButton$j.f = motionSpecCreateFromAttribute;
        extendedFloatingActionButton$i.f = motionSpecCreateFromAttribute2;
        extendedFloatingActionButton$h.f = motionSpecCreateFromAttribute3;
        extendedFloatingActionButton$h2.f = motionSpecCreateFromAttribute4;
        typedArrayObtainStyledAttributes.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, i, i2, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }
}
