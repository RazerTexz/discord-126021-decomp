package b.a.a;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$UserInfo;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class u implements View$OnClickListener {
    public final /* synthetic */ t j;

    public u(t tVar) {
        this.j = tVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Integer num;
        t tVar = this.j;
        KProperty[] kPropertyArr = t.j;
        x xVarH = tVar.h();
        d0.z.d.m.checkNotNullExpressionValue(view, "button");
        Context context = view.getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "button.context");
        Objects.requireNonNull(xVarH);
        d0.z.d.m.checkNotNullParameter(context, "context");
        ChannelSelector.Companion.getInstance().findAndSetDirectMessage(context, UserUtils.SYSTEM_USER_ID);
        x$d viewState = xVarH.getViewState();
        if (viewState == null || (num = viewState.a) == null) {
            return;
        }
        RestAPIParams$UserInfo restAPIParams$UserInfo = new RestAPIParams$UserInfo(null, null, null, null, null, null, null, null, null, Integer.valueOf(num.intValue() & (-8193)), null, 1535, null);
        xVarH.updateViewState(new x$d(viewState.a, true));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(xVarH.l.patchUser(restAPIParams$UserInfo), false, 1, null), xVarH, null, 2, null), x.class, (Context) null, (Function1) null, new z(xVarH), (Function0) null, (Function0) null, new y(xVarH), 54, (Object) null);
    }
}
