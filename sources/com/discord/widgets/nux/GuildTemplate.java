package com.discord.widgets.nux;

import com.discord.C5419R;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.guilds.create.StockGuildTemplate;

/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GuildTemplate {
    CreateMyOwn(C5419R.string.guild_template_header_create, C5419R.drawable.drawable_guild_template_create, StockGuildTemplate.CREATE),
    Gaming(C5419R.string.guild_template_header_gaming, C5419R.drawable.drawable_guild_template_gaming, StockGuildTemplate.GAMING_GROUP),
    SchoolClub(C5419R.string.guild_template_header_school_club, C5419R.drawable.drawable_guild_template_club, StockGuildTemplate.CLUB),
    StudyGroup(C5419R.string.guild_template_header_study, C5419R.drawable.drawable_guild_template_study, StockGuildTemplate.STUDY_GROUP),
    Friends(C5419R.string.guild_template_header_friend, C5419R.drawable.drawable_guild_template_friend, StockGuildTemplate.FRIEND_GROUP),
    ArtistsAndCreators(C5419R.string.guild_template_header_creator, C5419R.drawable.drawable_guild_template_creator, StockGuildTemplate.CONTENT_CREATOR),
    LocalCommunity(C5419R.string.guild_template_header_community, C5419R.drawable.drawable_guild_template_community, StockGuildTemplate.LOCAL_COMMUNITY),
    HubStudyGroup(C5419R.string.guild_template_header_study, C5419R.drawable.drawable_guild_template_friend, StockGuildTemplate.HUB_STUDY_GROUP),
    HubSchoolClub(C5419R.string.guild_template_header_school_club, C5419R.drawable.drawable_guild_template_community, StockGuildTemplate.HUB_SCHOOL_CLUB),
    Class(C5419R.string.guild_template_header_class, C5419R.drawable.drawable_guild_template_study, StockGuildTemplate.CLASS),
    Social(C5419R.string.guild_template_header_social, C5419R.drawable.drawable_guild_template_gaming, StockGuildTemplate.SOCIAL),
    SubjectOrMajor(C5419R.string.guild_template_header_major, C5419R.drawable.drawable_guild_template_club, StockGuildTemplate.MAJOR),
    Dorm(C5419R.string.guild_template_header_dorm, C5419R.drawable.drawable_guild_template_creator, StockGuildTemplate.DORM);

    private final int drawableRes;
    private final StockGuildTemplate templateType;
    private final int titleRes;

    GuildTemplate(int i, int i2, StockGuildTemplate stockGuildTemplate) {
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
