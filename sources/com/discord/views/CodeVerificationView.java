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
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C0946e2;
import p007b.p008a.p025i.C0954f2;
import p007b.p008a.p025i.C0962g2;
import p007b.p008a.p062y.C1327e;
import p007b.p008a.p062y.ViewOnClickListenerC1323c;
import p007b.p008a.p062y.ViewOnFocusChangeListenerC1321b;
import p007b.p008a.p062y.ViewOnKeyListenerC1325d;
import p007b.p008a.p062y.ViewOnLayoutChangeListenerC1319a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: CodeVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CodeVerificationView extends LinearLayout {

    /* JADX INFO: renamed from: j */
    public static final EnumC7072a f19031j = EnumC7072a.NUMERIC;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0946e2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final List<TextView> characterViews;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableUnfocused;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Drawable charBackgroundDrawableFocused;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public EnumC7072a inputType;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public String inputFormat;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String code;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public Function1<? super String, Unit> onCodeEntered;

    /* JADX INFO: renamed from: com.discord.views.CodeVerificationView$a */
    /* JADX INFO: compiled from: CodeVerificationView.kt */
    public enum EnumC7072a {
        NUMERIC,
        ALPHANUMERIC;


        /* JADX INFO: renamed from: n */
        public static final a f19044n = new a(null);

        /* JADX INFO: renamed from: m */
        public static final EnumC7072a[] f19043m = values();

        /* JADX INFO: renamed from: com.discord.views.CodeVerificationView$a$a */
        /* JADX INFO: compiled from: CodeVerificationView.kt */
        public static final class a {
            public a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CodeVerificationView(Context context, AttributeSet attributeSet) {
        ViewBinding c0954f2;
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_code_verification, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        FlexboxLayout flexboxLayout = (FlexboxLayout) viewInflate;
        C0946e2 c0946e2 = new C0946e2(flexboxLayout, flexboxLayout);
        C12238m.checkNotNullExpressionValue(c0946e2, "ViewCodeVerificationBind…rom(context), this, true)");
        this.binding = c0946e2;
        this.code = "";
        this.onCodeEntered = C1327e.f2017j;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.CodeVerificationView, 0, 0);
            C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…deVerificationView, 0, 0)");
            try {
                int i = typedArrayObtainStyledAttributes.getInt(1, f19031j.ordinal());
                EnumC7072a.a aVar = EnumC7072a.f19044n;
                this.inputType = EnumC7072a.f19043m[i];
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
        setOnFocusChangeListener(new ViewOnFocusChangeListenerC1321b(this));
        setOnClickListener(new ViewOnClickListenerC1323c(this));
        setOnKeyListener(new ViewOnKeyListenerC1325d(this));
        String str = this.inputFormat;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("inputFormat");
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
                FlexboxLayout flexboxLayout2 = this.binding.f809b;
                View viewInflate2 = layoutInflaterFrom.inflate(C5419R.layout.view_code_verification_text, (ViewGroup) flexboxLayout2, false);
                flexboxLayout2.addView(viewInflate2);
                Objects.requireNonNull(viewInflate2, "rootView");
                c0954f2 = new C0962g2((TextView) viewInflate2);
                C12238m.checkNotNullExpressionValue(c0954f2, "ViewCodeVerificationText…t), binding.layout, true)");
                arrayList.add(c0954f2.getRoot());
            } else {
                if (!strValueOf.equals("-")) {
                    throw new IllegalStateException("Invalid format for " + cCharAt);
                }
                LayoutInflater layoutInflaterFrom2 = LayoutInflater.from(context);
                FlexboxLayout flexboxLayout3 = this.binding.f809b;
                View viewInflate3 = layoutInflaterFrom2.inflate(C5419R.layout.view_code_verification_space, (ViewGroup) flexboxLayout3, false);
                flexboxLayout3.addView(viewInflate3);
                Objects.requireNonNull(viewInflate3, "rootView");
                c0954f2 = new C0954f2((Space) viewInflate3);
                C12238m.checkNotNullExpressionValue(c0954f2, "ViewCodeVerificationSpac…t), binding.layout, true)");
                arrayList.add(c0954f2.getRoot());
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
            view.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1319a(this));
        } else {
            m8537a(this);
        }
        this.charBackgroundDrawableUnfocused = ContextCompat.getDrawable(context, C5419R.drawable.drawable_uikit_background_tertiary_button);
        this.charBackgroundDrawableFocused = ContextCompat.getDrawable(context, C5419R.drawable.drawable_uikit_background_tertiary_button_outline);
        m8541e();
    }

    /* JADX INFO: renamed from: a */
    public static final void m8537a(CodeVerificationView codeVerificationView) {
        Object systemService = codeVerificationView.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(codeVerificationView, 2);
    }

    private final int getInputLength() {
        String str = this.inputFormat;
        if (str == null) {
            C12238m.throwUninitializedPropertyAccessException("inputFormat");
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (C12238m.areEqual(String.valueOf(str.charAt(i2)), "x")) {
                i++;
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public final void m8538b() {
        if (this.code.length() > 0) {
            this.code = "";
            m8540d();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8539c(char c) {
        if (this.code.length() < getInputLength()) {
            this.code = this.code + c;
            m8540d();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m8540d() {
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            TextView textView = (TextView) obj;
            if (i <= C12106w.getLastIndex(this.code)) {
                textView.setText(String.valueOf(this.code.charAt(i)));
            } else {
                textView.setText("");
            }
            i = i2;
        }
        if (this.code.length() == getInputLength()) {
            this.onCodeEntered.invoke(this.code);
        }
        m8541e();
    }

    /* JADX INFO: renamed from: e */
    public final void m8541e() {
        int iMin = Math.min(this.code.length(), C12147n.getLastIndex(this.characterViews));
        int i = 0;
        for (Object obj : this.characterViews) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
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
        C12238m.checkNotNullParameter(outAttrs, "outAttrs");
        EnumC7072a enumC7072a = this.inputType;
        if (enumC7072a == null) {
            C12238m.throwUninitializedPropertyAccessException("inputType");
        }
        int iOrdinal = enumC7072a.ordinal();
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
        C12238m.checkNotNullParameter(code, ModelAuditLogEntry.CHANGE_KEY_CODE);
        String str = this.code;
        String string = code.toString();
        this.code = string;
        if (!C12238m.areEqual(str, string)) {
            m8540d();
        }
    }

    public final void setOnCodeEntered(Function1<? super String, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onCodeEntered = function1;
    }
}
