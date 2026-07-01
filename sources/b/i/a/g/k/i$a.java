package b.i.a.g.k;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.timepicker.TimeModel;
import java.util.Objects;

/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$a extends TextWatcherAdapter {
    public final /* synthetic */ i j;

    public i$a(i iVar) {
        this.j = iVar;
    }

    @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        try {
            if (TextUtils.isEmpty(editable)) {
                TimeModel timeModel = this.j.k;
                Objects.requireNonNull(timeModel);
                timeModel.n = 0;
            } else {
                int i = Integer.parseInt(editable.toString());
                TimeModel timeModel2 = this.j.k;
                Objects.requireNonNull(timeModel2);
                timeModel2.n = i % 60;
            }
        } catch (NumberFormatException unused) {
        }
    }
}
