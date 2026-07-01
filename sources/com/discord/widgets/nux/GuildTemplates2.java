package com.discord.widgets.nux;

import d0.t.Collections2;
import java.util.List;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateTypes, reason: use source file name */
/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplates2 {
    public static final GuildTemplates2 INSTANCE = new GuildTemplates2();
    private static final List<GuildTemplates> NUX = Collections2.listOf((Object[]) new GuildTemplates[]{GuildTemplates.Gaming, GuildTemplates.SchoolClub, GuildTemplates.StudyGroup, GuildTemplates.Friends, GuildTemplates.ArtistsAndCreators, GuildTemplates.LocalCommunity});
    private static final List<GuildTemplates> HUB = Collections2.listOf((Object[]) new GuildTemplates[]{GuildTemplates.HubStudyGroup, GuildTemplates.HubSchoolClub, GuildTemplates.Class, GuildTemplates.Social, GuildTemplates.SubjectOrMajor, GuildTemplates.Dorm});

    private GuildTemplates2() {
    }

    public final List<GuildTemplates> getHUB() {
        return HUB;
    }

    public final List<GuildTemplates> getNUX() {
        return NUX;
    }
}
