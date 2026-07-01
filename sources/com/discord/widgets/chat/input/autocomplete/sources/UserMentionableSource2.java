package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$createAutocompletablesForUsers$mentions$1, reason: use source file name */
/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionableSource2 extends Lambda implements Function1<Autocompletable, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMentionableSource2(int i) {
        super(1);
        this.$numPartitions = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Autocompletable autocompletable) {
        return Integer.valueOf(invoke2(autocompletable));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(Autocompletable autocompletable) {
        Intrinsics3.checkNotNullParameter(autocompletable, "e");
        if (autocompletable instanceof UserAutocompletable) {
            return (int) ((((UserAutocompletable) autocompletable).getUser().getId() >> 22) % ((long) this.$numPartitions));
        }
        return 0;
    }
}
