package b.i.a.c.b3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout$Alignment;
import androidx.core.view.ViewCompat;
import b.i.a.c.w0;
import b.i.a.c.w0$a;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements w0$a {
    public static final /* synthetic */ a a = new a();

    @Override // b.i.a.c.w0$a
    public final w0 a(Bundle bundle) {
        float f;
        int i;
        int i2;
        float f2;
        boolean z2;
        int i3;
        CharSequence charSequence = bundle.getCharSequence(b.b(0));
        CharSequence charSequence2 = charSequence != null ? charSequence : null;
        Layout$Alignment layout$Alignment = (Layout$Alignment) bundle.getSerializable(b.b(1));
        Layout$Alignment layout$Alignment2 = layout$Alignment != null ? layout$Alignment : null;
        Layout$Alignment layout$Alignment3 = (Layout$Alignment) bundle.getSerializable(b.b(2));
        Layout$Alignment layout$Alignment4 = layout$Alignment3 != null ? layout$Alignment3 : null;
        Bitmap bitmap = (Bitmap) bundle.getParcelable(b.b(3));
        Bitmap bitmap2 = bitmap != null ? bitmap : null;
        if (bundle.containsKey(b.b(4)) && bundle.containsKey(b.b(5))) {
            f = bundle.getFloat(b.b(4));
            i = bundle.getInt(b.b(5));
        } else {
            f = -3.4028235E38f;
            i = Integer.MIN_VALUE;
        }
        int i4 = bundle.containsKey(b.b(6)) ? bundle.getInt(b.b(6)) : Integer.MIN_VALUE;
        float f3 = bundle.containsKey(b.b(7)) ? bundle.getFloat(b.b(7)) : -3.4028235E38f;
        int i5 = bundle.containsKey(b.b(8)) ? bundle.getInt(b.b(8)) : Integer.MIN_VALUE;
        if (bundle.containsKey(b.b(10)) && bundle.containsKey(b.b(9))) {
            f2 = bundle.getFloat(b.b(10));
            i2 = bundle.getInt(b.b(9));
        } else {
            i2 = Integer.MIN_VALUE;
            f2 = -3.4028235E38f;
        }
        float f4 = bundle.containsKey(b.b(11)) ? bundle.getFloat(b.b(11)) : -3.4028235E38f;
        float f5 = bundle.containsKey(b.b(12)) ? bundle.getFloat(b.b(12)) : -3.4028235E38f;
        if (bundle.containsKey(b.b(13))) {
            i3 = bundle.getInt(b.b(13));
            z2 = true;
        } else {
            z2 = false;
            i3 = ViewCompat.MEASURED_STATE_MASK;
        }
        return new b(charSequence2, layout$Alignment2, layout$Alignment4, bitmap2, f, i, i4, f3, i5, i2, f2, f4, f5, bundle.getBoolean(b.b(14), false) ? z2 : false, i3, bundle.containsKey(b.b(15)) ? bundle.getInt(b.b(15)) : Integer.MIN_VALUE, bundle.containsKey(b.b(16)) ? bundle.getFloat(b.b(16)) : 0.0f, null);
    }
}
