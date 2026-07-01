package com.discord.api.guild.preview;

import b.d.b.a.outline;
import com.discord.api.emoji.GuildEmoji;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: GuildPreview.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class GuildPreview {
    private final Integer approximateMemberCount;
    private final Integer approximatePresenceCount;
    private final String banner;
    private final String description;
    private final List<GuildEmoji> emojis;
    private final Boolean featurableInDirectory;
    private final List<GuildFeature> features;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getApproximateMemberCount() {
        return this.approximateMemberCount;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Integer getApproximatePresenceCount() {
        return this.approximatePresenceCount;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<GuildEmoji> d() {
        return this.emojis;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Boolean getFeaturableInDirectory() {
        return this.featurableInDirectory;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildPreview)) {
            return false;
        }
        GuildPreview guildPreview = (GuildPreview) other;
        return this.id == guildPreview.id && Intrinsics3.areEqual(this.name, guildPreview.name) && Intrinsics3.areEqual(this.description, guildPreview.description) && Intrinsics3.areEqual(this.splash, guildPreview.splash) && Intrinsics3.areEqual(this.banner, guildPreview.banner) && Intrinsics3.areEqual(this.icon, guildPreview.icon) && Intrinsics3.areEqual(this.approximatePresenceCount, guildPreview.approximatePresenceCount) && Intrinsics3.areEqual(this.approximateMemberCount, guildPreview.approximateMemberCount) && Intrinsics3.areEqual(this.emojis, guildPreview.emojis) && Intrinsics3.areEqual(this.features, guildPreview.features) && Intrinsics3.areEqual(this.featurableInDirectory, guildPreview.featurableInDirectory);
    }

    public final List<GuildFeature> f() {
        return this.features;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.splash;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.banner;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Integer num = this.approximatePresenceCount;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.approximateMemberCount;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        List<GuildEmoji> list = this.emojis;
        int iHashCode8 = (iHashCode7 + (list != null ? list.hashCode() : 0)) * 31;
        List<GuildFeature> list2 = this.features;
        int iHashCode9 = (iHashCode8 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Boolean bool = this.featurableInDirectory;
        return iHashCode9 + (bool != null ? bool.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildPreview(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", banner=");
        sbU.append(this.banner);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", approximatePresenceCount=");
        sbU.append(this.approximatePresenceCount);
        sbU.append(", approximateMemberCount=");
        sbU.append(this.approximateMemberCount);
        sbU.append(", emojis=");
        sbU.append(this.emojis);
        sbU.append(", features=");
        sbU.append(this.features);
        sbU.append(", featurableInDirectory=");
        return outline.D(sbU, this.featurableInDirectory, ")");
    }
}
