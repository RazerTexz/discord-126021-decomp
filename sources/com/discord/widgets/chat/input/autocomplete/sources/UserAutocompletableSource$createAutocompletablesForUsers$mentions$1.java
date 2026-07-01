package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAutocompletableSource$createAutocompletablesForUsers$mentions$1 extends o implements Function1<Autocompletable, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAutocompletableSource$createAutocompletablesForUsers$mentions$1(int i) {
        super(1);
        this.$numPartitions = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Autocompletable autocompletable) {
        return Integer.valueOf(invoke2(autocompletable));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(Autocompletable autocompletable) {
        m.checkNotNullParameter(autocompletable, "e");
        if (autocompletable instanceof UserAutocompletable) {
            return (int) ((((UserAutocompletable) autocompletable).getUser().getId() >> 22) % ((long) this.$numPartitions));
        }
        return 0;
    }
}
