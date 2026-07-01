package com.discord.widgets.chat.input.emoji;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmojiPickerViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiPickerViewModel$Companion$buildEmojiListItems$items$2 extends Lambda implements Function1<Emoji, WidgetEmojiAdapter.EmojiItem> {
    public final /* synthetic */ boolean $allowEmojisToAnimate;
    public final /* synthetic */ Function1 $getGuild;
    public final /* synthetic */ String $searchInputLower;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$Companion$buildEmojiListItems$items$2(String str, Function1 function1, boolean z2) {
        super(1);
        this.$searchInputLower = str;
        this.$getGuild = function1;
        this.$allowEmojisToAnimate = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetEmojiAdapter.EmojiItem invoke(Emoji emoji) {
        String name;
        Object next;
        String lowerCase;
        Intrinsics3.checkNotNullParameter(emoji, "emoji");
        List<String> names = emoji.getNames();
        Intrinsics3.checkNotNullExpressionValue(names, "emoji.names");
        Iterator<T> it = names.iterator();
        do {
            name = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            Intrinsics3.checkNotNullExpressionValue(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Locale locale = Locale.getDefault();
            Intrinsics3.checkNotNullExpressionValue(locale, "Locale.getDefault()");
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            lowerCase = str.toLowerCase(locale);
            Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        } while (!Strings4.contains$default((CharSequence) lowerCase, (CharSequence) this.$searchInputLower, false, 2, (Object) null));
        String str2 = (String) next;
        if (str2 == null) {
            return null;
        }
        ModelEmojiCustom modelEmojiCustom = (ModelEmojiCustom) (!(emoji instanceof ModelEmojiCustom) ? null : emoji);
        if (modelEmojiCustom != null) {
            Guild guild = (Guild) this.$getGuild.invoke(Long.valueOf(modelEmojiCustom.getGuildId()));
            if (guild != null) {
                name = guild.getName();
            }
        }
        return new WidgetEmojiAdapter.EmojiItem(name, emoji, str2, this.$allowEmojisToAnimate);
    }
}
