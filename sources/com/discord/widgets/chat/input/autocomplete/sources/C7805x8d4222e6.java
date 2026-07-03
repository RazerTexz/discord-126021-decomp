package com.discord.widgets.chat.input.autocomplete.sources;

import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.UserAutocompletable;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.autocomplete.sources.UserAutocompletableSource$createAutocompletablesForUsers$mentions$1 */
/* JADX INFO: compiled from: UserMentionableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7805x8d4222e6 extends AbstractC12240o implements Function1<Autocompletable, Integer> {
    public final /* synthetic */ int $numPartitions;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7805x8d4222e6(int i) {
        super(1);
        this.$numPartitions = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Integer invoke(Autocompletable autocompletable) {
        return Integer.valueOf(invoke2(autocompletable));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2(Autocompletable autocompletable) {
        C12238m.checkNotNullParameter(autocompletable, "e");
        if (autocompletable instanceof UserAutocompletable) {
            return (int) ((((UserAutocompletable) autocompletable).getUser().getId() >> 22) % ((long) this.$numPartitions));
        }
        return 0;
    }
}
