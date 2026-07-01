package b.a.a;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.i.DialogDatePickerBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.a.k, reason: use source file name */
/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DatePickerDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(DatePickerDialog.class, "binding", "getBinding()Lcom/discord/databinding/DialogDatePickerBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super Long, Unit> onDatePicked;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public long selectedDate;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean datePicked;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.k$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: DatePickerDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final DatePickerDialog a(FragmentManager fragmentManager, CharSequence charSequence, long j, long j2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(charSequence, "label");
            DatePickerDialog datePickerDialog = new DatePickerDialog();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("label", charSequence);
            bundle.putLong("initial_date", j);
            bundle.putLong("max_date", j2);
            datePickerDialog.setArguments(bundle);
            datePickerDialog.show(fragmentManager, DatePickerDialog.class.getName());
            return datePickerDialog;
        }
    }

    /* JADX INFO: renamed from: b.a.a.k$b */
    /* JADX INFO: compiled from: DatePickerDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, DialogDatePickerBinding> {
        public static final b j = new b();

        public b() {
            super(1, DialogDatePickerBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogDatePickerBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public DialogDatePickerBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.dialog_date_picker_done;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.dialog_date_picker_done);
            if (materialButton != null) {
                i = R.id.dialog_date_picker_input;
                DatePicker datePicker = (DatePicker) view2.findViewById(R.id.dialog_date_picker_input);
                if (datePicker != null) {
                    i = R.id.dialog_date_picker_title;
                    TextView textView = (TextView) view2.findViewById(R.id.dialog_date_picker_title);
                    if (textView != null) {
                        return new DialogDatePickerBinding((LinearLayout) view2, materialButton, datePicker, textView);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.k$c */
    /* JADX INFO: compiled from: DatePickerDialog.kt */
    public static final class c implements DatePicker.OnDateChangedListener {
        public c() {
        }

        @Override // android.widget.DatePicker.OnDateChangedListener
        public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(i, i2, i3);
            DatePickerDialog datePickerDialog = DatePickerDialog.this;
            Intrinsics3.checkNotNullExpressionValue(calendar, "cal");
            datePickerDialog.selectedDate = calendar.getTimeInMillis();
            DatePickerDialog datePickerDialog2 = DatePickerDialog.this;
            datePickerDialog2.datePicked = true;
            Function1<? super Long, Unit> function1 = datePickerDialog2.onDatePicked;
            if (function1 != null) {
                function1.invoke(Long.valueOf(datePickerDialog2.selectedDate));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.k$d */
    /* JADX INFO: compiled from: DatePickerDialog.kt */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Long, Unit> function1;
            DatePickerDialog datePickerDialog = DatePickerDialog.this;
            if (datePickerDialog.datePicked && (function1 = datePickerDialog.onDatePicked) != null) {
                function1.invoke(Long.valueOf(datePickerDialog.selectedDate));
            }
            DatePickerDialog.this.dismiss();
        }
    }

    public DatePickerDialog() {
        super(R.layout.dialog_date_picker);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final DialogDatePickerBinding g() {
        return (DialogDatePickerBinding) this.binding.getValue((Fragment) this, j[0]);
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
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.dialogDatePickerTitle");
        Bundle arguments = getArguments();
        if (arguments == null || (charSequence = arguments.getCharSequence("label")) == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
        DatePicker datePicker = g().c;
        Intrinsics3.checkNotNullExpressionValue(datePicker, "binding.dialogDatePickerInput");
        Bundle arguments2 = getArguments();
        datePicker.setMaxDate(arguments2 != null ? arguments2.getLong("max_date") : 0L);
        DatePicker datePicker2 = g().c;
        Intrinsics3.checkNotNullExpressionValue(datePicker2, "binding.dialogDatePickerInput");
        datePicker2.setMinDate(BirthdayHelper.INSTANCE.subtractYearsFromToday(150));
        Bundle arguments3 = getArguments();
        this.selectedDate = arguments3 != null ? arguments3.getLong("initial_date") : 0L;
        if (this.onDatePicked == null) {
            dismiss();
        }
        Calendar calendar = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(this.selectedDate);
        g().c.init(calendar.get(1), calendar.get(2), calendar.get(5), new c());
        g().f143b.setOnClickListener(new d());
    }
}
