package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareSheetBinding;
import com.discord.views.SearchInputView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShareSheet$binding$2 extends k implements Function1<View, WidgetGuildInviteShareSheetBinding> {
    public static final WidgetGuildInviteShareSheet$binding$2 INSTANCE = new WidgetGuildInviteShareSheet$binding$2();

    public WidgetGuildInviteShareSheet$binding$2() {
        super(1, WidgetGuildInviteShareSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.copy_link_group;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.copy_link_group);
        if (constraintLayout != null) {
            i = R$id.copy_link_icon;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.copy_link_icon);
            if (frameLayout != null) {
                i = R$id.copy_link_icon_barrier;
                Barrier barrier = (Barrier) view.findViewById(R$id.copy_link_icon_barrier);
                if (barrier != null) {
                    i = R$id.copy_link_subtitle;
                    TextView textView = (TextView) view.findViewById(R$id.copy_link_subtitle);
                    if (textView != null) {
                        i = R$id.copy_link_title;
                        TextView textView2 = (TextView) view.findViewById(R$id.copy_link_title);
                        if (textView2 != null) {
                            i = R$id.empty_state_body;
                            TextView textView3 = (TextView) view.findViewById(R$id.empty_state_body);
                            if (textView3 != null) {
                                i = R$id.empty_state_img;
                                ImageView imageView = (ImageView) view.findViewById(R$id.empty_state_img);
                                if (imageView != null) {
                                    i = R$id.empty_state_invite_link;
                                    TextView textView4 = (TextView) view.findViewById(R$id.empty_state_invite_link);
                                    if (textView4 != null) {
                                        i = R$id.empty_state_link_options;
                                        ImageButton imageButton = (ImageButton) view.findViewById(R$id.empty_state_link_options);
                                        if (imageButton != null) {
                                            i = R$id.empty_state_scroller;
                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.empty_state_scroller);
                                            if (nestedScrollView != null) {
                                                i = R$id.empty_state_settings_subtext;
                                                TextView textView5 = (TextView) view.findViewById(R$id.empty_state_settings_subtext);
                                                if (textView5 != null) {
                                                    i = R$id.empty_state_share_btn;
                                                    MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.empty_state_share_btn);
                                                    if (materialButton != null) {
                                                        i = R$id.empty_state_title;
                                                        TextView textView6 = (TextView) view.findViewById(R$id.empty_state_title);
                                                        if (textView6 != null) {
                                                            i = R$id.invite_settings_button;
                                                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R$id.invite_settings_button);
                                                            if (frameLayout2 != null) {
                                                                i = R$id.invite_suggestions_header;
                                                                TextView textView7 = (TextView) view.findViewById(R$id.invite_suggestions_header);
                                                                if (textView7 != null) {
                                                                    i = R$id.link_settings_barrier;
                                                                    Barrier barrier2 = (Barrier) view.findViewById(R$id.link_settings_barrier);
                                                                    if (barrier2 != null) {
                                                                        FrameLayout frameLayout3 = (FrameLayout) view;
                                                                        i = R$id.search_barrier;
                                                                        Barrier barrier3 = (Barrier) view.findViewById(R$id.search_barrier);
                                                                        if (barrier3 != null) {
                                                                            i = R$id.search_input;
                                                                            SearchInputView searchInputView = (SearchInputView) view.findViewById(R$id.search_input);
                                                                            if (searchInputView != null) {
                                                                                i = R$id.share_button;
                                                                                CardView cardView = (CardView) view.findViewById(R$id.share_button);
                                                                                if (cardView != null) {
                                                                                    i = R$id.suggestion_list;
                                                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.suggestion_list);
                                                                                    if (recyclerView != null) {
                                                                                        i = R$id.suggestions_flipper;
                                                                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.suggestions_flipper);
                                                                                        if (appViewFlipper != null) {
                                                                                            return new WidgetGuildInviteShareSheetBinding(frameLayout3, constraintLayout, frameLayout, barrier, textView, textView2, textView3, imageView, textView4, imageButton, nestedScrollView, textView5, materialButton, textView6, frameLayout2, textView7, barrier2, frameLayout3, barrier3, searchInputView, cardView, recyclerView, appViewFlipper);
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
