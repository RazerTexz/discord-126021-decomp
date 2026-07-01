package b.a.a;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.restapi.RestAPIParams$EnableMFA;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s$d implements View$OnClickListener {
    public final /* synthetic */ s j;
    public final /* synthetic */ View k;

    public s$d(s sVar, View view) {
        this.j = sVar;
        this.k = view;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        s sVar = this.j;
        KProperty[] kPropertyArr = s.j;
        TextInputLayout textInputLayout = sVar.g().d;
        d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        this.j.g().c.setIsLoading(true);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().enableMFA(new RestAPIParams$EnableMFA("random code", "random secret", textOrEmpty)), false, 1, null), this.j, null, 2, null);
        s$d$a s_d_a = s$d$a.j;
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, this.j.getClass(), this.k.getContext(), (Function1) null, new s$d$b(this), (Function0) null, (Function0) null, s_d_a, 52, (Object) null);
    }
}
