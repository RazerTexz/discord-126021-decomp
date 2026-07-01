package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1 extends FunctionReferenceImpl implements Function1<Long, Guild> {
    public EmojiPickerViewModel$handleStoreState$unicodeCategoryItems$1(LinkedHashMap linkedHashMap) {
        super(1, linkedHashMap, LinkedHashMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Guild invoke(Long l) {
        Intrinsics3.checkNotNullParameter(l, "p1");
        return (Guild) ((LinkedHashMap) this.receiver).get(l);
    }
}
