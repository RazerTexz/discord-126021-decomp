package b.a.a.a0;

import com.discord.stores.StoreGifting$GiftState;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$d<T1, T2, R> implements Func2<StoreGifting$GiftState, Boolean, c$a$a> {
    public static final c$d j = new c$d();

    @Override // rx.functions.Func2
    public c$a$a call(StoreGifting$GiftState storeGifting$GiftState, Boolean bool) {
        StoreGifting$GiftState storeGifting$GiftState2 = storeGifting$GiftState;
        Boolean bool2 = bool;
        m.checkNotNullExpressionValue(storeGifting$GiftState2, "giftState");
        m.checkNotNullExpressionValue(bool2, "reduceMotion");
        return new c$a$a(storeGifting$GiftState2, bool2.booleanValue());
    }
}
