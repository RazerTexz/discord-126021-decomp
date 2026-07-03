package p007b.p076b.p077a.p084i;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.b.a.i.a */
/* JADX INFO: compiled from: FlexEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C1452a extends AbstractC12240o implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ FlexEditText this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1452a(FlexEditText flexEditText) {
        super(1);
        this.this$0 = flexEditText;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        InputContentInfoCompat inputContentInfoCompat2 = inputContentInfoCompat;
        if (inputContentInfoCompat2 != null) {
            Attachment.Companion companion = Attachment.INSTANCE;
            Context context = this.this$0.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            companion.m9297c(inputContentInfoCompat2, contentResolver, true, EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return Unit.f27425a;
    }
}
