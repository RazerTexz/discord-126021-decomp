package com.discord.widgets.guilds.create;

import android.content.res.Resources;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.restapi.RestAPIParams;
import com.discord.widgets.guilds.create.StockGuildTemplate2;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
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

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StockGuildTemplate.values();
            int[] iArr = new int[13];
            $EnumSwitchMapping$0 = iArr;
            iArr[StockGuildTemplate.GAMING_GROUP.ordinal()] = 1;
            iArr[StockGuildTemplate.FRIEND_GROUP.ordinal()] = 2;
            iArr[StockGuildTemplate.STUDY_GROUP.ordinal()] = 3;
            iArr[StockGuildTemplate.CLUB.ordinal()] = 4;
            iArr[StockGuildTemplate.CONTENT_CREATOR.ordinal()] = 5;
            iArr[StockGuildTemplate.LOCAL_COMMUNITY.ordinal()] = 6;
            iArr[StockGuildTemplate.HUB_SCHOOL_CLUB.ordinal()] = 7;
            iArr[StockGuildTemplate.HUB_STUDY_GROUP.ordinal()] = 8;
            iArr[StockGuildTemplate.CLASS.ordinal()] = 9;
            iArr[StockGuildTemplate.SOCIAL.ordinal()] = 10;
            iArr[StockGuildTemplate.MAJOR.ordinal()] = 11;
            iArr[StockGuildTemplate.DORM.ordinal()] = 12;
            iArr[StockGuildTemplate.CREATE.ordinal()] = 13;
        }
    }

    public final List<RestAPIParams.CreateGuildChannel> getChannels(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        switch (this) {
            case FRIEND_GROUP:
                String string = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string, "resources.getString(R.st…plate_name_category_text)");
                String string2 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string2, "resources.getString(R.st…ld_template_name_general)");
                String string3 = resources.getString(R.string.guild_template_name_game);
                Intrinsics3.checkNotNullExpressionValue(string3, "resources.getString(R.st…guild_template_name_game)");
                String string4 = resources.getString(R.string.guild_template_name_music);
                Intrinsics3.checkNotNullExpressionValue(string4, "resources.getString(R.st…uild_template_name_music)");
                List listCreateCategorySection = StockGuildTemplate3.createCategorySection(string, 100L, 0, new StockGuildTemplate2.SystemChannel(string2), new StockGuildTemplate2.NormalChannel(string3), new StockGuildTemplate2.NormalChannel(string4));
                String string5 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string5, "resources.getString(R.st…late_name_category_voice)");
                String string6 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string6, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string7 = resources.getString(R.string.guild_template_name_voice_stream_room);
                Intrinsics3.checkNotNullExpressionValue(string7, "resources.getString(R.st…e_name_voice_stream_room)");
                return _Collections.plus((Collection) listCreateCategorySection, (Iterable) StockGuildTemplate3.createCategorySection(string5, 200L, 2, new StockGuildTemplate2.NormalChannel(string6), new StockGuildTemplate2.NormalChannel(string7)));
            case STUDY_GROUP:
                String string8 = resources.getString(R.string.guild_template_name_category_information);
                Intrinsics3.checkNotNullExpressionValue(string8, "resources.getString(R.st…ame_category_information)");
                String string9 = resources.getString(R.string.guild_template_name_welcome_and_rules);
                Intrinsics3.checkNotNullExpressionValue(string9, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string10 = resources.getString(R.string.guild_template_name_notes_resources);
                Intrinsics3.checkNotNullExpressionValue(string10, "resources.getString(R.st…ate_name_notes_resources)");
                List listCreateCategorySection2 = StockGuildTemplate3.createCategorySection(string8, 100L, 0, new StockGuildTemplate2.NormalChannel(string9), new StockGuildTemplate2.NormalChannel(string10));
                String string11 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string11, "resources.getString(R.st…plate_name_category_text)");
                String string12 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string12, "resources.getString(R.st…ld_template_name_general)");
                String string13 = resources.getString(R.string.guild_template_name_homework_help);
                Intrinsics3.checkNotNullExpressionValue(string13, "resources.getString(R.st…plate_name_homework_help)");
                String string14 = resources.getString(R.string.guild_template_name_session_planning);
                Intrinsics3.checkNotNullExpressionValue(string14, "resources.getString(R.st…te_name_session_planning)");
                String string15 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string15, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus = _Collections.plus((Collection) listCreateCategorySection2, (Iterable) StockGuildTemplate3.createCategorySection(string11, 200L, 0, new StockGuildTemplate2.SystemChannel(string12), new StockGuildTemplate2.NormalChannel(string13), new StockGuildTemplate2.NormalChannel(string14), new StockGuildTemplate2.NormalChannel(string15)));
                String string16 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string16, "resources.getString(R.st…late_name_category_voice)");
                String string17 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string17, "resources.getString(R.st…mplate_name_voice_lounge)");
                return _Collections.plus((Collection) listPlus, (Iterable) StockGuildTemplate3.createCategorySection(string16, 300L, 2, new StockGuildTemplate2.NormalChannel(string17), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{"1"}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString()), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{ExifInterface.GPS_MEASUREMENT_2D}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString())));
            case GAMING_GROUP:
                String string18 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string18, "resources.getString(R.st…plate_name_category_text)");
                String string19 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string19, "resources.getString(R.st…ld_template_name_general)");
                String string20 = resources.getString(R.string.guild_template_name_clips_and_highlights);
                Intrinsics3.checkNotNullExpressionValue(string20, "resources.getString(R.st…ame_clips_and_highlights)");
                List listCreateCategorySection3 = StockGuildTemplate3.createCategorySection(string18, 100L, 0, new StockGuildTemplate2.SystemChannel(string19), new StockGuildTemplate2.NormalChannel(string20));
                String string21 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string21, "resources.getString(R.st…late_name_category_voice)");
                String string22 = resources.getString(R.string.guild_template_name_voice_lobby);
                Intrinsics3.checkNotNullExpressionValue(string22, "resources.getString(R.st…emplate_name_voice_lobby)");
                String string23 = resources.getString(R.string.guild_template_name_voice_gaming);
                Intrinsics3.checkNotNullExpressionValue(string23, "resources.getString(R.st…mplate_name_voice_gaming)");
                return _Collections.plus((Collection) listCreateCategorySection3, (Iterable) StockGuildTemplate3.createCategorySection(string21, 200L, 2, new StockGuildTemplate2.NormalChannel(string22), new StockGuildTemplate2.NormalChannel(string23)));
            case CONTENT_CREATOR:
                String string24 = resources.getString(R.string.guild_template_name_category_information);
                Intrinsics3.checkNotNullExpressionValue(string24, "resources.getString(R.st…ame_category_information)");
                String string25 = resources.getString(R.string.guild_template_name_welcome_and_rules);
                Intrinsics3.checkNotNullExpressionValue(string25, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string26 = resources.getString(R.string.guild_template_name_announcements);
                Intrinsics3.checkNotNullExpressionValue(string26, "resources.getString(R.st…plate_name_announcements)");
                List listCreateCategorySection4 = StockGuildTemplate3.createCategorySection(string24, 100L, 0, new StockGuildTemplate2.NormalChannel(string25), new StockGuildTemplate2.NormalChannel(string26));
                String string27 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string27, "resources.getString(R.st…plate_name_category_text)");
                String string28 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string28, "resources.getString(R.st…ld_template_name_general)");
                String string29 = resources.getString(R.string.guild_template_name_events);
                Intrinsics3.checkNotNullExpressionValue(string29, "resources.getString(R.st…ild_template_name_events)");
                String string30 = resources.getString(R.string.guild_template_name_ideas_and_feedback);
                Intrinsics3.checkNotNullExpressionValue(string30, "resources.getString(R.st…_name_ideas_and_feedback)");
                List listPlus2 = _Collections.plus((Collection) listCreateCategorySection4, (Iterable) StockGuildTemplate3.createCategorySection(string27, 200L, 0, new StockGuildTemplate2.SystemChannel(string28), new StockGuildTemplate2.NormalChannel(string29), new StockGuildTemplate2.NormalChannel(string30)));
                String string31 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string31, "resources.getString(R.st…late_name_category_voice)");
                String string32 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string32, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string33 = resources.getString(R.string.guild_template_name_voice_community_hangout);
                Intrinsics3.checkNotNullExpressionValue(string33, "resources.getString(R.st…_voice_community_hangout)");
                String string34 = resources.getString(R.string.guild_template_name_voice_stream_room);
                Intrinsics3.checkNotNullExpressionValue(string34, "resources.getString(R.st…e_name_voice_stream_room)");
                return _Collections.plus((Collection) listPlus2, (Iterable) StockGuildTemplate3.createCategorySection(string31, 300L, 2, new StockGuildTemplate2.NormalChannel(string32), new StockGuildTemplate2.NormalChannel(string33), new StockGuildTemplate2.NormalChannel(string34)));
            case CLUB:
                String string35 = resources.getString(R.string.guild_template_name_category_information);
                Intrinsics3.checkNotNullExpressionValue(string35, "resources.getString(R.st…ame_category_information)");
                String string36 = resources.getString(R.string.guild_template_name_welcome_and_rules);
                Intrinsics3.checkNotNullExpressionValue(string36, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string37 = resources.getString(R.string.guild_template_name_announcements);
                Intrinsics3.checkNotNullExpressionValue(string37, "resources.getString(R.st…plate_name_announcements)");
                List listCreateCategorySection5 = StockGuildTemplate3.createCategorySection(string35, 100L, 0, new StockGuildTemplate2.NormalChannel(string36), new StockGuildTemplate2.NormalChannel(string37));
                String string38 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string38, "resources.getString(R.st…plate_name_category_text)");
                String string39 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string39, "resources.getString(R.st…ld_template_name_general)");
                String string40 = resources.getString(R.string.guild_template_name_meeting_plans);
                Intrinsics3.checkNotNullExpressionValue(string40, "resources.getString(R.st…plate_name_meeting_plans)");
                List listPlus3 = _Collections.plus((Collection) listCreateCategorySection5, (Iterable) StockGuildTemplate3.createCategorySection(string38, 200L, 0, new StockGuildTemplate2.SystemChannel(string39), new StockGuildTemplate2.NormalChannel(string40)));
                String string41 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string41, "resources.getString(R.st…late_name_category_voice)");
                String string42 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string42, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string43 = resources.getString(R.string.guild_template_name_voice_meeting_room);
                Intrinsics3.checkNotNullExpressionValue(string43, "resources.getString(R.st…_name_voice_meeting_room)");
                return _Collections.plus((Collection) listPlus3, (Iterable) StockGuildTemplate3.createCategorySection(string41, 300L, 2, new StockGuildTemplate2.NormalChannel(string42), new StockGuildTemplate2.NormalChannel(string43)));
            case LOCAL_COMMUNITY:
                String string44 = resources.getString(R.string.guild_template_name_category_information);
                Intrinsics3.checkNotNullExpressionValue(string44, "resources.getString(R.st…ame_category_information)");
                String string45 = resources.getString(R.string.guild_template_name_welcome_and_rules);
                Intrinsics3.checkNotNullExpressionValue(string45, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string46 = resources.getString(R.string.guild_template_name_announcements);
                Intrinsics3.checkNotNullExpressionValue(string46, "resources.getString(R.st…plate_name_announcements)");
                String string47 = resources.getString(R.string.guild_template_name_resources);
                Intrinsics3.checkNotNullExpressionValue(string47, "resources.getString(R.st…_template_name_resources)");
                List listCreateCategorySection6 = StockGuildTemplate3.createCategorySection(string44, 100L, 0, new StockGuildTemplate2.NormalChannel(string45), new StockGuildTemplate2.NormalChannel(string46), new StockGuildTemplate2.NormalChannel(string47));
                String string48 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string48, "resources.getString(R.st…plate_name_category_text)");
                String string49 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string49, "resources.getString(R.st…ld_template_name_general)");
                String string50 = resources.getString(R.string.guild_template_name_meeting_plans);
                Intrinsics3.checkNotNullExpressionValue(string50, "resources.getString(R.st…plate_name_meeting_plans)");
                String string51 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string51, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus4 = _Collections.plus((Collection) listCreateCategorySection6, (Iterable) StockGuildTemplate3.createCategorySection(string48, 200L, 0, new StockGuildTemplate2.SystemChannel(string49), new StockGuildTemplate2.NormalChannel(string50), new StockGuildTemplate2.NormalChannel(string51)));
                String string52 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string52, "resources.getString(R.st…late_name_category_voice)");
                String string53 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string53, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string54 = resources.getString(R.string.guild_template_name_voice_meeting_room);
                Intrinsics3.checkNotNullExpressionValue(string54, "resources.getString(R.st…_name_voice_meeting_room)");
                return _Collections.plus((Collection) listPlus4, (Iterable) StockGuildTemplate3.createCategorySection(string52, 300L, 2, new StockGuildTemplate2.NormalChannel(string53), new StockGuildTemplate2.NormalChannel(string54)));
            case HUB_SCHOOL_CLUB:
                String string55 = resources.getString(R.string.guild_template_name_category_information);
                Intrinsics3.checkNotNullExpressionValue(string55, "resources.getString(R.st…ame_category_information)");
                String string56 = resources.getString(R.string.guild_template_name_welcome_and_rules);
                Intrinsics3.checkNotNullExpressionValue(string56, "resources.getString(R.st…e_name_welcome_and_rules)");
                String string57 = resources.getString(R.string.guild_template_name_announcements);
                Intrinsics3.checkNotNullExpressionValue(string57, "resources.getString(R.st…plate_name_announcements)");
                String string58 = resources.getString(R.string.guild_template_name_resources);
                Intrinsics3.checkNotNullExpressionValue(string58, "resources.getString(R.st…_template_name_resources)");
                List listCreateCategorySection7 = StockGuildTemplate3.createCategorySection(string55, 100L, 0, new StockGuildTemplate2.NormalChannel(string56), new StockGuildTemplate2.NormalChannel(string57), new StockGuildTemplate2.NormalChannel(string58));
                String string59 = resources.getString(R.string.guild_template_name_category_text);
                Intrinsics3.checkNotNullExpressionValue(string59, "resources.getString(R.st…plate_name_category_text)");
                String string60 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string60, "resources.getString(R.st…ld_template_name_general)");
                String string61 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string61, "resources.getString(R.st…plate_name_introductions)");
                String string62 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string62, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus5 = _Collections.plus((Collection) listCreateCategorySection7, (Iterable) StockGuildTemplate3.createCategorySection(string59, 200L, 0, new StockGuildTemplate2.SystemChannel(string60), new StockGuildTemplate2.NormalChannel(string61), new StockGuildTemplate2.NormalChannel(string62)));
                String string63 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string63, "resources.getString(R.st…late_name_category_voice)");
                String string64 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string64, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string65 = resources.getString(R.string.guild_template_name_voice_meeting_room_1);
                Intrinsics3.checkNotNullExpressionValue(string65, "resources.getString(R.st…ame_voice_meeting_room_1)");
                String string66 = resources.getString(R.string.guild_template_name_voice_meeting_room_2);
                Intrinsics3.checkNotNullExpressionValue(string66, "resources.getString(R.st…ame_voice_meeting_room_2)");
                return _Collections.plus((Collection) listPlus5, (Iterable) StockGuildTemplate3.createCategorySection(string63, 300L, 2, new StockGuildTemplate2.NormalChannel(string64), new StockGuildTemplate2.NormalChannel(string65), new StockGuildTemplate2.NormalChannel(string66)));
            case HUB_STUDY_GROUP:
                String string67 = resources.getString(R.string.guild_template_name_category_info);
                Intrinsics3.checkNotNullExpressionValue(string67, "resources.getString(R.st…plate_name_category_info)");
                String string68 = resources.getString(R.string.guild_template_name_notes_resources);
                Intrinsics3.checkNotNullExpressionValue(string68, "resources.getString(R.st…ate_name_notes_resources)");
                String string69 = resources.getString(R.string.guild_template_name_help_questions);
                Intrinsics3.checkNotNullExpressionValue(string69, "resources.getString(R.st…late_name_help_questions)");
                List listCreateCategorySection8 = StockGuildTemplate3.createCategorySection(string67, 100L, 0, new StockGuildTemplate2.NormalChannel(string68), new StockGuildTemplate2.NormalChannel(string69));
                String string70 = resources.getString(R.string.guild_template_name_category_chat);
                Intrinsics3.checkNotNullExpressionValue(string70, "resources.getString(R.st…plate_name_category_chat)");
                String string71 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string71, "resources.getString(R.st…plate_name_introductions)");
                String string72 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string72, "resources.getString(R.st…ld_template_name_general)");
                String string73 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string73, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus6 = _Collections.plus((Collection) listCreateCategorySection8, (Iterable) StockGuildTemplate3.createCategorySection(string70, 200L, 0, new StockGuildTemplate2.NormalChannel(string71), new StockGuildTemplate2.SystemChannel(string72), new StockGuildTemplate2.NormalChannel(string73)));
                String string74 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string74, "resources.getString(R.st…late_name_category_voice)");
                String string75 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string75, "resources.getString(R.st…mplate_name_voice_lounge)");
                return _Collections.plus((Collection) listPlus6, (Iterable) StockGuildTemplate3.createCategorySection(string74, 300L, 2, new StockGuildTemplate2.NormalChannel(string75), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{1}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString()), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{2}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString())));
            case CLASS:
                String string76 = resources.getString(R.string.guild_template_name_category_info);
                Intrinsics3.checkNotNullExpressionValue(string76, "resources.getString(R.st…plate_name_category_info)");
                String string77 = resources.getString(R.string.guild_template_name_assignments);
                Intrinsics3.checkNotNullExpressionValue(string77, "resources.getString(R.st…emplate_name_assignments)");
                String string78 = resources.getString(R.string.guild_template_name_help_questions);
                Intrinsics3.checkNotNullExpressionValue(string78, "resources.getString(R.st…late_name_help_questions)");
                String string79 = resources.getString(R.string.guild_template_name_resources);
                Intrinsics3.checkNotNullExpressionValue(string79, "resources.getString(R.st…_template_name_resources)");
                List listCreateCategorySection9 = StockGuildTemplate3.createCategorySection(string76, 100L, 0, new StockGuildTemplate2.NormalChannel(string77), new StockGuildTemplate2.NormalChannel(string78), new StockGuildTemplate2.NormalChannel(string79));
                String string80 = resources.getString(R.string.guild_template_name_category_chat);
                Intrinsics3.checkNotNullExpressionValue(string80, "resources.getString(R.st…plate_name_category_chat)");
                String string81 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string81, "resources.getString(R.st…plate_name_introductions)");
                String string82 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string82, "resources.getString(R.st…ld_template_name_general)");
                String string83 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string83, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus7 = _Collections.plus((Collection) listCreateCategorySection9, (Iterable) StockGuildTemplate3.createCategorySection(string80, 200L, 0, new StockGuildTemplate2.NormalChannel(string81), new StockGuildTemplate2.SystemChannel(string82), new StockGuildTemplate2.NormalChannel(string83)));
                String string84 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string84, "resources.getString(R.st…late_name_category_voice)");
                String string85 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string85, "resources.getString(R.st…mplate_name_voice_lounge)");
                return _Collections.plus((Collection) listPlus7, (Iterable) StockGuildTemplate3.createCategorySection(string84, 300L, 2, new StockGuildTemplate2.NormalChannel(string85), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{1}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString()), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{2}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString())));
            case SOCIAL:
                String string86 = resources.getString(R.string.guild_template_name_category_chat);
                Intrinsics3.checkNotNullExpressionValue(string86, "resources.getString(R.st…plate_name_category_chat)");
                String string87 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string87, "resources.getString(R.st…plate_name_introductions)");
                String string88 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string88, "resources.getString(R.st…ld_template_name_general)");
                String string89 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string89, "resources.getString(R.st…_template_name_off_topic)");
                String string90 = resources.getString(R.string.guild_template_name_meetups);
                Intrinsics3.checkNotNullExpressionValue(string90, "resources.getString(R.st…ld_template_name_meetups)");
                List listCreateCategorySection10 = StockGuildTemplate3.createCategorySection(string86, 200L, 0, new StockGuildTemplate2.NormalChannel(string87), new StockGuildTemplate2.SystemChannel(string88), new StockGuildTemplate2.NormalChannel(string89), new StockGuildTemplate2.NormalChannel(string90));
                String string91 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string91, "resources.getString(R.st…late_name_category_voice)");
                String string92 = resources.getString(R.string.guild_template_name_voice_couches);
                Intrinsics3.checkNotNullExpressionValue(string92, "resources.getString(R.st…plate_name_voice_couches)");
                String string93 = resources.getString(R.string.guild_template_name_voice_movie_room);
                Intrinsics3.checkNotNullExpressionValue(string93, "resources.getString(R.st…te_name_voice_movie_room)");
                String string94 = resources.getString(R.string.guild_template_name_voice_unnumbered_study_room);
                Intrinsics3.checkNotNullExpressionValue(string94, "resources.getString(R.st…ce_unnumbered_study_room)");
                return _Collections.plus((Collection) listCreateCategorySection10, (Iterable) StockGuildTemplate3.createCategorySection(string91, 300L, 2, new StockGuildTemplate2.NormalChannel(string92), new StockGuildTemplate2.NormalChannel(string93), new StockGuildTemplate2.NormalChannel(string94)));
            case MAJOR:
                String string95 = resources.getString(R.string.guild_template_name_category_info);
                Intrinsics3.checkNotNullExpressionValue(string95, "resources.getString(R.st…plate_name_category_info)");
                String string96 = resources.getString(R.string.guild_template_name_resources);
                Intrinsics3.checkNotNullExpressionValue(string96, "resources.getString(R.st…_template_name_resources)");
                String string97 = resources.getString(R.string.guild_template_name_help_questions);
                Intrinsics3.checkNotNullExpressionValue(string97, "resources.getString(R.st…late_name_help_questions)");
                List listCreateCategorySection11 = StockGuildTemplate3.createCategorySection(string95, 100L, 0, new StockGuildTemplate2.NormalChannel(string96), new StockGuildTemplate2.NormalChannel(string97));
                String string98 = resources.getString(R.string.guild_template_name_category_chat);
                Intrinsics3.checkNotNullExpressionValue(string98, "resources.getString(R.st…plate_name_category_chat)");
                String string99 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string99, "resources.getString(R.st…plate_name_introductions)");
                String string100 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string100, "resources.getString(R.st…ld_template_name_general)");
                String string101 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string101, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus8 = _Collections.plus((Collection) listCreateCategorySection11, (Iterable) StockGuildTemplate3.createCategorySection(string98, 200L, 0, new StockGuildTemplate2.NormalChannel(string99), new StockGuildTemplate2.SystemChannel(string100), new StockGuildTemplate2.NormalChannel(string101)));
                String string102 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string102, "resources.getString(R.st…late_name_category_voice)");
                String string103 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string103, "resources.getString(R.st…mplate_name_voice_lounge)");
                return _Collections.plus((Collection) listPlus8, (Iterable) StockGuildTemplate3.createCategorySection(string102, 300L, 2, new StockGuildTemplate2.NormalChannel(string103), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{1}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString()), new StockGuildTemplate2.NormalChannel(FormatUtils.c(resources, R.string.guild_template_name_voice_study_room, new Object[]{2}, (4 & 4) != 0 ? FormatUtils.d.j : null).toString())));
            case DORM:
                String string104 = resources.getString(R.string.guild_template_name_category_info);
                Intrinsics3.checkNotNullExpressionValue(string104, "resources.getString(R.st…plate_name_category_info)");
                String string105 = resources.getString(R.string.guild_template_name_dorm_news);
                Intrinsics3.checkNotNullExpressionValue(string105, "resources.getString(R.st…_template_name_dorm_news)");
                List listCreateCategorySection12 = StockGuildTemplate3.createCategorySection(string104, 100L, 0, new StockGuildTemplate2.NormalChannel(string105));
                String string106 = resources.getString(R.string.guild_template_name_category_chat);
                Intrinsics3.checkNotNullExpressionValue(string106, "resources.getString(R.st…plate_name_category_chat)");
                String string107 = resources.getString(R.string.guild_template_name_introductions);
                Intrinsics3.checkNotNullExpressionValue(string107, "resources.getString(R.st…plate_name_introductions)");
                String string108 = resources.getString(R.string.guild_template_name_general);
                Intrinsics3.checkNotNullExpressionValue(string108, "resources.getString(R.st…ld_template_name_general)");
                String string109 = resources.getString(R.string.guild_template_name_off_topic);
                Intrinsics3.checkNotNullExpressionValue(string109, "resources.getString(R.st…_template_name_off_topic)");
                List listPlus9 = _Collections.plus((Collection) listCreateCategorySection12, (Iterable) StockGuildTemplate3.createCategorySection(string106, 200L, 0, new StockGuildTemplate2.NormalChannel(string107), new StockGuildTemplate2.SystemChannel(string108), new StockGuildTemplate2.NormalChannel(string109)));
                String string110 = resources.getString(R.string.guild_template_name_category_voice);
                Intrinsics3.checkNotNullExpressionValue(string110, "resources.getString(R.st…late_name_category_voice)");
                String string111 = resources.getString(R.string.guild_template_name_voice_lounge);
                Intrinsics3.checkNotNullExpressionValue(string111, "resources.getString(R.st…mplate_name_voice_lounge)");
                String string112 = resources.getString(R.string.guild_template_name_voice_movie_room);
                Intrinsics3.checkNotNullExpressionValue(string112, "resources.getString(R.st…te_name_voice_movie_room)");
                String string113 = resources.getString(R.string.guild_template_name_voice_couches);
                Intrinsics3.checkNotNullExpressionValue(string113, "resources.getString(R.st…plate_name_voice_couches)");
                return _Collections.plus((Collection) listPlus9, (Iterable) StockGuildTemplate3.createCategorySection(string110, 300L, 2, new StockGuildTemplate2.NormalChannel(string111), new StockGuildTemplate2.NormalChannel(string112), new StockGuildTemplate2.NormalChannel(string113)));
            case CREATE:
                return Collections2.emptyList();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final long getSystemChannelId() {
        return 11L;
    }
}
