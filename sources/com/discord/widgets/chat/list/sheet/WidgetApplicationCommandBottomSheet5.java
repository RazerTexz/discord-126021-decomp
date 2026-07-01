package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandData;
import com.discord.api.commands.ApplicationCommandData3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet5 {

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map map) {
            super(1);
            this.$commandValues = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ApplicationCommandData3, CharSequence> {
        public final /* synthetic */ Map $commandValues;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Map map) {
            super(1);
            this.$commandValues = map;
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(ApplicationCommandData3 applicationCommandData3) {
            Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
            return WidgetApplicationCommandBottomSheet5.toSlashCommandCopyString(applicationCommandData3, (Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam>) this.$commandValues);
        }
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData applicationCommandData, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        String strJoinToString$default;
        Intrinsics3.checkNotNullParameter(applicationCommandData, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(applicationCommandData.getName());
        sb.append(' ');
        List<ApplicationCommandData3> listB = applicationCommandData.b();
        if (listB == null || (strJoinToString$default = _Collections.joinToString$default(listB, " ", null, null, 0, null, new AnonymousClass1(map), 30, null)) == null) {
            strJoinToString$default = "";
        }
        sb.append(strJoinToString$default);
        return sb.toString();
    }

    public static final String toSlashCommandCopyString(ApplicationCommandData3 applicationCommandData3, Map<String, WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam> map) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "$this$toSlashCommandCopyString");
        Intrinsics3.checkNotNullParameter(map, "commandValues");
        if (applicationCommandData3.c() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(applicationCommandData3.getName());
            sb.append(' ');
            List<ApplicationCommandData3> listC = applicationCommandData3.c();
            sb.append(listC != null ? _Collections.joinToString$default(listC, " ", null, null, 0, null, new AnonymousClass2(map), 30, null) : null);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(applicationCommandData3.getName());
        sb2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        WidgetApplicationCommandBottomSheetViewModel.SlashCommandParam slashCommandParam = map.get(applicationCommandData3.getName());
        sb2.append(slashCommandParam != null ? slashCommandParam.getCopyText() : null);
        return sb2.toString();
    }
}
