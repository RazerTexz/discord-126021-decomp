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
import com.discord.C5419R;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.typing.TypingDots;
import com.discord.widgets.roles.RoleIconView;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetChatListAdapterItemTextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16317a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LinkifiedTextView f16318b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final SimpleDraweeView f16319c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f16320d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RoleIconView f16321e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextView f16322f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16323g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final ConstraintLayout f16324h;

    public WidgetChatListAdapterItemTextBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull View view2, @NonNull LinearLayout linearLayout, @NonNull View view3, @NonNull LinkifiedTextView linkifiedTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout2, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull RoleIconView roleIconView, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull AppCompatImageView appCompatImageView, @NonNull TypingDots typingDots, @NonNull ConstraintLayout constraintLayout3, @NonNull ImageView imageView4, @NonNull TextView textView6, @NonNull Guideline guideline, @NonNull ConstraintLayout constraintLayout4) {
        this.f16317a = constraintLayout;
        this.f16318b = linkifiedTextView;
        this.f16319c = simpleDraweeView;
        this.f16320d = textView3;
        this.f16321e = roleIconView;
        this.f16322f = textView4;
        this.f16323g = textView5;
        this.f16324h = constraintLayout4;
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static WidgetChatListAdapterItemTextBinding m8408a(@NonNull View view) {
        int i = C5419R.id.chat_list_adapter_item_communication_disabled_icon;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_communication_disabled_icon);
        if (imageView != null) {
            i = C5419R.id.chat_list_adapter_item_gutter_bg;
            View viewFindViewById = view.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
            if (viewFindViewById != null) {
                i = C5419R.id.chat_list_adapter_item_highlighted_bg;
                View viewFindViewById2 = view.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
                if (viewFindViewById2 != null) {
                    i = C5419R.id.chat_list_adapter_item_reply_leading_views;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.chat_list_adapter_item_reply_leading_views);
                    if (linearLayout != null) {
                        i = C5419R.id.chat_list_adapter_item_selectable_background;
                        View viewFindViewById3 = view.findViewById(C5419R.id.chat_list_adapter_item_selectable_background);
                        if (viewFindViewById3 != null) {
                            i = C5419R.id.chat_list_adapter_item_text;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.chat_list_adapter_item_text);
                            if (linkifiedTextView != null) {
                                i = C5419R.id.chat_list_adapter_item_text_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_adapter_item_text_avatar);
                                if (simpleDraweeView != null) {
                                    i = C5419R.id.chat_list_adapter_item_text_decorator;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator);
                                    if (frameLayout != null) {
                                        i = C5419R.id.chat_list_adapter_item_text_decorator_avatar;
                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_avatar);
                                        if (simpleDraweeView2 != null) {
                                            i = C5419R.id.chat_list_adapter_item_text_decorator_reply_icon;
                                            ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_icon);
                                            if (imageView2 != null) {
                                                i = C5419R.id.chat_list_adapter_item_text_decorator_reply_link_icon;
                                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_link_icon);
                                                if (frameLayout2 != null) {
                                                    i = C5419R.id.chat_list_adapter_item_text_decorator_reply_name;
                                                    TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_decorator_reply_name);
                                                    if (textView != null) {
                                                        i = C5419R.id.chat_list_adapter_item_text_error;
                                                        ImageView imageView3 = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_item_text_error);
                                                        if (imageView3 != null) {
                                                            i = C5419R.id.chat_list_adapter_item_text_header;
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.chat_list_adapter_item_text_header);
                                                            if (constraintLayout != null) {
                                                                i = C5419R.id.chat_list_adapter_item_text_loading;
                                                                TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_loading);
                                                                if (textView2 != null) {
                                                                    i = C5419R.id.chat_list_adapter_item_text_name;
                                                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_name);
                                                                    if (textView3 != null) {
                                                                        i = C5419R.id.chat_list_adapter_item_text_reply_content;
                                                                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_reply_content);
                                                                        if (simpleDraweeSpanTextView != null) {
                                                                            i = C5419R.id.chat_list_adapter_item_text_role_icon;
                                                                            RoleIconView roleIconView = (RoleIconView) view.findViewById(C5419R.id.chat_list_adapter_item_text_role_icon);
                                                                            if (roleIconView != null) {
                                                                                i = C5419R.id.chat_list_adapter_item_text_tag;
                                                                                TextView textView4 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_tag);
                                                                                if (textView4 != null) {
                                                                                    i = C5419R.id.chat_list_adapter_item_text_timestamp;
                                                                                    TextView textView5 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_text_timestamp);
                                                                                    if (textView5 != null) {
                                                                                        i = C5419R.id.chat_list_adapter_item_thread_embed_spine;
                                                                                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.chat_list_adapter_item_thread_embed_spine);
                                                                                        if (appCompatImageView != null) {
                                                                                            i = C5419R.id.chat_overlay_typing_dots;
                                                                                            TypingDots typingDots = (TypingDots) view.findViewById(C5419R.id.chat_overlay_typing_dots);
                                                                                            if (typingDots != null) {
                                                                                                i = C5419R.id.thread_starter_message_header;
                                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.thread_starter_message_header);
                                                                                                if (constraintLayout2 != null) {
                                                                                                    i = C5419R.id.thread_starter_message_header_icon;
                                                                                                    ImageView imageView4 = (ImageView) view.findViewById(C5419R.id.thread_starter_message_header_icon);
                                                                                                    if (imageView4 != null) {
                                                                                                        i = C5419R.id.thread_starter_message_header_text;
                                                                                                        TextView textView6 = (TextView) view.findViewById(C5419R.id.thread_starter_message_header_text);
                                                                                                        if (textView6 != null) {
                                                                                                            i = C5419R.id.uikit_chat_guideline;
                                                                                                            Guideline guideline = (Guideline) view.findViewById(C5419R.id.uikit_chat_guideline);
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
    /* JADX INFO: renamed from: b */
    public static WidgetChatListAdapterItemTextBinding m8409b(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(C5419R.layout.widget_chat_list_adapter_item_text, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return m8408a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16317a;
    }
}
