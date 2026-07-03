package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadArchiveActionsSheetBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final NestedScrollView f18252a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final TextView f18253b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final LinearLayout f18254c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ConstraintLayout f18255d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final MaterialRadioButton f18256e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ConstraintLayout f18257f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MaterialRadioButton f18258g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ConstraintLayout f18259h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialRadioButton f18260i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final ConstraintLayout f18261j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final MaterialRadioButton f18262k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f18263l;

    public WidgetThreadArchiveActionsSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialRadioButton materialRadioButton2, @NonNull ConstraintLayout constraintLayout3, @NonNull MaterialRadioButton materialRadioButton3, @NonNull ConstraintLayout constraintLayout4, @NonNull MaterialRadioButton materialRadioButton4, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f18252a = nestedScrollView;
        this.f18253b = textView;
        this.f18254c = linearLayout;
        this.f18255d = constraintLayout;
        this.f18256e = materialRadioButton;
        this.f18257f = constraintLayout2;
        this.f18258g = materialRadioButton2;
        this.f18259h = constraintLayout3;
        this.f18260i = materialRadioButton3;
        this.f18261j = constraintLayout4;
        this.f18262k = materialRadioButton4;
        this.f18263l = textView2;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetThreadArchiveActionsSheetBinding m8420a(@NonNull View view) {
        int i = C5419R.id.archive_now;
        TextView textView = (TextView) view.findViewById(C5419R.id.archive_now);
        if (textView != null) {
            i = C5419R.id.auto_archive_header;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.auto_archive_header);
            if (linearLayout != null) {
                i = C5419R.id.auto_archive_sheet_duration_options;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.auto_archive_sheet_duration_options);
                if (linearLayout2 != null) {
                    i = C5419R.id.option_one_hour;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.option_one_hour);
                    if (constraintLayout != null) {
                        i = C5419R.id.option_one_hour_radio;
                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(C5419R.id.option_one_hour_radio);
                        if (materialRadioButton != null) {
                            i = C5419R.id.option_seven_days;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.option_seven_days);
                            if (constraintLayout2 != null) {
                                i = C5419R.id.option_seven_days_radio;
                                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(C5419R.id.option_seven_days_radio);
                                if (materialRadioButton2 != null) {
                                    i = C5419R.id.option_three_days;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(C5419R.id.option_three_days);
                                    if (constraintLayout3 != null) {
                                        i = C5419R.id.option_three_days_radio;
                                        MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view.findViewById(C5419R.id.option_three_days_radio);
                                        if (materialRadioButton3 != null) {
                                            i = C5419R.id.option_twenty_four_hours;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(C5419R.id.option_twenty_four_hours);
                                            if (constraintLayout4 != null) {
                                                i = C5419R.id.option_twenty_four_hours_radio;
                                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view.findViewById(C5419R.id.option_twenty_four_hours_radio);
                                                if (materialRadioButton4 != null) {
                                                    i = C5419R.id.subtitle;
                                                    TextView textView2 = (TextView) view.findViewById(C5419R.id.subtitle);
                                                    if (textView2 != null) {
                                                        i = C5419R.id.title;
                                                        TextView textView3 = (TextView) view.findViewById(C5419R.id.title);
                                                        if (textView3 != null) {
                                                            return new WidgetThreadArchiveActionsSheetBinding((NestedScrollView) view, textView, linearLayout, linearLayout2, constraintLayout, materialRadioButton, constraintLayout2, materialRadioButton2, constraintLayout3, materialRadioButton3, constraintLayout4, materialRadioButton4, textView2, textView3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18252a;
    }
}
