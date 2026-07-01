package com.discord.widgets.nux;

import d0.t.n;
import java.util.List;

/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateTypes {
    public static final GuildTemplateTypes INSTANCE = new GuildTemplateTypes();
    private static final List<GuildTemplate> NUX = n.listOf((Object[]) new GuildTemplate[]{GuildTemplate.Gaming, GuildTemplate.SchoolClub, GuildTemplate.StudyGroup, GuildTemplate.Friends, GuildTemplate.ArtistsAndCreators, GuildTemplate.LocalCommunity});
    private static final List<GuildTemplate> HUB = n.listOf((Object[]) new GuildTemplate[]{GuildTemplate.HubStudyGroup, GuildTemplate.HubSchoolClub, GuildTemplate.Class, GuildTemplate.Social, GuildTemplate.SubjectOrMajor, GuildTemplate.Dorm});

    private GuildTemplateTypes() {
    }

    public final List<GuildTemplate> getHUB() {
        return HUB;
    }

    public final List<GuildTemplate> getNUX() {
        return NUX;
    }
}
