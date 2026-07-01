package com.discord.widgets.chat.input.emoji;

import com.discord.models.guild.Guild;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildGuildEmojiListItems$$inlined$let$lambda$1 extends o implements Function1<Long, Guild> {
    public final /* synthetic */ boolean $allowEmojisToAnimate$inlined;
    public final /* synthetic */ Guild $guild$inlined;
    public final /* synthetic */ boolean $includeUnavailable$inlined;
    public final /* synthetic */ boolean $partition$inlined;
    public final /* synthetic */ String $searchInputLower$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildGuildEmojiListItems$$inlined$let$lambda$1(Guild guild, String str, boolean z2, boolean z3, boolean z4) {
        super(1);
        this.$guild$inlined = guild;
        this.$searchInputLower$inlined = str;
        this.$allowEmojisToAnimate$inlined = z2;
        this.$partition$inlined = z3;
        this.$includeUnavailable$inlined = z4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Guild invoke(Long l) {
        return invoke(l.longValue());
    }

    public final Guild invoke(long j) {
        return this.$guild$inlined;
    }
}
