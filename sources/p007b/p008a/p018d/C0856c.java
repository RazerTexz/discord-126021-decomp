package p007b.p008a.p018d;

import android.util.TypedValue;
import com.discord.app.AppActivity;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.d.c */
/* JADX INFO: compiled from: AppActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0856c extends AbstractC12240o implements Function2<Integer, Boolean, TypedValue> {
    public final /* synthetic */ AppActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0856c(AppActivity appActivity) {
        super(2);
        this.this$0 = appActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public TypedValue invoke(Integer num, Boolean bool) {
        int iIntValue = num.intValue();
        boolean zBooleanValue = bool.booleanValue();
        TypedValue typedValue = new TypedValue();
        this.this$0.getTheme().resolveAttribute(iIntValue, typedValue, zBooleanValue);
        return typedValue;
    }
}
