package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import d0.g;
import d0.z.d.m;
import j0.l.e.k;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: TextInVoiceFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag {
    public static final TextInVoiceFeatureFlag$Companion Companion = new TextInVoiceFeatureFlag$Companion(null);
    private static final Lazy INSTANCE$delegate = g.lazy(TextInVoiceFeatureFlag$Companion$INSTANCE$2.INSTANCE);
    private final StoreExperiments storeExperiments;
    private final StoreGuilds storeGuilds;

    public TextInVoiceFeatureFlag() {
        this(null, null, 3, null);
    }

    public TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds) {
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.storeExperiments = storeExperiments;
        this.storeGuilds = storeGuilds;
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$cp() {
        return INSTANCE$delegate;
    }

    public static final /* synthetic */ boolean access$isEnabled(TextInVoiceFeatureFlag textInVoiceFeatureFlag, Experiment experiment, Guild guild) {
        return textInVoiceFeatureFlag.isEnabled(experiment, guild);
    }

    public final boolean isEnabled(Long guildId) {
        if (guildId != null) {
            return isEnabled(this.storeExperiments.getGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.getGuild(guildId.longValue()));
        }
        return false;
    }

    public final Observable<Boolean> observeEnabled(Long guildId) {
        if (guildId == null) {
            k kVar = new k(Boolean.FALSE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(false)");
            return kVar;
        }
        Observable<Boolean> observableJ = Observable.j(this.storeExperiments.observeGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.observeGuild(guildId.longValue()), new TextInVoiceFeatureFlag$observeEnabled$1(this));
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…xperiment, guild)\n      }");
        return observableJ;
    }

    public /* synthetic */ TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.TEXT_IN_VOICE_ENABLED));
    }
}
