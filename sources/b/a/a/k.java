package b.a.a;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {a.d0(k.class, "binding", "getBinding()Lcom/discord/databinding/DialogDatePickerBinding;", 0)};
    public static final k$a k = new k$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Long, Unit> onDatePicked;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public long selectedDate;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean datePicked;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public k() {
        super(R$layout.dialog_date_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, k$b.j, null, 2, null);
    }

    public final b.a.i.k g() {
        return (b.a.i.k) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        g().c.clearFocus();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        CharSequence charSequence;
        super.onViewBoundOrOnResume();
        TextView textView = g().d;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.dialogDatePickerTitle");
        Bundle arguments = getArguments();
        if (arguments == null || (charSequence = arguments.getCharSequence("label")) == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
        DatePicker datePicker = g().c;
        d0.z.d.m.checkNotNullExpressionValue(datePicker, "binding.dialogDatePickerInput");
        Bundle arguments2 = getArguments();
        datePicker.setMaxDate(arguments2 != null ? arguments2.getLong("max_date") : 0L);
        DatePicker datePicker2 = g().c;
        d0.z.d.m.checkNotNullExpressionValue(datePicker2, "binding.dialogDatePickerInput");
        datePicker2.setMinDate(BirthdayHelper.INSTANCE.subtractYearsFromToday(150));
        Bundle arguments3 = getArguments();
        this.selectedDate = arguments3 != null ? arguments3.getLong("initial_date") : 0L;
        if (this.onDatePicked == null) {
            dismiss();
        }
        Calendar calendar = Calendar.getInstance();
        d0.z.d.m.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(this.selectedDate);
        g().c.init(calendar.get(1), calendar.get(2), calendar.get(5), new k$c(this));
        g().f143b.setOnClickListener(new k$d(this));
    }
}
