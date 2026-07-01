package com.discord.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemTextBinding implements ViewBinding {

    @NonNull
    public final ConstraintLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinkifiedTextView f2338b;

    @NonNull
    public final SimpleDraweeView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RoleIconView e;

    @NonNull
    public final TextView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final ConstraintLayout h;

    public WidgetChatListAdapterItemTextBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull View view2, @NonNull LinearLayout linearLayout, @NonNull View view3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull RoleIconView roleIconView, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull AppCompatImageView appCompatImageView, @NonNull TypingDots typingDots, @NonNull ConstraintLayout constraintLayout3, @NonNull ImageView imageView4, @NonNull TextView textView6, @NonNull Guideline guideline, @NonNull ConstraintLayout constraintLayout4) {
        this.a = constraintLayout;
        this.f2338b = linkifiedTextView;
        this.c = simpleDraweeView;
        this.d = textView3;
        this.e = roleIconView;
        this.f = textView4;
        this.g = textView5;
        this.h = constraintLayout4;
    }

    @NonNull
    public static WidgetChatListAdapterItemTextBinding a(@NonNull View view) {
        int i = R$id.chat_list_adapter_item_communication_disabled_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_adapter_item_communication_disabled_icon);
        if (imageView != null) {
            i = R$id.chat_list_adapter_item_gutter_bg;
            View viewFindViewById = view.findViewById(R$id.chat_list_adapter_item_gutter_bg);
            if (viewFindViewById != null) {
                i = R$id.chat_list_adapter_item_highlighted_bg;
                View viewFindViewById2 = view.findViewById(R$id.chat_list_adapter_item_highlighted_bg);
                if (viewFindViewById2 != null) {
                    i = R$id.chat_list_adapter_item_reply_leading_views;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.chat_list_adapter_item_reply_leading_views);
                    if (linearLayout != null) {
                        i = R$id.chat_list_adapter_item_selectable_background;
                        View viewFindViewById3 = view.findViewById(R$id.chat_list_adapter_item_selectable_background);
                        if (viewFindViewById3 != null) {
                            i = R$id.chat_list_adapter_item_text;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.chat_list_adapter_item_text);
                            if (linkifiedTextView != null) {
                                i = R$id.chat_list_adapter_item_text_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.chat_list_adapter_item_text_avatar);
                                if (simpleDraweeView != null) {
                                    i = R$id.chat_list_adapter_item_text_decorator;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.chat_list_adapter_item_text_decorator);
                                    if (frameLayout != null) {
                                        i = R$id.chat_list_adapter_item_text_decorator_avatar;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.chat_list_adapter_item_text_decorator_avatar);
                                        if (simpleDraweeView2 != null) {
                                            i = R$id.chat_list_adapter_item_text_decorator_reply_icon;
                                            ImageView imageView2 = (ImageView) view.findViewById(R$id.chat_list_adapter_item_text_decorator_reply_icon);
                                            if (imageView2 != null) {
                                                i = R$id.chat_list_adapter_item_text_decorator_reply_link_icon;
                                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R$id.chat_list_adapter_item_text_decorator_reply_link_icon);
                                                if (frameLayout2 != null) {
                                                    i = R$id.chat_list_adapter_item_text_decorator_reply_name;
                                                    TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_decorator_reply_name);
                                                    if (textView != null) {
                                                        i = R$id.chat_list_adapter_item_text_error;
                                                        ImageView imageView3 = (ImageView) view.findViewById(R$id.chat_list_adapter_item_text_error);
                                                        if (imageView3 != null) {
                                                            i = R$id.chat_list_adapter_item_text_header;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.chat_list_adapter_item_text_header);
                                                            if (constraintLayout != null) {
                                                                i = R$id.chat_list_adapter_item_text_loading;
                                                                TextView textView2 = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_loading);
                                                                if (textView2 != null) {
                                                                    i = R$id.chat_list_adapter_item_text_name;
                                                                    TextView textView3 = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_name);
                                                                    if (textView3 != null) {
                                                                        i = R$id.chat_list_adapter_item_text_reply_content;
                                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R$id.chat_list_adapter_item_text_reply_content);
                                                                        if (simpleDraweeSpanTextView != null) {
                                                                            i = R$id.chat_list_adapter_item_text_role_icon;
                                                                            RoleIconView roleIconView = (RoleIconView) view.findViewById(R$id.chat_list_adapter_item_text_role_icon);
                                                                            if (roleIconView != null) {
                                                                                i = R$id.chat_list_adapter_item_text_tag;
                                                                                TextView textView4 = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_tag);
                                                                                if (textView4 != null) {
                                                                                    i = R$id.chat_list_adapter_item_text_timestamp;
                                                                                    TextView textView5 = (TextView) view.findViewById(R$id.chat_list_adapter_item_text_timestamp);
                                                                                    if (textView5 != null) {
                                                                                        i = R$id.chat_list_adapter_item_thread_embed_spine;
                                                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.chat_list_adapter_item_thread_embed_spine);
                                                                                        if (appCompatImageView != null) {
                                                                                            i = R$id.chat_overlay_typing_dots;
                                                                                            TypingDots typingDots = (TypingDots) view.findViewById(R$id.chat_overlay_typing_dots);
                                                                                            if (typingDots != null) {
                                                                                                i = R$id.thread_starter_message_header;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R$id.thread_starter_message_header);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i = R$id.thread_starter_message_header_icon;
                                                                                                    ImageView imageView4 = (ImageView) view.findViewById(R$id.thread_starter_message_header_icon);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = R$id.thread_starter_message_header_text;
                                                                                                        TextView textView6 = (TextView) view.findViewById(R$id.thread_starter_message_header_text);
                                                                                                        if (textView6 != null) {
                                                                                                            i = 2131365922;
                                                                                                            Guideline guideline = (Guideline) view.findViewById(2131365922);
                                                                                                            if (guideline != null) {
                                                                                                                ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                                                                                                return new WidgetChatListAdapterItemTextBinding(constraintLayout3, imageView, viewFindViewById, viewFindViewById2, linearLayout, viewFindViewById3, linkifiedTextView, simpleDraweeView, frameLayout, simpleDraweeView2, imageView2, frameLayout2, textView, imageView3, constraintLayout, textView2, textView3, simpleDraweeSpanTextView, roleIconView, textView4, textView5, appCompatImageView, typingDots, constraintLayout2, imageView4, textView6, guideline, constraintLayout3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static WidgetChatListAdapterItemTextBinding b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R$layout.widget_chat_list_adapter_item_text, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
