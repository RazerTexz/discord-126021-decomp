package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.Dispatcher;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;

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
                C12238m.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return channelSelector;
        }

        public final void init(StoreStream stream, Dispatcher dispatcher, ObservationDeck observationDeck) {
            C12238m.checkNotNullParameter(stream, "stream");
            C12238m.checkNotNullParameter(dispatcher, "dispatcher");
            C12238m.checkNotNullParameter(observationDeck, "observationDeck");
            ChannelSelector.INSTANCE = new ChannelSelector(stream, dispatcher, observationDeck);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$dismissCreateThread$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67181 extends AbstractC12240o implements Function0<Unit> {
        public C67181() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getChannelsSelected().dismissCreateThread();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67191 extends AbstractC12240o implements Function0<Channel> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67191(long j, Context context) {
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
                String string = context.getString(C5419R.string.inaccessible_channel_link_title);
                C12238m.checkNotNullExpressionValue(string, "context.getString(R.stri…sible_channel_link_title)");
                accessibilityUtils.sendAnnouncement(context, string);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSet$3 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67213 extends AbstractC12240o implements Function1<Channel, Unit> {
        public C67213() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            ChannelSelector.selectChannel$default(ChannelSelector.this, channel, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetDirectMessage$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67221 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67221(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.findAndSet(this.$context, channel.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67231 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$findAndSetThread$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: ChannelSelector.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Channel $channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Channel channel) {
                super(0);
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ChannelSelector.this.getStream().handleThreadCreateOrUpdate(this.$channel);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67231(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            ChannelSelector.this.getDispatcher().schedule(new AnonymousClass1(channel));
            ChannelSelector.this.findAndSet(this.$context, this.$channelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$gotoChannel$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67241 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67241(long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = selectedChannelAnalyticsLocation;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().handleGuildSelected(this.$guildId);
            ChannelSelector.this.getStream().getChannelsSelected().trySelectChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$openCreateThread$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67251 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $parentMessageId;
        public final /* synthetic */ String $startThreadLocation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67251(long j, long j2, Long l, String str) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
            this.$parentMessageId = l;
            this.$startThreadLocation = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ChannelSelector.this.getStream().getThreadDraft().clearDraftState();
            ChannelSelector.this.getStream().getChannelsSelected().openCreateThread(this.$guildId, this.$channelId, this.$parentMessageId, this.$startThreadLocation);
            AnalyticsTracker.INSTANCE.threadCreationStarted(this.$channelId, this.$guildId, this.$startThreadLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67261 extends AbstractC12240o implements Function0<Channel> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67261(long j) {
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

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$previewVoiceChannel$2 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67272 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WeakReference $fragmentManagerRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67272(WeakReference weakReference, long j) {
            super(1);
            this.$fragmentManagerRef = weakReference;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            FragmentManager fragmentManager = (FragmentManager) this.$fragmentManagerRef.get();
            if (fragmentManager != null) {
                C12238m.checkNotNullExpressionValue(fragmentManager, "fragmentManagerRef.get() ?: return@appSubscribe");
                StoreStream.INSTANCE.getGuildSelected().set(channel.getGuildId());
                WidgetVoiceBottomSheet.INSTANCE.show(fragmentManager, this.$channelId, true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$1 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67281 extends AbstractC12240o implements Function1 {
        public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67281(long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = selectedChannelAnalyticsLocation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Void) obj);
            return Unit.f27425a;
        }

        public final void invoke(Void r8) {
            ChannelSelector.this.gotoChannel(this.$guildId, this.$channelId, this.$peekParent, this.$analyticsLocation);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectChannel$2 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67292 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ SelectedChannelAnalyticsLocation $analyticsLocation;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Long $peekParent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67292(long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation) {
            super(1);
            this.$guildId = j;
            this.$channelId = j2;
            this.$peekParent = l;
            this.$analyticsLocation = selectedChannelAnalyticsLocation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001f  */
        /* JADX WARN: Code duplicated, block: B:8:0x0028  */
        /* JADX WARN: Code duplicated, block: B:9:0x002a  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            boolean z2;
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                C12238m.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.m7669D(channel)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                C12238m.checkNotNullExpressionValue(channel, "channel");
                if (ChannelUtils.m7675J(channel)) {
                    z2 = true;
                } else {
                    C12238m.checkNotNullExpressionValue(channel, "channel");
                    if (ChannelUtils.m7669D(channel)) {
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

    /* JADX INFO: renamed from: com.discord.utilities.channel.ChannelSelector$selectPreviousChannel$2 */
    /* JADX INFO: compiled from: ChannelSelector.kt */
    public static final class C67312 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C67312(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            long id2 = 0;
            if (channel != null && !ChannelUtils.m7675J(channel) && channel.getId() >= 0) {
                id2 = channel.getId();
            }
            ChannelSelector.selectChannel$default(ChannelSelector.this, this.$guildId, id2, null, null, 12, null);
        }
    }

    public ChannelSelector(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeStream, "stream");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
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

    private final void gotoChannel(long guildId, long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        this.dispatcher.schedule(new C67241(guildId, channelId, peekParent, analyticsLocation));
    }

    public static /* synthetic */ void openCreateThread$default(ChannelSelector channelSelector, long j, long j2, Long l, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        channelSelector.openCreateThread(j, j2, l, str);
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, Channel channel, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            selectedChannelAnalyticsLocation = null;
        }
        channelSelector.selectChannel(channel, l, selectedChannelAnalyticsLocation);
    }

    public final void dismissCreateThread() {
        this.dispatcher.schedule(new C67181());
    }

    public final void findAndSet(Context context, long channelId) {
        if (channelId <= 0) {
            return;
        }
        Observable observableM11118y = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new C67191(channelId, context), 14, null).m11118y(new InterfaceC12589b<Channel, Boolean>() { // from class: com.discord.utilities.channel.ChannelSelector.findAndSet.2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel != null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "observationDeck\n        …   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y, 0L, true, 1, null)), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67213());
    }

    public final void findAndSetDirectMessage(Context context, long userId) {
        C12238m.checkNotNullParameter(context, "context");
        if (userId <= 0) {
            return;
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().createOrFetchDM(userId))), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67221(context));
    }

    public final void findAndSetThread(Context context, long channelId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationBuffered(RestAPI.INSTANCE.getApi().getChannel(channelId))), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67231(context, channelId));
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
        this.dispatcher.schedule(new C67251(guildId, channelId, parentMessageId, startThreadLocation));
    }

    public final void previewVoiceChannel(FragmentManager fragmentManager, long channelId) {
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WeakReference weakReference = new WeakReference(fragmentManager);
        Observable observableM11083G = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.stream.getChannels(), this.stream.getPermissions()}, false, null, null, new C67261(channelId), 14, null).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null)), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67272(weakReference, channelId));
    }

    public final void selectChannel(Channel channel, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        if (channel != null) {
            selectChannel(channel.getGuildId(), channel.getId(), peekParent, analyticsLocation);
        }
    }

    public final void selectPreviousChannel(long guildId) {
        Observable<R> observableM11099Y = this.stream.getChannelsSelected().observePreviousId().m11099Y(new InterfaceC12589b<Long, Observable<? extends Channel>>() { // from class: com.discord.utilities.channel.ChannelSelector.selectPreviousChannel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(Long l) {
                StoreChannels channels$app_productionGoogleRelease = ChannelSelector.this.getStream().getChannels();
                C12238m.checkNotNullExpressionValue(l, "previousChannelId");
                return channels$app_productionGoogleRelease.observeChannel(l.longValue());
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "stream.channelsSelected.…nnel(previousChannelId) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67312(guildId));
    }

    public static /* synthetic */ void selectChannel$default(ChannelSelector channelSelector, long j, long j2, Long l, SelectedChannelAnalyticsLocation selectedChannelAnalyticsLocation, int i, Object obj) {
        channelSelector.selectChannel(j, j2, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : selectedChannelAnalyticsLocation);
    }

    public final void selectChannel(long guildId, long channelId, Long peekParent, SelectedChannelAnalyticsLocation analyticsLocation) {
        StoreNavigation.setNavigationPanelAction$default(this.stream.getNavigation(), StoreNavigation.PanelAction.CLOSE, null, 2, null);
        if (guildId == 0 || channelId == 0) {
            C12721k c12721k = new C12721k(null);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(null)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(c12721k), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67281(guildId, channelId, peekParent, analyticsLocation));
        } else {
            Observable<R> observableM11083G = this.stream.getChannels().observeChannel(channelId).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null), (Class<?>) ChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C67292(guildId, channelId, peekParent, analyticsLocation));
        }
    }
}
