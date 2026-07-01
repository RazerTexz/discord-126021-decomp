package com.discord.widgets.user.usersheet;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetUserSheetBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.roles.RolesListView;
import com.discord.widgets.stage.usersheet.UserProfileStageActionsView;
import com.discord.widgets.user.profile.UserProfileAdminView;
import com.discord.widgets.user.profile.UserProfileConnectionsView;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$binding$2 extends k implements Function1<View, WidgetUserSheetBinding> {
    public static final WidgetUserSheet$binding$2 INSTANCE = new WidgetUserSheet$binding$2();

    public WidgetUserSheet$binding$2() {
        super(1, WidgetUserSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetUserSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetUserSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetUserSheetBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.about_me_card;
        CardView cardView = (CardView) view.findViewById(R$id.about_me_card);
        if (cardView != null) {
            i = R$id.about_me_guild_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.about_me_guild_icon);
            if (simpleDraweeView != null) {
                i = R$id.about_me_guild_icon_name;
                TextView textView = (TextView) view.findViewById(R$id.about_me_guild_icon_name);
                if (textView != null) {
                    i = R$id.about_me_header;
                    TextView textView2 = (TextView) view.findViewById(R$id.about_me_header);
                    if (textView2 != null) {
                        i = R$id.about_me_header_container;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R$id.about_me_header_container);
                        if (flexboxLayout != null) {
                            i = R$id.about_me_text;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.about_me_text);
                            if (linkifiedTextView != null) {
                                i = R$id.loading_progress_bar;
                                ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) view.findViewById(R$id.loading_progress_bar);
                                if (contentLoadingProgressBar != null) {
                                    i = R$id.rich_presence_container;
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.rich_presence_container);
                                    if (frameLayout != null) {
                                        i = R$id.user_sheet_add_friend_action_button;
                                        Button button = (Button) view.findViewById(R$id.user_sheet_add_friend_action_button);
                                        if (button != null) {
                                            i = R$id.user_sheet_admin_card;
                                            CardView cardView2 = (CardView) view.findViewById(R$id.user_sheet_admin_card);
                                            if (cardView2 != null) {
                                                i = R$id.user_sheet_admin_view;
                                                UserProfileAdminView userProfileAdminView = (UserProfileAdminView) view.findViewById(R$id.user_sheet_admin_view);
                                                if (userProfileAdminView != null) {
                                                    i = R$id.user_sheet_call_action_button;
                                                    Button button2 = (Button) view.findViewById(R$id.user_sheet_call_action_button);
                                                    if (button2 != null) {
                                                        i = R$id.user_sheet_connections_header;
                                                        TextView textView3 = (TextView) view.findViewById(R$id.user_sheet_connections_header);
                                                        if (textView3 != null) {
                                                            i = R$id.user_sheet_connections_view;
                                                            UserProfileConnectionsView userProfileConnectionsView = (UserProfileConnectionsView) view.findViewById(R$id.user_sheet_connections_view);
                                                            if (userProfileConnectionsView != null) {
                                                                i = R$id.user_sheet_content;
                                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.user_sheet_content);
                                                                if (linearLayout != null) {
                                                                    i = R$id.user_sheet_copy_id;
                                                                    TextView textView4 = (TextView) view.findViewById(R$id.user_sheet_copy_id);
                                                                    if (textView4 != null) {
                                                                        i = R$id.user_sheet_developer_header;
                                                                        TextView textView5 = (TextView) view.findViewById(R$id.user_sheet_developer_header);
                                                                        if (textView5 != null) {
                                                                            i = R$id.user_sheet_friend_request_accept_button;
                                                                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.user_sheet_friend_request_accept_button);
                                                                            if (materialButton != null) {
                                                                                i = R$id.user_sheet_friend_request_ignore_button;
                                                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.user_sheet_friend_request_ignore_button);
                                                                                if (materialButton2 != null) {
                                                                                    i = R$id.user_sheet_friend_request_incoming_container;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.user_sheet_friend_request_incoming_container);
                                                                                    if (linearLayout2 != null) {
                                                                                        i = R$id.user_sheet_guild_container;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R$id.user_sheet_guild_container);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R$id.user_sheet_guild_header;
                                                                                            TextView textView6 = (TextView) view.findViewById(R$id.user_sheet_guild_header);
                                                                                            if (textView6 != null) {
                                                                                                i = R$id.user_sheet_incoming_friend_request_header;
                                                                                                TextView textView7 = (TextView) view.findViewById(R$id.user_sheet_incoming_friend_request_header);
                                                                                                if (textView7 != null) {
                                                                                                    i = R$id.user_sheet_loading_container;
                                                                                                    FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R$id.user_sheet_loading_container);
                                                                                                    if (frameLayout2 != null) {
                                                                                                        i = R$id.user_sheet_message_action_button;
                                                                                                        Button button3 = (Button) view.findViewById(R$id.user_sheet_message_action_button);
                                                                                                        if (button3 != null) {
                                                                                                            i = R$id.user_sheet_more_button;
                                                                                                            ImageView imageView = (ImageView) view.findViewById(R$id.user_sheet_more_button);
                                                                                                            if (imageView != null) {
                                                                                                                i = R$id.user_sheet_note_header;
                                                                                                                TextView textView8 = (TextView) view.findViewById(R$id.user_sheet_note_header);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R$id.user_sheet_note_text_field;
                                                                                                                    TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(R$id.user_sheet_note_text_field);
                                                                                                                    if (textInputEditText != null) {
                                                                                                                        i = R$id.user_sheet_note_text_field_wrap;
                                                                                                                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.user_sheet_note_text_field_wrap);
                                                                                                                        if (textInputLayout != null) {
                                                                                                                            i = R$id.user_sheet_pending_friend_request_action_button;
                                                                                                                            Button button4 = (Button) view.findViewById(R$id.user_sheet_pending_friend_request_action_button);
                                                                                                                            if (button4 != null) {
                                                                                                                                i = R$id.user_sheet_profile_actions_container;
                                                                                                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R$id.user_sheet_profile_actions_container);
                                                                                                                                if (linearLayout4 != null) {
                                                                                                                                    i = R$id.user_sheet_profile_actions_divider;
                                                                                                                                    View viewFindViewById = view.findViewById(R$id.user_sheet_profile_actions_divider);
                                                                                                                                    if (viewFindViewById != null) {
                                                                                                                                        i = R$id.user_sheet_profile_add_to_server_button;
                                                                                                                                        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.user_sheet_profile_add_to_server_button);
                                                                                                                                        if (materialButton3 != null) {
                                                                                                                                            i = R$id.user_sheet_profile_add_to_server_container;
                                                                                                                                            FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R$id.user_sheet_profile_add_to_server_container);
                                                                                                                                            if (frameLayout3 != null) {
                                                                                                                                                i = R$id.user_sheet_profile_edit_button;
                                                                                                                                                MaterialButton materialButton4 = (MaterialButton) view.findViewById(R$id.user_sheet_profile_edit_button);
                                                                                                                                                if (materialButton4 != null) {
                                                                                                                                                    i = R$id.user_sheet_profile_edit_container;
                                                                                                                                                    FlexboxLayout flexboxLayout2 = (FlexboxLayout) view.findViewById(R$id.user_sheet_profile_edit_container);
                                                                                                                                                    if (flexboxLayout2 != null) {
                                                                                                                                                        i = R$id.user_sheet_profile_header_view;
                                                                                                                                                        UserProfileHeaderView userProfileHeaderView = (UserProfileHeaderView) view.findViewById(R$id.user_sheet_profile_header_view);
                                                                                                                                                        if (userProfileHeaderView != null) {
                                                                                                                                                            i = R$id.user_sheet_profile_identity_button;
                                                                                                                                                            MaterialButton materialButton5 = (MaterialButton) view.findViewById(R$id.user_sheet_profile_identity_button);
                                                                                                                                                            if (materialButton5 != null) {
                                                                                                                                                                i = R$id.user_sheet_profile_stage_actions_card;
                                                                                                                                                                CardView cardView3 = (CardView) view.findViewById(R$id.user_sheet_profile_stage_actions_card);
                                                                                                                                                                if (cardView3 != null) {
                                                                                                                                                                    i = R$id.user_sheet_profile_stage_actions_view;
                                                                                                                                                                    UserProfileStageActionsView userProfileStageActionsView = (UserProfileStageActionsView) view.findViewById(R$id.user_sheet_profile_stage_actions_view);
                                                                                                                                                                    if (userProfileStageActionsView != null) {
                                                                                                                                                                        i = R$id.user_sheet_profile_voice_settings_header;
                                                                                                                                                                        TextView textView9 = (TextView) view.findViewById(R$id.user_sheet_profile_voice_settings_header);
                                                                                                                                                                        if (textView9 != null) {
                                                                                                                                                                            i = R$id.user_sheet_profile_voice_settings_view;
                                                                                                                                                                            UserProfileVoiceSettingsView userProfileVoiceSettingsView = (UserProfileVoiceSettingsView) view.findViewById(R$id.user_sheet_profile_voice_settings_view);
                                                                                                                                                                            if (userProfileVoiceSettingsView != null) {
                                                                                                                                                                                i = R$id.user_sheet_roles_list;
                                                                                                                                                                                RolesListView rolesListView = (RolesListView) view.findViewById(R$id.user_sheet_roles_list);
                                                                                                                                                                                if (rolesListView != null) {
                                                                                                                                                                                    i = R$id.user_sheet_video_action_button;
                                                                                                                                                                                    Button button5 = (Button) view.findViewById(R$id.user_sheet_video_action_button);
                                                                                                                                                                                    if (button5 != null) {
                                                                                                                                                                                        i = R$id.voice_settings_view_card;
                                                                                                                                                                                        CardView cardView4 = (CardView) view.findViewById(R$id.voice_settings_view_card);
                                                                                                                                                                                        if (cardView4 != null) {
                                                                                                                                                                                            return new WidgetUserSheetBinding((NestedScrollView) view, cardView, simpleDraweeView, textView, textView2, flexboxLayout, linkifiedTextView, contentLoadingProgressBar, frameLayout, button, cardView2, userProfileAdminView, button2, textView3, userProfileConnectionsView, linearLayout, textView4, textView5, materialButton, materialButton2, linearLayout2, linearLayout3, textView6, textView7, frameLayout2, button3, imageView, textView8, textInputEditText, textInputLayout, button4, linearLayout4, viewFindViewById, materialButton3, frameLayout3, materialButton4, flexboxLayout2, userProfileHeaderView, materialButton5, cardView3, userProfileStageActionsView, textView9, userProfileVoiceSettingsView, rolesListView, button5, cardView4);
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
