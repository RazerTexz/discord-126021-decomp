package b.a.a.f.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.discord.R$id;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a$c extends k implements Function1<View, b.a.i.b> {
    public static final a$c j = new a$c();

    public a$c() {
        super(1, b.a.i.b.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public b.a.i.b invoke(View view) {
        View view2 = view;
        m.checkNotNullParameter(view2, "p1");
        int i = R$id.audio_output_selection_bluetooth_radio;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(R$id.audio_output_selection_bluetooth_radio);
        if (materialRadioButton != null) {
            i = R$id.audio_output_selection_dialog_header;
            TextView textView = (TextView) view2.findViewById(R$id.audio_output_selection_dialog_header);
            if (textView != null) {
                i = R$id.audio_output_selection_dialog_radio_group;
                RadioGroup radioGroup = (RadioGroup) view2.findViewById(R$id.audio_output_selection_dialog_radio_group);
                if (radioGroup != null) {
                    i = R$id.audio_output_selection_earpiece_radio;
                    MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(R$id.audio_output_selection_earpiece_radio);
                    if (materialRadioButton2 != null) {
                        i = R$id.audio_output_selection_speaker_radio;
                        MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(R$id.audio_output_selection_speaker_radio);
                        if (materialRadioButton3 != null) {
                            i = R$id.audio_output_selection_wired_radio;
                            MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(R$id.audio_output_selection_wired_radio);
                            if (materialRadioButton4 != null) {
                                return new b.a.i.b((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
