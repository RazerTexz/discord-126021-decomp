package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View$OnClickListener;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import b.a.i.p3;
import b.a.i.q3;
import b.a.i.s3;
import b.a.k.b;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting extends RelativeLayout implements Checkable {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Action1<Boolean> checkedListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public CheckedSetting$b binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckedSetting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            f(CheckedSetting$ViewType.CHECK);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$a.CheckedSetting, 0, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.CheckedSetting, 0, 0)");
        try {
            int i = typedArrayObtainStyledAttributes.getInt(15, CheckedSetting$ViewType.CHECK.ordinal());
            Objects.requireNonNull(CheckedSetting$ViewType.Companion);
            f(CheckedSetting$ViewType.access$getVALUES$cp()[i]);
            CheckedSetting$b checkedSetting$b = this.binding;
            if (checkedSetting$b == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingLeft = checkedSetting$b.b().getPaddingLeft();
            CheckedSetting$b checkedSetting$b2 = this.binding;
            if (checkedSetting$b2 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingTop = checkedSetting$b2.b().getPaddingTop();
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(6, paddingLeft);
            int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(7, paddingTop);
            CheckedSetting$b checkedSetting$b3 = this.binding;
            if (checkedSetting$b3 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            checkedSetting$b3.b().setPadding(dimension, dimension2, dimension, dimension2);
            float dimension3 = typedArrayObtainStyledAttributes.getDimension(14, -1.0f);
            float f = 0;
            if (dimension3 > f) {
                CheckedSetting$b checkedSetting$b4 = this.binding;
                if (checkedSetting$b4 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b4.a().setTextSize(0, dimension3);
            }
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(12);
            if (colorStateList != null) {
                CheckedSetting$b checkedSetting$b5 = this.binding;
                if (checkedSetting$b5 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b5.a().setTextColor(colorStateList);
            }
            CheckedSetting$b checkedSetting$b6 = this.binding;
            if (checkedSetting$b6 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            TextView textViewA = checkedSetting$b6.a();
            String string = typedArrayObtainStyledAttributes.getString(11);
            textViewA.setText(string != null ? b.l(string, new Object[0], null, 2) : null);
            CheckedSetting$b checkedSetting$b7 = this.binding;
            if (checkedSetting$b7 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageViewD = checkedSetting$b7.d();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(3);
            imageViewD.setVisibility(drawable != null ? 0 : 8);
            imageViewD.setImageDrawable(drawable);
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(4);
            if (colorStateList2 != null) {
                imageViewD.setImageTintList(colorStateList2);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(13, -1);
            if (resourceId != -1) {
                CheckedSetting$b checkedSetting$b8 = this.binding;
                if (checkedSetting$b8 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b8.a().setTypeface(ResourcesCompat.getFont(getContext(), resourceId));
            }
            String string2 = typedArrayObtainStyledAttributes.getString(8);
            CharSequence charSequenceL = string2 != null ? b.l(string2, new Object[0], null, 2) : null;
            if (charSequenceL == null || charSequenceL.length() == 0) {
                CheckedSetting$b checkedSetting$b9 = this.binding;
                if (checkedSetting$b9 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b9.f().setVisibility(8);
            } else {
                CheckedSetting$b checkedSetting$b10 = this.binding;
                if (checkedSetting$b10 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b10.f().setText(charSequenceL);
                CheckedSetting$b checkedSetting$b11 = this.binding;
                if (checkedSetting$b11 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b11.f().setVisibility(0);
            }
            float dimension4 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
            if (dimension4 > f) {
                CheckedSetting$b checkedSetting$b12 = this.binding;
                if (checkedSetting$b12 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b12.f().setTextSize(0, dimension4);
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(9);
            if (colorStateList3 != null) {
                CheckedSetting$b checkedSetting$b13 = this.binding;
                if (checkedSetting$b13 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b13.f().setTextColor(colorStateList3);
            }
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable2 != null) {
                setBackground(drawable2);
            } else {
                setBackgroundResource(2131231135);
            }
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(1);
            if (colorStateList4 != null) {
                setBackgroundTintList(colorStateList4);
            }
            Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(2);
            if (drawable3 != null) {
                CheckedSetting$b checkedSetting$b14 = this.binding;
                if (checkedSetting$b14 == null) {
                    m.throwUninitializedPropertyAccessException("binding");
                }
                checkedSetting$b14.b().setBackground(drawable3);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static final /* synthetic */ CheckedSetting$b a(CheckedSetting checkedSetting) {
        CheckedSetting$b checkedSetting$b = checkedSetting.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        return checkedSetting$b;
    }

    public static /* synthetic */ void d(CheckedSetting checkedSetting, CharSequence charSequence, int i) {
        int i2 = i & 1;
        checkedSetting.c(null);
    }

    public static /* synthetic */ void i(CheckedSetting checkedSetting, CharSequence charSequence, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        checkedSetting.h(charSequence, z2);
    }

    public final void b(@StringRes int disabledToastRes) {
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        c(b.h(context, disabledToastRes, new Object[0], null, 4));
    }

    public final void c(CharSequence disabledToastText) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.b().setOnClickListener(new CheckedSetting$c(this, disabledToastText));
        setAlpha(0.3f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        m.checkNotNullParameter(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        m.checkNotNullParameter(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    public final void e(View$OnClickListener listener) {
        m.checkNotNullParameter(listener, "listener");
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.b().setOnClickListener(listener);
        setAlpha(1.0f);
    }

    public final void f(CheckedSetting$ViewType viewType) {
        CheckedSetting$b checkedSetting$b$a;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int iOrdinal = viewType.ordinal();
        int i = R$id.setting_button;
        if (iOrdinal == 0) {
            layoutInflaterFrom.inflate(R$layout.view_setting_check, this);
            MaterialCheckBox materialCheckBox = (MaterialCheckBox) findViewById(R$id.setting_button);
            if (materialCheckBox != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.setting_container);
                if (constraintLayout != null) {
                    p3 p3Var = new p3(this, materialCheckBox, constraintLayout);
                    m.checkNotNullExpressionValue(p3Var, "ViewSettingCheckBinding.…ate(layoutInflater, this)");
                    m.checkNotNullParameter(p3Var, "binding");
                    checkedSetting$b$a = new CheckedSetting$b$a(p3Var);
                } else {
                    i = R$id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal == 1) {
            layoutInflaterFrom.inflate(R$layout.view_setting_radio, this);
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) findViewById(R$id.setting_button);
            if (materialRadioButton != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R$id.setting_container);
                if (constraintLayout2 != null) {
                    q3 q3Var = new q3(this, materialRadioButton, constraintLayout2);
                    m.checkNotNullExpressionValue(q3Var, "ViewSettingRadioBinding.…ate(layoutInflater, this)");
                    m.checkNotNullParameter(q3Var, "binding");
                    checkedSetting$b$a = new CheckedSetting$b$b(q3Var);
                } else {
                    i = R$id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        layoutInflaterFrom.inflate(R$layout.view_setting_switch, this);
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(R$id.setting_button);
        if (switchMaterial != null) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(R$id.setting_container);
            if (constraintLayout3 != null) {
                s3 s3Var = new s3(this, switchMaterial, constraintLayout3);
                m.checkNotNullExpressionValue(s3Var, "ViewSettingSwitchBinding…ate(layoutInflater, this)");
                m.checkNotNullParameter(s3Var, "binding");
                checkedSetting$b$a = new CheckedSetting$b$d(s3Var);
            } else {
                i = R$id.setting_container;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        this.binding = checkedSetting$b$a;
        if (viewType == CheckedSetting$ViewType.RADIO) {
            checkedSetting$b$a.b().setOnClickListener(new CheckedSetting$a(0, this));
        } else {
            checkedSetting$b$a.b().setOnClickListener(new CheckedSetting$a(1, this));
        }
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        ViewCompat.setAccessibilityDelegate(checkedSetting$b.b(), new CheckedSetting$d(this, viewType));
    }

    public final void g(boolean checked, boolean reportChange) {
        if (reportChange) {
            CheckedSetting$b checkedSetting$b = this.binding;
            if (checkedSetting$b == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            checkedSetting$b.c().setChecked(checked);
            return;
        }
        CheckedSetting$b checkedSetting$b2 = this.binding;
        if (checkedSetting$b2 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b2.c().setOnCheckedChangeListener(null);
        CheckedSetting$b checkedSetting$b3 = this.binding;
        if (checkedSetting$b3 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b3.c().setChecked(checked);
        setOnCheckedListener(this.checkedListener);
    }

    public final void h(CharSequence text, boolean containsClickables) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.f().setText(text);
        CheckedSetting$b checkedSetting$b2 = this.binding;
        if (checkedSetting$b2 == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b2.f().setVisibility(text == null || text.length() == 0 ? 8 : 0);
        if (containsClickables) {
            CheckedSetting$b checkedSetting$b3 = this.binding;
            if (checkedSetting$b3 == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            checkedSetting$b3.f().setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        return checkedSetting$b.c().isChecked();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        m.checkNotNullParameter(state, "state");
        if (state instanceof Bundle) {
            CheckedSetting$b checkedSetting$b = this.binding;
            if (checkedSetting$b == null) {
                m.throwUninitializedPropertyAccessException("binding");
            }
            Bundle bundle = (Bundle) state;
            checkedSetting$b.c().setChecked(bundle.getBoolean("STATE_CHECKED"));
            parcelable = bundle.getParcelable("STATE_SUPER");
        } else {
            parcelable = null;
        }
        if (parcelable != null) {
            state = parcelable;
        }
        super.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("STATE_SUPER", super.onSaveInstanceState());
        bundle.putBoolean("STATE_CHECKED", isChecked());
        return bundle;
    }

    public final void setButtonAlpha(float alpha) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.c().setAlpha(alpha);
    }

    public final void setButtonVisibility(boolean isVisible) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.c().setVisibility(isVisible ? 0 : 8);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        g(checked, false);
    }

    public final void setLabelTagText(@StringRes int resId) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.e().setText(resId);
    }

    public final void setLabelTagVisibility(boolean isVisible) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.e().setVisibility(isVisible ? 0 : 8);
    }

    public final void setOnCheckedListener(Action1<Boolean> checkedListener) {
        this.checkedListener = checkedListener;
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.c().setOnCheckedChangeListener(new CheckedSetting$e(checkedListener));
    }

    public final void setSubtext(CharSequence charSequence) {
        h(charSequence, false);
    }

    public final void setSubtextColor(@ColorInt int color) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.f().setTextColor(color);
    }

    public final void setSubtextOnClickListener(Action0 listener) {
        m.checkNotNullParameter(listener, "listener");
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.f().setOnClickListener(new CheckedSetting$f(listener));
    }

    public final void setText(CharSequence text) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.a().setText(text);
    }

    public final void setTextColor(@ColorInt int color) {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        checkedSetting$b.a().setTextColor(color);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        CheckedSetting$b checkedSetting$b = this.binding;
        if (checkedSetting$b == null) {
            m.throwUninitializedPropertyAccessException("binding");
        }
        g(!checkedSetting$b.c().isChecked(), false);
    }
}
