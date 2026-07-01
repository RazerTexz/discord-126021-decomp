package com.discord.widgets.guilds.create;

import android.content.res.Resources;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.b;
import com.discord.restapi.RestAPIParams$CreateGuildChannel;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: StockGuildTemplate.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum StockGuildTemplate {
    FRIEND_GROUP,
    STUDY_GROUP,
    GAMING_GROUP,
    CONTENT_CREATOR,
    CLUB,
    LOCAL_COMMUNITY,
    HUB_SCHOOL_CLUB,
    HUB_STUDY_GROUP,
    CLASS,
    SOCIAL,
    MAJOR,
    DORM,
    CREATE;

    public final List<RestAPIParams$CreateGuildChannel> getChannels(Resources resources) {
        m.checkNotNullParameter(resources, "resources");
        switch (this) {
            case FRIEND_GROUP:
                String string = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string, "resources.getString(R.st…plate_name_category_text)");
                String string2 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string2, "resources.getString(R.st…ld_template_name_general)");
                String string3 = resources.getString(2131891610);
                m.checkNotNullExpressionValue(string3, "resources.getString(R.st…guild_template_name_game)");
                String string4 = resources.getString(2131891618);
                m.checkNotNullExpressionValue(string4, "resources.getString(R.st…uild_template_name_music)");
                List listAccess$createCategorySection = StockGuildTemplateKt.access$createCategorySection(string, 100L, 0, new ChannelTemplate$SystemChannel(string2), new ChannelTemplate$NormalChannel(string3), new ChannelTemplate$NormalChannel(string4));
                String string5 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string5, "resources.getString(R.st…late_name_category_voice)");
                String string6 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string6, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string7 = resources.getString(2131891632);
                m.checkNotNullExpressionValue(string7, "resources.getString(R.st…e_name_voice_stream_room)");
                return u.plus((Collection) listAccess$createCategorySection, (Iterable) StockGuildTemplateKt.access$createCategorySection(string5, 200L, 2, new ChannelTemplate$NormalChannel(string6), new ChannelTemplate$NormalChannel(string7)));
            case STUDY_GROUP:
                String string8 = resources.getString(2131891604);
                m.checkNotNullExpressionValue(string8, "resources.getString(R.st…ame_category_information)");
                String string9 = resources.getString(2131891635);
                m.checkNotNullExpressionValue(string9, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string10 = resources.getString(2131891619);
                m.checkNotNullExpressionValue(string10, "resources.getString(R.st…ate_name_notes_resources)");
                List listAccess$createCategorySection2 = StockGuildTemplateKt.access$createCategorySection(string8, 100L, 0, new ChannelTemplate$NormalChannel(string9), new ChannelTemplate$NormalChannel(string10));
                String string11 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string11, "resources.getString(R.st…plate_name_category_text)");
                String string12 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string12, "resources.getString(R.st…ld_template_name_general)");
                String string13 = resources.getString(2131891613);
                m.checkNotNullExpressionValue(string13, "resources.getString(R.st…plate_name_homework_help)");
                String string14 = resources.getString(2131891622);
                m.checkNotNullExpressionValue(string14, "resources.getString(R.st…te_name_session_planning)");
                String string15 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string15, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus = u.plus((Collection) listAccess$createCategorySection2, (Iterable) StockGuildTemplateKt.access$createCategorySection(string11, 200L, 0, new ChannelTemplate$SystemChannel(string12), new ChannelTemplate$NormalChannel(string13), new ChannelTemplate$NormalChannel(string14), new ChannelTemplate$NormalChannel(string15)));
                String string16 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string16, "resources.getString(R.st…late_name_category_voice)");
                String string17 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string17, "resources.getString(R.st…mplate_name_voice_lounge)");
                return u.plus((Collection) listPlus, (Iterable) StockGuildTemplateKt.access$createCategorySection(string16, 300L, 2, new ChannelTemplate$NormalChannel(string17), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{"1"}, null, 4).toString()), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, null, 4).toString())));
            case GAMING_GROUP:
                String string18 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string18, "resources.getString(R.st…plate_name_category_text)");
                String string19 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string19, "resources.getString(R.st…ld_template_name_general)");
                String string20 = resources.getString(2131891607);
                m.checkNotNullExpressionValue(string20, "resources.getString(R.st…ame_clips_and_highlights)");
                List listAccess$createCategorySection3 = StockGuildTemplateKt.access$createCategorySection(string18, 100L, 0, new ChannelTemplate$SystemChannel(string19), new ChannelTemplate$NormalChannel(string20));
                String string21 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string21, "resources.getString(R.st…late_name_category_voice)");
                String string22 = resources.getString(2131891626);
                m.checkNotNullExpressionValue(string22, "resources.getString(R.st…emplate_name_voice_lobby)");
                String string23 = resources.getString(2131891625);
                m.checkNotNullExpressionValue(string23, "resources.getString(R.st…mplate_name_voice_gaming)");
                return u.plus((Collection) listAccess$createCategorySection3, (Iterable) StockGuildTemplateKt.access$createCategorySection(string21, 200L, 2, new ChannelTemplate$NormalChannel(string22), new ChannelTemplate$NormalChannel(string23)));
            case CONTENT_CREATOR:
                String string24 = resources.getString(2131891604);
                m.checkNotNullExpressionValue(string24, "resources.getString(R.st…ame_category_information)");
                String string25 = resources.getString(2131891635);
                m.checkNotNullExpressionValue(string25, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string26 = resources.getString(2131891600);
                m.checkNotNullExpressionValue(string26, "resources.getString(R.st…plate_name_announcements)");
                List listAccess$createCategorySection4 = StockGuildTemplateKt.access$createCategorySection(string24, 100L, 0, new ChannelTemplate$NormalChannel(string25), new ChannelTemplate$NormalChannel(string26));
                String string27 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string27, "resources.getString(R.st…plate_name_category_text)");
                String string28 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string28, "resources.getString(R.st…ld_template_name_general)");
                String string29 = resources.getString(2131891609);
                m.checkNotNullExpressionValue(string29, "resources.getString(R.st…ild_template_name_events)");
                String string30 = resources.getString(2131891614);
                m.checkNotNullExpressionValue(string30, "resources.getString(R.st…_name_ideas_and_feedback)");
                List listPlus2 = u.plus((Collection) listAccess$createCategorySection4, (Iterable) StockGuildTemplateKt.access$createCategorySection(string27, 200L, 0, new ChannelTemplate$SystemChannel(string28), new ChannelTemplate$NormalChannel(string29), new ChannelTemplate$NormalChannel(string30)));
                String string31 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string31, "resources.getString(R.st…late_name_category_voice)");
                String string32 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string32, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string33 = resources.getString(2131891623);
                m.checkNotNullExpressionValue(string33, "resources.getString(R.st…_voice_community_hangout)");
                String string34 = resources.getString(2131891632);
                m.checkNotNullExpressionValue(string34, "resources.getString(R.st…e_name_voice_stream_room)");
                return u.plus((Collection) listPlus2, (Iterable) StockGuildTemplateKt.access$createCategorySection(string31, 300L, 2, new ChannelTemplate$NormalChannel(string32), new ChannelTemplate$NormalChannel(string33), new ChannelTemplate$NormalChannel(string34)));
            case CLUB:
                String string35 = resources.getString(2131891604);
                m.checkNotNullExpressionValue(string35, "resources.getString(R.st…ame_category_information)");
                String string36 = resources.getString(2131891635);
                m.checkNotNullExpressionValue(string36, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string37 = resources.getString(2131891600);
                m.checkNotNullExpressionValue(string37, "resources.getString(R.st…plate_name_announcements)");
                List listAccess$createCategorySection5 = StockGuildTemplateKt.access$createCategorySection(string35, 100L, 0, new ChannelTemplate$NormalChannel(string36), new ChannelTemplate$NormalChannel(string37));
                String string38 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string38, "resources.getString(R.st…plate_name_category_text)");
                String string39 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string39, "resources.getString(R.st…ld_template_name_general)");
                String string40 = resources.getString(2131891616);
                m.checkNotNullExpressionValue(string40, "resources.getString(R.st…plate_name_meeting_plans)");
                List listPlus3 = u.plus((Collection) listAccess$createCategorySection5, (Iterable) StockGuildTemplateKt.access$createCategorySection(string38, 200L, 0, new ChannelTemplate$SystemChannel(string39), new ChannelTemplate$NormalChannel(string40)));
                String string41 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string41, "resources.getString(R.st…late_name_category_voice)");
                String string42 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string42, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string43 = resources.getString(2131891628);
                m.checkNotNullExpressionValue(string43, "resources.getString(R.st…_name_voice_meeting_room)");
                return u.plus((Collection) listPlus3, (Iterable) StockGuildTemplateKt.access$createCategorySection(string41, 300L, 2, new ChannelTemplate$NormalChannel(string42), new ChannelTemplate$NormalChannel(string43)));
            case LOCAL_COMMUNITY:
                String string44 = resources.getString(2131891604);
                m.checkNotNullExpressionValue(string44, "resources.getString(R.st…ame_category_information)");
                String string45 = resources.getString(2131891635);
                m.checkNotNullExpressionValue(string45, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string46 = resources.getString(2131891600);
                m.checkNotNullExpressionValue(string46, "resources.getString(R.st…plate_name_announcements)");
                String string47 = resources.getString(2131891621);
                m.checkNotNullExpressionValue(string47, "resources.getString(R.st…_template_name_resources)");
                List listAccess$createCategorySection6 = StockGuildTemplateKt.access$createCategorySection(string44, 100L, 0, new ChannelTemplate$NormalChannel(string45), new ChannelTemplate$NormalChannel(string46), new ChannelTemplate$NormalChannel(string47));
                String string48 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string48, "resources.getString(R.st…plate_name_category_text)");
                String string49 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string49, "resources.getString(R.st…ld_template_name_general)");
                String string50 = resources.getString(2131891616);
                m.checkNotNullExpressionValue(string50, "resources.getString(R.st…plate_name_meeting_plans)");
                String string51 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string51, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus4 = u.plus((Collection) listAccess$createCategorySection6, (Iterable) StockGuildTemplateKt.access$createCategorySection(string48, 200L, 0, new ChannelTemplate$SystemChannel(string49), new ChannelTemplate$NormalChannel(string50), new ChannelTemplate$NormalChannel(string51)));
                String string52 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string52, "resources.getString(R.st…late_name_category_voice)");
                String string53 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string53, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string54 = resources.getString(2131891628);
                m.checkNotNullExpressionValue(string54, "resources.getString(R.st…_name_voice_meeting_room)");
                return u.plus((Collection) listPlus4, (Iterable) StockGuildTemplateKt.access$createCategorySection(string52, 300L, 2, new ChannelTemplate$NormalChannel(string53), new ChannelTemplate$NormalChannel(string54)));
            case HUB_SCHOOL_CLUB:
                String string55 = resources.getString(2131891604);
                m.checkNotNullExpressionValue(string55, "resources.getString(R.st…ame_category_information)");
                String string56 = resources.getString(2131891635);
                m.checkNotNullExpressionValue(string56, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string57 = resources.getString(2131891600);
                m.checkNotNullExpressionValue(string57, "resources.getString(R.st…plate_name_announcements)");
                String string58 = resources.getString(2131891621);
                m.checkNotNullExpressionValue(string58, "resources.getString(R.st…_template_name_resources)");
                List listAccess$createCategorySection7 = StockGuildTemplateKt.access$createCategorySection(string55, 100L, 0, new ChannelTemplate$NormalChannel(string56), new ChannelTemplate$NormalChannel(string57), new ChannelTemplate$NormalChannel(string58));
                String string59 = resources.getString(2131891605);
                m.checkNotNullExpressionValue(string59, "resources.getString(R.st…plate_name_category_text)");
                String string60 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string60, "resources.getString(R.st…ld_template_name_general)");
                String string61 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string61, "resources.getString(R.st…plate_name_introductions)");
                String string62 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string62, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus5 = u.plus((Collection) listAccess$createCategorySection7, (Iterable) StockGuildTemplateKt.access$createCategorySection(string59, 200L, 0, new ChannelTemplate$SystemChannel(string60), new ChannelTemplate$NormalChannel(string61), new ChannelTemplate$NormalChannel(string62)));
                String string63 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string63, "resources.getString(R.st…late_name_category_voice)");
                String string64 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string64, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string65 = resources.getString(2131891629);
                m.checkNotNullExpressionValue(string65, "resources.getString(R.st…ame_voice_meeting_room_1)");
                String string66 = resources.getString(2131891630);
                m.checkNotNullExpressionValue(string66, "resources.getString(R.st…ame_voice_meeting_room_2)");
                return u.plus((Collection) listPlus5, (Iterable) StockGuildTemplateKt.access$createCategorySection(string63, 300L, 2, new ChannelTemplate$NormalChannel(string64), new ChannelTemplate$NormalChannel(string65), new ChannelTemplate$NormalChannel(string66)));
            case HUB_STUDY_GROUP:
                String string67 = resources.getString(2131891603);
                m.checkNotNullExpressionValue(string67, "resources.getString(R.st…plate_name_category_info)");
                String string68 = resources.getString(2131891619);
                m.checkNotNullExpressionValue(string68, "resources.getString(R.st…ate_name_notes_resources)");
                String string69 = resources.getString(2131891612);
                m.checkNotNullExpressionValue(string69, "resources.getString(R.st…late_name_help_questions)");
                List listAccess$createCategorySection8 = StockGuildTemplateKt.access$createCategorySection(string67, 100L, 0, new ChannelTemplate$NormalChannel(string68), new ChannelTemplate$NormalChannel(string69));
                String string70 = resources.getString(2131891602);
                m.checkNotNullExpressionValue(string70, "resources.getString(R.st…plate_name_category_chat)");
                String string71 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string71, "resources.getString(R.st…plate_name_introductions)");
                String string72 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string72, "resources.getString(R.st…ld_template_name_general)");
                String string73 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string73, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus6 = u.plus((Collection) listAccess$createCategorySection8, (Iterable) StockGuildTemplateKt.access$createCategorySection(string70, 200L, 0, new ChannelTemplate$NormalChannel(string71), new ChannelTemplate$SystemChannel(string72), new ChannelTemplate$NormalChannel(string73)));
                String string74 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string74, "resources.getString(R.st…late_name_category_voice)");
                String string75 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string75, "resources.getString(R.st…mplate_name_voice_lounge)");
                return u.plus((Collection) listPlus6, (Iterable) StockGuildTemplateKt.access$createCategorySection(string74, 300L, 2, new ChannelTemplate$NormalChannel(string75), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{1}, null, 4).toString()), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{2}, null, 4).toString())));
            case CLASS:
                String string76 = resources.getString(2131891603);
                m.checkNotNullExpressionValue(string76, "resources.getString(R.st…plate_name_category_info)");
                String string77 = resources.getString(2131891601);
                m.checkNotNullExpressionValue(string77, "resources.getString(R.st…emplate_name_assignments)");
                String string78 = resources.getString(2131891612);
                m.checkNotNullExpressionValue(string78, "resources.getString(R.st…late_name_help_questions)");
                String string79 = resources.getString(2131891621);
                m.checkNotNullExpressionValue(string79, "resources.getString(R.st…_template_name_resources)");
                List listAccess$createCategorySection9 = StockGuildTemplateKt.access$createCategorySection(string76, 100L, 0, new ChannelTemplate$NormalChannel(string77), new ChannelTemplate$NormalChannel(string78), new ChannelTemplate$NormalChannel(string79));
                String string80 = resources.getString(2131891602);
                m.checkNotNullExpressionValue(string80, "resources.getString(R.st…plate_name_category_chat)");
                String string81 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string81, "resources.getString(R.st…plate_name_introductions)");
                String string82 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string82, "resources.getString(R.st…ld_template_name_general)");
                String string83 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string83, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus7 = u.plus((Collection) listAccess$createCategorySection9, (Iterable) StockGuildTemplateKt.access$createCategorySection(string80, 200L, 0, new ChannelTemplate$NormalChannel(string81), new ChannelTemplate$SystemChannel(string82), new ChannelTemplate$NormalChannel(string83)));
                String string84 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string84, "resources.getString(R.st…late_name_category_voice)");
                String string85 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string85, "resources.getString(R.st…mplate_name_voice_lounge)");
                return u.plus((Collection) listPlus7, (Iterable) StockGuildTemplateKt.access$createCategorySection(string84, 300L, 2, new ChannelTemplate$NormalChannel(string85), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{1}, null, 4).toString()), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{2}, null, 4).toString())));
            case SOCIAL:
                String string86 = resources.getString(2131891602);
                m.checkNotNullExpressionValue(string86, "resources.getString(R.st…plate_name_category_chat)");
                String string87 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string87, "resources.getString(R.st…plate_name_introductions)");
                String string88 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string88, "resources.getString(R.st…ld_template_name_general)");
                String string89 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string89, "resources.getString(R.st…_template_name_off_topic)");
                String string90 = resources.getString(2131891617);
                m.checkNotNullExpressionValue(string90, "resources.getString(R.st…ld_template_name_meetups)");
                List listAccess$createCategorySection10 = StockGuildTemplateKt.access$createCategorySection(string86, 200L, 0, new ChannelTemplate$NormalChannel(string87), new ChannelTemplate$SystemChannel(string88), new ChannelTemplate$NormalChannel(string89), new ChannelTemplate$NormalChannel(string90));
                String string91 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string91, "resources.getString(R.st…late_name_category_voice)");
                String string92 = resources.getString(2131891624);
                m.checkNotNullExpressionValue(string92, "resources.getString(R.st…plate_name_voice_couches)");
                String string93 = resources.getString(2131891631);
                m.checkNotNullExpressionValue(string93, "resources.getString(R.st…te_name_voice_movie_room)");
                String string94 = resources.getString(2131891634);
                m.checkNotNullExpressionValue(string94, "resources.getString(R.st…ce_unnumbered_study_room)");
                return u.plus((Collection) listAccess$createCategorySection10, (Iterable) StockGuildTemplateKt.access$createCategorySection(string91, 300L, 2, new ChannelTemplate$NormalChannel(string92), new ChannelTemplate$NormalChannel(string93), new ChannelTemplate$NormalChannel(string94)));
            case MAJOR:
                String string95 = resources.getString(2131891603);
                m.checkNotNullExpressionValue(string95, "resources.getString(R.st…plate_name_category_info)");
                String string96 = resources.getString(2131891621);
                m.checkNotNullExpressionValue(string96, "resources.getString(R.st…_template_name_resources)");
                String string97 = resources.getString(2131891612);
                m.checkNotNullExpressionValue(string97, "resources.getString(R.st…late_name_help_questions)");
                List listAccess$createCategorySection11 = StockGuildTemplateKt.access$createCategorySection(string95, 100L, 0, new ChannelTemplate$NormalChannel(string96), new ChannelTemplate$NormalChannel(string97));
                String string98 = resources.getString(2131891602);
                m.checkNotNullExpressionValue(string98, "resources.getString(R.st…plate_name_category_chat)");
                String string99 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string99, "resources.getString(R.st…plate_name_introductions)");
                String string100 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string100, "resources.getString(R.st…ld_template_name_general)");
                String string101 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string101, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus8 = u.plus((Collection) listAccess$createCategorySection11, (Iterable) StockGuildTemplateKt.access$createCategorySection(string98, 200L, 0, new ChannelTemplate$NormalChannel(string99), new ChannelTemplate$SystemChannel(string100), new ChannelTemplate$NormalChannel(string101)));
                String string102 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string102, "resources.getString(R.st…late_name_category_voice)");
                String string103 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string103, "resources.getString(R.st…mplate_name_voice_lounge)");
                return u.plus((Collection) listPlus8, (Iterable) StockGuildTemplateKt.access$createCategorySection(string102, 300L, 2, new ChannelTemplate$NormalChannel(string103), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{1}, null, 4).toString()), new ChannelTemplate$NormalChannel(b.i(resources, 2131891633, new Object[]{2}, null, 4).toString())));
            case DORM:
                String string104 = resources.getString(2131891603);
                m.checkNotNullExpressionValue(string104, "resources.getString(R.st…plate_name_category_info)");
                String string105 = resources.getString(2131891608);
                m.checkNotNullExpressionValue(string105, "resources.getString(R.st…_template_name_dorm_news)");
                List listAccess$createCategorySection12 = StockGuildTemplateKt.access$createCategorySection(string104, 100L, 0, new ChannelTemplate$NormalChannel(string105));
                String string106 = resources.getString(2131891602);
                m.checkNotNullExpressionValue(string106, "resources.getString(R.st…plate_name_category_chat)");
                String string107 = resources.getString(2131891615);
                m.checkNotNullExpressionValue(string107, "resources.getString(R.st…plate_name_introductions)");
                String string108 = resources.getString(2131891611);
                m.checkNotNullExpressionValue(string108, "resources.getString(R.st…ld_template_name_general)");
                String string109 = resources.getString(2131891620);
                m.checkNotNullExpressionValue(string109, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus9 = u.plus((Collection) listAccess$createCategorySection12, (Iterable) StockGuildTemplateKt.access$createCategorySection(string106, 200L, 0, new ChannelTemplate$NormalChannel(string107), new ChannelTemplate$SystemChannel(string108), new ChannelTemplate$NormalChannel(string109)));
                String string110 = resources.getString(2131891606);
                m.checkNotNullExpressionValue(string110, "resources.getString(R.st…late_name_category_voice)");
                String string111 = resources.getString(2131891627);
                m.checkNotNullExpressionValue(string111, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string112 = resources.getString(2131891631);
                m.checkNotNullExpressionValue(string112, "resources.getString(R.st…te_name_voice_movie_room)");
                String string113 = resources.getString(2131891624);
                m.checkNotNullExpressionValue(string113, "resources.getString(R.st…plate_name_voice_couches)");
                return u.plus((Collection) listPlus9, (Iterable) StockGuildTemplateKt.access$createCategorySection(string110, 300L, 2, new ChannelTemplate$NormalChannel(string111), new ChannelTemplate$NormalChannel(string112), new ChannelTemplate$NormalChannel(string113)));
            case CREATE:
                return n.emptyList();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final long getSystemChannelId() {
        return 11L;
    }
}
