package com.discord.widgets.chat.list;

import com.discord.api.guild.GuildFeature;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: TextInVoiceFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TextInVoiceFeatureFlag {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy INSTANCE$delegate = C12083g.lazy(TextInVoiceFeatureFlag$Companion$INSTANCE$2.INSTANCE);
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
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
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
            C12721k c12721k = new C12721k(Boolean.FALSE);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(false)");
            return c12721k;
        }
        Observable<Boolean> observableM11076j = Observable.m11076j(this.storeExperiments.observeGuildExperiment("2022-03_text_in_voice", guildId.longValue(), true), this.storeGuilds.observeGuild(guildId.longValue()), new Func2<Experiment, Guild, Boolean>() { // from class: com.discord.widgets.chat.list.TextInVoiceFeatureFlag.observeEnabled.1
            @Override // p658rx.functions.Func2
            public final Boolean call(Experiment experiment, Guild guild) {
                return Boolean.valueOf(TextInVoiceFeatureFlag.this.isEnabled(experiment, guild));
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…xperiment, guild)\n      }");
        return observableM11076j;
    }

    public /* synthetic */ TextInVoiceFeatureFlag(StoreExperiments storeExperiments, StoreGuilds storeGuilds, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 2) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds);
    }

    private final boolean isEnabled(Experiment experiment, Guild guild) {
        return (experiment != null && experiment.getBucket() == 1) || (guild != null && guild.hasFeature(GuildFeature.TEXT_IN_VOICE_ENABLED));
    }
}
