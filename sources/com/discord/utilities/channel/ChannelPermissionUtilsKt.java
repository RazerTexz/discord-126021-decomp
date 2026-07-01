package com.discord.utilities.channel;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.d.f;
import b.a.k.b;
import com.discord.R$id;
import com.discord.api.role.GuildRole;
import d0.o;
import d0.t.h0;
import d0.z.d.m;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: ChannelPermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionUtilsKt {
    public static final Map<Integer, PermissionLabelOverrides> getCategoryLabels(boolean z2, Context context) {
        String str;
        CharSequence charSequenceH;
        CharSequence charSequenceH2;
        String str2;
        CharSequence charSequenceH3;
        CharSequence charSequenceH4;
        String str3;
        CharSequence charSequenceH5;
        CharSequence charSequenceH6;
        m.checkNotNullParameter(context, "context");
        Pair[] pairArr = new Pair[29];
        Integer numValueOf = Integer.valueOf(R$id.channel_permission_text_read_messages);
        String string = context.getString(2131895131);
        String string2 = context.getString(2131895133);
        m.checkNotNullExpressionValue(string2, "context.getString(R.stri…nel_description_category)");
        pairArr[0] = o.to(numValueOf, new PermissionLabelOverrides(string2, string, null, null, context.getString(2131895136), context.getString(2131895137), null, context.getString(2131895134), null, 332, null));
        Integer numValueOf2 = Integer.valueOf(R$id.channel_permission_general_manage_channel);
        String string3 = context.getString(2131892678);
        String string4 = context.getString(2131895016);
        m.checkNotNullExpressionValue(string4, "context.getString(R.stri…nel_description_category)");
        pairArr[1] = o.to(numValueOf2, new PermissionLabelOverrides(string4, string3, context.getString(2131895019), context.getString(2131895017), null, null, null, null, null, 496, null));
        Integer numValueOf3 = Integer.valueOf(R$id.channel_permission_general_manage_threads);
        String string5 = context.getString(2131895039);
        m.checkNotNullExpressionValue(string5, "context.getString(R.stri…ads_description_category)");
        pairArr[2] = o.to(numValueOf3, new PermissionLabelOverrides(string5, null, null, null, null, null, null, context.getString(2131895039), null, 382, null));
        Integer numValueOf4 = Integer.valueOf(R$id.channel_permission_general_manage_permissions);
        String string6 = context.getString(2131895031);
        m.checkNotNullExpressionValue(string6, "context.getString(R.stri…les_description_category)");
        pairArr[3] = o.to(numValueOf4, new PermissionLabelOverrides(string6, null, null, context.getString(2131895033), null, null, null, null, null, 502, null));
        Integer numValueOf5 = Integer.valueOf(R$id.channel_permission_general_manage_webhooks);
        String string7 = context.getString(2131895042);
        m.checkNotNullExpressionValue(string7, "context.getString(R.stri…oks_description_category)");
        pairArr[4] = o.to(numValueOf5, new PermissionLabelOverrides(string7, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf6 = Integer.valueOf(R$id.channel_permission_text_send_messages);
        String string8 = context.getString(2131895087);
        m.checkNotNullExpressionValue(string8, "context.getString(R.stri…ges_description_category)");
        f fVar = f.a;
        pairArr[5] = o.to(numValueOf6, new PermissionLabelOverrides(string8, null, null, null, null, null, null, null, b.h(context, 2131895086, new Object[]{fVar.a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf7 = Integer.valueOf(R$id.channel_permission_text_send_messages_in_threads);
        if (z2) {
            charSequenceH = context.getString(2131895093);
            str = "context.getString(R.stri…ads_description_category)";
            m.checkNotNullExpressionValue(charSequenceH, str);
        } else {
            str = "context.getString(R.stri…ads_description_category)";
            charSequenceH = b.h(context, 2131892200, new Object[0], null, 4);
        }
        if (z2) {
            String string9 = context.getString(2131895093);
            m.checkNotNullExpressionValue(string9, str);
            charSequenceH2 = string9;
        } else {
            charSequenceH2 = b.h(context, 2131892200, new Object[0], null, 4);
        }
        String str4 = str;
        pairArr[6] = o.to(numValueOf7, new PermissionLabelOverrides(charSequenceH, null, null, null, null, null, null, charSequenceH2, null, 382, null));
        Integer numValueOf8 = Integer.valueOf(R$id.channel_permission_text_create_public_threads);
        if (z2) {
            charSequenceH3 = context.getString(2131895005);
            str2 = str4;
            m.checkNotNullExpressionValue(charSequenceH3, str2);
        } else {
            str2 = str4;
            charSequenceH3 = b.h(context, 2131892197, new Object[0], null, 4);
        }
        if (z2) {
            String string10 = context.getString(2131895005);
            m.checkNotNullExpressionValue(string10, str2);
            charSequenceH4 = string10;
        } else {
            charSequenceH4 = b.h(context, 2131892197, new Object[0], null, 4);
        }
        CharSequence charSequence = charSequenceH4;
        String str5 = str2;
        pairArr[7] = o.to(numValueOf8, new PermissionLabelOverrides(charSequenceH3, null, null, null, null, null, null, charSequence, null, 382, null));
        Integer numValueOf9 = Integer.valueOf(R$id.channel_permission_text_create_private_threads);
        if (z2) {
            charSequenceH5 = context.getString(2131895002);
            str3 = str5;
            m.checkNotNullExpressionValue(charSequenceH5, str3);
        } else {
            str3 = str5;
            charSequenceH5 = b.h(context, 2131892194, new Object[0], null, 4);
        }
        if (z2) {
            String string11 = context.getString(2131895002);
            m.checkNotNullExpressionValue(string11, str3);
            charSequenceH6 = string11;
        } else {
            charSequenceH6 = b.h(context, 2131892194, new Object[0], null, 4);
        }
        pairArr[8] = o.to(numValueOf9, new PermissionLabelOverrides(charSequenceH5, null, null, null, null, null, null, charSequenceH6, null, 382, null));
        Integer numValueOf10 = Integer.valueOf(R$id.channel_permission_general_create_instant_invite);
        String string12 = context.getString(2131894998);
        m.checkNotNullExpressionValue(string12, "context.getString(R.stri…ite_description_category)");
        pairArr[9] = o.to(numValueOf10, new PermissionLabelOverrides(string12, null, context.getString(2131895000), null, null, null, null, null, null, 506, null));
        Integer numValueOf11 = Integer.valueOf(R$id.channel_permission_text_embed_links);
        String string13 = context.getString(2131895011);
        m.checkNotNullExpressionValue(string13, "context.getString(R.stri…nks_description_category)");
        pairArr[10] = o.to(numValueOf11, new PermissionLabelOverrides(string13, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf12 = Integer.valueOf(R$id.channel_permission_text_attach_files);
        String string14 = context.getString(2131894985);
        m.checkNotNullExpressionValue(string14, "context.getString(R.stri…les_description_category)");
        pairArr[11] = o.to(numValueOf12, new PermissionLabelOverrides(string14, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf13 = Integer.valueOf(R$id.channel_permission_text_add_reactions);
        String string15 = context.getString(2131894981);
        m.checkNotNullExpressionValue(string15, "context.getString(R.stri…ons_description_category)");
        pairArr[12] = o.to(numValueOf13, new PermissionLabelOverrides(string15, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf14 = Integer.valueOf(R$id.channel_permission_text_use_external_emojis);
        String string16 = context.getString(2131895120);
        m.checkNotNullExpressionValue(string16, "context.getString(R.stri…jis_description_category)");
        pairArr[13] = o.to(numValueOf14, new PermissionLabelOverrides(string16, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf15 = Integer.valueOf(R$id.channel_permission_text_use_external_stickers);
        String string17 = context.getString(2131895124);
        m.checkNotNullExpressionValue(string17, "context.getString(R.stri…ers_description_category)");
        pairArr[14] = o.to(numValueOf15, new PermissionLabelOverrides(string17, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf16 = Integer.valueOf(R$id.channel_permission_text_mention_everyone);
        String string18 = context.getString(2131895045);
        m.checkNotNullExpressionValue(string18, "context.getString(R.stri…one_description_category)");
        pairArr[15] = o.to(numValueOf16, new PermissionLabelOverrides(string18, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf17 = Integer.valueOf(R$id.channel_permission_text_manage_messages);
        String string19 = context.getString(2131895027);
        m.checkNotNullExpressionValue(string19, "context.getString(R.stri…ges_description_category)");
        pairArr[16] = o.to(numValueOf17, new PermissionLabelOverrides(string19, null, null, null, null, null, null, null, b.h(context, 2131895026, new Object[]{fVar.a(360032008192L, null)}, null, 4), 254, null));
        Integer numValueOf18 = Integer.valueOf(R$id.channel_permission_text_read_message_history);
        String string20 = context.getString(2131895065);
        m.checkNotNullExpressionValue(string20, "context.getString(R.stri…ory_description_category)");
        pairArr[17] = o.to(numValueOf18, new PermissionLabelOverrides(string20, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf19 = Integer.valueOf(R$id.channel_permission_text_send_tts_messages);
        String string21 = context.getString(2131895102);
        m.checkNotNullExpressionValue(string21, "context.getString(R.stri…ges_description_category)");
        pairArr[18] = o.to(numValueOf19, new PermissionLabelOverrides(string21, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf20 = Integer.valueOf(R$id.channel_permission_voice_connect);
        String string22 = context.getString(2131894991);
        m.checkNotNullExpressionValue(string22, "context.getString(R.stri…ect_description_category)");
        pairArr[19] = o.to(numValueOf20, new PermissionLabelOverrides(string22, null, null, context.getString(2131894993), null, context.getString(2131894996), context.getString(2131894994), context.getString(2131894992), null, 278, null));
        Integer numValueOf21 = Integer.valueOf(R$id.channel_permission_voice_speak);
        String string23 = context.getString(2131895105);
        m.checkNotNullExpressionValue(string23, "context.getString(R.stri…eak_description_category)");
        pairArr[20] = o.to(numValueOf21, new PermissionLabelOverrides(string23, null, null, context.getString(2131895106), null, null, null, null, null, 502, null));
        Integer numValueOf22 = Integer.valueOf(R$id.channel_permission_voice_video);
        String string24 = context.getString(2131895109);
        m.checkNotNullExpressionValue(string24, "context.getString(R.stri…eam_description_category)");
        pairArr[21] = o.to(numValueOf22, new PermissionLabelOverrides(string24, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf23 = Integer.valueOf(R$id.channel_permission_voice_use_vad);
        String string25 = context.getString(2131895127);
        m.checkNotNullExpressionValue(string25, "context.getString(R.stri…vad_description_category)");
        pairArr[22] = o.to(numValueOf23, new PermissionLabelOverrides(string25, null, null, context.getString(2131895128), null, null, null, null, null, 502, null));
        pairArr[23] = o.to(Integer.valueOf(R$id.channel_permission_voice_priority_speaker), new PermissionLabelOverrides(b.h(context, 2131895060, new Object[]{b.h(context, 2131892475, new Object[0], null, 4)}, null, 4), null, null, null, null, null, null, b.h(context, 2131895060, new Object[]{b.h(context, 2131892475, new Object[0], null, 4)}, null, 4), null, 382, null));
        pairArr[24] = o.to(Integer.valueOf(R$id.channel_permission_voice_mute_members), new PermissionLabelOverrides(b.h(context, 2131895054, new Object[0], null, 4), null, null, b.h(context, 2131895055, new Object[0], null, 4), null, null, null, null, null, 502, null));
        Integer numValueOf24 = Integer.valueOf(R$id.channel_permission_voice_deafen_members);
        String string26 = context.getString(2131895008);
        m.checkNotNullExpressionValue(string26, "context.getString(R.stri…ers_description_category)");
        pairArr[25] = o.to(numValueOf24, new PermissionLabelOverrides(string26, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf25 = Integer.valueOf(R$id.channel_permission_voice_move_members);
        String string27 = context.getString(2131895050);
        m.checkNotNullExpressionValue(string27, "context.getString(R.stri…ers_description_category)");
        pairArr[26] = o.to(numValueOf25, new PermissionLabelOverrides(string27, null, null, context.getString(2131895051), null, null, null, null, null, 502, null));
        Integer numValueOf26 = Integer.valueOf(R$id.channel_permission_stage_request_to_speak);
        String string28 = context.getString(2131895069);
        m.checkNotNullExpressionValue(string28, "context.getString(R.stri…eak_description_category)");
        pairArr[27] = o.to(numValueOf26, new PermissionLabelOverrides(string28, null, null, null, null, null, null, null, null, 510, null));
        Integer numValueOf27 = Integer.valueOf(R$id.channel_permission_events_manage_events);
        String string29 = context.getString(2131895023);
        m.checkNotNullExpressionValue(string29, "context.getString(R.stri…nts_description_category)");
        pairArr[28] = o.to(numValueOf27, new PermissionLabelOverrides(string29, null, null, null, null, null, null, null, null, 510, null));
        return h0.hashMapOf(pairArr);
    }

    @StringRes
    public static final int getChannelPermissionOwnerRoleLabel(GuildRole guildRole) {
        m.checkNotNullParameter(guildRole, "role");
        return (guildRole.getPermissions() & 8) == 8 ? 2131894554 : 2131894557;
    }
}
