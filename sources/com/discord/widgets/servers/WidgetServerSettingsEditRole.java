package com.discord.widgets.servers;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.o;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.permission.Permission;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetEditRoleBinding;
import com.discord.restapi.RestAPIParams$Role;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEditRole.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEditRoleBinding;", 0)};
    public static final WidgetServerSettingsEditRole$Companion Companion = new WidgetServerSettingsEditRole$Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_ROLE_ID = "INTENT_EXTRA_ROLE_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final StatefulViews state;

    public WidgetServerSettingsEditRole() {
        super(R$layout.widget_edit_role);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEditRole$binding$2.INSTANCE, null, 2, null);
        this.state = new StatefulViews(R$id.edit_role_name);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        widgetServerSettingsEditRole.configureUI(widgetServerSettingsEditRole$Model);
    }

    public static final /* synthetic */ WidgetEditRoleBinding access$getBinding$p(WidgetServerSettingsEditRole widgetServerSettingsEditRole) {
        return widgetServerSettingsEditRole.getBinding();
    }

    public static final /* synthetic */ String access$getLockMessage(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model, boolean z2) {
        return widgetServerSettingsEditRole.getLockMessage(widgetServerSettingsEditRole$Model, z2);
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetServerSettingsEditRole widgetServerSettingsEditRole, WidgetServerSettingsEditRole$Model widgetServerSettingsEditRole$Model) {
        widgetServerSettingsEditRole.launchColorPicker(widgetServerSettingsEditRole$Model);
    }

    public static final /* synthetic */ void access$patchRole(WidgetServerSettingsEditRole widgetServerSettingsEditRole, long j, RestAPIParams$Role restAPIParams$Role) {
        widgetServerSettingsEditRole.patchRole(j, restAPIParams$Role);
    }

    private final void configureUI(WidgetServerSettingsEditRole$Model data) {
        if ((data != null ? data.getRole() : null) == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setupMenu(data);
        setupActionBar(data);
        setupRoleName(data);
        setupHoistAndMentionSettings(data);
        setupPermissionsSettings(data);
        setupColorSetting(data);
        setRoleIcon(data);
        this.state.configureSaveActionView(getBinding().c);
        getBinding().c.setOnClickListener(new WidgetServerSettingsEditRole$configureUI$1(this, data));
        if (data.getUseNewThreadPermissions()) {
            return;
        }
        CheckedSetting.i(getBinding().M, getString(2131895085), false, 2);
        getBinding().N.setText(getString(2131892202));
        getBinding().N.h(b.k(this, 2131892199, new Object[0], null, 4), true);
        getBinding().m.setText(getString(2131892192));
        getBinding().m.h(b.k(this, 2131892196, new Object[0], null, 4), true);
        getBinding().l.setText(getString(2131892191));
        getBinding().l.h(b.k(this, 2131892193, new Object[0], null, 4), true);
    }

    private final void enableSetting(CheckedSetting setting, WidgetServerSettingsEditRole$Model data, long permission) {
        setting.e(new WidgetServerSettingsEditRole$enableSetting$1(this, data, permission));
    }

    private final WidgetEditRoleBinding getBinding() {
        return (WidgetEditRoleBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002b  */
    private final String getLockMessage(WidgetServerSettingsEditRole$Model data, boolean everyoneLocked) {
        String string;
        if (everyoneLocked && data.isEveryoneRole()) {
            String string2 = getString(2131889161);
            m.checkNotNullExpressionValue(string2, "getString(R.string.form_…el_disabled_for_everyone)");
            return string2;
        }
        WidgetServerSettingsEditRole$Model$ManageStatus manageStatus = data.getManageStatus();
        if (manageStatus != null) {
            int iOrdinal = manageStatus.ordinal();
            if (iOrdinal == 0) {
                string = getString(2131891705);
            } else if (iOrdinal == 1) {
                string = getString(2131891707);
            } else if (iOrdinal == 2) {
                string = getString(2131891708);
            } else if (iOrdinal != 3) {
                string = "";
            } else {
                string = getString(2131896527);
            }
        } else {
            string = "";
        }
        m.checkNotNullExpressionValue(string, "when (data.manageStatus)…s)\n      else -> \"\"\n    }");
        return string;
    }

    public static final void launch(long j, long j2, Context context) {
        Companion.launch(j, j2, context);
    }

    private final void launchColorPicker(WidgetServerSettingsEditRole$Model data) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), 2131894860, RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null));
        colorPickerDialogBuildColorPickerDialog.k = new WidgetServerSettingsEditRole$launchColorPicker$1(this, data);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void patchRole(long guildId, RestAPIParams$Role roleParams) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateRole(guildId, roleParams.getId(), roleParams), false, 1, null), this, null, 2, null).k(o.j(WidgetServerSettingsEditRole$patchRole$1.INSTANCE, getContext(), null, 4));
    }

    private final void setRoleIcon(WidgetServerSettingsEditRole$Model data) {
        if (data.getRole().getIcon() != null) {
            String icon = data.getRole().getIcon();
            m.checkNotNull(icon);
            if (icon.length() > 0) {
                getBinding().J.setRole(data.getRole(), Long.valueOf(data.getGuildId()));
                TextView textView = getBinding().L;
                m.checkNotNullExpressionValue(textView, "binding.roleSettingsRoleIconHeader");
                textView.setVisibility(0);
                View view = getBinding().K;
                m.checkNotNullExpressionValue(view, "binding.roleSettingsRoleIconDivider");
                view.setVisibility(0);
                RelativeLayout relativeLayout = getBinding().r;
                m.checkNotNullExpressionValue(relativeLayout, "binding.roleSettingsIconContainer");
                relativeLayout.setVisibility(0);
                return;
            }
        }
        TextView textView2 = getBinding().L;
        m.checkNotNullExpressionValue(textView2, "binding.roleSettingsRoleIconHeader");
        textView2.setVisibility(8);
        View view2 = getBinding().K;
        m.checkNotNullExpressionValue(view2, "binding.roleSettingsRoleIconDivider");
        view2.setVisibility(8);
        RelativeLayout relativeLayout2 = getBinding().r;
        m.checkNotNullExpressionValue(relativeLayout2, "binding.roleSettingsIconContainer");
        relativeLayout2.setVisibility(8);
    }

    private final void setupActionBar(WidgetServerSettingsEditRole$Model data) {
        int iHSVToColor;
        AppActivity appActivity = getAppActivity();
        Toolbar toolbar = appActivity != null ? appActivity.toolbar : null;
        if (toolbar != null) {
            int roleColor = RoleUtils.getRoleColor(data.getRole(), requireContext(), Integer.valueOf(ColorCompat.getThemedColor(requireContext(), 2130969062)));
            if (RoleUtils.isDefaultColor(data.getRole())) {
                iHSVToColor = ColorCompat.getThemedColor(this, 2130969074);
            } else {
                float[] fArr = new float[3];
                Color.colorToHSV(roleColor, fArr);
                fArr[2] = fArr[2] * 0.5f;
                iHSVToColor = Color.HSVToColor(fArr);
            }
            boolean zIsColorDark$default = ColorCompat.isColorDark$default(roleColor, 0.0f, 2, null);
            int color = ColorCompat.getColor(requireContext(), zIsColorDark$default ? 2131100162 : 2131100178);
            ColorCompat.setStatusBarColor(this, iHSVToColor, zIsColorDark$default);
            WidgetServerSettingsEditRole$setupActionBar$1 widgetServerSettingsEditRole$setupActionBar$1 = WidgetServerSettingsEditRole$setupActionBar$1.INSTANCE;
            AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
            String string = getString(2131889255);
            m.checkNotNullExpressionValue(string, "getString(R.string.form_label_role_settings)");
            setActionBarTitle(widgetServerSettingsEditRole$setupActionBar$1.invoke(string, color));
            setActionBarSubtitle(widgetServerSettingsEditRole$setupActionBar$1.invoke(data.getRole().getName(), color));
            toolbar.setBackgroundColor(roleColor);
            Drawable navigationIcon = toolbar.getNavigationIcon();
            if (navigationIcon != null) {
                navigationIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff$Mode.SRC_ATOP));
            }
            Drawable overflowIcon = toolbar.getOverflowIcon();
            if (overflowIcon != null) {
                overflowIcon.setColorFilter(new PorterDuffColorFilter(color, PorterDuff$Mode.SRC_ATOP));
            }
        }
    }

    private final void setupColorSetting(WidgetServerSettingsEditRole$Model data) {
        View view = getBinding().n;
        m.checkNotNullExpressionValue(view, "binding.roleSettingsCurrentColorDisplay");
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), 2131231192);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(RoleUtils.getRoleColor$default(data.getRole(), requireContext(), null, 2, null), PorterDuff$Mode.SRC_ATOP));
            View view2 = getBinding().n;
            m.checkNotNullExpressionValue(view2, "binding.roleSettingsCurrentColorDisplay");
            view2.setBackground(drawable);
        }
        if (!data.canManage() || data.isEveryoneRole()) {
            View view3 = getBinding().i;
            m.checkNotNullExpressionValue(view3, "binding.roleSettingsColorDisabledOverlay");
            view3.setVisibility(0);
            getBinding().i.setOnClickListener(new WidgetServerSettingsEditRole$setupColorSetting$2(this, data));
            return;
        }
        getBinding().j.setOnClickListener(new WidgetServerSettingsEditRole$setupColorSetting$1(this, data));
        View view4 = getBinding().i;
        m.checkNotNullExpressionValue(view4, "binding.roleSettingsColorDisabledOverlay");
        view4.setVisibility(8);
        getBinding().i.setOnClickListener(null);
    }

    private final void setupHoistAndMentionSettings(WidgetServerSettingsEditRole$Model data) {
        CheckedSetting checkedSetting = getBinding().q;
        m.checkNotNullExpressionValue(checkedSetting, "binding.roleSettingsHoistCheckedsetting");
        checkedSetting.setChecked(data.getRole().getHoist());
        CheckedSetting checkedSetting2 = getBinding().D;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsMentionableCheckedsetting");
        checkedSetting2.setChecked(data.getRole().getMentionable());
        if (data.canManage() && !data.isEveryoneRole()) {
            getBinding().q.e(new WidgetServerSettingsEditRole$setupHoistAndMentionSettings$1(this, data));
            getBinding().D.e(new WidgetServerSettingsEditRole$setupHoistAndMentionSettings$2(this, data));
        } else {
            String lockMessage = getLockMessage(data, true);
            getBinding().q.c(lockMessage);
            getBinding().D.c(lockMessage);
        }
    }

    private final void setupMenu(WidgetServerSettingsEditRole$Model data) {
        if (!data.canManage() || data.isEveryoneRole() || data.getRole().getManaged()) {
            AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_empty, null, null, 4, null);
        } else {
            AppFragment.setActionBarOptionsMenu$default(this, R$menu.menu_edit_role, new WidgetServerSettingsEditRole$setupMenu$1(this, data), null, 4, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0297  */
    private final void setupPermissionsSettings(WidgetServerSettingsEditRole$Model data) {
        long j;
        for (CheckedSetting checkedSetting : n.listOf((Object[]) new CheckedSetting[]{getBinding().e, getBinding().f, getBinding().g, getBinding().h, getBinding().k, getBinding().p, getBinding().f2372s, getBinding().t, getBinding().w, getBinding().A, getBinding().f2373x, getBinding().u, getBinding().f2374y, getBinding().f2375z, getBinding().E, getBinding().B, getBinding().C, getBinding().G, getBinding().H, getBinding().M, getBinding().N, getBinding().m, getBinding().l, getBinding().O, getBinding().P, getBinding().Q, getBinding().R, getBinding().d, getBinding().S, getBinding().U, getBinding().Y, getBinding().f2370a0, getBinding().X, getBinding().V, getBinding().W, getBinding().Z, getBinding().F, getBinding().T, getBinding().I, getBinding().v})) {
            m.checkNotNullExpressionValue(checkedSetting, "setting");
            switch (checkedSetting.getId()) {
                case R$id.role_settings_add_reactions /* 2131364965 */:
                    j = 64;
                    break;
                case R$id.role_settings_administrator /* 2131364966 */:
                    j = 8;
                    break;
                case R$id.role_settings_attach_files /* 2131364967 */:
                    j = Permission.ATTACH_FILES;
                    break;
                case R$id.role_settings_ban_members /* 2131364968 */:
                    j = 4;
                    break;
                case R$id.role_settings_change_nickname /* 2131364969 */:
                    j = Permission.CHANGE_NICKNAME;
                    break;
                case R$id.role_settings_color_disabled_overlay /* 2131364970 */:
                case R$id.role_settings_color_selector_container /* 2131364971 */:
                case R$id.role_settings_current_color_display /* 2131364975 */:
                case R$id.role_settings_edit_name_disabled_overlay /* 2131364976 */:
                case R$id.role_settings_hoist_checkedsetting /* 2131364978 */:
                case R$id.role_settings_icon_container /* 2131364979 */:
                case R$id.role_settings_mentionable_checkedsetting /* 2131364991 */:
                case R$id.role_settings_overview_scroll /* 2131364993 */:
                case R$id.role_settings_role_icon /* 2131364998 */:
                case R$id.role_settings_role_icon_divider /* 2131364999 */:
                case R$id.role_settings_role_icon_header /* 2131365000 */:
                default:
                    j = 0;
                    break;
                case R$id.role_settings_create_instant_invite /* 2131364972 */:
                    j = 1;
                    break;
                case R$id.role_settings_create_private_threads /* 2131364973 */:
                    j = Permission.CREATE_PRIVATE_THREADS;
                    break;
                case R$id.role_settings_create_public_threads /* 2131364974 */:
                    j = Permission.CREATE_PUBLIC_THREADS;
                    break;
                case R$id.role_settings_embed_links /* 2131364977 */:
                    j = Permission.EMBED_LINKS;
                    break;
                case R$id.role_settings_kick_members /* 2131364980 */:
                    j = 2;
                    break;
                case R$id.role_settings_manage_channels /* 2131364981 */:
                    j = 16;
                    break;
                case R$id.role_settings_manage_emojis_and_stickers /* 2131364982 */:
                    j = Permission.MANAGE_EMOJIS_AND_STICKERS;
                    break;
                case R$id.role_settings_manage_events /* 2131364983 */:
                    j = Permission.MANAGE_EVENTS;
                    break;
                case R$id.role_settings_manage_messages /* 2131364984 */:
                    j = Permission.MANAGE_MESSAGES;
                    break;
                case R$id.role_settings_manage_nicknames /* 2131364985 */:
                    j = Permission.MANAGE_NICKNAMES;
                    break;
                case R$id.role_settings_manage_roles /* 2131364986 */:
                    j = Permission.MANAGE_ROLES;
                    break;
                case R$id.role_settings_manage_server /* 2131364987 */:
                    j = 32;
                    break;
                case R$id.role_settings_manage_threads /* 2131364988 */:
                    j = Permission.MANAGE_THREADS;
                    break;
                case R$id.role_settings_manage_webhooks /* 2131364989 */:
                    j = Permission.MANAGE_WEBHOOKS;
                    break;
                case R$id.role_settings_mention_everyone /* 2131364990 */:
                    j = Permission.MENTION_EVERYONE;
                    break;
                case R$id.role_settings_moderate_member /* 2131364992 */:
                    j = Permission.MODERATE_MEMBERS;
                    break;
                case R$id.role_settings_priority_speaker /* 2131364994 */:
                    j = 256;
                    break;
                case R$id.role_settings_read_message_history /* 2131364995 */:
                    j = Permission.READ_MESSAGE_HISTORY;
                    break;
                case R$id.role_settings_read_messages /* 2131364996 */:
                    j = Permission.VIEW_CHANNEL;
                    break;
                case R$id.role_settings_request_to_speak /* 2131364997 */:
                    j = Permission.REQUEST_TO_SPEAK;
                    break;
                case R$id.role_settings_send_messages /* 2131365001 */:
                    j = Permission.SEND_MESSAGES;
                    break;
                case R$id.role_settings_send_messages_in_threads /* 2131365002 */:
                    j = Permission.SEND_MESSAGES_IN_THREADS;
                    break;
                case R$id.role_settings_send_tts_messages /* 2131365003 */:
                    j = Permission.SEND_TTS_MESSAGES;
                    break;
                case R$id.role_settings_use_application_commands /* 2131365004 */:
                    j = Permission.USE_APPLICATION_COMMANDS;
                    break;
                case R$id.role_settings_use_external_emojis /* 2131365005 */:
                    j = Permission.USE_EXTERNAL_EMOJIS;
                    break;
                case R$id.role_settings_use_external_stickers /* 2131365006 */:
                    j = Permission.USE_EXTERNAL_STICKERS;
                    break;
                case R$id.role_settings_view_audit_log /* 2131365007 */:
                    j = 128;
                    break;
                case R$id.role_settings_view_guild_analytics /* 2131365008 */:
                    j = Permission.VIEW_GUILD_ANALYTICS;
                    break;
                case R$id.role_settings_voice_connect /* 2131365009 */:
                    j = Permission.CONNECT;
                    break;
                case R$id.role_settings_voice_deafen_members /* 2131365010 */:
                    j = Permission.DEAFEN_MEMBERS;
                    break;
                case R$id.role_settings_voice_move_members /* 2131365011 */:
                    j = Permission.MOVE_MEMBERS;
                    break;
                case R$id.role_settings_voice_mute_members /* 2131365012 */:
                    j = Permission.MUTE_MEMBERS;
                    break;
                case R$id.role_settings_voice_speak /* 2131365013 */:
                    j = Permission.SPEAK;
                    break;
                case R$id.role_settings_voice_use_voice_activity /* 2131365014 */:
                    j = Permission.USE_VAD;
                    break;
                case R$id.role_settings_voice_video /* 2131365015 */:
                    j = 512;
                    break;
            }
            boolean zCan = PermissionUtils.can(j, Long.valueOf(data.getRole().getPermissions()));
            checkedSetting.setChecked(zCan);
            boolean zCan2 = PermissionUtils.can(j, data.getMyPermissions());
            WidgetServerSettingsEditRole$Model$ManageStatus manageStatus = data.getManageStatus();
            if (manageStatus != null) {
                int iOrdinal = manageStatus.ordinal();
                if (iOrdinal != 4) {
                    if (iOrdinal != 5) {
                        checkedSetting.c(getLockMessage(data, false));
                    } else if (!data.getOwner() && j == 8 && data.isSingular(j)) {
                        checkedSetting.b(2131891710);
                    } else {
                        enableSetting(checkedSetting, data, j);
                    }
                } else if (zCan2 && !(data.isSingular(j) && zCan)) {
                    enableSetting(checkedSetting, data, j);
                } else if (zCan2) {
                    checkedSetting.b(2131891710);
                } else {
                    checkedSetting.b(2131891706);
                }
            } else {
                checkedSetting.c(getLockMessage(data, false));
            }
            checkedSetting.setVisibility(((j > Permission.VIEW_GUILD_ANALYTICS ? 1 : (j == Permission.VIEW_GUILD_ANALYTICS ? 0 : -1)) == 0 && !data.isCommunityServer()) ^ true ? 0 : 8);
        }
        CheckedSetting checkedSetting2 = getBinding().E;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.roleSettingsModerateMember");
        checkedSetting2.setVisibility(data.getHasGuildCommunicationDisabledFeature() ? 0 : 8);
    }

    private final void setupRoleName(WidgetServerSettingsEditRole$Model data) {
        TextInputLayout textInputLayout = getBinding().f2371b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        StatefulViews statefulViews = this.state;
        TextInputLayout textInputLayout2 = getBinding().f2371b;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.editRoleName");
        ViewExtensions.setText(textInputLayout, (CharSequence) statefulViews.get(textInputLayout2.getId(), data.getRole().getName()));
        if (!data.canManage() || data.isEveryoneRole()) {
            View view = getBinding().o;
            m.checkNotNullExpressionValue(view, "binding.roleSettingsEditNameDisabledOverlay");
            view.setVisibility(0);
            getBinding().o.setOnClickListener(new WidgetServerSettingsEditRole$setupRoleName$1(this, data));
            return;
        }
        View view2 = getBinding().o;
        m.checkNotNullExpressionValue(view2, "binding.roleSettingsEditNameDisabledOverlay");
        view2.setVisibility(8);
        getBinding().o.setOnClickListener(null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.state.setupUnsavedChangesConfirmation(this);
        StatefulViews statefulViews = this.state;
        FloatingActionButton floatingActionButton = getBinding().c;
        TextInputLayout textInputLayout = getBinding().f2371b;
        m.checkNotNullExpressionValue(textInputLayout, "binding.editRoleName");
        statefulViews.setupTextWatcherWithSaveAction(this, floatingActionButton, textInputLayout);
        FloatingActionButton floatingActionButton2 = getBinding().c;
        m.checkNotNullExpressionValue(floatingActionButton2, "binding.editRoleSave");
        floatingActionButton2.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(WidgetServerSettingsEditRole$Model.Companion.get(getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L), getMostRecentIntent().getLongExtra(INTENT_EXTRA_ROLE_ID, -1L))), this, null, 2, null), WidgetServerSettingsEditRole.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsEditRole$onViewBoundOrOnResume$1(this), 62, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Fragment fragmentFindFragmentByTag = parentFragmentManager.findFragmentByTag(DIALOG_TAG_COLOR_PICKER);
        if (fragmentFindFragmentByTag != null) {
            parentFragmentManager.beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }
}
