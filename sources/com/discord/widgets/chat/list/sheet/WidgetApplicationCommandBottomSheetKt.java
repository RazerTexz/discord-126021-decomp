package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandValue;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetKt {
    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> map) {
        String strJoinToString$default;
        m.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        m.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandValue> listB = applicationCommandData.b();
        if (listB == null || (strJoinToString$default = u.joinToString$default(listB, " ", null, null, 0, null, new WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandValue applicationCommandValue, Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> map) {
        m.checkNotNullParameter(applicationCommandValue, "$this$toSlashCommandCopyString");
        m.checkNotNullParameter(map, "commandValues");
        if (applicationCommandValue.c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandValue.getName());
            sb.append(' ');
            List<ApplicationCommandValue> listC = applicationCommandValue.c();
            sb.append(listC != null ? u.joinToString$default(listC, " ", null, null, 0, null, new WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandValue.getName());
        sb2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam widgetApplicationCommandBottomSheetViewModel$SlashCommandParam = map.get(applicationCommandValue.getName());
        sb2.append(widgetApplicationCommandBottomSheetViewModel$SlashCommandParam != null ? widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
