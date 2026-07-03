package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class EmojiPickerViewModel$handleStoreState$favoriteItems$1 extends C12236k implements Function1<Long, Guild> {
    public EmojiPickerViewModel$handleStoreState$favoriteItems$1(LinkedHashMap linkedHashMap) {
        super(1, linkedHashMap, LinkedHashMap.class, "get", "get(Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Guild invoke(Long l) {
        C12238m.checkNotNullParameter(l, "p1");
        return (Guild) ((LinkedHashMap) this.receiver).get(l);
    }
}
