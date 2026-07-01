package b.b.a.i;

import android.content.ContentResolver;
import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.widget.FlexEditText;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.b.a.i.a, reason: use source file name */
/* JADX INFO: compiled from: FlexEditText.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FlexEditText2 extends Lambda implements Function1<InputContentInfoCompat, Unit> {
    public final /* synthetic */ FlexEditText this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlexEditText2(FlexEditText flexEditText) {
        super(1);
        this.this$0 = flexEditText;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(InputContentInfoCompat inputContentInfoCompat) {
        InputContentInfoCompat inputContentInfoCompat2 = inputContentInfoCompat;
        if (inputContentInfoCompat2 != null) {
            Attachment.Companion companion = Attachment.INSTANCE;
            Context context = this.this$0.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ContentResolver contentResolver = context.getContentResolver();
            Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
            companion.c(inputContentInfoCompat2, contentResolver, true, EnvironmentCompat.MEDIA_UNKNOWN);
        }
        return Unit.a;
    }
}
