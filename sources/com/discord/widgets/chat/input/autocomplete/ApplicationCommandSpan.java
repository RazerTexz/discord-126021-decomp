package com.discord.widgets.chat.input.autocomplete;

import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommandSpan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandSpan extends SimpleRoundedBackgroundSpan {
    private final ApplicationCommandOption commandOption;
    private final String commandValue;

    public /* synthetic */ ApplicationCommandSpan(ApplicationCommandOption applicationCommandOption, String str, int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1 function1, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommandOption, str, i, i2, i3, i4, i5, f, (i6 & 256) != 0 ? null : num, (i6 & 512) != 0 ? true : z2, (i6 & 1024) != 0 ? null : function1);
    }

    public final ApplicationCommandOption getCommandOption() {
        return this.commandOption;
    }

    public final String getCommandValue() {
        return this.commandValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandSpan(ApplicationCommandOption applicationCommandOption, String str, int i, int i2, int i3, int i4, int i5, float f, Integer num, boolean z2, Function1<? super String, String> function1) {
        super(i, i2, i3, i4, i5, f, num, z2, function1, 0, 512, null);
        m.checkNotNullParameter(applicationCommandOption, "commandOption");
        this.commandOption = applicationCommandOption;
        this.commandValue = str;
    }
}
