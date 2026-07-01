package com.discord.widgets.bugreports;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetBugReportBinding;
import com.discord.views.SearchInputView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetBugReport$binding$2 extends FunctionReferenceImpl implements Function1<View, WidgetBugReportBinding> {
    public static final WidgetBugReport$binding$2 INSTANCE = new WidgetBugReport$binding$2();

    public WidgetBugReport$binding$2() {
        super(1, WidgetBugReportBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetBugReportBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetBugReportBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.bug_report_clear_screenshot;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.bug_report_clear_screenshot);
        if (appCompatImageView != null) {
            i = R.id.bug_report_description;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.bug_report_description);
            if (textInputLayout != null) {
                i = R.id.bug_report_feature_area;
                TextInputLayout textInputLayout2 = (TextInputLayout) view.findViewById(R.id.bug_report_feature_area);
                if (textInputLayout2 != null) {
                    i = R.id.bug_report_feature_area_card;
                    MaterialCardView materialCardView = (MaterialCardView) view.findViewById(R.id.bug_report_feature_area_card);
                    if (materialCardView != null) {
                        i = R.id.bug_report_feature_area_chevron;
                        ImageView imageView = (ImageView) view.findViewById(R.id.bug_report_feature_area_chevron);
                        if (imageView != null) {
                            i = R.id.bug_report_feature_loader;
                            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.bug_report_feature_loader);
                            if (progressBar != null) {
                                i = R.id.bug_report_feature_recycler;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bug_report_feature_recycler);
                                if (recyclerView != null) {
                                    i = R.id.bug_report_feature_search;
                                    SearchInputView searchInputView = (SearchInputView) view.findViewById(R.id.bug_report_feature_search);
                                    if (searchInputView != null) {
                                        i = R.id.bug_report_name;
                                        TextInputLayout textInputLayout3 = (TextInputLayout) view.findViewById(R.id.bug_report_name);
                                        if (textInputLayout3 != null) {
                                            i = R.id.bug_report_no_screenshot_label;
                                            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.bug_report_no_screenshot_label);
                                            if (materialTextView != null) {
                                                i = R.id.bug_report_priority;
                                                TextInputLayout textInputLayout4 = (TextInputLayout) view.findViewById(R.id.bug_report_priority);
                                                if (textInputLayout4 != null) {
                                                    i = R.id.bug_report_priority_card;
                                                    MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(R.id.bug_report_priority_card);
                                                    if (materialCardView2 != null) {
                                                        i = R.id.bug_report_priority_icon;
                                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.bug_report_priority_icon);
                                                        if (simpleDraweeView != null) {
                                                            i = R.id.bug_report_screenshot;
                                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.bug_report_screenshot);
                                                            if (appCompatImageView2 != null) {
                                                                i = R.id.bug_report_select_component_chevron;
                                                                ImageView imageView2 = (ImageView) view.findViewById(R.id.bug_report_select_component_chevron);
                                                                if (imageView2 != null) {
                                                                    i = R.id.bug_report_status_expression;
                                                                    StickerView stickerView = (StickerView) view.findViewById(R.id.bug_report_status_expression);
                                                                    if (stickerView != null) {
                                                                        i = R.id.bug_report_status_text;
                                                                        MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.bug_report_status_text);
                                                                        if (materialTextView2 != null) {
                                                                            i = R.id.bug_report_submit;
                                                                            MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.bug_report_submit);
                                                                            if (materialButton != null) {
                                                                                i = R.id.bug_report_switch_flipper;
                                                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.bug_report_switch_flipper);
                                                                                if (appViewFlipper != null) {
                                                                                    i = R.id.bug_report_undo_screenshot_remove;
                                                                                    MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.bug_report_undo_screenshot_remove);
                                                                                    if (materialButton2 != null) {
                                                                                        i = R.id.submit_report_error;
                                                                                        MaterialTextView materialTextView3 = (MaterialTextView) view.findViewById(R.id.submit_report_error);
                                                                                        if (materialTextView3 != null) {
                                                                                            i = R.id.widget_bug_report_feature_touch_delegate;
                                                                                            View viewFindViewById = view.findViewById(R.id.widget_bug_report_feature_touch_delegate);
                                                                                            if (viewFindViewById != null) {
                                                                                                i = R.id.widget_bug_report_severity_touch_delegate;
                                                                                                View viewFindViewById2 = view.findViewById(R.id.widget_bug_report_severity_touch_delegate);
                                                                                                if (viewFindViewById2 != null) {
                                                                                                    return new WidgetBugReportBinding((LinearLayoutCompat) view, appCompatImageView, textInputLayout, textInputLayout2, materialCardView, imageView, progressBar, recyclerView, searchInputView, textInputLayout3, materialTextView, textInputLayout4, materialCardView2, simpleDraweeView, appCompatImageView2, imageView2, stickerView, materialTextView2, materialButton, appViewFlipper, materialButton2, materialTextView3, viewFindViewById, viewFindViewById2);
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
}
