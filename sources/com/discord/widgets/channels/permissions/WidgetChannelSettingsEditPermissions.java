package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsEditPermissionsBinding;
import com.discord.utilities.channel.ChannelPermissionUtilsKt;
import com.discord.utilities.channel.PermissionLabelOverrides;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.TernaryCheckBox;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import d0.g;
import d0.t.m0;
import d0.t.n0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions extends AppFragment {
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    private static final String INTENT_EXTRA_TYPE = "INTENT_EXTRA_TYPE";
    public static final int TYPE_ROLE = 1;
    public static final int TYPE_USER = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: permissionCheckboxes$delegate, reason: from kotlin metadata */
    private final Lazy permissionCheckboxes;
    private StatefulViews state;

    /* JADX INFO: renamed from: targetId$delegate, reason: from kotlin metadata */
    private final Lazy targetId;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    private final Lazy type;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsEditPermissions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", 0)};
    public static final WidgetChannelSettingsEditPermissions$Companion Companion = new WidgetChannelSettingsEditPermissions$Companion(null);
    private static final Set<Long> STAGE_HIDDEN_PERMISSIONS = n0.setOf((Object[]) new Long[]{512L, 256L, Long.valueOf(Permission.SPEAK), Long.valueOf(Permission.USE_VAD)});
    private static final Set<Long> STAGE_DISABLED_PERMISSIONS = m0.setOf(Long.valueOf(Permission.REQUEST_TO_SPEAK));

    public WidgetChannelSettingsEditPermissions() {
        super(R$layout.widget_channel_settings_edit_permissions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsEditPermissions$binding$2.INSTANCE, null, 2, null);
        this.permissionCheckboxes = g.lazy(new WidgetChannelSettingsEditPermissions$permissionCheckboxes$2(this));
        this.guildId = g.lazy(new WidgetChannelSettingsEditPermissions$guildId$2(this));
        this.channelId = g.lazy(new WidgetChannelSettingsEditPermissions$channelId$2(this));
        this.targetId = g.lazy(new WidgetChannelSettingsEditPermissions$targetId$2(this));
        this.type = g.lazy(new WidgetChannelSettingsEditPermissions$type$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
        widgetChannelSettingsEditPermissions.configureUI(widgetChannelSettingsEditPermissionsModel);
    }

    public static final /* synthetic */ void access$deletePermissionOverwrites(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, long j, long j2) {
        widgetChannelSettingsEditPermissions.deletePermissionOverwrites(j, j2);
    }

    public static final /* synthetic */ WidgetChannelSettingsEditPermissionsBinding access$getBinding$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getBinding();
    }

    public static final /* synthetic */ List access$getPermissionCheckboxes$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getPermissionCheckboxes();
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.state;
    }

    public static final /* synthetic */ long access$getTargetId$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        return widgetChannelSettingsEditPermissions.getTargetId();
    }

    public static final /* synthetic */ void access$setState$p(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, StatefulViews statefulViews) {
        widgetChannelSettingsEditPermissions.state = statefulViews;
    }

    public static final /* synthetic */ void access$updatePermissionOverwrites(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, long j, long j2, int i) {
        widgetChannelSettingsEditPermissions.updatePermissionOverwrites(j, j2, i);
    }

    private final void configureUI(WidgetChannelSettingsEditPermissionsModel model) {
        PermissionOverwrite permissionOverwrite;
        PermissionOverwrite next;
        Object next2;
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        List<PermissionOverwrite> listV = model.getChannel().v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
            } while (!(((PermissionOverwrite) next2).getId() == getTargetId()));
            permissionOverwrite = (PermissionOverwrite) next2;
        } else {
            permissionOverwrite = null;
        }
        int i = permissionOverwrite != null ? R$menu.menu_edit_permission_overwrite : R$menu.menu_empty;
        setActionBarTitle(ChannelUtils.k(model.getChannel()) ? 2131887472 : 2131887604);
        setActionBarSubtitle(ChannelUtils.d(model.getChannel(), requireContext(), true));
        AppFragment.setActionBarOptionsMenu$default(this, i, new WidgetChannelSettingsEditPermissions$configureUI$1(this, model), null, 4, null);
        if (model instanceof WidgetChannelSettingsEditPermissionsModel$ModelForRole) {
            SettingsMemberView settingsMemberView = getBinding().M;
            m.checkNotNullExpressionValue(settingsMemberView, "binding.memberView");
            settingsMemberView.setVisibility(8);
            TextView textView = getBinding().J;
            m.checkNotNullExpressionValue(textView, "binding.channelPermissionsTargetName");
            textView.setVisibility(0);
            WidgetChannelSettingsEditPermissions$Companion widgetChannelSettingsEditPermissions$Companion = Companion;
            TextView textView2 = getBinding().J;
            m.checkNotNullExpressionValue(textView2, "binding.channelPermissionsTargetName");
            WidgetChannelSettingsEditPermissionsModel$ModelForRole widgetChannelSettingsEditPermissionsModel$ModelForRole = (WidgetChannelSettingsEditPermissionsModel$ModelForRole) model;
            WidgetChannelSettingsEditPermissions$Companion.access$setTextWithFont(widgetChannelSettingsEditPermissions$Companion, textView2, widgetChannelSettingsEditPermissionsModel$ModelForRole.getGuildRole().getName(), 2130969396);
            getBinding().J.setTextColor(RoleUtils.getRoleColor$default(widgetChannelSettingsEditPermissionsModel$ModelForRole.getGuildRole(), requireContext(), null, 2, null));
        } else if (model instanceof WidgetChannelSettingsEditPermissionsModel$ModelForUser) {
            SettingsMemberView settingsMemberView2 = getBinding().M;
            m.checkNotNullExpressionValue(settingsMemberView2, "binding.memberView");
            settingsMemberView2.setVisibility(0);
            TextView textView3 = getBinding().J;
            m.checkNotNullExpressionValue(textView3, "binding.channelPermissionsTargetName");
            textView3.setVisibility(8);
            WidgetChannelSettingsEditPermissionsModel$ModelForUser widgetChannelSettingsEditPermissionsModel$ModelForUser = (WidgetChannelSettingsEditPermissionsModel$ModelForUser) model;
            getBinding().M.a(widgetChannelSettingsEditPermissionsModel$ModelForUser.getUser(), widgetChannelSettingsEditPermissionsModel$ModelForUser.getGuildMember());
            WidgetChannelSettingsEditPermissions$Companion widgetChannelSettingsEditPermissions$Companion2 = Companion;
            TextView textView4 = getBinding().J;
            m.checkNotNullExpressionValue(textView4, "binding.channelPermissionsTargetName");
            WidgetChannelSettingsEditPermissions$Companion.access$setTextWithFont(widgetChannelSettingsEditPermissions$Companion2, textView4, widgetChannelSettingsEditPermissionsModel$ModelForUser.getUser().getUsername(), 2130969395);
        }
        TextView textView5 = getBinding().F;
        m.checkNotNullExpressionValue(textView5, "binding.channelPermissionsChannelName");
        textView5.setText(ChannelUtils.d(model.getChannel(), requireContext(), true));
        boolean z2 = ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.Companion.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId()));
        LinearLayout linearLayout = getBinding().K;
        m.checkNotNullExpressionValue(linearLayout, "binding.channelPermissionsTextContainer");
        linearLayout.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || z2 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().L;
        m.checkNotNullExpressionValue(linearLayout2, "binding.channelPermissionsVoiceContainer");
        linearLayout2.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().I;
        m.checkNotNullExpressionValue(linearLayout3, "binding.channelPermissionsStageContainer");
        linearLayout3.setVisibility(ChannelUtils.D(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().G;
        m.checkNotNullExpressionValue(linearLayout4, "binding.channelPermissionsEventsContainer");
        linearLayout4.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        TernaryCheckBox ternaryCheckBox = getBinding().g;
        m.checkNotNullExpressionValue(ternaryCheckBox, "binding.channelPermissionGeneralManageWebhooks");
        ternaryCheckBox.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        if (ChannelUtils.k(model.getChannel())) {
            getBinding().N.setText(2131895075);
        }
        Map<Integer, PermissionLabelOverrides> categoryLabels = ChannelPermissionUtilsKt.getCategoryLabels(model.getUseNewThreadsPermissions(), requireContext());
        boolean z3 = model.getType() == 1 && model.getTargetId() == model.getChannel().getGuildId();
        List<PermissionOverwrite> listV2 = model.getChannel().v();
        m.checkNotNull(listV2);
        Iterator<PermissionOverwrite> it2 = listV2.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (next.e() != model.getTargetId());
        if (!model.getUseNewThreadsPermissions()) {
            getBinding().f2274s.setLabel(getString(2131892202));
            getBinding().f2274s.setSubtext(b.k(this, 2131892201, new Object[0], null, 4));
            getBinding().l.setLabel(getString(2131892192));
            getBinding().l.setSubtext(b.k(this, 2131892198, new Object[0], null, 4));
            getBinding().k.setLabel(getString(2131892191));
            getBinding().k.setSubtext(b.k(this, 2131892195, new Object[0], null, 4));
        }
        for (TernaryCheckBox ternaryCheckBox2 : getPermissionCheckboxes()) {
            int id2 = ternaryCheckBox2.getId();
            long jAccess$getPermission = WidgetChannelSettingsEditPermissions$Companion.access$getPermission(Companion, id2);
            if (model.getChannel().getType() == 13 && STAGE_HIDDEN_PERMISSIONS.contains(Long.valueOf(jAccess$getPermission))) {
                ternaryCheckBox2.setVisibility(8);
            }
            setupPermissionEnabledState(ternaryCheckBox2, jAccess$getPermission, model);
            setupPermissionCheckedState(ternaryCheckBox2, next);
            if (id2 == 2131362412) {
                ternaryCheckBox2.setSubtext(b.j(ternaryCheckBox2, 2131895063, new Object[]{getString(2131892475)}, null, 4));
            }
            if (id2 == 2131362395) {
                ternaryCheckBox2.setVisibility(ChannelUtils.i(model.getChannel()) ^ true ? 0 : 8);
            }
            if (id2 == 2131362389) {
                ternaryCheckBox2.setVisibility(ChannelUtils.w(model.getChannel()) ^ true ? 0 : 8);
            }
            updateCheckboxLabels(ternaryCheckBox2, model.getChannel().getType(), z3, categoryLabels.get(Integer.valueOf(id2)));
        }
        getBinding().H.setOnClickListener(new WidgetChannelSettingsEditPermissions$configureUI$2(this, model));
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
            statefulViews.configureSaveActionView(getBinding().H);
        }
    }

    public static final void createForRole(Context context, long j, long j2, long j3) {
        Companion.createForRole(context, j, j2, j3);
    }

    public static final void createForUser(Context context, long j, long j2, long j3) {
        Companion.createForUser(context, j, j2, j3);
    }

    private final void deletePermissionOverwrites(long channelId, long targetId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().deletePermissionOverwrites(channelId, targetId), false, 1, null), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1(this), 60, (Object) null);
    }

    private final WidgetChannelSettingsEditPermissionsBinding getBinding() {
        return (WidgetChannelSettingsEditPermissionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<TernaryCheckBox> getPermissionCheckboxes() {
        return (List) this.permissionCheckboxes.getValue();
    }

    private final long getTargetId() {
        return ((Number) this.targetId.getValue()).longValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void setupPermissionCheckedState(TernaryCheckBox checkBox, PermissionOverwrite permissionOverwrite) {
        long deny;
        long allow = 0;
        if (permissionOverwrite != null) {
            allow = permissionOverwrite.getAllow();
            deny = permissionOverwrite.getDeny();
        } else {
            deny = 0;
        }
        int id2 = checkBox.getId();
        long jAccess$getPermission = WidgetChannelSettingsEditPermissions$Companion.access$getPermission(Companion, id2);
        if (jAccess$getPermission == (allow & jAccess$getPermission)) {
            checkBox.f();
        } else if (jAccess$getPermission == (jAccess$getPermission & deny)) {
            checkBox.e();
        } else {
            checkBox.d();
        }
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
        }
        checkBox.setOnSwitchStatusChangedListener(new WidgetChannelSettingsEditPermissions$setupPermissionCheckedState$1(this, id2));
    }

    private final void setupPermissionEnabledState(TernaryCheckBox checkBox, long permission, WidgetChannelSettingsEditPermissionsModel model) {
        if (ChannelUtils.D(model.getChannel()) && STAGE_DISABLED_PERMISSIONS.contains(Long.valueOf(permission))) {
            checkBox.setDisabled(2131895786);
            return;
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel$ModelForUser) {
            WidgetChannelSettingsEditPermissionsModel$ModelForUser widgetChannelSettingsEditPermissionsModel$ModelForUser = (WidgetChannelSettingsEditPermissionsModel$ModelForUser) model;
            if (widgetChannelSettingsEditPermissionsModel$ModelForUser.isMe()) {
                if (checkBox.b()) {
                    checkBox.setDisabled(2131887445);
                    return;
                } else {
                    checkBox.setOffDisabled(2131887445);
                    return;
                }
            }
            if ((widgetChannelSettingsEditPermissionsModel$ModelForUser.getMyPermissionsForChannel() & permission) == permission) {
                checkBox.c();
                return;
            } else {
                checkBox.setDisabled(2131887444);
                return;
            }
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel$ModelForRole) {
            WidgetChannelSettingsEditPermissionsModel$ModelForRole widgetChannelSettingsEditPermissionsModel$ModelForRole = (WidgetChannelSettingsEditPermissionsModel$ModelForRole) model;
            if (!widgetChannelSettingsEditPermissionsModel$ModelForRole.getMeHasRole()) {
                checkBox.setEnabled((widgetChannelSettingsEditPermissionsModel$ModelForRole.getMyPermissionsForChannel() & permission) == permission);
                return;
            }
            int i = checkBox.switchStatus;
            if (i == 0) {
                if (widgetChannelSettingsEditPermissionsModel$ModelForRole.canDenyRolePermission(permission)) {
                    checkBox.c();
                    return;
                } else if ((widgetChannelSettingsEditPermissionsModel$ModelForRole.getMyPermissionsForChannel() & permission) == permission) {
                    checkBox.setOffDisabled(2131887446);
                    return;
                } else {
                    checkBox.setOffDisabled(2131887444);
                    return;
                }
            }
            if (i == -1) {
                checkBox.c();
                return;
            }
            if (checkBox.b()) {
                if (!widgetChannelSettingsEditPermissionsModel$ModelForRole.canNeutralizeRolePermission(permission)) {
                    checkBox.setDisabled(2131887446);
                    return;
                }
                if (widgetChannelSettingsEditPermissionsModel$ModelForRole.canNeutralizeRolePermission(permission) && !widgetChannelSettingsEditPermissionsModel$ModelForRole.canDenyRolePermission(permission)) {
                    checkBox.setOffDisabled(2131887446);
                } else if (widgetChannelSettingsEditPermissionsModel$ModelForRole.canNeutralizeRolePermission(permission) && widgetChannelSettingsEditPermissionsModel$ModelForRole.canDenyRolePermission(permission)) {
                    checkBox.c();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    private final void updateCheckboxLabels(TernaryCheckBox checkBox, int channelType, boolean isEveryoneRole, PermissionLabelOverrides labels) {
        CharSequence textChannelEveryoneSubtext;
        if (labels != null) {
            CharSequence categoryEveryoneSubtext = null;
            if (channelType != 0) {
                if (channelType == 2) {
                    textChannelEveryoneSubtext = isEveryoneRole ? labels.getVoiceChannelEveryoneSubtext() : null;
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getVoiceChannelSubtext();
                    }
                } else if (channelType == 13) {
                    if (isEveryoneRole) {
                        textChannelEveryoneSubtext = labels.getStageChannelEveryoneSubtext();
                        if (textChannelEveryoneSubtext == null) {
                            textChannelEveryoneSubtext = labels.getVoiceChannelEveryoneSubtext();
                        }
                    } else {
                        textChannelEveryoneSubtext = null;
                    }
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getStageChannelSubtext();
                    }
                    if (textChannelEveryoneSubtext == null) {
                        textChannelEveryoneSubtext = labels.getVoiceChannelSubtext();
                    }
                } else if (channelType == 4) {
                    String categoryLabel = labels.getCategoryLabel();
                    categoryEveryoneSubtext = isEveryoneRole ? labels.getCategoryEveryoneSubtext() : null;
                    if (categoryEveryoneSubtext == null) {
                        categoryEveryoneSubtext = labels.getCategorySubtext();
                    }
                    CharSequence charSequence = categoryEveryoneSubtext;
                    categoryEveryoneSubtext = categoryLabel;
                    textChannelEveryoneSubtext = charSequence;
                } else if (channelType != 5) {
                    textChannelEveryoneSubtext = null;
                } else {
                    textChannelEveryoneSubtext = labels.getAnnouncementChannelSubtext();
                    LinkifiedTextView linkifiedTextView = checkBox.binding.f;
                    m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
                    linkifiedTextView.setMovementMethod(LinkMovementMethod.getInstance());
                }
            } else if (isEveryoneRole) {
                textChannelEveryoneSubtext = labels.getTextChannelEveryoneSubtext();
            } else {
                textChannelEveryoneSubtext = null;
            }
            if (categoryEveryoneSubtext != null) {
                checkBox.setLabel(categoryEveryoneSubtext);
            }
            if (textChannelEveryoneSubtext != null) {
                checkBox.setSubtext(textChannelEveryoneSubtext);
            }
        }
    }

    private final void updatePermissionOverwrites(long channelId, long targetId, int type) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updatePermissionOverwrites(channelId, targetId, new WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1(this, type, targetId).invoke()), false, 1, null), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$2.INSTANCE, 60, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        StatefulViews statefulViews = new StatefulViews(getPermissionCheckboxes());
        this.state = statefulViews;
        if (statefulViews != null) {
            statefulViews.setupUnsavedChangesConfirmation(this);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetChannelSettingsEditPermissionsModel.Companion.get(getGuildId(), getChannelId(), getTargetId(), getType()), this, null, 2, null), WidgetChannelSettingsEditPermissions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
