package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.Dispatcher;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelSelector {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static ChannelSelector INSTANCE;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private final StoreStream stream;

    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ChannelSelector getInstance() {
            ChannelSelector channelSelector = ChannelSelector.INSTANCE;
            if (channelSelector == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return channelSelector;
        }

        public final void init(StoreStream stream, Dispatcher dispatcher, ObservationDeck observationDeck) {
            Intrinsics3.checkNotNullParameter(stream, "stream");
            Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
            ChannelSelector.INSTANCE = new ChannelSelector(stream, dispatcher, observationDeck);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$dismissCreateThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getChannelsSelected().dismissCreateThread();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, Context context) {
            super(0);
            this.$channelId = j;
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            Context context = this.$context;
            if (context != null) {
                AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
                String string = context.getString(R.string.inaccessible_channel_link_title);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…sible_channel_link_title)");
                accessibilityUtils.sendAnnouncement(context, string);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$3, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            ChannelSelector.selectChannel$default(ChannelSelector.this, channel, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetDirectMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.findAndSet(this.$context, channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ChannelSelector.kt */
        public static final class C02111 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02111(Channel channel) {
                super(0);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChannelSelector.this.getStream().handleThreadCreateOrUpdate(this.$channel);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.getDispatcher().schedule(new C02111(channel));
            ChannelSelector.this.findAndSet(this.$context, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$gotoChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().handleGuildSelected(this.$guildId);
            ChannelSelector.this.getStream().getChannelsSelected().trySelectChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$openCreateThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $parentMessageId;
        public final /* synthetic */ String $startThreadLocation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, String str) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$parentMessageId = l;
            this.$startThreadLocation = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getThreadDraft().clearDraftState();
            ChannelSelector.this.getStream().getChannelsSelected().openCreateThread(this.$guildId, this.$channelId, this.$parentMessageId, this.$startThreadLocation);
            AnalyticsTracker.INSTANCE.threadCreationStarted(this.$channelId, this.$guildId, this.$startThreadLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            Channel channelFindChannelById = ChannelSelector.this.getStream().getChannels().findChannelById(this.$channelId);
            if (channelFindChannelById != null && PermissionUtils.INSTANCE.hasAccess(channelFindChannelById, ChannelSelector.this.getStream().getPermissions().getPermissionsByChannel().get(Long.valueOf(this.$channelId)))) {
                return channelFindChannelById;
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WeakReference $fragmentManagerRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WeakReference weakReference, long j) {
            super(1);
            this.$fragmentManagerRef = weakReference;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            FragmentManager fragmentManager = (FragmentManager) this.$fragmentManagerRef.get();
            if (fragmentManager != null) {
                Intrinsics3.checkNotNullExpressionValue(fragmentManager, "fragmentManagerRef.get() ?: return@appSubscribe");
                StoreStream.INSTANCE.getGuildSelected().set(channel.getGuildId());
                WidgetVoiceBottomSheet.INSTANCE.show(fragmentManager, this.$channelId, true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Void) obj);
            return Unit.a;
        }

        public final void invoke(Void r8) {
            ChannelSelector.this.gotoChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ StoreChannelsSelected3 $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = storeChannelsSelected3;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001f  */
        /* JADX WARN: Code duplicated, block: B:8:0x0028  */
        /* JADX WARN: Code duplicated, block: B:9:0x002a  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            boolean z2;
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.D(channel)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.J(channel)) {
                    z2 = true;
                } else {
                    Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                    if (ChannelUtils.D(channel)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
            }
            ChannelSelector.this.gotoChannel(this.$guildId, z2 ? this.$guildId : this.$channelId, this.$peekParent, this.$analyticsLocation);
            if (z2) {
                ChannelSelector.this.getStream().getVoiceChannelSelected().selectVoiceChannel(this.$channelId);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            long id2 = 0;
            if (channel != null && !ChannelUtils.J(channel) && channel.getId() >= 0) {
                id2 = channel.getId();
            }
            ChannelSelector.selectChannel$default(ChannelSelector.this, this.$guildId, id2, null, null, 12, null);
        }
    }

    public ChannelSelector(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
    }

    public static /* synthetic */ void findAndSetDirectMessage$default(ChannelSelector channelSelector, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        channelSelector.findAndSetDirectMessage(context, j);
    }

    public static final ChannelSelector getInstance() {
        return INSTANCE.getInstance();
    }

    private final void gotoChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId, peekParent, analyticsLocation));
    }

    public static /* synthetic */ void openCreateThread$default(ChannelSelector channelSelector, long j, long j2, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        channelSelector.openCreateThread(j, j2, l, str);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, Channel channel, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            storeChannelsSelected3 = null;
        }
        channelSelector.selectChannel(channel, l, storeChannelsSelected3);
    }

    public final void dismissCreateThread() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void findAndSet(Context context, long channelId) {
        if (channelId <= 0) {
            return;
        }
        Observable observableY = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new AnonymousClass1(channelId, context), 14, null).y(new Func1<Channel, Boolean>() { // from class: com.discord.utilities.channel.ChannelSelector.findAndSet.2
            @Override // j0.k.Func1
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "observationDeck\n        …   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, true, 1, null)), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    public final void findAndSetDirectMessage(Context context, long userId) {
        Intrinsics3.checkNotNullParameter(context, "context");
        if (userId <= 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().createOrFetchDM(userId))), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(context));
    }

    public final void findAndSetThread(Context context, long channelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().getChannel(channelId))), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(context, channelId));
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String startThreadLocation) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, channelId, parentMessageId, startThreadLocation));
    }

    public final void previewVoiceChannel(FragmentManager fragmentManager, long channelId) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        WeakReference weakReference = new WeakReference(fragmentManager);
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new AnonymousClass1(channelId), 14, null).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null)), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(weakReference, channelId));
    }

    public final void selectChannel(Channel channel, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        if (channel != null) {
            selectChannel(channel.getGuildId(), channel.getId(), peekParent, analyticsLocation);
        }
    }

    public final void selectPreviousChannel(long guildId) {
        Observable<R> observableY = this.stream.getChannelsSelected().observePreviousId().Y(new Func1<Long, Observable<? extends Channel>>() { // from class: com.discord.utilities.channel.ChannelSelector.selectPreviousChannel.1
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(Long l) {
                StoreChannels channels$app_productionGoogleRelease = ChannelSelector.this.getStream().getChannels();
                Intrinsics3.checkNotNullExpressionValue(l, "previousChannelId");
                return channels$app_productionGoogleRelease.observeChannel(l.longValue());
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "stream.channelsSelected.…nnel(previousChannelId) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(guildId));
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, long j, long j2, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
        channelSelector.selectChannel(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : storeChannelsSelected3);
    }

    public final void selectChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        StoreNavigation.setNavigationPanelAction$default(this.stream.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        if (guildId == 0 || channelId == 0) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(scalarSynchronousObservable), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId, channelId, peekParent, analyticsLocation));
        } else {
            Observable<R> observableG = this.stream.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(guildId, channelId, peekParent, analyticsLocation));
        }
    }
}
