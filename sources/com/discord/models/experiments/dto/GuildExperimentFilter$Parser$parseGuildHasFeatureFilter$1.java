package com.discord.models.experiments.dto;

import com.discord.api.guild.GuildFeature;
import com.discord.models.deserialization.gson.InboundGatewayGsonParser;
import com.discord.models.domain.Model;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $features;
    public final /* synthetic */ Model.JsonReader $reader;

    public GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1(Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef) {
        this.$reader = jsonReader;
        this.$features = ref$ObjectRef;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.$reader.nextListIndexed(new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.1
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader.skipValue();
            }
        }, new Runnable() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.2
            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.Set] */
            @Override // java.lang.Runnable
            public final void run() throws IOException {
                GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1 = GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this;
                Ref$ObjectRef ref$ObjectRef = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$features;
                List listNextList = guildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.$reader.nextList(new Model.JsonReader.ItemFactory<GuildFeature>() { // from class: com.discord.models.experiments.dto.GuildExperimentFilter.Parser.parseGuildHasFeatureFilter.1.2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
                    public final GuildFeature get() {
                        return (GuildFeature) InboundGatewayGsonParser.fromJson(GuildExperimentFilter$Parser$parseGuildHasFeatureFilter$1.this.$reader, GuildFeature.class);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(listNextList, "reader.nextList {\n      …ass.java)\n              }");
                ref$ObjectRef.element = _Collections.toSet(listNextList);
            }
        });
    }
}
