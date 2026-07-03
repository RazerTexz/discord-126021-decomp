package com.discord.widgets.nux;

import java.util.List;
import p507d0.p580t.C12147n;

/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateTypes {
    public static final GuildTemplateTypes INSTANCE = new GuildTemplateTypes();
    private static final List<GuildTemplate> NUX = C12147n.listOf((Object[]) new GuildTemplate[]{GuildTemplate.Gaming, GuildTemplate.SchoolClub, GuildTemplate.StudyGroup, GuildTemplate.Friends, GuildTemplate.ArtistsAndCreators, GuildTemplate.LocalCommunity});
    private static final List<GuildTemplate> HUB = C12147n.listOf((Object[]) new GuildTemplate[]{GuildTemplate.HubStudyGroup, GuildTemplate.HubSchoolClub, GuildTemplate.Class, GuildTemplate.Social, GuildTemplate.SubjectOrMajor, GuildTemplate.Dorm});

    private GuildTemplateTypes() {
    }

    public final List<GuildTemplate> getHUB() {
        return HUB;
    }

    public final List<GuildTemplate> getNUX() {
        return NUX;
    }
}
