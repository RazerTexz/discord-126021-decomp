package com.discord.widgets.nux;

import com.discord.R;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.guilds.create.StockGuildTemplate;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplate, reason: use source file name */
/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GuildTemplates {
    CreateMyOwn(R.string.guild_template_header_create, R.drawable.drawable_guild_template_create, StockGuildTemplate.CREATE),
    Gaming(R.string.guild_template_header_gaming, R.drawable.drawable_guild_template_gaming, StockGuildTemplate.GAMING_GROUP),
    SchoolClub(R.string.guild_template_header_school_club, R.drawable.drawable_guild_template_club, StockGuildTemplate.CLUB),
    StudyGroup(R.string.guild_template_header_study, R.drawable.drawable_guild_template_study, StockGuildTemplate.STUDY_GROUP),
    Friends(R.string.guild_template_header_friend, R.drawable.drawable_guild_template_friend, StockGuildTemplate.FRIEND_GROUP),
    ArtistsAndCreators(R.string.guild_template_header_creator, R.drawable.drawable_guild_template_creator, StockGuildTemplate.CONTENT_CREATOR),
    LocalCommunity(R.string.guild_template_header_community, R.drawable.drawable_guild_template_community, StockGuildTemplate.LOCAL_COMMUNITY),
    HubStudyGroup(R.string.guild_template_header_study, R.drawable.drawable_guild_template_friend, StockGuildTemplate.HUB_STUDY_GROUP),
    HubSchoolClub(R.string.guild_template_header_school_club, R.drawable.drawable_guild_template_community, StockGuildTemplate.HUB_SCHOOL_CLUB),
    Class(R.string.guild_template_header_class, R.drawable.drawable_guild_template_study, StockGuildTemplate.CLASS),
    Social(R.string.guild_template_header_social, R.drawable.drawable_guild_template_gaming, StockGuildTemplate.SOCIAL),
    SubjectOrMajor(R.string.guild_template_header_major, R.drawable.drawable_guild_template_club, StockGuildTemplate.MAJOR),
    Dorm(R.string.guild_template_header_dorm, R.drawable.drawable_guild_template_creator, StockGuildTemplate.DORM);

    private final int drawableRes;
    private final StockGuildTemplate templateType;
    private final int titleRes;

    GuildTemplates(int i, int i2, StockGuildTemplate stockGuildTemplate) {
        this.titleRes = i;
        this.drawableRes = i2;
        this.templateType = stockGuildTemplate;
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final StockGuildTemplate getTemplateType() {
        return this.templateType;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
