package b.a.a.f.a;

import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a$d extends o implements Function1<d$a, Unit> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$d(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(d$a d_a) {
        int id2;
        d$a d_a2 = d_a;
        m.checkNotNullParameter(d_a2, "viewState");
        a aVar = this.this$0;
        Objects.requireNonNull(aVar);
        m.checkNotNullParameter(d_a2, "viewState");
        if (!(d_a2 instanceof d$a$b) && (d_a2 instanceof d$a$a)) {
            d$a$a d_a_a = (d$a$a) d_a2;
            int iOrdinal = d_a_a.a.ordinal();
            if (iOrdinal == 2) {
                MaterialRadioButton materialRadioButton = aVar.i().e;
                m.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                id2 = materialRadioButton.getId();
            } else if (iOrdinal == 3) {
                MaterialRadioButton materialRadioButton2 = aVar.i().f;
                m.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                id2 = materialRadioButton2.getId();
            } else if (iOrdinal == 4) {
                MaterialRadioButton materialRadioButton3 = aVar.i().d;
                m.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                id2 = materialRadioButton3.getId();
            } else if (iOrdinal == 5) {
                MaterialRadioButton materialRadioButton4 = aVar.i().f80b;
                m.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                id2 = materialRadioButton4.getId();
            }
            aVar.i().c.check(id2);
            MaterialRadioButton materialRadioButton5 = aVar.i().f80b;
            m.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
            materialRadioButton5.setVisibility(d_a_a.f48b ? 0 : 8);
            MaterialRadioButton materialRadioButton6 = aVar.i().f80b;
            m.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
            String string = d_a_a.c;
            if (string == null) {
                string = aVar.getString(2131886896);
            }
            materialRadioButton6.setText(string);
            MaterialRadioButton materialRadioButton7 = aVar.i().e;
            m.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
            materialRadioButton7.setVisibility(d_a_a.d ? 0 : 8);
            MaterialRadioButton materialRadioButton8 = aVar.i().f;
            m.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
            materialRadioButton8.setVisibility(d_a_a.e ? 0 : 8);
            MaterialRadioButton materialRadioButton9 = aVar.i().d;
            m.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
            materialRadioButton9.setVisibility(d_a_a.f ? 0 : 8);
        }
        return Unit.a;
    }
}
