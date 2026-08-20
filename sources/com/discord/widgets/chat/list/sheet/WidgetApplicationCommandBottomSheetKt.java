package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandValue;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetKt {

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1 */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class C81671 extends AbstractC12240o implements Function1<ApplicationCommandValue, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81671(Map map) {
            super(1);
            this.$commandValues = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ApplicationCommandValue applicationCommandValue) {
            C12238m.checkNotNullParameter(applicationCommandValue, "it");
            return WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(applicationCommandValue, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2 */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class C81682 extends AbstractC12240o implements Function1<ApplicationCommandValue, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81682(Map map) {
            super(1);
            this.$commandValues = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ApplicationCommandValue applicationCommandValue) {
            C12238m.checkNotNullParameter(applicationCommandValue, "it");
            return WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(applicationCommandValue, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        String strJoinToString$default;
        C12238m.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        C12238m.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandValue> listM7725b = applicationCommandData.m7725b();
        if (listM7725b == null || (strJoinToString$default = C12163u.joinToString$default(listM7725b, " ", null, null, 0, null, new C81671(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandValue applicationCommandValue, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        C12238m.checkNotNullParameter(applicationCommandValue, "$this$toSlashCommandCopyString");
        C12238m.checkNotNullParameter(map, "commandValues");
        if (applicationCommandValue.m7741c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandValue.getName());
            sb.append(' ');
            List<ApplicationCommandValue> listM7741c = applicationCommandValue.m7741c();
            sb.append(listM7741c != null ? C12163u.joinToString$default(listM7741c, " ", null, null, 0, null, new C81682(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandValue.getName());
        sb2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = map.get(applicationCommandValue.getName());
        sb2.append(slashCommandParam != null ? slashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
