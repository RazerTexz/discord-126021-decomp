package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsEditPermissionsBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelPermissionUtilsKt;
import com.discord.utilities.channel.PermissionLabelOverrides;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.TernaryCheckBox;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action2;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChannelSettingsEditPermissions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Long> STAGE_HIDDEN_PERMISSIONS = C12148n0.setOf((Object[]) new Long[]{512L, 256L, Long.valueOf(Permission.SPEAK), Long.valueOf(Permission.USE_VAD)});
    private static final Set<Long> STAGE_DISABLED_PERMISSIONS = C12146m0.setOf(Long.valueOf(Permission.REQUEST_TO_SPEAK));

    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void create(Context context, long guildId, long channelId, long targetId, int type) {
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetChannelSettingsEditPermissions.INTENT_EXTRA_CHANNEL_ID, channelId);
            intent.putExtra("INTENT_EXTRA_TARGET_ID", targetId);
            intent.putExtra(WidgetChannelSettingsEditPermissions.INTENT_EXTRA_TYPE, type);
            C0870j.m156d(context, WidgetChannelSettingsEditPermissions.class, intent);
        }

        @SuppressLint({"NonConstantResourceId"})
        private final long getPermission(@IdRes int permissionSettingId) {
            switch (permissionSettingId) {
                case C5419R.id.channel_permission_events_manage_events /* 2131362385 */:
                    return Permission.MANAGE_EVENTS;
                case C5419R.id.channel_permission_general_create_instant_invite /* 2131362386 */:
                    return 1L;
                case C5419R.id.channel_permission_general_manage_channel /* 2131362387 */:
                    return 16L;
                case C5419R.id.channel_permission_general_manage_permissions /* 2131362388 */:
                    return Permission.MANAGE_ROLES;
                case C5419R.id.channel_permission_general_manage_threads /* 2131362389 */:
                    return Permission.MANAGE_THREADS;
                case C5419R.id.channel_permission_general_manage_webhooks /* 2131362390 */:
                    return Permission.MANAGE_WEBHOOKS;
                case C5419R.id.channel_permission_owner_view /* 2131362391 */:
                default:
                    throw new IllegalArgumentException(C1643a.m871q("Invalid ID: ", permissionSettingId));
                case C5419R.id.channel_permission_stage_request_to_speak /* 2131362392 */:
                    return Permission.REQUEST_TO_SPEAK;
                case C5419R.id.channel_permission_text_add_reactions /* 2131362393 */:
                    return 64L;
                case C5419R.id.channel_permission_text_attach_files /* 2131362394 */:
                    return Permission.ATTACH_FILES;
                case C5419R.id.channel_permission_text_create_private_threads /* 2131362395 */:
                    return Permission.CREATE_PRIVATE_THREADS;
                case C5419R.id.channel_permission_text_create_public_threads /* 2131362396 */:
                    return Permission.CREATE_PUBLIC_THREADS;
                case C5419R.id.channel_permission_text_embed_links /* 2131362397 */:
                    return Permission.EMBED_LINKS;
                case C5419R.id.channel_permission_text_manage_messages /* 2131362398 */:
                    return Permission.MANAGE_MESSAGES;
                case C5419R.id.channel_permission_text_mention_everyone /* 2131362399 */:
                    return Permission.MENTION_EVERYONE;
                case C5419R.id.channel_permission_text_read_message_history /* 2131362400 */:
                    return Permission.READ_MESSAGE_HISTORY;
                case C5419R.id.channel_permission_text_read_messages /* 2131362401 */:
                    return Permission.VIEW_CHANNEL;
                case C5419R.id.channel_permission_text_send_messages /* 2131362402 */:
                    return Permission.SEND_MESSAGES;
                case C5419R.id.channel_permission_text_send_messages_in_threads /* 2131362403 */:
                    return Permission.SEND_MESSAGES_IN_THREADS;
                case C5419R.id.channel_permission_text_send_tts_messages /* 2131362404 */:
                    return Permission.SEND_TTS_MESSAGES;
                case C5419R.id.channel_permission_text_use_external_emojis /* 2131362405 */:
                    return Permission.USE_EXTERNAL_EMOJIS;
                case C5419R.id.channel_permission_text_use_external_stickers /* 2131362406 */:
                    return Permission.USE_EXTERNAL_STICKERS;
                case C5419R.id.channel_permission_use_application_commands /* 2131362407 */:
                    return Permission.USE_APPLICATION_COMMANDS;
                case C5419R.id.channel_permission_voice_connect /* 2131362408 */:
                    return Permission.CONNECT;
                case C5419R.id.channel_permission_voice_deafen_members /* 2131362409 */:
                    return Permission.DEAFEN_MEMBERS;
                case C5419R.id.channel_permission_voice_move_members /* 2131362410 */:
                    return Permission.MOVE_MEMBERS;
                case C5419R.id.channel_permission_voice_mute_members /* 2131362411 */:
                    return Permission.MUTE_MEMBERS;
                case C5419R.id.channel_permission_voice_priority_speaker /* 2131362412 */:
                    return 256L;
                case C5419R.id.channel_permission_voice_speak /* 2131362413 */:
                    return Permission.SPEAK;
                case C5419R.id.channel_permission_voice_use_vad /* 2131362414 */:
                    return Permission.USE_VAD;
                case C5419R.id.channel_permission_voice_video /* 2131362415 */:
                    return 512L;
            }
        }

        private final void setTextWithFont(TextView textView, String str, @AttrRes int i) {
            FontUtils fontUtils = FontUtils.INSTANCE;
            Context context = textView.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            Typeface themedFont = fontUtils.getThemedFont(context, i);
            if (themedFont != null) {
                TypefaceSpanCompat typefaceSpanCompat = new TypefaceSpanCompat(themedFont);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(typefaceSpanCompat, 0, spannableStringBuilder.length(), 33);
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            }
        }

        public final void createForRole(Context context, long guildId, long channelId, long targetId) {
            C12238m.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 1);
        }

        public final void createForUser(Context context, long guildId, long channelId, long targetId) {
            C12238m.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class C75381 extends AbstractC12240o implements Function1<Void, Unit> {
        public C75381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) throws Exception {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) throws Exception {
            StatefulViews statefulViews = WidgetChannelSettingsEditPermissions.this.state;
            if (statefulViews != null) {
                StatefulViews.clear$default(statefulViews, false, 1, null);
            }
            AppActivity appActivity = WidgetChannelSettingsEditPermissions.this.getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final /* synthetic */ class C75391 extends C12236k implements Function1<WidgetChannelSettingsEditPermissionsModel, Unit> {
        public C75391(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
            super(1, widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            invoke2(widgetChannelSettingsEditPermissionsModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            ((WidgetChannelSettingsEditPermissions) this.receiver).configureUI(widgetChannelSettingsEditPermissionsModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class C75411 extends AbstractC12240o implements Function0<RestAPIParams.ChannelPermissionOverwrites> {
        public final /* synthetic */ long $targetId;
        public final /* synthetic */ int $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C75411(int i, long j) {
            super(0);
            this.$type = i;
            this.$targetId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RestAPIParams.ChannelPermissionOverwrites invoke() {
            Iterator it = WidgetChannelSettingsEditPermissions.this.getPermissionCheckboxes().iterator();
            long permission = 0;
            long permission2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) it.next();
                if (ternaryCheckBox.m8559b()) {
                    permission |= WidgetChannelSettingsEditPermissions.INSTANCE.getPermission(ternaryCheckBox.getId());
                } else {
                    if (ternaryCheckBox.switchStatus == -1) {
                        permission2 |= WidgetChannelSettingsEditPermissions.INSTANCE.getPermission(ternaryCheckBox.getId());
                    }
                }
            }
            return this.$type == 1 ? RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(this.$targetId, Long.valueOf(permission), Long.valueOf(permission2)) : RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForMember(this.$targetId, Long.valueOf(permission), Long.valueOf(permission2));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class C75422 extends AbstractC12240o implements Function1<Void, Unit> {
        public static final C75422 INSTANCE = new C75422();

        public C75422() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelSettingsEditPermissions() {
        super(C5419R.layout.widget_channel_settings_edit_permissions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsEditPermissions$binding$2.INSTANCE, null, 2, null);
        this.permissionCheckboxes = C12083g.lazy(new WidgetChannelSettingsEditPermissions$permissionCheckboxes$2(this));
        this.guildId = C12083g.lazy(new WidgetChannelSettingsEditPermissions$guildId$2(this));
        this.channelId = C12083g.lazy(new WidgetChannelSettingsEditPermissions$channelId$2(this));
        this.targetId = C12083g.lazy(new WidgetChannelSettingsEditPermissions$targetId$2(this));
        this.type = C12083g.lazy(new WidgetChannelSettingsEditPermissions$type$2(this));
    }

    private final void configureUI(final WidgetChannelSettingsEditPermissionsModel model) {
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
        List<PermissionOverwrite> listM7655v = model.getChannel().m7655v();
        if (listM7655v != null) {
            Iterator<T> it = listM7655v.iterator();
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
        int i = permissionOverwrite != null ? C5419R.menu.menu_edit_permission_overwrite : C5419R.menu.menu_empty;
        setActionBarTitle(ChannelUtils.m7687k(model.getChannel()) ? C5419R.string.category_settings : C5419R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.m7680d(model.getChannel(), requireContext(), true));
        AppFragment.setActionBarOptionsMenu$default(this, i, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.configureUI.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_edit_overwrite_delete) {
                    return;
                }
                WidgetChannelSettingsEditPermissions.this.deletePermissionOverwrites(model.getChannel().getId(), WidgetChannelSettingsEditPermissions.this.getTargetId());
            }
        }, null, 4, null);
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForRole) {
            SettingsMemberView settingsMemberView = getBinding().f15920M;
            C12238m.checkNotNullExpressionValue(settingsMemberView, "binding.memberView");
            settingsMemberView.setVisibility(8);
            TextView textView = getBinding().f15917J;
            C12238m.checkNotNullExpressionValue(textView, "binding.channelPermissionsTargetName");
            textView.setVisibility(0);
            Companion companion = INSTANCE;
            TextView textView2 = getBinding().f15917J;
            C12238m.checkNotNullExpressionValue(textView2, "binding.channelPermissionsTargetName");
            WidgetChannelSettingsEditPermissionsModel.ModelForRole modelForRole = (WidgetChannelSettingsEditPermissionsModel.ModelForRole) model;
            companion.setTextWithFont(textView2, modelForRole.getGuildRole().getName(), C5419R.attr.font_primary_semibold);
            getBinding().f15917J.setTextColor(RoleUtils.getRoleColor$default(modelForRole.getGuildRole(), requireContext(), null, 2, null));
        } else if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            SettingsMemberView settingsMemberView2 = getBinding().f15920M;
            C12238m.checkNotNullExpressionValue(settingsMemberView2, "binding.memberView");
            settingsMemberView2.setVisibility(0);
            TextView textView3 = getBinding().f15917J;
            C12238m.checkNotNullExpressionValue(textView3, "binding.channelPermissionsTargetName");
            textView3.setVisibility(8);
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            getBinding().f15920M.m8621a(modelForUser.getUser(), modelForUser.getGuildMember());
            Companion companion2 = INSTANCE;
            TextView textView4 = getBinding().f15917J;
            C12238m.checkNotNullExpressionValue(textView4, "binding.channelPermissionsTargetName");
            companion2.setTextWithFont(textView4, modelForUser.getUser().getUsername(), C5419R.attr.font_primary_normal);
        }
        TextView textView5 = getBinding().f15913F;
        C12238m.checkNotNullExpressionValue(textView5, "binding.channelPermissionsChannelName");
        textView5.setText(ChannelUtils.m7680d(model.getChannel(), requireContext(), true));
        boolean z2 = ChannelUtils.m7675J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId()));
        LinearLayout linearLayout = getBinding().f15918K;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.channelPermissionsTextContainer");
        linearLayout.setVisibility(ChannelUtils.m7698v(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) || z2 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().f15919L;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.channelPermissionsVoiceContainer");
        linearLayout2.setVisibility(ChannelUtils.m7699w(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().f15916I;
        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.channelPermissionsStageContainer");
        linearLayout3.setVisibility(ChannelUtils.m7669D(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().f15914G;
        C12238m.checkNotNullExpressionValue(linearLayout4, "binding.channelPermissionsEventsContainer");
        linearLayout4.setVisibility(ChannelUtils.m7699w(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        TernaryCheckBox ternaryCheckBox = getBinding().f15928g;
        C12238m.checkNotNullExpressionValue(ternaryCheckBox, "binding.channelPermissionGeneralManageWebhooks");
        ternaryCheckBox.setVisibility(ChannelUtils.m7698v(model.getChannel()) || ChannelUtils.m7687k(model.getChannel()) ? 0 : 8);
        if (ChannelUtils.m7687k(model.getChannel())) {
            getBinding().f15921N.setText(C5419R.string.role_permissions_section_general_category);
        }
        Map<Integer, PermissionLabelOverrides> categoryLabels = ChannelPermissionUtilsKt.getCategoryLabels(model.getUseNewThreadsPermissions(), requireContext());
        boolean z3 = model.getType() == 1 && model.getTargetId() == model.getChannel().getGuildId();
        List<PermissionOverwrite> listM7655v2 = model.getChannel().m7655v();
        C12238m.checkNotNull(listM7655v2);
        Iterator<PermissionOverwrite> it2 = listM7655v2.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (next.m8131e() != model.getTargetId());
        if (!model.getUseNewThreadsPermissions()) {
            getBinding().f15940s.setLabel(getString(C5419R.string.interim_send_messages_in_threads));
            getBinding().f15940s.setSubtext(C1107b.m213e(this, C5419R.string.f14772xa26a6cbf, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            getBinding().f15933l.setLabel(getString(C5419R.string.interim_create_public_threads));
            getBinding().f15933l.setSubtext(C1107b.m213e(this, C5419R.string.interim_role_permissions_create_public_threads_description_text, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            getBinding().f15932k.setLabel(getString(C5419R.string.interim_create_private_threads));
            getBinding().f15932k.setSubtext(C1107b.m213e(this, C5419R.string.interim_role_permissions_create_private_threads_description_text, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        }
        for (TernaryCheckBox ternaryCheckBox2 : getPermissionCheckboxes()) {
            int id2 = ternaryCheckBox2.getId();
            long permission = INSTANCE.getPermission(id2);
            if (model.getChannel().getType() == 13 && STAGE_HIDDEN_PERMISSIONS.contains(Long.valueOf(permission))) {
                ternaryCheckBox2.setVisibility(8);
            }
            setupPermissionEnabledState(ternaryCheckBox2, permission, model);
            setupPermissionCheckedState(ternaryCheckBox2, next);
            if (id2 == C5419R.id.channel_permission_voice_priority_speaker) {
                ternaryCheckBox2.setSubtext(C1107b.m212d(ternaryCheckBox2, C5419R.string.role_permissions_priority_speaker_description_voice_mobile, new Object[]{getString(C5419R.string.keybind_push_to_talk_priority)}, (4 & 4) != 0 ? C1107b.c.f1492j : null));
            }
            if (id2 == C5419R.id.channel_permission_text_create_private_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.m7685i(model.getChannel()) ^ true ? 0 : 8);
            }
            if (id2 == C5419R.id.channel_permission_general_manage_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.m7699w(model.getChannel()) ^ true ? 0 : 8);
            }
            updateCheckboxLabels(ternaryCheckBox2, model.getChannel().getType(), z3, categoryLabels.get(Integer.valueOf(id2)));
        }
        getBinding().f15915H.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsEditPermissions.this.updatePermissionOverwrites(model.getChannel().getId(), model.getTargetId(), model.getType());
            }
        });
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
            statefulViews.configureSaveActionView(getBinding().f15915H);
        }
    }

    public static final void createForRole(Context context, long j, long j2, long j3) {
        INSTANCE.createForRole(context, j, j2, j3);
    }

    public static final void createForUser(Context context, long j, long j2, long j3) {
        INSTANCE.createForUser(context, j, j2, j3);
    }

    private final void deletePermissionOverwrites(long channelId, long targetId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePermissionOverwrites(channelId, targetId), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75381());
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
        final int id2 = checkBox.getId();
        long permission = INSTANCE.getPermission(id2);
        if (permission == (allow & permission)) {
            checkBox.m8563f();
        } else if (permission == (permission & deny)) {
            checkBox.m8562e();
        } else {
            checkBox.m8561d();
        }
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
        }
        checkBox.setOnSwitchStatusChangedListener(new TernaryCheckBox.InterfaceC7094b() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.setupPermissionCheckedState.1
            @Override // com.discord.views.TernaryCheckBox.InterfaceC7094b
            public void onSwitchStatusChanged(int switchStatus) {
                StatefulViews statefulViews2 = WidgetChannelSettingsEditPermissions.this.state;
                if (statefulViews2 != null) {
                    statefulViews2.put(id2, Integer.valueOf(switchStatus));
                }
                StatefulViews statefulViews3 = WidgetChannelSettingsEditPermissions.this.state;
                if (statefulViews3 != null) {
                    statefulViews3.configureSaveActionView(WidgetChannelSettingsEditPermissions.this.getBinding().f15915H);
                }
            }
        });
    }

    private final void setupPermissionEnabledState(TernaryCheckBox checkBox, long permission, WidgetChannelSettingsEditPermissionsModel model) {
        if (ChannelUtils.m7669D(model.getChannel()) && STAGE_DISABLED_PERMISSIONS.contains(Long.valueOf(permission))) {
            checkBox.setDisabled(C5419R.string.stage_channel_cannot_overwrite_permission);
            return;
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            if (modelForUser.isMe()) {
                if (checkBox.m8559b()) {
                    checkBox.setDisabled(C5419R.string.cannot_deny_self_simple);
                    return;
                } else {
                    checkBox.setOffDisabled(C5419R.string.cannot_deny_self_simple);
                    return;
                }
            }
            if ((modelForUser.getMyPermissionsForChannel() & permission) == permission) {
                checkBox.m8560c();
                return;
            } else {
                checkBox.setDisabled(C5419R.string.cannot_deny_missing_permission);
                return;
            }
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForRole) {
            WidgetChannelSettingsEditPermissionsModel.ModelForRole modelForRole = (WidgetChannelSettingsEditPermissionsModel.ModelForRole) model;
            if (!modelForRole.getMeHasRole()) {
                checkBox.setEnabled((modelForRole.getMyPermissionsForChannel() & permission) == permission);
                return;
            }
            int i = checkBox.switchStatus;
            if (i == 0) {
                if (modelForRole.canDenyRolePermission(permission)) {
                    checkBox.m8560c();
                    return;
                } else if ((modelForRole.getMyPermissionsForChannel() & permission) == permission) {
                    checkBox.setOffDisabled(C5419R.string.cannot_deny_singular_permission);
                    return;
                } else {
                    checkBox.setOffDisabled(C5419R.string.cannot_deny_missing_permission);
                    return;
                }
            }
            if (i == -1) {
                checkBox.m8560c();
                return;
            }
            if (checkBox.m8559b()) {
                if (!modelForRole.canNeutralizeRolePermission(permission)) {
                    checkBox.setDisabled(C5419R.string.cannot_deny_singular_permission);
                    return;
                }
                if (modelForRole.canNeutralizeRolePermission(permission) && !modelForRole.canDenyRolePermission(permission)) {
                    checkBox.setOffDisabled(C5419R.string.cannot_deny_singular_permission);
                } else if (modelForRole.canNeutralizeRolePermission(permission) && modelForRole.canDenyRolePermission(permission)) {
                    checkBox.m8560c();
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
                    LinkifiedTextView linkifiedTextView = checkBox.binding.f675f;
                    C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(channelId, targetId, new C75411(type, targetId).invoke()), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C75422.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(WidgetChannelSettingsEditPermissionsModel.INSTANCE.get(getGuildId(), getChannelId(), getTargetId(), getType()), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75391(this));
    }
}
