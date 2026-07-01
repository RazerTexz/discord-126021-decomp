package com.discord.widgets.chat.input.autocomplete.sources;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.widgets.chat.input.autocomplete.Autocompletable;
import com.discord.widgets.chat.input.autocomplete.LeadingIdentifier;
import d0.z.d.m;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func2;

/* JADX INFO: compiled from: EmojiAutocompletableSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiAutocompletableSource$observeEmojiAutocompletables$1<T1, T2, R> implements Func2<EmojiSet, Boolean, Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>>> {
    public final /* synthetic */ EmojiAutocompletableSource this$0;

    public EmojiAutocompletableSource$observeEmojiAutocompletables$1(EmojiAutocompletableSource emojiAutocompletableSource) {
        this.this$0 = emojiAutocompletableSource;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Map<LeadingIdentifier, ? extends TreeSet<Autocompletable>> call(EmojiSet emojiSet, Boolean bool) {
        return call2(emojiSet, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Map<LeadingIdentifier, TreeSet<Autocompletable>> call2(EmojiSet emojiSet, Boolean bool) {
        EmojiAutocompletableSource emojiAutocompletableSource = this.this$0;
        m.checkNotNullExpressionValue(emojiSet, "emojiSet");
        m.checkNotNullExpressionValue(bool, "animationsEnabled");
        return EmojiAutocompletableSource.access$createFromEmojiSet(emojiAutocompletableSource, emojiSet, bool.booleanValue());
    }
}
