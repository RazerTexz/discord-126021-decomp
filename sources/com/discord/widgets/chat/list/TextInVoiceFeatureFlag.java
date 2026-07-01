package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;

/* JADX INFO: compiled from: TextInVoiceFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = LazyJVM.lazy(TextInVoiceFeatureFlag2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    /* JADX INFO: compiled from: TextInVoiceFeatureFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public final TextInVoiceFeatureFlag getINSTANCE() {
            Lazy lazy = TextInVoiceFeatureFlag.INSTANCE$delegate;
            Companion companion = TextInVoiceFeatureFlag.INSTANCE;
            return (TextInVoiceFeatureFlag) lazy.getValue();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextInVoiceFeatureFlag() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public final boolean isEnabled(Long guildId) {
        if (guildId != null) {
            return isEnabled(this.storeExperiments.getGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.getGuild(guildId.longValue()));
        }
        return false;
    }

    public final Observable<Boolean> observeEnabled(Long guildId) {
        if (guildId == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Boolean.FALSE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(false)");
            return scalarSynchronousObservable;
        }
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.observeGuild(guildId.longValue()), new Func2<Experiment, Guild, Boolean>() { // from class: com.discord.widgets.chat.list.TextInVoiceFeatureFlag.observeEnabled.1
            @Override // rx.functions.Func2
            public final Boolean call(Experiment experiment, Guild guild) {
                return Boolean.valueOf(TextInVoiceFeatureFlag.this.isEnabled(experiment, guild));
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…xperiment, guild)\n      }");
        return observableJ;
    }

    public /* synthetic */ TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.TEXT_IN_VOICE_ENABLED));
    }
}
