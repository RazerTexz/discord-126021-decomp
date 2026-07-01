package com.discord.widgets.chat.list.sheet;

import com.discord.api.commands.ApplicationCommandValue;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1 extends o implements Function1<ApplicationCommandValue, CharSequence> {
    public final /* synthetic */ Map $commandValues;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheetKt$toSlashCommandCopyString$1(Map map) {
        super(1);
        this.$commandValues = map;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ApplicationCommandValue applicationCommandValue) {
        m.checkNotNullParameter(applicationCommandValue, "it");
        return WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(applicationCommandValue, (Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam>) this.$commandValues);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ApplicationCommandValue applicationCommandValue) {
        return invoke2(applicationCommandValue);
    }
}
