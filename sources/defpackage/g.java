package defpackage;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.a.a0.c;
import com.discord.stores.StoreGifting$GiftState$RedeemedFailed;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class g implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public g(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            StoreStream.Companion.getGifting().acceptGift(((StoreGifting$GiftState$RedeemedFailed) this.k).getGift());
        } else {
            if (i != 1) {
                throw null;
            }
            ((c) this.k).dismiss();
        }
    }
}
