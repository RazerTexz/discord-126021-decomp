package b.i.a.g.d;

import android.content.Context;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.util.Date;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ c k;

    public c$a(c cVar, String str) {
        this.k = cVar;
        this.j = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.k;
        TextInputLayout textInputLayout = cVar.j;
        DateFormat dateFormat = cVar.k;
        Context context = textInputLayout.getContext();
        textInputLayout.setError(context.getString(R$string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_use), this.j) + "\n" + String.format(context.getString(R$string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(l.h().getTimeInMillis()))));
        this.k.a();
    }
}
