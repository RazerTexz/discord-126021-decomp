package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.R;
import com.google.android.material.radiobutton.MaterialRadioButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetThreadArchiveActionsSheetBinding implements ViewBinding {

    @NonNull
    public final NestedScrollView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f2667b;

    @NonNull
    public final LinearLayout c;

    @NonNull
    public final ConstraintLayout d;

    @NonNull
    public final MaterialRadioButton e;

    @NonNull
    public final ConstraintLayout f;

    @NonNull
    public final MaterialRadioButton g;

    @NonNull
    public final ConstraintLayout h;

    @NonNull
    public final MaterialRadioButton i;

    @NonNull
    public final ConstraintLayout j;

    @NonNull
    public final MaterialRadioButton k;

    @NonNull
    public final TextView l;

    public WidgetThreadArchiveActionsSheetBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialRadioButton materialRadioButton, @NonNull ConstraintLayout constraintLayout2, @NonNull MaterialRadioButton materialRadioButton2, @NonNull ConstraintLayout constraintLayout3, @NonNull MaterialRadioButton materialRadioButton3, @NonNull ConstraintLayout constraintLayout4, @NonNull MaterialRadioButton materialRadioButton4, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.a = nestedScrollView;
        this.f2667b = textView;
        this.c = linearLayout;
        this.d = constraintLayout;
        this.e = materialRadioButton;
        this.f = constraintLayout2;
        this.g = materialRadioButton2;
        this.h = constraintLayout3;
        this.i = materialRadioButton3;
        this.j = constraintLayout4;
        this.k = materialRadioButton4;
        this.l = textView2;
    }

    @NonNull
    public static WidgetThreadArchiveActionsSheetBinding a(@NonNull View view) {
        int i = R.id.archive_now;
        TextView textView = (TextView) view.findViewById(R.id.archive_now);
        if (textView != null) {
            i = R.id.auto_archive_header;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.auto_archive_header);
            if (linearLayout != null) {
                i = R.id.auto_archive_sheet_duration_options;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.auto_archive_sheet_duration_options);
                if (linearLayout2 != null) {
                    i = R.id.option_one_hour;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.option_one_hour);
                    if (constraintLayout != null) {
                        i = R.id.option_one_hour_radio;
                        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view.findViewById(R.id.option_one_hour_radio);
                        if (materialRadioButton != null) {
                            i = R.id.option_seven_days;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.option_seven_days);
                            if (constraintLayout2 != null) {
                                i = R.id.option_seven_days_radio;
                                MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view.findViewById(R.id.option_seven_days_radio);
                                if (materialRadioButton2 != null) {
                                    i = R.id.option_three_days;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.option_three_days);
                                    if (constraintLayout3 != null) {
                                        i = R.id.option_three_days_radio;
                                        MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view.findViewById(R.id.option_three_days_radio);
                                        if (materialRadioButton3 != null) {
                                            i = R.id.option_twenty_four_hours;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.option_twenty_four_hours);
                                            if (constraintLayout4 != null) {
                                                i = R.id.option_twenty_four_hours_radio;
                                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view.findViewById(R.id.option_twenty_four_hours_radio);
                                                if (materialRadioButton4 != null) {
                                                    i = R.id.subtitle;
                                                    TextView textView2 = (TextView) view.findViewById(R.id.subtitle);
                                                    if (textView2 != null) {
                                                        i = R.id.title;
                                                        TextView textView3 = (TextView) view.findViewById(R.id.title);
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
        return this.a;
    }
}
