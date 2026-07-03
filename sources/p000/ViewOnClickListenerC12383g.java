package p000;

import android.view.View;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreStream;
import p007b.p008a.p009a.p011a0.C0805c;

/* JADX INFO: renamed from: g */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12383g implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f26065j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f26066k;

    public ViewOnClickListenerC12383g(int i, Object obj) {
        this.f26065j = i;
        this.f26066k = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f26065j;
        if (i == 0) {
            StoreStream.INSTANCE.getGifting().acceptGift(((StoreGifting.GiftState.RedeemedFailed) this.f26066k).getGift());
        } else {
            if (i != 1) {
                throw null;
            }
            ((C0805c) this.f26066k).dismiss();
        }
    }
}
