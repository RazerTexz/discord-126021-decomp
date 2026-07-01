package b.a.a;

import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R$id;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DatePickerDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k$b extends d0.z.d.k implements Function1<View, b.a.i.k> {
    public static final k$b j = new k$b();

    public k$b() {
        super(1, b.a.i.k.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/DialogDatePickerBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.k invoke(View view) {
        View view2 = view;
        d0.z.d.m.checkNotNullParameter(view2, "p1");
        int i = R$id.dialog_date_picker_done;
        MaterialButton materialButton = (MaterialButton) view2.findViewById(R$id.dialog_date_picker_done);
        if (materialButton != null) {
            i = R$id.dialog_date_picker_input;
            DatePicker datePicker = (DatePicker) view2.findViewById(R$id.dialog_date_picker_input);
            if (datePicker != null) {
                i = R$id.dialog_date_picker_title;
                TextView textView = (TextView) view2.findViewById(R$id.dialog_date_picker_title);
                if (textView != null) {
                    return new b.a.i.k((LinearLayout) view2, materialButton, datePicker, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
