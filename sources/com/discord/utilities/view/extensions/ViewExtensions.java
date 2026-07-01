package com.discord.utilities.view.extensions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View$OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.PluralsRes;
import androidx.annotation.StringRes;
import androidx.annotation.StyleableRes;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.text.TextWatcherKt;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.c0;
import d0.z.d.m;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions {
    private static final long DEFAULT_FADE_MILLIS_RES = 350;
    private static final long HINT_DELAY_MILLIS = 250;
    private static final HashMap<View, FadeAnimation> fadeAnimations = new HashMap<>();

    public static final /* synthetic */ HashMap access$getFadeAnimations$p() {
        return fadeAnimations;
    }

    public static final Unit addBindedTextWatcher(TextInputLayout textInputLayout, Fragment fragment, Function1<? super Editable, Unit> function1) {
        m.checkNotNullParameter(textInputLayout, "$this$addBindedTextWatcher");
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(function1, "onAfterTextChanged");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        TextWatcherKt.addBindedTextWatcher(editText, fragment, function1);
        return Unit.a;
    }

    public static final void addOnHeightChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        m.checkNotNullParameter(view, "$this$addOnHeightChangedListener");
        m.checkNotNullParameter(function2, "onHeightChanged");
        view.addOnLayoutChangeListener(new ViewExtensions$addOnHeightChangedListener$1(function2));
    }

    public static final void addOnSizeChangedListener(View view, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function4) {
        m.checkNotNullParameter(view, "$this$addOnSizeChangedListener");
        m.checkNotNullParameter(function4, "onSizeChanged");
        view.addOnLayoutChangeListener(new ViewExtensions$addOnSizeChangedListener$1(function4));
    }

    public static final void addOnWidthChangedListener(View view, Function2<? super Integer, ? super Integer, Unit> function2) {
        m.checkNotNullParameter(view, "$this$addOnWidthChangedListener");
        m.checkNotNullParameter(function2, "onWidthChanged");
        view.addOnLayoutChangeListener(new ViewExtensions$addOnWidthChangedListener$1(function2));
    }

    public static final void cancelFadeAnimations(View view) {
        ViewPropertyAnimator viewPropertyAnimator;
        m.checkNotNullParameter(view, "$this$cancelFadeAnimations");
        FadeAnimation fadeAnimationRemove = fadeAnimations.remove(view);
        if (fadeAnimationRemove == null || (viewPropertyAnimator = fadeAnimationRemove.getViewPropertyAnimator()) == null) {
            return;
        }
        viewPropertyAnimator.cancel();
    }

    public static final Unit clear(TextInputLayout textInputLayout) {
        Editable text;
        m.checkNotNullParameter(textInputLayout, "$this$clear");
        EditText editText = textInputLayout.getEditText();
        if (editText == null || (text = editText.getText()) == null) {
            return null;
        }
        text.clear();
        return Unit.a;
    }

    public static final void disable(View view) {
        m.checkNotNullParameter(view, "$this$disable");
        view.setEnabled(false);
    }

    public static final void enable(View view) {
        m.checkNotNullParameter(view, "$this$enable");
        view.setEnabled(true);
    }

    public static final void fadeBy(View view, boolean z2) {
        fadeBy$default(view, z2, 0L, 2, null);
    }

    public static final void fadeBy(View view, boolean z2, long j) {
        if (z2) {
            fadeIn$default(view, j, null, null, null, 14, null);
        } else {
            fadeOut$default(view, j, null, null, 6, null);
        }
    }

    public static /* synthetic */ void fadeBy$default(View view, boolean z2, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        fadeBy(view, z2, j);
    }

    @MainThread
    public static final void fadeIn(View view) {
        fadeIn$default(view, 0L, null, null, null, 15, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j) {
        fadeIn$default(view, j, null, null, null, 14, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1) {
        fadeIn$default(view, j, function1, null, null, 12, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function2) {
        fadeIn$default(view, j, function1, function2, null, 8, null);
    }

    @MainThread
    public static final void fadeIn(View view, long j, Function1<? super View, Unit> function1, Function1<? super ViewPropertyAnimator, Unit> function2, Function0<Unit> function0) {
        m.checkNotNullParameter(function1, "setup");
        m.checkNotNullParameter(function2, "additionalAnimation");
        m.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, FadeAnimation> map = fadeAnimations;
            FadeAnimation fadeAnimation = map.get(view);
            FadeAnimation$Type type = fadeAnimation != null ? fadeAnimation.getType() : null;
            FadeAnimation$Type fadeAnimation$Type = FadeAnimation$Type.FADE_IN;
            if (type == fadeAnimation$Type) {
                return;
            }
            if (fadeAnimation != null) {
                map.remove(view);
                fadeAnimation.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                view.setAlpha(1.0f);
                return;
            }
            view.setAlpha(0.0f);
            function1.invoke(view);
            view.setVisibility(0);
            ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(1.0f);
            function2.invoke(viewPropertyAnimatorAlpha);
            ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions$fadeIn$viewPropertyAnimator$1(function0)).setListener(new CleanupViewAnimationListener(view));
            m.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
            map.put(view, new FadeAnimation(listener, fadeAnimation$Type));
            listener.start();
        }
    }

    public static /* synthetic */ void fadeIn$default(View view, long j, Function1 function1, Function1 function2, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            function1 = ViewExtensions$fadeIn$1.INSTANCE;
        }
        Function1 function3 = function1;
        if ((i & 4) != 0) {
            function2 = ViewExtensions$fadeIn$2.INSTANCE;
        }
        Function1 function4 = function2;
        if ((i & 8) != 0) {
            function0 = ViewExtensions$fadeIn$3.INSTANCE;
        }
        fadeIn(view, j2, function3, function4, function0);
    }

    @MainThread
    public static final void fadeOut(View view) {
        fadeOut$default(view, 0L, null, null, 7, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j) {
        fadeOut$default(view, j, null, null, 6, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1) {
        fadeOut$default(view, j, function1, null, 4, null);
    }

    @MainThread
    public static final void fadeOut(View view, long j, Function1<? super ViewPropertyAnimator, Unit> function1, Function0<Unit> function0) {
        m.checkNotNullParameter(function1, "additionalAnimation");
        m.checkNotNullParameter(function0, "onAnimationEnd");
        if (view != null) {
            HashMap<View, FadeAnimation> map = fadeAnimations;
            FadeAnimation fadeAnimation = map.get(view);
            FadeAnimation$Type type = fadeAnimation != null ? fadeAnimation.getType() : null;
            FadeAnimation$Type fadeAnimation$Type = FadeAnimation$Type.FADE_OUT;
            if (type == fadeAnimation$Type) {
                return;
            }
            if (fadeAnimation != null) {
                map.remove(view);
                fadeAnimation.getViewPropertyAnimator().cancel();
            }
            if (view.getVisibility() == 0) {
                ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().alpha(0.0f);
                function1.invoke(viewPropertyAnimatorAlpha);
                ViewPropertyAnimator listener = viewPropertyAnimatorAlpha.setDuration(j).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new ViewExtensions$fadeOut$viewPropertyAnimator$1(view, function0)).setListener(new CleanupViewAnimationListener(view));
                m.checkNotNullExpressionValue(listener, "viewPropertyAnimator");
                map.put(view, new FadeAnimation(listener, fadeAnimation$Type));
                listener.start();
            }
        }
    }

    public static /* synthetic */ void fadeOut$default(View view, long j, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DEFAULT_FADE_MILLIS_RES;
        }
        if ((i & 2) != 0) {
            function1 = ViewExtensions$fadeOut$1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function0 = ViewExtensions$fadeOut$2.INSTANCE;
        }
        fadeOut(view, j, function1, function0);
    }

    public static final /* synthetic */ <T extends ViewParent> T findParent(View view) {
        m.checkNotNullParameter(view, "$this$findParent");
        T t = (T) view.getParent();
        if (t == null) {
            return null;
        }
        m.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return t;
    }

    public static final View getContentView(NestedScrollView nestedScrollView) {
        m.checkNotNullParameter(nestedScrollView, "$this$getContentView");
        View childAt = nestedScrollView.getChildAt(0);
        m.checkNotNullExpressionValue(childAt, "getChildAt(0)");
        return childAt;
    }

    public static final String getTextOrEmpty(TextInputLayout textInputLayout) {
        Editable text;
        m.checkNotNullParameter(textInputLayout, "$this$getTextOrEmpty");
        EditText editText = textInputLayout.getEditText();
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        return string != null ? string : "";
    }

    public static final void hintWithRipple(View view, long j) {
        m.checkNotNullParameter(view, "$this$hintWithRipple");
        view.setPressed(true);
        view.setPressed(false);
        view.postDelayed(new ViewExtensions$hintWithRipple$1(view), j);
    }

    public static /* synthetic */ void hintWithRipple$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = HINT_DELAY_MILLIS;
        }
        hintWithRipple(view, j);
    }

    public static final void i18nSetText(TextInputLayout textInputLayout, @StringRes int i, Object[] objArr, Function1<? super RenderContext, Unit> function1) {
        m.checkNotNullParameter(textInputLayout, "$this$i18nSetText");
        m.checkNotNullParameter(objArr, "formatArgs");
        m.checkNotNullParameter(function1, "initializer");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            b.m(editText, i, Arrays.copyOf(objArr, objArr.length), function1);
        }
    }

    public static /* synthetic */ void i18nSetText$default(TextInputLayout textInputLayout, int i, Object[] objArr, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = ViewExtensions$i18nSetText$1.INSTANCE;
        }
        i18nSetText(textInputLayout, i, objArr, function1);
    }

    public static final void interceptScrollWhenInsideScrollable(TextInputLayout textInputLayout) {
        m.checkNotNullParameter(textInputLayout, "$this$interceptScrollWhenInsideScrollable");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnTouchListener(ViewExtensions$interceptScrollWhenInsideScrollable$1.INSTANCE);
        }
    }

    public static final void moveCursorToEnd(TextInputLayout textInputLayout) {
        m.checkNotNullParameter(textInputLayout, "$this$moveCursorToEnd");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setSelection(editText.getText().toString().length());
        }
    }

    public static final void setBackgroundAndKeepPadding(View view, Drawable drawable) {
        m.checkNotNullParameter(view, "$this$setBackgroundAndKeepPadding");
        view.setBackground(drawable);
    }

    public static final void setCompoundDrawableWithIntrinsicBounds(TextView textView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3, @DrawableRes int i4) {
        m.checkNotNullParameter(textView, "$this$setCompoundDrawableWithIntrinsicBounds");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    public static /* synthetic */ void setCompoundDrawableWithIntrinsicBounds$default(TextView textView, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        setCompoundDrawableWithIntrinsicBounds(textView, i, i2, i3, i4);
    }

    public static final void setEnabledAlpha(View view, boolean z2, float f) {
        m.checkNotNullParameter(view, "$this$setEnabledAlpha");
        if (z2) {
            f = 1.0f;
        }
        view.setAlpha(f);
    }

    public static /* synthetic */ void setEnabledAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAlpha(view, z2, f);
    }

    public static final void setEnabledAndAlpha(View view, boolean z2, float f) {
        m.checkNotNullParameter(view, "$this$setEnabledAndAlpha");
        view.setEnabled(z2);
        setEnabledAlpha(view, z2, f);
    }

    public static /* synthetic */ void setEnabledAndAlpha$default(View view, boolean z2, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.3f;
        }
        setEnabledAndAlpha(view, z2, f);
    }

    public static final void setForwardingWindowInsetsListener(ViewGroup viewGroup) {
        m.checkNotNullParameter(viewGroup, "$this$setForwardingWindowInsetsListener");
        ViewCompat.setOnApplyWindowInsetsListener(viewGroup, ViewExtensions$setForwardingWindowInsetsListener$1.INSTANCE);
    }

    public static final void setHint(TextInputLayout textInputLayout, int i) {
        m.checkNotNullParameter(textInputLayout, "$this$setHint");
        textInputLayout.setHint(textInputLayout.getContext().getString(i));
    }

    public static final Unit setOnEditTextClickListener(TextInputLayout textInputLayout, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(textInputLayout, "$this$setOnEditTextClickListener");
        m.checkNotNullParameter(function1, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnClickListener(new ViewExtensions$sam$android_view_View_OnClickListener$0(function1));
        return Unit.a;
    }

    public static final void setOnEditTextFocusChangeListener(TextInputLayout textInputLayout, View$OnFocusChangeListener view$OnFocusChangeListener) {
        m.checkNotNullParameter(textInputLayout, "$this$setOnEditTextFocusChangeListener");
        m.checkNotNullParameter(view$OnFocusChangeListener, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(view$OnFocusChangeListener);
        }
    }

    public static final Unit setOnEditorActionListener(TextInputLayout textInputLayout, Function3<? super TextView, ? super Integer, ? super KeyEvent, Boolean> function3) {
        m.checkNotNullParameter(textInputLayout, "$this$setOnEditorActionListener");
        m.checkNotNullParameter(function3, "l");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setOnEditorActionListener(new ViewExtensions$sam$android_widget_TextView_OnEditorActionListener$0(function3));
        return Unit.a;
    }

    public static final Unit setOnImeActionDone(TextInputLayout textInputLayout, boolean z2, Function1<? super TextView, Unit> function1) {
        m.checkNotNullParameter(textInputLayout, "$this$setOnImeActionDone");
        m.checkNotNullParameter(function1, "onImeActionDone");
        return setOnEditorActionListener(textInputLayout, new ViewExtensions$setOnImeActionDone$1(textInputLayout, function1, z2));
    }

    public static /* synthetic */ Unit setOnImeActionDone$default(TextInputLayout textInputLayout, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return setOnImeActionDone(textInputLayout, z2, function1);
    }

    public static final void setOnLongClickListenerConsumeClick(View view, Function1<? super View, Unit> function1) {
        m.checkNotNullParameter(view, "$this$setOnLongClickListenerConsumeClick");
        m.checkNotNullParameter(function1, "onLongClick");
        view.setOnLongClickListener(new ViewExtensions$setOnLongClickListenerConsumeClick$1(function1));
    }

    public static final void setPluralText(TextView textView, @PluralsRes int i, int i2, Object... objArr) {
        m.checkNotNullParameter(textView, "$this$setPluralText");
        m.checkNotNullParameter(objArr, "formatArgs");
        Resources resources = textView.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, "context");
        c0 c0Var = new c0(2);
        c0Var.add(Integer.valueOf(i2));
        c0Var.addSpread(objArr);
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, context, i, i2, c0Var.toArray(new Object[c0Var.size()])));
    }

    public static final void setProgrammaticChecked(CompoundButton compoundButton, boolean z2, CompoundButton$OnCheckedChangeListener compoundButton$OnCheckedChangeListener) {
        m.checkNotNullParameter(compoundButton, "$this$setProgrammaticChecked");
        m.checkNotNullParameter(compoundButton$OnCheckedChangeListener, "listener");
        compoundButton.setOnCheckedChangeListener(null);
        compoundButton.setChecked(z2);
        compoundButton.setOnCheckedChangeListener(compoundButton$OnCheckedChangeListener);
    }

    public static final Unit setSelection(TextInputLayout textInputLayout, int i) {
        m.checkNotNullParameter(textInputLayout, "$this$setSelection");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setSelection(i);
        return Unit.a;
    }

    public static final Unit setSelectionEnd(TextInputLayout textInputLayout) {
        m.checkNotNullParameter(textInputLayout, "$this$setSelectionEnd");
        EditText editText = textInputLayout.getEditText();
        return setSelection(textInputLayout, editText != null ? editText.length() : 0);
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, int i) {
        m.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        String string = textInputLayout.getContext().getString(i);
        m.checkNotNullExpressionValue(string, "context.getString(resId)");
        setSingleLineHint(textInputLayout, string);
    }

    public static final Unit setText(TextInputLayout textInputLayout, int i) {
        m.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(i);
        return Unit.a;
    }

    public static final void setTextAndVisibilityBy(TextView textView, CharSequence charSequence) {
        m.checkNotNullParameter(textView, "$this$setTextAndVisibilityBy");
        textView.setText(charSequence);
        textView.setVisibility((charSequence == null || t.isBlank(charSequence)) ^ true ? 0 : 8);
    }

    public static final void setTextIfDifferent(TextInputLayout textInputLayout, CharSequence charSequence) {
        EditText editText;
        Editable text;
        m.checkNotNullParameter(textInputLayout, "$this$setTextIfDifferent");
        EditText editText2 = textInputLayout.getEditText();
        if (!(!m.areEqual((editText2 == null || (text = editText2.getText()) == null) ? null : text.toString(), charSequence)) || (editText = textInputLayout.getEditText()) == null) {
            return;
        }
        editText.setText(charSequence);
    }

    public static final void useAttrs(View view, AttributeSet attributeSet, @StyleableRes int[] iArr, Function1<? super TypedArray, Unit> function1) {
        m.checkNotNullParameter(view, "$this$useAttrs");
        m.checkNotNullParameter(iArr, "styleable");
        m.checkNotNullParameter(function1, "block");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "context");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        function1.invoke(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void setSingleLineHint(TextInputLayout textInputLayout, CharSequence charSequence) {
        m.checkNotNullParameter(textInputLayout, "$this$setSingleLineHint");
        m.checkNotNullParameter(charSequence, "charSequence");
        textInputLayout.setHintEnabled(false);
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setHint(charSequence);
        }
    }

    public static final Unit setText(TextInputLayout textInputLayout, CharSequence charSequence) {
        m.checkNotNullParameter(textInputLayout, "$this$setText");
        EditText editText = textInputLayout.getEditText();
        if (editText == null) {
            return null;
        }
        editText.setText(charSequence);
        return Unit.a;
    }
}
