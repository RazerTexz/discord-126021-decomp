package b.a.a;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import com.discord.stores.StoreStream;

/* JADX INFO: compiled from: ImageUploadFailedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$d implements CompoundButton$OnCheckedChangeListener {
    public static final c$d a = new c$d();

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        StoreStream.Companion.getUserSettings().setIsAutoImageCompressionEnabled(z2);
    }
}
