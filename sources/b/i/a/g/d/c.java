package b.i.a.g.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends TextWatcherAdapter {

    @NonNull
    public final TextInputLayout j;
    public final DateFormat k;
    public final CalendarConstraints l;
    public final String m;
    public final Runnable n;
    public Runnable o;

    public c(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.k = dateFormat;
        this.j = textInputLayout;
        this.l = calendarConstraints;
        this.m = textInputLayout.getContext().getString(R$string.mtrl_picker_out_of_range);
        this.n = new c$a(this, str);
    }

    public abstract void a();

    public abstract void b(@Nullable Long l);

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void onTextChanged(@NonNull CharSequence charSequence, int i, int i2, int i3) {
        this.j.removeCallbacks(this.n);
        this.j.removeCallbacks(this.o);
        this.j.setError(null);
        b(null);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        try {
            Date date = this.k.parse(charSequence.toString());
            this.j.setError(null);
            long time = date.getTime();
            if (this.l.getDateValidator().isValid(time) && this.l.isWithinBounds(time)) {
                b(Long.valueOf(date.getTime()));
                return;
            }
            d dVar = new d(this, time);
            this.o = dVar;
            this.j.postDelayed(dVar, 1000L);
        } catch (ParseException unused) {
            this.j.postDelayed(this.n, 1000L);
        }
    }
}
