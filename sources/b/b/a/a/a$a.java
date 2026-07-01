package b.b.a.a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.lytefast.flexinput.R$h;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import com.lytefast.flexinput.viewmodel.FlexInputViewModel;
import java.util.Objects;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class a$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public a$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            a aVar = (a) this.k;
            int i2 = a.j;
            if (aVar.isCancelable()) {
                aVar.h(true);
                return;
            }
            return;
        }
        if (i != 1) {
            if (i != 2) {
                throw null;
            }
            FlexInputFragment flexInputFragment = (FlexInputFragment) ((Fragment) this.k);
            FlexInputViewModel flexInputViewModel = flexInputFragment.viewModel;
            if (flexInputViewModel != null) {
                flexInputViewModel.onSendButtonClicked(flexInputFragment.inputListener);
                return;
            }
            return;
        }
        a aVar2 = (a) this.k;
        Objects.requireNonNull(aVar2);
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        try {
            aVar2.startActivityForResult(intent, 5968);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(aVar2.getContext(), aVar2.getString(R$h.error_generic_title), 0).show();
        }
    }
}
