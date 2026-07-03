package com.discord.widgets.stage;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.RxCoroutineUtilsKt;
import com.discord.utilities.voice.VoiceChannelJoinability;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.C0836m;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12163u;
import p507d0.p584w.p585h.C12182b;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.C12185b;
import p507d0.p584w.p586i.p587a.C12190g;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p659s.p660a.C13126l;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper {
    public static final StageChannelJoinHelper INSTANCE = new StageChannelJoinHelper();
    private static Job lurkJob;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            VoiceChannelJoinability.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY.ordinal()] = 1;
            iArr[VoiceChannelJoinability.PERMISSIONS_MISSING.ordinal()] = 2;
            iArr[VoiceChannelJoinability.CHANNEL_FULL.ordinal()] = 3;
            iArr[VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST.ordinal()] = 4;
            iArr[VoiceChannelJoinability.CAN_JOIN.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100041 extends AbstractC12240o implements Function0<Unit> {
        public static final C100041 INSTANCE = new C100041();

        public C100041() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100052 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ StoreChannels $channelsStore;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ Function0 $onCompleted;
        public final /* synthetic */ StoreUserRelationships $userRelationshipsStore;
        public final /* synthetic */ StoreVoiceChannelSelected $voiceChannelSelectedStore;
        public final /* synthetic */ StoreVoiceStates $voiceStatesStore;
        public final /* synthetic */ boolean $warnedAboutBlockedUsers;

        /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$connectToStage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<StoreVoiceChannelSelected.JoinVoiceChannelResult, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                invoke2(joinVoiceChannelResult);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StoreVoiceChannelSelected.JoinVoiceChannelResult joinVoiceChannelResult) {
                C12238m.checkNotNullParameter(joinVoiceChannelResult, "it");
                C100052 c100052 = C100052.this;
                if (c100052.$launchFullscreen) {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, c100052.$context, c100052.$channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
                }
                C100052.this.$onCompleted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100052(StoreChannels storeChannels, long j, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, boolean z2, StoreVoiceChannelSelected storeVoiceChannelSelected, FragmentManager fragmentManager, boolean z3, Function0 function0, Context context) {
            super(0);
            this.$channelsStore = storeChannels;
            this.$channelId = j;
            this.$voiceStatesStore = storeVoiceStates;
            this.$userRelationshipsStore = storeUserRelationships;
            this.$warnedAboutBlockedUsers = z2;
            this.$voiceChannelSelectedStore = storeVoiceChannelSelected;
            this.$fragmentManager = fragmentManager;
            this.$launchFullscreen = z3;
            this.$onCompleted = function0;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007e  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            boolean z2;
            Object next;
            Integer num;
            Channel channel = this.$channelsStore.getChannel(this.$channelId);
            if (channel != null) {
                Map mapEmptyMap = (Map) C1643a.m843c(channel, this.$voiceStatesStore.get());
                if (mapEmptyMap == null) {
                    mapEmptyMap = C12136h0.emptyMap();
                }
                Sequence map = C12078q.map(C12078q.filter(C12163u.asSequence(mapEmptyMap.values()), new C10006x21efe36e(channel)), C10007x21efe36f.INSTANCE);
                Map<Long, Integer> relationships = this.$userRelationshipsStore.getRelationships();
                if (!this.$warnedAboutBlockedUsers) {
                    Iterator it = map.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            num = relationships.get(Long.valueOf(((Number) next).longValue()));
                        }
                    } while (!(num != null && num.intValue() == 2));
                    z2 = (next == null || this.$voiceChannelSelectedStore.getSelectedVoiceChannelId() == this.$channelId) ? false : true;
                }
                if (!z2) {
                    ObservableExtensionsKt.appSubscribe(this.$voiceChannelSelectedStore.selectVoiceChannel(this.$channelId), (Class<?>) StageChannelJoinHelper.INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
                } else {
                    WidgetStageAudienceBlockedBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channelId, this.$launchFullscreen);
                    this.$onCompleted.invoke();
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStage$1", m10085f = "StageChannelJoinHelper.kt", m10086l = {123}, m10087m = "invokeSuspend")
    public static final class C100081 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreGuilds $guildsStore;
        public final /* synthetic */ boolean $launchFullscreen;
        public final /* synthetic */ StoreLurking $lurkingStore;
        public final /* synthetic */ StoreVoiceChannelSelected $selectedVoiceChannelStore;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100081(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation) {
            super(2, continuation);
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$guildId = j;
            this.$channelId = j2;
            this.$launchFullscreen = z2;
            this.$guildsStore = storeGuilds;
            this.$lurkingStore = storeLurking;
            this.$selectedVoiceChannelStore = storeVoiceChannelSelected;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new C100081(this.$context, this.$fragmentManager, this.$guildId, this.$channelId, this.$launchFullscreen, this.$guildsStore, this.$lurkingStore, this.$selectedVoiceChannelStore, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C100081) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context context = this.$context;
                FragmentManager fragmentManager = this.$fragmentManager;
                long j = this.$guildId;
                long j2 = this.$channelId;
                boolean z2 = this.$launchFullscreen;
                StoreGuilds storeGuilds = this.$guildsStore;
                StoreLurking storeLurking = this.$lurkingStore;
                StoreVoiceChannelSelected storeVoiceChannelSelected = this.$selectedVoiceChannelStore;
                this.label = 1;
                if (stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, z2, storeGuilds, storeLurking, storeVoiceChannelSelected, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$1 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.stage.StageChannelJoinHelper", m10085f = "StageChannelJoinHelper.kt", m10086l = {180, Opcodes.IF_ICMPEQ, Opcodes.IF_ACMPNE}, m10087m = "lurkAndJoinStageAsync")
    public static final class C100091 extends AbstractC12187d {
        public long J$0;
        public long J$1;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C100091(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StageChannelJoinHelper.this.lurkAndJoinStageAsync(null, null, 0L, 0L, false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.StageChannelJoinHelper$lurkAndJoinStageAsync$5 */
    /* JADX INFO: compiled from: StageChannelJoinHelper.kt */
    public static final class C100125 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ StoreLurking $lurkingStore;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C100125(StoreLurking storeLurking, long j) {
            super(0);
            this.$lurkingStore = storeLurking;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$lurkingStore.removeOldLurkingGuilds(this.$guildId);
        }
    }

    private StageChannelJoinHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connectToStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, boolean z2, boolean z3, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, Function0 function0, int i, Object obj) {
        stageChannelJoinHelper.connectToStage(context, fragmentManager, j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.INSTANCE.getVoiceStates() : storeVoiceStates, (i & 256) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships, (i & 512) != 0 ? C100041.INSTANCE : function0);
    }

    @MainThread
    public final void connectToStage(Context context, FragmentManager fragmentManager, long channelId, boolean warnedAboutBlockedUsers, boolean launchFullscreen, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreChannels channelsStore, StoreVoiceStates voiceStatesStore, StoreUserRelationships userRelationshipsStore, Function0<Unit> onCompleted) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(channelsStore, "channelsStore");
        C12238m.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        C12238m.checkNotNullParameter(userRelationshipsStore, "userRelationshipsStore");
        C12238m.checkNotNullParameter(onCompleted, "onCompleted");
        verifyStageJoinability(context, fragmentManager, channelId, new C100052(channelsStore, channelId, voiceStatesStore, userRelationshipsStore, warnedAboutBlockedUsers, voiceChannelSelectedStore, fragmentManager, launchFullscreen, onCompleted, context));
    }

    @MainThread
    public final void lurkAndJoinStage(Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long guildId, long channelId, boolean launchFullscreen, StoreGuilds guildsStore, StoreLurking lurkingStore, StoreVoiceChannelSelected selectedVoiceChannelStore) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(guildsStore, "guildsStore");
        C12238m.checkNotNullParameter(lurkingStore, "lurkingStore");
        C12238m.checkNotNullParameter(selectedVoiceChannelStore, "selectedVoiceChannelStore");
        Job job = lurkJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        lurkJob = coroutineScope != null ? C3404f.m4211H0(coroutineScope, null, null, new C100081(context, fragmentManager, guildId, channelId, launchFullscreen, guildsStore, lurkingStore, selectedVoiceChannelStore, null), 3, null) : null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0185  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object lurkAndJoinStageAsync(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation<? super Boolean> continuation) {
        C100091 c100091;
        FragmentManager fragmentManager2;
        StoreGuilds storeGuilds2;
        StoreLurking storeLurking2;
        final long j3;
        long j4;
        StageChannelJoinHelper stageChannelJoinHelper;
        Object obj;
        StoreVoiceChannelSelected storeVoiceChannelSelected2;
        Context context2;
        boolean z3;
        StoreLurking storeLurking3;
        Context context3;
        StoreVoiceChannelSelected storeVoiceChannelSelected3;
        StageChannelJoinHelper stageChannelJoinHelper2;
        FragmentManager fragmentManager3;
        boolean z4;
        Observable<Channel> observableM11119z;
        boolean z5;
        StageChannelJoinHelper stageChannelJoinHelper3;
        long j5;
        long j6;
        StoreLurking storeLurking4;
        FragmentManager fragmentManager4;
        Context context4;
        if (continuation instanceof C100091) {
            c100091 = (C100091) continuation;
            int i = c100091.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c100091.label = i - Integer.MIN_VALUE;
            } else {
                c100091 = new C100091(continuation);
            }
        } else {
            c100091 = new C100091(continuation);
        }
        Object obj2 = c100091.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c100091.label;
        if (i2 != 0) {
            if (i2 == 1) {
                boolean z6 = c100091.Z$0;
                j4 = c100091.J$1;
                j3 = c100091.J$0;
                StoreVoiceChannelSelected storeVoiceChannelSelected4 = (StoreVoiceChannelSelected) c100091.L$5;
                StoreLurking storeLurking5 = (StoreLurking) c100091.L$4;
                StoreGuilds storeGuilds3 = (StoreGuilds) c100091.L$3;
                FragmentManager fragmentManager5 = (FragmentManager) c100091.L$2;
                context2 = (Context) c100091.L$1;
                StageChannelJoinHelper stageChannelJoinHelper4 = (StageChannelJoinHelper) c100091.L$0;
                C12113l.throwOnFailure(obj2);
                storeVoiceChannelSelected2 = storeVoiceChannelSelected4;
                storeLurking2 = storeLurking5;
                obj = obj2;
                z3 = z6;
                fragmentManager2 = fragmentManager5;
                stageChannelJoinHelper = stageChannelJoinHelper4;
                storeGuilds2 = storeGuilds3;
            } else if (i2 == 2) {
                z4 = c100091.Z$0;
                j4 = c100091.J$1;
                j3 = c100091.J$0;
                storeVoiceChannelSelected3 = (StoreVoiceChannelSelected) c100091.L$4;
                storeLurking3 = (StoreLurking) c100091.L$3;
                fragmentManager3 = (FragmentManager) c100091.L$2;
                context3 = (Context) c100091.L$1;
                stageChannelJoinHelper2 = (StageChannelJoinHelper) c100091.L$0;
                C12113l.throwOnFailure(obj2);
                observableM11119z = storeVoiceChannelSelected3.observeSelectedChannel().m11118y(new InterfaceC12589b<Channel, Boolean>() { // from class: com.discord.widgets.stage.StageChannelJoinHelper.lurkAndJoinStageAsync.4
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Boolean call(Channel channel) {
                        return Boolean.valueOf(channel == null);
                    }
                }).m11119z();
                C12238m.checkNotNullExpressionValue(observableM11119z, "selectedVoiceChannelStor…= null }\n        .first()");
                c100091.L$0 = stageChannelJoinHelper2;
                c100091.L$1 = context3;
                c100091.L$2 = fragmentManager3;
                c100091.L$3 = storeLurking3;
                c100091.L$4 = null;
                c100091.J$0 = j3;
                c100091.J$1 = j4;
                c100091.Z$0 = z4;
                c100091.label = 3;
                if (RxCoroutineUtilsKt.awaitSingle(observableM11119z, c100091) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z5 = z4;
                stageChannelJoinHelper3 = stageChannelJoinHelper2;
                j5 = j4;
                j6 = j3;
                storeLurking4 = storeLurking3;
                fragmentManager4 = fragmentManager3;
                context4 = context3;
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z7 = c100091.Z$0;
                long j7 = c100091.J$1;
                j6 = c100091.J$0;
                storeLurking4 = (StoreLurking) c100091.L$3;
                FragmentManager fragmentManager6 = (FragmentManager) c100091.L$2;
                Context context5 = (Context) c100091.L$1;
                StageChannelJoinHelper stageChannelJoinHelper5 = (StageChannelJoinHelper) c100091.L$0;
                C12113l.throwOnFailure(obj2);
                stageChannelJoinHelper3 = stageChannelJoinHelper5;
                z5 = z7;
                j5 = j7;
                fragmentManager4 = fragmentManager6;
                context4 = context5;
            }
            connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new C100125(storeLurking4, j6), 488, null);
            return C12185b.boxBoolean(true);
        }
        C12113l.throwOnFailure(obj2);
        storeVoiceChannelSelected.clear();
        c100091.L$0 = this;
        c100091.L$1 = context;
        fragmentManager2 = fragmentManager;
        c100091.L$2 = fragmentManager2;
        storeGuilds2 = storeGuilds;
        c100091.L$3 = storeGuilds2;
        storeLurking2 = storeLurking;
        c100091.L$4 = storeLurking2;
        c100091.L$5 = storeVoiceChannelSelected;
        c100091.J$0 = j;
        c100091.J$1 = j2;
        c100091.Z$0 = z2;
        c100091.label = 1;
        C13126l c13126l = new C13126l(C12182b.intercepted(c100091), 1);
        c13126l.m11318A();
        storeLurking.startLurking(j, C12185b.boxLong(j2), false, new StageChannelJoinHelper$lurkAndJoinStageAsync$2$1(c13126l), new StageChannelJoinHelper$lurkAndJoinStageAsync$2$2(c13126l));
        Object objM11326u = c13126l.m11326u();
        if (objM11326u == C12183c.getCOROUTINE_SUSPENDED()) {
            C12190g.probeCoroutineSuspended(c100091);
        }
        if (objM11326u == coroutine_suspended) {
            return coroutine_suspended;
        }
        j3 = j;
        j4 = j2;
        stageChannelJoinHelper = this;
        obj = objM11326u;
        storeVoiceChannelSelected2 = storeVoiceChannelSelected;
        context2 = context;
        z3 = z2;
        if (((Unit) obj) == null) {
            return C12185b.boxBoolean(false);
        }
        Observable<Set<Long>> observableM11119z2 = storeGuilds2.observeGuildIds().m11118y(new InterfaceC12589b<Set<? extends Long>, Boolean>() { // from class: com.discord.widgets.stage.StageChannelJoinHelper.lurkAndJoinStageAsync.3
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Boolean call(Set<? extends Long> set) {
                return call2((Set<Long>) set);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Set<Long> set) {
                return Boolean.valueOf(set.contains(Long.valueOf(j3)));
            }
        }).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z2, "guildsStore\n        .obs…in ids }\n        .first()");
        c100091.L$0 = stageChannelJoinHelper;
        c100091.L$1 = context2;
        c100091.L$2 = fragmentManager2;
        c100091.L$3 = storeLurking2;
        c100091.L$4 = storeVoiceChannelSelected2;
        c100091.L$5 = null;
        c100091.J$0 = j3;
        c100091.J$1 = j4;
        c100091.Z$0 = z3;
        c100091.label = 2;
        if (RxCoroutineUtilsKt.awaitSingle(observableM11119z2, c100091) == coroutine_suspended) {
            return coroutine_suspended;
        }
        storeLurking3 = storeLurking2;
        context3 = context2;
        storeVoiceChannelSelected3 = storeVoiceChannelSelected2;
        stageChannelJoinHelper2 = stageChannelJoinHelper;
        fragmentManager3 = fragmentManager2;
        z4 = z3;
        observableM11119z = storeVoiceChannelSelected3.observeSelectedChannel().m11118y(new InterfaceC12589b<Channel, Boolean>() { // from class: com.discord.widgets.stage.StageChannelJoinHelper.lurkAndJoinStageAsync.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Channel channel) {
                return Boolean.valueOf(channel == null);
            }
        }).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "selectedVoiceChannelStor…= null }\n        .first()");
        c100091.L$0 = stageChannelJoinHelper2;
        c100091.L$1 = context3;
        c100091.L$2 = fragmentManager3;
        c100091.L$3 = storeLurking3;
        c100091.L$4 = null;
        c100091.J$0 = j3;
        c100091.J$1 = j4;
        c100091.Z$0 = z4;
        c100091.label = 3;
        if (RxCoroutineUtilsKt.awaitSingle(observableM11119z, c100091) == coroutine_suspended) {
            return coroutine_suspended;
        }
        z5 = z4;
        stageChannelJoinHelper3 = stageChannelJoinHelper2;
        j5 = j4;
        j6 = j3;
        storeLurking4 = storeLurking3;
        fragmentManager4 = fragmentManager3;
        context4 = context3;
        connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new C100125(storeLurking4, j6), 488, null);
        return C12185b.boxBoolean(true);
    }

    @MainThread
    public final void verifyStageJoinability(Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onJoinVerified) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(onJoinVerified, "onJoinVerified");
        int iOrdinal = VoiceChannelJoinabilityUtils.INSTANCE.getJoinability(channelId).ordinal();
        if (iOrdinal == 0) {
            onJoinVerified.invoke();
            return;
        }
        if (iOrdinal == 1) {
            C0876m.m169g(context, C5419R.string.channel_locked, 0, null, 12);
            return;
        }
        if (iOrdinal == 2) {
            C0836m.INSTANCE.m140a(fragmentManager);
        } else if (iOrdinal == 3) {
            C0876m.m169g(context, C5419R.string.unable_to_join_channel_full, 0, null, 12);
        } else {
            if (iOrdinal != 4) {
                return;
            }
            C0876m.m169g(context, C5419R.string.guild_settings_public_welcome_invalid_channel, 0, null, 12);
        }
    }
}
