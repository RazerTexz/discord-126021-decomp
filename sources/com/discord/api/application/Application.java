package com.discord.api.application;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import d0.g0.w;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Application.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class Application {
    private final String coverImage;
    private final String deeplinkUri;
    private final String description;
    private final Long guildId;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;
    private final Team team;
    private final List<ThirdPartySku> thirdPartySkus;
    private final ApplicationType type;

    public final String a() {
        String strRemoveSuffix;
        String strW;
        String str = this.deeplinkUri;
        return (str == null || (strRemoveSuffix = w.removeSuffix(str, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) == null || (strW = a.w(strRemoveSuffix, "/_discord")) == null) ? a.C(a.U("dscd"), this.id, "://connect/_discord") : strW;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<String> d() {
        List<ThirdPartySku> list = this.thirdPartySkus;
        if (list == null) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (m.areEqual(((ThirdPartySku) obj).getDistributor(), "google_play")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strB = ((ThirdPartySku) it.next()).getSku();
            if (strB != null) {
                arrayList2.add(strB);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application application = (Application) other;
        return this.id == application.id && m.areEqual(this.name, application.name) && m.areEqual(this.description, application.description) && m.areEqual(this.splash, application.splash) && m.areEqual(this.coverImage, application.coverImage) && m.areEqual(this.icon, application.icon) && m.areEqual(this.thirdPartySkus, application.thirdPartySkus) && m.areEqual(this.deeplinkUri, application.deeplinkUri) && m.areEqual(this.type, application.type) && m.areEqual(this.guildId, application.guildId) && m.areEqual(this.team, application.team);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
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
        String str4 = this.coverImage;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<ThirdPartySku> list = this.thirdPartySkus;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        String str6 = this.deeplinkUri;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ApplicationType applicationType = this.type;
        int iHashCode8 = (iHashCode7 + (applicationType != null ? applicationType.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Team team = this.team;
        return iHashCode9 + (team != null ? team.hashCode() : 0);
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final ApplicationType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = a.U("Application(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", splash=");
        sbU.append(this.splash);
        sbU.append(", coverImage=");
        sbU.append(this.coverImage);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", thirdPartySkus=");
        sbU.append(this.thirdPartySkus);
        sbU.append(", deeplinkUri=");
        sbU.append(this.deeplinkUri);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", team=");
        sbU.append(this.team);
        sbU.append(")");
        return sbU.toString();
    }
}
