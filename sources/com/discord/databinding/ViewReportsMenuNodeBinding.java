package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.mobile_reports.MobileReportsBottomButton;
import com.discord.widgets.mobile_reports.MobileReportsBreadcrumbs;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import p007b.p008a.p025i.C1019o2;
import p007b.p008a.p025i.C1026p2;
import p007b.p008a.p025i.C1098z4;

/* JADX INFO: loaded from: classes.dex */
public final class ViewReportsMenuNodeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f15529a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final C1026p2 f15530b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C1026p2 f15531c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final C1098z4 f15532d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final LinearLayout f15533e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final C1019o2 f15534f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final MobileReportsBottomButton f15535g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final MobileReportsBreadcrumbs f15536h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final MaterialCardView f15537i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final LinearLayout f15538j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final MaterialCardView f15539k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final TextView f15540l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final TextView f15541m;

    /* JADX INFO: renamed from: n */
    @NonNull
    public final MaterialCardView f15542n;

    /* JADX INFO: renamed from: o */
    @NonNull
    public final TextView f15543o;

    /* JADX INFO: renamed from: p */
    @NonNull
    public final LinkifiedTextView f15544p;

    /* JADX INFO: renamed from: q */
    @NonNull
    public final ImageView f15545q;

    public ViewReportsMenuNodeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull C1026p2 c1026p2, @NonNull C1026p2 c1026p3, @NonNull C1098z4 c1098z4, @NonNull LinearLayout linearLayout, @NonNull C1019o2 c1019o2, @NonNull MobileReportsBottomButton mobileReportsBottomButton, @NonNull MobileReportsBreadcrumbs mobileReportsBreadcrumbs, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout2, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView3, @NonNull TextView textView3, @NonNull MaterialCardView materialCardView4, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView) {
        this.f15529a = constraintLayout;
        this.f15530b = c1026p2;
        this.f15531c = c1026p3;
        this.f15532d = c1098z4;
        this.f15533e = linearLayout;
        this.f15534f = c1019o2;
        this.f15535g = mobileReportsBottomButton;
        this.f15536h = mobileReportsBreadcrumbs;
        this.f15537i = materialCardView;
        this.f15538j = linearLayout2;
        this.f15539k = materialCardView2;
        this.f15540l = textView;
        this.f15541m = textView2;
        this.f15542n = materialCardView3;
        this.f15543o = textView3;
        this.f15544p = linkifiedTextView;
        this.f15545q = imageView;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static ViewReportsMenuNodeBinding m8401a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.view_reports_menu_node, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        View viewFindViewById = viewInflate.findViewById(C5419R.id.mobile_reports_channel_preview);
        int i = C5419R.id.mobile_reports_node_header;
        if (viewFindViewById != null) {
            C1026p2 c1026p2M203a = C1026p2.m203a(viewFindViewById);
            View viewFindViewById2 = viewInflate.findViewById(C5419R.id.mobile_reports_directory_channel_preview);
            if (viewFindViewById2 != null) {
                C1026p2 c1026p2M203a2 = C1026p2.m203a(viewFindViewById2);
                View viewFindViewById3 = viewInflate.findViewById(C5419R.id.mobile_reports_message_preview);
                if (viewFindViewById3 != null) {
                    int i2 = C5419R.id.chat_list_adapter_item_chat_attachment_icon;
                    ImageView imageView = (ImageView) viewFindViewById3.findViewById(C5419R.id.chat_list_adapter_item_chat_attachment_icon);
                    if (imageView != null) {
                        i2 = C5419R.id.chat_list_adapter_item_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById3.findViewById(C5419R.id.chat_list_adapter_item_text);
                        if (linkifiedTextView != null) {
                            i2 = C5419R.id.chat_list_adapter_item_text_avatar;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewFindViewById3.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
                            if (simpleDraweeView != null) {
                                i2 = C5419R.id.chat_list_adapter_item_text_name;
                                TextView textView = (TextView) viewFindViewById3.findViewById(C5419R.id.chat_list_adapter_item_text_name);
                                if (textView != null) {
                                    i2 = C5419R.id.report_message_end_guideline;
                                    Guideline guideline = (Guideline) viewFindViewById3.findViewById(C5419R.id.report_message_end_guideline);
                                    if (guideline != null) {
                                        i2 = C5419R.id.report_message_start_guideline;
                                        Guideline guideline2 = (Guideline) viewFindViewById3.findViewById(C5419R.id.report_message_start_guideline);
                                        if (guideline2 != null) {
                                            i2 = C5419R.id.report_message_top_guideline;
                                            Guideline guideline3 = (Guideline) viewFindViewById3.findViewById(C5419R.id.report_message_top_guideline);
                                            if (guideline3 != null) {
                                                C1098z4 c1098z4 = new C1098z4((ConstraintLayout) viewFindViewById3, imageView, linkifiedTextView, simpleDraweeView, textView, guideline, guideline2, guideline3);
                                                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.mobile_reports_multiselect);
                                                if (linearLayout != null) {
                                                    View viewFindViewById4 = viewInflate.findViewById(C5419R.id.mobile_reports_node_block_user);
                                                    if (viewFindViewById4 != null) {
                                                        int i3 = C5419R.id.mobile_reports_block_user_avatar;
                                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewFindViewById4.findViewById(C5419R.id.mobile_reports_block_user_avatar);
                                                        if (simpleDraweeView2 != null) {
                                                            i3 = C5419R.id.mobile_reports_block_user_button;
                                                            MaterialButton materialButton = (MaterialButton) viewFindViewById4.findViewById(C5419R.id.mobile_reports_block_user_button);
                                                            if (materialButton != null) {
                                                                i3 = C5419R.id.mobile_reports_block_user_description;
                                                                TextView textView2 = (TextView) viewFindViewById4.findViewById(C5419R.id.mobile_reports_block_user_description);
                                                                if (textView2 != null) {
                                                                    i3 = C5419R.id.mobile_reports_block_user_header;
                                                                    TextView textView3 = (TextView) viewFindViewById4.findViewById(C5419R.id.mobile_reports_block_user_header);
                                                                    if (textView3 != null) {
                                                                        i3 = C5419R.id.mobile_reports_block_user_name;
                                                                        TextView textView4 = (TextView) viewFindViewById4.findViewById(C5419R.id.mobile_reports_block_user_name);
                                                                        if (textView4 != null) {
                                                                            C1019o2 c1019o2 = new C1019o2((LinearLayout) viewFindViewById4, simpleDraweeView2, materialButton, textView2, textView3, textView4);
                                                                            MobileReportsBottomButton mobileReportsBottomButton = (MobileReportsBottomButton) viewInflate.findViewById(C5419R.id.mobile_reports_node_bottom_button);
                                                                            if (mobileReportsBottomButton != null) {
                                                                                MobileReportsBreadcrumbs mobileReportsBreadcrumbs = (MobileReportsBreadcrumbs) viewInflate.findViewById(C5419R.id.mobile_reports_node_breadcrumbs);
                                                                                if (mobileReportsBreadcrumbs != null) {
                                                                                    MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(C5419R.id.mobile_reports_node_channel_preview);
                                                                                    if (materialCardView != null) {
                                                                                        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(C5419R.id.mobile_reports_node_child_list);
                                                                                        if (linearLayout2 != null) {
                                                                                            MaterialCardView materialCardView2 = (MaterialCardView) viewInflate.findViewById(C5419R.id.mobile_reports_node_directory_channel_preview);
                                                                                            if (materialCardView2 != null) {
                                                                                                TextView textView5 = (TextView) viewInflate.findViewById(C5419R.id.mobile_reports_node_directory_channel_preview_title);
                                                                                                if (textView5 != null) {
                                                                                                    TextView textView6 = (TextView) viewInflate.findViewById(C5419R.id.mobile_reports_node_header);
                                                                                                    if (textView6 != null) {
                                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) viewInflate.findViewById(C5419R.id.mobile_reports_node_info_box);
                                                                                                        if (materialCardView3 != null) {
                                                                                                            i = C5419R.id.mobile_reports_node_info_text;
                                                                                                            TextView textView7 = (TextView) viewInflate.findViewById(C5419R.id.mobile_reports_node_info_text);
                                                                                                            if (textView7 != null) {
                                                                                                                MaterialCardView materialCardView4 = (MaterialCardView) viewInflate.findViewById(C5419R.id.mobile_reports_node_message_preview);
                                                                                                                if (materialCardView4 != null) {
                                                                                                                    i = C5419R.id.mobile_reports_node_subheader;
                                                                                                                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.mobile_reports_node_subheader);
                                                                                                                    if (linkifiedTextView2 != null) {
                                                                                                                        ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.mobile_reports_node_success_shield);
                                                                                                                        if (imageView2 != null) {
                                                                                                                            return new ViewReportsMenuNodeBinding((ConstraintLayout) viewInflate, c1026p2M203a, c1026p2M203a2, c1098z4, linearLayout, c1019o2, mobileReportsBottomButton, mobileReportsBreadcrumbs, materialCardView, linearLayout2, materialCardView2, textView5, textView6, materialCardView3, textView7, materialCardView4, linkifiedTextView2, imageView2);
                                                                                                                        }
                                                                                                                        i = C5419R.id.mobile_reports_node_success_shield;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i = C5419R.id.mobile_reports_node_message_preview;
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            i = C5419R.id.mobile_reports_node_info_box;
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    i = C5419R.id.mobile_reports_node_directory_channel_preview_title;
                                                                                                }
                                                                                            } else {
                                                                                                i = C5419R.id.mobile_reports_node_directory_channel_preview;
                                                                                            }
                                                                                        } else {
                                                                                            i = C5419R.id.mobile_reports_node_child_list;
                                                                                        }
                                                                                    } else {
                                                                                        i = C5419R.id.mobile_reports_node_channel_preview;
                                                                                    }
                                                                                } else {
                                                                                    i = C5419R.id.mobile_reports_node_breadcrumbs;
                                                                                }
                                                                            } else {
                                                                                i = C5419R.id.mobile_reports_node_bottom_button;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById4.getResources().getResourceName(i3)));
                                                    }
                                                    i = C5419R.id.mobile_reports_node_block_user;
                                                } else {
                                                    i = C5419R.id.mobile_reports_multiselect;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById3.getResources().getResourceName(i2)));
                }
                i = C5419R.id.mobile_reports_message_preview;
            } else {
                i = C5419R.id.mobile_reports_directory_channel_preview;
            }
        } else {
            i = C5419R.id.mobile_reports_channel_preview;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15529a;
    }
}
