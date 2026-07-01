package b.a.a.g;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;
    public final /* synthetic */ Object l;

    public a$a(int i, Object obj, Object obj2) {
        this.j = i;
        this.k = obj;
        this.l = obj2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            a aVar = (a) this.k;
            m.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "v.context");
            String str = (String) this.l;
            KProperty[] kPropertyArr = a.j;
            aVar.h(context, str);
            return;
        }
        if (i != 1) {
            throw null;
        }
        a aVar2 = (a) this.k;
        m.checkNotNullExpressionValue(view, "v");
        Context context2 = view.getContext();
        m.checkNotNullExpressionValue(context2, "v.context");
        String str2 = (String) this.l;
        KProperty[] kPropertyArr2 = a.j;
        Objects.requireNonNull(aVar2);
        StoreStream.Companion.getMaskedLinks().trustDomain(str2);
        aVar2.h(context2, str2);
    }
}
