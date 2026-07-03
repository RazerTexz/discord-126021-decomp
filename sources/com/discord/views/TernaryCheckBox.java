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
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p000.ViewOnClickListenerC5317c;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0916a4;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TernaryCheckBox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TernaryCheckBox extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C0916a4 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String labelText;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public CharSequence subtextText;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public InterfaceC7094b onSwitchStatusChangedListener;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int switchStatus;

    /* JADX INFO: renamed from: com.discord.views.TernaryCheckBox$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: com.discord.views.TernaryCheckBox$b */
    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public interface InterfaceC7094b {
        void onSwitchStatusChanged(int i);
    }

    /* JADX INFO: renamed from: com.discord.views.TernaryCheckBox$c */
    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class ViewOnClickListenerC7095c implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ String f19162k;

        public ViewOnClickListenerC7095c(String str) {
            this.f19162k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0876m.m170h(TernaryCheckBox.this.getContext(), this.f19162k, 0, null, 12);
        }
    }

    /* JADX INFO: renamed from: com.discord.views.TernaryCheckBox$d */
    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class ViewOnClickListenerC7096d implements View.OnClickListener {

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ String f19164k;

        public ViewOnClickListenerC7096d(String str) {
            this.f19164k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0876m.m170h(TernaryCheckBox.this.getContext(), this.f19164k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TernaryCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.view_ternary_checkbox, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.checkable_off_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C5419R.id.checkable_off_container);
        if (frameLayout != null) {
            i = C5419R.id.checkboxes_container;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.checkboxes_container);
            if (linearLayout != null) {
                i = C5419R.id.off_disabled_overlay;
                View viewFindViewById = viewInflate.findViewById(C5419R.id.off_disabled_overlay);
                if (viewFindViewById != null) {
                    i = C5419R.id.setting_disabled_overlay;
                    View viewFindViewById2 = viewInflate.findViewById(C5419R.id.setting_disabled_overlay);
                    if (viewFindViewById2 != null) {
                        i = C5419R.id.setting_label;
                        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.setting_label);
                        if (textView != null) {
                            i = C5419R.id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i = C5419R.id.ternary_check_neutral;
                                CheckableImageView checkableImageView = (CheckableImageView) viewInflate.findViewById(C5419R.id.ternary_check_neutral);
                                if (checkableImageView != null) {
                                    i = C5419R.id.ternary_check_off;
                                    CheckableImageView checkableImageView2 = (CheckableImageView) viewInflate.findViewById(C5419R.id.ternary_check_off);
                                    if (checkableImageView2 != null) {
                                        i = C5419R.id.ternary_check_on;
                                        CheckableImageView checkableImageView3 = (CheckableImageView) viewInflate.findViewById(C5419R.id.ternary_check_on);
                                        if (checkableImageView3 != null) {
                                            C0916a4 c0916a4 = new C0916a4((LinearLayout) viewInflate, frameLayout, linearLayout, viewFindViewById, viewFindViewById2, textView, linkifiedTextView, checkableImageView, checkableImageView2, checkableImageView3);
                                            C12238m.checkNotNullExpressionValue(c0916a4, "ViewTernaryCheckboxBindi…rom(context), this, true)");
                                            this.binding = c0916a4;
                                            this.switchStatus = -1;
                                            if (attributeSet != null) {
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.TernaryCheckBox, 0, 0);
                                                C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.TernaryCheckBox, 0, 0)");
                                                try {
                                                    this.labelText = typedArrayObtainStyledAttributes.getString(0);
                                                    String string = typedArrayObtainStyledAttributes.getString(1);
                                                    this.subtextText = string != null ? C1107b.m215g(string, new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null) : null;
                                                    typedArrayObtainStyledAttributes.recycle();
                                                } catch (Throwable th) {
                                                    typedArrayObtainStyledAttributes.recycle();
                                                    throw th;
                                                }
                                            }
                                            C12238m.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setVisibility(this.labelText != null ? 0 : 8);
                                            C12238m.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setText(this.labelText);
                                            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setVisibility(this.subtextText != null ? 0 : 8);
                                            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setText(this.subtextText);
                                            checkableImageView3.setOnClickListener(new ViewOnClickListenerC5317c(0, this));
                                            checkableImageView2.setOnClickListener(new ViewOnClickListenerC5317c(1, this));
                                            checkableImageView.setOnClickListener(new ViewOnClickListenerC5317c(2, this));
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

    private final void setDisabled(String message) {
        FrameLayout frameLayout = this.binding.f671b;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.checkableOffContainer");
        frameLayout.setEnabled(true);
        View view = this.binding.f672c;
        C12238m.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        this.binding.f673d.setOnClickListener(new ViewOnClickListenerC7095c(message));
        View view2 = this.binding.f673d;
        C12238m.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setOffDisabled(String message) {
        CheckableImageView checkableImageView = this.binding.f677h;
        C12238m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(false);
        View view = this.binding.f673d;
        C12238m.checkNotNullExpressionValue(view, "binding.settingDisabledOverlay");
        view.setVisibility(8);
        this.binding.f672c.setOnClickListener(new ViewOnClickListenerC7096d(message));
        View view2 = this.binding.f672c;
        C12238m.checkNotNullExpressionValue(view2, "binding.offDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setSwitchStatus(int i) {
        this.switchStatus = i;
        CheckableImageView checkableImageView = this.binding.f678i;
        C12238m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOn");
        checkableImageView.setChecked(i == 1);
        CheckableImageView checkableImageView2 = this.binding.f677h;
        C12238m.checkNotNullExpressionValue(checkableImageView2, "binding.ternaryCheckOff");
        checkableImageView2.setChecked(i == -1);
        CheckableImageView checkableImageView3 = this.binding.f676g;
        C12238m.checkNotNullExpressionValue(checkableImageView3, "binding.ternaryCheckNeutral");
        checkableImageView3.setChecked(i == 0);
        InterfaceC7094b interfaceC7094b = this.onSwitchStatusChangedListener;
        if (interfaceC7094b != null) {
            interfaceC7094b.onSwitchStatusChanged(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8559b() {
        return this.switchStatus == 1;
    }

    /* JADX INFO: renamed from: c */
    public final void m8560c() {
        CheckableImageView checkableImageView = this.binding.f677h;
        C12238m.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(true);
        View view = this.binding.f672c;
        C12238m.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        View view2 = this.binding.f673d;
        C12238m.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(8);
    }

    /* JADX INFO: renamed from: d */
    public final void m8561d() {
        setSwitchStatus(0);
    }

    /* JADX INFO: renamed from: e */
    public final void m8562e() {
        setSwitchStatus(-1);
    }

    /* JADX INFO: renamed from: f */
    public final void m8563f() {
        setSwitchStatus(1);
    }

    public final InterfaceC7094b getOnSwitchStatusChangedListener() {
        return this.onSwitchStatusChangedListener;
    }

    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setLabel(CharSequence text) {
        TextView textView = this.binding.f674e;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingLabel");
        textView.setText(text);
    }

    public final void setOnSwitchStatusChangedListener(InterfaceC7094b interfaceC7094b) {
        this.onSwitchStatusChangedListener = interfaceC7094b;
    }

    public final void setSubtext(CharSequence text) {
        LinkifiedTextView linkifiedTextView = this.binding.f675f;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
        linkifiedTextView.setText(text);
    }

    public final void setDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        C12238m.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setDisabled(string);
    }

    public final void setOffDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        C12238m.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setOffDisabled(string);
    }
}
