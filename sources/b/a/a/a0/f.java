package b.a.a.a0;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f implements View$OnClickListener {
    public final /* synthetic */ ModelGift j;

    public f(ModelGift modelGift) {
        this.j = modelGift;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StoreStream.Companion.getGifting().acceptGift(this.j);
    }
}
