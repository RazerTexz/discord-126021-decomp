package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1027p3;
import p007b.p008a.p025i.C1034q3;
import p007b.p008a.p025i.C1041r3;
import p007b.p008a.p025i.C1048s3;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action0;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting extends RelativeLayout implements Checkable {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19010j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Action1<Boolean> checkedListener;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public InterfaceC7067b binding;

    /* JADX INFO: compiled from: CheckedSetting.kt */
    public enum ViewType {
        CHECK,
        RADIO,
        SWITCH;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] VALUES = values();

        /* JADX INFO: renamed from: com.discord.views.CheckedSetting$ViewType$a, reason: from kotlin metadata */
        /* JADX INFO: compiled from: CheckedSetting.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes.dex */
    public static final class ViewOnClickListenerC7066a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f19013j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f19014k;

        public ViewOnClickListenerC7066a(int i, Object obj) {
            this.f19013j = i;
            this.f19014k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f19013j;
            if (i == 0) {
                CheckedSetting.m8522a((CheckedSetting) this.f19014k).mo8533c().setChecked(true);
            } else {
                if (i != 1) {
                    throw null;
                }
                CheckedSetting.m8522a((CheckedSetting) this.f19014k).mo8533c().setChecked(true ^ CheckedSetting.m8522a((CheckedSetting) this.f19014k).mo8533c().isChecked());
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$b */
    /* JADX INFO: compiled from: CheckedSetting.kt */
    public interface InterfaceC7067b {

        /* JADX INFO: renamed from: com.discord.views.CheckedSetting$b$a */
        /* JADX INFO: compiled from: CheckedSetting.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: e */
            public final ConstraintLayout f19015e;

            /* JADX INFO: renamed from: f */
            public final MaterialCheckBox f19016f;

            /* JADX WARN: Illegal instructions before constructor call */
            public a(C1027p3 c1027p3) {
                C12238m.checkNotNullParameter(c1027p3, "binding");
                ConstraintLayout constraintLayout = c1027p3.f1136c;
                C12238m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = c1027p3.f1136c;
                C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.f19015e = constraintLayout2;
                MaterialCheckBox materialCheckBox = c1027p3.f1135b;
                C12238m.checkNotNullExpressionValue(materialCheckBox, "binding.settingButton");
                this.f19016f = materialCheckBox;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: b */
            public View mo8532b() {
                return this.f19015e;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: c */
            public CompoundButton mo8533c() {
                return this.f19016f;
            }
        }

        /* JADX INFO: renamed from: com.discord.views.CheckedSetting$b$b */
        /* JADX INFO: compiled from: CheckedSetting.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: e */
            public final ConstraintLayout f19017e;

            /* JADX INFO: renamed from: f */
            public final MaterialRadioButton f19018f;

            /* JADX WARN: Illegal instructions before constructor call */
            public b(C1034q3 c1034q3) {
                C12238m.checkNotNullParameter(c1034q3, "binding");
                ConstraintLayout constraintLayout = c1034q3.f1150c;
                C12238m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = c1034q3.f1150c;
                C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.f19017e = constraintLayout2;
                MaterialRadioButton materialRadioButton = c1034q3.f1149b;
                C12238m.checkNotNullExpressionValue(materialRadioButton, "binding.settingButton");
                this.f19018f = materialRadioButton;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: b */
            public View mo8532b() {
                return this.f19017e;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: c */
            public CompoundButton mo8533c() {
                return this.f19018f;
            }
        }

        /* JADX INFO: renamed from: com.discord.views.CheckedSetting$b$c */
        /* JADX INFO: compiled from: CheckedSetting.kt */
        public static abstract class c implements InterfaceC7067b {

            /* JADX INFO: renamed from: a */
            public final TextView f19019a;

            /* JADX INFO: renamed from: b */
            public final TextView f19020b;

            /* JADX INFO: renamed from: c */
            public final LinkifiedTextView f19021c;

            /* JADX INFO: renamed from: d */
            public final ImageView f19022d;

            public c(ViewGroup viewGroup, C1041r3 c1041r3, int i) {
                C1041r3 c1041r4;
                if ((i & 2) != 0) {
                    int i2 = C5419R.id.setting_drawable_left;
                    ImageView imageView = (ImageView) viewGroup.findViewById(C5419R.id.setting_drawable_left);
                    if (imageView != null) {
                        i2 = C5419R.id.setting_label;
                        TextView textView = (TextView) viewGroup.findViewById(C5419R.id.setting_label);
                        if (textView != null) {
                            i2 = C5419R.id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewGroup.findViewById(C5419R.id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i2 = C5419R.id.setting_tag;
                                TextView textView2 = (TextView) viewGroup.findViewById(C5419R.id.setting_tag);
                                if (textView2 != null) {
                                    c1041r4 = new C1041r3(viewGroup, imageView, textView, linkifiedTextView, textView2);
                                    C12238m.checkNotNullExpressionValue(c1041r4, "ViewSettingSharedBinding.bind(container)");
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewGroup.getResources().getResourceName(i2)));
                }
                c1041r4 = null;
                C12238m.checkNotNullParameter(viewGroup, "container");
                C12238m.checkNotNullParameter(c1041r4, "binding");
                TextView textView3 = c1041r4.f1183c;
                C12238m.checkNotNullExpressionValue(textView3, "binding.settingLabel");
                this.f19019a = textView3;
                TextView textView4 = c1041r4.f1185e;
                C12238m.checkNotNullExpressionValue(textView4, "binding.settingTag");
                this.f19020b = textView4;
                LinkifiedTextView linkifiedTextView2 = c1041r4.f1184d;
                C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.settingSubtext");
                this.f19021c = linkifiedTextView2;
                ImageView imageView2 = c1041r4.f1182b;
                C12238m.checkNotNullExpressionValue(imageView2, "binding.settingDrawableLeft");
                this.f19022d = imageView2;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: a */
            public TextView mo8531a() {
                return this.f19019a;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: d */
            public ImageView mo8534d() {
                return this.f19022d;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: e */
            public TextView mo8535e() {
                return this.f19020b;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: f */
            public TextView mo8536f() {
                return this.f19021c;
            }
        }

        /* JADX INFO: renamed from: com.discord.views.CheckedSetting$b$d */
        /* JADX INFO: compiled from: CheckedSetting.kt */
        public static final class d extends c {

            /* JADX INFO: renamed from: e */
            public final ConstraintLayout f19023e;

            /* JADX INFO: renamed from: f */
            public final SwitchMaterial f19024f;

            /* JADX WARN: Illegal instructions before constructor call */
            public d(C1048s3 c1048s3) {
                C12238m.checkNotNullParameter(c1048s3, "binding");
                ConstraintLayout constraintLayout = c1048s3.f1213c;
                C12238m.checkNotNullExpressionValue(constraintLayout, "binding.settingContainer");
                super(constraintLayout, null, 2);
                ConstraintLayout constraintLayout2 = c1048s3.f1213c;
                C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.settingContainer");
                this.f19023e = constraintLayout2;
                SwitchMaterial switchMaterial = c1048s3.f1212b;
                C12238m.checkNotNullExpressionValue(switchMaterial, "binding.settingButton");
                this.f19024f = switchMaterial;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: b */
            public View mo8532b() {
                return this.f19023e;
            }

            @Override // com.discord.views.CheckedSetting.InterfaceC7067b
            /* JADX INFO: renamed from: c */
            public CompoundButton mo8533c() {
                return this.f19024f;
            }
        }

        /* JADX INFO: renamed from: a */
        TextView mo8531a();

        /* JADX INFO: renamed from: b */
        View mo8532b();

        /* JADX INFO: renamed from: c */
        CompoundButton mo8533c();

        /* JADX INFO: renamed from: d */
        ImageView mo8534d();

        /* JADX INFO: renamed from: e */
        TextView mo8535e();

        /* JADX INFO: renamed from: f */
        TextView mo8536f();
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$c */
    /* JADX INFO: compiled from: CheckedSetting.kt */
    public static final class ViewOnClickListenerC7068c implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ CharSequence f19026k;

        public ViewOnClickListenerC7068c(CharSequence charSequence) {
            this.f19026k = charSequence;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.f19026k != null) {
                C0876m.m170h(CheckedSetting.this.getContext(), this.f19026k, 0, null, 12);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$d */
    /* JADX INFO: compiled from: CheckedSetting.kt */
    public static final class C7069d extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ ViewType f19028b;

        public C7069d(ViewType viewType) {
            this.f19028b = viewType;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C12238m.checkNotNullParameter(view, "host");
            C12238m.checkNotNullParameter(accessibilityEvent, "event");
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(CheckedSetting.this.isChecked());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            C12238m.checkNotNullParameter(view, "host");
            C12238m.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(true);
            accessibilityNodeInfoCompat.setChecked(CheckedSetting.this.isChecked());
            Resources resources = view.getResources();
            int iOrdinal = this.f19028b.ordinal();
            if (iOrdinal == 0) {
                i = C5419R.string.a11y_role_checkbox;
            } else if (iOrdinal == 1) {
                i = C5419R.string.a11y_role_radio_button;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i = C5419R.string.a11y_role_switch;
            }
            accessibilityNodeInfoCompat.setRoleDescription(resources.getString(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$e */
    /* JADX INFO: compiled from: CheckedSetting.kt */
    public static final class C7070e implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Action1 f19029a;

        public C7070e(Action1 action1) {
            this.f19029a = action1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            Action1 action1 = this.f19029a;
            if (action1 != null) {
                action1.call(Boolean.valueOf(z2));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.views.CheckedSetting$f */
    /* JADX INFO: compiled from: CheckedSetting.kt */
    public static final class ViewOnClickListenerC7071f implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Action0 f19030j;

        public ViewOnClickListenerC7071f(Action0 action0) {
            this.f19030j = action0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f19030j.call();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckedSetting(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            m8528f(ViewType.CHECK);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.CheckedSetting, 0, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…ble.CheckedSetting, 0, 0)");
        try {
            int i = typedArrayObtainStyledAttributes.getInt(15, ViewType.CHECK.ordinal());
            Objects.requireNonNull(ViewType.INSTANCE);
            m8528f(ViewType.VALUES[i]);
            InterfaceC7067b interfaceC7067b = this.binding;
            if (interfaceC7067b == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingLeft = interfaceC7067b.mo8532b().getPaddingLeft();
            InterfaceC7067b interfaceC7067b2 = this.binding;
            if (interfaceC7067b2 == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            int paddingTop = interfaceC7067b2.mo8532b().getPaddingTop();
            int dimension = (int) typedArrayObtainStyledAttributes.getDimension(6, paddingLeft);
            int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(7, paddingTop);
            InterfaceC7067b interfaceC7067b3 = this.binding;
            if (interfaceC7067b3 == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            interfaceC7067b3.mo8532b().setPadding(dimension, dimension2, dimension, dimension2);
            float dimension3 = typedArrayObtainStyledAttributes.getDimension(14, -1.0f);
            float f = 0;
            if (dimension3 > f) {
                InterfaceC7067b interfaceC7067b4 = this.binding;
                if (interfaceC7067b4 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b4.mo8531a().setTextSize(0, dimension3);
            }
            ColorStateList colorStateList = typedArrayObtainStyledAttributes.getColorStateList(12);
            if (colorStateList != null) {
                InterfaceC7067b interfaceC7067b5 = this.binding;
                if (interfaceC7067b5 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b5.mo8531a().setTextColor(colorStateList);
            }
            InterfaceC7067b interfaceC7067b6 = this.binding;
            if (interfaceC7067b6 == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            TextView textViewMo8531a = interfaceC7067b6.mo8531a();
            String string = typedArrayObtainStyledAttributes.getString(11);
            textViewMo8531a.setText(string != null ? C1107b.m215g(string, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : null);
            InterfaceC7067b interfaceC7067b7 = this.binding;
            if (interfaceC7067b7 == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageViewMo8534d = interfaceC7067b7.mo8534d();
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(3);
            imageViewMo8534d.setVisibility(drawable != null ? 0 : 8);
            imageViewMo8534d.setImageDrawable(drawable);
            ColorStateList colorStateList2 = typedArrayObtainStyledAttributes.getColorStateList(4);
            if (colorStateList2 != null) {
                imageViewMo8534d.setImageTintList(colorStateList2);
            }
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(13, -1);
            if (resourceId != -1) {
                InterfaceC7067b interfaceC7067b8 = this.binding;
                if (interfaceC7067b8 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b8.mo8531a().setTypeface(ResourcesCompat.getFont(getContext(), resourceId));
            }
            String string2 = typedArrayObtainStyledAttributes.getString(8);
            CharSequence charSequenceM215g = string2 != null ? C1107b.m215g(string2, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : null;
            if (charSequenceM215g == null || charSequenceM215g.length() == 0) {
                InterfaceC7067b interfaceC7067b9 = this.binding;
                if (interfaceC7067b9 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b9.mo8536f().setVisibility(8);
            } else {
                InterfaceC7067b interfaceC7067b10 = this.binding;
                if (interfaceC7067b10 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b10.mo8536f().setText(charSequenceM215g);
                InterfaceC7067b interfaceC7067b11 = this.binding;
                if (interfaceC7067b11 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b11.mo8536f().setVisibility(0);
            }
            float dimension4 = typedArrayObtainStyledAttributes.getDimension(10, -1.0f);
            if (dimension4 > f) {
                InterfaceC7067b interfaceC7067b12 = this.binding;
                if (interfaceC7067b12 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b12.mo8536f().setTextSize(0, dimension4);
            }
            ColorStateList colorStateList3 = typedArrayObtainStyledAttributes.getColorStateList(9);
            if (colorStateList3 != null) {
                InterfaceC7067b interfaceC7067b13 = this.binding;
                if (interfaceC7067b13 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b13.mo8536f().setTextColor(colorStateList3);
            }
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(0);
            if (drawable2 != null) {
                setBackground(drawable2);
            } else {
                setBackgroundResource(C5419R.drawable.drawable_bg_settings_item_white);
            }
            ColorStateList colorStateList4 = typedArrayObtainStyledAttributes.getColorStateList(1);
            if (colorStateList4 != null) {
                setBackgroundTintList(colorStateList4);
            }
            Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(2);
            if (drawable3 != null) {
                InterfaceC7067b interfaceC7067b14 = this.binding;
                if (interfaceC7067b14 == null) {
                    C12238m.throwUninitializedPropertyAccessException("binding");
                }
                interfaceC7067b14.mo8532b().setBackground(drawable3);
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ InterfaceC7067b m8522a(CheckedSetting checkedSetting) {
        InterfaceC7067b interfaceC7067b = checkedSetting.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        return interfaceC7067b;
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ void m8523d(CheckedSetting checkedSetting, CharSequence charSequence, int i) {
        int i2 = i & 1;
        checkedSetting.m8526c(null);
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ void m8524i(CheckedSetting checkedSetting, CharSequence charSequence, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        checkedSetting.m8530h(charSequence, z2);
    }

    /* JADX INFO: renamed from: b */
    public final void m8525b(@StringRes int disabledToastRes) {
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        m8526c(C1107b.m210b(context, disabledToastRes, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null));
    }

    /* JADX INFO: renamed from: c */
    public final void m8526c(CharSequence disabledToastText) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8532b().setOnClickListener(new ViewOnClickListenerC7068c(disabledToastText));
        setAlpha(0.3f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        C12238m.checkNotNullParameter(container, "container");
        dispatchThawSelfOnly(container);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> container) {
        C12238m.checkNotNullParameter(container, "container");
        dispatchFreezeSelfOnly(container);
    }

    /* JADX INFO: renamed from: e */
    public final void m8527e(View.OnClickListener listener) {
        C12238m.checkNotNullParameter(listener, "listener");
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8532b().setOnClickListener(listener);
        setAlpha(1.0f);
    }

    /* JADX INFO: renamed from: f */
    public final void m8528f(ViewType viewType) {
        InterfaceC7067b aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int iOrdinal = viewType.ordinal();
        int i = C5419R.id.setting_button;
        if (iOrdinal == 0) {
            layoutInflaterFrom.inflate(C5419R.layout.view_setting_check, this);
            MaterialCheckBox materialCheckBox = (MaterialCheckBox) findViewById(C5419R.id.setting_button);
            if (materialCheckBox != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C5419R.id.setting_container);
                if (constraintLayout != null) {
                    C1027p3 c1027p3 = new C1027p3(this, materialCheckBox, constraintLayout);
                    C12238m.checkNotNullExpressionValue(c1027p3, "ViewSettingCheckBinding.…ate(layoutInflater, this)");
                    C12238m.checkNotNullParameter(c1027p3, "binding");
                    aVar = new InterfaceC7067b.a(c1027p3);
                } else {
                    i = C5419R.id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal == 1) {
            layoutInflaterFrom.inflate(C5419R.layout.view_setting_radio, this);
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) findViewById(C5419R.id.setting_button);
            if (materialRadioButton != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(C5419R.id.setting_container);
                if (constraintLayout2 != null) {
                    C1034q3 c1034q3 = new C1034q3(this, materialRadioButton, constraintLayout2);
                    C12238m.checkNotNullExpressionValue(c1034q3, "ViewSettingRadioBinding.…ate(layoutInflater, this)");
                    C12238m.checkNotNullParameter(c1034q3, "binding");
                    aVar = new InterfaceC7067b.b(c1034q3);
                } else {
                    i = C5419R.id.setting_container;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        layoutInflaterFrom.inflate(C5419R.layout.view_setting_switch, this);
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(C5419R.id.setting_button);
        if (switchMaterial != null) {
            ConstraintLayout constraintLayout3 = (ConstraintLayout) findViewById(C5419R.id.setting_container);
            if (constraintLayout3 != null) {
                C1048s3 c1048s3 = new C1048s3(this, switchMaterial, constraintLayout3);
                C12238m.checkNotNullExpressionValue(c1048s3, "ViewSettingSwitchBinding…ate(layoutInflater, this)");
                C12238m.checkNotNullParameter(c1048s3, "binding");
                aVar = new InterfaceC7067b.d(c1048s3);
            } else {
                i = C5419R.id.setting_container;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
        this.binding = aVar;
        if (viewType == ViewType.RADIO) {
            aVar.mo8532b().setOnClickListener(new ViewOnClickListenerC7066a(0, this));
        } else {
            aVar.mo8532b().setOnClickListener(new ViewOnClickListenerC7066a(1, this));
        }
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        ViewCompat.setAccessibilityDelegate(interfaceC7067b.mo8532b(), new C7069d(viewType));
    }

    /* JADX INFO: renamed from: g */
    public final void m8529g(boolean checked, boolean reportChange) {
        if (reportChange) {
            InterfaceC7067b interfaceC7067b = this.binding;
            if (interfaceC7067b == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            interfaceC7067b.mo8533c().setChecked(checked);
            return;
        }
        InterfaceC7067b interfaceC7067b2 = this.binding;
        if (interfaceC7067b2 == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b2.mo8533c().setOnCheckedChangeListener(null);
        InterfaceC7067b interfaceC7067b3 = this.binding;
        if (interfaceC7067b3 == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b3.mo8533c().setChecked(checked);
        setOnCheckedListener(this.checkedListener);
    }

    /* JADX INFO: renamed from: h */
    public final void m8530h(CharSequence text, boolean containsClickables) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8536f().setText(text);
        InterfaceC7067b interfaceC7067b2 = this.binding;
        if (interfaceC7067b2 == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b2.mo8536f().setVisibility(text == null || text.length() == 0 ? 8 : 0);
        if (containsClickables) {
            InterfaceC7067b interfaceC7067b3 = this.binding;
            if (interfaceC7067b3 == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            interfaceC7067b3.mo8536f().setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        return interfaceC7067b.mo8533c().isChecked();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Parcelable parcelable;
        C12238m.checkNotNullParameter(state, "state");
        if (state instanceof Bundle) {
            InterfaceC7067b interfaceC7067b = this.binding;
            if (interfaceC7067b == null) {
                C12238m.throwUninitializedPropertyAccessException("binding");
            }
            Bundle bundle = (Bundle) state;
            interfaceC7067b.mo8533c().setChecked(bundle.getBoolean("STATE_CHECKED"));
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
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8533c().setAlpha(alpha);
    }

    public final void setButtonVisibility(boolean isVisible) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8533c().setVisibility(isVisible ? 0 : 8);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean checked) {
        m8529g(checked, false);
    }

    public final void setLabelTagText(@StringRes int resId) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8535e().setText(resId);
    }

    public final void setLabelTagVisibility(boolean isVisible) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8535e().setVisibility(isVisible ? 0 : 8);
    }

    public final void setOnCheckedListener(Action1<Boolean> checkedListener) {
        this.checkedListener = checkedListener;
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8533c().setOnCheckedChangeListener(new C7070e(checkedListener));
    }

    public final void setSubtext(CharSequence charSequence) {
        m8530h(charSequence, false);
    }

    public final void setSubtextColor(@ColorInt int color) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8536f().setTextColor(color);
    }

    public final void setSubtextOnClickListener(Action0 listener) {
        C12238m.checkNotNullParameter(listener, "listener");
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8536f().setOnClickListener(new ViewOnClickListenerC7071f(listener));
    }

    public final void setText(CharSequence text) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8531a().setText(text);
    }

    public final void setTextColor(@ColorInt int color) {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        interfaceC7067b.mo8531a().setTextColor(color);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        InterfaceC7067b interfaceC7067b = this.binding;
        if (interfaceC7067b == null) {
            C12238m.throwUninitializedPropertyAccessException("binding");
        }
        m8529g(!interfaceC7067b.mo8533c().isChecked(), false);
    }
}
