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
import b.a.i.e2;
import b.a.i.f2;
import b.a.i.g2;
import b.a.y.a;
import b.a.y.b;
import b.a.y.c;
import b.a.y.d;
import b.a.y.e;
import com.discord.R$a;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.flexbox.FlexboxLayout;
import d0.g0.w;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView extends LinearLayout {
    public static final CodeVerificationView$a j = CodeVerificationView$a.NUMERIC;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final e2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final List<TextView> characterViews;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableUnfocused;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableFocused;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public CodeVerificationView$a inputType;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public String inputFormat;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String code;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public Function1<? super String, Unit> onCodeEntered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeVerificationView(Context context, AttributeSet attributeSet) {
        ViewBinding f2Var;
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_code_verification, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate;
        e2 e2Var = new e2(flexboxLayout, flexboxLayout);
        m.checkNotNullExpressionValue(e2Var, "ViewCodeVerificationBind…rom(context), this, true)");
        this.binding = e2Var;
        this.code = "";
        this.onCodeEntered = e.j;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.CodeVerificationView, 0, 0);
            m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…deVerificationView, 0, 0)");
            try {
                int i = typedArrayObtainStyledAttributes.getInt(1, j.ordinal());
                CodeVerificationView$a$a codeVerificationView$a$a = CodeVerificationView$a.n;
                this.inputType = CodeVerificationView$a.m[i];
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
        setOnFocusChangeListener(new b(this));
        setOnClickListener(new c(this));
        setOnKeyListener(new d(this));
        String str = this.inputFormat;
        if (str == null) {
            m.throwUninitializedPropertyAccessException("inputFormat");
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
                View viewInflate2 = layoutInflaterFrom.inflate(R$layout.view_code_verification_text, (ViewGroup) flexboxLayout2, false);
                flexboxLayout2.addView(viewInflate2);
                Objects.requireNonNull(viewInflate2, "rootView");
                f2Var = new g2((TextView) viewInflate2);
                m.checkNotNullExpressionValue(f2Var, "ViewCodeVerificationText…t), binding.layout, true)");
                arrayList.add(f2Var.getRoot());
            } else {
                if (!strValueOf.equals("-")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout3 = this.binding.f104b;
                View viewInflate3 = layoutInflaterFrom2.inflate(R$layout.view_code_verification_space, (ViewGroup) flexboxLayout3, false);
                flexboxLayout3.addView(viewInflate3);
                Objects.requireNonNull(viewInflate3, "rootView");
                f2Var = new f2((Space) viewInflate3);
                m.checkNotNullExpressionValue(f2Var, "ViewCodeVerificationSpac…t), binding.layout, true)");
                arrayList.add(f2Var.getRoot());
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
            view.addOnLayoutChangeListener(new a(this));
        } else {
            a(this);
        }
        this.charBackgroundDrawableUnfocused = ContextCompat.getDrawable(context, 2131231333);
        this.charBackgroundDrawableFocused = ContextCompat.getDrawable(context, 2131231334);
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
            m.throwUninitializedPropertyAccessException("inputFormat");
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (m.areEqual(String.valueOf(str.charAt(i2)), "x")) {
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
                n.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            if (i <= w.getLastIndex(this.code)) {
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
        int iMin = Math.min(this.code.length(), n.getLastIndex(this.characterViews));
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
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
        m.checkNotNullParameter(outAttrs, "outAttrs");
        CodeVerificationView$a codeVerificationView$a = this.inputType;
        if (codeVerificationView$a == null) {
            m.throwUninitializedPropertyAccessException("inputType");
        }
        int iOrdinal = codeVerificationView$a.ordinal();
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
        m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        String str = this.code;
        String string = code.toString();
        this.code = string;
        if (!m.areEqual(str, string)) {
            d();
        }
    }

    public final void setOnCodeEntered(Function1<? super String, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onCodeEntered = function1;
    }
}
