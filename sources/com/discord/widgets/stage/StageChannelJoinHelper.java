package com.discord.widgets.stage;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import b.i.a.f.e.o.f;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.rx.RxCoroutineUtilsKt;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.b;
import d0.w.i.a.g;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import rx.Observable;

/* JADX INFO: compiled from: StageChannelJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelJoinHelper {
    public static final StageChannelJoinHelper INSTANCE = new StageChannelJoinHelper();
    private static Job lurkJob;

    private StageChannelJoinHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connectToStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, boolean z2, boolean z3, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreChannels storeChannels, StoreVoiceStates storeVoiceStates, StoreUserRelationships storeUserRelationships, Function0 function0, int i, Object obj) {
        stageChannelJoinHelper.connectToStage(context, fragmentManager, j, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? true : z3, (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 128) != 0 ? StoreStream.Companion.getVoiceStates() : storeVoiceStates, (i & 256) != 0 ? StoreStream.Companion.getUserRelationships() : storeUserRelationships, (i & 512) != 0 ? StageChannelJoinHelper$connectToStage$1.INSTANCE : function0);
    }

    public static /* synthetic */ void lurkAndJoinStage$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, int i, Object obj) {
        stageChannelJoinHelper.lurkAndJoinStage(context, fragmentManager, coroutineScope, j, j2, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.Companion.getLurking() : storeLurking, (i & 256) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected);
    }

    public static /* synthetic */ Object lurkAndJoinStageAsync$default(StageChannelJoinHelper stageChannelJoinHelper, Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation continuation, int i, Object obj) {
        return stageChannelJoinHelper.lurkAndJoinStageAsync(context, fragmentManager, j, j2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.Companion.getLurking() : storeLurking, (i & 128) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, continuation);
    }

    @MainThread
    public final void connectToStage(Context context, FragmentManager fragmentManager, long channelId, boolean warnedAboutBlockedUsers, boolean launchFullscreen, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreChannels channelsStore, StoreVoiceStates voiceStatesStore, StoreUserRelationships userRelationshipsStore, Function0<Unit> onCompleted) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        m.checkNotNullParameter(userRelationshipsStore, "userRelationshipsStore");
        m.checkNotNullParameter(onCompleted, "onCompleted");
        verifyStageJoinability(context, fragmentManager, channelId, new StageChannelJoinHelper$connectToStage$2(channelsStore, channelId, voiceStatesStore, userRelationshipsStore, warnedAboutBlockedUsers, voiceChannelSelectedStore, fragmentManager, launchFullscreen, onCompleted, context));
    }

    @MainThread
    public final void lurkAndJoinStage(Context context, FragmentManager fragmentManager, CoroutineScope coroutineScope, long guildId, long channelId, boolean launchFullscreen, StoreGuilds guildsStore, StoreLurking lurkingStore, StoreVoiceChannelSelected selectedVoiceChannelStore) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(guildsStore, "guildsStore");
        m.checkNotNullParameter(lurkingStore, "lurkingStore");
        m.checkNotNullParameter(selectedVoiceChannelStore, "selectedVoiceChannelStore");
        Job job = lurkJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        lurkJob = coroutineScope != null ? f.H0(coroutineScope, null, null, new StageChannelJoinHelper$lurkAndJoinStage$1(context, fragmentManager, guildId, channelId, launchFullscreen, guildsStore, lurkingStore, selectedVoiceChannelStore, null), 3, null) : null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0184 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0185  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object lurkAndJoinStageAsync(Context context, FragmentManager fragmentManager, long j, long j2, boolean z2, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreVoiceChannelSelected storeVoiceChannelSelected, Continuation<? super Boolean> continuation) {
        StageChannelJoinHelper$lurkAndJoinStageAsync$1 stageChannelJoinHelper$lurkAndJoinStageAsync$1;
        FragmentManager fragmentManager2;
        StoreGuilds storeGuilds2;
        StoreLurking storeLurking2;
        long j3;
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
        Observable<Channel> observableZ;
        boolean z5;
        StageChannelJoinHelper stageChannelJoinHelper3;
        long j5;
        long j6;
        StoreLurking storeLurking4;
        FragmentManager fragmentManager4;
        Context context4;
        if (continuation instanceof StageChannelJoinHelper$lurkAndJoinStageAsync$1) {
            stageChannelJoinHelper$lurkAndJoinStageAsync$1 = (StageChannelJoinHelper$lurkAndJoinStageAsync$1) continuation;
            int i = stageChannelJoinHelper$lurkAndJoinStageAsync$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.label = i - Integer.MIN_VALUE;
            } else {
                stageChannelJoinHelper$lurkAndJoinStageAsync$1 = new StageChannelJoinHelper$lurkAndJoinStageAsync$1(this, continuation);
            }
        } else {
            stageChannelJoinHelper$lurkAndJoinStageAsync$1 = new StageChannelJoinHelper$lurkAndJoinStageAsync$1(this, continuation);
        }
        Object obj2 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.label;
        if (i2 != 0) {
            if (i2 == 1) {
                boolean z6 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0;
                j4 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1;
                j3 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0;
                StoreVoiceChannelSelected storeVoiceChannelSelected4 = (StoreVoiceChannelSelected) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$5;
                StoreLurking storeLurking5 = (StoreLurking) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4;
                StoreGuilds storeGuilds3 = (StoreGuilds) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3;
                FragmentManager fragmentManager5 = (FragmentManager) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2;
                context2 = (Context) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1;
                StageChannelJoinHelper stageChannelJoinHelper4 = (StageChannelJoinHelper) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0;
                l.throwOnFailure(obj2);
                storeVoiceChannelSelected2 = storeVoiceChannelSelected4;
                storeLurking2 = storeLurking5;
                obj = obj2;
                z3 = z6;
                fragmentManager2 = fragmentManager5;
                stageChannelJoinHelper = stageChannelJoinHelper4;
                storeGuilds2 = storeGuilds3;
            } else if (i2 == 2) {
                z4 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0;
                j4 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1;
                j3 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0;
                storeVoiceChannelSelected3 = (StoreVoiceChannelSelected) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4;
                storeLurking3 = (StoreLurking) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3;
                fragmentManager3 = (FragmentManager) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2;
                context3 = (Context) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1;
                stageChannelJoinHelper2 = (StageChannelJoinHelper) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0;
                l.throwOnFailure(obj2);
                observableZ = storeVoiceChannelSelected3.observeSelectedChannel().y(StageChannelJoinHelper$lurkAndJoinStageAsync$4.INSTANCE).z();
                m.checkNotNullExpressionValue(observableZ, "selectedVoiceChannelStor…= null }\n        .first()");
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0 = stageChannelJoinHelper2;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1 = context3;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2 = fragmentManager3;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3 = storeLurking3;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4 = null;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0 = j3;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1 = j4;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0 = z4;
                stageChannelJoinHelper$lurkAndJoinStageAsync$1.label = 3;
                if (RxCoroutineUtilsKt.awaitSingle(observableZ, stageChannelJoinHelper$lurkAndJoinStageAsync$1) == coroutine_suspended) {
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
                boolean z7 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0;
                long j7 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1;
                j6 = stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0;
                storeLurking4 = (StoreLurking) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3;
                FragmentManager fragmentManager6 = (FragmentManager) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2;
                Context context5 = (Context) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1;
                StageChannelJoinHelper stageChannelJoinHelper5 = (StageChannelJoinHelper) stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0;
                l.throwOnFailure(obj2);
                stageChannelJoinHelper3 = stageChannelJoinHelper5;
                z5 = z7;
                j5 = j7;
                fragmentManager4 = fragmentManager6;
                context4 = context5;
            }
            connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new StageChannelJoinHelper$lurkAndJoinStageAsync$5(storeLurking4, j6), 488, null);
            return b.boxBoolean(true);
        }
        l.throwOnFailure(obj2);
        storeVoiceChannelSelected.clear();
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0 = this;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1 = context;
        fragmentManager2 = fragmentManager;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2 = fragmentManager2;
        storeGuilds2 = storeGuilds;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3 = storeGuilds2;
        storeLurking2 = storeLurking;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4 = storeLurking2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$5 = storeVoiceChannelSelected;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0 = j;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1 = j2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0 = z2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.label = 1;
        s.a.l lVar = new s.a.l(d0.w.h.b.intercepted(stageChannelJoinHelper$lurkAndJoinStageAsync$1), 1);
        lVar.A();
        storeLurking.startLurking(j, b.boxLong(j2), false, new StageChannelJoinHelper$lurkAndJoinStageAsync$2$1(lVar), new StageChannelJoinHelper$lurkAndJoinStageAsync$2$2(lVar));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(stageChannelJoinHelper$lurkAndJoinStageAsync$1);
        }
        if (objU == coroutine_suspended) {
            return coroutine_suspended;
        }
        j3 = j;
        j4 = j2;
        stageChannelJoinHelper = this;
        obj = objU;
        storeVoiceChannelSelected2 = storeVoiceChannelSelected;
        context2 = context;
        z3 = z2;
        if (((Unit) obj) == null) {
            return b.boxBoolean(false);
        }
        Observable<Set<Long>> observableZ2 = storeGuilds2.observeGuildIds().y(new StageChannelJoinHelper$lurkAndJoinStageAsync$3(j3)).z();
        m.checkNotNullExpressionValue(observableZ2, "guildsStore\n        .obs…in ids }\n        .first()");
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0 = stageChannelJoinHelper;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1 = context2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2 = fragmentManager2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3 = storeLurking2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4 = storeVoiceChannelSelected2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$5 = null;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0 = j3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1 = j4;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0 = z3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.label = 2;
        if (RxCoroutineUtilsKt.awaitSingle(observableZ2, stageChannelJoinHelper$lurkAndJoinStageAsync$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        storeLurking3 = storeLurking2;
        context3 = context2;
        storeVoiceChannelSelected3 = storeVoiceChannelSelected2;
        stageChannelJoinHelper2 = stageChannelJoinHelper;
        fragmentManager3 = fragmentManager2;
        z4 = z3;
        observableZ = storeVoiceChannelSelected3.observeSelectedChannel().y(StageChannelJoinHelper$lurkAndJoinStageAsync$4.INSTANCE).z();
        m.checkNotNullExpressionValue(observableZ, "selectedVoiceChannelStor…= null }\n        .first()");
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$0 = stageChannelJoinHelper2;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$1 = context3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$2 = fragmentManager3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$3 = storeLurking3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.L$4 = null;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$0 = j3;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.J$1 = j4;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.Z$0 = z4;
        stageChannelJoinHelper$lurkAndJoinStageAsync$1.label = 3;
        if (RxCoroutineUtilsKt.awaitSingle(observableZ, stageChannelJoinHelper$lurkAndJoinStageAsync$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        z5 = z4;
        stageChannelJoinHelper3 = stageChannelJoinHelper2;
        j5 = j4;
        j6 = j3;
        storeLurking4 = storeLurking3;
        fragmentManager4 = fragmentManager3;
        context4 = context3;
        connectToStage$default(stageChannelJoinHelper3, context4, fragmentManager4, j5, false, z5, null, null, null, null, new StageChannelJoinHelper$lurkAndJoinStageAsync$5(storeLurking4, j6), 488, null);
        return b.boxBoolean(true);
    }

    @MainThread
    public final void verifyStageJoinability(Context context, FragmentManager fragmentManager, long channelId, Function0<Unit> onJoinVerified) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onJoinVerified, "onJoinVerified");
        int iOrdinal = VoiceChannelJoinabilityUtils.INSTANCE.getJoinability(channelId).ordinal();
        if (iOrdinal == 0) {
            onJoinVerified.invoke();
            return;
        }
        if (iOrdinal == 1) {
            b.a.d.m.g(context, 2131887549, 0, null, 12);
            return;
        }
        if (iOrdinal == 2) {
            b.a.a.m.k.a(fragmentManager);
        } else if (iOrdinal == 3) {
            b.a.d.m.g(context, 2131896558, 0, null, 12);
        } else {
            if (iOrdinal != 4) {
                return;
            }
            b.a.d.m.g(context, 2131891400, 0, null, 12);
        }
    }
}
