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
import b.a.i.ViewMobileReportBlockUserBinding;
import b.a.i.ViewMobileReportsChannelPreviewBinding;
import b.a.i.WidgetChatListAdapterItemSingleLineMessagePreviewBinding;
import com.discord.R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.mobile_reports.MobileReportsBottomButton;
import com.discord.widgets.mobile_reports.MobileReportsBreadcrumbs;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

/* JADX INFO: loaded from: classes.dex */
public final class ViewReportsMenuNodeBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewMobileReportsChannelPreviewBinding f2206b;

    @NonNull
    public final ViewMobileReportsChannelPreviewBinding c;

    @NonNull
    public final WidgetChatListAdapterItemSingleLineMessagePreviewBinding d;

    @NonNull
    public final LinearLayout e;

    @NonNull
    public final ViewMobileReportBlockUserBinding f;

    @NonNull
    public final MobileReportsBottomButton g;

    @NonNull
    public final MobileReportsBreadcrumbs h;

    @NonNull
    public final MaterialCardView i;

    @NonNull
    public final LinearLayout j;

    @NonNull
    public final MaterialCardView k;

    @NonNull
    public final TextView l;

    @NonNull
    public final TextView m;

    @NonNull
    public final MaterialCardView n;

    @NonNull
    public final TextView o;

    @NonNull
    public final LinkifiedTextView p;

    @NonNull
    public final ImageView q;

    public ViewReportsMenuNodeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding, @NonNull ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBinding2, @NonNull WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding, @NonNull LinearLayout linearLayout, @NonNull ViewMobileReportBlockUserBinding viewMobileReportBlockUserBinding, @NonNull MobileReportsBottomButton mobileReportsBottomButton, @NonNull MobileReportsBreadcrumbs mobileReportsBreadcrumbs, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout2, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView3, @NonNull TextView textView3, @NonNull MaterialCardView materialCardView4, @NonNull LinkifiedTextView linkifiedTextView, @NonNull ImageView imageView) {
        this.a = constraintLayout;
        this.f2206b = viewMobileReportsChannelPreviewBinding;
        this.c = viewMobileReportsChannelPreviewBinding2;
        this.d = widgetChatListAdapterItemSingleLineMessagePreviewBinding;
        this.e = linearLayout;
        this.f = viewMobileReportBlockUserBinding;
        this.g = mobileReportsBottomButton;
        this.h = mobileReportsBreadcrumbs;
        this.i = materialCardView;
        this.j = linearLayout2;
        this.k = materialCardView2;
        this.l = textView;
        this.m = textView2;
        this.n = materialCardView3;
        this.o = textView3;
        this.p = linkifiedTextView;
        this.q = imageView;
    }

    @NonNull
    public static ViewReportsMenuNodeBinding a(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.view_reports_menu_node, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        View viewFindViewById = viewInflate.findViewById(R.id.mobile_reports_channel_preview);
        int i = R.id.mobile_reports_node_header;
        if (viewFindViewById != null) {
            ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBindingA = ViewMobileReportsChannelPreviewBinding.a(viewFindViewById);
            View viewFindViewById2 = viewInflate.findViewById(R.id.mobile_reports_directory_channel_preview);
            if (viewFindViewById2 != null) {
                ViewMobileReportsChannelPreviewBinding viewMobileReportsChannelPreviewBindingA2 = ViewMobileReportsChannelPreviewBinding.a(viewFindViewById2);
                View viewFindViewById3 = viewInflate.findViewById(R.id.mobile_reports_message_preview);
                if (viewFindViewById3 != null) {
                    int i2 = R.id.chat_list_adapter_item_chat_attachment_icon;
                    ImageView imageView = (ImageView) viewFindViewById3.findViewById(R.id.chat_list_adapter_item_chat_attachment_icon);
                    if (imageView != null) {
                        i2 = R.id.chat_list_adapter_item_text;
                        LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewFindViewById3.findViewById(R.id.chat_list_adapter_item_text);
                        if (linkifiedTextView != null) {
                            i2 = R.id.chat_list_adapter_item_text_avatar;
                            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewFindViewById3.findViewById(R.id.chat_list_adapter_item_text_avatar);
                            if (simpleDraweeView != null) {
                                i2 = R.id.chat_list_adapter_item_text_name;
                                TextView textView = (TextView) viewFindViewById3.findViewById(R.id.chat_list_adapter_item_text_name);
                                if (textView != null) {
                                    i2 = R.id.report_message_end_guideline;
                                    Guideline guideline = (Guideline) viewFindViewById3.findViewById(R.id.report_message_end_guideline);
                                    if (guideline != null) {
                                        i2 = R.id.report_message_start_guideline;
                                        Guideline guideline2 = (Guideline) viewFindViewById3.findViewById(R.id.report_message_start_guideline);
                                        if (guideline2 != null) {
                                            i2 = R.id.report_message_top_guideline;
                                            Guideline guideline3 = (Guideline) viewFindViewById3.findViewById(R.id.report_message_top_guideline);
                                            if (guideline3 != null) {
                                                WidgetChatListAdapterItemSingleLineMessagePreviewBinding widgetChatListAdapterItemSingleLineMessagePreviewBinding = new WidgetChatListAdapterItemSingleLineMessagePreviewBinding((ConstraintLayout) viewFindViewById3, imageView, linkifiedTextView, simpleDraweeView, textView, guideline, guideline2, guideline3);
                                                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.mobile_reports_multiselect);
                                                if (linearLayout != null) {
                                                    View viewFindViewById4 = viewInflate.findViewById(R.id.mobile_reports_node_block_user);
                                                    if (viewFindViewById4 != null) {
                                                        int i3 = R.id.mobile_reports_block_user_avatar;
                                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewFindViewById4.findViewById(R.id.mobile_reports_block_user_avatar);
                                                        if (simpleDraweeView2 != null) {
                                                            i3 = R.id.mobile_reports_block_user_button;
                                                            MaterialButton materialButton = (MaterialButton) viewFindViewById4.findViewById(R.id.mobile_reports_block_user_button);
                                                            if (materialButton != null) {
                                                                i3 = R.id.mobile_reports_block_user_description;
                                                                TextView textView2 = (TextView) viewFindViewById4.findViewById(R.id.mobile_reports_block_user_description);
                                                                if (textView2 != null) {
                                                                    i3 = R.id.mobile_reports_block_user_header;
                                                                    TextView textView3 = (TextView) viewFindViewById4.findViewById(R.id.mobile_reports_block_user_header);
                                                                    if (textView3 != null) {
                                                                        i3 = R.id.mobile_reports_block_user_name;
                                                                        TextView textView4 = (TextView) viewFindViewById4.findViewById(R.id.mobile_reports_block_user_name);
                                                                        if (textView4 != null) {
                                                                            ViewMobileReportBlockUserBinding viewMobileReportBlockUserBinding = new ViewMobileReportBlockUserBinding((LinearLayout) viewFindViewById4, simpleDraweeView2, materialButton, textView2, textView3, textView4);
                                                                            MobileReportsBottomButton mobileReportsBottomButton = (MobileReportsBottomButton) viewInflate.findViewById(R.id.mobile_reports_node_bottom_button);
                                                                            if (mobileReportsBottomButton != null) {
                                                                                MobileReportsBreadcrumbs mobileReportsBreadcrumbs = (MobileReportsBreadcrumbs) viewInflate.findViewById(R.id.mobile_reports_node_breadcrumbs);
                                                                                if (mobileReportsBreadcrumbs != null) {
                                                                                    MaterialCardView materialCardView = (MaterialCardView) viewInflate.findViewById(R.id.mobile_reports_node_channel_preview);
                                                                                    if (materialCardView != null) {
                                                                                        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.mobile_reports_node_child_list);
                                                                                        if (linearLayout2 != null) {
                                                                                            MaterialCardView materialCardView2 = (MaterialCardView) viewInflate.findViewById(R.id.mobile_reports_node_directory_channel_preview);
                                                                                            if (materialCardView2 != null) {
                                                                                                TextView textView5 = (TextView) viewInflate.findViewById(R.id.mobile_reports_node_directory_channel_preview_title);
                                                                                                if (textView5 != null) {
                                                                                                    TextView textView6 = (TextView) viewInflate.findViewById(R.id.mobile_reports_node_header);
                                                                                                    if (textView6 != null) {
                                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) viewInflate.findViewById(R.id.mobile_reports_node_info_box);
                                                                                                        if (materialCardView3 != null) {
                                                                                                            i = R.id.mobile_reports_node_info_text;
                                                                                                            TextView textView7 = (TextView) viewInflate.findViewById(R.id.mobile_reports_node_info_text);
                                                                                                            if (textView7 != null) {
                                                                                                                MaterialCardView materialCardView4 = (MaterialCardView) viewInflate.findViewById(R.id.mobile_reports_node_message_preview);
                                                                                                                if (materialCardView4 != null) {
                                                                                                                    i = R.id.mobile_reports_node_subheader;
                                                                                                                    LinkifiedTextView linkifiedTextView2 = (LinkifiedTextView) viewInflate.findViewById(R.id.mobile_reports_node_subheader);
                                                                                                                    if (linkifiedTextView2 != null) {
                                                                                                                        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.mobile_reports_node_success_shield);
                                                                                                                        if (imageView2 != null) {
                                                                                                                            return new ViewReportsMenuNodeBinding((ConstraintLayout) viewInflate, viewMobileReportsChannelPreviewBindingA, viewMobileReportsChannelPreviewBindingA2, widgetChatListAdapterItemSingleLineMessagePreviewBinding, linearLayout, viewMobileReportBlockUserBinding, mobileReportsBottomButton, mobileReportsBreadcrumbs, materialCardView, linearLayout2, materialCardView2, textView5, textView6, materialCardView3, textView7, materialCardView4, linkifiedTextView2, imageView2);
                                                                                                                        }
                                                                                                                        i = R.id.mobile_reports_node_success_shield;
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    i = R.id.mobile_reports_node_message_preview;
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            i = R.id.mobile_reports_node_info_box;
                                                                                                        }
                                                                                                    }
                                                                                                } else {
                                                                                                    i = R.id.mobile_reports_node_directory_channel_preview_title;
                                                                                                }
                                                                                            } else {
                                                                                                i = R.id.mobile_reports_node_directory_channel_preview;
                                                                                            }
                                                                                        } else {
                                                                                            i = R.id.mobile_reports_node_child_list;
                                                                                        }
                                                                                    } else {
                                                                                        i = R.id.mobile_reports_node_channel_preview;
                                                                                    }
                                                                                } else {
                                                                                    i = R.id.mobile_reports_node_breadcrumbs;
                                                                                }
                                                                            } else {
                                                                                i = R.id.mobile_reports_node_bottom_button;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById4.getResources().getResourceName(i3)));
                                                    }
                                                    i = R.id.mobile_reports_node_block_user;
                                                } else {
                                                    i = R.id.mobile_reports_multiselect;
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
                i = R.id.mobile_reports_message_preview;
            } else {
                i = R.id.mobile_reports_directory_channel_preview;
            }
        } else {
            i = R.id.mobile_reports_channel_preview;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
