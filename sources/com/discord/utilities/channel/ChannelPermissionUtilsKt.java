package com.discord.utilities.channel;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import java.util.Map;
import kotlin.Pair;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p027k.C1107b;
import p507d0.C12116o;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelPermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionUtilsKt {
    public static final Map<Integer, PermissionLabelOverrides> getCategoryLabels(boolean z2, Context context) {
        String str;
        CharSequence charSequenceM210b;
        CharSequence charSequenceM210b2;
        String str2;
        CharSequence charSequenceM210b3;
        CharSequence charSequenceM210b4;
        String str3;
        CharSequence charSequenceM210b5;
        CharSequence charSequenceM210b6;
        C12238m.checkNotNullParameter(context, "context");
        Pair[] pairArr = new Pair[29];
        Integer numValueOf = Integer.valueOf(C5419R.id.channel_permission_text_read_messages);
        String string = context.getString(C5419R.string.role_permissions_view_channel);
        String string2 = context.getString(C5419R.string.role_permissions_view_channel_description_category);
        C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…nel_description_category)");
        pairArr[0] = C12116o.m10073to(numValueOf, new PermissionLabelOverrides(string2, string, null, null, context.getString(C5419R.string.role_permissions_view_channel_description_text_everyone), context.getString(C5419R.string.role_permissions_view_channel_description_voice_everyone), null, context.getString(C5419R.string.role_permissions_view_channel_description_category_everyone), null, 332, null));
        Integer numValueOf2 = Integer.valueOf(C5419R.id.channel_permission_general_manage_channel);
        String string3 = context.getString(C5419R.string.manage_channels);
        String string4 = context.getString(C5419R.string.role_permissions_manage_channel_description_category);
        C12238m.checkNotNullExpressionValue(string4, "context.getString(R.stri…nel_description_category)");
        pairArr[1] = C12116o.m10073to(numValueOf2, new PermissionLabelOverrides(string4, string3, context.getString(C5419R.string.role_permissions_manage_channel_description_voice), context.getString(C5419R.string.role_permissions_manage_channel_description_stage), null, null, null, null, null, 496, null));
        Integer numValueOf3 = Integer.valueOf(C5419R.id.channel_permission_general_manage_threads);
        String string5 = context.getString(C5419R.string.role_permissions_manage_threads_description_category);
        C12238m.checkNotNullExpressionValue(string5, "context.getString(R.stri…ads_description_category)");
        pairArr[2] = C12116o.m10073to(numValueOf3, new PermissionLabelOverrides(string5, null, null, null, null, null, null, context.getString(C5419R.string.role_permissions_manage_threads_description_category), null, 382, null));
        Integer numValueOf4 = Integer.valueOf(C5419R.id.channel_permission_general_manage_permissions);
        String string6 = context.getString(C5419R.string.role_permissions_manage_roles_description_category);
        C12238m.checkNotNullExpressionValue(string6, "context.getString(R.stri…les_description_category)");
        pairArr[3] = C12116o.m10073to(numValueOf4, new PermissionLabelOverrides(string6, null, null, context.getString(C5419R.string.role_permissions_manage_roles_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf5 = Integer.valueOf(C5419R.id.channel_permission_general_manage_webhooks);
        String string7 = context.getString(C5419R.string.role_permissions_manage_webhooks_description_category);
        C12238m.checkNotNullExpressionValue(string7, "context.getString(R.stri…oks_description_category)");
        pairArr[4] = C12116o.m10073to(numValueOf5, new PermissionLabelOverrides(string7, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf6 = Integer.valueOf(C5419R.id.channel_permission_text_send_messages);
        String string8 = context.getString(C5419R.string.role_permissions_send_messages_description_category);
        C12238m.checkNotNullExpressionValue(string8, "context.getString(R.stri…ges_description_category)");
        C0862f c0862f = C0862f.f507a;
        pairArr[5] = C12116o.m10073to(numValueOf6, new PermissionLabelOverrides(string8, null, null, null, null, null, null, null, C1107b.m210b(context, C5419R.string.role_permissions_send_messages_description_announcement, new Object[]{c0862f.m149a(360032008192L, null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 254, null));
        Integer numValueOf7 = Integer.valueOf(C5419R.id.channel_permission_text_send_messages_in_threads);
        if (z2) {
            charSequenceM210b = context.getString(C5419R.string.role_permissions_send_messages_in_threads_description_category);
            str = "context.getString(R.stri…ads_description_category)";
            C12238m.checkNotNullExpressionValue(charSequenceM210b, str);
        } else {
            str = "context.getString(R.stri…ads_description_category)";
            charSequenceM210b = C1107b.m210b(context, C5419R.string.f14771x98d4cb90, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        if (z2) {
            String string9 = context.getString(C5419R.string.role_permissions_send_messages_in_threads_description_category);
            C12238m.checkNotNullExpressionValue(string9, str);
            charSequenceM210b2 = string9;
        } else {
            charSequenceM210b2 = C1107b.m210b(context, C5419R.string.f14771x98d4cb90, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        String str4 = str;
        pairArr[6] = C12116o.m10073to(numValueOf7, new PermissionLabelOverrides(charSequenceM210b, null, null, null, null, null, null, charSequenceM210b2, null, 382, null));
        Integer numValueOf8 = Integer.valueOf(C5419R.id.channel_permission_text_create_public_threads);
        if (z2) {
            charSequenceM210b3 = context.getString(C5419R.string.role_permissions_create_public_threads_description_category);
            str2 = str4;
            C12238m.checkNotNullExpressionValue(charSequenceM210b3, str2);
        } else {
            str2 = str4;
            charSequenceM210b3 = C1107b.m210b(context, C5419R.string.f14770x8ac810cf, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        if (z2) {
            String string10 = context.getString(C5419R.string.role_permissions_create_public_threads_description_category);
            C12238m.checkNotNullExpressionValue(string10, str2);
            charSequenceM210b4 = string10;
        } else {
            charSequenceM210b4 = C1107b.m210b(context, C5419R.string.f14770x8ac810cf, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        CharSequence charSequence = charSequenceM210b4;
        String str5 = str2;
        pairArr[7] = C12116o.m10073to(numValueOf8, new PermissionLabelOverrides(charSequenceM210b3, null, null, null, null, null, null, charSequence, null, 382, null));
        Integer numValueOf9 = Integer.valueOf(C5419R.id.channel_permission_text_create_private_threads);
        if (z2) {
            charSequenceM210b5 = context.getString(C5419R.string.role_permissions_create_private_threads_description_category);
            str3 = str5;
            C12238m.checkNotNullExpressionValue(charSequenceM210b5, str3);
        } else {
            str3 = str5;
            charSequenceM210b5 = C1107b.m210b(context, C5419R.string.f14769x19ffc831, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        if (z2) {
            String string11 = context.getString(C5419R.string.role_permissions_create_private_threads_description_category);
            C12238m.checkNotNullExpressionValue(string11, str3);
            charSequenceM210b6 = string11;
        } else {
            charSequenceM210b6 = C1107b.m210b(context, C5419R.string.f14769x19ffc831, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null);
        }
        pairArr[8] = C12116o.m10073to(numValueOf9, new PermissionLabelOverrides(charSequenceM210b5, null, null, null, null, null, null, charSequenceM210b6, null, 382, null));
        Integer numValueOf10 = Integer.valueOf(C5419R.id.channel_permission_general_create_instant_invite);
        String string12 = context.getString(C5419R.string.role_permissions_create_instant_invite_description_category);
        C12238m.checkNotNullExpressionValue(string12, "context.getString(R.stri…ite_description_category)");
        pairArr[9] = C12116o.m10073to(numValueOf10, new PermissionLabelOverrides(string12, null, context.getString(C5419R.string.role_permissions_create_instant_invite_description_voice), null, null, null, null, null, null, 506, null));
        Integer numValueOf11 = Integer.valueOf(C5419R.id.channel_permission_text_embed_links);
        String string13 = context.getString(C5419R.string.role_permissions_embed_links_description_category);
        C12238m.checkNotNullExpressionValue(string13, "context.getString(R.stri…nks_description_category)");
        pairArr[10] = C12116o.m10073to(numValueOf11, new PermissionLabelOverrides(string13, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf12 = Integer.valueOf(C5419R.id.channel_permission_text_attach_files);
        String string14 = context.getString(C5419R.string.role_permissions_attach_files_description_category);
        C12238m.checkNotNullExpressionValue(string14, "context.getString(R.stri…les_description_category)");
        pairArr[11] = C12116o.m10073to(numValueOf12, new PermissionLabelOverrides(string14, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf13 = Integer.valueOf(C5419R.id.channel_permission_text_add_reactions);
        String string15 = context.getString(C5419R.string.role_permissions_add_reactions_description_category);
        C12238m.checkNotNullExpressionValue(string15, "context.getString(R.stri…ons_description_category)");
        pairArr[12] = C12116o.m10073to(numValueOf13, new PermissionLabelOverrides(string15, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf14 = Integer.valueOf(C5419R.id.channel_permission_text_use_external_emojis);
        String string16 = context.getString(C5419R.string.role_permissions_use_external_emojis_description_category);
        C12238m.checkNotNullExpressionValue(string16, "context.getString(R.stri…jis_description_category)");
        pairArr[13] = C12116o.m10073to(numValueOf14, new PermissionLabelOverrides(string16, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf15 = Integer.valueOf(C5419R.id.channel_permission_text_use_external_stickers);
        String string17 = context.getString(C5419R.string.role_permissions_use_external_stickers_description_category);
        C12238m.checkNotNullExpressionValue(string17, "context.getString(R.stri…ers_description_category)");
        pairArr[14] = C12116o.m10073to(numValueOf15, new PermissionLabelOverrides(string17, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf16 = Integer.valueOf(C5419R.id.channel_permission_text_mention_everyone);
        String string18 = context.getString(C5419R.string.role_permissions_mention_everyone_description_category);
        C12238m.checkNotNullExpressionValue(string18, "context.getString(R.stri…one_description_category)");
        pairArr[15] = C12116o.m10073to(numValueOf16, new PermissionLabelOverrides(string18, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf17 = Integer.valueOf(C5419R.id.channel_permission_text_manage_messages);
        String string19 = context.getString(C5419R.string.role_permissions_manage_messages_description_category);
        C12238m.checkNotNullExpressionValue(string19, "context.getString(R.stri…ges_description_category)");
        pairArr[16] = C12116o.m10073to(numValueOf17, new PermissionLabelOverrides(string19, null, null, null, null, null, null, null, C1107b.m210b(context, C5419R.string.role_permissions_manage_messages_description_announcement, new Object[]{c0862f.m149a(360032008192L, null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null), 254, null));
        Integer numValueOf18 = Integer.valueOf(C5419R.id.channel_permission_text_read_message_history);
        String string20 = context.getString(C5419R.string.role_permissions_read_message_history_description_category);
        C12238m.checkNotNullExpressionValue(string20, "context.getString(R.stri…ory_description_category)");
        pairArr[17] = C12116o.m10073to(numValueOf18, new PermissionLabelOverrides(string20, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf19 = Integer.valueOf(C5419R.id.channel_permission_text_send_tts_messages);
        String string21 = context.getString(C5419R.string.role_permissions_send_tts_messages_description_category);
        C12238m.checkNotNullExpressionValue(string21, "context.getString(R.stri…ges_description_category)");
        pairArr[18] = C12116o.m10073to(numValueOf19, new PermissionLabelOverrides(string21, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf20 = Integer.valueOf(C5419R.id.channel_permission_voice_connect);
        String string22 = context.getString(C5419R.string.role_permissions_connect_description_category);
        C12238m.checkNotNullExpressionValue(string22, "context.getString(R.stri…ect_description_category)");
        pairArr[19] = C12116o.m10073to(numValueOf20, new PermissionLabelOverrides(string22, null, null, context.getString(C5419R.string.role_permissions_connect_description_stage), null, context.getString(C5419R.string.role_permissions_connect_description_voice_everyone), context.getString(C5419R.string.role_permissions_connect_description_stage_everyone), context.getString(C5419R.string.role_permissions_connect_description_category_everyone), null, 278, null));
        Integer numValueOf21 = Integer.valueOf(C5419R.id.channel_permission_voice_speak);
        String string23 = context.getString(C5419R.string.role_permissions_speak_description_category);
        C12238m.checkNotNullExpressionValue(string23, "context.getString(R.stri…eak_description_category)");
        pairArr[20] = C12116o.m10073to(numValueOf21, new PermissionLabelOverrides(string23, null, null, context.getString(C5419R.string.role_permissions_speak_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf22 = Integer.valueOf(C5419R.id.channel_permission_voice_video);
        String string24 = context.getString(C5419R.string.role_permissions_stream_description_category);
        C12238m.checkNotNullExpressionValue(string24, "context.getString(R.stri…eam_description_category)");
        pairArr[21] = C12116o.m10073to(numValueOf22, new PermissionLabelOverrides(string24, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf23 = Integer.valueOf(C5419R.id.channel_permission_voice_use_vad);
        String string25 = context.getString(C5419R.string.role_permissions_use_vad_description_category);
        C12238m.checkNotNullExpressionValue(string25, "context.getString(R.stri…vad_description_category)");
        pairArr[22] = C12116o.m10073to(numValueOf23, new PermissionLabelOverrides(string25, null, null, context.getString(C5419R.string.role_permissions_use_vad_description_stage), null, null, null, null, null, 502, null));
        pairArr[23] = C12116o.m10073to(Integer.valueOf(C5419R.id.channel_permission_voice_priority_speaker), new PermissionLabelOverrides(C1107b.m210b(context, C5419R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{C1107b.m210b(context, C5419R.string.keybind_push_to_talk_priority, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null), null, null, null, null, null, null, C1107b.m210b(context, C5419R.string.role_permissions_priority_speaker_description_category_mobile, new Object[]{C1107b.m210b(context, C5419R.string.keybind_push_to_talk_priority, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null)}, (4 & 4) != 0 ? C1107b.b.f1491j : null), null, 382, null));
        pairArr[24] = C12116o.m10073to(Integer.valueOf(C5419R.id.channel_permission_voice_mute_members), new PermissionLabelOverrides(C1107b.m210b(context, C5419R.string.role_permissions_mute_members_description_category, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), null, null, C1107b.m210b(context, C5419R.string.role_permissions_mute_members_description_stage, new Object[0], (4 & 4) != 0 ? C1107b.b.f1491j : null), null, null, null, null, null, 502, null));
        Integer numValueOf24 = Integer.valueOf(C5419R.id.channel_permission_voice_deafen_members);
        String string26 = context.getString(C5419R.string.role_permissions_deafen_members_description_category);
        C12238m.checkNotNullExpressionValue(string26, "context.getString(R.stri…ers_description_category)");
        pairArr[25] = C12116o.m10073to(numValueOf24, new PermissionLabelOverrides(string26, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf25 = Integer.valueOf(C5419R.id.channel_permission_voice_move_members);
        String string27 = context.getString(C5419R.string.role_permissions_move_members_description_category);
        C12238m.checkNotNullExpressionValue(string27, "context.getString(R.stri…ers_description_category)");
        pairArr[26] = C12116o.m10073to(numValueOf25, new PermissionLabelOverrides(string27, null, null, context.getString(C5419R.string.role_permissions_move_members_description_stage), null, null, null, null, null, 502, null));
        Integer numValueOf26 = Integer.valueOf(C5419R.id.channel_permission_stage_request_to_speak);
        String string28 = context.getString(C5419R.string.role_permissions_request_to_speak_description_category);
        C12238m.checkNotNullExpressionValue(string28, "context.getString(R.stri…eak_description_category)");
        pairArr[27] = C12116o.m10073to(numValueOf26, new PermissionLabelOverrides(string28, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf27 = Integer.valueOf(C5419R.id.channel_permission_events_manage_events);
        String string29 = context.getString(C5419R.string.role_permissions_manage_events_description_category);
        C12238m.checkNotNullExpressionValue(string29, "context.getString(R.stri…nts_description_category)");
        pairArr[28] = C12116o.m10073to(numValueOf27, new PermissionLabelOverrides(string29, null, null, null, null, null, null, null, null, 510, null));
        return C12136h0.hashMapOf(pairArr);
    }

    @StringRes
    public static final int getChannelPermissionOwnerRoleLabel(GuildRole guildRole) {
        C12238m.checkNotNullParameter(guildRole, "role");
        return (guildRole.getPermissions() & 8) == 8 ? C5419R.string.private_channel_add_members_modal_row_administrator : C5419R.string.private_channel_add_members_modal_row_role;
    }
}
