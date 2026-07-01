package b.b.a.i;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.model.Attachment$Companion;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FlexEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends o implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ FlexEditText this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(FlexEditText flexEditText) {
        super(1);
        this.this$0 = flexEditText;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        InputContentInfoCompat inputContentInfoCompat2 = inputContentInfoCompat;
        if (inputContentInfoCompat2 != null) {
            Attachment$Companion attachment$Companion = Attachment.Companion;
            Context context = this.this$0.getContext();
            m.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            attachment$Companion.c(inputContentInfoCompat2, contentResolver, true, EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return Unit.a;
    }
}
