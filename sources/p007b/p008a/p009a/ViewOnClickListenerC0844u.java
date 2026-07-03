package p007b.p008a.p009a;

import android.content.Context;
import android.view.View;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.C0847x;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.u */
/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC0844u implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0843t f444j;

    public ViewOnClickListenerC0844u(C0843t c0843t) {
        this.f444j = c0843t;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer num;
        C0843t c0843t = this.f444j;
        KProperty[] kPropertyArr = C0843t.f438j;
        C0847x c0847xM146h = c0843t.m146h();
        C12238m.checkNotNullExpressionValue(view, "button");
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "button.context");
        Objects.requireNonNull(c0847xM146h);
        C12238m.checkNotNullParameter(context, "context");
        ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, UserUtils.SYSTEM_USER_ID);
        C0847x.d viewState = c0847xM146h.getViewState();
        if (viewState == null || (num = viewState.f452a) == null) {
            return;
        }
        RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, null, null, null, null, null, null, Integer.valueOf(num.intValue() & (-8193)), null, 1535, null);
        c0847xM146h.updateViewState(new C0847x.d(viewState.f452a, true));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(c0847xM146h.f448l.patchUser(userInfo), false, 1, null), c0847xM146h, null, 2, null), (Class<?>) C0847x.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C0849z(c0847xM146h)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0848y(c0847xM146h));
    }
}
