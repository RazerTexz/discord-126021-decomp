package com.discord.widgets.channels.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.thread.ThreadMetadata;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetThreadArchiveActions;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadArchiveActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadArchiveActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadArchiveActions widgetThreadArchiveActions = new WidgetThreadArchiveActions();
            Bundle bundleT = outline.T(WidgetThreadArchiveActions.INTENT_EXTRA_CHANNEL_ID, channelId);
            bundleT.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetThreadArchiveActions.setArguments(bundleT);
            widgetThreadArchiveActions.show(fragmentManager, WidgetThreadArchiveActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final Guild guild;
        private final boolean isModerator;

        /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long channelId, long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableI = Observable.i(companion.getChannels().observeChannel(channelId), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForChannel(channelId), new Func3<Channel, Guild, Long, Model>() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions$Model$Companion$get$1
                    @Override // rx.functions.Func3
                    public final WidgetThreadArchiveActions.Model call(Channel channel, Guild guild, Long l) {
                        if (channel != null) {
                            return new WidgetThreadArchiveActions.Model(channel, guild, ThreadUtils.INSTANCE.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L)));
                        }
                        return null;
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableI, "Observable.combineLatest…            }\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Channel channel, Guild guild, boolean z2) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.guild = guild;
            this.isModerator = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Channel channel, Guild guild, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = model.channel;
            }
            if ((i & 2) != 0) {
                guild = model.guild;
            }
            if ((i & 4) != 0) {
                z2 = model.isModerator;
            }
            return model.copy(channel, guild, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        public final Model copy(Channel channel, Guild guild, boolean isModerator) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new Model(channel, guild, isModerator);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.guild, model.guild) && this.isModerator == model.isModerator;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", isModerator=");
            return outline.O(sbU, this.isModerator, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$archiveThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetThreadArchiveActions widgetThreadArchiveActions) {
            super(1, widgetThreadArchiveActions, WidgetThreadArchiveActions.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/list/WidgetThreadArchiveActions$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetThreadArchiveActions) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$setAutoArchiveDuration$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadArchiveActions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "it");
            WidgetThreadArchiveActions.this.dismiss();
        }
    }

    public WidgetThreadArchiveActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadArchiveActions3.INSTANCE, null, 2, null);
    }

    private final void archiveThread(Channel channel, boolean lockThread) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long id2 = channel.getId();
        Boolean bool = Boolean.TRUE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, lockThread ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: archiveThread", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    private final void configureUI(final Model model) {
        if (model == null) {
            dismiss();
            return;
        }
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        final Channel channel = model.getChannel();
        model.getGuild();
        new Traits.Location(Traits.Location.Page.GUILD_CHANNEL, Traits.Location.Section.THREAD_ARCHIVAL_DURATION_SHEET, Traits.Location.Obj.LIST_ITEM, null, null, 24, null);
        LinearLayout linearLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.autoArchiveHeader");
        boolean z2 = false;
        linearLayout.setVisibility(0);
        long jComputeThreadAutoArchiveTimeMs = ThreadUtils.INSTANCE.computeThreadAutoArchiveTimeMs(channel);
        TextView textView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.subtitle");
        textView.setText(FormatUtils.b(contextRequireContext, R.string.auto_archive_thread_at_long, new Object[]{TimeUtils.toReadableTimeString$default(contextRequireContext, jComputeThreadAutoArchiveTimeMs, null, 4, null)}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        ThreadMetadata threadMetadata = channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        TextView textView2 = getBinding().f2667b;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.archiveNow");
        textView2.setVisibility(0);
        getBinding().f2667b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadArchiveActions.this.archiveThread(channel, model.isModerator());
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadArchiveActions.this.setAutoArchiveDuration(channel, 60);
            }
        });
        MaterialRadioButton materialRadioButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.optionOneHourRadio");
        materialRadioButton.setChecked(numValueOf != null && numValueOf.intValue() == 60);
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadArchiveActions.this.setAutoArchiveDuration(channel, 1440);
            }
        });
        MaterialRadioButton materialRadioButton2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.optionTwentyFourHoursRadio");
        materialRadioButton2.setChecked(numValueOf != null && numValueOf.intValue() == 1440);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadArchiveActions.this.setAutoArchiveDuration(channel, ThreadUtils.ThreadArchiveDurations.THREE_DAYS_IN_MINUTES);
            }
        });
        MaterialRadioButton materialRadioButton3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.optionThreeDaysRadio");
        materialRadioButton3.setChecked(numValueOf != null && numValueOf.intValue() == 4320);
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.list.WidgetThreadArchiveActions.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadArchiveActions.this.setAutoArchiveDuration(channel, ThreadUtils.ThreadArchiveDurations.SEVEN_DAYS_IN_MINUTES);
            }
        });
        MaterialRadioButton materialRadioButton4 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.optionSevenDaysRadio");
        if (numValueOf != null && numValueOf.intValue() == 10080) {
            z2 = true;
        }
        materialRadioButton4.setChecked(z2);
    }

    private final WidgetThreadArchiveActionsSheetBinding getBinding() {
        return (WidgetThreadArchiveActionsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void setAutoArchiveDuration(Channel channel, int minutes) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().editThread(channel.getId(), new RestAPIParams.ThreadSettings(null, null, Integer.valueOf(minutes), 3, null)), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: setAutoArchiveDuration", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass3.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.AnonymousClass4.INSTANCE : null));
    }

    public static final void show(FragmentManager fragmentManager, long j, long j2) {
        INSTANCE.show(fragmentManager, j, j2);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getArgumentsOrDefault().getLong(INTENT_EXTRA_CHANNEL_ID, -1L), getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L)), this, null, 2, null), (Class<?>) WidgetThreadArchiveActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_thread_archive_actions_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }
}
