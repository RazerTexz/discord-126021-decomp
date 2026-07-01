package b.a.a;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetEnableTwoFactorPasswordDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s$d$b extends d0.z.d.o implements Function1<Error, Unit> {
    public final /* synthetic */ s$d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s$d$b(s$d s_d) {
        super(1);
        this.this$0 = s_d;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Error error2 = error;
        d0.z.d.m.checkNotNullParameter(error2, "error");
        s sVar = this.this$0.j;
        KProperty[] kPropertyArr = s.j;
        sVar.g().c.setIsLoading(false);
        Error$Response response = error2.getResponse();
        d0.z.d.m.checkNotNullExpressionValue(response, "error.response");
        if (response.getCode() == 60005) {
            error2.setShowErrorToasts(false);
            this.this$0.j.dismiss();
            s sVar2 = this.this$0.j;
            Function1<? super String, Unit> function1 = sVar2.onValidPasswordEntered;
            TextInputLayout textInputLayout = sVar2.g().d;
            d0.z.d.m.checkNotNullExpressionValue(textInputLayout, "binding.enableTwoFactorPasswordViewInput");
            function1.invoke(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
        return Unit.a;
    }
}
