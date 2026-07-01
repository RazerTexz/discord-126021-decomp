package b.a.a;

import android.content.Context;
import android.view.View;
import b.a.a.WidgetUrgentMessageDialogViewModel3;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.u, reason: use source file name */
/* JADX INFO: compiled from: WidgetUrgentMessageDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUrgentMessageDialog2 implements View.OnClickListener {
    public final /* synthetic */ WidgetUrgentMessageDialog j;

    public WidgetUrgentMessageDialog2(WidgetUrgentMessageDialog widgetUrgentMessageDialog) {
        this.j = widgetUrgentMessageDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer num;
        WidgetUrgentMessageDialog widgetUrgentMessageDialog = this.j;
        KProperty[] kPropertyArr = WidgetUrgentMessageDialog.j;
        WidgetUrgentMessageDialogViewModel3 widgetUrgentMessageDialogViewModel3H = widgetUrgentMessageDialog.h();
        Intrinsics3.checkNotNullExpressionValue(view, "button");
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "button.context");
        Objects.requireNonNull(widgetUrgentMessageDialogViewModel3H);
        Intrinsics3.checkNotNullParameter(context, "context");
        ChannelSelector.INSTANCE.getInstance().findAndSetDirectMessage(context, UserUtils.SYSTEM_USER_ID);
        WidgetUrgentMessageDialogViewModel3.d viewState = widgetUrgentMessageDialogViewModel3H.getViewState();
        if (viewState == null || (num = viewState.a) == null) {
            return;
        }
        RestAPIParams.UserInfo userInfo = new RestAPIParams.UserInfo(null, null, null, null, null, null, null, null, null, Integer.valueOf(num.intValue() & (-8193)), null, 1535, null);
        widgetUrgentMessageDialogViewModel3H.updateViewState(new WidgetUrgentMessageDialogViewModel3.d(viewState.a, true));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(widgetUrgentMessageDialogViewModel3H.l.patchUser(userInfo), false, 1, null), widgetUrgentMessageDialogViewModel3H, null, 2, null), (Class<?>) WidgetUrgentMessageDialogViewModel3.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new WidgetUrgentMessageDialogViewModel5(widgetUrgentMessageDialogViewModel3H)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new WidgetUrgentMessageDialogViewModel4(widgetUrgentMessageDialogViewModel3H));
    }
}
