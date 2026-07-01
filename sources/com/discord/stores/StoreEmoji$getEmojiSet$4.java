package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.utilities.Quad;
import com.discord.utilities.rx.ObservableExtensionsKt;
import j0.k.b;
import java.util.List;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: StoreEmoji.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmoji$getEmojiSet$4<T, R> implements b<Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>>, Observable<? extends EmojiSet>> {
    public final /* synthetic */ StoreEmoji$EmojiContext $emojiContext;
    public final /* synthetic */ boolean $includeUnavailableEmojis;
    public final /* synthetic */ boolean $includeUnusableEmojis;
    public final /* synthetic */ StoreEmoji this$0;

    public StoreEmoji$getEmojiSet$4(StoreEmoji storeEmoji, StoreEmoji$EmojiContext storeEmoji$EmojiContext, boolean z2, boolean z3) {
        this.this$0 = storeEmoji;
        this.$emojiContext = storeEmoji$EmojiContext;
        this.$includeUnavailableEmojis = z2;
        this.$includeUnusableEmojis = z3;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends EmojiSet> call(Quad<? extends Boolean, ? extends Boolean, ? extends List<? extends Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>> quad) {
        return call2((Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>>) quad);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends EmojiSet> call2(Quad<Boolean, Boolean, ? extends List<Long>, ? extends Set<? extends StoreMediaFavorites$Favorite>> quad) {
        Boolean boolComponent1 = quad.component1();
        Boolean boolComponent2 = quad.component2();
        return ObservableExtensionsKt.computationLatest(StoreEmoji.access$getCustomEmojiStore$p(this.this$0).observeAllowedGuildEmoji()).G(new StoreEmoji$getEmojiSet$4$1(this, quad.component3(), boolComponent1, boolComponent2, quad.component4()));
    }
}
