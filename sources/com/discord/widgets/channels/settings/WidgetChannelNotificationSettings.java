package com.discord.widgets.channels.settings;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.preview.GuildPreview;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelNotificationSettingsBinding;
import com.discord.models.domain.ModelMuteConfig;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.guild.Guild;
import com.discord.stores.NotificationTextUtils;
import com.discord.stores.StoreGuildProfiles;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.channel.ChannelNotificationSettingsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.notifications.NotificationUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelNotificationSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelNotificationSettingsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_SHOW_SYSTEM_SETTINGS = "SHOW_SYSTEM_SETTING";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager notificationSettingsRadioManager;

    /* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, long j, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.launch(context, j, z2);
        }

        public final void launch(Context context, long channelId, boolean showSystemSetting) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId).putExtra(WidgetChannelNotificationSettings.INTENT_SHOW_SYSTEM_SETTINGS, showSystemSetting);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…TINGS, showSystemSetting)");
            AppScreen2.d(context, WidgetChannelNotificationSettings.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final float RADIO_DIMMED_ALPHA = 0.3f;
        public static final float RADIO_OPAQUE_ALPHA = 1.0f;
        private final boolean canAccessRedesignedForumChannels;
        private final Channel channel;
        private final boolean channelIsMuted;
        private final String channelMuteEndTime;
        private final Integer channelOverrideFlags;
        private final Integer forumPostNotificationSetting;
        private final boolean isAboveNotifyAllSize;
        private final boolean isGuildMuted;
        private final int notificationSetting;
        private final boolean notificationSettingIsInherited;
        private final Integer parentNotificationSetting;

        /* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId) {
                Observable<R> observableY = StoreStream.INSTANCE.getChannels().observeChannel(channelId).Y(new Func1<Channel, Observable<? extends Model>>() { // from class: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetChannelNotificationSettings.Model> call(final Channel channel) {
                        if (channel == null) {
                            return new ScalarSynchronousObservable(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.f(companion.getThreadsJoined().observeJoinedThread(channel.getId()), companion.getChannels().observeChannel(channel.getParentId()), companion.getGuilds().observeGuild(channel.getGuildId()), companion.getUserGuildSettings().observeGuildSettings(channel.getGuildId()), companion.getGuildProfiles().observeGuildProfile(channel.getGuildId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), null, null, 6, null), new Func6<StoreThreadsJoined.JoinedThread, Channel, Guild, ModelNotificationSettings, StoreGuildProfiles.GuildProfileData, Boolean, WidgetChannelNotificationSettings.Model>() { // from class: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$Model$Companion$get$1$$special$$inlined$let$lambda$1
                            /* JADX WARN: Code duplicated, block: B:34:0x0088  */
                            @Override // rx.functions.Func6
                            public final WidgetChannelNotificationSettings.Model call(StoreThreadsJoined.JoinedThread joinedThread, Channel channel2, Guild guild, ModelNotificationSettings modelNotificationSettings, StoreGuildProfiles.GuildProfileData guildProfileData, Boolean bool) {
                                int iComputeNotificationSetting;
                                String muteEndTime;
                                String str;
                                GuildPreview data;
                                ModelMuteConfig muteConfig;
                                if (guild == null) {
                                    return null;
                                }
                                NotificationTextUtils notificationTextUtils = NotificationTextUtils.INSTANCE;
                                Integer numChannelMessageNotificationLevel = notificationTextUtils.channelMessageNotificationLevel(modelNotificationSettings, channel2, guild);
                                if (ChannelUtils.H(channel)) {
                                    int iComputeThreadNotificationSetting = ThreadUtils.INSTANCE.computeThreadNotificationSetting(joinedThread, notificationTextUtils.isGuildOrCategoryOrChannelMuted(modelNotificationSettings, channel2), numChannelMessageNotificationLevel);
                                    if (iComputeThreadNotificationSetting != 4) {
                                        iComputeNotificationSetting = iComputeThreadNotificationSetting != 8 ? ModelNotificationSettings.FREQUENCY_ALL : ModelNotificationSettings.FREQUENCY_NOTHING;
                                    } else {
                                        iComputeNotificationSetting = ModelNotificationSettings.FREQUENCY_MENTIONS;
                                    }
                                } else {
                                    ChannelNotificationSettingsUtils channelNotificationSettingsUtils = ChannelNotificationSettingsUtils.INSTANCE;
                                    Channel channel3 = channel;
                                    Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
                                    iComputeNotificationSetting = channelNotificationSettingsUtils.computeNotificationSetting(guild, channel3, modelNotificationSettings);
                                }
                                int i = iComputeNotificationSetting;
                                ModelNotificationSettings.ChannelOverride channelOverride = modelNotificationSettings.getChannelOverride(channel.getId());
                                boolean z2 = !ChannelUtils.H(channel) ? channelOverride == null || !channelOverride.isMuted() : joinedThread == null || !joinedThread.getMuted();
                                if (ChannelUtils.H(channel)) {
                                    if (joinedThread == null || (muteConfig = joinedThread.getMuteConfig()) == null) {
                                        str = null;
                                    } else {
                                        muteEndTime = muteConfig.getEndTime();
                                        str = muteEndTime;
                                    }
                                } else if (channelOverride != null) {
                                    muteEndTime = channelOverride.getMuteEndTime();
                                    str = muteEndTime;
                                } else {
                                    str = null;
                                }
                                boolean z3 = i == ModelNotificationSettings.FREQUENCY_UNSET;
                                Integer numValueOf = channelOverride != null ? Integer.valueOf(channelOverride.getForumPostNotificationSetting()) : null;
                                Integer approximateMemberCount = (guildProfileData == null || (data = guildProfileData.getData()) == null) ? null : data.getApproximateMemberCount();
                                boolean z4 = approximateMemberCount != null && approximateMemberCount.intValue() > 2500;
                                Channel channel4 = channel;
                                Intrinsics3.checkNotNullExpressionValue(modelNotificationSettings, "guildSettings");
                                boolean zIsMuted = modelNotificationSettings.isMuted();
                                Integer numValueOf2 = channelOverride != null ? Integer.valueOf(channelOverride.getFlags()) : null;
                                Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
                                return new WidgetChannelNotificationSettings.Model(channel4, z2, str, zIsMuted, i, numValueOf2, numValueOf, numChannelMessageNotificationLevel, z3, z4, bool.booleanValue());
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …ust(null)\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationBuffered(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, boolean z2, String str, boolean z3, int i, Integer num, Integer num2, Integer num3, boolean z4, boolean z5, boolean z6) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.channelIsMuted = z2;
            this.channelMuteEndTime = str;
            this.isGuildMuted = z3;
            this.notificationSetting = i;
            this.channelOverrideFlags = num;
            this.forumPostNotificationSetting = num2;
            this.parentNotificationSetting = num3;
            this.notificationSettingIsInherited = z4;
            this.isAboveNotifyAllSize = z5;
            this.canAccessRedesignedForumChannels = z6;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final boolean getIsAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getChannelIsMuted() {
            return this.channelIsMuted;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getChannelMuteEndTime() {
            return this.channelMuteEndTime;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsGuildMuted() {
            return this.isGuildMuted;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getChannelOverrideFlags() {
            return this.channelOverrideFlags;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Integer getForumPostNotificationSetting() {
            return this.forumPostNotificationSetting;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getParentNotificationSetting() {
            return this.parentNotificationSetting;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getNotificationSettingIsInherited() {
            return this.notificationSettingIsInherited;
        }

        public final Model copy(Channel channel, boolean channelIsMuted, String channelMuteEndTime, boolean isGuildMuted, int notificationSetting, Integer channelOverrideFlags, Integer forumPostNotificationSetting, Integer parentNotificationSetting, boolean notificationSettingIsInherited, boolean isAboveNotifyAllSize, boolean canAccessRedesignedForumChannels) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(channel, channelIsMuted, channelMuteEndTime, isGuildMuted, notificationSetting, channelOverrideFlags, forumPostNotificationSetting, parentNotificationSetting, notificationSettingIsInherited, isAboveNotifyAllSize, canAccessRedesignedForumChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && this.channelIsMuted == model.channelIsMuted && Intrinsics3.areEqual(this.channelMuteEndTime, model.channelMuteEndTime) && this.isGuildMuted == model.isGuildMuted && this.notificationSetting == model.notificationSetting && Intrinsics3.areEqual(this.channelOverrideFlags, model.channelOverrideFlags) && Intrinsics3.areEqual(this.forumPostNotificationSetting, model.forumPostNotificationSetting) && Intrinsics3.areEqual(this.parentNotificationSetting, model.parentNotificationSetting) && this.notificationSettingIsInherited == model.notificationSettingIsInherited && this.isAboveNotifyAllSize == model.isAboveNotifyAllSize && this.canAccessRedesignedForumChannels == model.canAccessRedesignedForumChannels;
        }

        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final boolean getChannelIsMuted() {
            return this.channelIsMuted;
        }

        public final String getChannelMuteEndTime() {
            return this.channelMuteEndTime;
        }

        public final Integer getChannelOverrideFlags() {
            return this.channelOverrideFlags;
        }

        public final Integer getForumPostNotificationSetting() {
            return this.forumPostNotificationSetting;
        }

        public final int getNotificationSetting() {
            return this.notificationSetting;
        }

        public final boolean getNotificationSettingIsInherited() {
            return this.notificationSettingIsInherited;
        }

        public final Integer getParentNotificationSetting() {
            return this.parentNotificationSetting;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v22, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v6, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.channelIsMuted;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            String str = this.channelMuteEndTime;
            int iHashCode2 = (i + (str != null ? str.hashCode() : 0)) * 31;
            boolean z3 = this.isGuildMuted;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (((iHashCode2 + r3) * 31) + this.notificationSetting) * 31;
            Integer num = this.channelOverrideFlags;
            int iHashCode3 = (i2 + (num != null ? num.hashCode() : 0)) * 31;
            Integer num2 = this.forumPostNotificationSetting;
            int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
            Integer num3 = this.parentNotificationSetting;
            int iHashCode5 = (iHashCode4 + (num3 != null ? num3.hashCode() : 0)) * 31;
            boolean z4 = this.notificationSettingIsInherited;
            ?? r1 = z4;
            if (z4) {
                r1 = 1;
            }
            int i3 = (iHashCode5 + r1) * 31;
            boolean z5 = this.isAboveNotifyAllSize;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.canAccessRedesignedForumChannels;
            return i4 + (z6 ? 1 : z6);
        }

        public final boolean isAboveNotifyAllSize() {
            return this.isAboveNotifyAllSize;
        }

        public final boolean isGuildMuted() {
            return this.isGuildMuted;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", channelIsMuted=");
            sbU.append(this.channelIsMuted);
            sbU.append(", channelMuteEndTime=");
            sbU.append(this.channelMuteEndTime);
            sbU.append(", isGuildMuted=");
            sbU.append(this.isGuildMuted);
            sbU.append(", notificationSetting=");
            sbU.append(this.notificationSetting);
            sbU.append(", channelOverrideFlags=");
            sbU.append(this.channelOverrideFlags);
            sbU.append(", forumPostNotificationSetting=");
            sbU.append(this.forumPostNotificationSetting);
            sbU.append(", parentNotificationSetting=");
            sbU.append(this.parentNotificationSetting);
            sbU.append(", notificationSettingIsInherited=");
            sbU.append(this.notificationSettingIsInherited);
            sbU.append(", isAboveNotifyAllSize=");
            sbU.append(this.isAboveNotifyAllSize);
            sbU.append(", canAccessRedesignedForumChannels=");
            return outline.O(sbU, this.canAccessRedesignedForumChannels, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureNotificationRadios$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Model, CheckedSetting, Integer, Unit> {
        public final /* synthetic */ Ref$IntRef $notificationSetting;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$IntRef ref$IntRef) {
            super(3);
            this.$notificationSetting = ref$IntRef;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Model model, CheckedSetting checkedSetting, Integer num) {
            invoke(model, checkedSetting, num.intValue());
            return Unit.a;
        }

        public final void invoke(final Model model, CheckedSetting checkedSetting, final int i) {
            Intrinsics3.checkNotNullParameter(model, "$this$configureNotificationRadio");
            Intrinsics3.checkNotNullParameter(checkedSetting, "radio");
            if (model.isGuildMuted() || model.getChannelIsMuted()) {
                checkedSetting.b(R.string.channel_or_guild_muted);
            } else {
                checkedSetting.e(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings.configureNotificationRadios.1.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StoreStream.INSTANCE.getUserGuildSettings().setChannelFrequency(outline.x(view, "it", "it.context"), model.getChannel(), i);
                    }
                });
            }
            if (model.isAboveNotifyAllSize() && i == ModelNotificationSettings.FREQUENCY_ALL) {
                CharSequence charSequenceE = FormatUtils.e(WidgetChannelNotificationSettings.this, R.string.large_guild_notify_all_messages_description, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                int i2 = CheckedSetting.j;
                checkedSetting.h(charSequenceE, false);
            } else {
                int i3 = CheckedSetting.j;
                checkedSetting.h(null, false);
            }
            boolean z2 = this.$notificationSetting.element == i;
            checkedSetting.setButtonAlpha((z2 && model.getNotificationSettingIsInherited()) ? 0.3f : 1.0f);
            if (z2) {
                WidgetChannelNotificationSettings.access$getNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings.this).a(checkedSetting);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            if (model != null) {
                WidgetChannelNotificationSettings.this.configureUI(model);
                return;
            }
            FragmentActivity fragmentActivityE = WidgetChannelNotificationSettings.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
        }
    }

    public WidgetChannelNotificationSettings() {
        super(R.layout.widget_channel_notification_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelNotificationSettings4.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ RadioManager access$getNotificationSettingsRadioManager$p(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        RadioManager radioManager = widgetChannelNotificationSettings.notificationSettingsRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("notificationSettingsRadioManager");
        }
        return radioManager;
    }

    private final void configureChannel(Model model) {
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        linearLayout.setVisibility(8);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(8);
        getBinding().i.setText(R.string.form_label_notification_frequency);
    }

    private final void configureGuildForumChannel(final Model model) {
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.forumChannelNotificationSettings");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.frequencySubheader");
        textView.setVisibility(0);
        getBinding().e.setText(R.string.forum_message_notifications);
        getBinding().i.setText(R.string.forum_message_notifications_description);
        Integer parentNotificationSetting = model.getParentNotificationSetting();
        boolean z3 = parentNotificationSetting != null && parentNotificationSetting.intValue() == ModelNotificationSettings.FREQUENCY_ALL;
        Integer forumPostNotificationSetting = model.getForumPostNotificationSetting();
        int iIntValue = forumPostNotificationSetting != null ? forumPostNotificationSetting.intValue() : ModelNotificationSettings.FREQUENCY_UNSET;
        CheckedSetting checkedSetting = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.frequencyAllPosts");
        if (iIntValue == ModelNotificationSettings.FREQUENCY_UNSET) {
            z2 = z3;
        } else if (iIntValue == ModelNotificationSettings.FORUM_THREAD_CREATED_ON) {
            z2 = true;
        }
        checkedSetting.setChecked(z2);
        getBinding().d.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings.configureGuildForumChannel.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                int i = bool.booleanValue() ? ModelNotificationSettings.FORUM_THREAD_CREATED_ON : ModelNotificationSettings.FORUM_THREAD_CREATED_OFF;
                Integer channelOverrideFlags = model.getChannelOverrideFlags();
                int iIntValue2 = i | ((channelOverrideFlags != null ? channelOverrideFlags.intValue() : 0) & (~ModelNotificationSettings.FORUM_THREAD_CREATED_MASK));
                StoreUserGuildSettings userGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
                CheckedSetting checkedSetting2 = WidgetChannelNotificationSettings.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.frequencyAllPosts");
                Context context = checkedSetting2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.frequencyAllPosts.context");
                userGuildSettings.setChannelNotificationFlags(context, model.getChannel(), iIntValue2);
            }
        });
    }

    private final void configureNotificationRadios(Model model) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = model.getNotificationSetting();
        if (ChannelUtils.D(model.getChannel()) && ref$IntRef.element == ModelNotificationSettings.FREQUENCY_ALL) {
            ref$IntRef.element = ModelNotificationSettings.FREQUENCY_MENTIONS;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$IntRef);
        CheckedSetting checkedSetting = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.frequencyRadioAll");
        checkedSetting.setVisibility(ChannelUtils.F(model.getChannel()) || ChannelUtils.k(model.getChannel()) ? 0 : 8);
        CheckedSetting checkedSetting2 = getBinding().g;
        String string = requireContext().getString(ChannelUtils.D(model.getChannel()) ? R.string.form_label_live_stages_only : R.string.form_label_only_mentions);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…s\n            }\n        )");
        checkedSetting2.setText(FormatUtils.g(string, new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null));
        CheckedSetting checkedSetting3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.frequencyRadioAll");
        anonymousClass1.invoke(model, checkedSetting3, ModelNotificationSettings.FREQUENCY_ALL);
        CheckedSetting checkedSetting4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.frequencyRadioMentions");
        anonymousClass1.invoke(model, checkedSetting4, ModelNotificationSettings.FREQUENCY_MENTIONS);
        CheckedSetting checkedSetting5 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.frequencyRadioNothing");
        anonymousClass1.invoke(model, checkedSetting5, ModelNotificationSettings.FREQUENCY_NOTHING);
    }

    private final void configureUI(Model model) {
        setActionBarSubtitle(ChannelUtils.e(model.getChannel(), requireContext(), false, 2));
        boolean z2 = true;
        NotificationMuteSettingsView.ViewState viewState = new NotificationMuteSettingsView.ViewState(model.getChannelIsMuted(), model.getChannelMuteEndTime(), ChannelUtils.F(model.getChannel()) ? FormatUtils.b(requireContext(), R.string.mute_channel, new Object[]{ChannelUtils.e(model.getChannel(), requireContext(), false, 2)}, (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(requireContext(), R.string.mute_category, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), ChannelUtils.F(model.getChannel()) ? FormatUtils.b(requireContext(), R.string.unmute_channel, new Object[]{ChannelUtils.e(model.getChannel(), requireContext(), false, 2)}, (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(requireContext(), R.string.unmute_category, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), FormatUtils.b(requireContext(), R.string.form_label_mobile_channel_muted, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null), ChannelUtils.F(model.getChannel()) ? R.string.form_label_mobile_channel_muted_until : R.string.form_label_mobile_category_muted_until, ChannelUtils.F(model.getChannel()) ? FormatUtils.b(requireContext(), R.string.form_label_mobile_channel_override_mute, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null) : FormatUtils.b(requireContext(), R.string.form_label_mobile_category_override_mute, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null));
        WidgetChannelNotificationSettings5 widgetChannelNotificationSettings5 = new WidgetChannelNotificationSettings5(this, model);
        WidgetChannelNotificationSettings6 widgetChannelNotificationSettings6 = new WidgetChannelNotificationSettings6(this, model);
        if (!ChannelUtils.F(model.getChannel()) && !ChannelUtils.k(model.getChannel())) {
            z2 = false;
        }
        NotificationMuteSettingsView notificationMuteSettingsView = getBinding().k;
        notificationMuteSettingsView.setVisibility(z2 ? 0 : 8);
        notificationMuteSettingsView.updateView(viewState, widgetChannelNotificationSettings5, widgetChannelNotificationSettings6);
        View view = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.frequencyTopDivider");
        view.setVisibility(z2 ? 0 : 8);
        configureNotificationRadios(model);
        if (ChannelUtils.q(model.getChannel()) && model.getCanAccessRedesignedForumChannels()) {
            configureGuildForumChannel(model);
        } else {
            configureChannel(model);
        }
    }

    private final WidgetChannelNotificationSettingsBinding getBinding() {
        return (WidgetChannelNotificationSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.notification_settings);
        this.notificationSettingsRadioManager = new RadioManager(Collections2.listOf((Object[]) new CheckedSetting[]{getBinding().f, getBinding().g, getBinding().h}));
        LinearLayout linearLayout = getBinding().f2262b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.channelNotificationSettingsSystem");
        linearLayout.setVisibility(getMostRecentIntent().getBooleanExtra(INTENT_SHOW_SYSTEM_SETTINGS, false) ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
        getBinding().f2262b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings.onViewBoundOrOnResume.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotificationUtils.INSTANCE.showNotificationPage(WidgetChannelNotificationSettings.this);
            }
        });
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), (Class<?>) WidgetChannelNotificationSettings.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
