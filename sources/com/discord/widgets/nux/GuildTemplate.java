package com.discord.widgets.nux;

import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.guilds.create.StockGuildTemplate;

/* JADX INFO: compiled from: GuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum GuildTemplate {
    CreateMyOwn(2131891560, 2131231236, StockGuildTemplate.CREATE),
    Gaming(2131891564, 2131231239, StockGuildTemplate.GAMING_GROUP),
    SchoolClub(2131891566, 2131231234, StockGuildTemplate.CLUB),
    StudyGroup(2131891568, 2131231240, StockGuildTemplate.STUDY_GROUP),
    Friends(2131891563, 2131231238, StockGuildTemplate.FRIEND_GROUP),
    ArtistsAndCreators(2131891561, 2131231237, StockGuildTemplate.CONTENT_CREATOR),
    LocalCommunity(2131891559, 2131231235, StockGuildTemplate.LOCAL_COMMUNITY),
    HubStudyGroup(2131891568, 2131231238, StockGuildTemplate.HUB_STUDY_GROUP),
    HubSchoolClub(2131891566, 2131231235, StockGuildTemplate.HUB_SCHOOL_CLUB),
    Class(2131891557, 2131231240, StockGuildTemplate.CLASS),
    Social(2131891567, 2131231239, StockGuildTemplate.SOCIAL),
    SubjectOrMajor(2131891565, 2131231234, StockGuildTemplate.MAJOR),
    Dorm(2131891562, 2131231237, StockGuildTemplate.DORM);

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
