package com.discord.widgets.servers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import b.a.i.d0;
import com.discord.R$id;
import com.discord.databinding.WidgetServerSettingsEditIntegrationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsEditIntegration$binding$2 extends k implements Function1<View, WidgetServerSettingsEditIntegrationBinding> {
    public static final WidgetServerSettingsEditIntegration$binding$2 INSTANCE = new WidgetServerSettingsEditIntegration$binding$2();

    public WidgetServerSettingsEditIntegration$binding$2() {
        super(1, WidgetServerSettingsEditIntegrationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditIntegrationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditIntegrationBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = 2131363051;
        DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
        if (dimmerView != null) {
            i = R$id.edit_integration_custom_emotes_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.edit_integration_custom_emotes_container);
            if (linearLayout != null) {
                i = R$id.edit_integration_custom_emotes_toggle;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.edit_integration_custom_emotes_toggle);
                if (checkedSetting != null) {
                    i = R$id.edit_integration_expire_radio_kick_user;
                    CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R$id.edit_integration_expire_radio_kick_user);
                    if (checkedSetting2 != null) {
                        i = R$id.edit_integration_expire_radio_remove_role;
                        CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R$id.edit_integration_expire_radio_remove_role);
                        if (checkedSetting3 != null) {
                            i = R$id.edit_integration_expired_sub_container;
                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.edit_integration_expired_sub_container);
                            if (linearLayout2 != null) {
                                i = R$id.edit_integration_grace_period_container;
                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R$id.edit_integration_grace_period_container);
                                if (linearLayout3 != null) {
                                    i = R$id.edit_integration_grace_period_radio_14_days;
                                    CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R$id.edit_integration_grace_period_radio_14_days);
                                    if (checkedSetting4 != null) {
                                        i = R$id.edit_integration_grace_period_radio_1_day;
                                        CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R$id.edit_integration_grace_period_radio_1_day);
                                        if (checkedSetting5 != null) {
                                            i = R$id.edit_integration_grace_period_radio_30_days;
                                            CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R$id.edit_integration_grace_period_radio_30_days);
                                            if (checkedSetting6 != null) {
                                                i = R$id.edit_integration_grace_period_radio_3_days;
                                                CheckedSetting checkedSetting7 = (CheckedSetting) view.findViewById(R$id.edit_integration_grace_period_radio_3_days);
                                                if (checkedSetting7 != null) {
                                                    i = R$id.edit_integration_grace_period_radio_7_days;
                                                    CheckedSetting checkedSetting8 = (CheckedSetting) view.findViewById(R$id.edit_integration_grace_period_radio_7_days);
                                                    if (checkedSetting8 != null) {
                                                        i = R$id.edit_integration_icon;
                                                        ImageView imageView = (ImageView) view.findViewById(R$id.edit_integration_icon);
                                                        if (imageView != null) {
                                                            i = R$id.edit_integration_name;
                                                            TextView textView = (TextView) view.findViewById(R$id.edit_integration_name);
                                                            if (textView != null) {
                                                                i = R$id.edit_integration_name_container;
                                                                LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R$id.edit_integration_name_container);
                                                                if (linearLayout4 != null) {
                                                                    i = R$id.edit_integration_owner_name;
                                                                    TextView textView2 = (TextView) view.findViewById(R$id.edit_integration_owner_name);
                                                                    if (textView2 != null) {
                                                                        i = R$id.edit_integration_save;
                                                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.edit_integration_save);
                                                                        if (floatingActionButton != null) {
                                                                            i = R$id.edit_integration_settings_scroll;
                                                                            NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R$id.edit_integration_settings_scroll);
                                                                            if (nestedScrollView != null) {
                                                                                i = R$id.edit_member_administrative_container;
                                                                                LinearLayout linearLayout5 = (LinearLayout) view.findViewById(R$id.edit_member_administrative_container);
                                                                                if (linearLayout5 != null) {
                                                                                    i = R$id.edit_member_roles_container;
                                                                                    LinearLayout linearLayout6 = (LinearLayout) view.findViewById(R$id.edit_member_roles_container);
                                                                                    if (linearLayout6 != null) {
                                                                                        i = R$id.sync_settings;
                                                                                        View viewFindViewById = view.findViewById(R$id.sync_settings);
                                                                                        if (viewFindViewById != null) {
                                                                                            int i2 = R$id.edit_integration_last_sync_time;
                                                                                            TextView textView3 = (TextView) viewFindViewById.findViewById(R$id.edit_integration_last_sync_time);
                                                                                            if (textView3 != null) {
                                                                                                i2 = R$id.edit_integration_subscriber_count;
                                                                                                TextView textView4 = (TextView) viewFindViewById.findViewById(R$id.edit_integration_subscriber_count);
                                                                                                if (textView4 != null) {
                                                                                                    i2 = R$id.edit_integration_sync_container;
                                                                                                    RelativeLayout relativeLayout = (RelativeLayout) viewFindViewById.findViewById(R$id.edit_integration_sync_container);
                                                                                                    if (relativeLayout != null) {
                                                                                                        i2 = R$id.edit_integration_synced_role;
                                                                                                        TextView textView5 = (TextView) viewFindViewById.findViewById(R$id.edit_integration_synced_role);
                                                                                                        if (textView5 != null) {
                                                                                                            i2 = R$id.edit_integration_synced_role_container;
                                                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) viewFindViewById.findViewById(R$id.edit_integration_synced_role_container);
                                                                                                            if (relativeLayout2 != null) {
                                                                                                                return new WidgetServerSettingsEditIntegrationBinding((CoordinatorLayout) view, dimmerView, linearLayout, checkedSetting, checkedSetting2, checkedSetting3, linearLayout2, linearLayout3, checkedSetting4, checkedSetting5, checkedSetting6, checkedSetting7, checkedSetting8, imageView, textView, linearLayout4, textView2, floatingActionButton, nestedScrollView, linearLayout5, linearLayout6, new d0((LinearLayout) viewFindViewById, textView3, textView4, relativeLayout, textView5, relativeLayout2));
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
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
