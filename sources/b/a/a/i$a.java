package b.a.a;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.uri.UriHandler;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class i$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    public i$a(int i, Object obj, Object obj2) {
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context contextRequireContext = ((i) this.k).requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            UriHandler.handle$default(uriHandler, contextRequireContext, (String) this.l, false, false, null, 28, null);
            ((i) this.k).dismiss();
            return;
        }
        if (i != 1) {
            throw null;
        }
        Context contextRequireContext2 = ((i) this.k).requireContext();
        d0.z.d.m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        String str = (String) this.l;
        d0.z.d.m.checkNotNullExpressionValue(str, "username");
        b.a.d.m.a(contextRequireContext2, str, 2131887925);
        ((i) this.k).dismiss();
    }
}
