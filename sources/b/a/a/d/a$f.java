package b.a.a.d;

import android.content.Context;
import android.widget.TextView;
import com.discord.R$integer;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: UserActionsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$f extends k implements Function1<f$d$a, Unit> {
    public a$f(a aVar) {
        super(1, aVar, a.class, "updateView", "updateView(Lcom/discord/dialogs/useractions/UserActionsDialogViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(f$d$a f_d_a) {
        f$d$a f_d_a2 = f_d_a;
        m.checkNotNullParameter(f_d_a2, "p1");
        a aVar = (a) this.receiver;
        KProperty[] kPropertyArr = a.j;
        SimpleDraweeView simpleDraweeView = aVar.g().f209b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.userActionsDialogAvatar");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(f_d_a2.a, true, null, 4, null), 0, (Function1) null, aVar.imagesChangeDetector, 12, (Object) null);
        TextView textView = aVar.g().f;
        m.checkNotNullExpressionValue(textView, "binding.userActionsDialogUserName");
        User user = f_d_a2.a;
        String str = f_d_a2.f47b;
        Context contextRequireContext = aVar.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, str, contextRequireContext, 2130968989, 2130969396, R$integer.uikit_textsize_large_sp, 2130969056, 2130969395, R$integer.uikit_textsize_large_sp));
        TextView textView2 = aVar.g().c;
        m.checkNotNullExpressionValue(textView2, "binding.userActionsDialogBlockItem");
        textView2.setVisibility(f_d_a2.c ? 0 : 8);
        TextView textView3 = aVar.g().e;
        m.checkNotNullExpressionValue(textView3, "binding.userActionsDialogUnblockItem");
        textView3.setVisibility(f_d_a2.d ? 0 : 8);
        TextView textView4 = aVar.g().d;
        m.checkNotNullExpressionValue(textView4, "binding.userActionsDialogRemoveFriendItem");
        textView4.setVisibility(f_d_a2.e ? 0 : 8);
        return Unit.a;
    }
}
