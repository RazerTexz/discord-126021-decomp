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
import b.a.d.AppToast;
import b.a.i.ViewTernaryCheckboxBinding;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: TernaryCheckBox.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TernaryCheckBox extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final ViewTernaryCheckboxBinding binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public String labelText;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public CharSequence subtextText;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public b onSwitchStatusChangedListener;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public int switchStatus;

    /* JADX INFO: renamed from: com.discord.views.TernaryCheckBox$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public interface b {
        void onSwitchStatusChanged(int i);
    }

    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ String k;

        public c(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.h(TernaryCheckBox.this.getContext(), this.k, 0, null, 12);
        }
    }

    /* JADX INFO: compiled from: TernaryCheckBox.kt */
    public static final class d implements View.OnClickListener {
        public final /* synthetic */ String k;

        public d(String str) {
            this.k = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppToast.h(TernaryCheckBox.this.getContext(), this.k, 0, null, 12);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TernaryCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.view_ternary_checkbox, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.checkable_off_container;
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.checkable_off_container);
        if (frameLayout != null) {
            i = R.id.checkboxes_container;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.checkboxes_container);
            if (linearLayout != null) {
                i = R.id.off_disabled_overlay;
                View viewFindViewById = viewInflate.findViewById(R.id.off_disabled_overlay);
                if (viewFindViewById != null) {
                    i = R.id.setting_disabled_overlay;
                    View viewFindViewById2 = viewInflate.findViewById(R.id.setting_disabled_overlay);
                    if (viewFindViewById2 != null) {
                        i = R.id.setting_label;
                        TextView textView = (TextView) viewInflate.findViewById(R.id.setting_label);
                        if (textView != null) {
                            i = R.id.setting_subtext;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.setting_subtext);
                            if (linkifiedTextView != null) {
                                i = R.id.ternary_check_neutral;
                                CheckableImageView checkableImageView = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_neutral);
                                if (checkableImageView != null) {
                                    i = R.id.ternary_check_off;
                                    CheckableImageView checkableImageView2 = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_off);
                                    if (checkableImageView2 != null) {
                                        i = R.id.ternary_check_on;
                                        CheckableImageView checkableImageView3 = (CheckableImageView) viewInflate.findViewById(R.id.ternary_check_on);
                                        if (checkableImageView3 != null) {
                                            ViewTernaryCheckboxBinding viewTernaryCheckboxBinding = new ViewTernaryCheckboxBinding((LinearLayout) viewInflate, frameLayout, linearLayout, viewFindViewById, viewFindViewById2, textView, linkifiedTextView, checkableImageView, checkableImageView2, checkableImageView3);
                                            Intrinsics3.checkNotNullExpressionValue(viewTernaryCheckboxBinding, "ViewTernaryCheckboxBindi…rom(context), this, true)");
                                            this.binding = viewTernaryCheckboxBinding;
                                            this.switchStatus = -1;
                                            if (attributeSet != null) {
                                                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.TernaryCheckBox, 0, 0);
                                                Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.TernaryCheckBox, 0, 0)");
                                                try {
                                                    this.labelText = typedArrayObtainStyledAttributes.getString(0);
                                                    String string = typedArrayObtainStyledAttributes.getString(1);
                                                    this.subtextText = string != null ? FormatUtils.g(string, new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null) : null;
                                                    typedArrayObtainStyledAttributes.recycle();
                                                } catch (Throwable th) {
                                                    typedArrayObtainStyledAttributes.recycle();
                                                    throw th;
                                                }
                                            }
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setVisibility(this.labelText != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
                                            textView.setText(this.labelText);
                                            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setVisibility(this.subtextText != null ? 0 : 8);
                                            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                                            linkifiedTextView.setText(this.subtextText);
                                            checkableImageView3.setOnClickListener(new defpackage.c(0, this));
                                            checkableImageView2.setOnClickListener(new defpackage.c(1, this));
                                            checkableImageView.setOnClickListener(new defpackage.c(2, this));
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
        FrameLayout frameLayout = this.binding.f77b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.checkableOffContainer");
        frameLayout.setEnabled(true);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        this.binding.d.setOnClickListener(new c(message));
        View view2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setOffDisabled(String message) {
        CheckableImageView checkableImageView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(false);
        View view = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.settingDisabledOverlay");
        view.setVisibility(8);
        this.binding.c.setOnClickListener(new d(message));
        View view2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.offDisabledOverlay");
        view2.setVisibility(0);
    }

    private final void setSwitchStatus(int i) {
        this.switchStatus = i;
        CheckableImageView checkableImageView = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOn");
        checkableImageView.setChecked(i == 1);
        CheckableImageView checkableImageView2 = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView2, "binding.ternaryCheckOff");
        checkableImageView2.setChecked(i == -1);
        CheckableImageView checkableImageView3 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView3, "binding.ternaryCheckNeutral");
        checkableImageView3.setChecked(i == 0);
        b bVar = this.onSwitchStatusChangedListener;
        if (bVar != null) {
            bVar.onSwitchStatusChanged(i);
        }
    }

    public final boolean b() {
        return this.switchStatus == 1;
    }

    public final void c() {
        CheckableImageView checkableImageView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(checkableImageView, "binding.ternaryCheckOff");
        checkableImageView.setEnabled(true);
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.offDisabledOverlay");
        view.setVisibility(8);
        View view2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingDisabledOverlay");
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

    public final b getOnSwitchStatusChangedListener() {
        return this.onSwitchStatusChangedListener;
    }

    public final int getSwitchStatus() {
        return this.switchStatus;
    }

    public final void setLabel(CharSequence text) {
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingLabel");
        textView.setText(text);
    }

    public final void setOnSwitchStatusChangedListener(b bVar) {
        this.onSwitchStatusChangedListener = bVar;
    }

    public final void setSubtext(CharSequence text) {
        LinkifiedTextView linkifiedTextView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
        linkifiedTextView.setText(text);
    }

    public final void setDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setDisabled(string);
    }

    public final void setOffDisabled(int messageRes) {
        String string = getContext().getString(messageRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(messageRes)");
        setOffDisabled(string);
    }
}
