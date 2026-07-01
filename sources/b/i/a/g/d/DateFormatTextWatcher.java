package b.i.a.g.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/* JADX INFO: renamed from: b.i.a.g.d.c, reason: use source file name */
/* JADX INFO: compiled from: DateFormatTextWatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DateFormatTextWatcher extends TextWatcherAdapter {

    @NonNull
    public final TextInputLayout j;
    public final DateFormat k;
    public final CalendarConstraints l;
    public final String m;
    public final Runnable n;
    public Runnable o;

    /* JADX INFO: renamed from: b.i.a.g.d.c$a */
    /* JADX INFO: compiled from: DateFormatTextWatcher.java */
    public class a implements Runnable {
        public final /* synthetic */ String j;

        public a(String str) {
            this.j = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            DateFormatTextWatcher dateFormatTextWatcher = DateFormatTextWatcher.this;
            TextInputLayout textInputLayout = dateFormatTextWatcher.j;
            DateFormat dateFormat = dateFormatTextWatcher.k;
            Context context = textInputLayout.getContext();
            textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), this.j) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(UtcDates.h().getTimeInMillis()))));
            DateFormatTextWatcher.this.a();
        }
    }

    public DateFormatTextWatcher(String str, DateFormat dateFormat, @NonNull TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.k = dateFormat;
        this.j = textInputLayout;
        this.l = calendarConstraints;
        this.m = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.n = new a(str);
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
            DateFormatTextWatcher2 dateFormatTextWatcher2 = new DateFormatTextWatcher2(this, time);
            this.o = dateFormatTextWatcher2;
            this.j.postDelayed(dateFormatTextWatcher2, 1000L);
        } catch (ParseException unused) {
            this.j.postDelayed(this.n, 1000L);
        }
    }
}
