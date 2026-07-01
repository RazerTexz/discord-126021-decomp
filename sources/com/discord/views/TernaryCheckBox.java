package com.discord.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.a.i.a4;
import b.a.k.b;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.m;
import defpackage.c;

/* JADX INFO: compiled from: TernaryCheckBox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TernaryCheckBox extends RelativeLayout {
    public static final TernaryCheckBox$a j = new TernaryCheckBox$a(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final a4 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String labelText;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public CharSequence subtextText;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public TernaryCheckBox$b onSwitchStatusChangedListener;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int switchStatus;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TernaryCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_ternary_checkbox, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.checkable_off_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.checkable_off_container);
        if (frameLayout != null) {
            i = R$id.checkboxes_container;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.checkboxes_container);
            if (linearLayout != null) {
                i = R$id.off_disabled_overlay;
                View viewFindViewById = viewInflate.findViewById(R$id.off_disabled_overlay);
                if (viewFindViewById != null) {
                    i = R$id.setting_disabled_overlay;
                    View viewFindViewById2 = viewInflate.findViewById(R$id.setting_disabled_overlay);
                    if (viewFindViewById2 != null) {
                        i = R$id.setting_label;
                        TextView textView = (TextView) viewInflate.findViewById(R$id.setting_label);
                        if (textView != null) {
                            i = R$id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R$id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i = R$id.ternary_check_neutral;
                                CheckableImageView checkableImageView = (CheckableImageView) viewInflate.findViewById(R$id.ternary_check_neutral);
                                if (checkableImageView != null) {
                                    i = R$id.ternary_check_off;
                                    CheckableImageView checkableImageView2 = (CheckableImageView) viewInflate.findViewById(R$id.ternary_check_off);
                                    if (checkableImageView2 != null) {
                                        i = R$id.ternary_check_on;
                                        CheckableImageView checkableImageView3 = (CheckableImageView) viewInflate.findViewById(R$id.ternary_check_on);
                                        if (checkableImageView3 != null) {
                                            a4 a4Var = new a4((LinearLayout) viewInflate, frameLayout, linearLayout, viewFindViewById, viewFindViewById2, textView, linkifiedTextView, checkableImageView, checkableImageView2, checkableImageView3);
                                            m.checkNotNullExpressionValue(a4Var, "ViewTernaryCheckboxBindi…rom(context), this, true)");
                                            this.binding = a4Var;
                                            this.switchStatus = -1;
                                            if (attributeSet != null) {
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.TernaryCheckBox, 0, 0);
                                                m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.TernaryCheckBox, 0, 0)");
                                                try {
                                                    this.labelText = typedArrayObtainStyledAttributes.getString(0);
                                                    String string = typedArrayObtainStyledAttributes.getString(1);
                                                    this.subtextText = string != null ? b.l(string, new Object[0], null, 2) : null;
                                                    typedArrayObtainStyledAttributes.recycle();
                                                } catch (Throwable th) {
                                                    typedArrayObtainStyledAttributes.recycle();
                                                    throw th;
                                                }
                                            }
                                            m.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setVisibility(this.labelText != null ? 0 : 8);
                                            m.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setText(this.labelText);
                                            m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setVisibility(this.subtextText != null ? 0 : 8);
                                            m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setText(this.subtextText);
                                            checkableImageView3.setOnClickListener(new c(0, this));
                                            checkableImageView2.setOnClickListener(new c(1, this));
                                            checkableImageView.setOnClickListener(new c(2, this));
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void a(TernaryCheckBox ternaryCheckBox, int i) {
        ternaryCheckBox.setSwitchStatus(i);
    }

    private final void setDisabled(String message) {
        FrameLayout frameLayout = this.binding.f77b;
        m.checkNotNullExpressionValue(frameLayout, "binding.checkableOffContainer");
        frameLayout.setEnabled(true);
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        this.binding.d.setOnClickListener(new TernaryCheckBox$c(this, message));
        View view2 = this.binding.d;
        m.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setOffDisabled(String message) {
        CheckableImageView checkableImageView = this.binding.h;
        m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(false);
        View view = this.binding.d;
        m.checkNotNullExpressionValue(view, "binding.settingDisabledOverlay");
        view.setVisibility(8);
        this.binding.c.setOnClickListener(new TernaryCheckBox$d(this, message));
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.offDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setSwitchStatus(int i) {
        this.switchStatus = i;
        CheckableImageView checkableImageView = this.binding.i;
        m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOn");
        checkableImageView.setChecked(i == 1);
        CheckableImageView checkableImageView2 = this.binding.h;
        m.checkNotNullExpressionValue(checkableImageView2, "binding.ternaryCheckOff");
        checkableImageView2.setChecked(i == -1);
        CheckableImageView checkableImageView3 = this.binding.g;
        m.checkNotNullExpressionValue(checkableImageView3, "binding.ternaryCheckNeutral");
        checkableImageView3.setChecked(i == 0);
        TernaryCheckBox$b ternaryCheckBox$b = this.onSwitchStatusChangedListener;
        if (ternaryCheckBox$b != null) {
            ternaryCheckBox$b.onSwitchStatusChanged(i);
        }
    }

    public final boolean b() {
        return this.switchStatus == 1;
    }

    public final void c() {
        CheckableImageView checkableImageView = this.binding.h;
        m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(true);
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        View view2 = this.binding.d;
        m.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(8);
    }

    public final void d() {
        setSwitchStatus(0);
    }

    public final void e() {
        setSwitchStatus(-1);
    }

    public final void f() {
        setSwitchStatus(1);
    }

    public final TernaryCheckBox$b getOnSwitchStatusChangedListener() {
        return this.onSwitchStatusChangedListener;
    }

    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setLabel(CharSequence text) {
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.settingLabel");
        textView.setText(text);
    }

    public final void setOnSwitchStatusChangedListener(TernaryCheckBox$b ternaryCheckBox$b) {
        this.onSwitchStatusChangedListener = ternaryCheckBox$b;
    }

    public final void setSubtext(CharSequence text) {
        LinkifiedTextView linkifiedTextView = this.binding.f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
        linkifiedTextView.setText(text);
    }

    public final void setDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        m.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setDisabled(string);
    }

    public final void setOffDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        m.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setOffDisabled(string);
    }
}
