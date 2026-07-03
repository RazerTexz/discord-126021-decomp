package p007b.p008a.p009a.p011a0;

import android.view.View;
import com.discord.models.domain.ModelGift;
import com.discord.stores.StoreStream;

/* JADX INFO: renamed from: b.a.a.a0.f */
/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0808f implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ ModelGift f241j;

    public ViewOnClickListenerC0808f(ModelGift modelGift) {
        this.f241j = modelGift;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreStream.INSTANCE.getGifting().acceptGift(this.f241j);
    }
}
