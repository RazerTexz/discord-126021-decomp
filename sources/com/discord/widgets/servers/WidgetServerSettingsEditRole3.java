package com.discord.widgets.servers;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetEditRoleBinding;
import com.discord.views.CheckedSetting;
import com.discord.widgets.roles.RoleIconView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditRole$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditRole3 extends FunctionReferenceImpl implements Function1<View, WidgetEditRoleBinding> {
    public static final WidgetServerSettingsEditRole3 INSTANCE = new WidgetServerSettingsEditRole3();

    public WidgetServerSettingsEditRole3() {
        super(1, WidgetEditRoleBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEditRoleBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEditRoleBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.edit_role_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.edit_role_name);
        if (textInputLayout != null) {
            i = R.id.edit_role_save;
            FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.edit_role_save);
            if (floatingActionButton != null) {
                i = R.id.event_permissions_divider;
                View viewFindViewById = view.findViewById(R.id.event_permissions_divider);
                if (viewFindViewById != null) {
                    i = R.id.event_permissions_title;
                    TextView textView = (TextView) view.findViewById(R.id.event_permissions_title);
                    if (textView != null) {
                        i = R.id.role_settings_add_reactions;
                        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.role_settings_add_reactions);
                        if (checkedSetting != null) {
                            i = R.id.role_settings_administrator;
                            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.role_settings_administrator);
                            if (checkedSetting2 != null) {
                                i = R.id.role_settings_attach_files;
                                CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.role_settings_attach_files);
                                if (checkedSetting3 != null) {
                                    i = R.id.role_settings_ban_members;
                                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.role_settings_ban_members);
                                    if (checkedSetting4 != null) {
                                        i = R.id.role_settings_change_nickname;
                                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.role_settings_change_nickname);
                                        if (checkedSetting5 != null) {
                                            i = R.id.role_settings_color_disabled_overlay;
                                            View viewFindViewById2 = view.findViewById(R.id.role_settings_color_disabled_overlay);
                                            if (viewFindViewById2 != null) {
                                                i = R.id.role_settings_color_selector_container;
                                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.role_settings_color_selector_container);
                                                if (relativeLayout != null) {
                                                    i = R.id.role_settings_create_instant_invite;
                                                    CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.role_settings_create_instant_invite);
                                                    if (checkedSetting6 != null) {
                                                        i = R.id.role_settings_create_private_threads;
                                                        CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R.id.role_settings_create_private_threads);
                                                        if (checkedSetting7 != null) {
                                                            i = R.id.role_settings_create_public_threads;
                                                            CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R.id.role_settings_create_public_threads);
                                                            if (checkedSetting8 != null) {
                                                                i = R.id.role_settings_current_color_display;
                                                                View viewFindViewById3 = view.findViewById(R.id.role_settings_current_color_display);
                                                                if (viewFindViewById3 != null) {
                                                                    i = R.id.role_settings_edit_name_disabled_overlay;
                                                                    View viewFindViewById4 = view.findViewById(R.id.role_settings_edit_name_disabled_overlay);
                                                                    if (viewFindViewById4 != null) {
                                                                        i = R.id.role_settings_embed_links;
                                                                        CheckedSetting checkedSetting9 = (CheckedSetting) view.findViewById(R.id.role_settings_embed_links);
                                                                        if (checkedSetting9 != null) {
                                                                            i = R.id.role_settings_hoist_checkedsetting;
                                                                            CheckedSetting checkedSetting10 = (CheckedSetting) view.findViewById(R.id.role_settings_hoist_checkedsetting);
                                                                            if (checkedSetting10 != null) {
                                                                                i = R.id.role_settings_icon_container;
                                                                                RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.role_settings_icon_container);
                                                                                if (relativeLayout2 != null) {
                                                                                    i = R.id.role_settings_kick_members;
                                                                                    CheckedSetting checkedSetting11 = (CheckedSetting) view.findViewById(R.id.role_settings_kick_members);
                                                                                    if (checkedSetting11 != null) {
                                                                                        i = R.id.role_settings_manage_channels;
                                                                                        CheckedSetting checkedSetting12 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_channels);
                                                                                        if (checkedSetting12 != null) {
                                                                                            i = R.id.role_settings_manage_emojis_and_stickers;
                                                                                            CheckedSetting checkedSetting13 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_emojis_and_stickers);
                                                                                            if (checkedSetting13 != null) {
                                                                                                i = R.id.role_settings_manage_events;
                                                                                                CheckedSetting checkedSetting14 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_events);
                                                                                                if (checkedSetting14 != null) {
                                                                                                    i = R.id.role_settings_manage_messages;
                                                                                                    CheckedSetting checkedSetting15 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_messages);
                                                                                                    if (checkedSetting15 != null) {
                                                                                                        i = R.id.role_settings_manage_nicknames;
                                                                                                        CheckedSetting checkedSetting16 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_nicknames);
                                                                                                        if (checkedSetting16 != null) {
                                                                                                            i = R.id.role_settings_manage_roles;
                                                                                                            CheckedSetting checkedSetting17 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_roles);
                                                                                                            if (checkedSetting17 != null) {
                                                                                                                i = R.id.role_settings_manage_server;
                                                                                                                CheckedSetting checkedSetting18 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_server);
                                                                                                                if (checkedSetting18 != null) {
                                                                                                                    i = R.id.role_settings_manage_threads;
                                                                                                                    CheckedSetting checkedSetting19 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_threads);
                                                                                                                    if (checkedSetting19 != null) {
                                                                                                                        i = R.id.role_settings_manage_webhooks;
                                                                                                                        CheckedSetting checkedSetting20 = (CheckedSetting) view.findViewById(R.id.role_settings_manage_webhooks);
                                                                                                                        if (checkedSetting20 != null) {
                                                                                                                            i = R.id.role_settings_mention_everyone;
                                                                                                                            CheckedSetting checkedSetting21 = (CheckedSetting) view.findViewById(R.id.role_settings_mention_everyone);
                                                                                                                            if (checkedSetting21 != null) {
                                                                                                                                i = R.id.role_settings_mentionable_checkedsetting;
                                                                                                                                CheckedSetting checkedSetting22 = (CheckedSetting) view.findViewById(R.id.role_settings_mentionable_checkedsetting);
                                                                                                                                if (checkedSetting22 != null) {
                                                                                                                                    i = R.id.role_settings_moderate_member;
                                                                                                                                    CheckedSetting checkedSetting23 = (CheckedSetting) view.findViewById(R.id.role_settings_moderate_member);
                                                                                                                                    if (checkedSetting23 != null) {
                                                                                                                                        i = R.id.role_settings_overview_scroll;
                                                                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.role_settings_overview_scroll);
                                                                                                                                        if (nestedScrollView != null) {
                                                                                                                                            i = R.id.role_settings_priority_speaker;
                                                                                                                                            CheckedSetting checkedSetting24 = (CheckedSetting) view.findViewById(R.id.role_settings_priority_speaker);
                                                                                                                                            if (checkedSetting24 != null) {
                                                                                                                                                i = R.id.role_settings_read_message_history;
                                                                                                                                                CheckedSetting checkedSetting25 = (CheckedSetting) view.findViewById(R.id.role_settings_read_message_history);
                                                                                                                                                if (checkedSetting25 != null) {
                                                                                                                                                    i = R.id.role_settings_read_messages;
                                                                                                                                                    CheckedSetting checkedSetting26 = (CheckedSetting) view.findViewById(R.id.role_settings_read_messages);
                                                                                                                                                    if (checkedSetting26 != null) {
                                                                                                                                                        i = R.id.role_settings_request_to_speak;
                                                                                                                                                        CheckedSetting checkedSetting27 = (CheckedSetting) view.findViewById(R.id.role_settings_request_to_speak);
                                                                                                                                                        if (checkedSetting27 != null) {
                                                                                                                                                            i = R.id.role_settings_role_icon;
                                                                                                                                                            RoleIconView roleIconView = (RoleIconView) view.findViewById(R.id.role_settings_role_icon);
                                                                                                                                                            if (roleIconView != null) {
                                                                                                                                                                i = R.id.role_settings_role_icon_divider;
                                                                                                                                                                View viewFindViewById5 = view.findViewById(R.id.role_settings_role_icon_divider);
                                                                                                                                                                if (viewFindViewById5 != null) {
                                                                                                                                                                    i = R.id.role_settings_role_icon_header;
                                                                                                                                                                    TextView textView2 = (TextView) view.findViewById(R.id.role_settings_role_icon_header);
                                                                                                                                                                    if (textView2 != null) {
                                                                                                                                                                        i = R.id.role_settings_send_messages;
                                                                                                                                                                        CheckedSetting checkedSetting28 = (CheckedSetting) view.findViewById(R.id.role_settings_send_messages);
                                                                                                                                                                        if (checkedSetting28 != null) {
                                                                                                                                                                            i = R.id.role_settings_send_messages_in_threads;
                                                                                                                                                                            CheckedSetting checkedSetting29 = (CheckedSetting) view.findViewById(R.id.role_settings_send_messages_in_threads);
                                                                                                                                                                            if (checkedSetting29 != null) {
                                                                                                                                                                                i = R.id.role_settings_send_tts_messages;
                                                                                                                                                                                CheckedSetting checkedSetting30 = (CheckedSetting) view.findViewById(R.id.role_settings_send_tts_messages);
                                                                                                                                                                                if (checkedSetting30 != null) {
                                                                                                                                                                                    i = R.id.role_settings_use_application_commands;
                                                                                                                                                                                    CheckedSetting checkedSetting31 = (CheckedSetting) view.findViewById(R.id.role_settings_use_application_commands);
                                                                                                                                                                                    if (checkedSetting31 != null) {
                                                                                                                                                                                        i = R.id.role_settings_use_external_emojis;
                                                                                                                                                                                        CheckedSetting checkedSetting32 = (CheckedSetting) view.findViewById(R.id.role_settings_use_external_emojis);
                                                                                                                                                                                        if (checkedSetting32 != null) {
                                                                                                                                                                                            i = R.id.role_settings_use_external_stickers;
                                                                                                                                                                                            CheckedSetting checkedSetting33 = (CheckedSetting) view.findViewById(R.id.role_settings_use_external_stickers);
                                                                                                                                                                                            if (checkedSetting33 != null) {
                                                                                                                                                                                                i = R.id.role_settings_view_audit_log;
                                                                                                                                                                                                CheckedSetting checkedSetting34 = (CheckedSetting) view.findViewById(R.id.role_settings_view_audit_log);
                                                                                                                                                                                                if (checkedSetting34 != null) {
                                                                                                                                                                                                    i = R.id.role_settings_view_guild_analytics;
                                                                                                                                                                                                    CheckedSetting checkedSetting35 = (CheckedSetting) view.findViewById(R.id.role_settings_view_guild_analytics);
                                                                                                                                                                                                    if (checkedSetting35 != null) {
                                                                                                                                                                                                        i = R.id.role_settings_voice_connect;
                                                                                                                                                                                                        CheckedSetting checkedSetting36 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_connect);
                                                                                                                                                                                                        if (checkedSetting36 != null) {
                                                                                                                                                                                                            i = R.id.role_settings_voice_deafen_members;
                                                                                                                                                                                                            CheckedSetting checkedSetting37 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_deafen_members);
                                                                                                                                                                                                            if (checkedSetting37 != null) {
                                                                                                                                                                                                                i = R.id.role_settings_voice_move_members;
                                                                                                                                                                                                                CheckedSetting checkedSetting38 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_move_members);
                                                                                                                                                                                                                if (checkedSetting38 != null) {
                                                                                                                                                                                                                    i = R.id.role_settings_voice_mute_members;
                                                                                                                                                                                                                    CheckedSetting checkedSetting39 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_mute_members);
                                                                                                                                                                                                                    if (checkedSetting39 != null) {
                                                                                                                                                                                                                        i = R.id.role_settings_voice_speak;
                                                                                                                                                                                                                        CheckedSetting checkedSetting40 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_speak);
                                                                                                                                                                                                                        if (checkedSetting40 != null) {
                                                                                                                                                                                                                            i = R.id.role_settings_voice_use_voice_activity;
                                                                                                                                                                                                                            CheckedSetting checkedSetting41 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_use_voice_activity);
                                                                                                                                                                                                                            if (checkedSetting41 != null) {
                                                                                                                                                                                                                                i = R.id.role_settings_voice_video;
                                                                                                                                                                                                                                CheckedSetting checkedSetting42 = (CheckedSetting) view.findViewById(R.id.role_settings_voice_video);
                                                                                                                                                                                                                                if (checkedSetting42 != null) {
                                                                                                                                                                                                                                    return new WidgetEditRoleBinding((CoordinatorLayout) view, textInputLayout, floatingActionButton, viewFindViewById, textView, checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5, viewFindViewById2, relativeLayout, checkedSetting6, checkedSetting7, checkedSetting8, viewFindViewById3, viewFindViewById4, checkedSetting9, checkedSetting10, relativeLayout2, checkedSetting11, checkedSetting12, checkedSetting13, checkedSetting14, checkedSetting15, checkedSetting16, checkedSetting17, checkedSetting18, checkedSetting19, checkedSetting20, checkedSetting21, checkedSetting22, checkedSetting23, nestedScrollView, checkedSetting24, checkedSetting25, checkedSetting26, checkedSetting27, roleIconView, viewFindViewById5, textView2, checkedSetting28, checkedSetting29, checkedSetting30, checkedSetting31, checkedSetting32, checkedSetting33, checkedSetting34, checkedSetting35, checkedSetting36, checkedSetting37, checkedSetting38, checkedSetting39, checkedSetting40, checkedSetting41, checkedSetting42);
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
