package b.a.a;

import b.a.d.d0;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetAccessibilityDetectionDialogViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p extends d0<p$a> {
    public final StoreUserSettings j;
    public final StoreNotices k;

    public p() {
        this(null, null, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(StoreUserSettings storeUserSettings, StoreNotices storeNotices, int i) {
        super(p$a$a.a);
        StoreUserSettings userSettings = (i & 1) != 0 ? StoreStream.Companion.getUserSettings() : null;
        StoreNotices notices = (i & 2) != 0 ? StoreStream.Companion.getNotices() : null;
        d0.z.d.m.checkNotNullParameter(userSettings, "storeUserSettings");
        d0.z.d.m.checkNotNullParameter(notices, "storeNotices");
        this.j = userSettings;
        this.k = notices;
    }

    @Override // b.a.d.d0, androidx.view.ViewModel
    public void onCleared() {
        StoreNotices storeNotices = this.k;
        Objects.requireNonNull(h.k);
        StoreNotices.markSeen$default(storeNotices, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG", 0L, 2, null);
    }
}
