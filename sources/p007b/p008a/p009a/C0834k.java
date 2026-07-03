package p007b.p008a.p009a;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.utilities.birthday.BirthdayHelper;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p025i.C0988k;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.a.k */
/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0834k extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f396j = {C1643a.m846d0(C0834k.class, "binding", "getBinding()Lcom/discord/databinding/DialogDatePickerBinding;", 0)};

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

        /* JADX INFO: renamed from: a */
        public final C0834k m139a(FragmentManager fragmentManager, CharSequence charSequence, long j, long j2) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(charSequence, "label");
            C0834k c0834k = new C0834k();
            Bundle bundle = new Bundle();
            bundle.putCharSequence("label", charSequence);
            bundle.putLong("initial_date", j);
            bundle.putLong("max_date", j2);
            c0834k.setArguments(bundle);
            c0834k.show(fragmentManager, C0834k.class.getName());
            return c0834k;
        }
    }

    /* JADX INFO: renamed from: b.a.a.k$b */
    /* JADX INFO: compiled from: DatePickerDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C0988k> {

        /* JADX INFO: renamed from: j */
        public static final b f402j = new b();

        public b() {
            super(1, C0988k.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogDatePickerBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C0988k invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.dialog_date_picker_done;
            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.dialog_date_picker_done);
            if (materialButton != null) {
                i = C5419R.id.dialog_date_picker_input;
                DatePicker datePicker = (DatePicker) view2.findViewById(C5419R.id.dialog_date_picker_input);
                if (datePicker != null) {
                    i = C5419R.id.dialog_date_picker_title;
                    TextView textView = (TextView) view2.findViewById(C5419R.id.dialog_date_picker_title);
                    if (textView != null) {
                        return new C0988k((LinearLayout) view2, materialButton, datePicker, textView);
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
            C0834k c0834k = C0834k.this;
            C12238m.checkNotNullExpressionValue(calendar, "cal");
            c0834k.selectedDate = calendar.getTimeInMillis();
            C0834k c0834k2 = C0834k.this;
            c0834k2.datePicked = true;
            Function1<? super Long, Unit> function1 = c0834k2.onDatePicked;
            if (function1 != null) {
                function1.invoke(Long.valueOf(c0834k2.selectedDate));
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
            C0834k c0834k = C0834k.this;
            if (c0834k.datePicked && (function1 = c0834k.onDatePicked) != null) {
                function1.invoke(Long.valueOf(c0834k.selectedDate));
            }
            C0834k.this.dismiss();
        }
    }

    public C0834k() {
        super(C5419R.layout.dialog_date_picker);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f402j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final C0988k m138g() {
        return (C0988k) this.binding.getValue((Fragment) this, f396j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        m138g().f989c.clearFocus();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        CharSequence charSequence;
        super.onViewBoundOrOnResume();
        TextView textView = m138g().f990d;
        C12238m.checkNotNullExpressionValue(textView, "binding.dialogDatePickerTitle");
        Bundle arguments = getArguments();
        if (arguments == null || (charSequence = arguments.getCharSequence("label")) == null) {
            charSequence = "";
        }
        textView.setText(charSequence);
        DatePicker datePicker = m138g().f989c;
        C12238m.checkNotNullExpressionValue(datePicker, "binding.dialogDatePickerInput");
        Bundle arguments2 = getArguments();
        datePicker.setMaxDate(arguments2 != null ? arguments2.getLong("max_date") : 0L);
        DatePicker datePicker2 = m138g().f989c;
        C12238m.checkNotNullExpressionValue(datePicker2, "binding.dialogDatePickerInput");
        datePicker2.setMinDate(BirthdayHelper.INSTANCE.subtractYearsFromToday(150));
        Bundle arguments3 = getArguments();
        this.selectedDate = arguments3 != null ? arguments3.getLong("initial_date") : 0L;
        if (this.onDatePicked == null) {
            dismiss();
        }
        Calendar calendar = Calendar.getInstance();
        C12238m.checkNotNullExpressionValue(calendar, "calendar");
        calendar.setTimeInMillis(this.selectedDate);
        m138g().f989c.init(calendar.get(1), calendar.get(2), calendar.get(5), new c());
        m138g().f988b.setOnClickListener(new d());
    }
}
