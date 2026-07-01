package com.discord.utilities.experiments;

import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildHubType;
import com.discord.models.experiments.domain.ExperimentHash;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import com.discord.models.experiments.dto.GuildExperimentDto;
import com.discord.models.experiments.dto.GuildExperimentFilter;
import com.discord.models.experiments.dto.GuildExperimentFilter$GuildHasFeatureFilter;
import com.discord.models.experiments.dto.GuildExperimentFilter$GuildHubTypesFeatureFilter;
import com.discord.models.experiments.dto.GuildExperimentFilter$GuildIdRangeFilter;
import com.discord.models.experiments.dto.GuildExperimentFilter$GuildIdsFilter;
import com.discord.models.experiments.dto.GuildExperimentFilter$GuildMemberCountRangeFilter;
import com.discord.models.experiments.dto.GuildExperimentOverridesDto;
import com.discord.models.experiments.dto.GuildExperimentPopulationDto;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.d0.f;
import d0.z.d.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ExperimentUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExperimentUtils {
    public static final int BUCKET_NOT_ELIGIBLE = -1;
    public static final ExperimentUtils INSTANCE = new ExperimentUtils();

    private ExperimentUtils() {
    }

    public final int computeGuildExperimentBucket(String experimentName, long guildId, int guildMemberCount, Guild guild, GuildExperimentDto experiment) {
        Object obj;
        boolean z2;
        boolean z3;
        boolean z4;
        String str = experimentName;
        m.checkNotNullParameter(str, "experimentName");
        m.checkNotNullParameter(experiment, "experiment");
        for (GuildExperimentOverridesDto guildExperimentOverridesDto : experiment.getOverrides()) {
            if (guildExperimentOverridesDto.getGuilds().contains(Long.valueOf(guildId))) {
                return guildExperimentOverridesDto.getBucket();
            }
        }
        StringBuilder sb = new StringBuilder();
        String hashKey = experiment.getHashKey();
        if (hashKey != null) {
            str = hashKey;
        }
        sb.append(str);
        sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sb.append(guildId);
        long jFrom = ExperimentHash.INSTANCE.from(sb.toString()) % ((long) 10000);
        for (GuildExperimentPopulationDto guildExperimentPopulationDto : experiment.getPopulations()) {
            Iterator<GuildExperimentFilter> it = guildExperimentPopulationDto.getFilters().iterator();
            boolean z5 = true;
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    break;
                }
                GuildExperimentFilter next = it.next();
                if (next instanceof GuildExperimentFilter$GuildIdsFilter) {
                    if (!((GuildExperimentFilter$GuildIdsFilter) next).getGuildIds().contains(Long.valueOf(guildId))) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter$GuildIdRangeFilter) {
                    if (!((GuildExperimentFilter$GuildIdRangeFilter) next).getRange().contains(guildId)) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter$GuildMemberCountRangeFilter) {
                    if (!f.longRangeContains(((GuildExperimentFilter$GuildMemberCountRangeFilter) next).getRange(), guildMemberCount)) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter$GuildHasFeatureFilter) {
                    Set<GuildFeature> features = ((GuildExperimentFilter$GuildHasFeatureFilter) next).getFeatures();
                    if (!(features instanceof Collection) || !features.isEmpty()) {
                        Iterator<T> it2 = features.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = true;
                                break;
                            }
                            if (guild != null && guild.hasFeature((GuildFeature) it2.next())) {
                                z3 = false;
                                break;
                            }
                        }
                    } else {
                        z3 = true;
                        break;
                    }
                    if (z3) {
                        z5 = false;
                    }
                } else if (next instanceof GuildExperimentFilter$GuildHubTypesFeatureFilter) {
                    Set<GuildHubType> hubTypes = ((GuildExperimentFilter$GuildHubTypesFeatureFilter) next).getHubTypes();
                    if (!(hubTypes instanceof Collection) || !hubTypes.isEmpty()) {
                        Iterator<T> it3 = hubTypes.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z4 = true;
                                break;
                            }
                            if ((guild != null ? guild.getHubType() : null) == ((GuildHubType) it3.next())) {
                                z4 = false;
                                break;
                            }
                        }
                    } else {
                        z4 = true;
                        break;
                    }
                    if (z4) {
                        z5 = false;
                    }
                }
            }
            if (z5) {
                for (Object obj2 : guildExperimentPopulationDto.getBuckets()) {
                    List<IntRange> positions = ((GuildExperimentBucketDto) obj2).getPositions();
                    if (!(positions instanceof Collection) || !positions.isEmpty()) {
                        Iterator<T> it4 = positions.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                z2 = false;
                                break;
                            }
                            IntRange intRange = (IntRange) it4.next();
                            if (jFrom >= ((long) intRange.getFirst()) && jFrom < ((long) intRange.getLast())) {
                                z2 = true;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        break;
                        break;
                    }
                    if (z2) {
                        obj = obj2;
                        break;
                    }
                }
                GuildExperimentBucketDto guildExperimentBucketDto = (GuildExperimentBucketDto) obj;
                if (guildExperimentBucketDto != null) {
                    return guildExperimentBucketDto.getBucket();
                }
                return 0;
            }
        }
        return -1;
    }
}
