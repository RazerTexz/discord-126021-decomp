package com.discord.widgets.channels.permissions;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelSettingsEditPermissionsBinding;
import com.discord.views.TernaryCheckBox;
import com.discord.views.user.SettingsMemberView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelSettingsEditPermissions$binding$2 extends k implements Function1<View, WidgetChannelSettingsEditPermissionsBinding> {
    public static final WidgetChannelSettingsEditPermissions$binding$2 INSTANCE = new WidgetChannelSettingsEditPermissions$binding$2();

    public WidgetChannelSettingsEditPermissions$binding$2() {
        super(1, WidgetChannelSettingsEditPermissionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelSettingsEditPermissionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelSettingsEditPermissionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.channel_permission_events_manage_events;
        TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) view.findViewById(R$id.channel_permission_events_manage_events);
        if (ternaryCheckBox != null) {
            i = R$id.channel_permission_general_create_instant_invite;
            TernaryCheckBox ternaryCheckBox2 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_general_create_instant_invite);
            if (ternaryCheckBox2 != null) {
                i = R$id.channel_permission_general_manage_channel;
                TernaryCheckBox ternaryCheckBox3 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_general_manage_channel);
                if (ternaryCheckBox3 != null) {
                    i = R$id.channel_permission_general_manage_permissions;
                    TernaryCheckBox ternaryCheckBox4 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_general_manage_permissions);
                    if (ternaryCheckBox4 != null) {
                        i = R$id.channel_permission_general_manage_threads;
                        TernaryCheckBox ternaryCheckBox5 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_general_manage_threads);
                        if (ternaryCheckBox5 != null) {
                            i = R$id.channel_permission_general_manage_webhooks;
                            TernaryCheckBox ternaryCheckBox6 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_general_manage_webhooks);
                            if (ternaryCheckBox6 != null) {
                                i = R$id.channel_permission_stage_request_to_speak;
                                TernaryCheckBox ternaryCheckBox7 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_stage_request_to_speak);
                                if (ternaryCheckBox7 != null) {
                                    i = R$id.channel_permission_text_add_reactions;
                                    TernaryCheckBox ternaryCheckBox8 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_add_reactions);
                                    if (ternaryCheckBox8 != null) {
                                        i = R$id.channel_permission_text_attach_files;
                                        TernaryCheckBox ternaryCheckBox9 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_attach_files);
                                        if (ternaryCheckBox9 != null) {
                                            i = R$id.channel_permission_text_create_private_threads;
                                            TernaryCheckBox ternaryCheckBox10 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_create_private_threads);
                                            if (ternaryCheckBox10 != null) {
                                                i = R$id.channel_permission_text_create_public_threads;
                                                TernaryCheckBox ternaryCheckBox11 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_create_public_threads);
                                                if (ternaryCheckBox11 != null) {
                                                    i = R$id.channel_permission_text_embed_links;
                                                    TernaryCheckBox ternaryCheckBox12 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_embed_links);
                                                    if (ternaryCheckBox12 != null) {
                                                        i = R$id.channel_permission_text_manage_messages;
                                                        TernaryCheckBox ternaryCheckBox13 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_manage_messages);
                                                        if (ternaryCheckBox13 != null) {
                                                            i = R$id.channel_permission_text_mention_everyone;
                                                            TernaryCheckBox ternaryCheckBox14 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_mention_everyone);
                                                            if (ternaryCheckBox14 != null) {
                                                                i = R$id.channel_permission_text_read_message_history;
                                                                TernaryCheckBox ternaryCheckBox15 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_read_message_history);
                                                                if (ternaryCheckBox15 != null) {
                                                                    i = R$id.channel_permission_text_read_messages;
                                                                    TernaryCheckBox ternaryCheckBox16 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_read_messages);
                                                                    if (ternaryCheckBox16 != null) {
                                                                        i = R$id.channel_permission_text_send_messages;
                                                                        TernaryCheckBox ternaryCheckBox17 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_send_messages);
                                                                        if (ternaryCheckBox17 != null) {
                                                                            i = R$id.channel_permission_text_send_messages_in_threads;
                                                                            TernaryCheckBox ternaryCheckBox18 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_send_messages_in_threads);
                                                                            if (ternaryCheckBox18 != null) {
                                                                                i = R$id.channel_permission_text_send_tts_messages;
                                                                                TernaryCheckBox ternaryCheckBox19 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_send_tts_messages);
                                                                                if (ternaryCheckBox19 != null) {
                                                                                    i = R$id.channel_permission_text_use_external_emojis;
                                                                                    TernaryCheckBox ternaryCheckBox20 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_use_external_emojis);
                                                                                    if (ternaryCheckBox20 != null) {
                                                                                        i = R$id.channel_permission_text_use_external_stickers;
                                                                                        TernaryCheckBox ternaryCheckBox21 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_text_use_external_stickers);
                                                                                        if (ternaryCheckBox21 != null) {
                                                                                            i = R$id.channel_permission_use_application_commands;
                                                                                            TernaryCheckBox ternaryCheckBox22 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_use_application_commands);
                                                                                            if (ternaryCheckBox22 != null) {
                                                                                                i = R$id.channel_permission_voice_connect;
                                                                                                TernaryCheckBox ternaryCheckBox23 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_connect);
                                                                                                if (ternaryCheckBox23 != null) {
                                                                                                    i = R$id.channel_permission_voice_deafen_members;
                                                                                                    TernaryCheckBox ternaryCheckBox24 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_deafen_members);
                                                                                                    if (ternaryCheckBox24 != null) {
                                                                                                        i = R$id.channel_permission_voice_move_members;
                                                                                                        TernaryCheckBox ternaryCheckBox25 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_move_members);
                                                                                                        if (ternaryCheckBox25 != null) {
                                                                                                            i = R$id.channel_permission_voice_mute_members;
                                                                                                            TernaryCheckBox ternaryCheckBox26 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_mute_members);
                                                                                                            if (ternaryCheckBox26 != null) {
                                                                                                                i = R$id.channel_permission_voice_priority_speaker;
                                                                                                                TernaryCheckBox ternaryCheckBox27 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_priority_speaker);
                                                                                                                if (ternaryCheckBox27 != null) {
                                                                                                                    i = R$id.channel_permission_voice_speak;
                                                                                                                    TernaryCheckBox ternaryCheckBox28 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_speak);
                                                                                                                    if (ternaryCheckBox28 != null) {
                                                                                                                        i = R$id.channel_permission_voice_use_vad;
                                                                                                                        TernaryCheckBox ternaryCheckBox29 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_use_vad);
                                                                                                                        if (ternaryCheckBox29 != null) {
                                                                                                                            i = R$id.channel_permission_voice_video;
                                                                                                                            TernaryCheckBox ternaryCheckBox30 = (TernaryCheckBox) view.findViewById(R$id.channel_permission_voice_video);
                                                                                                                            if (ternaryCheckBox30 != null) {
                                                                                                                                i = R$id.channel_permissions_channel_name;
                                                                                                                                TextView textView = (TextView) view.findViewById(R$id.channel_permissions_channel_name);
                                                                                                                                if (textView != null) {
                                                                                                                                    i = R$id.channel_permissions_events_container;
                                                                                                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.channel_permissions_events_container);
                                                                                                                                    if (linearLayout != null) {
                                                                                                                                        i = R$id.channel_permissions_save;
                                                                                                                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.channel_permissions_save);
                                                                                                                                        if (floatingActionButton != null) {
                                                                                                                                            i = R$id.channel_permissions_stage_container;
                                                                                                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.channel_permissions_stage_container);
                                                                                                                                            if (linearLayout2 != null) {
                                                                                                                                                i = R$id.channel_permissions_target_name;
                                                                                                                                                TextView textView2 = (TextView) view.findViewById(R$id.channel_permissions_target_name);
                                                                                                                                                if (textView2 != null) {
                                                                                                                                                    i = R$id.channel_permissions_text_container;
                                                                                                                                                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R$id.channel_permissions_text_container);
                                                                                                                                                    if (linearLayout3 != null) {
                                                                                                                                                        i = R$id.channel_permissions_voice_container;
                                                                                                                                                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R$id.channel_permissions_voice_container);
                                                                                                                                                        if (linearLayout4 != null) {
                                                                                                                                                            i = R$id.member_view;
                                                                                                                                                            SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R$id.member_view);
                                                                                                                                                            if (settingsMemberView != null) {
                                                                                                                                                                i = R$id.section_general_permissions;
                                                                                                                                                                TextView textView3 = (TextView) view.findViewById(R$id.section_general_permissions);
                                                                                                                                                                if (textView3 != null) {
                                                                                                                                                                    return new WidgetChannelSettingsEditPermissionsBinding((CoordinatorLayout) view, ternaryCheckBox, ternaryCheckBox2, ternaryCheckBox3, ternaryCheckBox4, ternaryCheckBox5, ternaryCheckBox6, ternaryCheckBox7, ternaryCheckBox8, ternaryCheckBox9, ternaryCheckBox10, ternaryCheckBox11, ternaryCheckBox12, ternaryCheckBox13, ternaryCheckBox14, ternaryCheckBox15, ternaryCheckBox16, ternaryCheckBox17, ternaryCheckBox18, ternaryCheckBox19, ternaryCheckBox20, ternaryCheckBox21, ternaryCheckBox22, ternaryCheckBox23, ternaryCheckBox24, ternaryCheckBox25, ternaryCheckBox26, ternaryCheckBox27, ternaryCheckBox28, ternaryCheckBox29, ternaryCheckBox30, textView, linearLayout, floatingActionButton, linearLayout2, textView2, linearLayout3, linearLayout4, settingsMemberView, textView3);
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
