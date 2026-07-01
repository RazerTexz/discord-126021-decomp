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
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsEditPermissionsBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelPermissionUtils;
import com.discord.utilities.channel.ChannelPermissionUtils2;
import com.discord.utilities.error.Error;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.TernaryCheckBox;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissionsModel;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import d0.LazyJVM;
import d0.t.Sets5;
import d0.t.SetsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Subscription;
import rx.functions.Action2;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSettingsEditPermissions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsEditPermissionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Long> STAGE_HIDDEN_PERMISSIONS = Sets5.setOf((Object[]) new Long[]{512L, 256L, Long.valueOf(Permission.SPEAK), Long.valueOf(Permission.USE_VAD)});
    private static final Set<Long> STAGE_DISABLED_PERMISSIONS = SetsJVM.setOf(Long.valueOf(Permission.REQUEST_TO_SPEAK));

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
            AppScreen2.d(context, WidgetChannelSettingsEditPermissions.class, intent);
        }

        @SuppressLint({"NonConstantResourceId"})
        private final long getPermission(@IdRes int permissionSettingId) {
            switch (permissionSettingId) {
                case R.id.channel_permission_events_manage_events /* 2131362385 */:
                    return Permission.MANAGE_EVENTS;
                case R.id.channel_permission_general_create_instant_invite /* 2131362386 */:
                    return 1L;
                case R.id.channel_permission_general_manage_channel /* 2131362387 */:
                    return 16L;
                case R.id.channel_permission_general_manage_permissions /* 2131362388 */:
                    return Permission.MANAGE_ROLES;
                case R.id.channel_permission_general_manage_threads /* 2131362389 */:
                    return Permission.MANAGE_THREADS;
                case R.id.channel_permission_general_manage_webhooks /* 2131362390 */:
                    return Permission.MANAGE_WEBHOOKS;
                case R.id.channel_permission_owner_view /* 2131362391 */:
                default:
                    throw new IllegalArgumentException(outline.q("Invalid ID: ", permissionSettingId));
                case R.id.channel_permission_stage_request_to_speak /* 2131362392 */:
                    return Permission.REQUEST_TO_SPEAK;
                case R.id.channel_permission_text_add_reactions /* 2131362393 */:
                    return 64L;
                case R.id.channel_permission_text_attach_files /* 2131362394 */:
                    return Permission.ATTACH_FILES;
                case R.id.channel_permission_text_create_private_threads /* 2131362395 */:
                    return Permission.CREATE_PRIVATE_THREADS;
                case R.id.channel_permission_text_create_public_threads /* 2131362396 */:
                    return Permission.CREATE_PUBLIC_THREADS;
                case R.id.channel_permission_text_embed_links /* 2131362397 */:
                    return Permission.EMBED_LINKS;
                case R.id.channel_permission_text_manage_messages /* 2131362398 */:
                    return Permission.MANAGE_MESSAGES;
                case R.id.channel_permission_text_mention_everyone /* 2131362399 */:
                    return Permission.MENTION_EVERYONE;
                case R.id.channel_permission_text_read_message_history /* 2131362400 */:
                    return Permission.READ_MESSAGE_HISTORY;
                case R.id.channel_permission_text_read_messages /* 2131362401 */:
                    return Permission.VIEW_CHANNEL;
                case R.id.channel_permission_text_send_messages /* 2131362402 */:
                    return Permission.SEND_MESSAGES;
                case R.id.channel_permission_text_send_messages_in_threads /* 2131362403 */:
                    return Permission.SEND_MESSAGES_IN_THREADS;
                case R.id.channel_permission_text_send_tts_messages /* 2131362404 */:
                    return Permission.SEND_TTS_MESSAGES;
                case R.id.channel_permission_text_use_external_emojis /* 2131362405 */:
                    return Permission.USE_EXTERNAL_EMOJIS;
                case R.id.channel_permission_text_use_external_stickers /* 2131362406 */:
                    return Permission.USE_EXTERNAL_STICKERS;
                case R.id.channel_permission_use_application_commands /* 2131362407 */:
                    return Permission.USE_APPLICATION_COMMANDS;
                case R.id.channel_permission_voice_connect /* 2131362408 */:
                    return Permission.CONNECT;
                case R.id.channel_permission_voice_deafen_members /* 2131362409 */:
                    return Permission.DEAFEN_MEMBERS;
                case R.id.channel_permission_voice_move_members /* 2131362410 */:
                    return Permission.MOVE_MEMBERS;
                case R.id.channel_permission_voice_mute_members /* 2131362411 */:
                    return Permission.MUTE_MEMBERS;
                case R.id.channel_permission_voice_priority_speaker /* 2131362412 */:
                    return 256L;
                case R.id.channel_permission_voice_speak /* 2131362413 */:
                    return Permission.SPEAK;
                case R.id.channel_permission_voice_use_vad /* 2131362414 */:
                    return Permission.USE_VAD;
                case R.id.channel_permission_voice_video /* 2131362415 */:
                    return 512L;
            }
        }

        private final void setTextWithFont(TextView textView, String str, @AttrRes int i) {
            FontUtils fontUtils = FontUtils.INSTANCE;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            Typeface themedFont = fontUtils.getThemedFont(context, i);
            if (themedFont != null) {
                TypefaceSpanCompat typefaceSpanCompat = new TypefaceSpanCompat(themedFont);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                spannableStringBuilder.setSpan(typefaceSpanCompat, 0, spannableStringBuilder.length(), 33);
                textView.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
            }
        }

        public final void createForRole(Context context, long guildId, long channelId, long targetId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 1);
        }

        public final void createForUser(Context context, long guildId, long channelId, long targetId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            create(context, guildId, channelId, targetId, 0);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$deletePermissionOverwrites$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) throws Exception {
            invoke2(r1);
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetChannelSettingsEditPermissionsModel, Unit> {
        public AnonymousClass1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
            super(1, widgetChannelSettingsEditPermissions, WidgetChannelSettingsEditPermissions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/permissions/WidgetChannelSettingsEditPermissionsModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            invoke2(widgetChannelSettingsEditPermissionsModel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsEditPermissionsModel widgetChannelSettingsEditPermissionsModel) {
            ((WidgetChannelSettingsEditPermissions) this.receiver).configureUI(widgetChannelSettingsEditPermissionsModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<RestAPIParams.ChannelPermissionOverwrites> {
        public final /* synthetic */ long $targetId;
        public final /* synthetic */ int $type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, long j) {
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
                if (ternaryCheckBox.b()) {
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
        }
    }

    public WidgetChannelSettingsEditPermissions() {
        super(R.layout.widget_channel_settings_edit_permissions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsEditPermissions2.INSTANCE, null, 2, null);
        this.permissionCheckboxes = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions5(this));
        this.guildId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions4(this));
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions3(this));
        this.targetId = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions6(this));
        this.type = LazyJVM.lazy(new WidgetChannelSettingsEditPermissions7(this));
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
        int i = permissionOverwrite != null ? R.menu.menu_edit_permission_overwrite : R.menu.menu_empty;
        setActionBarTitle(ChannelUtils.k(model.getChannel()) ? R.string.category_settings : R.string.channel_settings);
        setActionBarSubtitle(ChannelUtils.d(model.getChannel(), requireContext(), true));
        AppFragment.setActionBarOptionsMenu$default(this, i, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.configureUI.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_edit_overwrite_delete) {
                    return;
                }
                WidgetChannelSettingsEditPermissions.this.deletePermissionOverwrites(model.getChannel().getId(), WidgetChannelSettingsEditPermissions.this.getTargetId());
            }
        }, null, 4, null);
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForRole) {
            SettingsMemberView settingsMemberView = getBinding().M;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.memberView");
            settingsMemberView.setVisibility(8);
            TextView textView = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelPermissionsTargetName");
            textView.setVisibility(0);
            Companion companion = INSTANCE;
            TextView textView2 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.channelPermissionsTargetName");
            WidgetChannelSettingsEditPermissionsModel.ModelForRole modelForRole = (WidgetChannelSettingsEditPermissionsModel.ModelForRole) model;
            companion.setTextWithFont(textView2, modelForRole.getGuildRole().getName(), R.attr.font_primary_semibold);
            getBinding().J.setTextColor(RoleUtils.getRoleColor$default(modelForRole.getGuildRole(), requireContext(), null, 2, null));
        } else if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            SettingsMemberView settingsMemberView2 = getBinding().M;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView2, "binding.memberView");
            settingsMemberView2.setVisibility(0);
            TextView textView3 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelPermissionsTargetName");
            textView3.setVisibility(8);
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            getBinding().M.a(modelForUser.getUser(), modelForUser.getGuildMember());
            Companion companion2 = INSTANCE;
            TextView textView4 = getBinding().J;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelPermissionsTargetName");
            companion2.setTextWithFont(textView4, modelForUser.getUser().getUsername(), R.attr.font_primary_normal);
        }
        TextView textView5 = getBinding().F;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.channelPermissionsChannelName");
        textView5.setText(ChannelUtils.d(model.getChannel(), requireContext(), true));
        boolean z2 = ChannelUtils.J(model.getChannel()) && TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(model.getChannel().getGuildId()));
        LinearLayout linearLayout = getBinding().K;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelPermissionsTextContainer");
        linearLayout.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) || z2 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().L;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.channelPermissionsVoiceContainer");
        linearLayout2.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().I;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.channelPermissionsStageContainer");
        linearLayout3.setVisibility(ChannelUtils.D(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        LinearLayout linearLayout4 = getBinding().G;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.channelPermissionsEventsContainer");
        linearLayout4.setVisibility(ChannelUtils.w(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        TernaryCheckBox ternaryCheckBox = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(ternaryCheckBox, "binding.channelPermissionGeneralManageWebhooks");
        ternaryCheckBox.setVisibility(ChannelUtils.v(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        if (ChannelUtils.k(model.getChannel())) {
            getBinding().N.setText(R.string.role_permissions_section_general_category);
        }
        Map<Integer, ChannelPermissionUtils2> categoryLabels = ChannelPermissionUtils.getCategoryLabels(model.getUseNewThreadsPermissions(), requireContext());
        boolean z3 = model.getType() == 1 && model.getTargetId() == model.getChannel().getGuildId();
        List<PermissionOverwrite> listV2 = model.getChannel().v();
        Intrinsics3.checkNotNull(listV2);
        Iterator<PermissionOverwrite> it2 = listV2.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (next.e() != model.getTargetId());
        if (!model.getUseNewThreadsPermissions()) {
            getBinding().f2274s.setLabel(getString(R.string.interim_send_messages_in_threads));
            getBinding().f2274s.setSubtext(FormatUtils.e(this, R.string.interim_role_permissions_send_messages_in_threads_description_text, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            getBinding().l.setLabel(getString(R.string.interim_create_public_threads));
            getBinding().l.setSubtext(FormatUtils.e(this, R.string.interim_role_permissions_create_public_threads_description_text, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            getBinding().k.setLabel(getString(R.string.interim_create_private_threads));
            getBinding().k.setSubtext(FormatUtils.e(this, R.string.interim_role_permissions_create_private_threads_description_text, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        for (TernaryCheckBox ternaryCheckBox2 : getPermissionCheckboxes()) {
            int id2 = ternaryCheckBox2.getId();
            long permission = INSTANCE.getPermission(id2);
            if (model.getChannel().getType() == 13 && STAGE_HIDDEN_PERMISSIONS.contains(Long.valueOf(permission))) {
                ternaryCheckBox2.setVisibility(8);
            }
            setupPermissionEnabledState(ternaryCheckBox2, permission, model);
            setupPermissionCheckedState(ternaryCheckBox2, next);
            if (id2 == R.id.channel_permission_voice_priority_speaker) {
                ternaryCheckBox2.setSubtext(FormatUtils.d(ternaryCheckBox2, R.string.role_permissions_priority_speaker_description_voice_mobile, new Object[]{getString(R.string.keybind_push_to_talk_priority)}, (4 & 4) != 0 ? FormatUtils.c.j : null));
            }
            if (id2 == R.id.channel_permission_text_create_private_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.i(model.getChannel()) ^ true ? 0 : 8);
            }
            if (id2 == R.id.channel_permission_general_manage_threads) {
                ternaryCheckBox2.setVisibility(ChannelUtils.w(model.getChannel()) ^ true ? 0 : 8);
            }
            updateCheckboxLabels(ternaryCheckBox2, model.getChannel().getType(), z3, categoryLabels.get(Integer.valueOf(id2)));
        }
        getBinding().H.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSettingsEditPermissions.this.updatePermissionOverwrites(model.getChannel().getId(), model.getTargetId(), model.getType());
            }
        });
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
            statefulViews.configureSaveActionView(getBinding().H);
        }
    }

    public static final void createForRole(Context context, long j, long j2, long j3) {
        INSTANCE.createForRole(context, j, j2, j3);
    }

    public static final void createForUser(Context context, long j, long j2, long j3) {
        INSTANCE.createForUser(context, j, j2, j3);
    }

    private final void deletePermissionOverwrites(long channelId, long targetId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deletePermissionOverwrites(channelId, targetId), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
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
            checkBox.f();
        } else if (permission == (permission & deny)) {
            checkBox.e();
        } else {
            checkBox.d();
        }
        StatefulViews statefulViews = this.state;
        if (statefulViews != null) {
        }
        checkBox.setOnSwitchStatusChangedListener(new TernaryCheckBox.b() { // from class: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions.setupPermissionCheckedState.1
            @Override // com.discord.views.TernaryCheckBox.b
            public void onSwitchStatusChanged(int switchStatus) {
                StatefulViews statefulViews2 = WidgetChannelSettingsEditPermissions.this.state;
                if (statefulViews2 != null) {
                    statefulViews2.put(id2, Integer.valueOf(switchStatus));
                }
                StatefulViews statefulViews3 = WidgetChannelSettingsEditPermissions.this.state;
                if (statefulViews3 != null) {
                    statefulViews3.configureSaveActionView(WidgetChannelSettingsEditPermissions.this.getBinding().H);
                }
            }
        });
    }

    private final void setupPermissionEnabledState(TernaryCheckBox checkBox, long permission, WidgetChannelSettingsEditPermissionsModel model) {
        if (ChannelUtils.D(model.getChannel()) && STAGE_DISABLED_PERMISSIONS.contains(Long.valueOf(permission))) {
            checkBox.setDisabled(R.string.stage_channel_cannot_overwrite_permission);
            return;
        }
        if (model instanceof WidgetChannelSettingsEditPermissionsModel.ModelForUser) {
            WidgetChannelSettingsEditPermissionsModel.ModelForUser modelForUser = (WidgetChannelSettingsEditPermissionsModel.ModelForUser) model;
            if (modelForUser.isMe()) {
                if (checkBox.b()) {
                    checkBox.setDisabled(R.string.cannot_deny_self_simple);
                    return;
                } else {
                    checkBox.setOffDisabled(R.string.cannot_deny_self_simple);
                    return;
                }
            }
            if ((modelForUser.getMyPermissionsForChannel() & permission) == permission) {
                checkBox.c();
                return;
            } else {
                checkBox.setDisabled(R.string.cannot_deny_missing_permission);
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
                    checkBox.c();
                    return;
                } else if ((modelForRole.getMyPermissionsForChannel() & permission) == permission) {
                    checkBox.setOffDisabled(R.string.cannot_deny_singular_permission);
                    return;
                } else {
                    checkBox.setOffDisabled(R.string.cannot_deny_missing_permission);
                    return;
                }
            }
            if (i == -1) {
                checkBox.c();
                return;
            }
            if (checkBox.b()) {
                if (!modelForRole.canNeutralizeRolePermission(permission)) {
                    checkBox.setDisabled(R.string.cannot_deny_singular_permission);
                    return;
                }
                if (modelForRole.canNeutralizeRolePermission(permission) && !modelForRole.canDenyRolePermission(permission)) {
                    checkBox.setOffDisabled(R.string.cannot_deny_singular_permission);
                } else if (modelForRole.canNeutralizeRolePermission(permission) && modelForRole.canDenyRolePermission(permission)) {
                    checkBox.c();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    private final void updateCheckboxLabels(TernaryCheckBox checkBox, int channelType, boolean isEveryoneRole, ChannelPermissionUtils2 labels) {
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
                    Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingSubtext");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(channelId, targetId, new AnonymousClass1(type, targetId).invoke()), false, 1, null), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass2.INSTANCE);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(WidgetChannelSettingsEditPermissionsModel.INSTANCE.get(getGuildId(), getChannelId(), getTargetId(), getType()), this, null, 2, null), (Class<?>) WidgetChannelSettingsEditPermissions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
