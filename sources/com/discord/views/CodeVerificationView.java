package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewbinding.ViewBinding;
import b.a.i.ViewCodeVerificationBinding;
import b.a.i.ViewCodeVerificationSpaceBinding;
import b.a.i.ViewCodeVerificationTextBinding;
import b.a.y.CodeVerificationView2;
import b.a.y.CodeVerificationView3;
import b.a.y.CodeVerificationView4;
import b.a.y.CodeVerificationView5;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.flexbox.FlexboxLayout;
import d0.g0.Strings4;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView extends LinearLayout {
    public static final a j = a.NUMERIC;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewCodeVerificationBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final List<TextView> characterViews;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableUnfocused;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableFocused;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public a inputType;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public String inputFormat;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String code;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public Function1<? super String, Unit> onCodeEntered;

    /* JADX INFO: compiled from: CodeVerificationView.kt */
    public enum a {
        NUMERIC,
        ALPHANUMERIC;

        public static final C0232a n = new C0232a(null);
        public static final a[] m = values();

        /* JADX INFO: renamed from: com.discord.views.CodeVerificationView$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CodeVerificationView.kt */
        public static final class C0232a {
            public C0232a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeVerificationView(Context context, AttributeSet attributeSet) {
        ViewBinding viewCodeVerificationSpaceBinding;
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_code_verification, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate;
        ViewCodeVerificationBinding viewCodeVerificationBinding = new ViewCodeVerificationBinding(flexboxLayout, flexboxLayout);
        Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationBinding, "ViewCodeVerificationBind…rom(context), this, true)");
        this.binding = viewCodeVerificationBinding;
        this.code = "";
        this.onCodeEntered = CodeVerificationView5.j;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.a.CodeVerificationView, 0, 0);
            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…deVerificationView, 0, 0)");
            try {
                int i = typedArrayObtainStyledAttributes.getInt(1, j.ordinal());
                a.C0232a c0232a = a.n;
                this.inputType = a.m[i];
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string == null) {
                    string = "xxx-xxx";
                }
                this.inputFormat = string;
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        setClickable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnFocusChangeListener(new CodeVerificationView2(this));
        setOnClickListener(new CodeVerificationView3(this));
        setOnKeyListener(new CodeVerificationView4(this));
        String str = this.inputFormat;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputFormat");
        }
        ArrayList arrayList = new ArrayList(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            String strValueOf = String.valueOf(cCharAt);
            int iHashCode = strValueOf.hashCode();
            if (iHashCode != 45) {
                if (iHashCode != 120 || !strValueOf.equals("x")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout2 = this.binding.f104b;
                View viewInflate2 = layoutInflaterFrom.inflate(R.layout.view_code_verification_text, (ViewGroup) flexboxLayout2, false);
                flexboxLayout2.addView(viewInflate2);
                Objects.requireNonNull(viewInflate2, "rootView");
                viewCodeVerificationSpaceBinding = new ViewCodeVerificationTextBinding((TextView) viewInflate2);
                Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationSpaceBinding, "ViewCodeVerificationText…t), binding.layout, true)");
                arrayList.add(viewCodeVerificationSpaceBinding.getRoot());
            } else {
                if (!strValueOf.equals("-")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout3 = this.binding.f104b;
                View viewInflate3 = layoutInflaterFrom2.inflate(R.layout.view_code_verification_space, (ViewGroup) flexboxLayout3, false);
                flexboxLayout3.addView(viewInflate3);
                Objects.requireNonNull(viewInflate3, "rootView");
                viewCodeVerificationSpaceBinding = new ViewCodeVerificationSpaceBinding((Space) viewInflate3);
                Intrinsics3.checkNotNullExpressionValue(viewCodeVerificationSpaceBinding, "ViewCodeVerificationSpac…t), binding.layout, true)");
                arrayList.add(viewCodeVerificationSpaceBinding.getRoot());
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (obj instanceof TextView) {
                arrayList2.add(obj);
            }
        }
        this.characterViews = arrayList2;
        ((TextView) arrayList2.get(0)).requestFocus();
        View view = (View) arrayList2.get(0);
        if (!ViewCompat.isLaidOut(view) || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new b.a.y.a(this));
        } else {
            a(this);
        }
        this.charBackgroundDrawableUnfocused = ContextCompat.getDrawable(context, R.drawable.drawable_uikit_background_tertiary_button);
        this.charBackgroundDrawableFocused = ContextCompat.getDrawable(context, R.drawable.drawable_uikit_background_tertiary_button_outline);
        e();
    }

    public static final void a(CodeVerificationView codeVerificationView) {
        Object systemService = codeVerificationView.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(codeVerificationView, 2);
    }

    private final int getInputLength() {
        String str = this.inputFormat;
        if (str == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputFormat");
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (Intrinsics3.areEqual(String.valueOf(str.charAt(i2)), "x")) {
                i++;
            }
        }
        return i;
    }

    public final void b() {
        if (this.code.length() > 0) {
            this.code = "";
            d();
        }
    }

    public final void c(char c) {
        if (this.code.length() < getInputLength()) {
            this.code = this.code + c;
            d();
        }
    }

    public final void d() {
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            if (i <= Strings4.getLastIndex(this.code)) {
                textView.setText(String.valueOf(this.code.charAt(i)));
            } else {
                textView.setText("");
            }
            i = i2;
        }
        if (this.code.length() == getInputLength()) {
            this.onCodeEntered.invoke(this.code);
        }
        e();
    }

    public final void e() {
        int iMin = Math.min(this.code.length(), Collections2.getLastIndex(this.characterViews));
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ((TextView) obj).setBackground(i == iMin ? this.charBackgroundDrawableFocused : this.charBackgroundDrawableUnfocused);
            i = i2;
        }
    }

    public final String getCode() {
        return this.code;
    }

    public final Function1<String, Unit> getOnCodeEntered() {
        return this.onCodeEntered;
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return true;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics3.checkNotNullParameter(outAttrs, "outAttrs");
        a aVar = this.inputType;
        if (aVar == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("inputType");
        }
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            BaseInputConnection baseInputConnection = new BaseInputConnection(this, false);
            outAttrs.inputType = 18;
            return baseInputConnection;
        }
        if (iOrdinal != 1) {
            throw new NoWhenBranchMatchedException();
        }
        BaseInputConnection baseInputConnection2 = new BaseInputConnection(this, false);
        outAttrs.inputType = 4224;
        return baseInputConnection2;
    }

    public final void setCode(CharSequence code) {
        Intrinsics3.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        String str = this.code;
        String string = code.toString();
        this.code = string;
        if (!Intrinsics3.areEqual(str, string)) {
            d();
        }
    }

    public final void setOnCodeEntered(Function1<? super String, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onCodeEntered = function1;
    }
}
